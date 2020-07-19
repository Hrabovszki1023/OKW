/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
      www.OpenKeyWord.de
    ============================================================================== 

    This file is part of OpenKeyWord.

    OpenKeyWord is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    OpenKeyWord is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

    Diese Datei ist Teil von OpenKeyWord.

    OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
    der GNU General Public License, wie von der Free Software Foundation,
    Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
    veröffentlichten Version, weiterverbreiten und/oder modifizieren.

    OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
    OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
    Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
    Siehe die GNU General Public License für weitere Details.

    Sie sollten eine Kopie der GNU General Public License zusammen mit 
    OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
*/

package okw.gui.adapter.selenium.webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWGUIObjectNotUniqueException;
import okw.log.Logger_Sngltn;

/**
 *  Pattern Singelton
 */
public class SeDriver
{

    // Get the instance of Logger_Sngltn
    protected Logger_Sngltn MyLogger        = Logger_Sngltn.getInstance();

    private WebDriver        driver = null;

    /** 
     * ID des iframes, auf welches aktuell der Driver zeigt.
     * "" ist default Frame
     */
    private String          currentiframeID = "";

    public String getCurrentiframeID()
    {
        return currentiframeID;
    }

    /** 
     *  Singelton-Class: instanz hold the Object-Referenc of CurrentObject
     */
    private static SeDriver instance = new SeDriver();

    private SeDriver()
    {
    }

    /**  \brief
    *  Gibt die Instance für die einzige Instanz dieser Klasse zurück.<br/>
    *  __Hinweis:__
    *  * Diese Klasse ist ein Singelton.
    *    - Higylander Prinzip: Es kann nur eine Instanz von dieser Klasse geben!
    *    - Verwenden Sie diese Eigenschaft um die Instance dieser Klasse zu erhalten.
    *    - Es gibt keinen öffentlichen Konstruktor für Methode!
    *  
    *  <value>
    *  The instance of CurrentObject.
    *  </value>
    *  \author Zoltan Hrabovszki
    *  \date 2012.11.29
    */
    public static SeDriver getInstance()
    {
        return instance;
    }

    public void setDriver( WebDriver fpDriver )
    {
        this.driver = fpDriver;
    }

    public WebDriver getDriver( )
    {
        return this.driver;
    }

    
    public void __DriveChrome()
    {
        this.driver = new ChromeDriver();
    }

    public void __DriveFireFox()
    {
        this.driver = new FirefoxDriver();
    }

    /*public void DriveInternetExplorer()
    {
        this.driver = new InternetExplorerDriver();
    }*/

    public void __DriveUnitDriver()
    {
        try
        {
            this.driver = new HtmlUnitDriver( true );
        }
        catch (Exception e)
        {

            System.out.println( e.getStackTrace() );
        }
    }

    /**
    * \~german
    * Wechselt das aktuelle Frame auf das Frame mit der id=iframeID
    * 
    * Wenn iframe = "", dann wird auf das "defaultContent" gewechselt
    * Sonst wird zunächts auf das defaultContent zurückgesetzt und anschliesend
    * das Frame mit der id=iframeID gewählt.
    * 
    * @param iframeID Eindeutige ID des Frames. Siehe im iframe-tag das Attribute 'id'. 
    * 
    * _Hinweis_ Nachdem setzten des Frame werden alle findElement Ausführungen
    * innerhalb des Frames ausgeführt.
    * @See https://www.seleniumeasy.com/selenium-tutorials/how-to-work-with-iframes-in-selenium-webdriver
    */
    public void swichToFrame( String iframeID )
    {

            // first reset to default
            driver.switchTo().defaultContent();

            // then set to yor iframe if not null or empty!
            if ( !okw.OKW_Helper.isStringNullOrEmpty( iframeID ) )
            {
                try
                {
                    driver.switchTo().frame( iframeID );
                }
                catch (NoSuchFrameException e)
                {
                    System.out.println( "Unable to locate frame with id " + iframeID + e.getStackTrace() );
                }
                catch (Exception e)
                {
                    System.out.println( "Unable to navigate to frame with id " + iframeID + e.getStackTrace() );
                }
            }
    }

    
	/**
	 * \~german Ermittelt die iFrame ID zum gegeben Lokator fpsLocator.
	 *
	 * Methode holt mit getIframesID() alle iframe-s der URL und durchsucht diese
	 * nach dem gegeben Locator fpsLocator.
	 *
	 * \note Einschränkung: Es wird aktuell nicht geprüft, ob ein Locator in
	 * mehrerern iFrame-s zu finden ist. Die Suche wird beendet sobald ein
	 * GUI-Objekt für den Lokator gefunden wurde
	 *
	 * @param fpsLocator Loacator des GUI-Objektes welches gesucht werden soll.
	 * @return Frame ID des iframe´s, in dem sich das Objekt mit dem gegebene
	 *         Locator fpsLocator befindet
	 * 
	 *         \~english
	 *
	 *
	 * @param ?
	 * @return \~
	 * @author Zoltán Hrabovszki
	 * @throws Exception
	 * @date 2019-02-23
	 */
	public WebElement getWebElement( String fpsLocator ) {

		// Variables:
		WebElement myWebElement = null;

		// Liste der Frame-ID´s ermitteln, die sich im aktuellen Fenster befinden
		ArrayList<String> iframeIDs = new ArrayList<String>();

		ArrayList<WebElement> WebElements = new ArrayList<WebElement>();

		// Action:
		try {

			MyLogger.LogFunctionStartDebug("SeDriver.getWebElement", "fpsLocator", fpsLocator);

			// iframeIDs.add( currentiframeID ); FIXME: Wozu? Denke kann weg
			iframeIDs.addAll(getIframesID());

			MyLogger.LogPrintDebug("Number of iFrames found: " + ((Integer) iframeIDs.size()).toString());

			// Alle iframes (ID) jeweils nach Webelementen durchsuchen. die zum gegebene
			// Lokator fpsLocator passen.
			for (String iframeID : iframeIDs) {
				try
				{   // Note: Wenn mehr als ein WenEement gefunden wird, dann löst das hier schon eine ausnahme aus
					myWebElement = this.getWebElement(iframeID, fpsLocator);

					if (myWebElement != null) {
						WebElements.add(myWebElement);
						this.currentiframeID = iframeID;
						continue;
					}
				} catch (OKWGUIObjectNotFoundException e) {
					// OKWGUIObjectNotFoundException abfangen und im nächsten iFrame locator-Match
					// suchen...
					// Alle anderen Exception Durchlassen
					// Die Exception OKWGUIObjectNotFoundException wird nachder Schleife unten
					// ausgelöst
					// wenn keiner der iFrames ein Objekt passend zum Locator fpsLocator enthält.
					continue;
				}
			}

			// Error handling...
			if (WebElements.size() == 0)
			{   // Wenn in keinem der Frames ein Webelement zum gegebenem Locator gefunden wurde,
			    // dann die Ausnamhe OKWGUIObjectNotFoundException auslösen.
				throw new OKWGUIObjectNotFoundException(
						"GUI object was not found. Locator: \"" + fpsLocator + "\"");
			}
			else if (WebElements.size() > 1)
			{   // Wenn in mehr als einem Frame Webelemente zum gegebenem Locator
				// gefunden wurden, dann OKWGUIObjectNotFoundException auslösen.
				throw new OKWGUIObjectNotUniqueException(
						"Object was not uniquely found. Several objects match the locator: \"" + fpsLocator + "\"");
			}
			else
			{
				// Wenn genua ein elemnt gefunden wird wird der Contxt auf das iFrame 
				// gesetzt in dem sich das Objekt befindet.
				this.swichToFrame(this.currentiframeID);
			}
			
		}
		finally
		{
			// edal wie LogFunction Level schließen...
			MyLogger.LogFunctionEndDebug();
		}
		return WebElements.get(0);
	}
    
//    /**
//     * \~german
//     * Ermittelt die iFrame ID zum gegeben Lokator fpsLocator.
//     *
//     * Methode holt mit getIframesID() alle iframe-s der URL und durchsucht diese nach dem gegeben Locator fpsLocator.
//     *
//     * \note Es wird aktuell nicht geprüft, ob ein Locator in mehrerern iFrame-s zu finden ist.
//     * Die Suche wird beendet sobald ein GUI-Objekt für den Lokator gefunden wurde
//     *
//     * @param fpsLocator Loacator des GUI-Objektes welches gesucht werden soll.
//     * @return Frame ID des iframe´s, in dem sich das Objekt mit dem gegebene Locator fpsLocator befindet
//     * 
//     * \~english
//     *
//     *
//     * @param ? 
//     * @return
//     * \~
//     * @author Zoltán Hrabovszki
//     * @throws Exception 
//     * @date 2019-02-23
//     */
//    public String getFrameID4Locator_old( String fpsLocator )
//    {
//        String return_iFrame = null;
//        WebElement myWebElement = null;
//        
//        // Merkt sich die "gefundenen" Ausnahme in der Schleife
//        // und löst diesen ggf. nach der schleife aus.
//        Exception ExceptionFound = null;
//
//        MyLogger.LogFunctionStartDebug( "SeDriver.getFrameID4Locator", "fpsLocator", fpsLocator );
//        
//        // Liste der Frame-ID´s ermitteln, die sich im aktuellen Fenster befinden
//        ArrayList<String> iframeIDs = new ArrayList<String>();
//
//        iframeIDs.add( currentiframeID );
//        iframeIDs.addAll( getIframesID() );
//
//        MyLogger.LogPrintDebug( "Number of iFrames found: " + ((Integer)iframeIDs.size()).toString() );
//        
//        // iframes(ID) jeweils nach dem GUI-Objekt durchsuchen.
//        for ( String iframeID : iframeIDs )
//        {
//            try
//            {
//                myWebElement = this.getElement( iframeID, fpsLocator );
//
//                if ( myWebElement != null )
//                {
//                    return_iFrame = currentiframeID;
//                    break;
//                }
//            }
//            catch ( OKWGUIObjectNotFoundException e )
//            {
//                ExceptionFound = e;
//                continue;
//            }
//            catch ( OKWGUIObjectNotUniqueException e )
//            {   // Hier wird z.B. abgefangen wenn zwei Locatoren
//                ExceptionFound = e;
//                break;
//            }            
//            catch ( Exception e )
//            {   // Other exceptions...
//                
//                ExceptionFound = e;
//                break;
//            }            
//        }
//
//        if ( ExceptionFound instanceof OKWGUIObjectNotFoundException )
//        {
//            MyLogger.LogPrintDebug( "Object not found." );
//            MyLogger.LogFunctionEndDebug( );
//            throw new OKWGUIObjectNotFoundException( ExceptionFound.getMessage() );
//        }
//        else if ( ExceptionFound instanceof OKWGUIObjectNotUniqueException )
//        {
//            MyLogger.LogPrintDebug( "More than one Object found." );
//            MyLogger.LogFunctionEndDebug( );
//            throw new OKWGUIObjectNotUniqueException( ExceptionFound.getMessage() );
//        }
//        else if ( ExceptionFound != null )
//        {
//            MyLogger.LogPrintDebug( "Unknown Exception." );
//            MyLogger.LogFunctionEndDebug( );
//            throw new RuntimeException( ExceptionFound );
//        }
//        else
//        {
//            MyLogger.LogFunctionEndDebug( "iFrame: '" + return_iFrame + "'");            
//        }        
//        return return_iFrame;
//    }

	/**
     * \~german
     * Ermittelt <b>alle</b> iFrames im aktuellen HTML und erstellt eine liste der iFrame-ID´s.
     * 
     * @return Liste aller gefundenen iFrame-ID´s.
     * 
     * \~english
     * Returns <b>all</b> iFrames in the current HTML and creates a list of the iFrameID´s.
     * 
     * @return List of found iFrame-ID´s for identification.
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-02-23
     */
    protected ArrayList<String> getIframesID( )
    {
        
        ArrayList<String> lvReturn = new ArrayList<String>();
        lvReturn.add(""); // Default iframe
        
        MyLogger.LogFunctionStartDebug( "SeDriver.getIframesID");

        //f
        this.swichToFrame(""); // TODO ZH tem eingabut
        List<WebElement> iframes = this.driver.findElements(By.tagName("iframe"));
        
        MyLogger.ResOpenListDebug( "iFrames..." );
        
        for (WebElement iframe : iframes)
        {
            String myID = iframe.getAttribute("id");
            
            if ( ! okw.OKW_Helper.isStringNullOrEmpty( myID ) )
            {
                lvReturn.add( myID );
                MyLogger.LogPrintDebug( "ID='" + myID + "'" );
            }
            else
            {
                myID = iframe.getAttribute("name");
                
                if ( ! okw.OKW_Helper.isStringNullOrEmpty( myID ) )
                {
                    lvReturn.add( myID );
                    MyLogger.LogPrintDebug( "name='" + myID + "'" );
                }
                else
                {
                    MyLogger.LogWarning( "iFrame has neither ID nor Name:" + iframe.toString() );
                }
            }
        }

        MyLogger.ResCloseListDebug( );
        MyLogger.LogFunctionEndDebug( lvReturn );
        
        return lvReturn;
    }
    
    /** \~german
     *  Ermittelt ein WebElement zu der gegebenen frameID und Locator.
     *  
     *  @param fpsFrameID Frame-ID des Frames, in dem nach dem GUI-Objekt mit dem Lokator fpsLocator gesucht werden soll.
     *  @param fpsLocator Lokator des GUI-Objektes. Siehe auch Parameter fpsFrameID
     *  
     *  @return Liefert das WebElemnt
     *  
     *  @exception OKWGUIObjectNotFoundException Wenn kein GUI-Objekt gefunden wird.
     *  
     *  @exception OKWGUIObjectNotUniqueException Wenn mehrere GUI-Objekte gefunden werden,
     *             d.h wenn der Locator kein eindeutiges Ergebnis, d.h. genau ein GUI-Objekt, liefert.
     *  
     *  \~english
     *  todo TODO: Brief Description.
     *  
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2015.05.12
     */
    protected WebElement getWebElement( String fpsFrameID, String fpsLocator )
    {
        WebElement webElement = null;
        List<WebElement> webElements = null;

        try
        {
            this.MyLogger.LogFunctionStartDebug( "SeDriver.getWebElement", "fpsFrameID", fpsFrameID, "fpsLocator", fpsLocator );

            // 1. ggf Auf das richtige frame Setzen oder zurück auf default. 
            this.swichToFrame( fpsFrameID );

            // Element ggf. des richtigen Frames Holen.
            webElements = this.driver.findElements( By.xpath( fpsLocator ) );

            if ( webElements.size() == 0 )
            {
                String lvsPrintMe = "GUI object was not found. Locator: \"" + fpsLocator + "\"";
                this.MyLogger.LogPrintDebug( lvsPrintMe );

                throw new OKWGUIObjectNotFoundException( lvsPrintMe );
            }
            else if ( webElements.size() > 1 )
            {
                String lvsPrintMe = "Object was not uniquely found. Several objects match the locator: \"" + fpsLocator + "\"";
                
                this.MyLogger.LogWarning( lvsPrintMe );

                throw new OKWGUIObjectNotUniqueException( lvsPrintMe );
            }
            else
            {
                String lvsPrintMe = "GUI object was found. iframe: '" + fpsFrameID + "' Locator: '" + fpsLocator + "'";
                this.MyLogger.LogPrintDebug( lvsPrintMe );
                webElement = webElements.get( 0 );
            }
        }
        finally
        {
            // Logfunction schliessen...
            if (webElement != null)
               this.MyLogger.LogFunctionEndDebug( webElement.toString() );
            else
                this.MyLogger.LogFunctionEndDebug( );       
        }
        
        return webElement;
    }

    /** \~german
     *  Ermittelt alle WebElemente, die in fpsFrameID mit dem Locator fpsLocator gefunden werden.
     *  
     *  
     *  \~english
     *  Returns all WebElements found in fpsFrameID with the locator fpsLocator
     *  
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.05.12
     */
    protected List<WebElement> __getWebElements( String fpsFrameID, String fpsLocator )
    {
        List<WebElement> WebElements = null;
        
        try
        {
        	this.MyLogger.LogFunctionStartDebug( "SeDriver.getElement", "fpsFrameID", fpsFrameID, "fpsLocator", fpsLocator );

        	// 1. Auf das richtige frame Setzen oder zurück auf default. 
            this.swichToFrame( fpsFrameID );

            // 2. Element im Frame finden.
            WebElements = this.driver.findElements( By.xpath( fpsLocator ) );
        }
        finally
        {
            this.MyLogger.LogFunctionEndDebug(); ;    
        }
        return WebElements;
    }

    /*
    /** \~german
     *  Erzeugt eine Instanz des HTMLnitDrivers
     *  
     *  Wetergehende Dokumentaion sind hier zu finden: http://docs.seleniumhq.org/docs/03_webdriver.jsp#htmlunit-driver
     *  
     *  \~english
     *  \todo TODO: Brief Description.
     *  
     *  \todo TODO: Detailed Description
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2015.05.12
     * /
    public void DriveRemote()
    {
        
        var remoteServer = new Uri("http://localhost:4444/wd/hub/");
        var  desiredCapabilities = DesiredCapabilities.HtmlUnit();
    	//var  desiredCapabilities = DesiredCapabilities.HtmlUnitWithJavaScript()
    	desiredCapabilities.IsJavaScriptEnabled = true;
    
    	this.driver= new RemoteWebDriver(remoteServer, desiredCapabilities);
        this.driver.Manage().Timeouts().ImplicitlyWait(new TimeSpan(0, 0, 30));
        //this.driver = new RemoteWebDriver(true);
    }*/
}
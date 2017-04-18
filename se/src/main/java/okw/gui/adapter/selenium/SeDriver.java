/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

package okw.gui.adapter.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.log.Logger_Sngltn;

     /**  \brief
     *  Pattern Singelton
     */  
    public class SeDriver
    {

      // Get the instance of Logger_Sngltn
      protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();
      
        public WebDriver driver;
        
        String currentIframeID = "";

        /** \brief
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


        public void DriveChrome()
        {
            this.driver = new ChromeDriver();
        }

        
        public void DriveFireFox()
        {
            this.driver = new FirefoxDriver();
        }


        /*public void DriveInternetExplorer()
        {
            this.driver = new InternetExplorerDriver();
        }*/

        
        public void DriveUnitDriver()
        {
          try
          {
            this.driver = new HtmlUnitDriver(true);
          }
          catch (Exception e)
          {
            
            System.out.println( e.getStackTrace() );
          }

            return;
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

    // Nur etwas Unternehmen wenn iframeID sich geändert hat
    if ( !currentIframeID.equalsIgnoreCase( iframeID ) )
    {
      // first reset to default
      driver.switchTo().defaultContent();

      // then set to yor ifframe if not null or empty!
      if ( !okw.OKW_Helper.StringIsNullOrEmpty( iframeID ) )
      {
        try
        {
          driver.switchTo().frame( iframeID );

          // Neuenwert merken wenn Fehlerfrei ge-Switchto wurde... 
          currentIframeID = iframeID;

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
    return;
  }
        
        
        /** \~german
         *  Ermittelt das Webelement mit der gegebenen frameID und dem gegebenen Locator
         *  
         *  
         *  \~english
         *  \todo TODO: Brief Description.
         *  
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2015.05.12
         */        
        public WebElement getElement( String frameID, String Locator )
        {
          WebElement me = null;
          List<WebElement> meme = null;
          
          // 1. ggf Auf das richtige frame Setzen oder zurück auf default. 
          this.swichToFrame( frameID );
          
          // Element ggf. des richtigen Frames Holen.
          meme = this.driver.findElements(By.xpath(Locator));
          
          if (meme.size() == 0)
          {
              String lvsPrintMe = "GUI-Objekt wurde nicht gefunden: Locator: >>" + Locator + "<<";
              
              this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );
              this.MyLogger.LogPrint( lvsPrintMe );
              this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );

              throw new OKWGUIObjectNotFoundException( lvsPrintMe );
          }
          else if (meme.size() > 1)
          {
              String lvsPrintMe = "Locator ist nicht eindeutig, es wurden mehrer GUI-Objekt gefunden:\n Locator: >>" + Locator + "<<";
              
              this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );
              this.MyLogger.LogPrint( lvsPrintMe );
              this.MyLogger.LogPrint( "????????????????????????????????????????????????????????????" );

              throw new OKWGUIObjectNotFoundException( lvsPrintMe );
          }
          else
          {
              me = meme.get(0);
          } 
          return me;
        }
        
        
        /** \~german
         *  Ermittelt das Webelement mit der gegebenen frameID und dem gegebenen Locator
         *  
         *  
         *  \~english
         *  \todo TODO: Brief Description.
         *  
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2015.05.12
         */        
        public List<WebElement> getElements( String frameID, String fpsLocator )
        {
          List<WebElement> meme = null;
          
          // 1. ggf Auf das richtige frame Setzen oder zurück auf default. 
          this.swichToFrame( frameID );
          
          // Element ggf. des richtigen Frames Holen.
          meme = this.driver.findElements(By.xpath(fpsLocator));
                    
          return meme;
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
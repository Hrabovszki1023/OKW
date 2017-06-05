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

import java.util.*;

import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.*;
import okw.log.Logger_Sngltn;
import okw.LogMessenger;
import okw.OKW_Const_Sngltn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * \~
 * @defgroup groupSeleniumWindowGUIAdapter Selenium Kindobjekt GUI-Adapter klasse
 * @ingroup groupSeleniumClasses
 *
 * @ingroup groupSeleniumWindowGUIAdapter
 * \~german
 * SeAnyWindow ist eine GUI-Adapterklasse.
 * 
 *  \~english
 *  \~
 *  @author Zoltán Hrabovszki
 *  @date 2017-06-05
 */
public class SeAnyWindow extends AnyWindow
{	
    // Logger Instance holen
    protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();
    
    protected LogMessenger LM = new LogMessenger("GUI");
    
    // If null then use "default" else switchTo "iframeID" 
    protected String iframeID = "";
    
    public String getIframeID()
    {
      return iframeID;
    }

    public void setIframeID( String iframeID )
    {
      this.iframeID = iframeID;
    }

    
    public SeAnyWindow(String Locator, OKWLocator... Locators)
    {
    	super(Locator, Locators);
      this.iframeID = "";
    }

    /** 
     * \~german
     * Konstruktor der Klasse. iframeID wird auf den Wert "" (empty string) gesetzt.
    *  
    *  @param Locator definiert die Objekterkennungseigenschaft des Objektes. Dieser wird als XPATH angegeben
    *  @param Locators Locatoren z.B. von Elternobjekten, die zu einem gesamt Locator verkettet werden sollen.
    *  
    *  \~english
    *  
    *  \~
    *  @author Zoltán Hrabovszki
    *  @date 2013.05.03
    */
    public SeAnyWindow(String IframeID, String Locator, OKWLocator... Locators)
    {
      super(Locator, Locators);
      this.iframeID = IframeID;
    }

    /** \~german
     *  Klickt auf das aktuelle Objekt.
     *  
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2013.11.11
     */
    public void ClickOn()
    {
        try
        {
            this.LogFunctionStartDebug("ClickOn");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.ClickOn()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            this.Me().click();
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    
    /** \~german
	 *  \brief
	 *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
	 *   
	 *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.12.07
	 */
	public ArrayList<String> getCaption()
	{
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	    try
	    {
	        MyLogger.LogFunctionStartDebug("GetCaption");
	
	        // Wenn das Objekt nicht existiert mit Exception beenden...
	        if (!this.getExists())
	        {
	            String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetCaption()");
	            throw new OKWGUIObjectNotFoundException(lvsLM);
	        }
	        
	        // The Attribute "value" wird als Beschriftung angezeigt...
	        lvLsReturn.add(this.Me().getAttribute("textContent"));
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	    
	    return lvLsReturn;
	}


	  /** \~german
     *  Prüft die Existenz des aktuellen Objektes.
     *  
     *  - Methode ist Selenium spezifisch.
     *  - Elementare Funktion, muss hier defiert werden.
     *  - Es wird nicht auf das Objekt gewarten!
     *  - Es wird nur ein eizigesmal die Existenz geprüft.
     *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist.
     *  - Wenn Das Objekt nicht eindeitig ist wird false Zurückgeliefert.
     *  
     *  @return true, falls das Objekt eindeutig gefunden worden ist ist, sonst false.
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2017.01.31
     */
    public Boolean getExists()
    {
        this.MyLogger.LogFunctionStartDebug("getExists");
        Boolean lvbReturn = false;
        String myLocator = null;
        
        List<WebElement> meme = null;

        try
        {
           myLocator = this.getLocator();
        
           //meme = SeDriver.getInstance().driver.findElements(By.xpath(myLocator));
           meme = SeDriver.getInstance().getElements( null, myLocator );
        
           if (meme.size() == 0)
           {
              lvbReturn = false;
           }
           else if (meme.size() > 1)
           {
              String lvsPrintMe = "Locator ist nicht eindeutig, es wurden mehrer GUI-Objekt gefunden:\n Locator: >>" + this.getLocator() + "<<";
              this.MyLogger.LogWarning( lvsPrintMe );

              lvbReturn = false;
           }
           else
           {
              lvbReturn = true;
           }
        }
        catch (OKWGUIObjectNotFoundException e)
        {
           this.MyLogger.LogPrintDebug("NoSuchElementException");
           lvbReturn = false;
        }
        finally
        {
           this.MyLogger.LogFunctionEndDebug(lvbReturn);
        }
        return lvbReturn;
    }

    
  /** \~german
	* \brief
	*  Methode liefert den aktuellen Zustand Wert des Focus.
	*  Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
	* 
	*  \return
	*  \~
	*  @author Zoltán Hrabovszki
	*  @date 2013.11.11
	*/
	public Boolean getHasFocus()
	{
	    Boolean lvbReturn = false;
	    Boolean bOK = false;
	
	    try
	    {
	        this.LogFunctionStartDebug("getHasFocus");
	
	        // Wenn das Objekt nicht existiert mit Exception beenden...
	        if (!this.getExists())
	        {
	            String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "getHasFocus()");
	            throw new OKWGUIObjectNotFoundException(lvsLM);
	        }
	
	        WebElement currentElement = SeDriver.getInstance().driver.switchTo().activeElement();
	
	        lvbReturn = currentElement.equals(this.Me());
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvbReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvbReturn;
	}


	/// \~german
    /// \brief
    /// Ermittelt, ob das aktuellen Objekt aktiv ist.
    /// 
    /// \returntrue, falls das Objekt aktive ist, sonst false\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.19
    public Boolean getIsActive()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;
        String lvDisabled = null;

        try
        {
            this.MyLogger.LogFunctionStartDebug("getIsActive");

            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.GetIsActive()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }

            lvDisabled = this.Me().getAttribute("disabled");

            if (lvDisabled != null)
            {
            	if (lvDisabled.equals("true")) lvbReturn = false;
            }
            else
            {
                lvbReturn = true;
            }

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
	/// \brief
	/// Ermittelt den textuellen Inhalt des Labels.
	/// 
	/// \return
	/// Rückgabe des Textuellen Inhaltes der Labels.
	/// \return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2014.06.17
	public ArrayList<String> getLabel() throws Exception
	{
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	    try
	    {
	        MyLogger.LogFunctionStartDebug("GetLabel");
	
	        // Wenn das Objekt nicht existiert mit Exception beenden...
	        if (!this.getExists())
	        {
	            String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetLabel()");
	            throw new OKWGUIObjectNotFoundException(lvsLM);
	        }
	        
	        // 1. Schritt: Attribute "id" is shown as Tooltip...
	        String lvsID = this.Me().getAttribute("id");
	        
	        // 2.schritt nun Tag Label mit for= "${lvsID}" finden.
	        WebElement label = SeDriver.getInstance().driver.findElement(By.xpath( "//label[@for='" + lvsID + "']" ));
	        lvLsReturn.add(label.getAttribute("textContent"));
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	    
	    return lvLsReturn;
	}


	/// \~german
	/// \brief
	/// Ermittelt den textuellen Inhalt des ToolTips.
	/// 
	/// \return
	/// Rückgabe des Textuellen Inhaltes der Tooltips.
	/// \return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.12.07
	public ArrayList<String> getTooltip() throws Exception
	{
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	    try
	    {
	        MyLogger.LogFunctionStartDebug("GetTooltip");
	
	        // Wenn das Objekt nicht existiert mit Exception beenden...
	        if (!this.getExists())
	        {
	            String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetTooltip()");
	            throw new OKWGUIObjectNotFoundException(lvsLM);
	        }
	        
	        // The Attribute "Title" is shown as Tooltip...
	        lvLsReturn.add(this.Me().getAttribute("title"));
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	    
	    return lvLsReturn;
	}


	/**
	 *  Liest den aktuellen Wert/Text aus dem HTML-Tag.
	 * 
	 *  Standardmäßig wird "textContent" ausgelesen.
	 *
	 *  @return
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.12.14
	 */
	public ArrayList<String> getValue() throws Exception
	{
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	
	    try
	    {
	        this.LogFunctionStartDebug("getValue");
	
          // Wenn das Objekt nicht existiert mit Exception beenden...
          if (!this.getExists())
          {
              String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetTooltip()");
              throw new OKWGUIObjectNotFoundException(lvsLM);
          }

          // Get Value from TextField and put this into the return ArrayList<String>
	        lvLsReturn.add(this.Me().getAttribute("textContent"));
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            this.LogFunctionEndDebug(lvLsReturn.toString());
	        }
	        else
	        {
	            this.LogFunctionEndDebug();
	        }
	    }
	    return lvLsReturn;
	}


	/** \~german
   *  Ermittelt den textuellen Inhalt der Beschriftung (Caption).
   *  
   *  Diese Methode ist der Einstiegspunkt für LogCaption-Anpassungen durch Methoden überschreibung.
   *  
   *  \return Rückgabe des Tooltiptextes.
   *  Interface schreibt ein Listen-Element als Rückgabewert vor.
   *  \~english
   *  \~
   *  @author Zoltán Hrabovszki
   *  @date 2013.12.07
   */
  public ArrayList<String> LogCaption() throws Exception
  {
      ArrayList<String> lvLsReturn = new ArrayList<String>();
      Boolean bOK = false;
  
      try
      {
          MyLogger.LogFunctionStartDebug("LogCaption");
  
          lvLsReturn = this.getCaption();
  
          bOK = true;
      }
      finally
      {
          if (bOK)
          {
              MyLogger.LogFunctionEndDebug(lvLsReturn);
          }
          else
          {
              MyLogger.LogFunctionEndDebug();
          }
      }
  
      return lvLsReturn;
  }


    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean LogExists()
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("LogExists");

            lvbReturn = this.getExists();

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \brief
    /// Ermittelt für LoggeWert, ob das aktuelle Objekt den Fokus hat.
    /// 
    /// Diese Methode ist der Einstiegspunkt für Loggewert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// true falls Objekt den Fokus hat, sonst false
    /// \return
    /// \author Zoltan Hrabovszki
    /// \date 2013.04.11
    public Boolean LogHasFocus() throws Exception
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;
    
        try
        {
            this.LogFunctionStartDebug("LogHasFocus");
    
            lvbReturn = this.getHasFocus();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }
    
        return lvbReturn;
    }


    /// \~german
    /// \brief
    /// Ermittelt, ob das aktuelle Objket Aktiv ist.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean LogIsActive() throws Exception
    {
        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug("LogIsActive");
            lvbReturn = this.getIsActive();
        }
        finally
        {
            this.LogFunctionEndDebug(lvbReturn);
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Logt den textuellen Inhalt des Labels eines Objektes.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> LogLabel() throws Exception
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;
    
        try
        {
            MyLogger.LogFunctionStartDebug("LogLabel");
    
            lvLsReturn = this.getLabel();
    
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }
    
        return lvLsReturn;
    }


    /// \~german
    /// \brief
    /// Logt den textuellen Inhalt des ToolTips.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> LogTooltip() throws Exception
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
    
        try
        {
            this.LogFunctionStartDebug("LogTooltip");
    
            lvLsReturn = this.getTooltip();
        }
        finally
        {
            this.LogFunctionEndDebug(lvLsReturn);
        }
    
        return lvLsReturn;
    }


    /**
      *  Ermittelt den Wert des Objktes für das Schlüsselwort Loggewert.
    
      *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen
      *  durch Methoden überschreibung.
      *  
      *  @return Rückgabe des Textuellen Inhaltes der markierten Textes.
      *  @author Zoltan Hrabovszki
      *  @date 2013.12.14
      * @throws Exception 
      */
    public ArrayList<String> LogValue() throws Exception
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
    
        try
        {
            this.LogFunctionStartDebug("LogValue");
            lvLsReturn = this.getValue();
        }
        finally
        {
                this.LogFunctionEndDebug(lvLsReturn);
        }
    
        return lvLsReturn;
    }


    /** \~german
     *  Ermittelt aus dem gegebenen Locator das DOM-Elelement, welches das Objekt representiert.
     *  
     *  \return Refernz auf das gefunde DOM-Element
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2013.11.11
     */
    public WebElement Me()
    {
      WebElement me = null;

      me = SeDriver.getInstance().getElement( getIframeID(), this.getLocator() );
          
      return me;
    }
    
    
    
    /// \~german
    /// \brief
    /// Ermittelt ob das Atuelle Objekt existiert, für das Schlüsselwort MerkeVorhanden.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeExist-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean MemorizeExists()
    {
        Boolean bOK = false;
        Boolean lvbReturn = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("MemorizeExists");

            lvbReturn = this.getExists();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt für das Schlüsselwort MerkeIstAktive, ob das aktuelle Objekt aktiv ist.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeIstAktive-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return true, falls das aktuelle Objekt aktiv ist, sonst false/// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.04.19
    public Boolean MemorizeIsActive() throws Exception
    {
        Boolean bOK = false;
        Boolean lvbReturn = false;

        try
        {
            this.MyLogger.LogFunctionStartDebug("MemorizeIsActive");

            lvbReturn = this.getIsActive();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /// \~german
    /// \brief
    /// Prüft die nicht Existenz des aktuellen Objektes.
    /// __Anmerkung:__ Falls ein Objekt zunächst noch vorhand ist und dann aber verschwindet,
    /// dann es sinnvoll sein eine gewisse Zeit(Timeout) zu prüfen, ob das Objekt existiert,
    /// Erst wenn diese Zeit verstrichen ist, wird gemeldet, das das Objekt nicht vorhanden ist.
    /// Diese Funktion ist der gegenspieler zu __Exists.
    /// 
    /// \returntrue, falls das Objekt NICHT vorhanden ist. Sonst false\return
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public Boolean NotExists() throws Exception
    {
        this.MyLogger.LogFunctionStartDebug("NotExists");
        Boolean lvb_Return = false;
        Boolean bOK = false;

        try
        {
            this.Me();
            lvb_Return = true;
            bOK = true;
        }
        catch (NoSuchElementException e)
        {
            this.MyLogger.LogPrint("NoSuchElementException");
            lvb_Return = true;
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                this.MyLogger.LogFunctionEndDebug(lvb_Return);
            }
            else
            {
                this.MyLogger.LogFunctionEndDebug();
            }
        }

        return lvb_Return;
    }

    /// \~german
    /// \brief
    /// Setzt den Focus auf das Objekt.
    /// __Anmerkung:__ Kleiner Trick: Selenium kennt keine öffentliche c#-Methode
    /// für das setzen des Fokus. So weit ich es verstanden habe, wird intern jedoch
    /// methode SetFocus verwendt, wenn <tt>SendKeys</tt> aufgerufen wird.
    /// Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
    /// 
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.11.11
    public void SetFocus() throws Exception
    {
        this.LogFunctionStartDebug("SetFocus");

        try
        {
            // Wenn das Objekt nicht existiert mit Exception beenden...
            if (!this.getExists())
            {
                String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SetFocus()");
                throw new OKWGUIObjectNotFoundException(lvsLM);
            }
            
            this.Me().sendKeys("");
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    
    // \~german
    // \brief
    // Muss in den Menü-Objekten Implementiert werden!
    // Daher wird hier ein OKWFrameObjectMethodNotImplemented ausgelöst!
    //
    // \return
    // \~english
    // \brief
    // A SeInputButton has no value! -> Trigger
    // OKWFrameObjectMethodNotImplemented!
    // \~
    // \author Zoltán Hrabovszki
    // \date 2016.10.06
    public void SelectMenu_Value(ArrayList<String> Values)
    {
      // ArrayList<String> lvLsReturn = new ArrayList<String>();
      try
      {
        MyLogger.LogFunctionStartDebug( "SelectMenu_Value" );

        String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu_Value()" );
        throw new OKWFrameObjectMethodNotImplemented( lvsLM );
      }
      finally
      {
        MyLogger.LogFunctionEndDebug();
      }
    }

    
    // \~
    // \author Zoltán Hrabovszki
    // \date 2016.10.06
    public void Select(ArrayList<String> Values)  throws Exception
    {
      // ArrayList<String> lvLsReturn = new ArrayList<String>();
      try
      {
        MyLogger.LogFunctionStartDebug( "Select" );

        String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "Select( ArrayList<String> )" );
        throw new OKWFrameObjectMethodNotImplemented( lvsLM );
      }
      finally
      {
        MyLogger.LogFunctionEndDebug();
      }
    }    

    
    // \~german
      // \brief
      // Muss in den Menü-Objekten Implementiert werden!
      // Daher wird hier ein OKWFrameObjectMethodNotImplemented ausgelöst!
      //
      // \return
      // \~english
      // \brief
      // A SeInputButton has no value! -> Trigger
      // OKWFrameObjectMethodNotImplemented!
      // \~
      // \author Zoltán Hrabovszki
      // \date 2016.10.06
      public void SelectMenu()
      {
        // ArrayList<String> lvLsReturn = new ArrayList<String>();
        try
        {
          MyLogger.LogFunctionStartDebug( "SelectMenu" );

          String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu()" );
          throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
          MyLogger.LogFunctionEndDebug();
        }
      }

      
    // \~german
    // \brief
    // \return
    // \~english
    // \brief
    // \~
    // \author Zoltán Hrabovszki
    // \date 2016.10.06
    public void SetValue( ArrayList<String> Values ) throws XPathExpressionException, Exception
    {
      // ArrayList<String> lvLsReturn = new ArrayList<String>();
      try
      {
        MyLogger.LogFunctionStartDebug( "SetValue" );

        String lvsLM = this.LM.GetMessage( "Common", "OKWGUIObjectNotFoundException", "SetValue()" );
        throw new OKWFrameObjectMethodNotImplemented( lvsLM );
      }
      finally
      {
        MyLogger.LogFunctionEndDebug();
      }
    }
    
    
    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des ToolTips für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> MemorizeTooltip() throws Exception
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = null;

        try
        {
            MyLogger.LogFunctionStartDebug("MemorizeTooltip");

            lvLsReturn = this.getTooltip();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt den textuellen Inhalt des Labels für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der Tooltips.
    /// Interface schreibt ein Listen-Element als Rückgabewert vor.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public ArrayList<String> MemorizeLabel() throws Exception
    {
        Boolean bOK = false;
        ArrayList<String> lvLsReturn = null;

        try
        {
            MyLogger.LogFunctionStartDebug("MemorizeLabel");

            lvLsReturn = this.getLabel();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
    /// \brief
    /// Ermittelt ob das Objekt den Fokus besitz und liefert diesen für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    ///  true falls Objekt den Fokus hat, sonst false
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.07
    public Boolean MemorizeHasFocus() throws Exception
    {
        Boolean lvbReturn = false;
        Boolean bOK = false;

        try
        {
            this.LogFunctionStartDebug("MemorizeHasFocus");

            lvbReturn = this.getHasFocus();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvbReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /** \~german
     *  Ermittelt den textuellen Inhalt des Caption/Überschrift für das Schlüsselwort MerkeWert.
     *  
     *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
     *  
     *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
     *  Interface schreibt ein Listen-Element als Rückgabewert vor.
     *  
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2013.12.07
     */
    public ArrayList<String> MemorizeCaption() throws Exception
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug("MemorizeCaption");

            lvLsReturn = this.getCaption();
        }
        finally
        {
            this.LogFunctionEndDebug(lvLsReturn);
        }

        return lvLsReturn;
    }
    
    /// \~german
    /// \brief
    /// Ermittelt den Wert, im Allgemeinen den textuellen Inhalt eines Objektes
    /// für das Schlüsselwort MerkeWert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes des aktuellen Objektes.
    /// \return
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.14
    public ArrayList<String> MemorizeValue() throws Exception
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("Memorize");
            lvLsReturn = this.getValue();
            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

    /// \~german
	/// \brief
	/// Tastatur Eingabe an das Objekt
	/// 
	/// \param fps_Values'>
	/// Werte, die via Tastatur eingegeben werden sollen.
	/// 
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.04.11
	public void TypeKey(ArrayList<String> fps_Values) throws Exception
	{
	    try
	    {
	        this.LogFunctionStartDebug("TypeKey", "fps_Values", fps_Values.toString());
	
	        // Wenn das Objekt nicht existiert mit Exception beenden...
	        if (!this.getExists())
	        {
	            String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "SeAnyWin.TypeKey()");
	            throw new OKWGUIObjectNotFoundException(lvsLM);
	        }
	
	        // We are using a local-Variable to prevent multiple call of Me() in foreach-loop
	        WebElement lv_WebElement = this.Me();
	
	        // Loop through all List-Values with foreach...
	        for (String Value : fps_Values)
	        {
	          Logger_Sngltn.getInstance().LogPrintDebug(">>" + Value + "<<");
	          
	          if (Value.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ))
	          {
	            lv_WebElement.clear();
	          }
	          else
	          {
	            lv_WebElement.sendKeys( Value );
	          }
	        }
	    }
	    finally
	    {
	        this.LogFunctionEndDebug();
	    }
	}


	/// \~german
	/// \brief
	/// Ermittelt den textuellen Inhalt des ToolTips für Prüfewert.
	/// 
	/// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	/// 
	/// \return
	/// Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
	/// Interface schreibt ein Listen-Element als Rückgabewert vor.
	/// \return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.12.07
	public ArrayList<String> VerifyCaption()  throws Exception
	{
	    MyLogger.LogFunctionStartDebug("VerifyCaption");
	
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	
	    try
	    {
	
	        // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
	        lvLsReturn = this.getCaption( );
	
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvLsReturn;
	}


	/// \~german
	/// \brief
	/// Ermittelt/Prüft, ob das aktuelle Objekt existiert.
	/// 
	/// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	/// 
	/// \param fpbExpectedValue Erwarteter Wert.
	/// 
	/// \return
	/// Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
	/// Interface schreibt ein Listen-Element als Rückgabewert vor.
	/// 
	/// \param fpbExpectedValue Erwarteter Wert.
	/// 
	/// \return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.12.07
	public Boolean VerifyExists() throws InterruptedException
	{
	    this.MyLogger.LogFunctionStartDebug("VerifyExists");
	
	    Boolean lvbReturn = true;
	    Boolean bOK = false;
	
	    try
	    {
	        lvbReturn = this.getExists( );
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            this.MyLogger.LogFunctionEndDebug(lvbReturn);
	        }
	        else
	        {
	            this.MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvbReturn;
	}


	/// \~german
	/// \brief
	/// Ermittelt/Prüft, ob das aktuelle Objekt aktiv ist.
	/// 
	/// Diese Methode ist der Einstiegspunkt für PrüfeIstAktive-Anpassungen durch Methodenüberschreibung.
	/// 
	/// \returntrue, falls das Objekt aktiv ist sonst false\return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.12.07
	public Boolean VerifyIsActive( )  throws Exception
	{
	    this.MyLogger.LogFunctionStartDebug("VerifyIsActive");
	
	    Boolean lvbReturn = true;
	    Boolean bOK = false;
	
	    try
	    {
	
	        // Nun mit dem erwarteten Sollwert und GetIsActive ggf. auf den erwarteten Wert warten.
	        lvbReturn = this.getIsActive( );
	
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            this.MyLogger.LogFunctionEndDebug(lvbReturn);
	        }
	        else
	        {
	            this.MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvbReturn;
	}


	// \~german
	// \brief
	// Ermittelt ob das GUI-Objekt den Fokus hat.
	// 
	// Dies ist der Einstiegspunkt für die Anpassung der Methote VerifyHasFocus (Methodenüberschreibung).
	// 
	// \return
	//  true falls Objekt den Fokus hat, sonst false.
	// \~english
	// \brief Determines whether the GUI object has the focus.
	//
	// This is the entry point for the adaptation of the method Verify Has Focus (method override).
	// \~
	// \author Zoltán Hrabovszki
	// \date 2013.12.07
	public Boolean VerifyHasFocus()  throws Exception
	{
	    Boolean lvbReturn = false;
	    Boolean bOK = false;
	
	    try
	    {
	        MyLogger.LogFunctionStartDebug("VerifyHasFocus");
	
	        // Nun mit dem erwarteten Sollwert und GetHasFocus ggf. auf den Wert Warten.
	        lvbReturn = this.getHasFocus( );
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvbReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvbReturn;
	}


	/// \~german
	/// \brief
	/// Ermittelt den textuellen Inhalt des Labels für Prüfewert.
	/// 
	/// \remark Sollte der Erwartetet Wert zunächt nicht mit dem aktuellen Wert nicht übereinstimmen,
	/// dann wird gewartet bis entweder der erwartete Wert sich im GUI objekt einstellt
	/// oder der TimeOut erreicht wird.<br/>
	/// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	/// 
	/// \param fplsExpectedValue'>Erwarteter Wert, auf den ggf. bis zum TimeOut gewartet wird.
	/// \return
	/// Rückgabe des Textuellen Inhaltes des Labels.
	/// Interface schreibt ein Listen-Element als Rückgabewert vor.
	/// \return
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.12.07
	public ArrayList<String> VerifyLabel() throws Exception
	{
	    MyLogger.LogFunctionStartDebug("VerifyLabel");
	
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	
	    try
	    {
	        // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
	        lvLsReturn = this.getLabel( );
	
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvLsReturn;
	}


  /** \~german
	 *  Ermittelt den textuellen Inhalt des ToolTips für Prüfewert.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  \return Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
	 *  Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *  \return
	 *  \~english
	 *  \~
	 *  \author Zoltán Hrabovszki
	 *  \date 2013.12.07
   */
	public ArrayList<String> VerifyTooltip() throws Exception
	{
	    MyLogger.LogFunctionStartDebug("VerifyTooltip");
	
	    ArrayList<String> lvLsReturn = new ArrayList<String>();
	    Boolean bOK = false;
	
	    try
	    {
	        // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
	        lvLsReturn = this.getTooltip( );
	
	        bOK = true;
	    }
	    finally
	    {
	        if (bOK)
	        {
	            MyLogger.LogFunctionEndDebug(lvLsReturn);
	        }
	        else
	        {
	            MyLogger.LogFunctionEndDebug();
	        }
	    }
	
	    return lvLsReturn;
	}


	/// \brief
    /// Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
    /// 
    /// Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    /// 
    /// \return
    /// Rückgabe des Textuellen Inhaltes der markierten Textes.
    /// Es wird (immer) der aktuelle Wert des Objektes zurückgeliefert.
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.14
    public ArrayList<String> VerifyValue( ) throws Exception
    {
        ArrayList<String> lvLsReturn = null;
        Boolean bOK = false;

        try
        {
            MyLogger.LogFunctionStartDebug("VerifyValue");

            // get the Actual Value.
            lvLsReturn = this.getValue(  );

            bOK = true;
        }
        finally
        {
            if (bOK)
            {
                MyLogger.LogFunctionEndDebug(lvLsReturn);
            }
            else
            {
                MyLogger.LogFunctionEndDebug();
            }
        }

        return lvLsReturn;
    }

}

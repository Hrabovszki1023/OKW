/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.*;
import okw.gui.adapter.selenium.webdriver.SeDriver;
import okw.log.Logger_Sngltn;
import okw.FrameObjectDictionary_Sngltn;
import okw.LogMessenger;
import okw.OKW;
import okw.OKW_Const_Sngltn;
import okw.OKW_TimeOut;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

/**
 * @defgroup groupSeleniumClasses OKW Selenium Klassen
 * 
 * @defgroup groupSeleniumChildGUIAdapter OKW Childwindow GUI-Adapterklassen
 * @ingroup groupSeleniumClasses
 */

/**
 * \~
 * @defgroup groupSeleniumChildGUIAdapterTests JUnit-Testklassen für OKW Childwindow GUI-Adapterklassen
 * @ingroup groupSeleniumClasses
 */


/**
 * @ingroup groupSeleniumChildGUIAdapter
 * @author zoltan
 */
public class SeAnyChildWindow extends AnyChildwindow
{
    protected LogMessenger  LM       = new LogMessenger( "GUI" );
    
    //protected OKWLocatorXPath _locator = null;
    
    public SeAnyChildWindow( )
    {
        _locator = new OKWLocatorXPath( );
    }
    
    
   /** 
    * \~german
    *  Konstruktor der Klasse. Locator wir speziell in setLocator 
    *  
    *  @param Locator definiert die Objekterkennungseigenschaft des Objektes. Dieser wird als XPATH angegeben
    *  @param Locators Locatoren z.B. von Elternobjekten, die zu einem gesamt Locator verkettet werden sollen.
    *  
    *  \~english
    *  
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2019.03.27
    */
    public SeAnyChildWindow( String fpsLocator, OKWLocatorBase... locators )
    {
        _locator = new OKWLocatorXPath( fpsLocator,  locators );
    }
    
    
    /** \~german
     *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refClickOn aufgerufen wird.
     *  
     *  Diese Methode:
     *  
     *  -# Wartet zunächst, bis das Objekt existiert.
     *  -# Klickt dann auf das aktuelle Objekt.
     *  
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.11.11
     */
    public void ClickOn()
    {
        try
        {
            this.LogFunctionStartDebug( "ClickOn" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.LogPrint( "vor WaitForMe()");
            this.WaitForMe();
            
            this.LogPrint( "Vor WaitForInteraction()");
            
            this.WaitForInteraction( () -> {this.Me().click();} );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    
    /** \~german
      *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
      *   
      *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
      *  \~english
      *  \~
      *  @author Zoltán Hrabovszki
      *  \date 2013.12.07
      */
    public ArrayList<String> getCaption()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "GetCaption" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // The Attribute "textContent" wird als Beschriftung angezeigt...
            WebElement MeME= this.Me();
            String myAttribute = MeME.getAttribute( "textContent" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }
        return lvLsReturn;
    }

    /** \~german
    *  Prüft die Existenz des aktuellen Objektes.
    *  
    *  - Methode ist Selenium spezifisch.
    *  - Elementare Funktion, muss hier defiert werden.
    *  - Es wird nicht auf das Objekt gewarten!
    *  - Es wird nur ein eiziges Mal die Existenz geprüft.
    *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist.
    *  - Wenn Das Objekt nicht eindeitig ist wird false Zurückgeliefert.
    *  
    *  @return true, falls das Objekt eindeutig gefunden worden ist ist, sonst false.
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2017.01.31
    */
    public Boolean getExists()
    {
        Boolean lvbReturn = false;
        
        // WebElement webElement = null; // FIXME: Wird das benötigt? Sonst Entfernen

        String myLocator = null;

        try
        {
            LogFunctionStartDebug( "getExists" );

            myLocator = this.getLocator();
            
            // webElement = SeDriver.getInstance().getWebElement( myLocator );
            SeDriver.getInstance().getWebElement( myLocator );

            lvbReturn = true;
        }
//        catch ( OKWGUIObjectNotUniqueException e )
//        {
//            LogPrint( "OKWGUIObjectNotUniqueException..." );
//            lvbReturn = false;
//        }
        
        catch (OKWGUIObjectNotFoundException e)
        {
            LogPrint( "OKWGUIObjectNotFoundException..." );
            lvbReturn = false;
        }
        catch ( StaleElementReferenceException e )
        {
            LogPrint( "StaleElementReferenceException..." );
            lvbReturn = false;
        }
        finally
        {
            LogFunctionEndDebug( lvbReturn );
        }
        return lvbReturn;
    }

    /** \~german
     *  Methode liefert den aktuellen Zustand Wert des Focus.
     *  
     *  Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
     * 
     *  @return true, if has focus else false
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.11.11
     */
    public Boolean getHasFocus()
    {
        Boolean lvbReturn = false;

        try
        {
            this.LogFunctionStartDebug( "getHasFocus" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            WebElement currentElement = SeDriver.getInstance().getDriver().switchTo().activeElement();

            lvbReturn = currentElement.equals( this.Me() );
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /** \~german
    *  Ermittelt, ob das aktuellen Objekt aktiv ist.
    *  
    *  @return true, falls das Objekt aktive ist, sonst false
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2014.04.19
    */
    public Boolean getIsActive()
    {
        Boolean lvbReturn = false;
        String lvDisabled = null;

        try
        {
            LogFunctionStartDebug( "getIsActive" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            lvDisabled = this.Me().getAttribute( "disabled" );

            if ( lvDisabled != null )
            {
                if ( lvDisabled.equals( "true" ) )
                    lvbReturn = false;
            }
            else
            {
                lvbReturn = true;
            }

        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /** \~german
      *  Ermittelt den textuellen Inhalt des Labels.
      *  
    *  Es wird das Attribute "textContent" des mit "id" an das aktuelle Objekt angebunde "Laben" gelesen.
    *  
    *  @return Rückgabe des Label-Textes.
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2014.06.17
    */
    public ArrayList<String> getLabel()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "getLabel" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // 1. Schritt: Attribute "id" is shown as Tooltip...
            String lvsID = this.Me().getAttribute( "id" );

            // 2.schritt nun Tag Label mit for= "${lvsID}" finden.
            WebElement label = SeDriver.getInstance().getDriver().findElement( By.xpath( "//label[@for='" + lvsID + "']" ) );
            
            // The Attribute "textContent" wird als Beschriftung angezeigt...
            String myAttribute = label.getAttribute( "textContent" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }


    /**  \~german
    *  Ermittelt den textuellen Inhalt des ToolTips.
    *  
    *  Es wird das Attribute "title" ausgelesen.
    *  
    *  @return
    *  Rückgabe des Textuellen Inhaltes der Tooltips.
    *  @return
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> getTooltip()

    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "GetTooltip" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // The Attribute "title" is shown as Tooltip...
            String myAttribute = this.Me().getAttribute( "title" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /** \~german
     *  Liest den aktuellen sichtbaren Wert/Text des HTML-Tags aus.
     * 
     *  Es wird das Attribut "textContent" ausgelesen.
     *  @return Wert des Attributs "textContent"
     *  
     *  \~english
     *  Reads the current visible value/text of the HTML tag.
     *  
     *  It reads the attribute "textContent".
     *  
     *  @return The value of the attribute "textContent"
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.14
     */
    public ArrayList<String> getValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "getValue" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // The Attribute "title" is shown as Tooltip...
            String myAttribute = this.Me().getAttribute( "textContent" );
            myAttribute = StringUtils.normalizeSpace( myAttribute );
            
            lvLsReturn.add( myAttribute );
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    
    /** \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogCaption aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt der Beschriftung (\ref refCaption).
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogCaption(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogCaption durch Methoden überschreibung.
    *  
    *  @return Rückgabe des Beschriftungstextes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> LogCaption()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogCaption" );

            lvLsReturn = this.getCaption();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }
        return lvLsReturn;
    }

    /**
    * \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogExists aufgerufen wird.
    *  
    *  Diese Methode ermittelt die Existenz des aktuellen Objektes.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogExists(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogExists durch Methoden überschreibung.
    *  
    *  @return Rückgabe true falls das Objekt exsistiert, sonst false.
    *
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public boolean LogExists()
    {
        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogExists" );

            lvbReturn = this.getExists();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**
    * \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogHasFocus aufgerufen wird.
    *  
    *  Diese Methode ermittelt, ob das aktuelle Objekt den Focus hat.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogHasFocus(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogHasFocus durch Methoden überschreibung.
    *  
    *  @return true falls Objekt den Fokus hat, sonst false
    *
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  \date 2013.04.11
    */
    public boolean LogHasFocus()
    {
        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogHasFocus" );

            lvbReturn = this.getHasFocus();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /** 
     * \~german
     *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogIsActive aufgerufen wird.
     *  
     *  Diese Methode ermittelt, ob das aktuelle Objekt Active.
     *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogIsActive(String) (zentral) vorgenommen.
     *  
     *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogIsActive durch Methoden überschreibung.
     *  
     *  @return true falls das Objekt aktive ist, sonst false.
     *
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.07
     */
    public boolean LogIsActive()
    {
        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogIsActive" );

            lvbReturn = this.getIsActive();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogLabel aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refLabel s.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogLabel(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogLabel durch Methoden überschreibung.
    *  
    *  @return Rückgabe des label-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> LogLabel()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogLabel" );

            lvLsReturn = this.getLabel();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogPlaceholder aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refPlaceholder s.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogLabel(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogLabel durch Methoden überschreibung.
    *  
    *  @return Rückgabe des label-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> LogPlaceholder()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogLabel" );

            lvLsReturn = this.getLabel();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogTooltip aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refTooltip s.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogTooltip(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogTooltip durch Methoden überschreibung.
    *  
    *  @return Rückgabe des Tooltip-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> LogTooltip()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "LogTooltip" );

            lvLsReturn = this.getTooltip();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

   /**
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refLogValue aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Wert des aktuellen Objektes.
    *  Das Loggen selbst wird in der aufrufenden Methode okw.core.OK.LogValue(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refLogValue durch Methoden überschreibung.
    *  
    *  @return Rückgabe des aktuellen Wertes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  
    *  @return Rückgabe des Textuellen Inhaltes der markierten Textes.
    *  @author Zoltan Hrabovszki
    *  \date 2013.12.14
    */
    public ArrayList<String> LogValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "LogValue" );

            lvLsReturn = this.getValue();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /** \~german
     *  Ermittelt aus dem gegebenen Locator das DOM-Elelement, welches das Objekt representiert.
     *  
     *  @return Refernz auf das gefunde DOM-Element
     *  \~
     *  @author Zoltán Hrabovszki
     *  @throws Exception 
     *  \date 2013.11.11
     */
    public WebElement Me()
    {
        WebElement me = null;

        me = SeDriver.getInstance().getWebElement( this.getLocator() );

        return me;
    }

    /** \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeCaption aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt der Beschriftung (\ref refCaption).
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeCaption(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeCaption durch Methoden überschreibung.
    *  
    *  @return Rückgabe des Beschriftungstextes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> MemorizeCaption()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "MemorizeCaption" );

            lvLsReturn = this.getCaption();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**
     * \~german
     *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeExists aufgerufen wird.
     *  
     *  Diese Methode ermittelt die Existenz des aktuellen Objektes.
     *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeExists(String) (zentral) vorgenommen.
     *  
     *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeExists durch Methoden überschreibung.
     *  
     *  @return Rückgabe true falls das Objekt exsistiert, sonst false.
     *
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.07
     */
    public boolean MemorizeExists()
    {
        Boolean lvbReturn = false;

        try
        {
            this.LogFunctionStartDebug( "MemorizeExists" );

            lvbReturn = this.getExists();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeHasFocus aufgerufen wird.
    *  
    *  Diese Methode ermittelt, ob das aktuelle Objekt den Focus hat.
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeHasFocus(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeHasFocus durch Methoden überschreibung.
    *  
    *  @return true falls Objekt den Fokus hat, sonst false
    *
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public boolean MemorizeHasFocus()
    {
        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug( "MemorizeHasFocus" );

            lvbReturn = this.getHasFocus();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**
    * \~german
     *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeIsActive aufgerufen wird.
     *  
     *  Diese Methode ermittelt, ob das aktuelle Objekt Active.
     *  Das Speichern des Wertes in der aufrufenden Methode okw.core.OK.MemorizeIsActive(String) (zentral) 
     *  vorgenommen.
     *  
     *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeIsActive durch Methoden überschreibung.
     *  
     *  @return true falls das Objekt aktive ist, sonst false.
     *
     *  \~english
     *  \~
     *   @author Zoltán Hrabovszki
     *  \date 2014.04.19
     */
    public boolean MemorizeIsActive()
    {
        Boolean lvbReturn = false;

        try
        {
            LogFunctionStartDebug( "MemorizeIsActive" );

            lvbReturn = this.getIsActive();
        }
        finally
        {
            LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeLabel aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refLabel s.
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeLabel(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeLabel durch Methoden überschreibung.
    *  
    *  @return Rückgabe des label-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> MemorizeLabel()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            LogFunctionStartDebug( "MemorizeLabel" );

            lvLsReturn = this.getLabel();
        }
        finally
        {
            LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizePlaceholder aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refPlaceholder s.
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizePlaceholder(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizePlaceholder durch Methoden überschreibung.
    *  
    *  @return Rückgabe des Placeholder-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2018.10.19
    */
    public ArrayList<String> MemorizePlaceholder()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "MemorizePlaceholder" );

            lvLsReturn = this.getPlaceholder();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    
    /**
    * \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeTooltip aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Inhalt des zugehörigen \ref refMemorizeTooltip s.
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeTooltip(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeTooltip durch Methoden überschreibung.
    *  
    *  @return Rückgabe des Tooltip-Textes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> MemorizeTooltip()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "MemorizeTooltip" );

            lvLsReturn = this.getTooltip();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
    *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refMemorizeValue aufgerufen wird.
    *  
    *  Diese Methode ermittelt den textuellen Wert des aktuellen Objektes.
    *  Das Speichern des Wertes selbst wird in der aufrufenden Methode okw.core.OK.MemorizeValue(String) (zentral) vorgenommen.
    *  
    *  Diese Methode ist der Einstiegspunkt für Anpassungen von \ref refMemorizeValue durch Methoden überschreibung.
    *  
    *  @return Rückgabe des aktuellen Wertes. Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.14
    */
    public ArrayList<String> MemorizeValue()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "MemorizeValue" );

            lvLsReturn = this.getValue();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
     *  Prüft die nicht Existenz des aktuellen Objektes.
     *  
     *  __Anmerkung:__ Falls ein Objekt zunächst noch vorhand ist und dann aber verschwindet,
     *  dann es sinnvoll sein eine gewisse Zeit(Timeout) zu prüfen, ob das Objekt existiert,
     *  Erst wenn diese Zeit verstrichen ist, wird gemeldet, das das Objekt nicht vorhanden ist.
     *  Diese Funktion ist der gegenspieler zu __Exists.
     *  
     *  @return true, falls das Objekt NICHT vorhanden ist. Sonst false
     *  \~
     *  @author Zoltán Hrabovszki
    * @throws Exception 
     *  \date 2013.11.11
     */
    public Boolean _NotExists() throws Exception
    {
        LogFunctionStartDebug( "NotExists" );
        Boolean lvb_Return = null;

        try
        {
            this.Me();
            lvb_Return = false;
        }
        catch (NoSuchElementException e)
        {
            LogPrint( "NoSuchElementException" );
            lvb_Return = true;
        }
        finally
        {
            LogFunctionEndDebug( lvb_Return );
        }
        return lvb_Return;
    }

    /** 
     * \~german
     * 
     * \~english

     * \~
     *  @author Zoltán Hrabovszki
     *  \date 2016.10.06
     */
    public void Select( ArrayList<String> Values )
    {

        try
        {
            this.LogFunctionStartDebug( "Select" );

            String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "Select( ArrayList<String> )" );
            throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    /**
     *  \~german
     *  Muss in den Menü-Objekten Implementiert werden!
     * 
     *  Daher wird hier ein OKWFrameObjectMethodNotImplemented ausgelöst!
     * 
     *  \~english
     *  A SeInputButton has no value! -> Trigger
     *  OKWFrameObjectMethodNotImplemented!
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2016.10.06
     */
    public void SelectMenu()
    {
        // ArrayList<String> lvLsReturn = new ArrayList<String>();
        try
        {
            this.LogFunctionStartDebug( "SelectMenu" );

            String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu()" );
            throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    /** \~german
     *  Muss in den Menü-Objekten Implementiert werden!
     *  Daher wird hier ein OKWFrameObjectMethodNotImplemented ausgelöst!
     *  \~english
     *  A SeInputButton has no value! -> Trigger
     *  OKWFrameObjectMethodNotImplemented!
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2016.10.06
     */
    public void SelectMenu( ArrayList<String> Values )
    {

        try
        {
            this.LogFunctionStartDebug( "SelectMenu_Value" );

            String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu_Value()" );
            throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    /**  \~german
     *  Setzt den Focus auf das Objekt.
     *  
     *  __Anmerkung:__ Kleiner Trick: Selenium kennt keine öffentliche Methode
     *  für das setzen des Fokus. So weit ich es verstanden habe, wird intern jedoch
     *  methode SetFocus verwendt, wenn <tt>SendKeys</tt> aufgerufen wird.
     *  Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
     *  
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     * @throws Exception 
     *  \date 2013.11.11
     */
    public void SetFocus() throws Exception
    {

        try
        {
            LogFunctionStartDebug( "SetFocus" );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            this.WaitForInteraction( () -> {this.Me().sendKeys( "" );} );

        }
        finally
        {
            LogFunctionEndDebug();
        }
    }

    /** \~german
     *  Methode kann hier nicht allgemein gültig implementiert werden. 
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2016.10.06
     */
    public void SetValue( ArrayList<String> Values )
    {

        try
        {
            LogFunctionStartDebug( "SetValue" );

            String lvsLM = this.LM.GetMessage( "Common", "OKWGUIObjectNotFoundException", "SetValue()" );
            throw new OKWFrameObjectMethodNotImplemented( lvsLM );
        }
        finally
        {
            LogFunctionEndDebug();
        }
    }

    /**  \~german
     *  Tastatureingabe in das aktuelle Objekt.
     *  
     *  @param fps_Values'>
     *  Werte, die via Tastatur eingegeben werden sollen.
     *  
     *  \~
     *  @author Zoltan Hrabovszki
     * @throws Exception 
     *  \date 2013.04.11
     */
    public void TypeKey( ArrayList<String> fps_Values )
    {
        try
        {
            LogFunctionStartDebug( "TypeKey", "fps_Values", fps_Values.toString() );

            // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
            this.WaitForMe();

            // We are using a local-Variable to prevent multiple call of Me() in foreach-loop
            WebElement lv_WebElement = this.Me();

            // Loop through all List-Values with foreach...
            for ( String Value : fps_Values )
            {
                Logger_Sngltn.getInstance().LogPrintDebug( ">>" + Value + "<<" );

                if ( Value.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ) )
                {
                    this.WaitForInteraction( () -> {lv_WebElement.clear();} );
                }
                else
                {
                    String resolvedValue = okw.parser.SeKeyParser.ParseMe( Value );
                    this.WaitForInteraction( (  ) -> {lv_WebElement.sendKeys( resolvedValue );} );
                }
            }
        }
        finally
        {
            LogFunctionEndDebug();
        }
    }

    /**
     * \~german
     *  Ermittelt den textuellen Inhalt des ToolTips.
     *  
     *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
     *  
     *  @return	Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
     *  Interface schreibt ein Listen-Element als Rückgabewert vor.
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.07
     */
    public ArrayList<String> VerifyCaption()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "VerifyCaption" );

            // Nun mit dem erwarteten Sollwert und GetValue_TOOLTIP ggf. auf den Wert Warten.
            lvLsReturn = this.getCaption();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**  \~german
    *  Ermittelt/Prüft, ob das aktuelle Objekt existiert.
    *  
    *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    *  	 *  
    *  @return Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
    *  Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public Boolean VerifyExists()
    {

        Boolean lvbReturn = null;

        try
        {
            this.LogFunctionStartDebug( "VerifyExists" );
            lvbReturn = this.getExists();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**
     * \~german
    *  Ermittelt/Prüft, ob das aktuelle Objekt aktiv ist.
    *  
    *  Diese Methode ist der Einstiegspunkt für PrüfeIstAktive-Anpassungen durch Methodenüberschreibung.
    *  
    *  @return true, falls das Objekt aktiv ist sonst false
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public Boolean VerifyIsActive()
    {

        Boolean lvbReturn = null;

        try
        {
            LogFunctionStartDebug( "VerifyIsActive" );

            // Wert GetIsActive ggf. auf den erwarteten Wert warten.
            lvbReturn = this.getIsActive();
        }
        finally
        {
            LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /** \~german
     *  Ermittelt ob das GUI-Objekt den Fokus hat.
     *  
     *  Dies ist der Einstiegspunkt für die Anpassung der Methote VerifyHasFocus (Methodenüberschreibung).
     *  
     *  @return true falls das Objekt den Fokus hat, sonst false.
     *  \~english
     *  Determines whether the GUI object has the focus.
     * 
     *  This is the entry point for the adaptation of the method Verify Has Focus (method override).
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.07
     */
    public Boolean VerifyHasFocus()
    {
        Boolean lvbReturn = false;

        try
        {
            this.LogFunctionStartDebug( "VerifyHasFocus" );

            lvbReturn = this.getHasFocus();
        }
        finally
        {
            this.LogFunctionEndDebug( lvbReturn );
        }
        return lvbReturn;
    }

   /**  
    * \~german
    *  Ermittelt den textuellen Inhalt des Labels für Prüfewert.
    *  
    *  @remark Sollte der erwartete Wert zunächt nicht mit dem aktuellen Wert nicht übereinstimmen,
    *  dann wird gewartet bis entweder der erwartete Wert sich im GUI objekt einstellt
    *  oder der TimeOut erreicht wird.<br/>
    *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    *  
    *  @return Rückgabe des Textuellen Inhaltes des Labels.
    *  Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  \~english
    *  \~
    *  @author Zoltán Hrabovszki
    *  \date 2013.12.07
    */
    public ArrayList<String> VerifyLabel()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "VerifyLabel" );

            lvLsReturn = this.getLabel();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }


    /**  
     * \~german
     *  Ermittelt die maximale Lenge des Wertes für Prüfewert.
     *  
     *  @remark Sollte der erwartete Wert zunächt nicht mit dem aktuellen Wert nicht übereinstimmen,
     *  dann wird gewartet bis entweder der erwartete Wert sich im GUI objekt einstellt
     *  oder der TimeOut erreicht wird.<br/>
     *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
     *  
     *  @return Rückgabe des Textuellen Inhaltes des Labels.
     *  Interface schreibt ein Listen-Element als Rückgabewert vor.
     *  \~english
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2018.12.27
     */
     @Override
     public Integer VerifyMaxLength()
     {
         Integer lvLsReturn = null;

         try
         {
             this.LogFunctionStartDebug( "VerifyMaxLength" );

             lvLsReturn = this.getMaxLength();
         }
         finally
         {
             this.LogFunctionEndDebug( lvLsReturn.toString( ) );
         }

         return lvLsReturn;
     }

     
     /**  
      * \~german
      *  Ermittelt die monimale Lenge des Wertes für Prüfewert.
      *  
      *  @remark Sollte der erwartete Wert zunächt nicht mit dem aktuellen Wert nicht übereinstimmen,
      *  dann wird gewartet bis entweder der erwartete Wert sich im GUI objekt einstellt
      *  oder der TimeOut erreicht wird.<br/>
      *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
      *  
      *  @return Rückgabe des Textuellen Inhaltes des Labels.
      *  Interface schreibt ein Listen-Element als Rückgabewert vor.
      *  \~english
      *  \~
      *  @author Zoltán Hrabovszki
      *  \date 2018.12.27
      */
      @Override
      public Integer VerifyMinLength()
      {
          Integer lvLsReturn = null;

          try
          {
              this.LogFunctionStartDebug( "VerifyMinLength" );

              lvLsReturn = this.getMinLength();
          }
          finally
          {
              this.LogFunctionEndDebug( lvLsReturn.toString( ) );
          }

          return lvLsReturn;
      }     

     /**  
     * \~german
     *  Ermittelt den Text-Inhalt des Platzhalter für VerifyPlaceholder().
     *  
     *  @remark Sollte der erwartete Wert zunächst nicht mit dem aktuellen Wert übereinstimmen,
     *  dann wird gewartet bis entweder der erwartete Wert sich im GUI Objekt einstellt
     *  oder der TimeOut erreicht wird.<br>
     *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
     *  
     *  @param fplsExpectedValue' Erwarteter Wert, auf den ggf. bis zum TimeOut gewartet wird.
     *  @return Rückgabe des Textuellen Inhaltes des Labels.
     *  Interface schreibt ein Listen-Element als Rückgabewert vor.
     *  \~english
     *  Returns the text content of the placeholder for VerifyPlaceholder().
     *  
     *  @remark If the expected value does not match the current value,
     *  the GUI waits until either the expected value is found in the GUI object
     *  or the TimeOut is reached.<br>
     *  This method is the entry point for CheckPlacholder() adjustments by method overwriting.
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2018.10.05
     */
     public ArrayList<String> VerifyPlaceholder()
     {
         ArrayList<String> lvLsReturn = new ArrayList<String>();

         try
         {
             this.LogFunctionStartDebug( "VerifyPlaceholder" );

             lvLsReturn = this.getPlaceholder();
         }
         finally
         {
             this.LogFunctionEndDebug( lvLsReturn );
         }

         return lvLsReturn;
     }

     
    /** \~german
    *  Ermittelt den textuellen Inhalt des ToolTips für Prüfewert.
    *  
    *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    *  
    *  @return Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
    *  Interface schreibt ein Listen-Element als Rückgabewert vor.
    *  \~english
    *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2013.12.07
     */
    public ArrayList<String> VerifyTooltip()
    {
        ArrayList<String> lvLsReturn = new ArrayList<String>();

        try
        {
            this.LogFunctionStartDebug( "VerifyTooltip" );

            lvLsReturn = this.getTooltip();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**
     * \~german
    *  Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
    *  
    *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
    *  
    *  @return Rückgabe des aktuellen Objekt-Wert.
    *  @author Zoltan Hrabovszki
    *  \date 2013.12.14
    */
    public ArrayList<String> VerifyValue()
    {
        ArrayList<String> lvLsReturn = null;

        try
        {
            this.LogFunctionStartDebug( "VerifyValue" );

            // get the Actual Value.
            lvLsReturn = this.getValue();
        }
        finally
        {
            this.LogFunctionEndDebug( lvLsReturn );
        }

        return lvLsReturn;
    }

    /**
     * Wartet auf das Objekt
     * Wenn kein Fenster gefunden wird, 
     */
    public Boolean WaitForMe()
    {
        Boolean lvbReturn = super.WaitForMe();

        if ( !lvbReturn )
        {
            ResOpenList( "GUI-Object not found..." );
            LogPrint( "Locator: '" + this.getLocator() + "'" );
            ResCloseList();

            String lvsLM = this.LM.GetMessage( "Common", "OKWGUIObjectNotFoundException", "WaitForMe()" );
            throw new OKWGUIObjectNotFoundException( lvsLM );
        }
        return lvbReturn;
    }
    

    /** \~german
     *  Methode Versucht eine Interaktion mit dem Se-GUI-Objekt auszuführen und warten ggf. WaitForMe_TO und versucht alle WaitForMe_PT die Interaktionn z wiederholen.
     *  
     *  @return true, wenn das Objekt vorhanden ist, sonst false.
     *  \~
     * 
     *  @author Zoltán Hrabovszki
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws JAXBException 
     * @throws XPathExpressionException 
     *  \date 2020.06.18
     */
    public void WaitForInteraction( Runnable Method2Call )
    {
    	// Variables
    	Integer Count = 0;
    	RuntimeException TimeOutException = null;
    	boolean isExecuted = false;

    	try
    	{
            OKW myOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );

            // TimeOut-Werte ermitteln
            OKW_TimeOut timeout = new OKW_TimeOut( myOKW.WaitForMe_TO(), myOKW.WaitForMe_PT() );

            Count = 0;

            while ( Count <= timeout.getMaxCount() )
            {
            	try
            	{
            		Method2Call.run();
                    
            		// No mistake: Get out of the loop.
            		isExecuted = true;
            		break;
                }
            	catch ( InvalidElementStateException e)
            	{
            		TimeOutException = new RuntimeException( e );
            	}

                Count++;
            }
            
            if (isExecuted)
            {
            	LogPrint( "Interaction succesfull executed" );
            }
            else
            {
            	throw TimeOutException;
            }

    	}
    	catch( XPathExpressionException | JAXBException | ParserConfigurationException | SAXException | IOException e )
    	{
    		throw new RuntimeException( e );
    	}
            
        return;
    }
    
}

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
import java.util.function.Supplier;

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
import org.openqa.selenium.JavascriptExecutor;
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
	 *  Das ist die GUI-Adapter Methode, durch das Schlüsselwort \ref refClickOn aufgerufen wird.
	 *  
	 *  Diese Methode:
	 *  
	 *  -# Wartet zunächst, bis das Objekt existiert.
	 *  -# Setzt den Fokus mit SetFocus() auf das Objekt, damit ggf. ein Trigger beim Verlassen eines anderen GUI-Objektes ausgelöst wird.
	 *     
	 *  -# Klickt danach auf das aktuelle Objekt.
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.11
	 */
	public void ClickOn()
	{

		this.WaitForInteraction( () -> {this.Me().click();} );
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


		String myAttribute = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( "textContent" ); } );

		lvLsReturn.add( StringUtils.normalizeSpace( myAttribute ) );
		return lvLsReturn;
	}

	/** \~german
	 *  Ermittelt den Wert des gegebenen Attribute .
	 *   
	 *  @return Rückgabe des Wert des  der Caption/Überschrift.
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public ArrayList<String> getAttribute( String Attribute )
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();


		String myAttribute = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( Attribute ); } );

		lvLsReturn.add( StringUtils.normalizeSpace( myAttribute ) );
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

		String myLocator = null;

		try
		{
			myLocator = this.getLocator();

			SeDriver.getInstance().getWebElement( myLocator );

			lvbReturn = true;
		}
		catch (OKWGUIObjectNotFoundException e)
		{
			LogPrint( "OKWGUIObjectNotFoundException - GUI-Object was not found..." );
			lvbReturn = false;
		}
		catch ( StaleElementReferenceException e )
		{
			LogPrint( "StaleElementReferenceException - GUI object no longer exists..." );
			lvbReturn = false;
		}

		return lvbReturn;
	}

	/** \~german
	 *  Methode liefert den Fokus-Zustand des aktuellen GUI-Objektes.
	 *  
	 *  Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
	 * 
	 *  @return true, wenn Fokus vorhanden, sonst false
	 *  
	 * \~english
	 *  Method returns the focus state of the current GUI object.
	 *  
	 *  Source: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
	 * 
	 *  @return true, if has focus else false
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.11
	 */
	public Boolean getHasFocus()
	{
		Boolean lvbReturn = false;

		// Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
		this.WaitForMe();

		WebElement currentElement = SeDriver.getInstance().getDriver().switchTo().activeElement();

		lvbReturn = currentElement.equals( this.Me() );
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
		String lvsDisabled = null;

		// Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
		lvsDisabled = this.WaitForInteractionReturnString( () -> { 
			return this.Me().getAttribute( "disabled" ); 
		} );

		if ( lvsDisabled != null )
		{
			if ( lvsDisabled.equals( "true" ) )
				lvbReturn = false;
		}
		else
		{
			lvbReturn = true;
		}

		return lvbReturn;
	}

	/** \~german
	 *  Ermittelt den textuellen Inhalt des Labels.
	 *  
	 *  Es wird das Attribute "textContent" des "Labels" gelesen, welches über das Attribute "id" an das aktuelle GUI-Objekt angebunden ist.
	 *  
	 *  @return Rückgabe des normalisierten Label-Textes.
	 *  \~english
	 *  Determines the textual content of the label.
	 *  
	 *  The "textContent" attribute of the "label" is read, which is linked to the current GUI object via the "id" attribute.
	 *  
	 *  @return Returns the normalized label text.
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2014.06.17
	 */
	public ArrayList<String> getLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		// 1. Schritt: get Attribute "id" is shown as Tooltip...
		String lvsID = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( "id" ); } );

		// 2.schritt nun Tag Label mit for= "${lvsID}" finden.
		WebElement label = SeDriver.getInstance().getDriver().findElement( By.xpath( "//label[@for='" + lvsID + "']" ) );

		// 3. Hole Attribute "textContent" wird als Beschriftung angezeigt...
		String myAttribute = label.getAttribute( "textContent" );

		// 4 Normalisieren...
		myAttribute = StringUtils.normalizeSpace( myAttribute );

		lvLsReturn.add( myAttribute );

		return lvLsReturn;
	}


	/**  \~german
	 *  Ermittelt den textuellen Inhalt des ToolTips.
	 *  
	 *  Dazu wird das Attribute "title" ausgelesen und anschließend normalisiert
	 *  
	 *  @return Rückgabe des textuellen Inhaltes des Tooltips.
	 *  
	 *  \~english
	 *  Gets the textual content of the ToolTip.
	 *  
	 *  For this purpose, the attribute "title" is read and then normalized,
	 *  
	 *  @return Rückgabe des textuellen Inhaltes des Tooltips. 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public ArrayList<String> getTooltip()

	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		// The Attribute "title" is shown as Tooltip...
		String myAttribute = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( "title" ); } );

		myAttribute = StringUtils.normalizeSpace( myAttribute );

		lvLsReturn.add( myAttribute );

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
		String myAttribute = null;

		// Warten auf die Interaktion mit dem Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
		String myValue = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( "data-harmony-value" ); } );

		// Wurde data-harmony-value definiert?
		if ( null == myValue )
		{
			// Nein: "Normal" Weiter 
			myAttribute = this.WaitForInteractionReturnString( () -> { return this.Me().getAttribute( "textContent" ); } );
		}
		else
		{   
			// Ja: Auslesen
			myAttribute = myValue;
		}
		lvLsReturn.add( StringUtils.normalizeSpace( myAttribute ) );

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


		lvLsReturn = this.getCaption();

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

		lvbReturn = this.getExists();

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


		lvbReturn = this.getHasFocus();

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


		lvbReturn = this.getIsActive();

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


		lvLsReturn = this.getLabel();

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


		lvLsReturn = this.getLabel();

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


		lvLsReturn = this.getTooltip();

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

		lvLsReturn = this.getValue();

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

		lvLsReturn = this.getCaption();

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


		lvbReturn = this.getExists();

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

		lvbReturn = this.getHasFocus();

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


		lvbReturn = this.getIsActive();

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


		lvLsReturn = this.getLabel();

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

		lvLsReturn = this.getPlaceholder();

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

		lvLsReturn = this.getTooltip();

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


		lvLsReturn = this.getValue();

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
		return lvb_Return;
	}

	/** 
	 * \~german
	 * 
	 * \~english
	 * 
	 * \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2016.10.06
	 */
	public void Select( ArrayList<String> Values )
	{

		String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "Select( ArrayList<String> )" );
		throw new OKWFrameObjectMethodNotImplemented( lvsLM );
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
		String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu()" );
		throw new OKWFrameObjectMethodNotImplemented( lvsLM );
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
		String lvsLM = this.LM.GetMessage( "Common", "OKWFrameObjectMethodNotImplemented", "SelectMenu_Value()" );
		throw new OKWFrameObjectMethodNotImplemented( lvsLM );
	}

	/** \~german
	 *  Setzt den Focus auf das Objekt.
	 *  
	 *  __Anmerkung:__ Kleiner Trick: Selenium kennt keine öffentliche Methode
	 *  für das setzen des Fokus. So weit ich es verstanden habe, wird intern jedoch
	 *  Methode SetFocus verwendt, wenn <tt>SendKeys</tt> aufgerufen wird.
	 *  Quelle: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
	 *  
	 *  \~english
	 *  Sets the focus to the object.
	 *  __Note:__ Little trick: Selenium does not know a public method for setting the focus.
	 *  As far as I (ZH) understood it, however, internally method SetFocus() is used when <tt>SendKeys</tt> is called.
	 *  Source: http://stackoverflow.com/questions/7491806/in-selenium-how-do-i-find-the-current-object
	 *  
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @throws Exception 
	 *  \date 2013.11.11
	 */
	public void SetFocus() // throws Exception
	{
		this.WaitForInteraction( () -> {this.Me().sendKeys( "" );} );
	}

	/** \~german
	 *  Methode kann hier nicht allgemein gültig implementiert werden.
	 *  
	 *  \~english
	 *  Method cannot be implemented here in a generally valid way.
	 *  
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2016.10.06
	 */
	public void SetValue( ArrayList<String> Values )
	{
		String lvsLM = this.LM.GetMessage( "Common", "OKWGUIObjectNotFoundException", "SetValue()" ); // FIXME Flasche Fehlemeldung? Prüfen
		throw new OKWFrameObjectMethodNotImplemented( lvsLM );
	}

	/** \~german
	 *  Tastatureingabe in das aktuelle Objekt.
	 *  
	 *  @param fps_Values - Werte, die über die Tastatur eingegeben werden sollen.
	 *  
	 *  \~english
	 *  Keyboard input into the current object.
	 *  
	 *  @param fps_Values - Values to be entered via the keyboard.
	 *  
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @throws Exception 
	 *  \date 2013.04.11
	 */
	public void TypeKey( ArrayList<String> fps_Values )
	{

		this.SetFocus();

		// Loop through all List-Values with foreach...
		for ( String Value : fps_Values )
		{
			Logger_Sngltn.getInstance().LogPrintDebug( ">>" + Value + "<<" );

			if ( Value.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" ) ) )
			{
				this.WaitForInteraction( () -> {this.Me().clear();} );
			}
			else
			{
				String resolvedValue = okw.parser.SeKeyParser.ParseMe( Value );
				this.WaitForInteraction( (  ) -> { this.Me().sendKeys( resolvedValue );} );
			}
		}
	}

	/**
	 * \~german
	 *  Ermittelt den textuellen Inhalt der Überschrift eines Objektes.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return	Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
	 *  		Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *  \~english
	 *  Retrieves the textual content of the heading of an object.
	 *  
	 *  This method is the entry point for check value adjustments by method overriding.
	 *  
	 *  @return	 Returns the textual content of the tooltips. It always returns the current value of the object Interface prescribes a list element as return value.
	 *  
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	@Override
	public ArrayList<String> VerifyCaption()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		// Get the current value of the caption.
		lvLsReturn = this.getCaption();

		return lvLsReturn;
	}

	/**  \~german
	 *  Ermittelt/Prüft, ob das aktuelle Objekt existiert.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 * 
	 *  @return Rückgabe des Textuellen Inhaltes der Tooltips. Es wird immer der aktuelle Wert des Objektes zurückgeliefert
	 *  Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *  
	 *  \~english
	 *  Identifies/checks if the current object exists.
	 *  
	 *  This method is the entry point for check value adjustments by method override.
	 *  
	 *  @return Rückgabe des Textuellen Inhaltes der Tooltips. 
	 *          Es wird immer der aktuelle Wert des Objektes zurückgeliefert Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *  
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public Boolean VerifyExists()
	{

		Boolean lvbReturn = false;

		lvbReturn = WaitForInteractionReturnBoolean( () -> {return this.getExists();} );

		return lvbReturn;
	}

	/**
	 * \~german
	 *  Ermittelt/Prüft, ob das aktuelle Objekt aktiv ist.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für VerifyIsActive()-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return true, falls das Objekt aktiv ist sonst false
	 *  
	 *  \~english
	 *  Determines/checks whether the current object is active or not.
	 *  
	 *  This method is the entry point for VerifyIsActive() adjustments through method overrides. Methode ist der Einstiegspunkt für VerifyIsActive()-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return true if the object is active otherwise false
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public Boolean VerifyIsActive()
	{

		Boolean lvbReturn = false;

		// Value GetIsActive if necessary wait for the expected value.
		lvbReturn = this.getIsActive();

		return lvbReturn;
	}

	/** \~german
	 *  Ermittelt ob das GUI-Objekt den Fokus hat.
	 *  
	 *  Dies ist der Einstiegspunkt für die Anpassung der Methote VerifyHasFocus (Methodenüberschreibung).
	 *  
	 *  @return true falls das Objekt den Fokus hat, sonst false.
	 *  
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

		lvbReturn = this.getHasFocus();

		return lvbReturn;
	}

	/**  
	 * \~german
	 *  Ermittelt den textuellen Inhalt des Labels für Prüfewert.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für VerifyLabel()-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe des Textuellen Inhaltes des Labels.
	 *  I       nterface schreibt ein Listen-Element als Rückgabewert vor.
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public ArrayList<String> VerifyLabel()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		lvLsReturn = this.getLabel();

		return lvLsReturn;
	}


	/**  
	 * \~german
	 *  Ermittelt die maximale erlaubte Länge des Wertes z.B. in einem Textfeld.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe der maximalen Länge.
	 *          
	 *  \~english
	 *  Determines the maximum length of the value e.g. in a text field.
	 *  
	 *  This method is the entry point for check value adjustments by method override.
	 *  
	 *  @return Return of the maximum length.
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2018.12.27
	 */
	@Override
	public Integer VerifyMaxLength()
	{
		Integer lvLsReturn = null;

		lvLsReturn = this.getMaxLength();

		return lvLsReturn;
	}


	/**  
	 * \~german
	 *  Ermittelt die minimale geforderte Länge des Wertes z.B. in einem Textfeld.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe der minimalen Länge.
	 *  
	 *  \~english
	 *  Determines the minimum required length of the value e.g. in a text field.
	 *  
	 *  This method is the entry point for check value adjustments by method override.
	 *  
	 *  @return Return of the minimum length.
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2018.12.27
	 */
	@Override
	public Integer VerifyMinLength()
	{
		Integer lvLsReturn = null;

		lvLsReturn = this.getMinLength();

		return lvLsReturn;
	}     

	/**  
	 * \~german
	 *  Ermittelt den Text des Platzhalter für das aktuelle GUI-Objekt.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für VerifyPlaceholder()-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe des Textuellen Inhaltes des Placeholders/Platzhalters.
	 *          Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *          
	 *  \~english
	 *  Determines the text of the placeholder for the current GUI object.
	 *  
	 *  This method is the entry point for VerifyPlaceholder() adjustments by method override.
	 *  
	 *  @return Returns the textual content of the placeholder.
	 *          Interface prescribes a list element as return value.
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2018.10.05
	 */
	public ArrayList<String> VerifyPlaceholder()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		lvLsReturn = this.getPlaceholder();

		return lvLsReturn;
	}


	/** \~german
	 *  Ermittelt den Text des Tolltips für das aktuelle GUI-Objekt.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für VerifyTooltip()-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe des Textuellen Inhaltes der Tooltips.
	 *          Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *          
	 *  \~english
	 *  Determines the text of the tolltip for the current GUI object.
	 *  
	 *  This method is the entry point for VerifyTooltip() adjustments by method override.
	 *  
	 *  @return Return the textual content of the tooltips.
	 *          Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.12.07
	 */
	public ArrayList<String> VerifyTooltip()
	{
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		lvLsReturn = this.getTooltip();

		return lvLsReturn;
	}

	/**
	 * \~german
	 *  Ermittelt den textuellen Inhalt für das aktuelle GUI-Objekt.
	 *  
	 *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
	 *  
	 *  @return Rückgabe des Textuellen Inhaltes der Tooltips.
	 *          Interface schreibt ein Listen-Element als Rückgabewert vor.
	 *          
	 *  @author Zoltan Hrabovszki
	 *  \date 2013.12.14
	 */
	public ArrayList<String> VerifyValue()
	{
		ArrayList<String> lvLsReturn = null;

		// get the Actual Value.
		lvLsReturn = this.getValue();

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
	 *  Verschiebt das aktuelle Element in den sichtbaren Bereich.
	 *  
	 *  @return true, wenn erfolgreich sonst false
	 *  
	 * \~english
	 *  Moves the current element into the visible area.
	 *  
	 *  @return true if successful, false otherwise
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.10.02
	 */
	public Boolean scrollIntoView()
	{
		Boolean lvbReturn = false;

		this.LogPrint("Scrolling the object into the visible area...");

		((JavascriptExecutor) SeDriver.getInstance().getDriver())
		.executeScript("arguments[0].scrollIntoView({block:'nearest'})", Me());

		try
		{
			this.LogPrint("... und warte 1s.");
			// TODO: ScrollWait in Properties auslagern.
			Thread.sleep(1000);
			lvbReturn = true;
		}
		catch (InterruptedException e)
		{
			this.LogWarning("Unexpected exception InterruptedException during ScrollWait, we ignore that..." );
			e.printStackTrace();
		}

		return lvbReturn;
	}


	/** \~german
	 *  Methode versucht die gegebene Interaktion Method2Call gegen das aktuelle GUI-Objekt auszuführen und warten ggf. 
	 *  
	 *  Es wird WaitForMe_TO gewartet und während dieser Zeit alle WaitForMe_PT versucht die Interaktion zu wiederholen.
	 *  
	 *  Folgende Ausnahmen werden abgefangen und eine Interaktion erneut versucht.
	 *  
	 *  __Hinweis:__ bei jeder Iteraktion wird das GUI-Objekt neu gesucht und das Inetrne WebE.ement-referenz erneuert.
	 *  
	 *  @parameter Method2Call Interaktion, die durchgeführt werden soll, gegeben als Lamda Funktion
	 *  
	 *  @return true, wenn das Objekt vorhanden ist, sonst false.
	 *  \~
	 * 
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.06.18
	 */
	public void WaitForInteraction( Runnable Method2Call )
	{
		// Variables:
		Integer Count, MaxCount, PollTime;

		RuntimeException TimeOutException = null;
		boolean isExecuted = false;

		// Action:
		try
		{
			OKW myOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );

			// Determine TimeOut values
			OKW_TimeOut timeout = new OKW_TimeOut( myOKW.WaitForMe_TO(), myOKW.WaitForMe_PT() );

			Count = 0;
			MaxCount = timeout.getMaxCount();
			PollTime = timeout.getPT();


			while ( Count <= MaxCount )
			{
				try
				{

					Method2Call.run();
					
					LogPrint( "Transaction successful!" );

					// No mistake: Get out of the loop.
					isExecuted = true;
					break;
				}

				catch ( OKWGUIObjectNotFoundException e)
				{
					TimeOutException = e;
					LogPrint( "OKWGUIObjectNotFoundException: WebElement currently does not not exist. - wait and retry..." );
				}

				// Exception handling when the object is not yet ready for interaction....
				// includes also
				//  * ElementNotVisibleException
				//  * ElementClickInterceptedException
				//  * ElementNotVisibleException
				catch ( InvalidElementStateException e)
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "InvalidElementStateException: WebElement is currently not ready for interaction. - scroll, wait and retry..." );
					this.scrollIntoView();
				}

				// Ausnahme behandel, wenn das Objekt nicht mehr existiert...
				catch ( StaleElementReferenceException e )
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "StaleElementReferenceException: Update WebElement reference to the DOM. -  wait and try ..." );
				}	

				try
				{
					Thread.sleep( PollTime );
				} 
				catch (InterruptedException e)
				{
					TimeOutException = new RuntimeException( "Unexpected InterruptedException in Threadsleep!", e );
					e.printStackTrace();
				}

				Count++;
			}

			if (isExecuted)
			{
				//LogPrint( "Interaction succesfull executed" );
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


	/** \~german
	 *  Methode versucht die gegebene Interaktion Method2Call gegen das aktuelle GUI-Objekt 
	 *  auszuführen.
	 * 
	 *  Es wird maximal WaitForMe_TO die Interaktion erneut versucht. Während dieser Zeit wird alle WaitForMe_PT versucht die Interaktion zu wiederholen.
	 *  
	 *  Folgende Ausnahmen werden innerhalb von WaitForMe_TO abgefangen und eine Interaktion erneut versucht.
	 *  - OKWGUIObjectNotFoundException
	 *  - InvalidElementStateException
	 *  - StaleElementReferenceException
	 *  - fehlt noch: Exception wenn das objekt unsichbar ist. 
	 *  
	 *  __Hinweis:__ bei jeder Iteraktion wird das GUI-Objekt neu gesucht und das Inetrne WebElement-Referenz erneuert.
	 *  
	 *  @parameter Method2Call Interaktion, die durchgeführt werden soll, gegeben als Lamda Funktion
	 *  
	 *  @return String Wert, welches aus dem WebElement ausgelesn worden ist.
	 *  
	 * \~german
	 *  Method tries to execute the given interaction Method2Call against the current GUI object.
	 *  
	 *  At most WaitForMe_TO the interaction is tried again. During this time, all WaitForMe_PT attempts to repeat the interaction.
	 *  
	 *  The following exceptions are caught within WaitForMe_TO and an interaction is retried.
	 *  - OKWGUIObjectNotFoundException
	 *  - InvalidElementStateException
	 *  - StaleElementReferenceException
	 *  - still missing: Exception if the object is invisible. 
	 *  
	 *  __Note:__ At each iteration the GUI object is searched again and the Internal WebElement reference is renewed.
	 *  
	 *  @parameter Method2Call Interaktion, die durchgeführt werden soll, gegeben als Lamda Funktion
	 *  
	 *  @return String Wert, welches aus dem WebElement ausgelesn worden ist. 	
	 * 
	 *  \~
	 * 
	 *  @author Zoltán Hrabovszki
	 *  \date 2021.02.14
	 */
	public String WaitForInteractionReturnString( Supplier<String> Method2Call )
	{
		// Variables:
		Integer Count, MaxCount, PollTime;

		String lvsReturn = null;

		RuntimeException TimeOutException = null;
		boolean isExecuted = false;

		// Action:
		try
		{
			OKW myOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );
			
			LogPrint( "[WaitForInteractionReturnString] KN: " + this.getKN() );
			
			// Determine TimeOut values
			OKW_TimeOut timeout = new OKW_TimeOut( myOKW.WaitForMe_TO(), myOKW.WaitForMe_PT() );

			Count = 0;
			MaxCount = timeout.getMaxCount();
			PollTime = timeout.getPT();


			while ( Count <= MaxCount )
			{
				try
				{

					lvsReturn = Method2Call.get();
					
					LogPrint( "Transaction successful!" );

					// No mistake: Get out of the loop.
					isExecuted = true;
					break;
				}

				catch ( OKWGUIObjectNotFoundException e)
				{
					TimeOutException = e;
					LogPrint( "OKWGUIObjectNotFoundException: WebElement currently does not not exist. - wait and retry..." );
				}

				// Exception handling when the object is not yet ready for interaction....
				// includes also
				//  * ElementNotVisibleException
				//  * ElementClickInterceptedException
				//  * ElementNotVisibleException
				catch ( InvalidElementStateException e)
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "InvalidElementStateException: WebElement is currently not ready for interaction. - scroll, wait and retry..." );
					this.scrollIntoView();
				}

				// Ausnahme behandel, wenn das Objekt nicht mehr existiert...
				catch ( StaleElementReferenceException e )
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "StaleElementReferenceException: Update WebElement reference to the DOM. -  wait and retry ..." );
				}	

				try
				{
					Thread.sleep( PollTime );
				} 
				catch (InterruptedException e)
				{
					TimeOutException = new RuntimeException( "Unexpected InterruptedException in Threadsleep!", e );
					e.printStackTrace();
				}

				Count++;
			}

			if (isExecuted)
			{
				//LogPrint( "Interaction succesfull executed" );
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

		return lvsReturn;
	}

	/** \~german
	 *  Methode versucht die gegebene Interaktion Method2Call gegen das aktuelle GUI-Objekt 
	 *  auszuführen.
	 * 
	 *  Es wird maximal WaitForMe_TO die Interaktion erneut versucht. Während dieser Zeit wird alle WaitForMe_PT versucht die Interaktion zu wiederholen.
	 *  
	 *  Folgende Ausnahmen werden innerhalb von WaitForMe_TO abgefangen und eine Interaktion erneut versucht.
	 *  - OKWGUIObjectNotFoundException
	 *  - InvalidElementStateException
	 *  - StaleElementReferenceException
	 *  - fehlt noch: Exception wenn das objekt unsichbar ist. 
	 *  
	 *  __Hinweis:__ bei jeder Iteraktion wird das GUI-Objekt neu gesucht und das Inetrne WebElement-Referenz erneuert.
	 *  
	 *  @parameter Method2Call Interaktion, die durchgeführt werden soll, gegeben als Lamda Funktion
	 *  
	 *  @return Boolean Wert, welches aus dem WebElement ausgelesn worden ist.
	 *  
	 * \~german
	 *  Method tries to execute the given interaction Method2Call against the current GUI object.
	 *  
	 *  At most WaitForMe_TO the interaction is tried again. During this time, all WaitForMe_PT attempts to repeat the interaction.
	 *  
	 *  The following exceptions are caught within WaitForMe_TO and an interaction is retried.
	 *  - OKWGUIObjectNotFoundException
	 *  - InvalidElementStateException
	 *  - StaleElementReferenceException
	 *  - still missing: Exception if the object is invisible. 
	 *  
	 *  __Note:__ At each iteration the GUI object is searched again and the Internal WebElement reference is renewed.
	 *  
	 *  @parameter Method2Call Interaktion, die durchgeführt werden soll, gegeben als Lamda Funktion
	 *  
	 *  @return Boolean Wert, welches aus dem WebElement ausgelesn worden ist. 	
	 * 
	 *  \~
	 * 
	 *  @author Zoltán Hrabovszki
	 *  \date 2021.02.14
	 */
	public Boolean WaitForInteractionReturnBoolean( Supplier<Boolean> Method2Call )
	{
		// Variables:
		Integer Count, MaxCount, PollTime;

		Boolean lvbReturn = null;

		RuntimeException TimeOutException = null;
		boolean isExecuted = false;

		// Action:
		try
		{
			OKW myOKW = FrameObjectDictionary_Sngltn.getInstance().getOKW( this.getKN() );

			// Determine TimeOut values
			OKW_TimeOut timeout = new OKW_TimeOut( myOKW.WaitForMe_TO(), myOKW.WaitForMe_PT() );

			Count = 0;
			MaxCount = timeout.getMaxCount();
			PollTime = timeout.getPT();


			while ( Count <= MaxCount )
			{
				try
				{

					lvbReturn = Method2Call.get();

					LogPrint( "Transaction successful!" );

					// No mistake: Get out of the loop.
					isExecuted = true;
					break;
				}

				catch ( OKWGUIObjectNotFoundException e)
				{
					TimeOutException = e;
					LogPrint( "OKWGUIObjectNotFoundException: WebElement currently does not not exist. - wait and retry..." );
				}

				// Exception handling when the object is not yet ready for interaction....
				// includes also
				//  * ElementNotVisibleException
				//  * ElementClickInterceptedException
				catch ( InvalidElementStateException e)
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "InvalidElementStateException: WebElement is currently not ready for interaction. - scroll, wait and retry..." );
					this.scrollIntoView();
				}

				// Ausnahme behandel, wenn das Objekt nicht mehr existiert...
				catch ( StaleElementReferenceException e )
				{
					TimeOutException = new RuntimeException( e );
					LogPrint( "StaleElementReferenceException: Update WebElement reference to the DOM. -  wait and retry ..." );
				}	

				// Ausnahmebehandeln wenn Objekt unsichtbar
				// this.scrollIntoView();

				try
				{
					Thread.sleep( PollTime );
				} 
				catch (InterruptedException e)
				{
					TimeOutException = new RuntimeException( "Unexpected InterruptedException in Threadsleep!", e );
					e.printStackTrace();
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

		return lvbReturn;
	}
}

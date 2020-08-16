/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, 2016 IT-Beratung Hrabovszki
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

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;

import okw.OKW_Const_Sngltn;
import okw.gui.OKWLocatorBase;

/**
 * @ingroup groupSeleniumChildGUIAdapter \~german Diese Klasse implmenetiert die
 *          Methoden der IOKW_SimpleDataObj für ein Texfeld<br/>
 *          . GUI-Automatisierungswerkzeug: Selenium.<br/>
 *          Die meisten Methoden werden aus der abtrakten Klasse
 *          SeSimpleDataObjekt geerbt.
 * 
 *          \~
 * @author Zoltan Hrabovszki
 * \date 2014.06.2014
 */
public class SeTextarea extends SeAnyChildWindow {

	/**
	 * \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator...)
	 */
	public SeTextarea(String Locator, OKWLocatorBase... fpLocators) {
		super(Locator, fpLocators);
	}

	/**
	 * \~german Ermittelt den textuellen Inhalt des Labels.
	 * 
	 * Es wird das Attribute "textContent" des mit "id" an das aktuelle Objekt
	 * angebunde "Laben" gelesen.
	 * 
	 * @return Rückgabe des Label-Textes. \~english \~
	 * @author Zoltán Hrabovszki
	 * \date 2018.12.27
	 */
	public Integer getMaxLength() {
		Integer lviReturn = 0;

		try {
			this.LogFunctionStartDebug("getMaxLength");

			// Warten auf das Objekt. Wenn es nicht existiert wird mit
			// OKWGUIObjectNotFoundException beendet...
			this.WaitForMe();

			// The Attribute "MaxLength" auslesen...
			String lvsMaxLength = this.Me().getAttribute("maxlength");

			if (!okw.OKW_Helper.isStringNullOrEmpty(lvsMaxLength)) {
				lviReturn = Integer.parseInt(lvsMaxLength);
			}
		} finally {
			this.LogFunctionEndDebug(lviReturn.toString());
		}

		return lviReturn;
	}

	/**
	 * \~german Ermittelt den textuellen Inhalt des Labels.
	 * 
	 * Es wird das Attribute "minlength".
	 * 
	 * @return Rückgabe des minlength-Wertes. \~english \~
	 * @author Zoltán Hrabovszki
	 * \date 07-07-2019
	 */
	public Integer getMinLength() {
		Integer lviReturn = 0;

		try {
			this.LogFunctionStartDebug("getMinLength");

			// Warten auf das Objekt. Wenn es nicht existiert wird mit
			// OKWGUIObjectNotFoundException beendet...
			this.WaitForMe();

			// The Attribute "MaxLength" auslesen...
			String lvsMaxLength = this.Me().getAttribute("minlength");

			if (!okw.OKW_Helper.isStringNullOrEmpty(lvsMaxLength)) {
				lviReturn = Integer.parseInt(lvsMaxLength);
			}
		} finally {
			this.LogFunctionEndDebug(lviReturn.toString());
		}

		return lviReturn;
	}

	/**
	 * \~german Liest den Placeholder des TextAere-Tags aus.
	 * 
	 * Es wird das Attribut "placeholder" ausgelesen.
	 * 
	 * @return Wert des Attributs "placeholder"
	 * 
	 *         \~english Reads the current placeholder of the input-tag.
	 * 
	 *         It reads the attribute "placeholder".
	 * 
	 * @return The value of the attribute "placeholder"
	 * 
	 *         \~
	 * @author Zoltán Hrabovszki
	 * \date 2018.10.28
	 */
	public ArrayList<String> getPlaceholder() {
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		try {
			this.LogFunctionStartDebug("getPlaceholder");

			// Warten auf das Objekt. Wenn es nicht existiert wird mit
			// OKWGUIObjectNotFoundException beendet...
			this.WaitForMe();

			// The Attribute "placeholder" wird als Beschriftung angezeigt...
			String myAttribute = this.Me().getAttribute("placeholder");
			myAttribute = StringUtils.normalizeSpace(myAttribute);

			lvLsReturn.add(myAttribute);
		} finally {
			this.LogFunctionEndDebug(lvLsReturn);
		}

		return lvLsReturn;
	}

	/**
	 * \~german \brief Ermittelt den textuellen Inhalt eines Textfeldes.<br/>
	 * . GUI-Automatisierungswerkzeug: Selenium.<br/>
	 * 
	 * \return Gibt den Textuellen Inhaltes eines DOM-TextField-s zurück. Es
	 * korrespondieren je eine Zeile des GUI-Objektes mit jeweil einem
	 * Listen-Element.<br/>
	 * Ein Textfield besteht aus einerZeile: Daher wird der Wert des Textfield-s im
	 * ListenElement[0] abgelegt. Zurückgegeben. \return \~ \author Zoltan
	 * Hrabovszki \date 2014.06.2014
	 * 
	 * @throws Exception
	 */
	@Override
	public ArrayList<String> getValue() {
		ArrayList<String> lvLsReturn = new ArrayList<String>();

		try {
			this.LogFunctionStartDebug("GetValue");

			// Warten auf das Objekt. Wenn es nicht existiert wird mit
			// OKWGUIObjectNotFoundException beendet...
			this.WaitForMe();

			// Get Value from TextField and put this into the return List<string>
			String myValue = this.Me().getAttribute("value");

			if (myValue != null) {
				lvLsReturn.add(this.Me().getAttribute("value"));
			}
		} finally {
			this.LogFunctionEndDebug(lvLsReturn.toString());
		}

		return lvLsReturn;
	}

	public void SetValue(ArrayList<String> Values) {
		this.LogFunctionStartDebug("SetValue", "Val", Values.toString());

		try {
			// Warten auf das Objekt. Wenn es nicht existiert wird mit
			// OKWGUIObjectNotFoundException beendet...
			this.WaitForMe();

			WebElement myMe = this.Me();
			myMe.clear();

			for (String Value : Values)
			{
				if (Value.equals(OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("DELETE")))
				{
                    this.WaitForInteraction( () -> {myMe.clear();} );
				}
				else
				{
                    String resolvedValue = okw.parser.SeKeyParser.ParseMe( Value );
                    this.WaitForInteraction( (  ) -> {myMe.sendKeys( resolvedValue );} );
				}
			}
		}
		finally
		{
			this.LogFunctionEndDebug();
		}
	}

}
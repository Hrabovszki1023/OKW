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

import org.openqa.selenium.WebDriver;

import okw.gui.adapter.selenium.SeAnyChildWindow;

/** 
 * @ingroup groupSeleniumChildGUIAdapter
 * 
 *  \~german
 *  Klasse Implementiert das BACK-Button der Browser.
 *  Die Klasse besitz keinen <tt>locator</tt>.
 *  BACK-Button wird via <tt>SeDriver.Instance.driver.back()</tt> ausgelöst.
 *  Die Menge der Verwendbaren Schlüsselwörter ist begrenzt, weil die Selenium WebDriver API
 *  nur beschränkt an alle Funktionalitäten und Eigenschaften des
 *  BACK-Buttons eines Browser umsetzt.
 *  
 *  __Wichtig:__ Klasse kann nur zusammen mit Selenium WebBrowser Klassen verwendet werden.
 *  
 *  \~english
 *  \~
 *  @author Zoltan Hrabovszki
 *  @date 2014.04.19
 */
public class SeALERTDATA extends SeAnyChildWindow
{

	public SeALERTDATA()
	{
		super();
	}


	/**  \~german
	 *  Setzt den wert von Alet DATA auf den gegebenen wert. Unterstütz mehrzeilige eingaben nicht.
	 *  
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @date 2014.04.19
	 */
	@Override
	public void SetValue(ArrayList<String> fps_Values)
	{
		this.LogFunctionStartDebug("SetValue", "fps_Values", fps_Values.get(0));

		try
		{
			WebDriver myDriver = SeDriver.getInstance().getDriver();
			// The Attribute "textContent" wird als Beschriftung angezeigt...
			myDriver.switchTo().alert().sendKeys(fps_Values.get(0));
		}
		finally
		{
			this.LogFunctionEndDebug();
		}
	}


	/**  \~german
	 *  Setzt den Wert der der Alert-Eingebe im aktiven Browser/BrowserChild.
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  @date 2014.04.19
	 */
	@Override
	public void TypeKey(ArrayList<String> fps_Values)
	{
		this.LogFunctionStartDebug("TypeKey", "fps_Values", fps_Values.get(0));

		try
		{
			this.SetValue(fps_Values);
		}
		finally
		{
			this.LogFunctionEndDebug();
		}
	}
}
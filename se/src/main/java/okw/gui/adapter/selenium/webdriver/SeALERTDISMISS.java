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

package okw.gui.adapter.selenium.webdriver;

/** 
 * @ingroup groupSeleniumChildGUIAdapter
 * 
 *  \~german
 *  Klasse Implementiert die Alert-Cancel(DISMISS) im Alert-Box eines Browsers.
 *  Die Klasse hat keinen <tt>locator</tt>.
 *  Cancel-Button wird via <tt>SeDriver.Instance.switchTo().alert().dismiss()</tt> ausgelöst.
 *  Die Menge der Verwendbaren Schlüsselwörter ist begrenzt, weil die Selenium WebDriver API
 *  nur beschränkt an alle Funktionalitäten und Eigenschaften des
 *  Alert-Funktionen eines Browser umsetzt.
 *  
 *  __Wichtig:__ Klasse kann nur zusammen mit Selenium WebBrowser Klassen verwendet werden.
 *  
 *  \~english
 *  \~
 *  @author Zoltan Hrabovszki
 *  \date 2020.08.10
 */
public class SeALERTDISMISS extends SeDRIVERBASE
{

	public SeALERTDISMISS()
	{
		super();
	}

	/** \~german
	 *  Das ist die GUI-Adapter Methode, die durch das Schlüsselwort \ref refClickOn aufgerufen wird.
	 *  
	 *  Diese Methode implementiert einen Virtuellen-Click als auf ruf der Mthode driver.switchTo().alert().dismiss(;
	 *  
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2013.11.11
	 */
	@Override
	public void ClickOn()
	{
		try
		{
			this.LogFunctionStartDebug( "ClickOn" );

			SeDriver.getInstance().getDriver().switchTo().alert().dismiss();
		}
		finally
		{
			this.LogFunctionEndDebug();
		}
	}
}
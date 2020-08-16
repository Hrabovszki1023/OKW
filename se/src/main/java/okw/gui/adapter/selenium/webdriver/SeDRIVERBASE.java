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

import java.util.ArrayList;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.gui.adapter.selenium.SeAnyChildWindow;

/** 
 * @ingroup groupSeleniumChildGUIAdapter
 * 
 *  \~german
 *  Klasse Implementiert die Alert-Message im Alert-Box eines Browsers.
 *  Die Klasse hat keinen <tt>locator</tt>.
 *  BACK-Button wird via <tt>SeDriver.Instance.switchTo().alert().getText()</tt> ausgelöst.
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
public class SeDRIVERBASE extends SeAnyChildWindow
{

	public SeDRIVERBASE()
	{
		super();
	}


	/** \~german
	 *  Methode wird nicht untertütz, 
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public ArrayList<String> getCaption()
	{
		this.LogFunctionStartDebug( "getCaption" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getCaption: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("getCaption not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz, 
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public Boolean getExists()
	{
		this.LogFunctionStartDebug( "getExists" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getExists: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("getExists not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public Boolean getHasFocus()
	{
		this.LogFunctionStartDebug( "getIsActive" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getHasFocus: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("getHasFocus not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public Boolean getIsActive()
	{
		this.LogFunctionStartDebug( "getIsActive" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getIsActive: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("getIsActive not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public ArrayList<String> getLabel()
	{
		this.LogFunctionStartDebug( "getLabel" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getLabel: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("GetTooltip not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public ArrayList<String> getTooltip()
	{
		this.LogFunctionStartDebug("GetTooltip");
		this.LogFunctionEndDebug();

		// TODO: SeALERTMESSAGE.getTooltip: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("GetTooltip not supported by SeALERTMESSAGE-class!");
	}


	/**
	 * \~german
	 *  Methode wird nicht untertütz.
	 * 
	 * Es wird die Methode WebDriver.switchTo().alert().getText() verwendet.
	 * 
	 *  \~english
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public ArrayList<String> getValue()
	{
		this.LogFunctionStartDebug( "getValue" );
		this.LogFunctionEndDebug( );

		// TODO: SeALERTMESSAGE.getValue: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("getValue not supported by SeALERTMESSAGE-class!");
	}


	/** \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public void ClickOn()
	{
		this.LogFunctionStartDebug("SetFocus");
		this.LogFunctionEndDebug();

		// TODO: SeALERTMESSAGE.ClickOn: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("\"SetFocus\" not supported by SeALERTMESSAGE-class!");
	}


	/**  \~german
	 *  Methode wird nicht untertütz, 
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public void SetFocus()
	{
		this.LogFunctionStartDebug("SetFocus");
		this.LogFunctionEndDebug();

		// TODO: SeALERTMESSAGE.SetFocus: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("\"SetFocus\" not supported by SeALERTMESSAGE-class!");
	}


	/**  \~german
	 *  Methode wird nicht untertütz.
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public void SetValue(ArrayList<String> fps_Values)
	{
		this.LogFunctionStartDebug("SetValue", "fps_Values", fps_Values.get(0));
		this.LogFunctionEndDebug();

		// TODO: SeALERTMESSAGE.SetValue: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("\"SetValue\" not supported by SeALERTMESSAGE-class!");
	}


	/**  \~german
	 *  Methode wird nicht untertütz. 
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020.08.10
	 */
	public void TypeKey(ArrayList<String> fps_Values)
	{
		this.LogFunctionStartDebug("TypeKey", "fps_Values", fps_Values.get(0));
		this.LogFunctionEndDebug();

		// TODO: SeALERTMESSAGE.TypeKey: Ausnahme-Meldung auslagern
		throw new OKWFrameObjectMethodNotImplemented("\"TypeKey\" not supported by SeALERTMESSAGE-class!");
	}
}
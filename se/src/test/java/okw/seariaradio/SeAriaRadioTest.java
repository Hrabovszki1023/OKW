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
package okw.seariaradio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWNotAllowedValueException;


/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapterTests
 * 
 * @author zoltan
 */
public class SeAriaRadioTest extends OKWTestBase
{
	protected static String ApplicationName;

	protected String __cvsObjektName = "SeAriaRadio";

	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();

	String myURL = "https://www.w3.org/TR/wai-aria-practices-1.1/examples/radio/radio-1/radio-1.html";

	@Test
	public void tcClickOn() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey( "URL", myURL);

		// Set start condition: Set All Checkboxes to "CHECKED" 
		EN.SelectWindow("SeAriaRadio");

		EN.ClickOn("Regular crust");
		EN.VerifyValue("Regular crust", "CHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.ClickOn("Deep dish");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "CHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.ClickOn("Thin crust");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "CHECKED");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	@Test
	public void tcSelect() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");

		EN.Select("Regular crust", "CHECKED");
		EN.VerifyValue("Regular crust", "CHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.Select("Deep dish", "CHECKED");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "CHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.Select("Thin crust", "CHECKED");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "CHECKED");

		EN.StopApp( ApplicationName );

		EN.EndTest();
	}

	/**
	 *  Prüft  SetFocus() für SeAriaRadio
	 */
	@Test
	public void tcSetFocus() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");

		EN.SetFocus("Regular crust");
		EN.VerifyHasFocus("Regular crust", "YES");
		EN.VerifyHasFocus("Deep dish", "NO");
		EN.VerifyHasFocus("Thin crust", "NO");

		EN.SetFocus("Deep dish");
		EN.VerifyHasFocus("Regular crust", "NO");
		EN.VerifyHasFocus("Deep dish", "YES");
		EN.VerifyHasFocus("Thin crust", "NO");

		EN.SetFocus("Thin crust");
		EN.VerifyHasFocus("Regular crust", "NO");
		EN.VerifyHasFocus("Deep dish", "NO");
		EN.VerifyHasFocus("Thin crust", "YES");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/**
	 * Prüft SetValue() für SeArieRadio.
	 * 
	 */
	@Test
	public void tcSetValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");


		EN.SetValue("Regular crust", "CHECKED");
		EN.VerifyValue("Regular crust", "CHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.SetValue("Deep dish", "CHECKED");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "CHECKED");
		EN.VerifyValue("Thin crust", "UNCHECKED");

		EN.SetValue("Thin crust", "CHECKED");
		EN.VerifyValue("Regular crust", "UNCHECKED");
		EN.VerifyValue("Deep dish", "UNCHECKED");
		EN.VerifyValue("Thin crust", "CHECKED");


		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/**
	 * Nicht erlaubter Wert in SetValue(), Ausnahme OKWNotAllowedValueException wird auselöst.
	 * 
	 */
	@Test
	public void tcSetValue_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");

		EN.SetValue("Regular crust", "Zoli");

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 * Prüft die VerifyCaption() für SeRadio.
	 * 
	 */
	@Test 
	public void tcVerifyCaption() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");

		EN.VerifyCaption( "Regular crust", "Regular crust");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/**
	 * Prüft die VerifyFocus() für SeRadio.
	 * 
	 * tcSetFocus() beinhaltet VerifyFocus und wird hier referenziert.
	 */ 
	@Test
	public void tcVerifyHasFocus() throws Exception
	{
		tcSetFocus();
	}



	//@Test
	public void tcVerifyIsActive_ActuelYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");

		EN.VerifyIsActive("Tomato", "YES");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	@Test
	public void tcVerifyLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaRadio");
		EN.VerifyLabel("Regular crust", "Regular crust");

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	@Test
	public void tcVerifyValue() throws Exception
	{
		tcClickOn();
	}
}
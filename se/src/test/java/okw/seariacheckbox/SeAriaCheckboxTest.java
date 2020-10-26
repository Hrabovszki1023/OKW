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
package okw.seariacheckbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWNotAllowedValueException;


/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapterTests
 * 
 * @author zoltan
 */
public class SeAriaCheckboxTest extends OKWTestBase
{
	protected static String ApplicationName;

	protected String cvsObjektName = "SeCheckBox";

	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();

	String myURL = "https://www.w3.org/TR/wai-aria-practices-1.1/examples/checkbox/checkbox-1/checkbox-1.html";

	@Test
	public void tcClickOn() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey( "URL", myURL);

		// Set start condition: Set All Checkboxes to "CHECKED" 
		EN.SelectWindow("SeAriaCheckbox");
		EN.SetValue("Lettuce", "CHECKED");
		EN.SetValue("Tomato", "CHECKED");
		EN.SetValue("Mustard", "CHECKED");
		EN.SetValue("Sprouts", "CHECKED");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");
		EN.VerifyValue("Sprouts", "CHECKED");

		EN.ClickOn("Lettuce");
		EN.ClickOn("Tomato");
		EN.ClickOn("Mustard");
		EN.ClickOn("Sprouts");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");
		EN.VerifyValue("Sprouts", "UNCHECKED");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	@Test
	public void tcSelect() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.Select("Lettuce", "CHECKED");
		EN.Select("Tomato", "CHECKED");
		EN.Select("Mustard", "CHECKED");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");

		EN.Select("Lettuce", "UnChecked");
		EN.Select("Tomato", "UnChecked");
		EN.Select("Mustard", "UnChecked");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");

		EN.Select("Lettuce", "Checked");
		EN.Select("Tomato", "Checked");
		EN.Select("Mustard", "Checked");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");

		EN.Select("Lettuce", "UnChecked");
		EN.Select("Tomato", "UnChecked");
		EN.Select("Mustard", "UnChecked");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");

		EN.StopApp( ApplicationName );

		EN.EndTest();
	}


	/// \brief
	/// Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
	/// 
	@Test
	public void tcSetFocus() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.SetFocus("Lettuce");
		EN.VerifyHasFocus("Lettuce", "YES");
		EN.VerifyHasFocus("Tomato", "NO");

		EN.SetFocus("Tomato");
		EN.VerifyHasFocus("Lettuce", "NO");
		EN.VerifyHasFocus("Tomato", "YES");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	@Test
	public void tcSetValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.SetValue("Lettuce", "CHECKED");
		EN.SetValue("Tomato", "CHECKED");
		EN.SetValue("Mustard", "CHECKED");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");

		EN.SetValue("Lettuce", "UnChecked");
		EN.SetValue("Tomato", "UnChecked");
		EN.SetValue("Mustard", "UnChecked");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");

		EN.SetValue("Lettuce", "Checked");
		EN.SetValue("Tomato", "Checked");
		EN.SetValue("Mustard", "Checked");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");

		EN.SetValue("Lettuce", "UnChecked");
		EN.SetValue("Tomato", "UnChecked");
		EN.SetValue("Mustard", "UnChecked");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");


		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	@Test //( expected = OKWNotAllowedValueException.class )
	public void tcSetValue_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.SetValue("Lettuce", "Zoli");

        Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
	}


	@Test 
	public void tcVerifyCaption() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.VerifyCaption( "Tomato", "Tomato");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// \brief
	// Prüft die SetFocusFunktion bei Textfelder mit dem Attribute "ReadOnly"
	// 
	@Test
	public void tcVerifyHasFocus() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.SetFocus("Tomato");
		EN.VerifyHasFocus("Tomato", "YES");
		EN.VerifyHasFocus("Lettuce", "NO");

		EN.SetFocus("Lettuce");
		EN.VerifyHasFocus("Lettuce", "YES");
		EN.VerifyHasFocus("Tomato", "NO");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}



	@Test
	public void tcVerifyIsActive_ActuelYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.VerifyIsActive("Tomato", "YES");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	//@Test
	public void tcVerifyLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");
		EN.VerifyLabel("Lettuce", "Lettuce");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	@Test
	public void tcVerifyValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.TypeKey("URL", myURL);

		EN.SelectWindow("SeAriaCheckbox");

		EN.SetValue("Lettuce", "CHECKED");
		EN.SetValue("Tomato", "CHECKED");
		EN.SetValue("Mustard", "CHECKED");

		EN.VerifyValue("Lettuce", "CHECKED");
		EN.VerifyValue("Tomato", "CHECKED");
		EN.VerifyValue("Mustard", "CHECKED");

		EN.SetValue("Lettuce", "UNCHECKED");
		EN.SetValue("Tomato", "UNCHECKED");
		EN.SetValue("Mustard", "UNCHECKED");

		EN.VerifyValue("Lettuce", "UNCHECKED");
		EN.VerifyValue("Tomato", "UNCHECKED");
		EN.VerifyValue("Mustard", "UNCHECKED");

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}
}
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
package okw.seariaradiogroup;

import okw.OKWTestBase;
import okw.core.EN;
import okw.exceptions.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapterTests
 * 
 *  \~german
 *  Base-Class enthält Testfälle für die Prüfung der Klasse okw.gui.adapter.selenium.SeAriaRadioGroup
 *
 *  Browser spezifische Tests werden von dieser Klasse abgeleitet.
 *  @see
 *  <ul>
 *    <li>okw.SeAriaRadioGroup.SeAriaRadioGroup_Firefox_Test</li>
 *    <li>okw.SeAriaRadioGroup.SeAriaRadioGroup_HTMLUnitDriver_Test</li>
 *    <li>okw.SeAriaRadioGroup.SeAriaRadioGroup_Chrome_Test</li>
 *  </ul>
 * \~
 * @author Zoltan Hrabovszki
 * \date 2014.12.03
 */
public class SeAriaRadioGroup_Test extends OKWTestBase
{
	/** 
	 *  \~german
	 *  Enthält den FN Namen des aktuellen Browsers.
	 *  
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2016.12.25
	 */
	protected static String ApplicationName;

	String myURL = "https://www.w3.org/TR/wai-aria-practices-1.1/examples/radio/radio-1/radio-1.html";

	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.LogExists, wenn das Object _nicht vorhanden_ ist.<br>
	 * 
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.25
	 */
	// @Test //OK
	public void tcLogExists_ExistsNo() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.LogExists( "Does Not Exist" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.LogExists, wenn das Object _nicht vorhanden_ ist.<br>
	 * 
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.25
	 */
	// @Test //OK
	public void tcLogExists_ExistsYes() throws Exception
	{

		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.LogExists( "Pizza Crust" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK
	public void tcLogIsActive() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.LogIsActive( "Pizza Crust" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.LogValue.
	 *  
	 * Prüft ob der aktuell Wert "gelogged" wird. 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	//@Test //OK
	public void tcLogLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.LogLabel( "Pizza Crust" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 *  Tooltip eines Textfeldes Prüfen.
	 * @throws Exception
	 */
	//@Test // No Tooltip SUT
	public void tcLogToolTip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pay Method", "Visa" );
		EN.LogTooltip( "Pay Method" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.LogValue.
	 *  
	 * Prüft ob der aktuell Wert "gelogged" wird. 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK
	public void tcLogValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish");
		EN.LogValue( "Pizza Crust" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeValue.
	 *  
	 * Prüft ob der aktuell Wert eingespeichert wird. 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test // OK
	public void tcMemorizeLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.MemorizeLabel( "Pizza Crust", "SeRadioLabel_MemorizeValue_2" );
		assertEquals( "Pizza Crust", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioLabel_MemorizeValue_2" ) );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeLabel.
	 *  
	 * Prüft ob "" ein OKWNotAllowedValueException auslöst.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	//@Test // OK
	public void tcMemorizeLabel_Empty_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );
		EN.MemorizeLabel( "Pizza Crust", "" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeLabel.
	 *  
	 * Prüft ob IGNORE ein OKWNotAllowedValueException auslöst.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test // OK ( expected = OKWNotAllowedValueException.class )
	public void tcMemorizeLabel_IGNORE_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.MemorizeLabel( "Pizza Crust", "${IGNORE}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});

	}


	/**
	 *  Prüft die Methode SeLink.MemorizeToolTip.
	 * @throws Exception
	 */
	// @Test
	public void tcMemorizeToolTip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.MemorizeTooltip( "Pizza Crust", "SeAriaRadioGroup_MemorizeTooltip_1" );
		assertEquals( "fieldset-title", okw.OKW_Memorize_Sngltn.getInstance().get( "SeAriaRadioGroup_MemorizeTooltip_1" ) );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeValue.
	 *  
	 * Prüft ob der aktuell Wert eingespeichert wird. 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK
	public void tcMemorizeValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish");
		EN.MemorizeValue( "Pizza Crust", "SeAriaRadioGroup_MemorizeValue_1" );
		assertEquals( "Deep dish", okw.OKW_Memorize_Sngltn.getInstance().get( "SeAriaRadioGroup_MemorizeValue_1" ) );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeValue.
	 *  
	 * Prüft ob "" ein OKWNotAllowedValueException auslöst.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK ( expected = OKWNotAllowedValueException.class )
	public void tcMemorizeValue_Empty_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish");
		EN.MemorizeValue( "Pizza Crust", "SeAriaRadioGroup_MemorizeValue_1" );
		assertEquals( "Deep dish", okw.OKW_Memorize_Sngltn.getInstance().get( "SeAriaRadioGroup_MemorizeValue_1" ) );

		EN.MemorizeValue( "Pizza Crust", "" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.MemorizeValue.
	 *  
	 * Prüft ob IGNORE ein OKWNotAllowedValueException auslöst.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK ( expected = OKWNotAllowedValueException.class )
	public void tcMemorizeValue_IGNORE_OKWNotAllowedValueException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish");
		EN.MemorizeValue( "Pizza Crust", "SeAriaRadioGroup_MemorizeValue_1" );
		assertEquals( "Deep dish", okw.OKW_Memorize_Sngltn.getInstance().get( "SeAriaRadioGroup_MemorizeValue_1" ) );

		EN.MemorizeValue( "Pizza Crust", "${IGNORE}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 * Prüft die Methode EN.Select() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeAriaRadioGroup 
	 * übergeben wird.
	 *
	 *  \~english
	 * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.Select(), if more than one value is passed to SeAriaRadioGroup.
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2014.12.03
	 * 
	 * @throws Exception Here is no Exception expected!
	 */
	// @Test // ( expected = OKWOnlySingleValueAllowedException.class )
	public void tcSelect_OKWOnlySingleValueAllowedException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish${SEP}Thin crust" );

		EN.StopApp( ApplicationName );
		Assertions.assertThrows( OKWOnlySingleValueAllowedException.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 *  \~german
	 *  Testziel: Prüft, ob ein einzelner Wert gewählt wird.
	 *
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2014.12.03
	 */
	// @Test //OK
	public void tcSelect_SingelValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		// "Pizza crust"
		EN.Select( "Pizza Crust", "Regular crust" );
		EN.VerifyValue( "Pizza Crust", "Regular crust" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValue( "Pizza Crust", "Deep dish" );

		EN.Select( "Pizza Crust", "Thin crust" );
		EN.VerifyValue( "Pizza Crust", "Thin crust" );


		// "Pizza Delivery" "Pickup" "Home Delivery" "Dine in"
		EN.Select( "Pizza Delivery", "Pickup" );
		EN.VerifyValue( "Pizza Delivery", "Pickup" );

		EN.Select( "Pizza Delivery", "Home Delivery" );
		EN.VerifyValue( "Pizza Delivery", "Home Delivery" );

		EN.Select( "Pizza Delivery", "Dine in" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );
		// "Pizza crust"
		EN.Select( "Pizza Crust", "Regular crust" );
		EN.VerifyValue( "Pizza Crust", "Regular crust" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValue( "Pizza Crust", "Deep dish" );

		EN.Select( "Pizza Crust", "Thin crust" );
		EN.VerifyValue( "Pizza Crust", "Thin crust" );


		// "Pizza Delivery" "Pickup" "Home Delivery" "Dine in"
		EN.Select( "Pizza Delivery", "Pickup" );
		EN.VerifyValue( "Pizza Delivery", "Pickup" );

		EN.Select( "Pizza Delivery", "Home Delivery" );
		EN.VerifyValue( "Pizza Delivery", "Home Delivery" );

		EN.Select( "Pizza Delivery", "Dine in" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  \brief
	 *  Testziel: Prüft die Methode SeAriaRadioGroup.Select.
	 *
	 *  Löst einen OKWNotAllowedValueException aus da ein Radiobutten nicht gelöschwerden kann. Lediglisch durch das Auswählen eines anderen 
	 *  "deselectiert" ein RadioButton.<br>
	 *  \~english
	 * A radiobutton is usually part of a set. This configuration forces users to make a choice,
	 * it means that one of the buttons in the set MUST be checked and ONLY ONE can be checked.
	 * You can not uncheck the button because this would imply that no button in the set is checked.
	 * If you want a specific button to be unchecked, you need to check another button in the set: this will automatically uncheck the button you wanted unchecked.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2014.12.03
	 */
	// @Test //OK ( expected = OKWNotAllowedValueException.class )
	public void tcSelect_SingleValue_DELETE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Delivery", "${DELETE}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.Select(),
	 *  dass "" keine Aktivität im Objekt aulösen.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2014.12.03
	 */
	// @Test // OK
	public void tcSelect_SingleValue_EmptyString() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		// Mit Werten vorbelegen
		EN.Select( "Pizza Delivery", "Dine in" );

		// Werte sind im Objekt?
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		// IGNORE ändert nichts an den eingestellten Werten
		EN.Select( "Pizza Delivery", "" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.Select(), ob "${IGNORE}" keine Aktivität im Objekt vornimmt.
	 * 
	 * \~english
	 * Checks the SeAriaRadioGroup.Select() method if "${IGNORE}" does not perform any activity in the object.
	 *  \~
	 *  
	 *  @author Zoltan Hrabovszki
	 *  \date 2021.03.28
	 */
	// @Test // OK
	public void tcSelect_SingleValue_IGNORE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		// Mit Werten vorbelegen
		EN.Select( "Pizza Delivery", "Dine in" );

		// Werte sind im Objekt?
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		// IGNORE ändert nichts an den eingestellten Werten
		EN.Select( "Pizza Delivery", "${IGNORE}" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 * Prüft die Methode EN.SetValue() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeAriaRadioGroup 
	 * übergeben wird.
	 *
	 *  \~english
	 * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.SetValue(), if more than one value is passed to SeAriaRadioGroup.
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2014.12.03
	 * 
	 * @throws Exception The OKWOnlySingleValueAllowedException is expected!
	 */
	// @Test //OK ( expected = OKWOnlySingleValueAllowedException.class )
	public void tcSetValue_OKWOnlySingleValueAllowedException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.SetValue( "Pizza Delivery", "Thin crust${SEP}Deep dish" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWOnlySingleValueAllowedException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 * Prüft die Methode SeAriaRadioGroup.SetValue()
	 * ob _ein_ einzelner Wert ausgewählt wird.
	 *
	 *  \~english
	 * Reviews the  Methode SetValue of the Class SeAriaRadioGroup for singel value selection in SeAriaRadioGroup.
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2014.12.03
	 * 
	 * @throws Exception Here is no Exception expected!
	 */
	//@Test //OK
	public void tcSetValue_SingelValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		// "Pizza crust"
		EN.SetValue( "Pizza Crust", "Regular crust" );
		EN.VerifyValue( "Pizza Crust", "Regular crust" );

		EN.SetValue( "Pizza Crust", "Deep dish" );
		EN.VerifyValue( "Pizza Crust", "Deep dish" );

		EN.SetValue( "Pizza Crust", "Thin crust" );
		EN.VerifyValue( "Pizza Crust", "Thin crust" );


		// "Pizza Delivery" "Pickup" "Home Delivery" "Dine in"
		EN.SetValue( "Pizza Delivery", "Pickup" );
		EN.VerifyValue( "Pizza Delivery", "Pickup" );

		EN.SetValue( "Pizza Delivery", "Home Delivery" );
		EN.VerifyValue( "Pizza Delivery", "Home Delivery" );

		EN.SetValue( "Pizza Delivery", "Dine in" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );
		// "Pizza crust"
		EN.SetValue( "Pizza Crust", "Regular crust" );
		EN.VerifyValue( "Pizza Crust", "Regular crust" );

		EN.SetValue( "Pizza Crust", "Deep dish" );
		EN.VerifyValue( "Pizza Crust", "Deep dish" );

		EN.SetValue( "Pizza Crust", "Thin crust" );
		EN.VerifyValue( "Pizza Crust", "Thin crust" );


		// "Pizza Delivery" "Pickup" "Home Delivery" "Dine in"
		EN.SetValue( "Pizza Delivery", "Pickup" );
		EN.VerifyValue( "Pizza Delivery", "Pickup" );

		EN.SetValue( "Pizza Delivery", "Home Delivery" );
		EN.VerifyValue( "Pizza Delivery", "Home Delivery" );

		EN.SetValue( "Pizza Delivery", "Dine in" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 * Prüft die Methode SetValue() der Klasse SeAriaRadioGroup, ob ${IGNORE} und "" _keine Aktivität_ auf der GUI auslösen.
	 *
	 *  \~english
	 * \~
	 * @author Zoltan Hrabovszki
	 * \date 2016.12.24
	 * 
	 * @throws Exception Here is no Exception expected!
	 */
	// @Test //OK
	public void tcSetValue_SingelValue_IGNORE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.SetValue( "Pizza Delivery", "Dine in" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.SetValue( "Pizza Delivery", "${IGNORE}" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.SetValue( "Pizza Delivery", "" );
		EN.VerifyValue( "Pizza Delivery", "Dine in" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  \brief
	 *  Testziel: Prüft die Methode SeAriaRadioGroup.Select.
	 *
	 *  Löst einen OKWNotAllowedValueException aus da ein Radiobutten nicht gelöschwerden kann. Lediglisch durch das Auswählen eines anderen 
	 *  "deselectiert" ein RadioButten.
	 *  \~english
	 * A radiobutton is usually part of a set. This configuration forces users to make a choice,
	 * it means that one of the buttons in the set MUST be checked and ONLY ONE can be checked.
	 * You can not uncheck the button because this would imply that no button in the set is checked.
	 * If you want a specific button to be unchecked, you need to check another button in the set: this will automatically uncheck the button you wanted unchecked.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2014.12.03
	 */
	//@Test // OK
	public void tcSetValue_SingleValue_DELETE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.SetValue( "Pizza Crust", "${DELETE}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.VerifyExists.<br>
	 * 
	 *   Istwert: Ist _nicht vorhanden_.<br> 
	 *   Sollwert: Soll _nicht vorhanden_ sein.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.20
	 */
	// @Test //OK
	public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
	{

		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyExists( "Does Not Exist", "YES" );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}

	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.VerifyExists.<br>
	 * 
	 *   Istwert: Ist _nicht vorhanden_.<br> 
	 *   Sollwert: Soll _vorhanden_ sein.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.20
	 */
	// @Test // OK
	public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyExists( "Does Not Exist", "NO" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.VerifyExists.<br>
	 * 
	 *   Istwert: Ist _vorhanden_.<br> 
	 *   Sollwert: Soll _nicht vorhanden_ sein.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.20
	 */
	// @Test //OK ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyExists( "Pizza Crust", "NO" );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.VerifyExists.<br>
	 * 
	 *   Istwert: Ist _vorhanden_.<br> 
	 *   Sollwert: Soll _vorhanden_ sein.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.20
	 */
	// @Test
	public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyExists( "Pizza Crust", "YES" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.IsActive().
	 *  
	 *  Istwert: _ist aktive_. Sollwert: _aktive_ ist.
	 *  
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test // No SUT for thi Testcase
	public void tcVerifyIsActive_IsActiveNoExpectedNo() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyIsActive( "Pizza Crust", "NO" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.IsActive().<br>
	 *
	 *  Istwert: _ist aktive_. Sollwert _ist nicht aktive_.
	 * 
	 * @exception OKWVerifyingFailsException wird erwartet.
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.09.20
	 */
	//@Test // No SUT for thi Testcase ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyIsActive_IsActiveNoExpectedYes_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyIsActive( "Pay Method", "NO" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.IsActive().<br>
	 *
	 *  Istwert: _ist aktive_. Sollwert _ist nicht aktive_.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.09.20
	 */
	// @Test //OK ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyIsActive_IsActiveYesExpectedNo_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyIsActive( "Pizza Crust", "NO" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	/** \~german
	 *  Prüft die Methode SeAriaRadioGroup.IsActive().
	 *  
	 *  Istwert: _ist aktive_. Sollwert: _aktive_ ist.
	 *  
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2016.12.23
	 */
	// @Test //OK
	public void tcVerifyIsActive_IsActiveYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyIsActive( "Pizza Crust", "YES" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// @Test // OK
	public void tcVerifyLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyLabel( "Pizza Crust", "Pizza Crust" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// @Test //OK
	public void tcVerifyLabel_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Thin crust");
		EN.VerifyLabel( "Pizza Crust", "Schnick-Schnack" );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}

	// @Test //OK
	public void tcVerifyLabelREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Thin crust");
		EN.VerifyLabelREGX( "Pizza Crust", "Pizza .*" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// @Test //OK
	public void tcVerifyLabelREGX_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Thin crust");
		EN.VerifyLabelREGX( "Pizza Crust", "Schnick .*" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}

	// @Test //OK
	public void tcVerifyLabelWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Thin crust");
		EN.VerifyLabelWCM( "Pizza Crust", "Pizza*" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// @Test //OK
	public void tcVerifyLabelWCM_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Thin crust");
		EN.VerifyLabelWCM( "Pizza Crust", "Schnick*" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});	    }

	//@Test
	public void tcVerifyToolTip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltip( "Pizza Crust", "fieldset-title" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	//@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyToolTip_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltip( "Pizza Crust", "Wrong Value" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	//@Test
	public void tcVerifyToolTipREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltipREGX( "Pizza Crust", "fieldset.title" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	//@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyToolTipREGX_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltipREGX( "Pizza Crust", "Wrong Value" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}

	//@Test Kein Tolltip SUT Vorhanden.
	public void tcVerifyToolTipWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltipWCM( "Pizza Crust", "fieldset?title" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	//@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyToolTipWCM_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyTooltip( "Pizza Crust", "Wrong Value" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}

	@Test //OK
	public void tcVerifyValue() throws Exception
	{
		this.tcSelect_SingelValue();
	}


	@Test //OK
	public void tcVerifyValue_EMPTY() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.VerifyValue( "Pizza Crust", "${EMPTY}");

		EN.StopApp( ApplicationName );

		EN.EndTest();
	}


	@Test  //OK ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValue_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValue( "Pizza Crust", "Wrong Value");

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	@Test //OK
	public void tcVerifyValueREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValueREGX( "Pizza Crust", "Deep.*" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	@Test  //OK ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValueREGX_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValueREGX( "Pizza Crust", "Wrong V.*" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	@Test //OK
	public void tcVerifyValueWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValueWCM( "Pizza Crust", "Deep*" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	@Test //OK ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValueWCM_Fail_OKWVerifyingFailsException() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.SetValue( "URL", myURL );

		EN.SelectWindow( "SeAriaRadioGroup" );

		EN.Select( "Pizza Crust", "Deep dish" );
		EN.VerifyValueWCM( "Pizza Crust", "Wrong*" );

		EN.StopApp( ApplicationName );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}
}

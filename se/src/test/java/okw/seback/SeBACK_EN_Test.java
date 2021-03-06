/*
 ==============================================================================
 Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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
 along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.

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

package okw.seback;

import okw.OKW_Memorize_Sngltn;
import okw.SeOKWChildWindowBaseTest;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWNotAllowedValueException;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapterTests
 * 
 * \~german
 * Basisklasse für die BACK Testfälle zur Ableitung von Browser-Testfällen
 * 
 *  - Firefox: okw.SeBACK.SeBACK_Firefox_Test
 *  - Chrome: okw.SeBACK.SeBACK_Chrome_Test
 *  - HTMLUnit: okw.SeBACK.SeBACK_HTMLUnit_Test
 * 
 *  @author Zoltan Hrabovszki
 *  \date 2017-07-23
 */
@Disabled
public class SeBACK_EN_Test extends SeOKWChildWindowBaseTest
{

	protected static String ApplicationName;

	protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

	/**
	 * \~german
	 * Testet die Implementierung des Schlüsselwortes ClickOn( CAT ) für Klasse SeBACK .
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */
	@Override
	@Test
	public void tcClickOn() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );
		EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

		EN.SetValue( "URL", "http://test.openkeyword.de/Link/a.htm" );
		EN.VerifyValue( "URL", "http://test.openkeyword.de/Link/a.htm" );

		EN.ClickOn( "BACK" );
		EN.VerifyValue( "URL", "http://test.openkeyword.de/InputText/input_type_all_InputText.htm" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 * \~german
	 * Testet das Schlüsselwort LogExists( CAT ) eines SeBACK Prüfen.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcLogExists() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.LogExists( "BACK" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 * \~german
	 * Testet das Schlüsselwort LogHasFocus( CAT ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcLogHasFocus() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.LogHasFocus( "BACK" );

		// ( expected = OKWFrameObjectMethodNotImplemented.class )
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 * \~german
	 *  Teste das Schlüsselwort LogIsActive( CAT ) eines SeBACK prüfen.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcLogIsActive() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.LogIsActive( "BACK" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}
	
	/**
	 * \~german
	 * Testet das Schlüsselwort LogHasFocus( CAT ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  \date 2020-09-24
	 */
	@Override
	@Test
	public void tcLogLabel( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.LogLabel( "BACK" );

		// ( expected = OKWFrameObjectMethodNotImplemented.class )
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort LogTooltip( CAT, Val ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcLogToolTip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.LogTooltip( "BACK" );

		//(expected = OKWFrameObjectMethodNotImplemented.class)
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort LogTooltip( CAT, Val ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcLogValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.LogValue( "BACK" );

		// (expected = OKWFrameObjectMethodNotImplemented.class)
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort MemorizeExists( CAT, MemKey ).
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeExists() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.MemorizeExists( "BACK", "SeBACK_MemorizeExists_1" );

		assertEquals( "YES", myMem.get("SeBACK_MemorizeExists_1" ) );

		EN.StopApp( ApplicationName );

		EN.EndTest();
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort MemorizeExists( CAT, Val ) eines SeBACK Prüfen.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeExists_DELETE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		Integer keyCountsBefore = myMem.getKeysCount();
		EN.MemorizeExists( "BACK", "${DELETE}" );

		assertEquals( keyCountsBefore, myMem.getKeysCount() );
		
		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort MemorizeExists( CAT, Val ) eines SeBACK Prüfen.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeExists_EMPTY() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		
		Integer keyCountsBefore = myMem.getKeysCount();
		EN.MemorizeExists( "BACK", "${EMPTY}" );
		assertEquals( keyCountsBefore, myMem.getKeysCount() );
		
		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort MemorizeExists( CAT, IGNORE ).
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeExists_IGNORE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		
		Integer keyCountsBefore = myMem.getKeysCount();

		EN.MemorizeExists( "BACK", "${IGNORE}" );

		// Number of Memorized vauls is identical to the Value keyCountsBefore.
		assertEquals( keyCountsBefore, myMem.getKeysCount() );

		keyCountsBefore = myMem.getKeysCount();

		EN.MemorizeExists( "BACK", "" );

		// Number of Memorized vauls is identical to the Value keyCountsBefore.
		assertEquals( keyCountsBefore, myMem.getKeysCount() );

		
		EN.StopApp( ApplicationName );

		EN.EndTest();
	}
	
	/** 
	 * \~german
	 *  Teste das Schlüsselwort MemorizeHasFocus( CAT, MemKey ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected = OKWFrameObjectMethodNotImplemented.class)
	public void tcMemorizeHasFocus() throws Exception {

		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.MemorizeHasFocus( "BACK", "SeBACK_MemorizeHasFocus" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 * \~german
	 *  Teste das Schlüsselwort MemorizeIsActive( CAT, MemKey ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeIsActive() throws Exception {

		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.MemorizeIsActive( "BACK", "SeBACK_MemorizeIsActive" );

		assertEquals( "YES", myMem.get( "SeBACK_MemorizeIsActive" ) );

		EN.StopApp( ApplicationName );

		EN.EndTest();
	}

	/** 
	 * \~german
	 *  Teste das Schlüsselwort MemorizeLabel( CAT, MemKey ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.MemorizeLabel( "BACK", "SeBACK_MemorizeLabel_1" );

		// (expected = OKWFrameObjectMethodNotImplemented.class)
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 * \~german
	 *  Teste das Schlüsselwort MemorizeTooltip( CAT, MemKey ) eines SeBACK Prüfen.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected = OKWFrameObjectMethodNotImplemented.class)
	public void tcMemorizeToolTip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.MemorizeTooltip( "BACK", "SeBACK_MemorizeTooltip" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 * \~german
	 *  Teste das Schlüsselwort MemorizeValue( CAT, MemKey ) eines SeBACK.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcMemorizeValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.MemorizeValue( "BACK", "SeBACK_LogValue_2" );

		// (expected=OKWFrameObjectMethodNotImplemented.class )
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 *  Teste das Schlüsselwort SetFocus( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcSetFocus_ReadableAndEnabled( ) throws Exception
	{
		assertTrue( true, "BACK is always Readable and Enabled. This test is not relevant for virtual objects like BACK." );
	}


	/**
	 *  Teste das Schlüsselwort SetFocus( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcSetFocus_ReadonlyAndEnabled( ) throws Exception
	{
		assertTrue( true, "BACK is always Readable and Enabled. This test is not relevant for virtual objects like BACK." );
	}


	/**
	 * \~german
	 * Testet das Schlüsselwort SetValue( CAT ) eines SeBACK.
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test 
	public void tcSetValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "BACK", "Hrabovszki" );

		// (expected = OKWFrameObjectMethodNotImplemented.class)
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort SetValue( CAT, EMPTY ) eines SeBACK.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test 
	public void tcSetValue_EMPTY() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "BACK", "${EMPTY}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Testet das Schlüsselwort SetValue( CAT, EMPTY ).
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test 
	public void tcSetValue_DELETE() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "BACK", "${DELETE}" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/** 
	 *  Teste das Schlüsselwort TtcSetValue( CAT, "${IGNORE}" ) für SeBACK.
	 * 
	 * 
	 * @par IGNORE - Es wird keinerlei Interaktion mit der GUI ausgeführt.
	 * Schlüsselwort wird bereits in der Klasse OK "übersprungen" und daher wird keine Ausnahme ausgelöst,
	 *
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09.17
	 */
	@Override
	@Test
	public void tcSetValue_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.SetValue( "BACK", "${IGNORE}" );
		
		EN.SetValue( "BACK", "" );
		
		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 * \~german
	 * Testet das Schlüsselwort TypeKey( CAT, Val ) für SeBACK.
	 * 
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcTypeKey() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.TypeKey( "BACK", "Hrabovszki" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 * \~german
	 *  Teste das Schlüsselwort TypeKey( CAT, "DELETE" ) für SeBACK.
	 * 
	 * 
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09,17
	 */ 
	@Override
	@Test
	public void tcTypeKey_DELETE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.TypeKey( "BACK", "${DELETE}" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/** 
	 * \~german
	 *  Teste das Schlüsselwort TypeKey( CAT, "IGNORE" ).
	 * 
	 * @par IGNORE - Es wird keinerlei Interaktion mit der GUI ausgeführt.
	 * Schlüsselwort wird bereits in OK "übersprungen" und keine Ausnahme ausgelöst,
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09.17
	 */
	@Override
	@Test
	public void tcTypeKey_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.TypeKey( "BACK", "${IGNORE}" );
		
		EN.TypeKey( "BACK", "" );
		
		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** 
	 * \~german
	 *  Teste das Schlüsselwort TypeKey( CAT, "EMPTY" ).
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09.17
	 */
	@Override
	@Test
	public void tcTypeKey_EMPTY( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.TypeKey( "BACK", "${EMPTY}" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyCaption( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcVerifyCaption() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyCaption( "BACK", "Abc" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyCaptionREGX( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyCaptionREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyCaptionREGX( "BACK", "${EMPTY}" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 *  \~german
	 *  Test des Schlüsselwortes "VerifyCaptionWCM( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcVerifyCaptionWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyCaptionWCM( "BACK", "${EMPTY}" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}

	/** 
	 *  Teste das Schlüsselwort VerifyExists( CAT, VAL ).
	 *  
	 *  BACK existiert Immer
	 */
	@Override
	@Test
	public void tcVerifyExists_ExistsNoExpectedNo( ) throws Exception
	{
		assertTrue( true, "BACK ist immer vorhanden, daher ist dieser Test nicht möglich/nötig" );
	}

	
	/** 
	 *  Teste das Schlüsselwort VerifyExists( CAT, VAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyExists_ExistsNoExpectedYes( ) throws Exception
	{
		assertTrue( true, "BACK ist immer vorhanden, daher ist dieser Test nicht möglich/nötig" );
	}


	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyExists( CAT, ExpVal ) für SeBACK.
	 * 
	 *  Hier wird geprüft ob eine Soll/Ist-Abweichung die Ausnahme OKWVerifyingFailsException auslöst.
	 *  
	 *  @par Hinweis: BACK existiert immer,
	 *  
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcVerifyExists_ExistsYesExpectedNo()  throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyExists( "BACK", "NO" );

		Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
		{
			EN.EndTest();
		});
	}


	/**
	 * \~german
	 * Prüft ob das BACK existiert.
	 * Erwartet wird, dass das Objekt existiert.
	 * 
	 * @par Hinweis: BACK existiert immer
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */
	@Override
	@Test
	public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyExists( "BACK", "YES" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** 
	 *  Teste das Schlüsselwort VerifyExists( CAT, "IGNORE" ) für SeBACK.
	 * 
	 * @par IGNORE - Es wird keinerlei Interaktion mit der GUI ausgeführt.
	 * Schlüsselwort wird bereits in OK "übersprungen" und keine Ausnahme ausgelöst,
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09.17
	 */
	@Override
	@Test
	public void tcVerifyExists_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyExists( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyHasFocus( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017.07.23
	 */ 
	@Override
	@Test
	public void tcVerifyHasFocus() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyHasFocus( "BACK", "NO" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyHasFocus( CAT, VAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyHasFocus_HasFocusNoExpectedYes( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyHasFocus( "BACK", "YES" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}



	/** 
	 *  Teste das Schlüsselwort VerifyHasFocus( CAT, VAL ).
	 */
	@Override
    @Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyHasFocus_HasFocusYesExpectedNo( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyHasFocus( "BACK", "NO" );

		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyHasFocus( CAT, "IGNORE" ) für SeBACK.
	 * 
	 * @par IGNORE - Es wird keinerlei Interaktion mit der GUI ausgeführt.
	 * Schlüsselwort wird bereits in OK "übersprungen" und keine Ausnahme ausgelöst,
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2020.09.17
	 */
	@Override
	@Test
	public void tcVerifyHasFocus_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyHasFocus( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/**
	 * \~german
	 *  Test des Schlüsselwortes VerifyHasFocus( CAT, "NotAllowedValue" ) für SeBACK.
	 *  
	 *  @par Methode NotAllowedValue
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcVerifyHasFocus_NotAllowedValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyHasFocus( "BACK", "Uschi" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 *  Test des Schlüsselwortes VerifyIsActive( CAT, "NotAllowedValue" ) für SeBACK.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017.07.30
	 */
	@Override
	@Test
	public void tcVerifyIsActiv_ExistsYesExpectedYes() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyIsActive( "BACK", "YES" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/**
	 * \~german
	 *  Prüft, ob die Methode VerifyIsActive( "BACK", "NotAllowdValue" ) für BACK implementiert ist.
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-30
	 */
	@Override
	@Test
	public void tcVerifyIsActive_NotAllowedValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyIsActive( "BACK", "NotAllowedValue" );

		Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
		{
			EN.EndTest();
		});
	}

	/**
	 * \~german
	 * Test des Schlüsselwortes "VerifyLabel( CAT, ExpVal ) für SeBACK.
	 *  
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyLabel() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyLabel( "BACK", "Label" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyLabel( CAT, "IGNORE" ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyLabel_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyLabel( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/**
	 *  \~german
	 *  Test des Schlüsselwortes "VerifyLabelREGX( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyLabelREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyLabelREGX( "BACK", "Label" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyLabelREGX( CAT, "${IGNORE}" )
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyLabelREGX_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyLabelREGX( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}


	/** 
	 *  Teste das Schlüsselwort VerifyLabelWCM( CAT, negativeVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyLabelREGX_Fail( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyLabelREGX( "BACK", "Label" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}





	// FIXME: Create Testcsae for Not allowed Value.
	// FIXME: Create Testcsae for "NO", "NO".
	// FIXME: VerifyHasFocus: Create Testcase for Not allowed Value.



	// FIXME: VerifyIsActive: Create Testcsae for "IGNORE"
	// FIXME: VerifyIsActive: Create Testcsae for "NO", "NO".
	// FIXME: VerifyIsActive: Create Testcsae for "NO", "YES".
	// FIXME: VerifyIsActive: Create Testcsae for "YES", "NO".
	// FIXME: VerifyIsActive: Create Testcsae for notallowed Value.

	/**
	 * \~german
	 *  Test des Schlüsselwortes VerifyLabelWCM( CAT, ExpVal ) für SeBACK.
	 *  
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test
	public void tcVerifyLabelWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyLabelWCM( "BACK", "Name?" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyLabelWCM( CAT, "IGNORE" ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyLabelWCM_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyLabelWCM( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyLabelWCM( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyLabelWCM_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyMaxLength( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcVerifyMaxLength( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyMaxLength( CAT, "IGNORE" ).
	 */
	@Override
	@Test
	public void tcVerifyMaxLength_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyMaxLength( "BACK", "${IGNORE}" );
		
		EN.StopApp(ApplicationName);
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyMaxLength( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyMaxLength_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort tcVerifyMinLength( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcVerifyMinLength( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/** 
	 *  Teste das Schlüsselwort VerifyMinLength( CAT, "IGNORE" ).
	 */
	@Override
	@Test
	public void tcVerifyMinLength_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyMinLength( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort tcVerifyMinLength( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyMinLength_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholder( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcVerifyPlaceholder( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholder( CAT, IGNORE ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholder_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyPlaceholder( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholder( CAT, negativeVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholder_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderREGX( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcVerifyPlaceholderREGX( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderREGX( CAT, IGNORE ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholderREGX_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyLabel( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderREGX( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholderREGX_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderWCM( CAT, VAL ).
	 */
	@Override
	@Test
	public void tcVerifyPlaceholderWCM( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderWCM( CAT, IGNORE ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholderWCM_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyPlaceholderWCM( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyPlaceholderWCM( CAT, negativeVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyPlaceholderWCM_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyTooltip( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyTooltip() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyTooltip( "BACK", "Den Namen eingeben" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyTooltip( CAT, "IGNORE" ).
	 */
	@Override
	@Test //v( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltip_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyTooltip( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyTooltip( CAT, negativVAL ).
	 */
	@Override
	@Test //v( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltip_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	
	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyTooltipREGX( CAT, ExpVal ) für SeBACK.
	 *  
	 * @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyTooltipREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyTooltipREGX( "BACK", "\\wen Namen eingeben" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyTooltipREGX( CAT, "IGNORE" ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltipREGX_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyTooltipREGX( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyTooltipREGX( CAT, negativeVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltipREGX_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyTooltipWCM( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyTooltipWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyTooltipWCM( "BACK", "??? Namen eingeben" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyTooltipWCM( CAT, "IGNORE" ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltipWCM_IGNORE( ) throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );

		EN.VerifyTooltipWCM( "BACK", "${IGNORE}" );

		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	/** 
	 *  Teste das Schlüsselwort VerifyTooltipWCM( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyTooltipWCM_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/**
	 * \~german
	 *  Test des Schlüsselwortes "VerifyValue( CAT, ExpVal ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyValue() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyValue( "BACK", "Zoltan" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, DELETE ).
	 */
	@Override
	@Test
	public void tcVerifyValue_DELETE( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValue_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, EMPTY ).
	 */
	@Override
	@Test
	public void tcVerifyValue_EMPTY( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/**
	 * \~german
	 * Test des Schlüsselwortes "VerifyValueREGX( CAT, ExpValu ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyValueREGX() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyValueREGX( "BACK", ".oltan" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, DELETE ).
	 */
	@Override
	@Test
	public void tcVerifyValueREGX_DELETE( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, EMPTY ).
	 */
	@Override
	@Test
	public void tcVerifyValueREGX_EMPTY( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValueREGX_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}


	/**
	 * \~german
	 * Test des Schlüsselwortes "VerifyValueWCM( CAT, ExpValu ) für SeBACK.
	 *  
	 *  @par Methode ist nicht Implementiert -> OKWFrameObjectMethodNotImplemented
	 * 
	 *  \~
	 *  @author Zoltan Hrabovszki
	 *  \date 2017-07-23
	 */ 
	@Override
	@Test // (expected=OKWFrameObjectMethodNotImplemented.class )
	public void tcVerifyValueWCM() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
	
		EN.VerifyValueWCM( "BACK", "Abc" );
	
		Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
		{
			EN.EndTest();
		});
	}


	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, DELETE ).
	 */
	@Override
	@Test
	public void tcVerifyValueWCM_DELETE( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, EMPTY ).
	 */
	@Override
	@Test
	public void tcVerifyValueWCM_EMPTY( ) throws Exception
	{
		fail("Implement " + TestName );
	}

	/** 
	 *  Teste das Schlüsselwort VerifyValue( CAT, negativVAL ).
	 */
	@Override
	@Test // ( expected = OKWVerifyingFailsException.class )
	public void tcVerifyValueWCM_Fail( ) throws Exception
	{
		fail("Implement " + TestName );
	}
}

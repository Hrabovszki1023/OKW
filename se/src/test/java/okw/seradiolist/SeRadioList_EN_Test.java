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
package okw.seradiolist;

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
 *  Base-Class enthält Testfälle für die Prüfung der Klasse okw.gui.adapter.selenium.SeRadioList
 *
 *  Browser spezifische Tests werden von dieser Klasse abgeleitet.
 *  @see
 *  <ul>
 *    <li>okw.SeRadioList.SeRadioList_Firefox_Test</li>
 *    <li>okw.SeRadioList.SeRadioList_HTMLUnitDriver_Test</li>
 *    <li>okw.SeRadioList.SeRadioList_Chrome_Test</li>
 *  </ul>
 * \~
 * @author Zoltan Hrabovszki
 * \date 2014.12.03
 */
public class SeRadioList_EN_Test extends OKWTestBase
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

  /**
   *  \~german
   *  Testziel: Prüft, ob ein einzelner Wert gewählt wird.
   *
   * \~
   * @author Zoltan Hrabovszki
   * \date 2014.12.03
   */
  @Test
  public void tcSelect_SingelValue() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "Visa" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.Select( "Pay Method", "Mastercard" );
    EN.VerifyValue( "Pay Method", "Mastercard" );

    EN.Select( "Pay Method", "American Express" );
    EN.VerifyValue( "Pay Method", "American Express" );
    
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
  
  
  /** \~german
   * Prüft die Methode EN.Select() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeRadioList 
   * übergeben wird.
   *
   *  \~english
   * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.Select(), if more than one value is passed to SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * \date 2014.12.03
   * 
   * @throws Exception Here is no Exception expected!
   */
  @Test // ( expected = OKWOnlySingleValueAllowedException.class )
  public void tcSelect_OKWOnlySingleValueAllowedException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "Visa${SEP}Mastercard" );

    EN.StopApp( ApplicationName );
    Assertions.assertThrows( OKWOnlySingleValueAllowedException.class, () ->
        {
            EN.EndTest();
        });
  }
  

  /** \~german
   *  \brief
   *  Testziel: Prüft die Methode SeRadioList.Select.
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
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcSelect_SingleValue_DELETE() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "${DELETE}" );

	    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
	    {
	        EN.EndTest();
	    });
  }

  /** \~german
   *  \brief Prüft die Methode SeRadioList.Select(),
   *  ob "${IGNORE}" keine Aktivität im Objekt aulösen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2014.12.03
   */
  @Test
  public void tcSelect_SingleValue_IGNORE() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Visa" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Visa" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "${IGNORE}" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }


  /** \~german
   *  Prüft die Methode SeRadioList.Select(),
   *  dass "" keine Aktivität im Objekt aulösen.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2014.12.03
   */
  @Test
  public void tcSelect_SingleValue_EmptyString() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    // Mit Werten vorbelegen
    EN.Select( "Pay Method", "Visa" );

    // Werte sind im Objekt?
    EN.VerifyValue( "Pay Method", "Visa" );

    // IGNORE ändert nichts an den eingestellten Werten
    EN.Select( "Pay Method", "" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}
  
  
  /** \~german
   * Prüft die Methode SeRadioList.SetValue()
   * ob _ein_ einzelner Wert ausgewählt wird.
   *
   *  \~english
   * Reviews the  Methode SetValue of the Class SeRadioList for singel value selection in SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * \date 2014.12.03
   * 
   * @throws Exception Here is no Exception expected!
   */
  @Test
  public void tcSetValue_SingelValue() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.SetValue( "Pay Method", "Visa" );
    EN.VerifyValue( "Pay Method", "Visa" );

    EN.SetValue( "Pay Method", "Mastercard" );
    EN.VerifyValue( "Pay Method", "Mastercard" );

    EN.SetValue( "Pay Method", "American Express" );
    EN.VerifyValue( "Pay Method", "American Express" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}
  
  /** \~german
   *  \brief
   *  Testziel: Prüft die Methode SeRadioList.Select.
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
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcSetValue_SingleValue_DELETE() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.SetValue( "Pay Method", "${DELETE}" );
	    
	    
	    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
	        {
	            EN.EndTest();
	        });
  }

  
  /** \~german
   * Prüft die Methode EN.SetValue() ob OKWOnlySingleValueAllowedException ausgelöst wird, wenn mehr als ein Wert an SeRadioList 
   * übergeben wird.
   *
   *  \~english
   * Checks whether the OKWOnlySingleValueAllowedException is thrown by EN.SetValue(), if more than one value is passed to SeRadioList.
   * \~
   * @author Zoltan Hrabovszki
   * \date 2014.12.03
   * 
   * @throws Exception The OKWOnlySingleValueAllowedException is expected!
   */
  @Test // ( expected = OKWOnlySingleValueAllowedException.class )
  public void tcSetValue_OKWOnlySingleValueAllowedException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.SetValue( "Pay Method", "Visa${SEP}Mastercard" );

    EN.StopApp( ApplicationName );
    
    Assertions.assertThrows( OKWOnlySingleValueAllowedException.class, () ->
        {
            EN.EndTest();
        });
  }

  
  /** \~german
   * Prüft die Methode SetValue() der Klasse SeRadioList, ob ${IGNORE} und "" _keine Aktivität_ auf der GUI auslösen.
   *
   *  \~english
   * \~
   * @author Zoltan Hrabovszki
   * \date 2016.12.24
   * 
   * @throws Exception Here is no Exception expected!
   */
  @Test
  public void tcSetValue_SingelValue_IGNORE() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.SetValue( "Pay Method", "Visa" );
	    EN.VerifyValue( "Pay Method", "Visa" );

	    EN.SetValue( "Pay Method", "${IGNORE}" );
	    EN.VerifyValue( "Pay Method", "Visa" );

	    EN.SetValue( "Pay Method", "" );
	    EN.VerifyValue( "Pay Method", "Visa" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.VerifyExists.<br>
   * 
   *   Istwert: Ist _vorhanden_.<br> 
   *   Sollwert: Soll _vorhanden_ sein.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.20
   */
  @Test
  public void tcVerifyExists_ExistsYesExpectedYes() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.VerifyExists( "Pay Method", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.VerifyExists.<br>
   * 
   *   Istwert: Ist _nicht vorhanden_.<br> 
   *   Sollwert: Soll _nicht vorhanden_ sein.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.20
   */
  @Test
  public void tcVerifyExists_ExistsNoExpectedNo() throws Exception
  {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.VerifyExists( "Does Not Exist", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

 
   /** \~german
   *  Prüft die Methode SeRadioList.VerifyExists.<br>
   * 
   *   Istwert: Ist _vorhanden_.<br> 
   *   Sollwert: Soll _nicht vorhanden_ sein.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.20
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.VerifyExists( "Pay Method", "NO" );
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
  }

  
  /** \~german
  *  Prüft die Methode SeRadioList.VerifyExists.<br>
  * 
  *   Istwert: Ist _nicht vorhanden_.<br> 
  *   Sollwert: Soll _vorhanden_ sein.
  * 
  *  \~
  *  @author Zoltan Hrabovszki
  *  \date 2016.12.20
  */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyExists_ExistsNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.VerifyExists( "Does Not Exist", "NO" );
    
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  
  /** \~german
  *  Prüft die Methode SeRadioList.LogExists, wenn das Object _nicht vorhanden_ ist.<br>
  * 
  * 
  *  \~
  *  @author Zoltan Hrabovszki
  *  \date 2016.12.25
  */
  @Test
  public void tcLogExists_ExistsNo() throws Exception
  {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.LogExists( "Does Not Exist" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
  *  Prüft die Methode SeRadioList.LogExists, wenn das Object _nicht vorhanden_ ist.<br>
  * 
  * 
  *  \~
  *  @author Zoltan Hrabovszki
  *  \date 2016.12.25
  */
  @Test
  public void tcLogExists_ExistsYes() throws Exception
  {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.LogExists( "Pay Method" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }


  /** \~german
   *  Prüft die Methode SeRadioList.IsActive().
   *  
   *  Istwert: _ist aktive_. Sollwert: _aktive_ ist.
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcVerifyIsActive_IsActiveYesExpectedYes() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyIsActive( "Pay Method", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeValue.
   *  
   * Prüft ob der aktuell Wert eingespeichert wird. 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcMemorizeValue() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.MemorizeValue( "Pay Method", "SeRadioList_MemorizeValue_1" );
    assertEquals( "Visa", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioList_MemorizeValue_1" ) );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.LogValue.
   *  
   * Prüft ob der aktuell Wert "gelogged" wird. 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcLogValue() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.LogValue( "Pay Method" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeValue.
   *  
   * Prüft ob IGNORE ein OKWNotAllowedValueException auslöst.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeValue_IGNORE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.MemorizeValue( "Pay Method", "SeRadioList_MemorizeValue_1" );
    assertEquals( "Visa", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioList_MemorizeValue_1" ) );

    EN.Select( "Pay Method", "American Express");
    EN.MemorizeValue( "Pay Method", "${IGNORE}" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
    {
        EN.EndTest();
    });
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeValue.
   *  
   * Prüft ob "" ein OKWNotAllowedValueException auslöst.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeValue_Empty_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.MemorizeValue( "Pay Method", "SeRadioList_MemorizeValue_1" );
    assertEquals( "Visa", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioList_MemorizeValue_1" ) );

    EN.Select( "Pay Method", "American Express");
    EN.MemorizeValue( "Pay Method", "" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  
  /** \~german
   *  Prüft die Methode SeRadioList.IsActive().
   *  
   *  Istwert: _ist aktive_. Sollwert: _aktive_ ist.
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcVerifyIsActive_IsActiveNoExpectedNo() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

	    EN.SelectWindow( "SeRadioList" );

	    EN.VerifyIsActive( "Pay Method", "NO" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.IsActive().<br>
   *
   *  Istwert: _ist aktive_. Sollwert _ist nicht aktive_.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.09.20
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyIsActive_IsActiveYesExpectedNo_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );

	    EN.VerifyIsActive( "Pay Method", "NO" );

	    EN.StopApp( ApplicationName );
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.IsActive().<br>
   *
   *  Istwert: _ist aktive_. Sollwert _ist nicht aktive_.
   * 
   * @exception OKWVerifyingFailsException wird erwartet.
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.09.20
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyIsActive_IsActiveNoExpectedYes_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );

	    EN.VerifyIsActive( "Pay Method", "NO" );

	    EN.StopApp( ApplicationName );
	    
	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
  }

  /** \~german
   *  
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcLogIsActive() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

	    EN.SelectWindow( "SeRadioList" );

	    EN.LogIsActive( "Pay Method" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }

  
  @Test
  public void tcVerifyToolTip() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

	    EN.SelectWindow( "SeRadioList" );

	    EN.VerifyTooltip( "Pay Method", "fieldset-title" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }


  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTip_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyTooltip( "Pay Method", "Wrong Value" );

    EN.StopApp( ApplicationName );

    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }


  @Test
  public void tcVerifyToolTipWCM() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyTooltipWCM( "Pay Method", "fieldset?title" );
 
    EN.StopApp( ApplicationName );
    EN.EndTest();
}


  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTipWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyTooltip( "Pay Method", "Wrong Value" );

    EN.StopApp( ApplicationName );

    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
 }


  @Test
  public void tcVerifyToolTipREGX() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyTooltipREGX( "Pay Method", "fieldset.title" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}


  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyToolTipREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.VerifyTooltipREGX( "Pay Method", "Wrong Value" );

    EN.StopApp( ApplicationName );

    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  @Test
  public void tcVerifyLabel() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabel( "Pay Method", "Pay with:" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
	  }

  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabel_Fail_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabel( "Pay Method", "Schnick-Schnack" );

	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
	}

  @Test
  public void tcVerifyLabelWCM() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabelWCM( "Pay Method", "Pay*" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
}

  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabelWCM( "Pay Method", "Schnick*" );

	    EN.StopApp( ApplicationName );

	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });	    }

  @Test
  public void tcVerifyLabelREGX() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabelREGX( "Pay Method", "Pay .*" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }

  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyLabelREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyLabelREGX( "Pay Method", "Sch.*" );

	    EN.StopApp( ApplicationName );

	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
}

  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeValue.
   *  
   * Prüft ob der aktuell Wert eingespeichert wird. 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcMemorizeLabel() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.MemorizeLabel( "Pay Method", "SeRadioLabel_MemorizeValue_2" );
    assertEquals( "Pay with:", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioLabel_MemorizeValue_2" ) );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /** \~german
   *  Prüft die Methode SeRadioList.LogValue.
   *  
   * Prüft ob der aktuell Wert "gelogged" wird. 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test
  public void tcLogLabel() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.LogLabel( "Pay Method" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeLabel.
   *  
   * Prüft ob IGNORE ein OKWNotAllowedValueException auslöst.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeLabel_IGNORE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.Select( "Pay Method", "Visa");
    EN.MemorizeLabel( "Pay Method", "${IGNORE}" );

    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
    {
        EN.EndTest();
    });
    
  }

  
  /** \~german
   *  Prüft die Methode SeRadioList.MemorizeLabel.
   *  
   * Prüft ob "" ein OKWNotAllowedValueException auslöst.
   * 
   *  \~
   *  @author Zoltan Hrabovszki
   *  \date 2016.12.23
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeLabel_Empty_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    EN.MemorizeLabel( "Pay Method", "" );

    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
    {
        EN.EndTest();
    });
  }
  
  // / \brief
  // / Prüft die Methode SeLink.MemorizeToolTip.
  // /
  @Test
  public void tcMemorizeToolTip() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio_inactive.htm" );

    EN.SelectWindow( "SeRadioList" );

    EN.MemorizeTooltip( "Pay Method", "SeRadioList_MemorizeTooltip_1" );
    assertEquals( "fieldset-title", okw.OKW_Memorize_Sngltn.getInstance().get( "SeRadioList_MemorizeTooltip_1" ) );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  // / \brief
  // / Tooltip eines Textfeldes Prüfen.
  // /
  @Test
  public void tcLogToolTip() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );

	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "Visa" );
	    EN.LogTooltip( "Pay Method" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
}

  @Test
  public void tcVerifyValue() throws Exception
  {
	  this.tcSelect_SingelValue();
  }

  
  @Test
  public void tcVerifyValue_EMPTY() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );

	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.VerifyValue( "Pay Method", "${EMPTY}" );
}

  
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValue_Fail_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );

	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "Visa" );
	    EN.VerifyValue( "Pay Method", "American Express" );

	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
}

  
  @Test
  public void tcVerifyValueWCM() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "American Express" );
    EN.VerifyValueWCM( "Pay Method", "American*" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
}


  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueWCM_Fail_OKWVerifyingFailsException() throws Exception
  {
    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

    EN.SelectWindow( "SeRadioList" );
    
    EN.Select( "Pay Method", "American Express" );
    EN.VerifyValueWCM( "Pay Method", "Vis*" );

    EN.StopApp( ApplicationName );

    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
}

  
  @Test
  public void tcVerifyValueREGX() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyValueREGX( "Pay Method", "American.*" );

	    EN.StopApp( ApplicationName );
	    EN.EndTest();
  }

  
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tcVerifyValueREGX_Fail_OKWVerifyingFailsException() throws Exception
  {
	    EN.BeginTest( TestName );
	    EN.StartApp( ApplicationName );
	    EN.TypeKey( "URL", "http://test.openkeyword.de/InputRadioButton/input_type-radio.htm" );

	    EN.SelectWindow( "SeRadioList" );
	    
	    EN.Select( "Pay Method", "American Express" );
	    EN.VerifyValueREGX( "Pay Method", "Vis.*" );

	    EN.StopApp( ApplicationName );

	    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
	    {
	        EN.EndTest();
	    });
  }
}

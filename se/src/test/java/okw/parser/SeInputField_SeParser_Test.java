/*
 ==============================================================================
 Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.parser;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.core.OKWTestBase;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Disabled
public class SeInputField_SeParser_Test extends OKWTestBase{

  protected OKW_Memorize_Sngltn     myMem = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tc_ALT_a_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "UNPRESSED" );    

    
    EN.TypeKey( "Testarea", "#{ALT+a}" );
    EN.SetFocus( "Reset" );

    // Verify Buttons UNPRESSED
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "PRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tc_CTRL_b_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons Start with all are UNPRESSED
    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "S" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "B" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    EN.TypeKey( "Testarea", "#{SHIFT+c}" );
    EN.SetFocus( "Reset" );
    
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "PRESSED" );

    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" ); // Pressed Button

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Delete" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "C" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tc_SHUFT_c_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "UNPRESSED" );    

    
    EN.TypeKey( "Testarea", "#{ALT+a}" );
    EN.SetFocus( "Reset" );

    // Verify Buttons UNPRESSED
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "PRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

/**
   * SeTextField -> InputTypeText
   * InputTypeText.htm -> InputTypeText.htm
   * Vorame -> First Name
   * Name -> Last Name
   */
  
  /**
   * Testet das Schlüsselwort LogExists( FN ) eines SeInputField Prüfen.
   */ 
  @Test
  public void tc_AltCtrlCommend_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    
    EN.SetValue("Button", "Delete" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    EN.TypeKey( "Testarea", "#{ALT+CTRL+COMMAND+DELETE}" );
    EN.SetFocus( "Reset" );
    
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "PRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "PRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" ); // UNPRESSDE
    
    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "PRESSED" );

    EN.SetValue("Button", "Delete" );
    EN.VerifyValue( "Button", "PRESSED" );

  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

/**
   * Einzelner Buchstabe "c" wird eingegeben, keine Verwendung von "Modifier Tasten".
   */ 
  @Test
  public void tc_c_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons Start with all are UNPRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "B" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    // ===============================================
    // Eingabe/INPUT
    // ===============================================
    EN.TypeKey( "Testarea", "c" );

    // ===============================================
    // Prüfung
    // ===============================================
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" ); // Pressed Button

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "C" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
  
  /**
   * Einzelner Buchstabe "c" wird eingegeben, keine Verwendung von "Modifier Tasten".
   */ 
  @Test
  public void tc_absdef_Test() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons Start with all are UNPRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    EN.SetValue("Button", "B" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    EN.SetValue("Button", "C" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    EN.SetValue("Button", "D" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    EN.SetValue("Button", "E" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    // ===============================================
    // Eingabe/INPUT
    // ===============================================
    EN.TypeKey( "Testarea", "abcde" );

    // ===============================================
    // Prüfung
    // ===============================================
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" ); // Pressed Button

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "PRESSED" );
    EN.SetValue("Button", "B" );
    EN.VerifyValue( "Button", "PRESSED" );
    EN.SetValue("Button", "C" );
    EN.VerifyValue( "Button", "PRESSED" );
    EN.SetValue("Button", "D" );
    EN.VerifyValue( "Button", "PRESSED" );
    EN.SetValue("Button", "E" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

/**
   * Prüft die Eingabe von Umgebungsvariablen.
   * 
   * Hintergrund: Umgebungsvariablen werden vom Core-Parser aufgelöst.
   * Das erfolgt im Jeweiligen Core Schlüsselwort und nicht im GUI Adater (z.B. SeInputText).
   * 
   * Hinweis: Dieser Testfall Hat einen nicht regelkonfomen Namen weil mit ${TCN}
   * genau dieser name für die Prüfung der Gedrückten Tasten harangenommen wird. 
   * 
   */ 
  @Test
  public void a() throws Exception {

    EN.BeginTest( TestName );
    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "https://www.keyboardtester.com/tester.html" );

    EN.SelectWindow( "Keyboard Tester" );
    EN.ClickOn( "Reset" );

    // Verify Buttons Start with all are UNPRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "UNPRESSED" );    
    
    // ===============================================
    // Eingabe/INPUT
    // ===============================================
    EN.TypeKey( "Testarea", "${TCN}" );

    // ===============================================
    // Prüfung
    // ===============================================
    // Verify Buttons PRESSED
    EN.SetValue("Button", "Alt" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "Ctrl" );
    EN.VerifyValue( "Button", "UNPRESSED" ); // Pressed Button

    EN.SetValue("Button", "Win" );
    EN.VerifyValue( "Button", "UNPRESSED" );

    EN.SetValue("Button", "Shift" );
    EN.VerifyValue( "Button", "UNPRESSED" );
    
    EN.SetValue("Button", "A" );
    EN.VerifyValue( "Button", "PRESSED" );
  
    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
}


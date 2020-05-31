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

package okw.core;

import okw.OKW_TestClipboard;
import okw.core.EN;
import okw.exceptions.OKWNotAllowedValueException;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreTests")
public class EN_OKWNotAllowedValueException_Test {

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  public String TestName;

  @BeforeEach
  void init(TestInfo testInfo)
  {
      TestName = testInfo.getTestMethod().get().getName();
  }

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

    // Reset/init the Logger
    Logger_Sngltn.init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  LFC-VerifyExists ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test //  // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyExists_OKWNotAllowedValueException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyExists( "IsNotDefindeInRechner", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }
 
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  LFC-VerifyIsActive ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test //  // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyHasFocus_OKWNotAllowedValueException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyHasFocus( "IsNotDefindeInRechner", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  LFC-VerifyIsActive ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test //  // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyHasFocus_OKWNotAllowedValueException_2() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    
    EN.VerifyHasFocus( "All_MethodsObj", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  LFC-VerifyIsActive ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyIsActive_OKWNotAllowedValueException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyIsActive( "IsNotDefindeInRechner", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMaxLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMaxLength_OKWNotAllowedValueException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "IsNotDefindeInRechner", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMaxLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMaxLength_OKWNotAllowedValueException_2() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "All_MethodsObj", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMaxLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMaxLength_OKWNotAllowedValueException_3() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "All_MethodsObj", " 1" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMaxLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMaxLength_OKWNotAllowedValueException_4() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "All_MethodsObj", "1,03" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }
  
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMinLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMinLength_OKWNotAllowedValueException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMinLength( "IsNotDefindeInRechner", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMinLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMinLength_OKWNotAllowedValueException_2() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMinLength( "All_MethodsObj", "Bandersnatch" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMinLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMinLength_OKWNotAllowedValueException_3() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMinLength( "All_MethodsObj", " 1" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWNotAllowedValueException durch die
   *  VerifyMinLength(String, String) ausgelöst wird, wenn das Frame-Kindobjekt vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test // ( expected = OKWNotAllowedValueException.class )
  public void TC_VerifyMinLength_OKWNotAllowedValueException_4() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMinLength( "All_MethodsObj", "1,03" );
    
    Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
  }
}

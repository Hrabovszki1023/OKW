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
import okw.exceptions.OKWFrameObjectChildNotFoundException;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreTests")
public class EN_OKWFrameObjectChildNotFoundException_Test {

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

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch ClickOn
   *  ausgelöst wird, wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_ClickOn_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.ClickOn( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }


  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch SelectMenu
   *  ausgelöst wird, wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_SelectMenu_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SelectMenu( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch DoubleClickOn()
   *  ausgelöst wird, wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void tc_DoubleClickOn_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.DoubleClickOn( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  
  /** \~german
   *   Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *   LFC-Select ausgelöst wird, wenn das Kinobjekt nicht vorhanden ist.
   *  
   *   \~english
   *   \~
   *   \author Zoltan Hrabovszki
   *   \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_Select_OKWFrameObjectChildNotFoundException()
      throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.Select( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch SetFocus
   *  ausgelöst wird, wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_SetFocus_OKWFrameObjectChildNotFoundException()
      throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetFocus( "IsNotDefindeInRechner" );
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }


  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogCaption(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogCaption_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogCaption( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  } 
  

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogExists(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogExists_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogExists( "IsNotDefindeInRechner" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  } 
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogHasFocus(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogHasFocus_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogHasFocus( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  } 
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogIsActive(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogIsActive_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogIsActive( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }   
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogLabel(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogLabel_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogLabel( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }   
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogPlaceholder(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogPlaceholder_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogPlaceholder( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogSelected(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogSelected_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogSelected( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogTablecellValue(String,String,String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogTablecellValue_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogTablecellValue( "IsNotDefindeInRechner", "1", "1" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogTooltip(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogTooltip_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogTooltip( "IsNotDefindeInRechner" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.LogValue(String) ausgelöst wird,
   *  wenn das Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_LogValue_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.LogValue( "IsNotDefindeInRechner" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeCaption(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeCaption_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeCaption( "IsNotDefindeInRechner", "Key" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeExists(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeExists_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeExists( "IsNotDefindeInRechner", "Key" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }  

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeHasFocus(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeHasFocus_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeHasFocus( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }    

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.IsActive(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_IsActive_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeIsActive( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }    

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeLabel(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeLabel_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeLabel( "IsNotDefindeInRechner", "Key" );
    
    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }    

  /**
   *  \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch MemorizePlaceholder
   *  ausgelöst wird, wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizePlaceholder_OKWFrameObjectChildNotFoundException()
      throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizePlaceholder( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeTablecellValue(String,String,String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeTablecellValue_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeTablecellValue( "IsNotDefindeInRechner", "1", "1", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeTooltip(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeTooltip_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeTooltip( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeSelectedValue(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeSelectedValue_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeSelectedValue( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.MemorizeValue(String,String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_MemorizeValue_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.MemorizeValue( "IsNotDefindeInRechner", "Key" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  

  /**
   *  \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException
   *  durch okw.core.OK.SelectChild(String) ausgelöst wird,
   *  wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2019-11-22
  */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_SelectChild_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SelectChild( "IsNotDefindeInRechner" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  
  /**
   *  \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-SetValue ausgelöst wird, wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_SetValue_OKWFrameObjectChildNotFoundException()
      throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.SetValue( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }


  /** 
   *  \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-TypeKey ausgelöst wird, wenn das Kinobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_TypeKey_OKWFrameObjectChildNotFoundException()
      throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.TypeKey( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyCaption_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyCaption( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyCaptionWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyCaptionWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyCaptionREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyCaptionREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

    /**
     * \~german
     *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
     *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2016.05.07
     */
    @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
    public void TC_VerifyLabel_OKWFrameObjectChildNotFoundException() throws Exception
    {
        EN.BeginTest( TestName );

        EN.SelectWindow( "Rechner" );

        EN.VerifyLabel( "IsNotDefindeInRechner", "Value" );

        Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
        {
            EN.EndTest();
        });    
    }
  
  /**
   * \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyLabelWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyLabelWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft, ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyLabelREGX ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  Checks whether the OKWFrameObjectChildNotFoundException exception is raised
   *  by the LFC VerifyLabelREGX if the frame child object does not exist.
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyLabelREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyLabelREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft, ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyMaxLength ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  Checks whether the OKWFrameObjectChildNotFoundException exception is raised
   *  by the LFC VerifyMaxLength if the frame child object does not exist.
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyMaxLength_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyMaxLength( "IsNotDefindeInRechner", "2" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyPlaceholder ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyPlaceholder_OKWFrameObjectChildNotFoundException() throws Exception
  {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyPlaceholder( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  /**
   * \~german
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyPlaceholder ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyPlaceholderWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyPlaceholderWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyCaption ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyPlaceholderREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyPlaceholderREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyExists ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyExists_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyExists( "IsNotDefindeInRechner", "YES" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  
    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
     *  LFC-VerifyHasFocus ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2016.05.07
     */
    @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
    public void TC_VerifyHasFocus_OKWFrameObjectChildNotFoundException() throws Exception
    {
        EN.BeginTest( TestName );

        EN.SelectWindow( "Rechner" );

        EN.VerifyHasFocus( "IsNotDefindeInRechner", "YES" );

        Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
        {
            EN.EndTest();
        });    
    }  

  
    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
     *  LFC-VerifyIsActive ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2016.05.07
     */
    @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
    public void TC_VerifyIsActive_OKWFrameObjectChildNotFoundException() throws Exception
    {
        EN.BeginTest( TestName );

        EN.SelectWindow( "Rechner" );

        EN.VerifyIsActive( "IsNotDefindeInRechner", "YES" );

        Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
        {
            EN.EndTest();
        });    
    }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyTooltip_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltip( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyTooltipWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltipWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyTooltipREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltipREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyValue_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValue( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyValueWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValueWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyValueREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValueREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifyTablecellValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyTabelcellValue_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTablecellValue( "IsNotDefindeInRechner", "X", "Y", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifyTablecellValueWCM ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyTablecellValueWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTablecellValueWCM( "IsNotDefindeInRechner", "x", "Y", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifyTablecellValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TCVerifyTablecellValueREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTablecellValueREGX( "IsNotDefindeInRechner", "X", "Y", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifySelected ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifySelectedValue_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValue( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifySelectedValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifySelectedWCM_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValueWCM( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  VerifySelectedValue ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifySelectedValueREGX_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValueREGX( "IsNotDefindeInRechner", "Value" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
  
  /**
   * \~german
   *  \brief
   *  Prüft, ob die Ausnahme OKWFrameObjectChildNotFoundException durch die
   *  LFC-VerifyMinLength ausgelöst wird, wenn das Frame-Kindobjekt nicht vorhanden ist.
   * 
   *  \~english
   *  Checks whether the OKWFrameObjectChildNotFoundException exception is raised
   *  by the LFC VerifyMinLength if the frame child object does not exist.
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2018.06.18
   */
  @Test// ( expected = OKWFrameObjectChildNotFoundException.class )
  public void TC_VerifyMinLength_OKWFrameObjectChildNotFoundException() throws Exception {
    EN.BeginTest( TestName );

    EN.SelectWindow( "Rechner" );

    EN.VerifyMinLength( "IsNotDefindeInRechner", "2" );

    Assertions.assertThrows( OKWFrameObjectChildNotFoundException.class, () ->
    {
        EN.EndTest();
    });    
  }
}

//  OKW__Test__AllMethodCalls.cs
//
//  Author:
//       zoltan <${AuthorEmail}>
//
//  Copyright(c) 2012 zoltan
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package okw.core;

import static org.junit.Assert.*;
import okw.OKW_TestClipboard;
import okw.exceptions.OKWNotAllowedValueException;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_Keywords_Empty_Test {

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    // Reset des Loggers: Alle Geladenen Instanzen löschen
    Logger_Sngltn.Init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer vor jedem Test(fall) ausgeführt.
  // /
  @Before
  public void setUp() throws Exception {

  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer nach jedem Test(fall) ausgeführt.
  // /
  @After
  public void tearDown() throws Exception {
    EN.EndTest();
  }

  
  /**
   * \~german
   * \brief
   * 
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_SetValue_SV() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.SetValue( "All_MethodsObj", "${DELETE}" );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SetValue()", myClipBoard.getMethod() );
  }

  
  /**
   * \~german
   * \brief
   * 
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_TypeKey_SV() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.TypeKey( "All_MethodsObj", "${DELETE}" );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
  }


  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaption(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyCaption_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyCaption("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    // assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyCaption()", myClipBoard.getMethod());
  }
 
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaptionREGX(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyCaptionREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyCaptionREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyCaption()", myClipBoard.getMethod());
  }

  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaptionWCM(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyCaptionWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyCaptionWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyCaption()", myClipBoard.getMethod());

  }

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifySelectedValue(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifySelectedValue_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifySelectedValue( "All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    // assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifySelectedValue()", myClipBoard.getMethod());
  }
 
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifySelectedValueREGX(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifySelectedValueREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifySelectedValueREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifySelectedValue()", myClipBoard.getMethod());
  }


  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaptionWCM(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifySelectedValueWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifySelectedValueWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifySelectedValue()", myClipBoard.getMethod());

  }  
  

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaption(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabel_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyLabel("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyLabel()", myClipBoard.getMethod());
  }
 
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaption(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabelREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyLabelREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyLabel()", myClipBoard.getMethod());

  }

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyCaption(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabelWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyLabelWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyLabel()", myClipBoard.getMethod());

  }

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyTooltip_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTooltip("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTooltip()", myClipBoard.getMethod());
  }
  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyTooltipREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTooltipREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    // assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTooltip()", myClipBoard.getMethod());
  }
  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyTooltipWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTooltipWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTooltip()", myClipBoard.getMethod());
  }
  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyTablecellValue_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTablecellValue("All_MethodsObj_VerifyEmpty", "X", "Y", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }
  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyVTablecellalueREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTablecellValueREGX("All_MethodsObj_VerifyEmpty", "X", "Y", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );

    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }
  
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyTablecellValueWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyTablecellValueWCM("All_MethodsObj_VerifyEmpty", "X", "Y", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test( expected = OKWNotAllowedValueException.class )
  public void tc_VerifyExists_EMPTY_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
  
    EN.SelectWindow( "Rechner" );
    EN.VerifyExists( "All_MethodsObj", "${EMPTY}" );
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test( expected = OKWNotAllowedValueException.class )
  public void tc_VerifyIsActive_EMPTY_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
  
    EN.SelectWindow( "Rechner" );
    EN.VerifyIsActive( "All_MethodsObj", "${EMPTY}" );
  }

/**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyValue_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyValue("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }

/**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyValueREGX_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyValueREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );

    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }

/**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsselwort VerifyValue(string,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyValueWCM_Empty() throws Exception {

    EN.BeginTest( name.getMethodName() );

    // Löschen des Clipboards
    myClipBoard.Clear();

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Löschen des Clipboards
    myClipBoard.Clear();
    
    EN.VerifyValueWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyValue()", myClipBoard.getMethod());
  }
}

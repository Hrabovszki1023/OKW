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

import static org.junit.Assert.*;
import okw.OKW_TestClipboard;
import okw.exceptions.OKWNotAllowedValueException;
import okw.log.Logger_Sngltn;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EN_Keywords_Empty_Test {

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    // Reset des Loggers: Alle Geladenen Instanzen löschen
    Logger_Sngltn.init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
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
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SetValue()", myClipBoard.getMethod() );
    
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
 }  
  

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyLabel(strng,string)
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

    EN.EndTest();
  }
 
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyLabel(strng,string)
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

    EN.EndTest();
   }

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyLabel(strng,string)
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

    EN.EndTest();
  }
  

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyPlaceholder(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyPlaceholder_Empty() throws Exception {

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
    
    EN.VerifyPlaceholder("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyPlaceholder()", myClipBoard.getMethod());

    EN.EndTest();
  }
 
  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyPlaceholder(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyPlaceholderREGX_Empty() throws Exception {

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
    
    EN.VerifyPlaceholderREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyPlaceholder()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /**
   *  \~german
   *  \brief
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyPlaceholder(strng,string)
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyPlaceholderWCM_Empty() throws Exception {

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
    
    EN.VerifyPlaceholderWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyPlaceholder()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /** \~german
   * EMPTY ist ein nicht erlaubter Wert im Schlüsselwort EN.VerifyMaxLength(String,String).
   *
   * Dieser Test Prüft, ob die Ausnahmen OKWNotAllowedValueException ausgelöst wird.
   * 
   * \~english
   * EMPTY is an illegal value in the keyword EN.VerifyMaxLength(String,String).
   * 
   * This test verifies whether the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.12.26
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tc_VerifyMaxLength_EMPTY_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
  
    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "All_MethodsObj", "${EMPTY}" );

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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
    EN.SetValue( "All_MethodsObj", "${DELETE}" );
    EN.VerifyTablecellValue("All_MethodsObj", "X", "Y", "${EMPTY}");
    
    assertEquals( 3, myClipBoard.getValue().size() );
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals( "X", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Y", myClipBoard.getValue().get( 2 ) );    
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTablecellValue()", myClipBoard.getMethod());

    EN.EndTest();
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
  public void tc_VerifyTablecellValueREGX_Empty() throws Exception {

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
    EN.SetValue( "All_MethodsObj", "${DELETE}" );
    EN.VerifyTablecellValueREGX("All_MethodsObj", "X", "Y", "${EMPTY}");
    
    assertEquals( 3, myClipBoard.getValue().size() );
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals( "X", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Y", myClipBoard.getValue().get( 2 ) );    
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTablecellValue()", myClipBoard.getMethod());

    EN.EndTest();
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
    EN.SetValue( "All_MethodsObj", "${DELETE}" );
    EN.VerifyTablecellValueWCM("All_MethodsObj", "X", "Y", "${EMPTY}");
    
    assertEquals( 3, myClipBoard.getValue().size() );
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals( "X", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Y", myClipBoard.getValue().get( 2 ) );    
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyTablecellValue()", myClipBoard.getMethod());

    EN.EndTest();
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

    EN.EndTest();
  }

  /** \~german
   * EMPTY ist ein nicht erlaubter Wert im Schlüsselwort EN.VerifyIsActive(String,String).
   *
   * Dieser Test Prüft, ob die Ausnahmen OKWNotAllowedValueException ausgelöst wird.
   * 
   * \~english
   * EMPTY is an illegal value in the keyword EN.VerifyIsActive(String,String).
   * 
   * This test verifies whether the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author Zoltan Hrabovszki
   * \date 2016.09.24
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tc_VerifyIsActive_EMPTY_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
  
    EN.SelectWindow( "Rechner" );
    EN.VerifyIsActive( "All_MethodsObj", "${EMPTY}" );

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
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

    EN.EndTest();
  }
  

  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyBadge(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyBadge(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \date 2019.03.28
   */
  @Test
  public void tc_VerifyBadge_Empty() throws Exception {

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
    
    EN.VerifyBadge("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyBadge()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyBadge(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyBadge(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \date 2019.04.11
   */
  @Test
  public void tc_VerifyBadgeREGX_Empty() throws Exception {

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
    
    EN.VerifyBadgeREGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyBadge()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyBadge(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyBadge(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \date 2019.04.11
   */
  @Test
  public void tc_VerifyBadgeWCM_Empty() throws Exception {

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
    
    EN.VerifyBadgeWCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyBadge()", myClipBoard.getMethod());

    EN.EndTest();
  }
  
  /** \~german
   * EMPTY ist ein nicht erlaubter Wert im Schlüsselwort EN.VerifyMinLength(String,String).
   *
   * Dieser Test Prüft, ob die Ausnahmen OKWNotAllowedValueException ausgelöst wird.
   * 
   * \~english
   * EMPTY is an illegal value in the keyword EN.VerifyMinLength(String,String).
   * 
   * This test verifies whether the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author daniel KRüger
   * \date 2019.06.18
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tc_VerifyMinLength_EMPTY_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
  
    EN.SelectWindow( "Rechner" );
    EN.VerifyMinLength( "All_MethodsObj", "${EMPTY}" );

    EN.EndTest();
  }
  
  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyErrorMSG(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyErrorMSG(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \date 2019.05.31
   */
  @Test
  public void tc_VerifyErrorMSG_Empty() throws Exception {

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
    
    EN.VerifyErrorMSG("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyErrorMSG()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyBadge(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyBadge(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \date 2019.05.31
   */
  @Test
  public void tc_VerifyErrorMSG_REGX_Empty() throws Exception {

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
    
    EN.VerifyErrorMSG_REGX("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyErrorMSG()", myClipBoard.getMethod());

    EN.EndTest();
  }

  /**
   *  \~german
   *  Prüft "${EMPTY}" für das Schlüsslewort VerifyErrorMSG_WCM(string,string)
   * 
   *  \~english
   *  Checks "${EMPTY}" for the keyword VerifyErrorMSG_WCM(string,string)
   *  
   *  \~
   *  \author Daniel Krüger
   *  \\date 2019.05.31
   */
  @Test
  public void tc_VerifyErrorMSG_WCM_Empty() throws Exception {

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
    
    EN.VerifyErrorMSG_WCM("All_MethodsObj_VerifyEmpty", "${EMPTY}");
    
    assertEquals( 0, myClipBoard.getValue().size() );
    //assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
    assertEquals("VerifyErrorMSG()", myClipBoard.getMethod());

    EN.EndTest();
  }
}

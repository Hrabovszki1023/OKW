/*
    ==============================================================================
    Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_Keywords_DELETE_Test
{

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    // Reset des Loggers: Alle Geladenen Instanzen löschen
    Logger_Sngltn.init();
    // myLogger.AddLogger(new Log2Console());

    myLogger.setDebugMode( false );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer vor jedem Test(fall) ausgeführt.
  // /
  @Before
  public void setUp() throws Exception
  {

  }

  // / \~german
  // / \brief
  // / Diese Methode wird immer nach jedem Test(fall) ausgeführt.
  // /
  @After
  public void tearDown() throws Exception
  {
    EN.EndTest();
  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeCaption(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeCaption_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeCaption( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeCaption(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeCaption_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeCaption( "All_MethodsObj", "abc${DELETE}abc" );

  }

  // \~german
  // \brief
  // Prüft "${DELETE}" für das Schlüsslewort MemorizeExists(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeExists_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeExists( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "${DELETE}" mit zusätzlichen Zeichen für das Schlüsslewort
  // MemorizeExists(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeExists_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeExists( "All_MethodsObj", "abc${DELETE}efg" );
  }

  // \~german
  // \brief
  // Prüft "${DELETE}" für das Schlüsselwort MemorizeHasFocus(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeHasFocus_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeHasFocus( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "${DELETE}" mit zusätzlichen Zeichen für das Schlüsselwort
  // MemorizeHasFocus(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeHasFocus_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeHasFocus( "All_MethodsObj", "abc${DELETE}efg" );
  }

  // \~german
  // \brief
  // Prüft "${DELETE}" für das Schlüsselwort MemorizeIsActive(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeIsActive_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeIsActive( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "${DELETE}" mit zusätzlichen Zeichen für das Schlüsselwort
  // MemorizeIsActive(strng,string).
  //
  // "${DELETE}" ist ein nicht erlaubter Wert und muss die Ausnamhme
  // OKWNotAllowedValueException auslösen.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeIsActive_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeIsActive( "All_MethodsObj", "abc${DELETE}efg" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeLabel(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeLabel_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeLabel( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeLabel(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeLabel_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeLabel( "All_MethodsObj", "abc${DELETE}abc" );

  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeSelectedValue(strng,string) ob
  // die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeSelectedValue_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeSelectedValue( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeSelectedValue(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeSelectedValue_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeSelectedValue( "All_MethodsObj", "abc${DELETE}abc" );

  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeTablecellValue(strng,string)
  // ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeTablecellValue_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeTablecellValue( "All_MethodsObj", "1", "2", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeTablecellValue(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeTablecellValue_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeTablecellValue( "All_MethodsObj", "1", "2", "abc${DELETE}abc" );

  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeTooltip(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeTooltip_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeTooltip( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeTooltip(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeTooltip_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeTooltip( "All_MethodsObj", "abc${DELETE}abc" );

  }

  // \~german
  // \brief
  // Prüft "DELETE" für das Schlüsselwort MemorizeValue(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeValue_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeValue( "All_MethodsObj", "${DELETE}" );
  }

  // \~german
  // \brief
  // Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
  // MemorizeValue(strng,string) ob die
  // Ausname OKWNotAllowedValueException ausgelöst wird.
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.23
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizeValue_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizeValue( "All_MethodsObj", "abc${DELETE}abc" );

  }

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tcSelectMenu_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    
    EN.SelectMenu( "All_MethodsObj", "${DELETE}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectMenu(ArrayList<String>)", myClipBoard.getMethod() );

  }

  /**
   *  \~german
   * \brief
   * 
   *
   * \~english
   * \~
   * \author Zoltan Hrabovszki
   * \date 2013.12.26
   */
  @Test
  public void tcSelectMenu_Value_MV_DELETE_EmptyString() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    EN.SelectMenu( "All_MethodsObj", "${DELETE}${SEP}Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectMenu(ArrayList<String>)", myClipBoard.getMethod() );
    assertEquals( 2, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Value", myClipBoard.getValue().get( 1 ) );

  }

  // \~german
  // \brief
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2013.12.26
  @Test
  public void tcSelectMenu_Value_SV_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    EN.SelectMenu( "All_MethodsObj", "${DELETE}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectMenu(ArrayList<String>)", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
  }



  // / \~german
  // / \brief
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2016.09.24
  @Test
  public void tcSelect_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    myClipBoard.Clear();

    EN.Select( "All_MethodsObj", "${DELETE}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "Select()", myClipBoard.getMethod() );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
  }

  // / \~german
  // / \brief
  // / Prüft den Methodenaufruf Select mit einem einzelnen Wert.
  // / Prüft Ziel es darf nur ein Wert im List of string übergabe Parameter
  // enthalten sein.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tcSelect_DELETE_MV() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    myClipBoard.Clear();

    EN.Select( "All_MethodsObj", "${DELETE}${SEP}Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "Select()", myClipBoard.getMethod() );

    assertEquals( 2, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Value", myClipBoard.getValue().get( 1 ) );

  }

  // \~german
  // \brief
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2013.12.26
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcSequence_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.SelectWindow( "Rechner" );
    EN.Sequence( "Rechner", "TestSequence", "${DELETE}" );
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcSetValue_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    EN.SetValue( "All_MethodsObj", "${DELETE}" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SetValue()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "", myClipBoard.getValue().get( 0 ) );

  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcSetValue_DELETE_MV() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    EN.SetValue( "All_MethodsObj", "${DELETE}${SEP}Value" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SetValue()", myClipBoard.getMethod() );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    //assertEquals( "Value", myClipBoard.getValue().get( 1 ) );
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcTypeKeyTablecell_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    myClipBoard.Clear();
    EN.TypeKeyTablecell( "All_MethodsObj", "1", "2", "${DELETE}" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "TypeKeyTablecell(String COL, String ROW, List<String> Values)", myClipBoard.getMethod() );
    assertEquals( 3, myClipBoard.getValue().size() );
    assertEquals( "1", myClipBoard.getValue().get( 0 ) );
    assertEquals( "2", myClipBoard.getValue().get( 1 ) );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 2 ) );
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcTypeKeyTablecell_DELETE_MV() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    myClipBoard.Clear();
    EN.TypeKeyTablecell( "All_MethodsObj", "1", "2", "${DELETE}${SEP}Value" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "TypeKeyTablecell(String COL, String ROW, List<String> Values)", myClipBoard.getMethod() );

    assertEquals( 4, myClipBoard.getValue().size() );
    assertEquals( "1", myClipBoard.getValue().get( 0 ) );
    assertEquals( "2", myClipBoard.getValue().get( 1 ) );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 2 ) );
    assertEquals( "Value", myClipBoard.getValue().get( 3 ) );
  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcTypeKey_DELETE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    myClipBoard.Clear();
    EN.TypeKey( "All_MethodsObj", "${DELETE}" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );

  }

  // \~german
  // \brief
  //
  //
  // \~english
  // \~
  // \author Zoltan Hrabovszki
  // \date 2016.09.24
  @Test
  public void tcTypeKey_DELETE_MV() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    EN.TypeKey( "All_MethodsObj", "${DELETE}${SEP}Value" );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );

    assertEquals( 2, myClipBoard.getValue().size() );
    assertEquals( "${DELETE}", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Value", myClipBoard.getValue().get( 1 ) );
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
  public void tcVerifyCaption_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyCaption( "All_MethodsObj", "${DELETE}" );

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
  public void tcVerifyCaptionREGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.SelectWindow( "Rechner" );

    EN.VerifyCaptionREGX( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyCaptionWCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyCaptionWCM( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyLabel_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyLabel( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyLabelREGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyLabelREGX( "All_MethodsObj", "${DELETE}" );

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
  public void tcVerifyLabelWCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyLabelWCM( "All_MethodsObj", "${DELETE}" );
  }

  /** \~german
   * DELETE ist ein nicht erlaubter Wert im Schlüsselwort EN.VeryfyMaxLength(String,String).
   *
   * Dieser Test Prüft, ob die Ausnahmen OKWNotAllowedValueException ausgelöst wird.
   * 
   * \~english
   * DELETE is an illegal value in the keyword EN.VeryfyMaxLength(String,String).
   * 
   * This test verifies whether the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.12.26
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifyMaxLength_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyMaxLength( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyExists_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyExists( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyHasFocus_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.SelectWindow( "Rechner" );

    EN.VerifyHasFocus( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyIsActive_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyIsActive( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifySelectedValue_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValue( "All_MethodsObj", "${DELETE}" );

  }

  /** \~german
  *
  *
  * \~english
  * \~
  * @author Zoltan Hrabovszki
  * @date 2017-05-21
  */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifySelectedValueREGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValueREGX( "All_MethodsObj", "${DELETE}" );

  }

  /** \~german
  *
  *
  * \~english
  * \~
  * @author Zoltan Hrabovszki
  * @date 2017-05-21
  */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifySelectedValueWCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifySelectedValueWCM( "All_MethodsObj", "${DELETE}" );

  }

  
  /** \~german
   *
   *
   * \~english
   * \~
   * @author Zoltan Hrabovszki
   * @date 2016-09-24
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifyTablecellValue_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row", "${DELETE}" );

  }

  /** \~german
  *
  *
  * \~english
  * \~
  * @author Zoltan Hrabovszki
  * @date 2017-05-21
  */
 @Test( expected = OKWNotAllowedValueException.class )
 public void tcVerifyTablecellValueREGX_DELETE_OKWNotAllowedValueException() throws Exception
 {
   EN.BeginTest( name.getMethodName() );

   EN.SelectWindow( "Rechner" );

   EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "${DELETE}" );

 }

 /** \~german
 *
 *
 * \~english
 * \~
 * @author Zoltan Hrabovszki
 * @date 2016-09-24
 */
@Test( expected = OKWNotAllowedValueException.class )
public void tcVerifyTablecellValueWCM_DELETE_OKWNotAllowedValueException() throws Exception
{
  EN.BeginTest( name.getMethodName() );

  EN.SelectWindow( "Rechner" );

  EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "${DELETE}" );

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
  public void tcVerifyTooltip_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltip( "All_MethodsObj", "${DELETE}" );

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
  public void tcVerifyTooltipREGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltipREGX( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyTooltipWCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyTooltipWCM( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyValue_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValue( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyValueREGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValueREGX( "All_MethodsObj", "${DELETE}" );
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
  public void tcVerifyValueWCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyValueWCM( "All_MethodsObj", "${DELETE}" );

  }

  /* \~german
   * Prüft "DELETE" mit zusätlich Zeichen für das Schlüsselwort
   * MemorizePlaceholder(strng,string) ob die
   * Ausname OKWNotAllowedValueException ausgelöst wird.
   *
   * \~english
   * Checks "DELETE" for the keyword MemorizePlaceholder(strng,string)
   * if the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.10.05
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizePlaceholder_DELETE_2_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizePlaceholder( "All_MethodsObj", "abc${DELETE}abc" );

  }

  /* \~german
   * Prüft "DELETE" für das Schlüsselwort MemorizePlaceholder(strng,string) ob die
   * Ausname OKWNotAllowedValueException ausgelöst wird.
   *
   * \~english
   * Checks "DELETE" for the keyword MemorizePlaceholder(strng,string)
   * if the exception OKWNotAllowedValueException is thrown.
   * \~
   * \author Zoltan Hrabovszki
   * \date 2018.10.04
   */
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcMemorizePlaceholder_DELETE_OKWNotAllowedValueException() throws Exception
  {

    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.MemorizePlaceholder( "All_MethodsObj", "${DELETE}" );
  }
  
  /* \~german
  * Prüft "DELETE" für das Schlüsselwort VerifyErrorMSG(strng,string) ob die
  * Ausname OKWNotAllowedValueException ausgelöst wird.
  *
  * \~english
  * Checks "DELETE" for the keyword VerifyErrorMSG(strng,string)
  * if the exception OKWNotAllowedValueException is thrown.
  * \~
  *author Daniel Krüger
  *\date 2018.04.04
  */ 
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifyErrorMSG_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyErrorMSG( "All_MethodsObj", "${DELETE}" );

  }
  /* \~german
  * Prüft "DELETE" für das Schlüsselwort VerifyErrorMSG_REGX(strng,string) ob die
  * Ausname OKWNotAllowedValueException ausgelöst wird.
  *
  * \~english
  * Checks "DELETE" for the keyword VerifyErrorMSG_REGX(strng,string)
  * if the exception OKWNotAllowedValueException is thrown.
  * \~
  *author Daniel Krüger
  *\date 2019.05.31
  */ 
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifyErrorMSG_REGX_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    EN.VerifyErrorMSG_REGX( "All_MethodsObj", "${DELETE}" );

  }

  /* \~german
   * Prüft "DELETE" für das Schlüsselwort VerifyErrorMSG_WCM(strng,string) ob die
   * Ausname OKWNotAllowedValueException ausgelöst wird.
   *
   * \~english
   * Checks "DELETE" for the keyword VerifyErrorMSG_WCM(strng,string)
   * if the exception OKWNotAllowedValueException is thrown.
   * \~
   *author Daniel Krüger
   *\date 2019.05.31
   */ 
  @Test( expected = OKWNotAllowedValueException.class )
  public void tcVerifyErrorMSG_WCM_DELETE_OKWNotAllowedValueException() throws Exception
  {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyErrorMSG_WCM ( "All_MethodsObj", "${DELETE}" );
  }

}

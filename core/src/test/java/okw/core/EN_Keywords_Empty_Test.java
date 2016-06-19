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
import org.omg.CORBA.SystemException;

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

  // / \~german
  // / \brief
  // / Prüft "IGNORIEREN" für das Schlüsslewort MemorizeCaption(strng,string)
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
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
    
    EN.VerifyValue("Anzeige", "${EMPTY}");
    
    assertEquals( "", myClipBoard.getValue().get( 0 ) );
    assertEquals("Test_Textfield", myClipBoard.getObjectName());
    assertEquals("VerifyValue(ArrayList<String> fplsExpectedValue)", myClipBoard.getMethod());

  }
}

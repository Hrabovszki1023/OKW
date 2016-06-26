/** 
 *  OKW__Test__AllMethodCalls.cs
 *
 *  Author:
 *       zoltan <${AuthorEmail}>
 *
 *  Copyright(c) 2012, 2013, 2014, 2015, 2016 zoltan
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package okw.core;

import okw.OKW_TestClipboard;
import okw.exceptions.OKWFrameObjectMethodNotFoundException;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_OKWFrameObjectMethodNotFoundException_Test {

  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

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
    // EN.BeginTest( "TestContext.CurrentContext.Test.Name" );
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
  // / Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
  // SelectWindow ausgelöst wird.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2016.05.07
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_Select_Window_OKWFrameObjectMethodNotFoundException_Test()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "WindowWithoutMethods" );
  }

  
  /**
   *  \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  SelectWindow ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_ClickOn_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.ClickOn( "NoMethodObj" );
  }

  
  /**
   *  \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  SelectWindow ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_ClickOn_ClickType_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.ClickOn( "NoMethodObj", "DOUBLECLICK" );
  }

  
  /**
   * \~german \brief Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException
   * von SelectWindow ausgelöst wird.
   * 
   * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_Select_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.Select( "NoMethodObj", "NoValue" );
  }

  /**
   * \~german \brief Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException
   * von SelectWindow ausgelöst wird.
   * 
   * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_TypeKey_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.TypeKey( "NoMethodObj", "NoValue" );
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  StartApp ausgelöst wird, wenn die Methode StartApp im 
   *  Window-GUI-Adapter nicht definiert ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.06.18
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void tc_StartApp_OKWFrameObjectMethodNotFoundException_Test()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.StartApp( "WindowWithoutMethods" );
  }

  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  StopApp ausgelöst wird, wenn die Methode StopApp im 
   *  Window-GUI-Adapter nicht definiert ist.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.06.18
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void tc_StopApp_OKWFrameObjectMethodNotFoundException_Test()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.StopApp( "WindowWithoutMethods" );
  }

  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  VerifyExists ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_VerifyExists_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyExists( "NoMethodObj", "YES" );
  }
  
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  VerifyIsActive ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_VerifyHasFocus_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyHasFocus( "NoMethodObj", "YES" );
  }

  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  VerifyIsActive ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_VerifyIsActive_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyIsActive( "NoMethodObj", "YES" );
  }

  
    /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  VerifyCaption ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_VerifyCaption_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyCaption( "NoMethodObj", "NoValue" );
  }
  
  /**
   * \~german
   *  \brief
   *  Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von
   *  VerifyValue ausgelöst wird.
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2016.05.07
   */
  @Test( expected = OKWFrameObjectMethodNotFoundException.class )
  public void TC_VerifyValue_OKWFrameObjectMethodNotFoundException()
      throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    EN.VerifyValue( "NoMethodObj", "NoValue" );
  }

}

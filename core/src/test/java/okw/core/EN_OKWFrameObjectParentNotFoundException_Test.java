/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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
import okw.exceptions.OKWFrameObjectParentNotFoundException;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EN_OKWFrameObjectParentNotFoundException_Test
{

	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
        Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

        // Reset des Loggers: Alle Geladenen Instanzen löschen
        Logger_Sngltn.init();
        //myLogger.AddLogger(new Log2Console());

        myLogger.setDebugMode(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

    /// \~german
    /// \brief
    /// Diese Methode wird immer vor jedem Test(fall) ausgeführt.
    /// 
	@Before
	public void setUp() throws Exception
	{
        //EN.BeginTest( "TestContext.CurrentContext.Test.Name" );
	}

    /// \~german
    /// \brief
    /// Diese Methode wird immer nach jedem Test(fall) ausgeführt.
    /// 
	@After
	public void tearDown() throws Exception
	{
        EN.EndTest();
	}

	/**
   * \~german
   * \brief Prüft ob die Ausnahme OKWFrameObjectParentNotFoundException ausgelöst wird,
   *        wenn das FensterObjekt zum FN nicht gefunden wird. 
   *  
   * \~english
   * \~
   * \author Zoltan Hrabovszki
	 * \date 2013.12.26
   * 
	 * @throws Exception
	 */
	@Test(expected = OKWFrameObjectParentNotFoundException.class)
    public void tcSelectWindow_OKWFrameObjectParentNotFoundException_Test() throws Exception
    {
        EN.BeginTest( "TC_Select_Window_OKWFrameObjectParentNotFoundException_Test" );
        EN.SelectWindow( "WindowDoesNotExists" );
    }

	/**
   * \~german
   * \brief Prüft ob die Ausnahme OKWFrameObjectParentNotFoundException ausgelöst wird,
   *        wenn das FensterObjekt zum FN nicht gefunden wird. 
   *  
   * \~english
   * \~
   * \author Zoltan Hrabovszki
   * \date 2013.12.26
   * 
   * @throws Exception
   */
  @Test(expected = OKWFrameObjectParentNotFoundException.class)
    public void tcStartApp_OKWFrameObjectParentNotFoundException_Test() throws Exception
    {
        EN.BeginTest( "TC_Select_Window_OKWFrameObjectParentNotFoundException_Test" );
        EN.StartApp( "WindowDoesNotExists" );
    }

  /**
   * \~german
   * \brief Prüft ob die Ausnahme OKWFrameObjectParentNotFoundException ausgelöst wird,
   *        wenn das Frame zur gegebenen FN nicht gefunden wird. 
   *  
   * \~english
   * \~
   * \author Zoltan Hrabovszki
   * \date 2013.12.26
   * 
   * @throws Exception
   */
  @Test(expected = OKWFrameObjectParentNotFoundException.class)
    public void tcStopApp_OKWFrameObjectParentNotFoundException_Test() throws Exception
    {
        EN.BeginTest( "TC_Select_Window_OKWFrameObjectParentNotFoundException_Test" );
        EN.StopApp( "WindowDoesNotExists" );
    }
}
	
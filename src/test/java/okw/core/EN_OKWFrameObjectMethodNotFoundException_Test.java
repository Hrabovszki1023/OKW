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
import okw.exceptions.OKWFrameObjectMethodNotFoundException;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_OKWFrameObjectMethodNotFoundException_Test
{

	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();
	
    @Rule
    public TestName name = new TestName();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
        Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

        // Reset des Loggers: Alle Geladenen Instanzen löschen
        myLogger.Init();
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

	/// \~german
	/// \brief
	/// Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von SelectWindow ausgelöst wird.
	/// 
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2016.05.07
	@Test(expected = OKWFrameObjectMethodNotFoundException.class)
	public void TC_Select_Window_OKWFrameObjectMethodNotFoundException_Test() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
        
		EN.SelectWindow( "WindowWithoutMethods" );
    }
	
	/// \~german
	/// \brief
	/// Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von SelectWindow ausgelöst wird.
	/// 
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.26
	@Test(expected = OKWFrameObjectMethodNotFoundException.class)
    public void TC_ClickOn_OKWFrameObjectMethodNotFoundException() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
		
		EN.SelectWindow( "Rechner" );
		EN.ClickOn( "NoMethodObj" );
    }

	/// \~german
	/// \brief
	/// Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von SelectWindow ausgelöst wird.
	/// 
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.26
	@Test(expected = OKWFrameObjectMethodNotFoundException.class)
    public void TC_Select_OKWFrameObjectMethodNotFoundException() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
		
		EN.SelectWindow( "Rechner" );
		EN.Select( "NoMethodObj", "NoValue" );
    }

	/// \~german
	/// \brief
	/// Prüft ob die Ausnahme OKWFrameObjectMethodNotFoundException von SelectWindow ausgelöst wird.
	/// 
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.12.26
	@Test(expected = OKWFrameObjectMethodNotFoundException.class)
    public void TC_TypeKey_OKWFrameObjectMethodNotFoundException() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
		
		EN.SelectWindow( "Rechner" );
		EN.TypeKey( "NoMethodObj", "NoValue" );
    }
}
	
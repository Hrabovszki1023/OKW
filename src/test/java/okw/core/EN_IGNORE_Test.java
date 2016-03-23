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
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EN_IGNORE_Test
{

	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

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
        EN.BeginTest( "TestContext.CurrentContext.Test.Name" );
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
		/// Prüft "IGNORIEREN" für das Schlüsslewort MemorizeExists(strng,string)
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
    	@Test
        public void TC_MemorizeExists_IGNORE() throws Exception
        {
			// Löschen des Clipboards
			myClipBoard.Clear();
			// Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());


			// Löschen des Clipboards
			myClipBoard.Clear();
            EN.MemorizeExists( "All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals(0, myClipBoard.getValue().size());
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

		/// \~german
		/// \brief
		/// Prüft "IGNORIEREN" als string.empty.
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
    	@Test
    	public void TC_MemorizeExists_IGNORE_StringEmpty() throws Exception
		{
			// Löschen des Clipboards
			myClipBoard.Clear();
			// Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());


			// Löschen des Clipboards
			myClipBoard.Clear();
			EN.MemorizeExists("All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals(0, myClipBoard.getValue().size());
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_MemorizeHasFocus_IGNORE() throws Exception
        {
			// Löschen des Clipboards
			myClipBoard.Clear();
			// Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());


			// Löschen des Clipboards
			myClipBoard.Clear();
            EN.MemorizeHasFocus("All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals(0, myClipBoard.getValue().size());
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

		/// \~german
		/// \brief
		/// 
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
		@Test
		public void TC_MemorizeHasFocus_IGNORE_StringEmpty() throws Exception
		{
			// Löschen des Clipboards
			myClipBoard.Clear();
			// Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());


			// Löschen des Clipboards
			myClipBoard.Clear();
			EN.MemorizeHasFocus("All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals(0, myClipBoard.getValue().size());
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014.01.04
        @Test
		public void TC_MemorizeIsActive_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeIsActive("All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
            assertEquals("MemorizeIsActive()", myClipBoard.getMethod());
        }

		/// \~german
		/// \brief
		/// 
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2014.01.04
		@Test
		public void TC_MemorizeIsActive_IGNORE_StringEmpty() throws Exception
		{
			// Testscript in Schlüsselwort-Notation
			EN.SelectWindow("Rechner");

			// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("Rechner", myClipBoard.getObjectName());
			assertEquals("SelectWindow()", myClipBoard.getMethod());

			EN.MemorizeIsActive("All_MethodsObj", "");

			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("", myClipBoard.getObjectName());
			assertEquals("", myClipBoard.getMethod());
		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_MemorizeSelectedValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

		/// \~german
		/// \brief
		/// 
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
		@Test
		public void TC_MemorizeSelectedValue_IGNORE_StringEmpty() throws Exception
		{
			// Testscript in Schlüsselwort-Notation
			EN.SelectWindow("Rechner");

			// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("Rechner", myClipBoard.getObjectName());
			assertEquals("SelectWindow()", myClipBoard.getMethod());

			EN.MemorizeSelectedValue("All_MethodsObj", "");

			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("", myClipBoard.getObjectName());
			assertEquals("", myClipBoard.getMethod());

		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_MemorizeTablecellValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeTablecellValue("All_MethodsObj", "Col", "Row", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals(0, myClipBoard.getValue().size());
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

		/// \~german
		/// \brief
		/// 
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
		@Test
		public void TC_MemorizeTablecellValue_IGNORE_StringEmpty() throws Exception
		{
			// Testscript in Schlüsselwort-Notation
			EN.SelectWindow("Rechner");

			// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("Rechner", myClipBoard.getObjectName());
			assertEquals("SelectWindow()", myClipBoard.getMethod());

			EN.MemorizeTablecellValue("All_MethodsObj", "Col", "Row", "");

			// Check the Name, Called Method and Value of Actuel object
			assertEquals(0, myClipBoard.getValue().size());
			assertEquals("", myClipBoard.getObjectName());
			assertEquals("", myClipBoard.getMethod());
		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_MemorizeTooltip_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeTooltip("All_MethodsObj", "${INORIERE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

        }

		/// \~german
		/// \brief
		/// 
		/// 
		/// \~english
		/// \~
		/// \author Zoltan Hrabovszki
		/// \date 2013.12.26
		@Test
		public void TC_MemorizeTooltip_IGNORE_StringEmpty() throws Exception
		{
			// Testscript in Schlüsselwort-Notation
			EN.SelectWindow("Rechner");

			// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("Rechner", myClipBoard.getObjectName());
			assertEquals("SelectWindow()", myClipBoard.getMethod());

			EN.MemorizeTooltip("All_MethodsObj", "${INORIERE}");

			// Check the Name, Called Method and Value of Actuel object
			assertEquals("NO VALUE", myClipBoard.getValue().get(0));
			assertEquals("", myClipBoard.getObjectName());
			assertEquals("", myClipBoard.getMethod());
		}

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_MemorizeValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeValue("All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_MemorizeValue_IGNORE_StringEmpty() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.MemorizeValue("All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

        }
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_SelectMenu_Value_MV_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.SelectMenu( "All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_SelectMenu_Value_MV_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.SelectMenu( "All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_SelectMenu_Value_SV_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.SelectMenu("All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_SelectMenu_Value_SV_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.SelectMenu("All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());
        }

        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_Select_Clicktype_IGNORE() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

			EN.Select("All_MethodsObj", "${IGNORE}", "DOUBLEClick");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_Select_Clicktype_IGNORE_EmptyString() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

			EN.Select("All_MethodsObj", "", "DOUBLEClick");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
        }

        /// \~german
        /// \brief
        /// Prüft den Methodenaufruf Select mit einem einzelnen Wert.
        /// Prüft Ziel es darf nur ein Wert im List of string übergabe Parameter enthalten sein.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_Select_IGNORE() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            
            myClipBoard.Clear();

			EN.Select( "All_MethodsObj", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

            assertEquals(0, myClipBoard.getValue().size());
        }

        
        /// \~german
        /// \brief
        /// Prüft den Methodenaufruf Select mit einem einzelnen Wert.
        /// Prüft Ziel es darf nur ein Wert im List of string übergabe Parameter enthalten sein.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
		public void TC_Select_IGNORE_EmptyString() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            
            myClipBoard.Clear();

			EN.Select( "All_MethodsObj", "");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("", myClipBoard.getObjectName());
            assertEquals("", myClipBoard.getMethod());

            assertEquals(0, myClipBoard.getValue().size());
        }

        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_Sequence_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.Sequence("Rechner", "TestSequence", "${IGNORE}");

            // Check the Name, Called Method and Value of Actuel object
            //          assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            //          assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
            //          assertEquals("OKW_SetFocus()", myClipBoard.getMethod());
        }

        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_Sequence_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.Sequence("Rechner", "TestSequence", "");

        }
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_SetValue_IGNORE() throws Exception
        {

                EN.SelectWindow("Rechner");
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("Rechner", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                EN.SetValue( "All_MethodsObj", "${IGNORE}");

        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_SetValue_IGNORE_EmptyString() throws Exception
        {

                EN.SelectWindow("Rechner");
                assertEquals("NO VALUE", myClipBoard.getValue().get(0));
                assertEquals("Rechner", myClipBoard.getObjectName());
                assertEquals("SelectWindow()", myClipBoard.getMethod());

                EN.SetValue( "All_MethodsObj", "");

        }
        

        /// \~german
        /// \brief
        /// Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey Übertragen wird.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_TypeKeyTablecell_IGNORE() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

            EN.TypeKeyTablecell( "All_MethodsObj", "1", "1", "${IGNORE}");
        }
 
        /// \~german
        /// \brief
        /// Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey Übertragen wird.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_TypeKeyTablecell_IGNORE_EmptyString() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

            EN.TypeKeyTablecell( "All_MethodsObj", "1", "1", "");
        }
 
        /// \~german
        /// \brief
        /// Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey Übertragen wird.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_TypeKey_IGNORE() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

            EN.TypeKey("All_MethodsObj", "${IGNORE}");

        }

        
        /// \~german
        /// \brief
        /// Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey Übertragen wird.
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_TypeKey_IGNORE_EmptyString() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Check the Name, Called Method and Value of Actuel object
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));

            EN.TypeKey("All_MethodsObj", "");
        }


        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyExists_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyExists("All_MethodsObj", "${IGNORE}");
        }

        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyExists_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyExists("All_MethodsObj", "");
        }
        
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyHasFocus_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE}");

        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyHasFocus_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyHasFocus( "All_MethodsObj", "");

        }
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyIsActive_IGNORE() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyIsActive( "All_MethodsObj", "${IGNORE}");


        }
        
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyIsActive_IGNORE_EmptyString() throws Exception
        {
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyIsActive( "All_MethodsObj", "");
        }
        
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifySelectedValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            // Einzelner Wert
            EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE}");

        }

        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifySelectedValue_IGNORE_EMptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            // Einzelner Wert
            EN.VerifySelectedValue( "All_MethodsObj", "");
        }
        
        
        /// \~german
        /// \brief
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyTablecellValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");
            
            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyTablecellValue("All_MethodsObj", "Col", "Row", "${IGNORE}");

        }

        /// \~german
        /// \brief
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyTablecellValue_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");
            
            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyTablecellValue("All_MethodsObj", "Col", "Row", "");

        }

        
        /// \~german
        /// \brief
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyTooltip_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            // Ein eintzelner Wert
            EN.VerifyTooltip("All_MethodsObj", "${IGNORE}");
        }
        
        /// \~german
        /// \brief
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyTooltip_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");

            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            // Ein eintzelner Wert
            EN.VerifyTooltip("All_MethodsObj", "");
        }

        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyValue_IGNORE() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");
            
            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyValue("All_MethodsObj", "${IGNORE}");

        }
        
        /// \~german
        /// \brief
        /// 
        /// 
        /// \~english
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.26
        @Test
        public void TC_VerifyValue_IGNORE_EmptyString() throws Exception
        {
            // Testscript in Schlüsselwort-Notation
            EN.SelectWindow("Rechner");
            
            // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
            // Check the Name, Called Method and Value of Actuel object
            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
            assertEquals(1, myClipBoard.getValue().size());
            assertEquals("Rechner", myClipBoard.getObjectName());
            assertEquals("SelectWindow()", myClipBoard.getMethod());

            EN.VerifyValue("All_MethodsObj", "");

        }
}
	
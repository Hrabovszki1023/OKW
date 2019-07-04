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

import org.junit.*;
import org.junit.rules.TestName;
import org.omg.CORBA.SystemException;

public class EN_Keywords_IGNORE_Test
{

    private static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    private static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName                  name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        // Reset des Loggers: Alle Geladenen Instanzen löschen
        Logger_Sngltn.init();
        //myLogger.AddLogger(new Log2Console());

        myLogger.setDebugMode( false );
    }

    /*@AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }
    
    
    /** \~german
     * \brief
     *  Diese Methode wird immer vor jedem Test(fall) ausgeführt.
      
    @Before
    public void setUp() throws Exception
    {
    
    }
    */

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
    /// Prüft "IGNORIEREN" für das Schlüsslewort MemorizeCaption(strng,string)
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcMemorizeCaption_IGNORE() throws Exception
    {

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

        try
        {
            EN.MemorizeCaption( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeCaption_IGNORE_StringEmpty() throws Exception
    {
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

        try
        {
            EN.MemorizeCaption( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

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
    public void tcMemorizeExists_IGNORE() throws Exception
    {
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

        try
        {
            EN.MemorizeExists( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

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
    public void tcMemorizeExists_IGNORE_StringEmpty() throws Exception
    {
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

        try
        {
            EN.MemorizeExists( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeHasFocus_IGNORE() throws Exception
    {
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

        try
        {
            EN.MemorizeHasFocus( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

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
    public void tcMemorizeHasFocus_IGNORE_StringEmpty() throws Exception
    {
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

        try
        {
            EN.MemorizeHasFocus( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeIsActive_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeIsActive( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeIsActive_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeIsActive( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeLabel_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeLabel( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeLabel_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeLabel( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

    }

    /* \~german
     * 
     * 
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2018-10-04
     */
    @Test
    public void tcMemorizePlaceholde_IGNORE() throws Exception
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

        try
        {
            EN.MemorizePlaceholder( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
    }

    /* \~german
     * 
     * 
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2018-10-04
     */
    @Test
    public void tcMemorizePlaceholder_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizePlaceholder( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

    }

    /* \~german
     * 
     * 
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2018-10-04
     */
    @Test
    public void tcMemorizeSelectedValue_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeSelectedValue_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeSelectedValue( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

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
    public void tcMemorizeTablecellValue_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeTablecellValue( "All_MethodsObj", "Col", "Row", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Falsche Ausnahme wurde ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeTablecellValue_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeTablecellValue( "All_MethodsObj", "Col", "Row", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Falsche Ausnahme wurde ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeTooltip_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeTooltip( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Falsche Ausnahme wurde ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeTooltip_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeTooltip( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Falsche Ausnahme wurde ausgelöst: " + e.getMessage() );
        }
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
    public void tcMemorizeValue_IGNORE() throws Exception
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

        try
        {
            EN.MemorizeValue( "All_MethodsObj", "${IGNORE}" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst: " + e.getMessage() );
        }

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
    public void tcMemorizeValue_IGNORE_StringEmpty() throws Exception
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

        try
        {
            EN.MemorizeValue( "All_MethodsObj", "" );
            fail( "Erwartetet Ausnahme wurde nicht ausgelöst" );
        }
        catch (OKWNotAllowedValueException e)
        {
            // Check the Name, Called Method and Value of Actuel object
            assertEquals( 0, myClipBoard.getValue().size() );
            assertEquals( "", myClipBoard.getObjectName() );
            assertEquals( "", myClipBoard.getMethod() );
        }
        catch (SystemException e)
        {
            fail( "Unerwartetet Ausnahme wurde ausgelöst: " + e.getMessage() );
        }
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
    public void tcSelectMenu_Value_MV_IGNORE() throws Exception
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
        EN.SelectMenu( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

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
    public void tcSelectMenu_Value_MV_IGNORE_EmptyString() throws Exception
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
        EN.SelectMenu( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );
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
    public void tcSelectMenu_Value_SV_IGNORE() throws Exception
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
        EN.SelectMenu( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );
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
    public void tcSelectMenu_Value_SV_IGNORE_EmptyString() throws Exception
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
        EN.SelectMenu( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );
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
    public void tcSelect_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        myClipBoard.Clear();

        EN.Select( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
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
    public void tcSelect_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        myClipBoard.Clear();

        EN.Select( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
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
    public void tcSequence_IGNORE() throws Exception
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
        EN.Sequence( "Rechner", "TestSequence", "${IGNORE}" );

        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );
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
    public void tcSequence_IGNORE_EmptyString() throws Exception
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
        EN.Sequence( "Rechner", "TestSequence", "" );

        assertEquals( 0, myClipBoard.getValue().size() );
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

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
    public void tcSetValue_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "${IGNORE}" );

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
    public void tcSetValue_IGNORE_EmptyString() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "" );

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
    public void tcTypeKeyTablecell_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKeyTablecell( "All_MethodsObj", "1", "1", "${IGNORE}" );
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
    public void tcTypeKeyTablecell_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKeyTablecell( "All_MethodsObj", "1", "1", "" );
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
    public void tcTypeKey_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKey( "All_MethodsObj", "${IGNORE}" );

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
    public void tcTypeKey_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKey( "All_MethodsObj", "" );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaption_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaption( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaption_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaption( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaptionREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaptionREGX( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaptionREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaptionREGX( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaptionWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaptionWCM( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyCaptionWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyCaptionWCM( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyLabel( FN, "" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyLabel( FN, "" ) is not executed.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabel_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabel( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyLabel( FN, "${IGNORE}" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyLabel( FN, "${IGNORE}" ) is not executed.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabel_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabel( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabelREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabelREGX( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabelREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabelREGX( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabelWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabelWCM( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyLabelWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyLabelWCM( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyMaxLength( FN, "" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyMaxLength( FN, "" ) is not executed.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyMaxLength_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyMaxLength( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyMaxLength( FN, "${IGNORE}" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyMaxLength( FN, "${IGNORE}" ) is not executed.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyMaxLength_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyMaxLength( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  \~english
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tcVerifyPlaceholder_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyPlaceholder( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  \~english
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tcVerifyPlaceholderREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyPlaceholderREGX( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  \~english
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tcVerifyPlaceholderREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyPlaceholderREGX( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  \~english
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tcVerifyPlaceholderWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyPlaceholderWCM( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  
     *  \~english
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tcVerifyPlaceholderWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyPlaceholderWCM( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief Prüft ob das Schlüsselwort beim Sollwert "${IGNORE}" die Ausführung ignoriert
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyExists_IGNORE() throws Exception
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

        EN.VerifyExists( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief Prüft ob das Schlüsselwort beim Sollwert "" die Ausführung ignoriert
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyExists_IGNORE_EmptyString() throws Exception
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

        EN.VerifyExists( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
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
    public void tcVerifyHasFocus_IGNORE() throws Exception
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

        EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
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
    public void tcVerifyHasFocus_IGNORE_EmptyString() throws Exception
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

        EN.VerifyHasFocus( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );

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
    public void tcVerifyIsActive_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyIsActive( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );

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
    public void tcVerifyIsActive_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyIsActive( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );

    }

    /** \~german
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tcVerifySelectedValue_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE}" );
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
    public void tcVerifySelectedValue_IGNORE_EMptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValue( "All_MethodsObj", "" );
    }

    /** \~german
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tcVerifySelectedValueREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValueREGX( "All_MethodsObj", "${IGNORE}" );
    }

    /** \~german
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tcVerifySelectedValueREGX_IGNORE_EMptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValueREGX( "All_MethodsObj", "" );
    }

    /** \~german
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tcVerifySelectedValueWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValueWCM( "All_MethodsObj", "${IGNORE}" );
    }

    /** \~german
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifySelectedValueWCM_IGNORE_EMptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Einzelner Wert
        EN.VerifySelectedValueWCM( "All_MethodsObj", "" );
    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValue_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row", "${IGNORE}" );

    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValueREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "${IGNORE}" );

    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValueWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "${IGNORE}" );

    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValue_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row", "" );
    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValueREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "" );
    }

    /// \~german
    /// \brief
    /// 
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2013.12.26
    @Test
    public void tcVerifyTablecellValueWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "" );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltip_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltip( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltipREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltipREGX( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltipREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltipREGX( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltipWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltipWCM( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltipWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltipWCM( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyTooltip_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyTooltip( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValue_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValue( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValueREGX_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValueREGX( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValueREGX_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValueREGX( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValueWCM_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValueWCM( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValueWCM_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValueWCM( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  \brief
     *  
     *  
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tcVerifyValue_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyValue( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }
	
	/**
	 * \~german Prüft ob das Schlüsselwort VerifyLabel( FN, "" ) nicht ausgeführt
	 * wird
	 * 
	 * \~english Verifies if the keyword VerifyLabel( FN, "" ) is not executed.
	 * 
	 * \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyBadge_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadge("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german Prüft ob das Schlüsselwort VerifyVerifyBadge( FN, "${IGNORE}" )
	 * nicht ausgeführt wird
	 * 
	 * \~english Verifies if the keyword VerifyVerifyBadge( FN, "${IGNORE}" ) is not
	 * executed.
	 * 
	 * \~ \author Daniel Krüger \date 2019.03.27
	 */
	@Test
	public void tcVerifyBadge_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadge("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}
	
	/**
	 * \~german \brief
	 * 
	 * 
	 * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyBadgeREGX_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadgeREGX("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german \brief
	 * 
	 * 
	 * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyBadgeREGX_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadgeREGX("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german \brief
	 * 
	 * 
	 * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyBadgeWCM_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadgeWCM("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german
	 * 
	 * 
	 * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyBadgeWCM_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyBadgeWCM("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}
	
	  /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyMinLength( FN, "" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyMinLength( FN, "" ) is not executed.
     *  
     *  \~
     *  \author Daniel Krüger
     *  \date 2019.06.18
     */
    @Test
    public void tcVerifyMinLength_IGNORE_EmptyString() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyMinLength( "All_MethodsObj", "" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }

    /**
     *  \~german
     *  Prüft ob das Schlüsselwort VerifyMinLength( FN, "${IGNORE}" ) nicht ausgeführt wird
     *  
     *  \~english
     *  Verifies if the keyword VerifyMinLength( FN, "${IGNORE}" ) is not executed.
     *  
     *  \~
     *  \author Daniel Krüger
     *  \date 2019.06.18
     */
    @Test
    public void tcVerifyMinLength_IGNORE() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.VerifyMinLength( "All_MethodsObj", "${IGNORE}" );

        // Check the Name, Called Method and Value of Actual object
        assertEquals( "", myClipBoard.getObjectName() );
        assertEquals( "", myClipBoard.getMethod() );

        assertEquals( 0, myClipBoard.getValue().size() );
    }
	
    
	/**
	 * \~german Prüft ob das Schlüsselwort VerifyErrorMSG( FN, "" ) nicht ausgeführt
	 * wird
	 * 
	 * \~english Verifies if the keyword VerifyErrorMSG( FN, "" ) is not executed.
	 * 
	 * \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyErrorMSG_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}
	/**
	 * \~german Prüft ob das Schlüsselwort VerifyErrorMSG( FN, "${IGNORE}" )
	 * nicht ausgeführt wird
	 * 
	 * \~english Verifies if the keyword VerifyErrorMSG( FN, "${IGNORE}" ) is not
	 * executed.
	 * 
	 * \~ \author Daniel Krüger \date 2019.05.31
	 */
	@Test
	public void tcVerifyErrorMSG_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}
	
	/**
	 * \~german Prüft ob das Schlüsselwort VerifyErrorMSG_REGX( FN, "${IGNORE}" )
	 * nicht ausgeführt wird
	 * 
	 * \~english Verifies if the keyword VerifyErrorMSG_REGX( FN, "${IGNORE}" ) is not
	 * executed.
	 * 
	 * \~ \author Daniel Krüger \date 2019.05.31
	 */
	@Test
	public void tcVerifyErrorMSG_REGX_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG_REGX("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german \brief
	 * 
	 * 
	 * \~english \~ \author Daniel Krüger \date 2019.05.31
	 */
	@Test
	public void tcVerifyErrorMSG_REGX_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG_REGX("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german Prüft ob das Schlüsselwort VerifyErrorMSG_WCM( FN, "${IGNORE}" )
	 * nicht ausgeführt wird
	 * 
	 * \~english Verifies if the keyword VerifyErrorMSG_WCM( FN, "${IGNORE}" ) is not
	 * executed.
	 * 
	 * \~ \author Daniel Krüger \date 2019.05.31
	 */
	@Test
	public void tcVerifyErrorMSG_WCM_IGNORE() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG_WCM("All_MethodsObj", "${IGNORE}");

		// Check the Name, Called Method and Value of Actual object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}

	/**
	 * \~german
	 * 
	 * 
	 * \~english \~ \author Zoltan Hrabovszki \date 2013.12.26
	 */
	@Test
	public void tcVerifyErrorMSG_WCM_IGNORE_EmptyString() throws Exception {
		EN.BeginTest(name.getMethodName());

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals(1, myClipBoard.getValue().size());
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		myClipBoard.Clear();

		EN.VerifyErrorMSG_WCM("All_MethodsObj", "");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals("", myClipBoard.getObjectName());
		assertEquals("", myClipBoard.getMethod());

		assertEquals(0, myClipBoard.getValue().size());
	}
}
	
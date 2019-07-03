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
import okw.OKW_Memorize_Sngltn;
import okw.OKW_TestClipboard;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_Keywords_Test
{
    static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName          name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        // Log2Console myLog2Console = null;
        // myLog2Console = new Log2Console();
        // myLogger.AddLogger(myLog2Console);

        myLogger.setDebugMode( false );
    }

    /*
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        System.out.println( "===========================================================================" );
        System.out.println( "= Ausgabe in die Datei: 'EN_Keywords_Test.html'" );
        System.out.println( "===========================================================================" );
        //myLog2HTML.Result2HTML( "EN_Keywords_Test.html" );
        System.out.println( "===========================================================================" );
    }
    */

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
        EN.EndTest();
    }

    // \~german
    // \brief
    // Prüft methoden aufruf für einen einfachen Click.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_ClickOn() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "NO VALUE" );
        EN.ClickOn( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "ClickOn()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    // Prüft den Methodenaufruf für einen Click mit ClickType.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_DoubleClickOn() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "NO VALUE" );
        EN.DoubleClickOn( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "DoubleClickOn()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogExists() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.LogExists( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogExists()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogHasFocus() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.LogHasFocus( "All_MethodsObj" );

        // Check the Name, Called Method and Parameter
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogHasFocus()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogIsActive() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "No" );
        EN.LogIsActive( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "No", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogIsActive()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogSelected() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.LogSelected( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogSelected()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogTablecellValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.LogTablecellValue( "All_MethodsObj", "Col", "Row" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Col", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogTablecellValue()", myClipBoard.getMethod() );
    }

    // \~german
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogTooltip() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.LogTooltip( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogTooltip()", myClipBoard.getMethod() );
    }

    // \~german
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogPlaceholder() throws Exception
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
        EN.LogPlaceholder( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogPlaceholder()", myClipBoard.getMethod() );
    }
    
    // \~german
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogLabel() throws Exception
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
        EN.LogLabel( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogLabel()", myClipBoard.getMethod() );
    }

    // \~german
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogCaption() throws Exception
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
        EN.LogCaption( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogCaption()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_LogValue() throws Exception
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
        EN.LogValue( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "LogValue()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_MemorizeExists() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.MemorizeExists( "All_MethodsObj", "Key_TC_MemorizeExists" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeExists()", myClipBoard.getMethod() );

        assertEquals( "YES", OKW_Memorize_Sngltn.getInstance().get( "Key_TC_MemorizeExists" ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_MemorizeHasFocus() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.MemorizeHasFocus( "All_MethodsObj", "Key_TC_Memorize_Focus" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeHasFocus()", myClipBoard.getMethod() );

        assertEquals( "YES", OKW_Memorize_Sngltn.getInstance().get( "Key_TC_Memorize_Focus" ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.01.04
    @Test
    public void tc_MemorizeIsActive() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.MemorizeIsActive( "All_MethodsObj", "TC_MemorizeIsActive" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeIsActive()", myClipBoard.getMethod() );

        assertEquals( "YES", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeIsActive" ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_MemorizeSelectedValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.MemorizeSelectedValue( "All_MethodsObj", "TC_MemorizeSelectedValue_Key_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeSelectedValue()", myClipBoard.getMethod() );

        assertEquals( "MemorizeSelectedValue_Return_1${SEP}MemorizeSelectedValue_Return_2",
                        OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeSelectedValue_Key_1" ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_MemorizeTablecellValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.MemorizeTablecellValue( "All_MethodsObj", "Col", "Row", "TC_MemorizeTablecellVelue_Key_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 2, myClipBoard.getValue().size() );
        assertEquals( "Col", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeTablecellValue()", myClipBoard.getMethod() );

        assertEquals( "MemorizeTablecellValue_1", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeTablecellVelue_Key_1" ) );
    }

    /* \~german
     *
     * \~english
     * 
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
    */
    @Test
    public void tc_MemorizeTooltip() throws Exception
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
        EN.MemorizeTooltip( "All_MethodsObj", "TC_MemorizeTooltip_Key_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeTooltip()", myClipBoard.getMethod() );

        assertEquals( "MemorizeTooltip_Return_1${SEP}MemorizeTooltip_Return_2", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeTooltip_Key_1" ) );
    }

    /* \~german
    *
    * \~english
    * 
    * \~
    * \author Zoltan Hrabovszki
    * \date 2013.12.26
   */
   @Test
   public void tc_MemorizeCaption() throws Exception
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
       EN.MemorizeCaption( "All_MethodsObj", "TC_MemorizeCaption_Key_1" );

       // Check the Name, Called Method and Value of Actuel object
       assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
       assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
       assertEquals( "MemorizeCaption()", myClipBoard.getMethod() );

       assertEquals( "MemorizeCaption_Return_1${SEP}MemorizeCaption_Return_2", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeCaption_Key_1" ) );
   }

   /* \~german
   *
   * \~english
   * 
   * \~
   * \author Zoltan Hrabovszki
   * \date 2013.12.26
  */
  @Test
  public void tc_MemorizePlaceholder() throws Exception
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
      EN.MemorizePlaceholder( "All_MethodsObj", "TC_MemorizePlaceholder_Key_1" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "MemorizePlaceholder()", myClipBoard.getMethod() );

      assertEquals( "MemorizePlaceholder_Return_1${SEP}MemorizePlaceholder_Return_2", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizePlaceholder_Key_1" ) );
  }
  /* \~german
  *
  * \~english
  * 
  * \~
  * \author Zoltan Hrabovszki
  * \date 2013.12.26
 */
 @Test
 public void tc_MemorizeLabel() throws Exception
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
     EN.MemorizeLabel( "All_MethodsObj", "TC_MemorizeLabel_Key_1" );

     // Check the Name, Called Method and Value of Actuel object
     assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
     assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
     assertEquals( "MemorizeLabel()", myClipBoard.getMethod() );

     assertEquals( "MemorizeLabel_Return_1${SEP}MemorizeLabel_Return_2", OKW_Memorize_Sngltn.getInstance().get( "TC_MemorizeLabel_Key_1" ) );
 }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_MemorizeValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.MemorizeValue( "All_MethodsObj", "TC_Memorize_Key_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "MemorizeValue()", myClipBoard.getMethod() );

        assertEquals( "MemorizeValue_Return_1", OKW_Memorize_Sngltn.getInstance().get( "TC_Memorize_Key_1" ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SelectMenu() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "No Value" );
        EN.SelectMenu( "All_MethodsObj" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "No Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SelectMenu()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SelectMenu_Value_MV() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SelectMenu( "All_MethodsObj", "Wert 1${SEP}Wert 2${SEP}Wert 3" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Wert 2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Wert 3", myClipBoard.getValue().get( 2 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SelectMenu(ArrayList<String>)", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SelectMenu_Value_SV() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SelectMenu( "All_MethodsObj", "Hanna" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Hanna", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SelectMenu(ArrayList<String>)", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SelectTablecell() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.SetValue( "All_MethodsObj", "tc_SelectTablecell" );
        EN.SelectTablecell( "All_MethodsObj", "COL", "ROW" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SelectTablecell(String COL, String ROW)", myClipBoard.getMethod() );

        assertEquals( 3, myClipBoard.getValue().size() );
        assertEquals( "COL", myClipBoard.getValue().get( 0 ) );
        assertEquals( "ROW", myClipBoard.getValue().get( 1 ) );
        assertEquals( "tc_SelectTablecell", myClipBoard.getValue().get( 2 ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.03.19
    @Test
    public void tc_SelectWindow() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.03.19
    @Test
    public void tc_SelectChild() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();
        EN.SelectChild( "All_MethodsObj" );
        EN.SetValue( "SELECTEDCHILD", "YES" );
        EN.SetFocus( "SELECTEDCHILD" );

        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetFocus()", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.03.19
    @Test
    public void tc_SELECTEDCHILD() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();
        //EN.SelectChild( "All_MethodsObj" );
        EN.SetValue( "All_MethodsObj", "YES" );
        EN.SetFocus( "SELECTEDCHILD" );

        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetFocus()", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );
    }

    
    // \~german
    // \brief
    // Prüft den Methodenaufruf Select mit einem einzelnen Wert.
    // Prüft Ziel es darf nur ein Wert im List of string übergabe Parameter
    // enthalten sein.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_Select_MultipleValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.Select( "All_MethodsObj", "Hanna${SEP}Zoltan" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "Select()", myClipBoard.getMethod() );

        assertEquals( 2, myClipBoard.getValue().size() );
        assertEquals( "Hanna", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Zoltan", myClipBoard.getValue().get( 1 ) );
    }

    // \~german
    // \brief
    // Prüft den Methodenaufruf Select mit einem einzelnen Wert.
    // Prüft Ziel es darf nur ein Wert im List of string übergabe Parameter
    // enthalten sein.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_Select_SingleValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.Select( "All_MethodsObj", "Hanna" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "Select()", myClipBoard.getMethod() );

        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Hanna", myClipBoard.getValue().get( 0 ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_Sequence() throws Exception
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
        EN.Sequence( "Rechner", "TestSequence_1", "SEQID_Test" );

        // Check the Name, Called Method and Value of Actuel object

        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "SEQID_Test", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "TestSequence_1()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SetFocus() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.SetFocus( "All_MethodsObj" );

        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetFocus()", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );

    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_SetValue_MultipleValues() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Wert 1${SEP}Wert 2${SEP}Wert 3" );

        assertEquals( 3, myClipBoard.getValue().size() );
        assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Wert 2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Wert 3", myClipBoard.getValue().get( 2 ) );
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
    public void tc_SetValue_SV() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Wert 1" );

        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetValue()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    // Prüft den Methodenaufruf StartApp.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_StartApp() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.StartApp( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "StartApp()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    // Prüft den Methodenaufruf StopApp.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_StopApp() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.StopApp( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "StopApp()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    // Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey
    // Übertragen wird.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_TypeKeyTablecell_MultipleValues() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKey( "All_MethodsObj", "CTRL-C${SEP}CTRL-V" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
        assertEquals( 2, myClipBoard.getValue().size() );
        assertEquals( "CTRL-C", myClipBoard.getValue().get( 0 ) );
        assertEquals( "CTRL-V", myClipBoard.getValue().get( 1 ) );
    }

    // \~german
    // \brief
    // Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Type key
    // Übertragen wird.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_TypeKeyTablecell_SingelValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKeyTablecell( "All_MethodsObj", "1", "2", "CTRL A" );
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKeyTablecell(String COL, String ROW, List<String> Values)", myClipBoard.getMethod() );

        assertEquals( 3, myClipBoard.getValue().size() );
        assertEquals( "1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "CTRL A", myClipBoard.getValue().get( 2 ) );
    }

    // \~german
    // \brief
    // Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey
    // Übertragen wird.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_TypeKey_MultipleValues() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKey( "All_MethodsObj", "CTRL-C${SEP}CTRL-V" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
        assertEquals( 2, myClipBoard.getValue().size() );
        assertEquals( "CTRL-C", myClipBoard.getValue().get( 0 ) );
        assertEquals( "CTRL-V", myClipBoard.getValue().get( 1 ) );
    }

    // \~german
    // \brief
    // Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Type key
    // Übertragen wird.
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_TypeKey_SingelValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

        EN.TypeKey( "All_MethodsObj", "CTRL A" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "CTRL A", myClipBoard.getValue().get( 0 ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.03.19
    @Test
    public void tc_TypeKeyWindow_MV() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.TypeKeyWindow( "Rechner", "Wert 1${SEP}Wert 2${SEP}Wert 3" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );

        assertEquals( 3, myClipBoard.getValue().size() );
        assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Wert 2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Wert 3", myClipBoard.getValue().get( 2 ) );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2014.03.19
    @Test
    public void tc_TypeKeyWindowWindow_SV() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.TypeKeyWindow( "Rechner", "Wert" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );

        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Wert", myClipBoard.getValue().get( 0 ) );
    }

    /**
	 * \~german
	 * "Normaler" Testfall für das Schlüsselwort EN.VerifyBadge(String,String).
	 * 
	 *  \~english
	 *  \~
	 *  "Normal" test case for the keyword EN.VerifyBadge(String,String).
	 *  \author Daniel Krüger
	 *  \date 2019.03.25
	 */
	@Test
	public void tc_VerifyBadge() throws Exception
	{
	    EN.BeginTest( name.getMethodName() );
	
	    // Testscript in Schlüsselwort-Notation
	    EN.SelectWindow( "Rechner" );
	
	    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "Rechner", myClipBoard.getObjectName() );
	    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
	
	    myClipBoard.Clear();
	    
	    EN.SetValue( "All_MethodsObj", "The one and only VerifyBadge" );
	    EN.VerifyBadge( "All_MethodsObj", "The one and only VerifyBadge" );
	
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( 1, myClipBoard.getValue().size() );
	    assertEquals( "The one and only VerifyBadge", myClipBoard.getValue().get( 0 ) );
	    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	    assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	}

	/**
	 * \~german
	 * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelREGX(String,String).
	 * 
	 *  \~english
	 *  \~
	 *  "Normal" test case for the keyword EN.VerifyLabelREGX(String,String).
	 *  \author Zoltan Hrabovszki
	 *  \date 2013.12.26
	 */
	@Test
	public void tc_VerifyBadgeREGX() throws Exception
	{
	    EN.BeginTest( name.getMethodName() );
	
	    // Testscript in Schlüsselwort-Notation
	    EN.SelectWindow( "Rechner" );
	
	    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "Rechner", myClipBoard.getObjectName() );
	    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
	
	    EN.SetValue( "All_MethodsObj", "The one and only VerifyBadgeREGX" );
	    myClipBoard.Clear();
	    EN.VerifyBadgeREGX( "All_MethodsObj", "\\w{3} one and only VerifyBadgeREGX" );
	
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( 1, myClipBoard.getValue().size() );
	    assertEquals( "The one and only VerifyBadgeREGX", myClipBoard.getValue().get( 0 ) );
	    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	    assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	}

	/**
	 * \~german
	 * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelWCM(String,String). 
	 * 
	 *  \~english
	 *  "Normal" test case for the keyword EN.VerifyLabelWCM(String,String).
	 *  \~
	 *  "Normal" test case for the keyword EN.VerifyLabelWCM(String,String). 
	 *  \author Zoltan Hrabovszki
	 *  \date 2013.12.26
	 */
	@Test
	public void tc_VerifyBadgeWCM() throws Exception
	{
	    EN.BeginTest( name.getMethodName() );
	
	    // Testscript in Schlüsselwort-Notation
	    EN.SelectWindow( "Rechner" );
	
	    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
	    assertEquals( "Rechner", myClipBoard.getObjectName() );
	    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
	
	    EN.SetValue( "All_MethodsObj", "The one and only VerifyBadgeWCM" );
	    myClipBoard.Clear();
	    EN.VerifyBadgeWCM( "All_MethodsObj", "??? one and only VerifyBadgeWCM" );
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( 1, myClipBoard.getValue().size() );
	    assertEquals( "The one and only VerifyBadgeWCM", myClipBoard.getValue().get( 0 ) );
	    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	    assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	}

	/**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyCaption. 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyCaption() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyCaption( "All_MethodsObj", "The one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyCaptionREGX. 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyCaptionREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyCaptionREGX( "All_MethodsObj", "\\w{3} one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyCaptionWCM(String, String). 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyCaptionWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyCaptionWCM( "All_MethodsObj", "??? one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabel(String,String).
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyLabel() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyLabel" );
        myClipBoard.Clear();
        EN.VerifyLabel( "All_MethodsObj", "The one and only VerifyLabel" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyLabel", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelREGX(String,String).
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyLabelREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyLabel" );
        myClipBoard.Clear();
        EN.VerifyLabelREGX( "All_MethodsObj", "\\w{3} one and only VerifyLabel" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyLabel", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelWCM(String,String). 
     * 
     *  \~english
     *  "Normal" test case for the keyword EN.VerifyLabelWCM(String,String).
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyLabelWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyLabel" );
        myClipBoard.Clear();
        EN.VerifyLabelWCM( "All_MethodsObj", "??? one and only VerifyLabel" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyLabel", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyMaxLenth(String,String). 
     * 
     *  \~english
     *  "Normal" test case for the keyword EN.VerifyMaxLenth(String,String).
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018.12.26
     */
    @Test
    public void tc_VerifyMaxLength() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "2" );
        myClipBoard.Clear();
        EN.VerifyMaxLength( "All_MethodsObj", "2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "2", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyMaxLength()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyPlaceholder(String,String).
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tc_VerifyPlaceholder() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyPlaceholder" );
        myClipBoard.Clear();
        EN.VerifyPlaceholder( "All_MethodsObj", "The one and only VerifyPlaceholder" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyPlaceholder", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelREGX(String,String).
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tc_VerifyPlaceholderREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyPlaceholder" );
        myClipBoard.Clear();
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "\\w{3} one and only VerifyPlaceholder" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyPlaceholder", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyPlaceholderWCM(String,String). 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2018-10-04
     */
    @Test
    public void tc_VerifyPlaceholderWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only VerifyPlaceholder" );
        myClipBoard.Clear();
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "??? one and only VerifyPlaceholder" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only VerifyPlaceholder", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyExists. 
     * 
     * Prüft beide möglichen erwarteten Werte ab (YES/NO). 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyExists() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.VerifyExists( "All_MethodsObj", "YES" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyExists()", myClipBoard.getMethod() );
    }

    // \~german
    // \brief
    //
    //
    // \~english
    // \~
    // \author Zoltan Hrabovszki
    // \date 2013.12.26
    @Test
    public void tc_VerifyHasFocus() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        myClipBoard.Clear();

        EN.SetValue( "All_MethodsObj", "YES" );
        EN.VerifyHasFocus( "All_MethodsObj", "YES" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );

        //    myClipBoard.Clear();
        //    
        //    EN.VerifyHasFocus( "All_MethodsObj", "NO" );
        //
        //    // Check the Name, Called Method and Value of Actuel object
        //    assertEquals( "false", myClipBoard.getValue().get( 0 ) );
        //    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        //    assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
        //    assertEquals( 1, myClipBoard.getValue().size() );

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
    public void tc_VerifyIsActive() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // myClipBoard.Clear();
        EN.SetValue( "All_MethodsObj", "YES" );
        EN.VerifyIsActive( "All_MethodsObj", "YES" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
        assertEquals( 1, myClipBoard.getValue().size() );

        // 
        //    myClipBoard.Clear();

        //    EN.VerifyIsActive( "All_MethodsObj", "NO" );

        // Check the Name, Called Method and Value of Actuel object
        //    assertEquals( "NO", myClipBoard.getValue().get( 0 ) );
        //    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        //    assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
        //    assertEquals( 1, myClipBoard.getValue().size() );

    }

    
    /** \~german
     *
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tc_VerifySelectedValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Sollwert_Einstellen" );
        // Einzelner Wert
        EN.VerifySelectedValue( "All_MethodsObj", "Sollwert_Einstellen" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_Einstellen", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );

        // Mehrerer Werte
        EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
        EN.VerifySelectedValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
    }

    /** \~german
    *
    *
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2013-12-26
    */
   @Test
   public void tc_VerifySelectedValueWCM() throws Exception
   {
       EN.BeginTest( name.getMethodName() );

       // Testscript in Schlüsselwort-Notation
       EN.SelectWindow( "Rechner" );

       // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
       // Check the Name, Called Method and Value of Actuel object
       assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
       assertEquals( "Rechner", myClipBoard.getObjectName() );
       assertEquals( "SelectWindow()", myClipBoard.getMethod() );

       EN.SetValue( "All_MethodsObj", "Sollwert_Einstellen" );
       // Einzelner Wert
       EN.VerifySelectedValueWCM( "All_MethodsObj", "?ollwert_Einstellen" );

       // Check the Name, Called Method and Value of Actuel object
       assertEquals( "Sollwert_Einstellen", myClipBoard.getValue().get( 0 ) );
       assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
       assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );

       // Mehrerer Werte
       EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
       EN.VerifySelectedValueWCM( "All_MethodsObj", "?ollwert_1${SEP}?ollwert_2" );

       // Check the Name, Called Method and Value of Actuel object
       assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
       assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
       assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
       assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
   }
   
   
   /** \~german
   *
   *
   *  \~english
   *  \~
   *  @author Zoltan Hrabovszki
   *  @date 2013-12-26
   */
  @Test
  public void tc_VerifySelectedValueREGX() throws Exception
  {
      EN.BeginTest( name.getMethodName() );

      // Testscript in Schlüsselwort-Notation
      EN.SelectWindow( "Rechner" );

      // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
      // Check the Name, Called Method and Value of Actuel object
      assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
      assertEquals( "Rechner", myClipBoard.getObjectName() );
      assertEquals( "SelectWindow()", myClipBoard.getMethod() );

      EN.SetValue( "All_MethodsObj", "Sollwert_Einstellen" );
      // Einzelner Wert
      EN.VerifySelectedValueREGX( "All_MethodsObj", "Sollwert_Einstellen" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( "Sollwert_Einstellen", myClipBoard.getValue().get( 0 ) );
      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );

      // Mehrerer Werte
      EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
      EN.VerifySelectedValueREGX( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
      assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
  }

  
   /** \~german
     * 
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tc_VerifyTablecellValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Sollwert_1" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "*ollwert_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 2 ) );
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "*ollwert_1${SEP}S*llwert_2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 2 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 3 ) );
        assertEquals( 4, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
    }


    /** \~german
     * 
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tc_VerifyTablecellValueREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Sollwert_1" );
        EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "Sollwert_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 2 ) );
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
        EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "Sollwert_1${SEP}Sollwert_2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 2 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 3 ) );
        assertEquals( 4, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
    }

    
    /** \~german
     * 
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013-12-26
     */
    @Test
    public void tc_VerifyTablecellValueWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "Sollwert_1" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "Sollwert_1" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 2 ) );
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.SetValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "Sollwert_1${SEP}Sollwert_2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
        assertEquals( "Col", myClipBoard.getValue().get( 2 ) );
        assertEquals( "Row", myClipBoard.getValue().get( 3 ) );
        assertEquals( 4, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
    }

    
    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyCaption. 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyTooltip() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.VerifyTooltip( "All_MethodsObj", "The one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyTooltipREGX. 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyTooltipREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyTooltipREGX( "All_MethodsObj", "\\w{3} one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief "Normaler" Testfall für das Schlüsselwort VerifyTootip WCM(String, String). 
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     */
    @Test
    public void tc_VerifyTooltipWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue("All_MethodsObj", "The one and only Value" );
        EN.VerifyTooltipWCM( "All_MethodsObj", "??? one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyValue( "All_MethodsObj", "The one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /** 
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValue_MultipleValues() throws Exception
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

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyValue( "AllMethods_MultipleValues", "1. Value${SEP}2. Value${SEP}3. Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "1. Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "2. Value", myClipBoard.getValue().get( 1 ) );
        assertEquals( "3. Value", myClipBoard.getValue().get( 2 ) );

        assertEquals( "Rechner.AllMethods_MultipleValues", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValueWCM() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyValueWCM( "All_MethodsObj", "??? one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );

        EN.VerifyValueWCM( "All_MethodsObj", "The one and only Value" );
        EN.VerifyValueWCM( "All_MethodsObj", "??? ??? ??? ???? ?????" );
        EN.VerifyValueWCM( "All_MethodsObj", "* * * * *" );
    }

    /** 
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValueWCM_MultipleValues() throws Exception
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

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyValueWCM( "AllMethods_MultipleValues", "#. Value${SEP}#. Value${SEP}#. Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "1. Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "2. Value", myClipBoard.getValue().get( 1 ) );
        assertEquals( "3. Value", myClipBoard.getValue().get( 2 ) );

        assertEquals( "Rechner.AllMethods_MultipleValues", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValueREGX() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyValueREGX( "All_MethodsObj", "\\w{3} one and only Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );

    }

    /** 
     * \~german
     * \brief
     *
     * \~english
     * \~
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyValueREGX_MultipleValues() throws Exception
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

        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyValueREGX( "AllMethods_MultipleValues", "\\d+\\. Value${SEP}\\d+\\. Value${SEP}\\d+\\. Value" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 3, myClipBoard.getValue().size() );

        assertEquals( "1. Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( "2. Value", myClipBoard.getValue().get( 1 ) );
        assertEquals( "3. Value", myClipBoard.getValue().get( 2 ) );

        assertEquals( "Rechner.AllMethods_MultipleValues", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }
    
    /**
     * \~german
     * "Normaler" Testfall für das Schlüsselwort EN.VerifyMinLength(String,String). 
     * 
     *  \~english
     *  "Normal" test case for the keyword EN.VerifyMinLength(String,String).
     *  \~
     *  \author Daniel Krüger
     *  \date 2019.06.18
     */
    @Test
    public void tc_VerifyMinLength() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "2" );
        myClipBoard.Clear();
        EN.VerifyMinLength( "All_MethodsObj", "2" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "2", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyMinLength()", myClipBoard.getMethod() );
    }

}

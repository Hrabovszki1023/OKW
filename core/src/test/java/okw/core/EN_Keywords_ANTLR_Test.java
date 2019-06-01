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

import org.junit.*;
import org.junit.rules.TestName;


/** \~german
 * Testfälle für die Prüfung der ANTLR-Funktionalitäten der Schlüsselwörtern.
 * 
 * Geprüft wird:
 * * Gemerkte werte
 * * Umgebungsvariablen
 * 
 *
 * \~english
 * Test cases for checking the ANTLR functionalities of the keywords.
 * 
 * Is checked:
 *  * Notes values
 *  * environmental variables
 * \~
 * \author Zoltan Hrabovszki
 * \date 2016-05-07
 */
public class EN_Keywords_ANTLR_Test
{
    private static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    private static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName          name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLogger.setDebugMode( false );
    }

    /* @AfterClass
    public static void tearDownAfterClass() throws Exception
    {

    }
    */

    /*
    @Before
    public void setUp() throws Exception
    {
    }
    */

    @After
    public void myAfter() throws Exception
    {
        EN.EndTest();
    }

    /** \~german
     *  Prüft das Schlüsselwort "BeginTest" mit dem Testziel, dass der aktuelle Testfallname unter dem MemKey "TCN" (TestCaseName) gespeichert wird.
     * 
     *  \~english
     *  Checks the keyword "BeginTest" with the test objective that the current test case name is stored under the MemKey "TCN" (TestCaseName).
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-07
     */
    @Test
    public void tc_BeginTest_TestCaseName() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
        assertEquals( name.getMethodName(), OKW_Memorize_Sngltn.getInstance().get( "TCN" ) );
    }

    /** \~german
     *  Prüft das Keyword Select() mit dem Testziel ob gemerkte Werte richtig eingesetzt werden.
     * 
     *  \~english
     *  Checks the keyword Select() with the test objective of whether the memorized values are used correctly.
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-07
     */
    @Test
    public void tc_Select_MemorizedValue() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        // Set Memorize Values
        OKW_Memorize_Sngltn.getInstance().set( "myValue", "ValueToFind" );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.Select( "All_MethodsObj", "${myValue}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "ValueToFind", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "Select()", myClipBoard.getMethod() );
    }

    /**
     *  \~german
     *  Prüft das Keyword Select() mit dem Ziel, ob Umgebungsvariablen richtig eingesetzt werden.
     * 
     *  Als umgebungsvariable wird '${TCN}' verwendet.
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2016-05-07
     */
    @Test
    public void tc_Select_EnviromentVar() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        // Set Memorize Values

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Prüfung des Schlüsselwortes?
        EN.Select( "All_MethodsObj", "${TCN}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "Select()", myClipBoard.getMethod() );
    }

    /** \~german
     *  Prüft das Schlüsselwort Select mit dem Ziel ob gemerkte Werte richtig eingesetzt werden.
     * 
     *  \~english
     *  Checks the keyword Select with the aim to ensure that the values are used correctly.
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2016-05-07
     */
    @Test
    public void tc_Typekey_MemorizedValue() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        // Set Memorize Values
        OKW_Memorize_Sngltn.getInstance().set( "myValue", "ValueToFind" );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.TypeKey( "All_MethodsObj", "${myValue}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "ValueToFind", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
    }

    /// \~german
    /// \brief
    /// Prüft das Keyword Typekey mit dem Ziel, ob Umgebungsvariablen richtig eingesetzt werden.
    ///
    /// Als umgebungsvariable wird 'USER' verwendet.
    ///
    /// \~english
    /// \~
    /// \author Zoltan Hrabovszki
    /// \date 2016.05.07
    @Test
    public void tc_TypeKey_EnviromentVar() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        // Set Memorize Values
        String myUser = System.getenv( "USER" );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.TypeKey( "All_MethodsObj", "${USER}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( myUser, myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
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
    public void tc_VerifyExists_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "YES" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "YES" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyExists( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyExists()", myClipBoard.getMethod() );
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
    public void tc_VerifyHasFocus_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "YES" );

        EN.SetValue( "All_MethodsObj", "YES" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyHasFocus( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "NO" );

        EN.SetValue( "All_MethodsObj", "NO" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyHasFocus( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
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
    public void tc_VerifyIsActive_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "YES" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "YES" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyIsActive( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
    }

    /**
	 * \~german
	 *
	 * \~english
	 * \~
	 * \author Daniel Krüger
	 * \date 2019.04.04
	 */
	 @Test
	 public void tc_VerifyBadge_MemorizedValue() throws Exception
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
	
	     // Set Value in "Memory"
	     OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );
	
	     EN.SetValue( "All_MethodsObj", "The one and only Value" );
	     // Kommen auch mehrere Sollwerte im Objekt ab?
	     EN.VerifyBadge( "All_MethodsObj", "${Key1}" );
	
	     // Check the Name, Called Method and Value of Actuel object
	     //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
	     assertEquals( 1, myClipBoard.getValue().size() );
	
	     assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	     assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	 }

	/**
	 * \~german
	 * \brief
	 *
	 * \~english
	 * \~
	 * \author Daniel KRüger
	 * \date 2019.04.11
	 */
	 @Test
	 public void tc_VerifyBadgeWCM_MemorizedValue() throws Exception
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
	
	     // Set Value in "Memory"
	     OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );
	
	     // Wert in "All_MethodsObj" setzen.
	     EN.SetValue( "All_MethodsObj", "The one and only Value" );
	     // Prüfung des Schlüsselwortes?
	     EN.VerifyBadgeWCM( "All_MethodsObj", "${Key1}" );
	
	     // Check the Name, Called Method and Value of Actuel object
	     //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
	     assertEquals( 1, myClipBoard.getValue().size() );
	
	     assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	     assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	 }

	/**
	  * \~german
	  *
	  * \~english
	  * \~ 
	  * \author Daniel Krüger
	  * \date 2019.04.11
	  */
	 @Test
	 public void tc_VerifyBadgeREGX_MemorizedValue() throws Exception
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
	
	     // Set Value in "Memory"
	     OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );
	
	     EN.SetValue( "All_MethodsObj", "The one and only Value" );
	     EN.VerifyBadgeREGX( "All_MethodsObj", "${Key1}" );
	
	     // Check the Name, Called Method and Value of Actuel object
	     // assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
	     assertEquals( 1, myClipBoard.getValue().size() );
	
	     assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	     assertEquals( "VerifyBadge()", myClipBoard.getMethod() );
	 }

	/**
     *  \~german
     *  \brief
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     *  */
    @Test
    public void tc_VerifyCaption_EnviromentValue() throws Exception
    {

        // Set Memorize Values
        String myUser = System.getenv( "USER" );

        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", myUser );
        // Umgebungsvariable eingeben
        EN.VerifyCaption( "All_MethodsObj", "${USER}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( myUser, myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
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
    public void tc_VerifyCaption_MemorizedValue() throws Exception
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

        OKW_Memorize_Sngltn.getInstance();
        // Set Value in "Memory"
        OKW_Memorize_Sngltn.reset();
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyCaption( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
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
    public void tc_VerifyCaptionREGX_MemorizedValue() throws Exception
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

        OKW_Memorize_Sngltn.getInstance();
        // Set Value in "Memory"
        OKW_Memorize_Sngltn.reset();
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "\\w{3} one and only Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyCaptionREGX( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
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
    public void tc_VerifyCaptionWCM_MemorizedValue() throws Exception
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

        OKW_Memorize_Sngltn.getInstance();
        // Set Value in "Memory"
        OKW_Memorize_Sngltn.reset();
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "??? one and only Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyCaptionWCM( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
    }

    /**
    * \~german
    *
    * \~english
    * \~
    * \author Zoltan Hrabovszki
    * \date 2013.12.26
    */
    @Test
    public void tc_VerifyLabel_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyLabel( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
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
    public void tc_VerifyLabelWCM_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyLabelWCM( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     *
     * \~english
     * \~ 
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyLabelREGX_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyLabelREGX( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        // assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
    }

    /**
    * \~german
    *
    * \~english
    * \~
    * \author Zoltan Hrabovszki
    * \date 2013.12.26
    */
    @Test
    public void tc_VerifyPlaceholder_EnviromentVar() throws Exception
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
            
        EN.SetValue( "All_MethodsObj", "${TCN}" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyPlaceholder( "All_MethodsObj", "${TCN}" );
    
        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
    
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
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
    public void tc_VerifyPlaceholderWCM_EnviromentVar() throws Exception
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
       
        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "${TCN}" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "${TCN}" );
    
        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
    
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     *
     * \~english
     * \~ 
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyPlaceholderREGX_EnviromentVar() throws Exception
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
    
        EN.SetValue( "All_MethodsObj", "${TCN}" );
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "${TCN}" );
    
        // Check the Name, Called Method and Value of Actuel object
        // assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
    
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
    * \~german
    * \brief
    *
    * \~english
    * \~
    * \author Zoltan Hrabovszki
    * \date 2018.12.26
    */
    //@Test
    public void tc_VerifyMaxLength_EnviromentVar() throws Exception
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
       
        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "${VerifyMaxLength}" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyMaxLength( "All_MethodsObj", "${VerifyMaxLength}" );
    
        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
    
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     *
     * \~english
     * \~ 
     * \author Zoltan Hrabovszki
     * \date 2018.12.26
     */
    @Test
    public void tc_VerifyMaxLengthMemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "2" );
    
        EN.SetValue( "All_MethodsObj", "${Key1}" );
        EN.VerifyMaxLength( "All_MethodsObj", "${Key1}" );
    
        // Check the Name, Called Method and Value of Actuel object
        // assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );
    
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyMaxLength()", myClipBoard.getMethod() );
    }

    /**
    * \~german
    *
    * \~english
    * \~
    * \author Zoltan Hrabovszki
    * \date 2013.12.26
    */
    @Test
    public void tc_VerifyPlaceholder_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Placeholder" );

        EN.SetValue( "All_MethodsObj", "The one and only Placeholder" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyPlaceholder( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
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
    public void tc_VerifyPlaceholderWCM_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Placeholder" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Placeholder" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     * \~german
     *
     * \~english
     * \~ 
     * \author Zoltan Hrabovszki
     * \date 2013.12.26
     */
    @Test
    public void tc_VerifyPlaceholderREGX_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Placeholder" );

        EN.SetValue( "All_MethodsObj", "The one and only Placeholder" );
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        // assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyPlaceholder()", myClipBoard.getMethod() );
    }

    /**
     *  \~german
     *  \brief
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     *  */
  @Test
  public void tc__VerifySelectedValue_EnviromentValue() throws Exception
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

      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifySelectedValue( "All_MethodsObj", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
  }

  /**
   *  \~german
   *  \brief
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   *  */
  @Test
  public void tc__VerifySelectedValueREGX_EnviromentVar() throws Exception
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

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifySelectedValueREGX( "All_MethodsObj", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
  }

  /**
   *  \~german
   *  \brief
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   *  */
  @Test
  public void tc__VerifySelectedValueWCM_EnviromentVar() throws Exception
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

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifySelectedValueREGX( "All_MethodsObj", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
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
  public void tc_VerifySelectedValue_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Prüfung des Schlüsselwortes?
      EN.VerifySelectedValue( "All_MethodsObj", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
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
  public void tc_VerifySelectedValueWCM_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Kommen auch mehrere Sollwerte im Objekt ab?
      EN.VerifySelectedValueWCM( "All_MethodsObj", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
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
  public void tc_VerifySelectedValueREGX_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );

      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Kommen auch mehrere Sollwerte im Objekt ab?
      EN.VerifySelectedValueREGX( "All_MethodsObj", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
      assertEquals( 1, myClipBoard.getValue().size() );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
  }

    /**
     *  \~german
     *  \brief
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     *  */
  @Test
  public void tc__VerifyTablecellValue_EnviromentValue() throws Exception
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

      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifyTablecellValue( "All_MethodsObj", "X", "Y", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
  }

  /**
   *  \~german
   *  \brief
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   * 
   */
  @Test
  public void tc__VerifyTablecellValueREGX_EnviromentVar() throws Exception
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

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifyTablecellValueREGX( "All_MethodsObj", "X", "Y", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
  }

  /**
   *  \~german
   *  \brief
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   *  */
  @Test
  public void tc__VerifyTablecellValueWCM_EnviromentVar() throws Exception
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

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "${TCN}" );
      // Umgebungsvariable eingeben
      EN.VerifyTablecellValueREGX( "All_MethodsObj", "X", "Y", "${TCN}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
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
  public void tc_VerifyTablecellValue_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Prüfung des Schlüsselwortes?
      EN.VerifyTablecellValue( "All_MethodsObj", "X", "Y", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
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
  public void tc_VerifyTablecellValueWCM_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );

      // Wert in "All_MethodsObj" setzen.
      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Kommen auch mehrere Sollwerte im Objekt ab?
      EN.VerifyTablecellValueWCM( "All_MethodsObj", "X", "Y", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
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
  public void tc_VerifyTablecellValueREGX_MemorizedValue() throws Exception
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

      // Set Value in "Memory"
      OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );

      EN.SetValue( "All_MethodsObj", "The one and only Value" );
      // Kommen auch mehrere Sollwerte im Objekt ab?
      EN.VerifyTablecellValueREGX( "All_MethodsObj", "X", "Y", "${Key1}" );

      // Check the Name, Called Method and Value of Actuel object
      assertEquals( 3, myClipBoard.getValue().size() );
      assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
      assertEquals( "X", myClipBoard.getValue().get( 1 ) );
      assertEquals( "Y", myClipBoard.getValue().get( 2 ) );

      assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
      assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );
  }

  /**
   *  \~german
   *  \brief
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   *  */
@Test
public void tc__VerifyTooltip_EnviromentValue() throws Exception
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

    EN.SetValue( "All_MethodsObj", "${TCN}" );
    // Umgebungsvariable eingeben
    EN.VerifyTooltip( "All_MethodsObj", "${TCN}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
}

/**
 *  \~german
 *  \brief
 * 
 *  \~english
 *  \~
 *  \author Zoltan Hrabovszki
 *  \date 2013.12.26
 *  */
@Test
public void tc__VerifyTooltipREGX_EnviromentVar() throws Exception
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

    // Wert in "All_MethodsObj" setzen.
    EN.SetValue( "All_MethodsObj", "${TCN}" );
    // Umgebungsvariable eingeben
    EN.VerifyTooltipREGX( "All_MethodsObj", "${TCN}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
}

/**
 *  \~german
 *  \brief
 * 
 *  \~english
 *  \~
 *  \author Zoltan Hrabovszki
 *  \date 2013.12.26
 *  */
@Test
public void tc__VerifyTooltipWCM_EnviromentVar() throws Exception
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

    // Wert in "All_MethodsObj" setzen.
    EN.SetValue( "All_MethodsObj", "${TCN}" );
    // Umgebungsvariable eingeben
    EN.VerifyTooltipREGX( "All_MethodsObj", "${TCN}" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );

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
    public void tc_VerifyTooltip_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

        //Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        //Prüfung des Schlüsselwortes?
        EN.VerifyTooltip( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

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
    public void tc_VerifyTooltipWCM_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );

        //Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        //Prüfung des Schlüsselwortes?
        EN.VerifyTooltipWCM( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

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
    public void tc_VerifyTooltipREGX_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );

        //Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        //Prüfung des Schlüsselwortes?
        EN.VerifyTooltipREGX( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyTooltip()", myClipBoard.getMethod() );
    }

    /**
       *  \~german
       *  \brief
       * 
       *  \~english
       *  \~
       *  \author Zoltan Hrabovszki
       *  \date 2013.12.26
       *  */
    @Test
    public void tc__VerifyValue_EnviromentValue() throws Exception
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

        EN.SetValue( "All_MethodsObj", "${TCN}" );
        // Umgebungsvariable eingeben
        EN.VerifyValue( "All_MethodsObj", "${TCN}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /**
     *  \~german
     *  \brief
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     *  */
    @Test
    public void tc__VerifyValueREGX_EnviromentVar() throws Exception
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

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "${TCN}" );
        // Umgebungsvariable eingeben
        EN.VerifyValueREGX( "All_MethodsObj", "${TCN}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /**
     *  \~german
     *  \brief
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.26
     *  */
    @Test
    public void tc__VerifyValueWCM_EnviromentVar() throws Exception
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

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "${TCN}" );
        // Umgebungsvariable eingeben
        EN.VerifyValueREGX( "All_MethodsObj", "${TCN}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
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
    public void tc_VerifyValue_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "The one and only Value" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Prüfung des Schlüsselwortes?
        EN.VerifyValue( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
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
    public void tc_VerifyValueWCM_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", "* one and * Value" );

        // Wert in "All_MethodsObj" setzen.
        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyValueWCM( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
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
    public void tc_VerifyValueREGX_MemorizedValue() throws Exception
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

        // Set Value in "Memory"
        OKW_Memorize_Sngltn.getInstance().set( "Key1", ".* one and .* Value" );

        EN.SetValue( "All_MethodsObj", "The one and only Value" );
        // Kommen auch mehrere Sollwerte im Objekt ab?
        EN.VerifyValueREGX( "All_MethodsObj", "${Key1}" );

        // Check the Name, Called Method and Value of Actuel object
        //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
        assertEquals( 1, myClipBoard.getValue().size() );

        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    }

    /** \~german
     *  Prüft das Keyword SetValue mit dem Ziel ob gemerkte Werte richtig verarbeitet werden.
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-07
     */
    @Test
    public void tc_SetValue_MemorizedValue() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Set Memorize Values
        OKW_Memorize_Sngltn.getInstance().set( "myValue", "ValueToFind" );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "${myValue}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( "ValueToFind", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetValue()", myClipBoard.getMethod() );
    }


    /** \~german
     *  Prüft das Keyword Typekey mit dem Ziel, ob Umgebungsvariablen richtig eingesetzt werden.
     *
     *  Als umgebungsvariable wird 'USER' verwendet.
     *
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test
    public void tc__SetValue_EnviromentVar() throws Exception
    {

        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
        // Check the Name, Called Method and Value of Actuel object
        assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner", myClipBoard.getObjectName() );
        assertEquals( "SelectWindow()", myClipBoard.getMethod() );

        EN.SetValue( "All_MethodsObj", "${TCN}" );

        // Check the Name, Called Method and Value of Actuel object
        assertEquals( 1, myClipBoard.getValue().size() );
        assertEquals( name.getMethodName(), myClipBoard.getValue().get( 0 ) );
        assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
        assertEquals( "SetValue()", myClipBoard.getMethod() );
    }
}
	

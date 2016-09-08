package okw.core;

import static org.junit.Assert.*;
import okw.OKW_Memorize_Sngltn;
import okw.OKW_TestClipboard;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_Keywords_Test {
  static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
  static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

  @Rule
  public TestName          name        = new TestName();

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    // Reset des Loggers: Alle geladenen Instanzen löschen
    Logger_Sngltn.Init();

    // Log2Console myLog2Console = null;
    // myLog2Console = new Log2Console();
    // myLogger.AddLogger(myLog2Console);

    myLogger.setDebugMode( false );
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    System.out
        .println( "===========================================================================" );
    System.out.println( "= Ausgabe in die Datei: 'EN_Keywords_Test.html'" );
    System.out
        .println( "===========================================================================" );
    // myLog2HTML.Result2HTML( "EN_Keywords_Test.html" );
    System.out
        .println( "===========================================================================" );
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
    EN.EndTest();
  }

  // / \~german
  // / \brief
  // / Prüft methoden aufruf für einen einfachen Click.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_ClickOn() throws Exception {
    EN.BeginTest( name.getMethodName() );
    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.ClickOn( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "ClickOn()", myClipBoard.getMethod() );
  }

  // / \~german
  // / \brief
  // / Prüft den Methodenaufruf für einen Click mit ClickType.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_DoubleClickOn() throws Exception {

    EN.BeginTest( name.getMethodName() );
    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.DoubleClickOn( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "DoubleClickOn()", myClipBoard.getMethod() );
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
  public void tc_LogExists() throws Exception {

    EN.BeginTest( name.getMethodName() );
    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.LogExists( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "LogExists()", myClipBoard.getMethod() );
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
  public void tc_LogHasFocus() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.LogHasFocus( "All_MethodsObj" );

    // Check the Name, Called Method and Parameter
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "LogHasFocus()", myClipBoard.getMethod() );
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
  public void tc_LogIsActive() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.LogIsActive( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "LogIsActive()", myClipBoard.getMethod() );
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
  public void tc_LogSelected() throws Exception {
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

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_LogTablecellValue() throws Exception {
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

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_LogTooltip() throws Exception {
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

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_LogValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.LogValue( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "LogValue()", myClipBoard.getMethod() );
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
  public void tc_MemorizeExists() throws Exception {
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

    assertEquals( "YES",
        OKW_Memorize_Sngltn.getInstance().Get( "Key_TC_MemorizeExists" ) );
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
  public void tc_MemorizeHasFocus() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.MemorizeHasFocus( "All_MethodsObj", "Key_TC_Memorize_Focus" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "MemorizeHasFocus()", myClipBoard.getMethod() );

    assertEquals( "YES",
        OKW_Memorize_Sngltn.getInstance().Get( "Key_TC_Memorize_Focus" ) );
  }

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.01.04
  @Test
  public void tc_MemorizeIsActive() throws Exception {
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

    assertEquals( "YES",
        OKW_Memorize_Sngltn.getInstance().Get( "TC_MemorizeIsActive" ) );
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
  public void tc_MemorizeSelectedValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.MemorizeSelectedValue( "All_MethodsObj",
        "TC_MemorizeSelectedValue_Key_1" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "MemorizeSelectedValue()", myClipBoard.getMethod() );

    assertEquals(
        "MemorizeSelectedValue_Return_1${SEP}MemorizeSelectedValue_Return_2",
        OKW_Memorize_Sngltn.getInstance()
            .Get( "TC_MemorizeSelectedValue_Key_1" ) );
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
  public void tc_MemorizeTablecellValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.MemorizeTablecellValue( "All_MethodsObj", "Col", "Row",
        "TC_MemorizeTablecellVelue_Key_1" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 2, myClipBoard.getValue().size() );
    assertEquals( "Col", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Row", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "MemorizeTablecellValue()", myClipBoard.getMethod() );

    assertEquals( "MemorizeTablecellValue_1", OKW_Memorize_Sngltn.getInstance()
        .Get( "TC_MemorizeTablecellVelue_Key_1" ) );
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
  public void tc_MemorizeTooltip() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.MemorizeTooltip( "All_MethodsObj", "TC_MemorizeTooltip_Key_1" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "MemorizeTooltip()", myClipBoard.getMethod() );

    assertEquals( "MemorizeTooltip_Return_1${SEP}MemorizeTooltip_Return_2",
        OKW_Memorize_Sngltn.getInstance().Get( "TC_MemorizeTooltip_Key_1" ) );
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
  public void tc_MemorizeValue() throws Exception {
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

    assertEquals( "MemorizeValue_Return_1", OKW_Memorize_Sngltn.getInstance()
        .Get( "TC_Memorize_Key_1" ) );
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
  public void tc_SelectMenu() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.SelectMenu( "All_MethodsObj" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectMenu()", myClipBoard.getMethod() );
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
  public void tc_SelectMenu_Value_MV() throws Exception {
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
    assertEquals( "SelectMenu_Value()", myClipBoard.getMethod() );
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
  public void tc_SelectMenu_Value_SV() throws Exception {
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
    assertEquals( "SelectMenu_Value()", myClipBoard.getMethod() );
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
  public void tc_SelectTablecell() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    EN.SelectTablecell( "All_MethodsObj", "COL", "ROW" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectTablecell()", myClipBoard.getMethod() );
    assertEquals( "COL", myClipBoard.getValue().get( 0 ) );
    assertEquals( "ROW", myClipBoard.getValue().get( 1 ) );
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
  public void tc_SelectTablecell_Clicktype() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    EN.SelectTablecell( "All_MethodsObj", "COL", "ROW", "DOUBLECLICK" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SelectTablecellClicktype()", myClipBoard.getMethod() );
    assertEquals( "COL", myClipBoard.getValue().get( 0 ) );
    assertEquals( "ROW", myClipBoard.getValue().get( 1 ) );
    assertEquals( "DOUBLECLICK", myClipBoard.getValue().get( 2 ) );
  }

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.03.19
  @Test
  public void tc_SelectWindow() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
  }

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.03.19
  @Test
  public void tc_SelectWindow_MV() throws Exception {
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

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2014.03.19
  @Test
  public void tc_SelectWindow_SV() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.TypeKeyWindow( "Rechner", "Wert" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Wert", myClipBoard.getValue().get( 0 ) );
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
  public void tc_Select_Clicktype() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    EN.Select( "All_MethodsObj", "Hanna", "DOUBLEClick" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "Select_Clicktype()", myClipBoard.getMethod() );

    assertEquals( 2, myClipBoard.getValue().size() );
    assertEquals( "Hanna", myClipBoard.getValue().get( 0 ) );
    assertEquals( "DOUBLEClick", myClipBoard.getValue().get( 1 ) );
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
  public void tc_Select_MultipleValue() throws Exception {
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
  public void tc_Select_SingleValue() throws Exception {
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

  // / \~german
  // / \brief
  // /
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_Sequence() throws Exception {
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
    assertEquals( "TestSequence_1()", myClipBoard.getMethod());
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
  public void tc_SetFocus() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    
    EN.SetFocus( "All_MethodsObj" );

    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "SetFocus()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );

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
  public void tc_SetValue_MultipleValues() throws Exception {
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
  public void tc_SetValue_SV() throws Exception {
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


  // / \~german
  // / \brief
  // / Prüft den Methodenaufruf StartApp.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_StartApp() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.StartApp( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "StartApp()", myClipBoard.getMethod() );
  }

  // / \~german
  // / \brief
  // / Prüft den Methodenaufruf StopApp.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_StopApp() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.StopApp( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "StopApp()", myClipBoard.getMethod() );
  }

  // / \~german
  // / \brief
  // / Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey
  // Übertragen wird.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_TypeKeyTablecell_MultipleValues() throws Exception {
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

  // / \~german
  // / \brief
  // / Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Type key
  // Übertragen wird.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_TypeKeyTablecell_SingelValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );

    EN.TypeKeyTablecell( "All_MethodsObj", "1", "2", "CTRL A" );
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals(
        "TypeKeyTablecell(String COL, String ROW, List<String> Values)",
        myClipBoard.getMethod() );

    assertEquals( 3, myClipBoard.getValue().size() );
    assertEquals( "1", myClipBoard.getValue().get( 0 ) );
    assertEquals( "2", myClipBoard.getValue().get( 1 ) );
    assertEquals( "CTRL A", myClipBoard.getValue().get( 2 ) );
  }

  // / \~german
  // / \brief
  // / Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Typekey
  // Übertragen wird.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_TypeKey_MultipleValues() throws Exception {
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

  // / \~german
  // / \brief
  // / Prüft, ob ein einzelner Wert, oder ein einzelne Zeile an Type key
  // Übertragen wird.
  // /
  // / \~english
  // / \~
  // / \author Zoltan Hrabovszki
  // / \date 2013.12.26
  @Test
  public void tc_TypeKey_SingelValue() throws Exception {
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
  public void tc_VerifyCaption() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

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
  public void tc_VerifyCaptionREGX() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

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
  public void tc_VerifyCaptionWCM() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyCaptionWCM( "All_MethodsObj", "??? one and only Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyCaption()", myClipBoard.getMethod() );
  }

  /**
   * \~german
   * \brief "Normaler" Testfall für das Schlüsselwort EN.VerifyLabel(String,String).
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabel() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyLabel( "All_MethodsObj", "The one and only Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
  }
  
  /**
   * \~german
   * \brief "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelREGX(String,String).
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabelREGX() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyLabelREGX( "All_MethodsObj", "\\w{3} one and only Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
  }

  /**
   * \~german
   * \brief "Normaler" Testfall für das Schlüsselwort EN.VerifyLabelWCM(String,String). 
   * 
   *  \~english
   *  \~
   *  \author Zoltan Hrabovszki
   *  \date 2013.12.26
   */
  @Test
  public void tc_VerifyLabelWCM() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyLabelWCM( "All_MethodsObj", "??? one and only Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyLabel()", myClipBoard.getMethod() );
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
  public void tc_VerifyExists() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyExists( "All_MethodsObj", "YES" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "TRUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyExists()", myClipBoard.getMethod() );
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
  public void tc_VerifyHasFocus() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    
    EN.VerifyHasFocus( "All_MethodsObj", "YES" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "true", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );

    myClipBoard.Clear();
    
    EN.VerifyHasFocus( "All_MethodsObj", "NO" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "false", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );

  
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
  public void tc_VerifyIsActive() throws Exception {
    EN.BeginTest( name.getMethodName() );

    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    myClipBoard.Clear();
    
    EN.VerifyIsActive( "All_MethodsObj", "YES" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );

    myClipBoard.Clear();

    EN.VerifyIsActive( "All_MethodsObj", "NO" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
    assertEquals( 1, myClipBoard.getValue().size() );
  
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
  public void tc_VerifySelectedValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    // Einzelner Wert
    EN.VerifySelectedValue( "All_MethodsObj", "Sollwert_Einstellen" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Sollwert_Einstellen", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );

    // Mehrerer Werte
    EN.VerifySelectedValue( "All_MethodsObj", "Sollwert_1${SEP}Sollwert_2" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Sollwert_1", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Sollwert_2", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifySelectedValue()", myClipBoard.getMethod() );
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
  public void tc_VerifyTablecellValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row", "Sollwert_1" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Col", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Row", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Sollwert_1", myClipBoard.getValue().get( 2 ) );
    assertEquals( 3, myClipBoard.getValue().size() );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyTablecellValue()", myClipBoard.getMethod() );

    // Kommen auch mehrere Sollwerte im Objekt ab?
    EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row",
        "Sollwert_1${SEP}Sollwert_2" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "Col", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Row", myClipBoard.getValue().get( 1 ) );
    assertEquals( "Sollwert_1", myClipBoard.getValue().get( 2 ) );
    assertEquals( "Sollwert_2", myClipBoard.getValue().get( 3 ) );
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
  public void tc_VerifyTooltip() throws Exception {
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
  public void tc_VerifyTooltipREGX() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

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
  public void tc_VerifyTooltipWCM() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

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
  public void tc_VerifyValue() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

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
  public void tc_VerifyValue_MultipleValues() throws Exception {
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
  public void tc_VerifyValueWCM() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyValueWCM( "All_MethodsObj", "??? one and only Value" );

    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "The one and only Value", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyValue()", myClipBoard.getMethod() );
    
    EN.VerifyValueWCM( "All_MethodsObj","The one and only Value" );
    EN.VerifyValueWCM( "All_MethodsObj","??? ??? ??? ???? ?????" );
    EN.VerifyValueWCM( "All_MethodsObj","* * * * *" );
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
  public void tc_VerifyValueWCM_MultipleValues() throws Exception {
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
  public void tc_VerifyValueREGX() throws Exception {
    EN.BeginTest( name.getMethodName() );

    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );

    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );

    EN.VerifyValueREGX( "All_MethodsObj","\\w{3} one and only Value" );

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
  public void tc_VerifyValueREGX_MultipleValues() throws Exception {
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

    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
    assertEquals( "VerifyValue()", myClipBoard.getMethod() );
  }


}

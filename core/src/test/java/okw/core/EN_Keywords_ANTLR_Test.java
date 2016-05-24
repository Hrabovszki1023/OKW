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


/// \~german
/// \brief
/// Testfälle für die Prüfung der ANTLR-Funktionalitäten in den Schlüsselwörtern.
/// 
/// Geprüft wird:
/// * Gemerkte werte
/// * Umgebungsvariablen
/// 
///
/// \~english
/// \~
/// \author Zoltan Hrabovszki
/// \date 2016.05.07
public class EN_Keywords_ANTLR_Test
{
	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

    @Rule
    public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();
        
        myLogger.setDebugMode(false);
	}

	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}

	
	@Before
	public void setUp() throws Exception
	{
	}

	
	@After
	public void tearDown() throws Exception
	{
        EN.EndTest();
	}


	/// \~german
	/// \brief
	/// Prüft das Keyword Select mit dem Ziel ob gemerkte Werte richtig eingesetzt werden.
	///
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2016.05.07
	@Test
	public void TC_Select_MemorizedValue() throws Exception
	{
		
		EN.BeginTest( name.getMethodName() );

		// Set Memorize Values
		OKW_Memorize_Sngltn.getInstance().Set( "myValue", "ValueToFind" );

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		EN.Select("All_MethodsObj", "${myValue}");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals( 1, myClipBoard.getValue().size());
		assertEquals("ValueToFind", myClipBoard.getValue().get(0));
		assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
		assertEquals("Select()", myClipBoard.getMethod());
	}

	/// \~german
	/// \brief
	/// Prüft das Keyword Select mit dem Ziel, ob Umgebungsvariablen richtig eingesetzt werden.
	///
	/// Als umgebungsvariable wird 'USER' verwendet.
	///
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2016.05.07
	@Test
	public void TC_Select_EnviromentVar() throws Exception
	{
		
		EN.BeginTest( name.getMethodName() );

		// Set Memorize Values
		String myUser = System.getenv( "USER" );

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		EN.Select("All_MethodsObj", "${USER}");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals( 1, myClipBoard.getValue().size());
		assertEquals( myUser, myClipBoard.getValue().get(0));
		assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
		assertEquals("Select()", myClipBoard.getMethod());
	}

	
	/// \~german
	/// \brief
	/// Prüft das Keyword Select mit dem Ziel ob gemerkte Werte richtig eingesetzt werden.
	///
	/// \~english
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2016.05.07
	@Test
	public void TC_Typekey_MemorizedValue() throws Exception
	{
		
		EN.BeginTest( name.getMethodName() );

		// Set Memorize Values
		OKW_Memorize_Sngltn.getInstance().Set( "myValue", "ValueToFind" );

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		EN.TypeKey("All_MethodsObj", "${myValue}");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals( 1, myClipBoard.getValue().size());
		assertEquals("ValueToFind", myClipBoard.getValue().get(0));
		assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
		assertEquals("TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod());
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
	public void TC_TypeKey_EnviromentVar() throws Exception
	{
		
		EN.BeginTest( name.getMethodName() );

		// Set Memorize Values
		String myUser = System.getenv( "USER" );

		// Testscript in Schlüsselwort-Notation
		EN.SelectWindow("Rechner");

		// Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
		// Check the Name, Called Method and Value of Actuel object
		assertEquals("NO VALUE", myClipBoard.getValue().get(0));
		assertEquals("Rechner", myClipBoard.getObjectName());
		assertEquals("SelectWindow()", myClipBoard.getMethod());

		EN.TypeKey( "All_MethodsObj", "${USER}");

		// Check the Name, Called Method and Value of Actuel object
		assertEquals( 1, myClipBoard.getValue().size() );
		assertEquals( myUser, myClipBoard.getValue().get(0) );
		assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
		assertEquals( "TypeKey(List<String> fpLs_Value)", myClipBoard.getMethod() );
	}
}
	
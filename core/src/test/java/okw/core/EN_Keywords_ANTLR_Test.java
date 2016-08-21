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
	  public void tc_VerifyExists_MemorizedValue() throws Exception {
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
	    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "YES" );
	    
	    // Kommen auch mehrere Sollwerte im Objekt ab?
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
	  public void tc_VerifyHasFocus_MemorizedValue() throws Exception {
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
	    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "YES" );
	    
	    // Kommen auch mehrere Sollwerte im Objekt ab?
	    EN.VerifyHasFocus( "All_MethodsObj", "${Key1}" );
	  
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "true", myClipBoard.getValue().get( 0 ) );
	    assertEquals( 1, myClipBoard.getValue().size() );
	  
	    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	    assertEquals( "VerifyHasFocus()", myClipBoard.getMethod() );
	    
	    // Set Value in "Memory"
	    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "NO" );
	    
	    // Kommen auch mehrere Sollwerte im Objekt ab?
	    EN.VerifyHasFocus( "All_MethodsObj", "${Key1}" );
	  
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "false", myClipBoard.getValue().get( 0 ) );
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
	  public void tc_VerifyIsActive_MemorizedValue() throws Exception {
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
	    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "YES" );
	    
	    // Kommen auch mehrere Sollwerte im Objekt ab?
	    EN.VerifyIsActive( "All_MethodsObj", "${Key1}" );
	  
	    // Check the Name, Called Method and Value of Actuel object
	    assertEquals( "YES", myClipBoard.getValue().get( 0 ) );
	    assertEquals( 1, myClipBoard.getValue().size() );
	  
	    assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	    assertEquals( "VerifyIsActive()", myClipBoard.getMethod() );
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
  public void tc_VerifyCaption_EnviromentValue() throws Exception {

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
  public void tc_VerifyCaption_MemorizedValue() throws Exception {
    EN.BeginTest( name.getMethodName() );
  
    // Testscript in Schlüsselwort-Notation
    EN.SelectWindow( "Rechner" );
  
    // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
    assertEquals( 1, myClipBoard.getValue().size() );
    assertEquals( "Rechner", myClipBoard.getObjectName() );
    assertEquals( "SelectWindow()", myClipBoard.getMethod() );
    
    okw.OKW_Memorize_Sngltn.getInstance();
	// Set Value in "Memory"
    OKW_Memorize_Sngltn.Reset();
    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "The one and only Value" );
    
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
 public void tc_VerifyCaptionREGX_MemorizedValue() throws Exception {
   EN.BeginTest( name.getMethodName() );
 
   // Testscript in Schlüsselwort-Notation
   EN.SelectWindow( "Rechner" );
 
   // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
   // Check the Name, Called Method and Value of Actuel object
   assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
   assertEquals( 1, myClipBoard.getValue().size() );
   assertEquals( "Rechner", myClipBoard.getObjectName() );
   assertEquals( "SelectWindow()", myClipBoard.getMethod() );
   
   okw.OKW_Memorize_Sngltn.getInstance();
 // Set Value in "Memory"
   OKW_Memorize_Sngltn.Reset();
   okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "\\w{3} one and only Value" );
   
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
public void tc_VerifyCaptionWCM_MemorizedValue() throws Exception {
  EN.BeginTest( name.getMethodName() );

  // Testscript in Schlüsselwort-Notation
  EN.SelectWindow( "Rechner" );

  // Soll/Ist-Vergleich: Ist das Richtige Fenster gesetzt?
  // Check the Name, Called Method and Value of Actuel object
  assertEquals( "NO VALUE", myClipBoard.getValue().get( 0 ) );
  assertEquals( 1, myClipBoard.getValue().size() );
  assertEquals( "Rechner", myClipBoard.getObjectName() );
  assertEquals( "SelectWindow()", myClipBoard.getMethod() );
  
  okw.OKW_Memorize_Sngltn.getInstance();
// Set Value in "Memory"
  OKW_Memorize_Sngltn.Reset();
  okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "??? one and only Value" );
  
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
* \brief
*
* \~english
* \~
* \author Zoltan Hrabovszki
* \date 2013.12.26
*/
@Test
public void tc_VerifyLabel_MemorizedValue() throws Exception {
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
 okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "The one and only Value" );
 
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
public void tc_VerifyLabelWCM_MemorizedValue() throws Exception {
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
okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "* one and * Value" );

// Kommen auch mehrere Sollwerte im Objekt ab?
EN.VerifyLabelWCM( "All_MethodsObj", "${Key1}" );

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
public void tc_VerifyLabelREGX_MemorizedValue() throws Exception {
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
okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", ".* one and .* Value" );

// Kommen auch mehrere Sollwerte im Objekt ab?
EN.VerifyLabelREGX( "All_MethodsObj", "${Key1}" );

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
public void tc_VerifyTooltip_MemorizedValue() throws Exception {
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
 okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "The one and only Value" );
 
 // Kommen auch mehrere Sollwerte im Objekt ab?
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
public void tc_VerifyTooltipWCM_MemorizedValue() throws Exception {
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
okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "* one and * Value" );

// Kommen auch mehrere Sollwerte im Objekt ab?
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
public void tc_VerifyTooltipREGX_MemorizedValue() throws Exception {
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
okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", ".* one and .* Value" );

// Kommen auch mehrere Sollwerte im Objekt ab?
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
  public void tc_VerifyValue_EnviromentValue() throws Exception {

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
      
    // Umgebungsvariable eingeben
    EN.VerifyValue( "All_MethodsObj", "${USER}" );
  
    // Check the Name, Called Method and Value of Actuel object
    assertEquals( myUser, myClipBoard.getValue().get( 0 ) );
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
public void tc_VerifyValueREGX_EnviromentValue() throws Exception {

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
  
// Umgebungsvariable eingeben
EN.VerifyValueREGX( "All_MethodsObj", "${USER}" );

// Check the Name, Called Method and Value of Actuel object
assertEquals( myUser, myClipBoard.getValue().get( 0 ) );
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
  public void tc_VerifyValue_MemorizedValue() throws Exception {
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
    okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "The one and only Value" );
    
    // Kommen auch mehrere Sollwerte im Objekt ab?
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
 public void tc_VerifyValueWCM_MemorizedValue() throws Exception {
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
   okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", "* one and * Value" );
   
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
public void tc_VerifyValueREGX_MemorizedValue() throws Exception {
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
  okw.OKW_Memorize_Sngltn.getInstance().Set( "Key1", ".* one and .* Value" );
  
  // Kommen auch mehrere Sollwerte im Objekt ab?
  EN.VerifyValueREGX( "All_MethodsObj", "${Key1}" );

  // Check the Name, Called Method and Value of Actuel object
  //assertEquals( "Wert 1", myClipBoard.getValue().get( 0 ) );
  assertEquals( 1, myClipBoard.getValue().size() );

  assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
  assertEquals( "VerifyValue()", myClipBoard.getMethod() );
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
public void TC_SetValue_MemorizedValue() throws Exception
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

	EN.SetValue("All_MethodsObj", "${myValue}");

	// Check the Name, Called Method and Value of Actuel object
	assertEquals( 1, myClipBoard.getValue().size());
	assertEquals("ValueToFind", myClipBoard.getValue().get(0));
	assertEquals("Rechner.All_MethodsObj", myClipBoard.getObjectName());
	assertEquals("SetValue()", myClipBoard.getMethod());
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
public void TC_SetValue_EnviromentVar() throws Exception
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

	EN.SetValue( "All_MethodsObj", "${USER}");

	// Check the Name, Called Method and Value of Actuel object
	assertEquals( 1, myClipBoard.getValue().size() );
	assertEquals( myUser, myClipBoard.getValue().get(0) );
	assertEquals( "Rechner.All_MethodsObj", myClipBoard.getObjectName() );
	assertEquals( "SetValue()", myClipBoard.getMethod() );
}
}
	
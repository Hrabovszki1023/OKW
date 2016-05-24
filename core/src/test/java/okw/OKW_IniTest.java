
package okw;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.*;
import org.junit.rules.TestName;

import static org.junit.Assert.*;
import okw.core.EN;
import okw.exceptions.OKWFileDoesNotExistsException;
import okw.log.Logger_Sngltn;


public class OKW_IniTest
{
	@Rule
	public TestName	name	= new TestName();
    
	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();
    
	static String			myOKW_Xml	= "";

	protected static void setEnv( String fpsKey, String fpsValue )
	{
		try
		{
			Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
			Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
			theEnvironmentField.setAccessible(true);

			@SuppressWarnings({ "unchecked" }) // this will be a Map or the test
												// will fail if Java internals
												// are changed
			Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
			env.put(fpsKey, fpsValue);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@After
	public void myTestFixtureTearDown() throws Exception
	{
		EN.EndTest();
	}

	@Before
	public void myTestFixtureSetUp() throws Exception
	{
		EN.BeginTest( name.getMethodName() );
	}

	@BeforeClass
	public static void MySetUp()
	{
        // Reset des Loggers: Alle Instanzen löschen
        //Logger_Sngltn.Init();
        
        myLogger.setDebugMode(false);
	}

	@AfterClass
	public static void MyTearDown()
	{

	}

	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	@Ignore
	public void TC_Windows_OKW_Env_Set_XML_Exist()
	{
		String OKW_Xml = "";

		try
		{
			// 1. Merken wir den aktuellen OKW_Xml Wert
			OKW_Xml = System.getenv("OKW_Xml");

			assertEquals(true, OKW_FileHelper.DirectoryExists(OKW_Xml));

			// 2. Wert auf den 1. definierten Wert setzen
			OKW_Ini_Sngltn.Reset();
			OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();

			// Sind die Angaben zu OKW_Ini_Sngltn.xml Richtig?
			assertEquals(true, OKW_FileHelper.FileExists(myOKW_Ini.OKW_Enviroment.getFile_OKW_Ini_xml()));
			assertEquals(true, OKW_FileHelper.FileExists(myOKW_Ini.OKW_Enviroment.getFile_OKW_Keymaps_xml()));

			// Folgende Datein werden zur ggf zur Laufzeit angelegt. Daher
			// erfolgt hier nur die Prüfung ob die Zile verzeichnisse vorhanden
			// sind.
			assertEquals(true, OKW_FileHelper
					.DirectoryExists(Paths.get(myOKW_Ini.OKW_Enviroment.getFile_OKW_Memorize_xml()).toString()));
			assertEquals(true, OKW_FileHelper.DirectoryExists(
					Paths.get(myOKW_Ini.OKW_Enviroment.getFile_OKW_ImplementationMatrix_xml()).toString()));

			assertEquals(true, OKW_FileHelper.DirectoryExists(myOKW_Ini.OKW_Enviroment.getFolder_XML()));
			assertEquals(true, OKW_FileHelper.DirectoryExists(myOKW_Ini.OKW_Enviroment.getFolder_LogMessages()));

		}
		finally
		{
			// Umgebung zurücksetzen...
		}
	}

	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	@Ignore
	public void TC_Check_All_Path_with_OKW_Xml()
	{
		String OKW_Xml_Path_Expected = "";

		OKW_Xml_Path_Expected = System.getenv("OKW_Xml");

		OKW_Ini_Sngltn.Reset();
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();

		assertEquals(OKW_Xml_Path_Expected, myOKW_Ini.OKW_Enviroment.getFolder_XML());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "LogMessages"), myOKW_Ini.OKW_Enviroment.getFolder_LogMessages());

		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_Const.xml"),
				myOKW_Ini.OKW_Enviroment.getFile_OKW_Const_xml());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_Docu.xml"), myOKW_Ini.OKW_Enviroment.getFile_OKW_Docu_xml());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_ImplementationMatrix.xml"),
				myOKW_Ini.OKW_Enviroment.getFile_OKW_ImplementationMatrix_xml());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_Ini_Sngltn.xml"),
				myOKW_Ini.OKW_Enviroment.getFile_OKW_Ini_xml());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_Keymaps.xml"),
				myOKW_Ini.OKW_Enviroment.getFile_OKW_Keymaps_xml());
		assertEquals(Paths.get(OKW_Xml_Path_Expected, "OKW_Memorize.xml"),
				myOKW_Ini.OKW_Enviroment.getFile_OKW_Memorize_xml());
	}

	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	@Test
	@Ignore
	public void TC_Check_All_Path_without_OKW_Xml()
	{
		String OKW_Xml_original = "";
		String OKW_Xml_Path = "";
		Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

		try
		{

			// ------------------------------------------------------------------------------
			// SetUp der Umgebung
			// ------------------------------------------------------------------------------
			String SolutionDir = System.getenv("SolutionDir");
			String Path_XML_Source = Paths.get(SolutionDir, "XML").toString();
			String Path_XML_Destination = Paths.get(SolutionDir, "bin\\Debug\\XML").toString();

			myLogger.LogPrint("         SolutionDir:" + SolutionDir);
			myLogger.LogPrint("     Path_XML_Source:" + Path_XML_Source);
			myLogger.LogPrint("Path_XML_Destination:" + Path_XML_Destination);

			// ------------------------------------------------------------------------------
			// 1. Merken wir den aktuellen OKW_Xml Wert
			OKW_Xml_original = System.getenv("OKW_Xml");
			OKW_Xml_Path = Paths.get(OKW_Xml_original).toString();

			// ------------------------------------------------------------------------------
			// 2. Umgebungsvariable löschen!
			setEnv("OKW_Xml", "");

			// Prüfen ob die Umgebungsvariable nicht vorhanden ist.
			assertEquals(null, System.getenv("OKW_Xml"));

			// ------------------------------------------------------------------------------
			// 3. kopieren des XML-Verzechnisses zur OKW.dll
			OKW_FileHelper.DirectoryDelete(Path_XML_Destination);
			// Das Zielverzeichniss löschen.
			OKW_FileHelper.DirectoryCopy(Path_XML_Source, Path_XML_Destination);

			// ------------------------------------------------------------------------------
			// Test durchführen...
			// ------------------------------------------------------------------------------

			// OKW_Ini Resetten (Instanz löschen) und anschliessen instanz
			// neuanlegen
			OKW_Ini_Sngltn.Reset();
			OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();

			assertEquals(Paths.get(SolutionDir, "bin\\Debug").toString(), myOKW_Ini.MyDirectory());
			assertEquals(Path_XML_Destination, myOKW_Ini.OKW_Enviroment.getFolder_XML());
			assertEquals(Paths.get(Path_XML_Destination, "OKW_Ini_Sngltn.xml"),
					myOKW_Ini.OKW_Enviroment.getFile_OKW_Ini_xml());

		}
		finally
		{

			// ------------------------------------------------------------------------------
			// Wieder Herstellen der Umgebung
			// ------------------------------------------------------------------------------
			// Umgebung zurücksetzen...
			setEnv("OKW_Xml", OKW_Xml_original);
		}
	}

	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt, OKW_Ini_Sngltn.XML existiert jedoch nicht
	/// im Verzeichniss..
	///
	/// Ziel der Prüfung ist ob die richtige Exception ausgelöst wird,
	/// wenn die Umgebungsvariable auf einen falschen Pfad zeigt.
	///
	/// Umgebungsvariable ist gesetzt zeigt auf ein nicht vorhandenes
	/// Verzeichniss.
	///
	/// Erwartet wird dass eine "OKWFileDoesNotExistsException"-Ausnahme
	/// ausglöst wird.
	/// Geprüft wird auch ob richtige Meldung kommt.
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	@Test
	@Ignore
	public void TC_Windows_OKW_Env_Set_XML_NotExist_Exception()
	{
		// 1. Merken wir den aktuellen OKW_Xml Wert
		String OKW_Xml_original = System.getenv("OKW_Xml");

		// Umgebunsvariable auf eine nicht vorhandenen Wert setzen
		String SolutionDir = System.getenv("WORKSPACE");
		String Path_XML_invalid = Paths.get(SolutionDir, "invalid").toString();

		setEnv("OKW_Xml", Path_XML_invalid);

		// Prüfling Zurücksetzten.
		OKW_Ini_Sngltn.Reset();

		try
		{
			OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
			Assert.fail("Exception wurde nicht ausgelöst");
		}
		catch (OKWFileDoesNotExistsException e)
		{
			// Richtige Exception wurde ausgelöst.
			Logger_Sngltn.getInstance().LogPrint("OKWFileDoesNotExistsException: " + e.getMessage());
			assertEquals("Directory not found: >>" + Path_XML_invalid + "<<", e.getMessage());

			// Assert. pass("Exception wurde ausgelöst, das ist für diesen Test
			// OK!");
		}
		finally
		{
			setEnv("OKW_Xml", OKW_Xml_original);
		}
	}

	/// \~german Prüft alle Pfade als gegen Ressorce verzeichniss.
	/// \brief
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	@Test
	public void TC_VerifyFolder_XML()
	{
		
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		String xml_Folder = classLoader.getResource("xml").getPath();
		
		// Prüfling Zurücksetzten.
		OKW_Ini_Sngltn.Reset();

		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();

		
		// XML "Base-"Folder
		String ExpectedDir = xml_Folder;
		String Actuell = myOKW_Ini.OKW_Enviroment.getFolder_XML();

		assertEquals(ExpectedDir, Actuell);

		// XML "Base-"Folder
		ExpectedDir = xml_Folder + "/logmessages";
	    Actuell = myOKW_Ini.OKW_Enviroment.getFolder_LogMessages();

		assertEquals(ExpectedDir, Actuell);

	}
	
	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_Const()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

		
       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_Const_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_Const.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);

	}

	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_Docu()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

		
       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_Docu_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_Docu.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);
	}
	
	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_ImplementationMatrix()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_ImplementationMatrix_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_ImplementationMatrix.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);

	}

	
	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_Ini()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_Ini_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_Ini.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);
        
	}
	
	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_Keymaps()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_Keymaps_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_Keymaps.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);

	}
	
	/// \~german
	/// \brief
	/// Umgebungsvariable ist gesetzt. Prüfung ob Wert aus OKW_Ini gelesen wird.
	/// * Umgebungsvariable setzten.
	/// * OKW_Ini Instanzieren.
	/// * OKW_Ini_Sngltn.xml existiert und ist an der Richtigen stelle.
	/// * OKW_Ini_Sngltn.OKW_Ini_Xml Prüfen.
	/// * OKW_Ini Eigenschaften Prüfen.
	///
	/// \~
	/// \author Zoltan Hrabovszki
	/// \date 2013.11.25
	// [Category("WIN")]
	@Test
	public void TC_Check_Path_OKW_Memorize()
	{
		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
		
		String OKW_Xml_Path_Expected = myOKW_Ini.OKW_Enviroment.getFolder_XML();

       	String sActual = myOKW_Ini.OKW_Enviroment.getFile_OKW_Memorize_xml();
    	String sExpected = Paths.get(OKW_Xml_Path_Expected, "OKW_Memorize.xml").toString();

    	myLogger.LogPrint( "  Aktual Value: " + sActual);
    	myLogger.LogPrint( "Expected Value: " + sExpected);

        // Check Return
        assertEquals(sExpected, sActual);

	}

	public static String getJarExecutionDirectory()
	{
		String jarFile = null;
		String jarDirectory = null;
		int cutFileSeperator = 0;
		int cutSemicolon = -1;

		jarFile = System.getProperty("java.class.path");
		// Cut seperators
		cutFileSeperator = jarFile.lastIndexOf(System.getProperty("file.separator"));
		jarDirectory = jarFile.substring(0, cutFileSeperator);
		// Cut semicolons
		cutSemicolon = jarDirectory.lastIndexOf(';');
		jarDirectory = jarDirectory.substring(cutSemicolon + 1, jarDirectory.length());

		return jarDirectory + System.getProperty("file.separator");
	}
}
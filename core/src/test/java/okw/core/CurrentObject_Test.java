package okw.core;

import static org.junit.Assert.*;

import javax.xml.xpath.XPathExpressionException;

import org.junit.*;

import okw.*;
import okw.exceptions.OKWFrameObjectWindowNotSetException;
import okw.log.*;

public class CurrentObject_Test {


	        static OKW_CurrentObject_Sngltn CO = null;
	        
	    	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	    	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();
	        
	        Core myKernel= new Core();

	        /// \brief
	        /// Ziel des TestFixturesetup: Startbedingung für alle Testfälle herstellen.
	        /// Der Aufruf erfolgt genau einmal vor allen Testfällen.
	        /// 
	        /// Folgende Aktivitäten werden durchgeführt:
	        /// * Log2NUnit in den Logger laden.
	        /// * Debug-Modus des Logger -s abschalten.
	        /// * Logmessanger Spracheinstellung auf DE setzen.
	        /// 
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	        @BeforeClass
	        public static void TestFixtureSetUp()
	        {
	            try
	            {
	                // Reset des Loggers: Alle geladenen Instanzen löschen
	            	Logger_Sngltn.Init();
	                
	                // Log2NUnit in den Logger laden.
	            	//myLogger.AddLogger(new Log2NUnit());
	                
	                // Log2NUnit in den Logger laden.
	            	//myLogger.AddLogger(new Log2Console());
	                //myLogger.AddLogger(new Log2HTMLFile("C:\\temp\\Test_CurrentObject.htm"));

	                // Debug-Modus des Logger -s abschalten.
	            	myLogger.setDebugMode(false);

	                // Logmessenger Spracheinstellung auf "de" setzen.
	                OKWLanguage.getInstance().setLanguage("en");
	                
	                CO = OKW_CurrentObject_Sngltn.getInstance();
	            }
	            catch (Exception e)
	            {
	                // TODO: Prüfen ob Exception hier so OK Ist...
	            	myLogger.LogPrint("SystemException e");
	            }
	        }

	       @After
	        public void MyTearDown()
	        {
	    	   myLogger.LogFunctionEnd();
	        }







	/*
	        /// \brief
	        /// Testziel ist ob erlaubte Zeichen erkannt werden. Liefert ein true Zurück und es wir kein OKW_GUI_Exception ausgelöst.
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_CheckCharacter()
	        {
	            assertEquals(true, CO.CheckCharacter("abcdefghijklmnopqrstuvwxyz")); // > Alle kleinbuchstaben prüfen
	            assertEquals(true, CO.CheckCharacter("a1234567890")); // > Alle kleinbuchstaben prüfen
	            assertEquals(true, CO.CheckCharacter("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); // > Alle GROßBUCHSTABEN prüfen
	        }

	        /// \brief
	        /// Testziel: Wird ein OKWFrameObjectIllegalNameCharacterException ausgalöst, wenn ein unerlaubtes Zeichen übergeben wird?
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_CheckCharacter_Exception()
	        {
	            try
	            {
	                // Sonderzeichen? - Sollte ein Exception auslösen
	                CO.CheckCharacter("&&");
	                fail();
	            }
	            catch (OKWFrameObjectIllegalNameCharacterException e)
	            {
	                System.out.println("Print: >>" + e.getMessage() + "<<");
	            }
	        }

	        @Test
	        public void TC_LogObjectData_WindowAndChild()
	        {
	            ArrayList<String> SollWert = new ArrayList<String>();
	            SollWert.add(" Object Data:");
	            SollWert.add("      Name des Fensters: 'Rechner'");
	            SollWert.add("  Name des Kindobjektes: 'Taste_3'");
	            SollWert.add("        Name der Klasse: '__Taste_3'");
	            SollWert.add("  Vollständiger Name des Objektes: 'Rechner.Taste_3'");
	            SollWert.add("");

	            // Fesnter setzen:
	            CO.SetWindowName("Rechner");
	            CO.SetChildName("Taste_3");

	            Boolean DebugMode_Merker = myLogger.getDebugMode(); // Merken wir uns den Debug-Mode
	            myLogger.setDebugMode(false); // Debug-Modus des Logger -s abschalten.
	            //Log2NUnit_Console.GetInstance.Init();

	            CO.LogObjectData();
	            myLogger.setDebugMode(DebugMode_Merker); // Debug-Modus auf den Altenwert Zurücksetzten

	            assertEquals(SollWert.Count, Log2NUnit_Console.GetInstance.LogValue.Count);
	            assertEquals(SollWert, Log2NUnit_Console.GetInstance.LogValue);
	        }

	    	@Test
	        public void TC_LogObjectData_Window_Only()
	        {
	            ArrayList<String> SollWert = new ArrayList<String>();

	            SollWert.add(" Object Data:");
	            SollWert.add("      Name des Fensters: 'Rechner'");
	            SollWert.add("  Name des Kindobjektes: ''");
	            SollWert.add("        Name der Klasse: 'Rechner'");
	            SollWert.add("  Vollständiger Name des Objektes: 'Rechner'");
	            SollWert.add("");

	            // Fesnter setzen:
	            CO.SetWindowName("Rechner");

	            Boolean DebugMode_Merker = myLogger.getDebugMode(); // Merken wir uns den Debug-Mode
	            myLogger.setDebugMode(false); // Debug-Modus des Logger -s abschalten.

	            //Log2NUnit_Console.GetInstance.Init();
	            CO.LogObjectData();
	            myLogger.DebugMode = DebugMode_Merker; // Debug-Modus auf den Altenwert Zurücksetzten

	            assertEquals(SollWert.Count, Log2NUnit_Console.GetInstance.LogValue.Count);
	            assertEquals(SollWert, Log2NUnit_Console.GetInstance.LogValue);
	        }

	    	*/
	    	
	    	
	    	
	        /// \brief
	        /// OKW.Select unit-test for the Keyword >>Select: "WindowName#WINDOW"<<
	        /// 
	    	@Test
	        public void TC_SelectWindowName_WINDOW() throws Exception
	        {
	            // Testscript in Schlüsselwort notation
	            this.myKernel.SelectWindow("Rechner");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            //assertEquals("Rechner", myClipBoard.getObjectName());
	            assertEquals("SelectWindow()", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Ts the c_ select_ child object_ with out_ value.
	        /// 
	    	@Test
	        public void TC_Select_ChildObject_WithOut_Value() throws Exception
	        {
	            // Testscript in Schlüsselwort-Notation
	            this.myKernel.SelectWindow("Rechner");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            assertEquals("Rechner", myClipBoard.getObjectName());
	            assertEquals("SelectWindow()", myClipBoard.getMethod());

	            this.myKernel.ClickOn("Taste_3");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            //assertEquals("Rechner.Taste_3", myClipBoard.getObjectName());
	            assertEquals("ClickOn()", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetChildName(*).
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_ChildName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetChildName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.SetWindowName("Rechner");
	            
	            // Setzen wir den Namen des Kindobjektes
	            CO.SetChildName("Taste_3");
	            
	            // Nun müssen "Rechner" In Windowname finden.
	            //assertEquals("Rechner.Taste_3", CO.GetObjectName());
	        }

	        /// \brief
	        /// Testziel: Prüfen, ob OKW_Kernel_Exception in der Methode CurrentObject.SetChildName() ausglöst wird.<br/>
	        /// Auslöse Grund ist, wenn ein Kindobjekt angesprochen wird, ohne das voher ein Fenster-Objekt ausgewählt worden ist.<br/>
	        /// 
	        /// \remark Folgende Reaktionen sind denkbar:
	        /// 1. OKW_Kernel_Exception wird ausgelöst: KernelException wird true gesetzt.
	        /// 2. Es wird eine anderere beliebige Ausnahme(Exception) ausgelöst: KernelException wird false gesetzt.
	        /// 3. Es wird keine  Ausnahme ausgelöst: KernelException bleibt false gesetzt.
	        /// \author Zoltan Hrabovszki
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetChildName_OKWFrameObjectWindowNotSetException()
	        {
	            try
	            {
	                OKW_CurrentObject_Sngltn.Init();
	                // Exception wird ausgelöst wenn ein Fenster Objekt nicht gesetzt ist.
	                // Der Namen des Fensters wurde hier daher bewusst weggelasssen:
	                CO.SetChildName("Taste_3");

	                // Folgende Zeile darf nicht ausgeführt werden. ... Hier wir auf exception geprüft
	                fail();
	            }
	            catch (OKWFrameObjectWindowNotSetException e)
	            {
	                System.out.println(e.getMessage());
	                assertEquals("No Window is defined! Please select a Window first!", e.getMessage());
	            }
	            catch (Exception e)
	            {
	                fail("Es wurde ein nicht erwarteter Exception ausgelöst: " + e.getMessage());
	            }
	        }

	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetWindowName(*).
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_WindowName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetWindowName() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.SetWindowName("Rechner");

	            // Nun müssen "frm_Rechner" In Windowname finden.
	            assertEquals("Rechner", CO.GetObjectFN());
	        }

	        /// \brief
	        /// Testziel: Prüfen der Methode CurrentObject.SetWindowName(*).
	        /// Speziel wird hier geprüft, ob das Kindpbjekt name gelöscht wird, wenn erneut ein Fenstername gesetzt wird.
	        /// 
	        /// 
	        /// \remark Prüfung erfolgt indirekt, da CurrentObject.cvs_WindowName von privater Natur ist.
	        /// Es wird geprüft ob CurrentObject.cvs_ObjectName richtig gesetz ist.
	        /// \date 2012.12.16
	    	@Test
	        public void TC_SetWindowName_AfterChildWasSetted() throws XPathExpressionException, IllegalArgumentException, IllegalAccessException
	        {
	            // Setzen wir den Namen des Fensters
	            CO.SetWindowName("Rechner");

	            // Setzen wir den Namen des Kindobjektes
	            CO.SetChildName("Taste_3");

	            // Nun müssen "Rechner" In Windowname finden.
	            // assertEquals("Rechner.Taste_3", CO.GetObjectName());

	            // Nun müssen "frm_Rechner" In Windowname finden.
	            CO.SetWindowName("Rechner");
	            // assertEquals("Rechner", CO.GetObjectName());
	        }
	}


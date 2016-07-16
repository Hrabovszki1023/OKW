package okw.core;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.*;
import org.xml.sax.SAXException;

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

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _int CallMethodReturn_Boolean(String MethodName)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rB_pMN() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JAXBException, ParserConfigurationException, SAXException, IOException
	        {
	            Boolean bExpected = true;
	            
	            Logger_Sngltn.getInstance().LogFunctionStart("TC_CallMethodReturn_rB_pMN");
	            CO.Init();
	            
	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            Boolean bActuel = CO.CallMethodReturn_Boolean("CallMethodReturn_rB_pMN");

	            // Check Return
	            assertEquals(bExpected, bActuel);

	            // Den Namen des der aufgerufenen Methode prüfen.
	            assertEquals(1, myClipBoard.getValue().size());

	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rB_pMN", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _int CallMethodReturn_Boolean(String MethodName, Boolean Parameter)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rB_pMN_pB() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            Boolean bExpected = true;

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            Boolean bActuel = CO.CallMethodReturn_BooleanPb("CallMethodReturn_rB_pMN_pB", bExpected);

	            // Check Return
	            assertEquals(bExpected, bActuel);
	            
	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals(1, myClipBoard.getValue().size());

	            assertEquals("true", myClipBoard.getValue().get(0));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rB_pMN_pB", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _int CallMethodReturn_Int(String MethodName)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rI_pMN() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            int iExpected = 23101963;

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            int iActuel = CO.CallMethodReturn_Int("CallMethodReturn_rI_pMN");

	            // Check Return
	            assertEquals(iExpected, iActuel);
	            
	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals(1, myClipBoard.getValue().size());

	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rI_pMN", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void LogFunctionStart(String MethodName)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rLS_pMN() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Wert 1");
	            LsExpected.add("Wert 2");
	            LsExpected.add("Wert 3");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            ArrayList<String> LsActuel = CO.CallMethodReturn_ListString("CallMethodReturn_rLS_pMN");

	            // Check Return
	            assertEquals(LsExpected, LsActuel);

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rLS_pMN", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _List String CallMethodReturn_ListString(String MethodName, List String)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	        @Test
	        public void TC_CallMethodReturn_rLS_pMN_pLS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Wert 1");
	            LsExpected.add("Wert 2");
	            LsExpected.add("Wert 3");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            ArrayList<String> LsActuel = CO.CallMethodReturn_ListString("CallMethodReturn_rLS_pMN_pLS", LsExpected);

	            // Check Return
	            assertEquals(LsExpected, LsActuel);

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals(3, myClipBoard.getValue().size());
	            assertEquals("Wert 1", myClipBoard.getValue().get(0));
	            assertEquals("Wert 2", myClipBoard.getValue().get(1));
	            assertEquals("Wert 3", myClipBoard.getValue().get(2));
	            assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rLS_pMN_pLS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode List_String CallMethodReturn_ListString(String MethodenName, String Parameter1, String Parameter2)
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.03.01
	    	@Test
	        public void TC_CallMethodReturn_rLS_pMN_pS_pS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Col");
	            LsExpected.add("Row");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            ArrayList<String> LsActuel = CO.CallMethodReturn_ListString("CallMethodReturn_rLS_pMN_pS_pS", "Col", "Row");

	            // Check Return
	            assertEquals(LsExpected, LsActuel);

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("Col", myClipBoard.getValue().get(0));
	            assertEquals("Row", myClipBoard.getValue().get(1));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rLS_pMN_pS_pS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _List String CallMethodReturn_ListString(String MethodName, List String)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rLS_pMN_pS_pS_pLS() throws SecurityException, Exception
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Wert 1");
	            LsExpected.add("Wert 2");
	            LsExpected.add("Wert 3");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            ArrayList<String> LsActuel = CO.CallMethodReturn_ListString("CallMethodReturn_rLS_pMN_pS_pS_pLS", "Parameter1", "Parameter2", LsExpected);

	            // Check Return
	            assertEquals("Parameter1", LsActuel.get(0));
	            assertEquals("Parameter2", LsActuel.get(1));
	            assertEquals("Wert 1", LsActuel.get(2));
	            assertEquals("Wert 2", LsActuel.get(3));
	            assertEquals("Wert 3", LsActuel.get(4));

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals(5, myClipBoard.getValue().size());

	            assertEquals("Parameter1", myClipBoard.getValue().get(0));
	            assertEquals("Parameter2", myClipBoard.getValue().get(1));
	            assertEquals("Wert 1", myClipBoard.getValue().get(2));
	            assertEquals("Wert 2", myClipBoard.getValue().get(3));
	            assertEquals("Wert 3", myClipBoard.getValue().get(4));
	            assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rLS_pMN_pS_pS_pLS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _List String CallMethodReturn_ListString(String MethodName, List String)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rS_pMN() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            String sExpected = "Wert 1";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            String sActuel = CO.CallMethodReturn_String("CallMethodReturn_rS_pMN");

	            // Check Return
	            assertEquals(sExpected, sActuel);

	            // Den Namen des der aufgerufenen Methode prüfen.
	            assertEquals(1, myClipBoard.getValue().size());

	            assertEquals("Wert 1", myClipBoard.getValue().get(0));
	            //assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rS_pMN", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _List String CallMethodReturn_ListString(String MethodName, List String)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethodReturn_rS_pMN_pS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            String sExpected = "Ein Wert";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            String sActuel = CO.CallMethodReturn_String("CallMethodReturn_rS_pMN_pS", sExpected);

	            // Check Return
	            assertEquals(sExpected, sActuel);

	            // Den Namen des der aufgerufenen Methode prüfen.
	            assertEquals(1, myClipBoard.getValue().size());

	            assertEquals(sExpected, myClipBoard.getValue().get(0));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethodReturn_rS_pMN_pS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void LogFunctionStart(String MethodName)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN");

	            // Check the Name, Called Method and Value of Actuel object
	            assertEquals("NO VALUE", myClipBoard.getValue().get(0));
	            //assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_MN", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, String Parameter_1)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN_pS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {

	            String sParameter_1 = "Parameter_1";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pS", sParameter_1);

	            // Kein Return

	            // Name, Called Method und Wet of Actuel object
	            assertEquals(1, myClipBoard.getValue().size());
	            assertEquals(sParameter_1, myClipBoard.getValue().get(0));

	            //assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pS", myClipBoard.getMethod());
	        }

	        
	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, List String)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	        @Test
	        public void TC_CallMethod_pMN_pLS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Wert 1");
	            LsExpected.add("Wert 2");
	            LsExpected.add("Wert 3");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pLS", LsExpected);

	            // Den Namen des der aufgerufenen Methode prüfen.
	            assertEquals(3, myClipBoard.getValue().size());

	            assertEquals("Wert 1", myClipBoard.getValue().get(0));
	            assertEquals("Wert 2", myClipBoard.getValue().get(1));
	            assertEquals("Wert 3", myClipBoard.getValue().get(2));
	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pLS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, List String, String Option)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN_pLS_pS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            ArrayList<String> LsExpected = new ArrayList<String>();
	            LsExpected.add("Wert 1");
	            LsExpected.add("Wert 2");
	            LsExpected.add("Wert 3");

	            String sOption = "MeineOption";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pLS_pS", LsExpected, sOption);

	            // Kein Return

	            // Name, Called Method und Wet of Actuel object
	            assertEquals(4, myClipBoard.getValue().size() );

	            assertEquals("Wert 1", myClipBoard.getValue().get(0));
	            assertEquals("Wert 2", myClipBoard.getValue().get(1));
	            assertEquals("Wert 3", myClipBoard.getValue().get(2));

	            assertEquals(sOption, myClipBoard.getValue().get(3));

	            //assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pLS_pS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, List String, String Option)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN_pS_PS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            String sParameter_1 = "Parameter 1";
	            String sParameter_2 = "Parameter 2";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pS_pS", sParameter_1, sParameter_2);

	            // Kein Return

	            // Name, Called Method und Wet of Actuel object
	            assertEquals(2, myClipBoard.getValue().size());

	            assertEquals(sParameter_1, myClipBoard.getValue().get(0));
	            assertEquals(sParameter_2, myClipBoard.getValue().get(1));

	            //assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pS_pS", myClipBoard.getMethod());
	        }
	        
	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, List String, String Option)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN_pS_pS_pS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            String sParameter_1 = "Parameter 1";
	            String sParameter_2 = "Parameter 2";
	            String sParameter_3 = "Parameter 3";

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pS_pS_pS", sParameter_1, sParameter_2, sParameter_3);

	            // Kein Return

	            // Name, Called Method und Wet of Actuel object
	            assertEquals(3, myClipBoard.getValue().size());

	            assertEquals(sParameter_1, myClipBoard.getValue().get(0));
	            assertEquals(sParameter_2, myClipBoard.getValue().get(1));
	            assertEquals(sParameter_3, myClipBoard.getValue().get(2));

	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pS_pS_pS", myClipBoard.getMethod());
	        }

	        /// \brief
	        /// Prüft die Aufrufbarkeit der Methode _void CallMethod(String MethodName, List String, String Option, ArrayList<String> fpLSValues)_
	        /// 
	        /// \author Zoltan Hrabovszki
	        /// \date 2014.01.14
	    	@Test
	        public void TC_CallMethod_pMN_pS_pS_pLS() throws XPathExpressionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	        {
	            String sParameter_1 = "Parameter 1";
	            String sParameter_2 = "Parameter 2";

	            ArrayList<String> lvLsWerte = new ArrayList<String>();
	            lvLsWerte.add("Wert 1");
	            lvLsWerte.add("Wert 2");
	            lvLsWerte.add("Wert 3");

	            // GUI-Object definieren: Fenster und Kindobjekt setzten
	            CO.SetWindowName("CurrentObjectWindow");
	            CO.SetChildName("CurrentObjectAllMethodCallTypes");

	            // Objekt existiert...
	            CO.CallMethod("CallMethod_pMN_pS_pS_pLS", sParameter_1, sParameter_2, lvLsWerte);

	            // Kein Return

	            // Name, Called Method und Wet of Actuel object
	            assertEquals(5, myClipBoard.getValue().size());

	            assertEquals(sParameter_1, myClipBoard.getValue().get(0));
	            assertEquals(sParameter_2, myClipBoard.getValue().get(1));

	            assertEquals("Wert 1", myClipBoard.getValue().get(2));
	            assertEquals("Wert 2", myClipBoard.getValue().get(3));
	            assertEquals("Wert 3", myClipBoard.getValue().get(4));

	            // assertEquals("CurrentObjectWindow.CurrentObjectAllMethodCallTypes", myClipBoard.getObjectName());
	            assertEquals("CallMethod_pMN_pS_pS_pLS", myClipBoard.getMethod());
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
	                CO.Init();
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


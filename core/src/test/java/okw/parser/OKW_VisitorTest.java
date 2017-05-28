package okw.parser;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import okw.*;
// import okw.parser.*;
import okw.log.*;

import org.junit.*;

import static org.junit.Assert.*;

    //[TestFixture]
	public class OKW_VisitorTest
    {
        String myOKW_Xml = "";
        
        OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
        
        Logger_Sngltn Log = Logger_Sngltn.getInstance();
        
        //@Rule public TestName name = new TestName();
                
        /// \brief
        /// Initialisierung vor jedem Test:
        ///  * CurrentObject initialisieren.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.16
        @Before
        public void MySetUp( )
        {

        }

        @After
        public void MyTearDown()
        {
            /* Environment.SetEnvironmentVariable("OKW_Xml", this.myOKW_Xml);
        	 Log.LogFunctionEnd(TestContext.CurrentContext.Test.Name);
        	 */
        }

        /// \brief
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.01.14
        @Ignore
        @Test
        public void TC_ParseMe_EnvVar()
        {
            // Environment.SetEnvironmentVariable("TestEnvVar", "TestWert");

            String sActual = Parser.ParseMe("${TestEnvVar}");            
            String sExpected = "TestWert";

            assertEquals(sExpected, sActual);
            
            // Environment.SetEnvironmentVariable("TestEnvVar", "");
        }

        /// \brief
        /// Prüft das lesen eines gemerkten Wertes.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.01.14
        @Test
        public void TC_ParseMe_MemorizedValue()
        {
        	
        	OKW_Memorize_Sngltn.reset();
        	
            try
            {
            	OKW_Memorize_Sngltn.getInstance().set("Schluessel", "Wert des Schlüssels.");
			}
            catch (XPathExpressionException e)
            {
				fail(e.getMessage());
			}
            String sActual = Parser.ParseMe("${Schluessel}");
            String sExpected = "Wert des Schlüssels.";

            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);            
            
            // Check Return
            assertEquals(sExpected, sActual);
        }

  // \brief String ohne Ersätzung, Länge Größer "0"
  //
  // \author Zoltan Hrabovszki
  // \date 2014.10.14
  @Test
  public void TC_ParseMe_Without_Substitution()
  {
    String sActual = Parser.ParseMe( "Einfach nur Text." );
    String sExpected = "Einfach nur Text.";

    Log.LogPrint( "  Aktual Value: " + sActual );
    Log.LogPrint( "Expected Value: " + sExpected );

    // Check Return
    assertEquals( sExpected, sActual );
  }

  // \brief Prüft ob die OKW-Constanten nicht verändert werden.
  // Die OKW 
  //
  // \author Zoltan Hrabovszki
  // \date 2014.10.14
  @Test
  public void TC_ParseMe_OKW_Consts()
  {
    String sActual = Parser.ParseMe( "${IGNORE}${DELETE}${EMPTY}${SEP}${VSEP}${HSEP}" );
    String sExpected = "${IGNORE}${DELETE}${EMPTY}${SEP}${VSEP}${HSEP}";

    Log.LogPrint( "  Aktual Value: " + sActual );
    Log.LogPrint( "Expected Value: " + sExpected );

    // Check Return
    assertEquals( sExpected, sActual );
  }
  
        /// \brief Prüft, ob ein leerer String verarbeitet wird.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_StringWithBlank()
        {

        	String sActual = Parser.ParseMe(" ");
            
            String sExpected = " ";
 
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
        }
        
        
        /// \brief
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Ignore
        @Test
        public void TC_ParseMe_TextPlusEnvVar()
        {
            //Environment.SetEnvironmentVariable("TestEnvVar", "TestWert");

            String sActual = Parser.ParseMe("Text vorher ${TestEnvVar} Text danach.");
            
            String sExpected = "Text vorher TestWert Text danach.";
            
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
            
            //Environment.SetEnvironmentVariable("TestEnvVar", "");

        }

        /// \brief
        /// Testziel: OKW-Variable _PathXML_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_TextPlusFolder_XML()
        {
    		OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
        	
        	String sActual = Parser.ParseMe("PATHXML: >>${Folder_XML}<<");
 
        	String sExpected = "PATHXML: >>" + myOKW_Ini.OKW_Enviroment.getFolder_XML() + "<<";
            
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
 
        }

        /// \brief
        /// Testziel: OKW-Variable _PathRoot_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_TextPlusLogMessages()
        {
        	String sActual = Parser.ParseMe("Folder LogMessages: >>${Folder_LogMessages}<<");
            //System.Console.WriteLine(sActual);

        	String sExpected = "Folder LogMessages: >>" + myOKW_Ini.OKW_Enviroment.getFolder_LogMessages() + "<<";
            
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
        }
        

        /// \brief
        /// Testziel: OKW-Variable _File_OKWMemorize_xml_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_TextPlusFile_OKW_Memorize_xml()
        {
        	String sActual = Parser.ParseMe("File_OKWMemorize_xml: >>${File_OKW_Memorize_xml}<<");
            //System.Console.WriteLine(sActual);

        	String sExpected = "File_OKWMemorize_xml: >>" + myOKW_Ini.OKW_Enviroment.getFile_OKW_Memorize_xml() + "<<";
            
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
       }

        /// \brief
        /// Testziel: OKW-Variable _File_okwkeymaps_xml_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_FILE_OKWKEYMAPS_XML()
        {
        	String sActual = Parser.ParseMe("File_okwkeymaps_xml: >>${File_OKW_Keymaps_xml}<<");
            //System.Console.WriteLine(sActual);

        	String sExpected = "File_okwkeymaps_xml: >>" + myOKW_Ini.OKW_Enviroment.getFile_OKW_Keymaps_xml() + "<<";
            
            Log.LogPrint( "  Aktual Value: " + sActual);
            Log.LogPrint( "Expected Value: " + sExpected);
 
            // Check Return
            assertEquals(sExpected, sActual);
       }

        /// \brief
        /// Testziel: OKW-Variable _File_OKWConst_xml_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_ArrayListString()
        {
            ArrayList<String> LsInput = new ArrayList<String>();

            LsInput.add("PATHXML: >>${Folder_XML}<<");
            LsInput.add("${Schluessel}");
            
            OKW_Memorize_Sngltn.reset();
            OKW_Memorize_Sngltn myOKW_Memorize= OKW_Memorize_Sngltn.getInstance();

            try
            {
            	myOKW_Memorize.set("Schluessel", "Wert des Schlüssels.");
			}
            catch (XPathExpressionException e)
            {
				fail(e.getMessage());
			}
            
            ArrayList<String> LsActual = Parser.ParseMe(LsInput);

            String sExpected_1 = "PATHXML: >>" + myOKW_Ini.OKW_Enviroment.getFolder_XML() + "<<";
            String sExpected_2 = "Wert des Schlüssels.";
 
            Log.LogPrint( "  Aktual Value 1: " + LsActual.get(0));
            Log.LogPrint( "Expected Value 1: " + sExpected_1);

            Log.LogPrint( "  Aktual Value 2: " + LsActual.get(1));
            Log.LogPrint( "Expected Value 2: " + sExpected_2);

            
            // Check Return
            assertEquals(2, LsActual.size());
            assertEquals(sExpected_1, LsActual.get(0));
            assertEquals(sExpected_2, LsActual.get(1));
        }

        /// \brief
        /// Testziel: OKW-Variable _File_OKWConst_xml_ auslesen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2014.10.14
        @Test
        public void TC_ParseMe_ArrayListString_OneValue()
        {
            ArrayList<String> LsInput = new ArrayList<String>();

            LsInput.add("PATHXML: >>${Folder_XML}<<");
                        
            ArrayList<String> LsActual = Parser.ParseMe(LsInput);

            String sExpected_1 = "PATHXML: >>" + myOKW_Ini.OKW_Enviroment.getFolder_XML() + "<<";
 
            Log.LogPrint( "  Aktual Value 1: " + LsActual.get(0));
            Log.LogPrint( "Expected Value 1: " + sExpected_1);
            
            // Check Return
            assertEquals(1, LsActual.size());
            assertEquals(sExpected_1, LsActual.get(0));
        }

  /// \brief
  /// Testziel: OKW-Variable _File_OKWConst_xml_ auslesen.
  /// 
  /// \author Zoltan Hrabovszki
  /// \date 2014.10.14
  @Test
  public void TC_ParseMe_ArrayListString_Empty()
  {
      ArrayList<String> LsInput = new ArrayList<String>();

      LsInput.add("");
                  
      ArrayList<String> LsActual = Parser.ParseMe(LsInput);

      String sExpected_1 = "";

      Log.LogPrint( "  Aktual Value 1: " + LsActual.get(0));
      Log.LogPrint( "Expected Value 1: " + sExpected_1);
      
      // Check Return
      assertEquals(1, LsActual.size());
      assertEquals(sExpected_1, LsActual.get(0));
  }
}
	
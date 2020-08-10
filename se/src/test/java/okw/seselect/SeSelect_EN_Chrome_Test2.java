package okw.seselect;

import okw.OKWTestBase;
import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Tag("SeSelect_EN_Chrome_Test")
public class SeSelect_EN_Chrome_Test2 extends OKWTestBase
{
	protected static Log2HTML myLog2HTML = null;
	
	static String ApplicationName = "Chrome";

    @BeforeAll
    public static void setUpBeforeClass() throws Exception
    {
        ApplicationName = "Chrome";
        
        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("SeSelect_EN_Chrome_Test2");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);

        Logger_Sngltn.getInstance().setDebugMode(false);
    }

    /*@After
    public void AfterAfter() throws Exception
    {
        Runtime rt = Runtime.getRuntime();
        
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
            rt.exec("taskkill Chrome");
        else
            rt.exec("pkill -f Chrome");
          
        Thread.sleep( 1000 );
    }
    */
    
    @AfterAll
    public static void tearDownAfterClass() throws Exception
    {
        myLog2HTML.Result2HTML("target/SeSelect_EN_Chrome_Test2.html");
    }
    /**
     * Testet ob die ProxyKlasse die GUI-Klasse "SeButton" nachlädt.
     * 
     * Testbedignung:
     * 
     * 1. Locator ist ein XPATH
     * 2. GUI-Objekt/Tag ist vom Type button (D.h. nicht vom  input type=button)
     * 
     */
     @Test
     public void tc_Select_VerySelected_Value() throws Exception
     {
         EN.BeginTest( TestName );
         EN.StartApp( "Chrome" );
         EN.TypeKey( "URL", "http://test.openkeyword.de/Select/Select.htm" );
         EN.SelectWindow( "SeListBox" );

         EN.Select( "Künstler", "Heino" );
         EN.VerifySelectedValue( "Künstler", "Heino" );
         
         
         EN.Select( "Künstler", "Heino<SEP>Marianne Rosenberg" );
         EN.VerifySelectedValue( "Künstler", "Heino" );
         
         EN.StopApp( ApplicationName );
         EN.EndTest();
     }
}

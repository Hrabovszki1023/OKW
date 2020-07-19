package okw.iframe;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class IFrame_EN_Chrome_Test extends IFrame_EN_Test
{

	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Chrome";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("target/IFrame_EN_Chrome_Test.html");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML( "IFrame_EN_Chrome_Test" );
	}
	
    @AfterEach
    public void AfterTest() throws Exception
    {
    	Runtime rt = Runtime.getRuntime();
    	
    	if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) rt.exec("taskkill Chrome");
    	else rt.exec("pkill -f Chrome");
    	  
    	Thread.sleep( 1000 );
    }
}

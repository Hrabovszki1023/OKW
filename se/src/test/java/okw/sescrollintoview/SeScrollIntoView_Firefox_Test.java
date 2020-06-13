package okw.sescrollintoview;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeScrollIntoView_Firefox_Test extends SeScrollIntoView_Test
{
	protected static Log2HTML myLog2HTML = null;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML( );
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

//  @After
//  public void FirefoxAfter() throws Exception
//  {
//    Runtime rt = Runtime.getRuntime();
//    
//    if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
//       rt.exec("taskkill Firefox");
//    else rt.exec("pkill -f Firefox");
//      
//    Thread.sleep( 1000 );
//   
//  }
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML("target/SeScrollIntoView_Firefox_Test.html");
	}
}

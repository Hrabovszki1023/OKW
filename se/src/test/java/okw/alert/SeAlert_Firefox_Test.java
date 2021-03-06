package okw.alert;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;
import org.junit.jupiter.api.*;


public class SeAlert_Firefox_Test extends SeAlert_Test
{

	protected static Log2HTML myLog2HTML = null;

	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("SeBrowserChild_Firefox_Test");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

	
  @AfterAll
  public static void tearDownAfterClass() throws Exception
  {
    myLog2HTML.Result2HTML( "target/SeBrowserChild_Firefox_Test.html" );
  }

  /*
  @After
  public void FirefoxAfter() throws Exception
  {
    Runtime rt = Runtime.getRuntime();
    
    if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
        rt.exec("taskkill firefox");
    else
        rt.exec("pkill -f firefox");
    Thread.sleep( 1000 );
  }
  */
}

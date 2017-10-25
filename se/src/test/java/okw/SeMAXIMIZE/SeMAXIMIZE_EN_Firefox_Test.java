package okw.SeMAXIMIZE;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.*;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeMAXIMIZE_EN_Firefox_Test extends SeMAXIMIZE_EN_Test
{
	static Log2HTML myLog2HTML = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("target/SeMAXIMIZE_Firefox_Test.html");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

  @After
  public void FirefoxAfter() throws Exception
  {
    Runtime rt = Runtime.getRuntime();
    
    if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
       rt.exec("taskkill Firefox");
    else rt.exec("pkill -f Firefox");
      
    Thread.sleep( 1000 );
   
  }
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML();
	}
}

package okw.SeInputField;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.*;

public class SeInputField_Firefox_Test extends SeInputField_Test
{
	static Log2HTML myLog2HTML = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        //myLog2HTML = new Log2HTML("SeTextField_EN_Firefox_Test.html");
        //Logger_Sngltn.getInstance().AddLogger(myLog2HTML);
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
	
/*	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML();
	}
	*/
}

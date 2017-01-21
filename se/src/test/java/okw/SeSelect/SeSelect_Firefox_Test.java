package okw.SeSelect;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class SeSelect_Firefox_Test extends SeSelect_Test
{

  static Log2HTML myLog2HTML = null;
  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		 // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        myLog2HTML = new Log2HTML("target/SeSelect_Firefox_Test.html");
        Logger_Sngltn.getInstance().AddLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
   }

	
	 @AfterClass
	  public static void tearDownAfterClass() throws Exception
	  {
	    myLog2HTML.Result2HTML();
	  }


    @After
    public void FirefoxAfter() throws Exception
    {
    	Runtime rt = Runtime.getRuntime();
    	  if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
    	     rt.exec("taskkill firefox");
    	   else
    	     rt.exec("pkill -f firefox");
    }
}

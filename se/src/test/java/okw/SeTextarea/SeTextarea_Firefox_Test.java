package okw.SeTextarea;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class SeTextarea_Firefox_Test extends SeTextarea_Test
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        Logger_Sngltn.getInstance().setDebugMode(false);
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

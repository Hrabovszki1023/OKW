package okw.SeInputCheckbox;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.*;

public class SeInputCheckbox_Firefox_Test extends SeInputCheckbox_Test
{

	static Log2HTML myLog2HTML = null;

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
    	     rt.exec("taskkill Firefox");
    	   else
    	     rt.exec("pkill -f Firefox");
    }
}

package okw.SeInputButton;

import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.BeforeClass;

public class SeInputButton_EN_Firefox_Test extends SeInputButton_EN_Test
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

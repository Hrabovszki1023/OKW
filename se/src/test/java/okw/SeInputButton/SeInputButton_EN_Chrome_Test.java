package okw.SeInputButton;

import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeInputButton_EN_Chrome_Test extends SeInputButton_EN_Test
{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Chrome";
		
        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        Logger_Sngltn.getInstance().setDebugMode(true);
	}

    @After
    public void FirefoxAfter() throws Exception
    {
    	Runtime rt = Runtime.getRuntime();
    	  if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
    	     rt.exec("taskkill Chrome");
    	   else
    	     rt.exec("pkill -f Chrome");
    }
}

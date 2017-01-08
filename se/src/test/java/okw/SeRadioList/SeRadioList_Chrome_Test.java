package okw.SeRadioList;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class SeRadioList_Chrome_Test extends SeRadioList_Test
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	ApplicationName = "Chrome";

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
    	     rt.exec("taskkill Chrome");
    	   else
    	     rt.exec("pkill -f Chrome");
    }
}

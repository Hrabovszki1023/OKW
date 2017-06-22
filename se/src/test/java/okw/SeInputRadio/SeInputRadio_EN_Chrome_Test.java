package okw.SeInputRadio;

import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.BeforeClass;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeInputRadio_EN_Chrome_Test extends SeInputRadio_EN_Test
{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Chrome";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        Logger_Sngltn.getInstance().setDebugMode(false);
	}


    @After
    public void FirefoxAfter() throws Exception
    {
    	Runtime rt = Runtime.getRuntime();
    	
    	if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) rt.exec("taskkill Chrome");
    	else rt.exec("pkill -f Chrome");
    	  
    	Thread.sleep( 1000 );
    }  
}

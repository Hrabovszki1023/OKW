package okw.seinputradio;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeInputRadio_EN_HTMLUnitDriver_Test extends SeInputRadio_EN_Test
{
	protected static Log2HTML myLog2HTML = null;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "HTMLUnit";
		
       Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
       Logger_Sngltn.init();

       myLog2HTML = new Log2HTML("target/OKWResult_SeInputRadio_HTMLUnitDriver_Test.html");
       Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        
       Logger_Sngltn.getInstance().setDebugMode(false);
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception
	{
		//myLog2HTML.Result2HTML();
	}
}

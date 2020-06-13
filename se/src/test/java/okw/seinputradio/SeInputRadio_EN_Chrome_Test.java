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
@Tag("SeInputRadio_EN_Chrome_Test")
public class SeInputRadio_EN_Chrome_Test extends SeInputRadio_EN_Test
{
	protected static Log2HTML myLog2HTML = null;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception
    {
        ApplicationName = "Chrome";
        
        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML( "SeInputRadio_Chrome_Test" );
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);

        Logger_Sngltn.getInstance().setDebugMode(false);
    }

    /* @After
    public void AfterAfter() throws Exception
    {
        Runtime rt = Runtime.getRuntime();
        
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
            rt.exec("taskkill Chrome");
        else
            rt.exec("pkill -f Chrome");
          
        Thread.sleep( 1000 );
    }
    */
    
    @AfterAll
    public static void tearDownAfterClass() throws Exception
    {
        myLog2HTML.Result2HTML("target/SeInputRadio_Chrome_Test.html");
    }
}

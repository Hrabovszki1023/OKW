package okw.selink;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeLink_EN_Firefox_Test extends SeLink_EN_Test
{

	protected static Log2HTML myLog2HTML = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    ApplicationName = "Firefox";

        Logger_Sngltn.getInstance();
     // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("SeLink_Firefox_Test");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
   }

  
   @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
      myLog2HTML.Result2HTML("target/SeLink_Firefox_Test.html");
    }

/*
    @After
    public void FirefoxAfter() throws Exception
    {
      Runtime rt = Runtime.getRuntime();
        if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) 
           rt.exec("taskkill firefox");
         else
           rt.exec("pkill -f firefox");
        Thread.sleep( 1000 );  
    }
    */
}

package okw.SeLink;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
public class SeLink_EN_Chrome_Test extends SeLink_EN_Test
{

	protected static Log2HTML myLog2HTML = null;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    ApplicationName = "Chrome";

        Logger_Sngltn.getInstance();
     // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("target/SeLink_Chrome_Test.html");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
   }

  
   @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
      myLog2HTML.Result2HTML();
    }

/*
   @After
   public void ChromeAfter() throws Exception
   {
       Runtime rt = Runtime.getRuntime();
       
       if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) rt.exec("taskkill Chrome");
       else rt.exec("pkill -f Chrome");
         
       Thread.sleep( 1000 );
   }  
   */
}

package okw.sebrowserchild;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class SeBrowserChild_EN_Chrome_Test extends SeBrowserChild_EN_Test
{

	protected static Log2HTML myLog2HTML = null;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Chrome";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML("SeBrowserChild_EN_Chrome_Test");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

	
  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
    myLog2HTML.Result2HTML("target/SeBrowserChild_EN_Chrome_Test.html");
  }

  
/*
  // @After
  public void afterChrome() throws Exception
  {
      Runtime rt = Runtime.getRuntime();
      
      if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1) rt.exec("taskkill Chrome");
      else
      {
          rt.exec("pkill -f Chrome");
          rt.exec("killall chromedriver");
      } 
      Thread.sleep( 1000 );
  }
  */
}

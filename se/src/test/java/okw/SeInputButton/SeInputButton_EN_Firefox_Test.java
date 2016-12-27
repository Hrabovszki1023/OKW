package okw.SeInputButton;

import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeInputButton_EN_Firefox_Test extends SeInputButton_EN_Test
{
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";
		
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
    	     rt.exec("taskkill firefox");
    	   else
    	     rt.exec("pkill -f firefox");
    }
	
  @Test
  public void AA_Taschenrechner_DE() throws Exception
  {
    EN.BeginTest( name.getMethodName() );
    EN.StartApp( ApplicationName );

    EN.TypeKey( "URL", "http://www.schulferien.org/taschenrechner/taschenrechner.html");
      EN.SelectWindow("Taschenrechner");
      EN.ClickOn("1");
      EN.ClickOn("+");
      EN.ClickOn("1");
      EN.ClickOn("=");

      EN.VerifyValue("Anzeige", "2");
  }
	
}

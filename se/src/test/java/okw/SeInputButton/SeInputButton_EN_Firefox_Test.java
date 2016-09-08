package okw.SeInputButton;

import okw.core.EN;
import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SeInputButton_EN_Firefox_Test extends SeInputButton_EN_Test
{
	static Log2HTML myLog2HTML = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Firefox";
		
        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        myLog2HTML = new Log2HTML("SePushButton_EN_Firefox_Test.html");
        Logger_Sngltn.getInstance().AddLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML();
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

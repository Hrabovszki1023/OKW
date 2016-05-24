package okw.calculator;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Calculator_EN_Safari_Test extends Calculator_EN_Test
{
	static Log2HTML myLog2HTML = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Safari";
		
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.getInstance().Init();

        myLog2HTML = new Log2HTML("Calculator_EN_Safari_Test.html");
        Logger_Sngltn.getInstance().AddLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML();
	}
}

package okw.calculator;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.jupiter.api.*;


public class Calculator_EN_Safari_Test extends Calculator_EN_Test
{
	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
		ApplicationName = "Safari";
		
        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        myLog2HTML = new Log2HTML( "Calculator_EN_Safari_Test" );
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(true);
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception
	{
		myLog2HTML.Result2HTML( "target/Calculator_EN_Safari_Test.html" );
	}
}

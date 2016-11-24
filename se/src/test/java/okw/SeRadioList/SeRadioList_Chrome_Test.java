package okw.SeRadioList;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class SeRadioList_Chrome_Test extends SeRadioList_Test
{
	static Log2HTML myLog2HTML = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	ApplicationName = "Chrome";

        Logger_Sngltn.getInstance();
		// Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.Init();

        myLog2HTML = new Log2HTML();
        myLog2HTML.setHTML_File( "target/SeRadioList_EN_Chrome_Test.html" );

        Logger_Sngltn.getInstance().AddLogger(myLog2HTML);
        Logger_Sngltn.getInstance().setDebugMode(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	    myLog2HTML.Result2HTML();
	}
}

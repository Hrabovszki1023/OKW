package okw.alert;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;


import org.junit.jupiter.api.*;

public class SeAlert_Test extends OKWTestBase {

	// String cvOKWObject = "SeBrowserChild" + "";

	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();

	protected static String ApplicationName;

	/**
	 * 
	 */
	@Test
	public void tc_Alert_CANCEL() throws Exception {
		EN.BeginTest(TestName);

		EN.StartApp(ApplicationName);
		EN.TypeKey("URL", "http://test.openkeyword.de/alert/alert.htm");

		EN.SelectWindow("Alert");
		EN.ClickOn("Try it");
		
		EN.ClickOn("ALERT CANCEL");
		
		EN.VerifyValue( "Anzeige", "User cancelled the prompt.");

		EN.StopApp(ApplicationName);
		EN.EndTest();
	}

	/**
	 * 
	 */
	@Test
	public void tc_Alert_OK() throws Exception {
		EN.BeginTest(TestName);

		EN.StartApp(ApplicationName);
		EN.TypeKey("URL", "http://test.openkeyword.de/alert/alert.htm");

		EN.SelectWindow("Alert");
		EN.ClickOn("Try it");
		
		EN.ClickOn("ALERT OK");
		
		EN.VerifyValue( "Anzeige", "Hello Harry Potter! How are you today?");

		EN.StopApp(ApplicationName);
		EN.EndTest();
	}
	
	/**
	 * 
	 */
	@Test
	public void tc_Alert_Message() throws Exception {
		EN.BeginTest(TestName);

		EN.StartApp(ApplicationName);
		EN.TypeKey("URL", "http://test.openkeyword.de/alert/alert.htm");

		EN.SelectWindow("Alert");
		EN.ClickOn("Try it");
		
		EN.VerifyValue( "ALERT MESSAGE", "Please enter your name:");
		
		EN.ClickOn("ALERT OK");
		
		EN.VerifyValue( "Anzeige", "Hello Harry Potter! How are you today?");

		EN.StopApp(ApplicationName);
		EN.EndTest();
	}

	/**
	 * 
	 */
	@Test
	public void tc_Alert_DATA() throws Exception {
		EN.BeginTest(TestName);

		EN.StartApp(ApplicationName);
		EN.TypeKey("URL", "http://test.openkeyword.de/alert/alert.htm");

		EN.SelectWindow("Alert");
		EN.ClickOn("Try it");
		
		EN.SetValue( "ALERT DATA", "Uschi" );
		
		EN.ClickOn("ALERT OK");
		
		EN.VerifyValue( "Anzeige", "Hello Uschi! How are you today?");

		EN.StopApp(ApplicationName);
		EN.EndTest();
	}
}
package okw.log.log2html;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import okw.log.log2html.Log2HTML;

public class Log2HTMLTest {


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TC_LogPrint_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogPrint_Test.html" );
				
		myLog.LogTestcaseStart( "TC_LogPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}

	@Test
	public void TC_LogPrintDebug_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogPrintDebug_Test.html" );
				
		myLog.LogTestcaseStart( "TC_LogPrintDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrintDebug( "Print im Schlüsselwort");
				myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}
	
	@Test
	public void TC_ResultList_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/ResultListPrint_Test.html" );
				
		myLog.LogTestcaseStart( "TC_ResultListPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenList( "ResultOpenList" );
					myLog.LogPrint( "Print im Schlüsselwort");
					myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.ResCloseList();
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}

	@Test
	public void TC_ResultListDebug_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/ResultListDebug_Test.html" );
				
		myLog.LogTestcaseStart( "TC_ResultListDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenListDebug( "ResultOpenListDebug" );
					myLog.LogPrintDebug( "Print im Schlüsselwort");
					myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.ResCloseListDebug();
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}
	
	@Test
	public void TC_LogException_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogException_Test.html" );
				
		myLog.LogTestcaseStart( "TC_LogException_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogException( "Exception");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}

	@Test
	public void TC_LogError_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogError_Test.html" );
				
		myLog.LogTestcaseStart( "TC_LogError_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogError("Error");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}
	
	@Test
	public void TC_LogWarning_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogWarning_Test.html" );
				
		myLog.LogTestcaseStart( "TC_LogWarning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogWarning( "Warnung");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}
	
	@Test
	public void TC_LogFunktion_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogFunktion_Test.html" );

		myLog.LogTestcaseStart( "TC_LogFunktion_Test" );
		
		myLog.LogFunctionStart("FunctionName", "String", "Parameter 1");
		
		myLog.LogPrint("Das ist ein LogPrint...");

		myLog.LogFunctionEnd();

		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
	}

	@Test
	public void TC_LogFunktion2_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogFunktion2_Test.html" );

		myLog.LogTestcaseStart( "TC_LogFunktion2_Test" );
		
		myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		
		myLog.LogPrint("Das ist ein LogPrint...");

		myLog.LogFunctionEnd();

		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
	}

	@Test
	public void TC_LogFunktion_ReturnBoolean_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogFunktion_ReturnBoolean_Test.html" );

		myLog.LogTestcaseStart( "TC_LogFunktion_ReturnBoolean_Test" );
		
		myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		
		myLog.LogPrint("Das ist ein LogPrint...");

		myLog.LogFunctionEnd(true);

		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
	}

	@Test
	public void TC_LogFunktionDebug_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogFunktionDebug_Test.html" );

		myLog.LogTestcaseStart( "TC_LogFunktionDebug_Test" );
		
		myLog.LogFunctionStartDebug("FunctionName", "String", "Parameter 1");
		
		myLog.LogPrintDebug("Das ist ein LogPrint...");
		
		myLog.ResOpenListDebug( "ResultOpenListDebug" );
		myLog.LogPrintDebug( "Print im Schlüsselwort");
		myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
		myLog.LogError( "Fehler" );
		myLog.ResCloseListDebug();

		myLog.LogFunctionEndDebug();

		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
	}

	@Test
	public void TC_LogSequence_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogSequence_Test.html" );

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogSequenceStart( "Sequence", "Facebook", "Login", "Zoltan", "!?GhoKklA");
			myLog.LogKeyWordStart( "Typekey", "Name", "Zoltan" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "Password", "!?GhoKklA" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Click", "OK" );
				myLog.LogKeyWordEnd();
			
			myLog.LogSequenceEnd();

		myLog.LogSequenceStart( "Sequence", "Facebook", "Update user properties", "Germany", "Hamburg", "male", "brown");
			myLog.LogKeyWordStart( "Typekey", "Country", "Germany" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "city", "Hamburg" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "Gender", "male" );
				myLog.LogKeyWordEnd();
			myLog.LogKeyWordStart( "Typekey", "eye color", "male" );
				myLog.LogKeyWordEnd();
			
			myLog.LogSequenceEnd();

			
		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
	}

	@Test
	public void TC_LogKeyWord_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/LogKeyWord_Test.html" );

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
	}

	
	@Test
	public void TC_Reset_Test() {

		Log2HTML myLog = new Log2HTML();
		myLog.setHTML_File( "target/Reset_Test.html" );

		myLog.LogTestcaseStart( "TC_Reset_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();
			
		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseStart( "This Test" );			
	
		myLog.Result2HTML();
	}

}

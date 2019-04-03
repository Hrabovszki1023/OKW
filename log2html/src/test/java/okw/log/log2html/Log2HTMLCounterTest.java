package okw.log.log2html;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import okw.log.log2html.Log2HTML;

public class Log2HTMLCounterTest {


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void tcTestcase_Normal_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/_Log2HTMLCounterTest-tcTestcase_Normal_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Normal_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

		myLog.Result2HTML();
		
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "3".toString(), LogBase.PrintCount.toString() );		

	}

	
	@Test
	public void tcTestcase_Aborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Aborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Aborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "3".toString(), LogBase.PrintCount.toString() );		
		
	}

	@Test
	public void tcTestcase_KeyWordNormal_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_KeyWordNormal_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_KeyWordNormal_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "2".toString(), LogBase.PrintCount.toString() );	
	}

	
	@Test
	public void tcTestcase_KeyWordAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_KeyWordAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_KeyWordAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "2".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_WarningAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_WarningAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "1".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_Warning_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Warning_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Warning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "1".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	
	@Test
	public void tcTestcase_Warning2_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Warning2_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Warning2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
				myLog.LogKeyWordEnd();
			myLog.LogWarning("Warning 1");
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "2".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	
	@Test
	public void tcTestcase_WarningAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_WarningAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "1".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_Error_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Error_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Error_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "1".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}
	
	
	@Test
	public void tcTestcase_Error2_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Error2_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Error2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogError("Error 2");
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "2".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_ErrorAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ErrorAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "1".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_ErrorAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ErrorAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogError("Error 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );

		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );

		assertEquals( "1".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_Passed_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Passed_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Passed_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "1".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_Passed2_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Passed2_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Passed2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Passed 1");
				myLog.LogKeyWordEnd();
			myLog.LogPass("Passed 2");
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "1".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "0".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "2".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_PassedAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
		
		assertEquals( "1".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_PassedAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogPass("Pass 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "1".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "0".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		//assertEquals( "0".toString(), LogBase.Passed.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_Exception_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Exception_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Exception_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "0".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "1".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );
	}

	@Test
	public void tcTestcase_Exception2_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Exception2_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Exception2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
				myLog.LogKeyWordEnd();
			myLog.LogException("Exception 2");
			myLog.LogTestcaseEnd();
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "0".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "2".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_ExceptionAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "0".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "0".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "1".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

	@Test
	public void tcTestcase_ExceptionAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ExceptionAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ExceptionAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogException("Exception 1");
		
		myLog.Result2HTML();
			
		assertEquals( "1".toString(), LogBase.TestcaseCount.toString() );
		assertEquals( "0".toString(), LogBase.TestcasePass.toString() );
		assertEquals( "1".toString(), LogBase.TestcaseFail.toString() );
	
		assertEquals( "0".toString(), LogBase.SequensCount.toString() );
		assertEquals( "0".toString(), LogBase.SequensPass.toString() );
		assertEquals( "0".toString(), LogBase.SequensFail.toString() );
		
		assertEquals( "1".toString(), LogBase.KeyWordCount.toString() );
		assertEquals( "0".toString(), LogBase.KeyWordPass.toString() );
		assertEquals( "1".toString(), LogBase.KeyWordFail.toString() );
		
		assertEquals( "1".toString(), LogBase.FunctionCount.toString() );
		assertEquals( "0".toString(), LogBase.FunctionPass.toString() );
		assertEquals( "0".toString(), LogBase.FunctionFail.toString() );
	
		assertEquals( "0".toString(), LogBase.PassedCount.toString() );
		assertEquals( "0".toString(), LogBase.ErrorCount.toString() );
		assertEquals( "1".toString(), LogBase.ExceptionCount.toString() );
		assertEquals( "0".toString(), LogBase.WarningCount.toString() );
		//assertEquals( "0".toString(), LogBase.Passed.toString() );
		assertEquals( "1".toString(), LogBase.PrintCount.toString() );				
	}

}

package okw.log.log2html;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import okw.log.log2html.Log2HTML;

public class Log2JSONTest {

    @Rule
    public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public String loadFile(String filename){

        StringBuilder myJSON = new StringBuilder();

        try{

          ClassLoader classloader = Thread.currentThread().getContextClassLoader();
          InputStream inputStream = classloader.getResourceAsStream(filename);
          InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
          BufferedReader reader = new BufferedReader(streamReader);
          for (String line; (line = reader.readLine()) != null;) {
              myJSON.append( line  + "\n" );
          }

        }catch(FileNotFoundException fnfe){
          // process errors
        }catch(IOException ioe){
          // process errors
        }
        return myJSON.toString();
      }
	
	   @Test
	    public void TC_LogPrint_Simple_Test()
	    {   
	        Log2HTML myLog = new Log2HTML( name.getMethodName() );
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Simple_Test" );
	            myLog.LogPrint( "LogPrint 1" );
	            myLog.LogPrint( "LogPrint 2" );
	            myLog.LogPrint( "LogPrint 3" );
	        myLog.LogTestcaseEnd();
	        
	        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	    }

	@Test
	public void TC_LogPrint_Test()
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
				
		myLog.LogTestcaseStart( "TC_LogPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterer Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
		assertEquals( "", myLog.Result2JSON( "test.json" ) );
		
	}

	@Test
	public void TC_LogPrintDebug_Test()
	{	
		Log2HTML myLog = new Log2HTML( name.getMethodName() );
	    myLog.setDebugMode( true );
				
		myLog.LogTestcaseStart( "TC_LogPrintDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrintDebug( "Print im Schlüsselwort");
				myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}
	
	@Test
	public void TC_ResultList_Test()
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
				
		myLog.LogTestcaseStart( "TC_ResultListPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenList( "ResultOpenList..." );
					myLog.LogPrint( "Print im Schlüsselwort");
					myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.ResCloseList();
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_ResultListDebug_Test( )
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
		myLog.setDebugMode( true );
				
		myLog.LogTestcaseStart( "TC_ResultListDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenListDebug( "ResultOpenListDebug" );
					myLog.LogPrintDebug( "Print im Schlüsselwort");
					myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.LogError( "Error" );
					myLog.LogPass( "Pass" );
					myLog.ResCloseListDebug();
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}
	
	@Test
	public void TC_LogException_Test()
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
				
		myLog.LogTestcaseStart( "TC_LogException_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogException( "Exception");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_LogError_Test()
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
				
		myLog.LogTestcaseStart( "TC_LogError_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogError("Error");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}
	
	@Test
	public void TC_LogWarning_Test()
	{	
		Log2HTML myLog = new Log2HTML(name.getMethodName());
				
		myLog.LogTestcaseStart( "TC_LogWarning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogWarning( "Warnung");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}
	
	   @Test
	    public void TC_LogVerify_Test()
	    {   
	        Log2HTML myLog = new Log2HTML(name.getMethodName());
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Test" );
	            myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
	            
	            //myLog.LogV
	            
	                myLog.LogKeyWordEnd();
	            myLog.LogPrint( "Print auf einer Ebene höher...");
	        myLog.LogTestcaseEnd();
	        
	        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	    }

	
	@Test
	public void TC_LogFunktion_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

		myLog.LogTestcaseStart( "TC_LogFunktion_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1");
		        myLog.LogPrint("Das ist ein LogPrint...");
		    myLog.LogFunctionEnd();
		myLog.LogTestcaseEnd();

        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_LogFunktionErrorWarning_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

		myLog.LogTestcaseStart( "TC_LogFunktion2_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		        myLog.LogPrint("Das ist ein LogPrint...");
		        myLog.LogError( "Error" );
	            myLog.LogError( "Warning" );
		    myLog.LogFunctionEnd();
        myLog.LogTestcaseEnd();

        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_LogFunktion_ReturnBoolean_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

		myLog.LogTestcaseStart( "TC_LogFunktion_ReturnBoolean_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		        myLog.LogPrint("Das ist ein LogPrint...");
		    myLog.LogFunctionEnd(true);
		myLog.LogTestcaseEnd();

        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	   @Test
	    public void TC_LogFunktionDebug_ReturnBoolean_Test() {

	        Log2HTML myLog = new Log2HTML(name.getMethodName());
	        myLog.setDebugMode( true ); 

	        myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnBoolean_Test" );
	            myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                myLog.LogPrintDebug("Das ist ein LogPrint...");
	            myLog.LogFunctionEndDebug(true);
	        myLog.LogTestcaseEnd();

	        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	    }


	    @Test
	    public void TC_LogFunktion_ReturnString_Test() {

	        Log2HTML myLog = new Log2HTML(name.getMethodName());

	        myLog.LogTestcaseStart( "TC_LogFunktion_ReturnString_Test" );
	            myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                myLog.LogPrint("Das ist ein LogPrint...");
	            myLog.LogFunctionEnd( "Return String" );
	        myLog.LogTestcaseEnd();

	        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	    }

	       @Test
	        public void TC_LogFunktionDebug_ReturnString_Test() {

	            Log2HTML myLog = new Log2HTML(name.getMethodName());
	            myLog.setDebugMode( true ); 

	            myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnString_Test" );
	                myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                    myLog.LogPrintDebug("Das ist ein LogPrintDebug...");
	                myLog.LogFunctionEndDebug( "Return String" );
	            myLog.LogTestcaseEnd();

	            assertEquals( "", myLog.Result2JSON( "test.json" ) );
	        }	   
	   

	        @Test
	        public void TC_LogFunktion_ReturnListString_Test() {

	            Log2HTML myLog = new Log2HTML(name.getMethodName());
	            ArrayList<String> returnListString= new ArrayList<String>();
	            
	            returnListString.add( "String 1" );
                returnListString.add( "String 2" );
                returnListString.add( "String 3" );
                
	            myLog.LogTestcaseStart( "TC_LogFunktion_ReturnListString_Test" );
	                myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                    myLog.LogPrint("Das ist ein LogPrint...");
	                myLog.LogFunctionEnd( returnListString );
	            myLog.LogTestcaseEnd();

	            assertEquals( "", myLog.Result2JSON( "test.json" ) );
	        }

	           @Test
	            public void TC_LogFunktionDebug_ReturnListString_Test() {

	                ArrayList<String> returnListString= new ArrayList<String>();

	                Log2HTML myLog = new Log2HTML(name.getMethodName());
	                myLog.setDebugMode( true ); 
	                
	                returnListString.add( "String 1" );
	                returnListString.add( "String 2" );
	                returnListString.add( "String 3" );

	                myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnListString_Test" );
	                    myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                        myLog.LogPrintDebug("Das ist ein LogPrint...");
	                    myLog.LogFunctionEndDebug( returnListString );
	                myLog.LogTestcaseEnd();

	                assertEquals( "", myLog.Result2JSON( "test.json" ) );
	            }      
	@Test
	public void TC_LogFunktionDebug_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());
		myLog.setDebugMode( true );

		myLog.LogTestcaseStart( "TC_LogFunktionDebug_Test" );
		
		    myLog.LogFunctionStartDebug("FunctionName", "String", "Parameter 1");
		
		    myLog.LogPrintDebug("Das ist ein LogPrint...");
		
		myLog.ResOpenListDebug( "ResultOpenListDebug" );
		myLog.LogPrintDebug( "Print im Schlüsselwort");
		myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
		myLog.LogError( "Fehler" );
		myLog.LogWarning( "Warning" );
		myLog.ResCloseListDebug();

		myLog.LogFunctionEndDebug();

		myLog.LogTestcaseEnd();

        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_LogSequence_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

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

        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	@Test
	public void TC_LogKeyWord_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseEnd();
		
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}

	
	@Test
	public void TC_Reset_Test() {

		Log2HTML myLog = new Log2HTML(name.getMethodName());

		myLog.LogTestcaseStart( "TC_Reset_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();
			
		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseStart( "This Test" );			
	
        assertEquals( "", myLog.Result2JSON( "test.json" ) );
	}
	
    @Test
    public void TC_LogLocalACCall_Test() {

        Log2HTML myLog = new Log2HTML(name.getMethodName());

        myLog.LogTestcaseStart( "TC_LogPrecondition_Test" );
        
        myLog.LogLocalACCallStart( "WHEN myPrecondion IS Test", "I" );
            myLog.LogSourceLocation( "10", "15", "myFeature", "mySourceType" );
        
            myLog.LogKeyWordStart( "Typekey", "Name", "Zoltan" );
                myLog.LogKeyWordEnd();
            myLog.LogKeyWordStart( "Typekey", "Password", "!?GhoKklA" );
                myLog.LogKeyWordEnd();
            
            myLog.LogLocalACCallEnd();
            
        myLog.LogTestcaseEnd();

        
        String Expected = "{\n" + 
                        " \"statistics\": {\n" + 
                        " \"PassedCount\": \"0\",\n" + 
                        " \"ExceptionCount\": \"0\",\n" + 
                        " \"ExceptionCount\": \"0\",\n" + 
                        " \"PassedCount\": \"0\",\n" + 
                        " \"TestcaseCount\": \"1\",\n" + 
                        " \"TestcasePass\": \"1\",\n" + 
                        " \"TestcaseFail\": \"0\",\n" + 
                        " \"SequensCount\": \"1\",\n" + 
                        " \"SequensPass\": \"1\",\n" + 
                        " \"SequensFail\": \"0\",\n" + 
                        " \"KeyWordCount\": \"3\",\n" + 
                        " \"KeyWordPass\": \"3\",\n" + 
                        " \"KeyWordFail\": \"0\",\n" + 
                        " \"Start time\": \"2019-Jul-27 07:58:05.492\",\n" + 
                        " \"End time\": \"2019-Jul-27 07:58:05.493\",\n" + 
                        " },\n" + 
                        " \"result\": {\n" + 
                        " \"LogTestcase1\": {\n" + 
                        "     \"Info\": \"TC_LogPrecondition_Test\",\n" + 
                        "     \"duration\": \"0,001\",\n" + 
                        "     \"LogPrecondition1\": {\n" + 
                        "         \"statistics\": {\n" + 
                        "         \"ErrorCount\": \"0\",\n" + 
                        "         \"ExceptionCount\": \"0\",\n" + 
                        "         \"WarningCount\": \"0\",\n" + 
                        "         \"PassedCount\": \"0\",\n" + 
                        "         \"PrintCount\": \"0\",\n" + 
                        "         \"FunctionCount\": \"0\",\n" + 
                        "         \"FunctionFail\": \"0\",\n" + 
                        "         \"FunctionPass\": \"0\",\n" + 
                        "         \"SequensCount\": \"0\",\n" + 
                        "         \"SequensFail\": \"0\",\n" + 
                        "         \"SequensPass\": \"0\",\n" + 
                        "         \"SubCount\": \"0\",\n" + 
                        "         \"SubFail\": \"0\",\n" + 
                        "         \"SubPass\": \"0\",\n" + 
                        "         \"StepCountLocal\": \"0\",\n" + 
                        "         \"StepFailLocal\": \"0\",\n" + 
                        "         \"StepPassLocal\": \"0\",\n" + 
                        "         \"KeyWordCountLocal\": \"3\",\n" + 
                        "         \"KeyWordFailLocal\": \"3\",\n" + 
                        "         \"KeyWordPassLocal\": \"0\",\n" + 
                        "         },\n" + 
                        "         \"duration\": \"0,000\",\n" + 
                        "         \"gherkin\": \"WHEN myPrecondion IS Test\",\n" + 
                        "         \"LogKeyword1\": {\n" + 
                        "             \"Keyword\": \"Typekey\",\n" + 
                        "             \"Parameter0\": \"Name\",\n" + 
                        "             \"Parameter1\": \"Zoltan\",\n" + 
                        "             \"duration\": \"0,000\",\n" + 
                        "         },\n" + 
                        "         \"LogKeyword2\": {\n" + 
                        "             \"Keyword\": \"Typekey\",\n" + 
                        "             \"Parameter0\": \"Password\",\n" + 
                        "             \"Parameter1\": \"!?GhoKklA\",\n" + 
                        "             \"duration\": \"0,000\",\n" + 
                        "         },\n" + 
                        "         \"LogKeyword3\": {\n" + 
                        "             \"Keyword\": \"Click\",\n" + 
                        "             \"Parameter0\": \"OK\",\n" + 
                        "             \"duration\": \"0,000\",\n" + 
                        "         },\n" + 
                        "     },\n" + 
                        " },\n" + 
                        " },\n" + 
                        "}\n" ;
        
        assertEquals( Expected, myLog.Result2JSON( "test.json" ) );
    }
}

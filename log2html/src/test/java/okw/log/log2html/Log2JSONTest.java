package okw.log.log2html;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.junit.JUnitBase;

@Tag("Log2HTML")
public class Log2JSONTest extends JUnitBase
{
    @BeforeEach
    public void setUp() throws Exception
    {
        okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
    }
    
	   @Test
	    public void TC_LogPrint_Simple_Test()
	    {   
	        Log2HTML myLog = new Log2HTML( TestName );
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Simple_Test" );
	            myLog.LogPrint( "LogPrint 1" );
	            myLog.LogPrint( "LogPrint 2" );
	            myLog.LogPrint( "LogPrint 3" );
	        myLog.LogTestcaseEnd();

	        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );	        

	        assertEquals( Expected, Current );
	    }

	@Test
	public void TC_LogPrint_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterer Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogPrintDebug_Test()
	{	
		Log2HTML myLog = new Log2HTML( TestName );
	    myLog.setDebugMode( true );
				
		myLog.LogTestcaseStart( "TC_LogPrintDebug_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrintDebug( "Print im Schlüsselwort");
				myLog.LogPrintDebug( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrintDebug( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_ResultList_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_ResultListPrint_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.ResOpenList( "ResultOpenList..." );
					myLog.LogPrint( "Print im Schlüsselwort");
					myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
					myLog.ResCloseList();
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_ResultListDebug_Test( )
	{	
		Log2HTML myLog = new Log2HTML(TestName);
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

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_LogException_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogException_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogException( "Exception");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogError_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogError_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogError("Error");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	@Test
	public void TC_LogWarning_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "TC_LogWarning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogWarning( "Warnung");
				myLog.LogKeyWordEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
	   @Test
	    public void TC_LogVerify_Test()
	    {   
	        Log2HTML myLog = new Log2HTML(TestName);
	                
	        myLog.LogTestcaseStart( "TC_LogPrint_Test" );
	            myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
	            
	            //myLog.LogV
	            
	                myLog.LogKeyWordEnd();
	            myLog.LogPrint( "Print auf einer Ebene höher...");
	        myLog.LogTestcaseEnd();

            String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
            String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

            assertEquals( Expected, Current );
	    }

	
	@Test
	public void TC_LogFunktion_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogFunktion_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1");
		        myLog.LogPrint("Das ist ein LogPrint...");
		    myLog.LogFunctionEnd();
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogFunktionErrorWarning_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogFunktion2_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		        myLog.LogPrint("Das ist ein LogPrint...");
		        myLog.LogError( "Error" );
	            myLog.LogError( "Warning" );
		    myLog.LogFunctionEnd();
        myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogFunktion_ReturnBoolean_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogFunktion_ReturnBoolean_Test" );
		    myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
		        myLog.LogPrint("Das ist ein LogPrint...");
		    myLog.LogFunctionEnd(true);
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	   @Test
	    public void TC_LogFunktionDebug_ReturnBoolean_Test() {

	        Log2HTML myLog = new Log2HTML(TestName);
	        myLog.setDebugMode( true ); 

	        myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnBoolean_Test" );
	            myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                myLog.LogPrintDebug("Das ist ein LogPrint...");
	            myLog.LogFunctionEndDebug(true);
	        myLog.LogTestcaseEnd();

	        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

	        assertEquals( Expected, Current );
	    }


	    @Test
	    public void TC_LogFunktion_ReturnString_Test() {

	        Log2HTML myLog = new Log2HTML(TestName);

	        myLog.LogTestcaseStart( "TC_LogFunktion_ReturnString_Test" );
	            myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                myLog.LogPrint("Das ist ein LogPrint...");
	            myLog.LogFunctionEnd( "Return String" );
	        myLog.LogTestcaseEnd();

	        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

	        assertEquals( Expected, Current );
	    }

	       @Test
	        public void TC_LogFunktionDebug_ReturnString_Test() {

	            Log2HTML myLog = new Log2HTML(TestName);
	            myLog.setDebugMode( true ); 

	            myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnString_Test" );
	                myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                    myLog.LogPrintDebug("Das ist ein LogPrintDebug...");
	                myLog.LogFunctionEndDebug( "Return String" );
	            myLog.LogTestcaseEnd();

	            String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	            String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

	            assertEquals( Expected, Current );
	        }	   
	   

	        @Test
	        public void TC_LogFunktion_ReturnListString_Test() {

	            Log2HTML myLog = new Log2HTML(TestName);
	            ArrayList<String> returnListString= new ArrayList<String>();
	            
	            returnListString.add( "String 1" );
                returnListString.add( "String 2" );
                returnListString.add( "String 3" );
                
	            myLog.LogTestcaseStart( "TC_LogFunktion_ReturnListString_Test" );
	                myLog.LogFunctionStart("FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                    myLog.LogPrint("Das ist ein LogPrint...");
	                myLog.LogFunctionEnd( returnListString );
	            myLog.LogTestcaseEnd();

	            String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	            String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

	            assertEquals( Expected, Current );
	        }

	           @Test
	            public void TC_LogFunktionDebug_ReturnListString_Test() {

	                ArrayList<String> returnListString= new ArrayList<String>();

	                Log2HTML myLog = new Log2HTML(TestName);
	                myLog.setDebugMode( true ); 
	                
	                returnListString.add( "String 1" );
	                returnListString.add( "String 2" );
	                returnListString.add( "String 3" );

	                myLog.LogTestcaseStart( "TC_LogFunktionDebug_ReturnListString_Test" );
	                    myLog.LogFunctionStartDebug( "FunctionName", "String", "Parameter 1", "String", "Parameter 2");
	                        myLog.LogPrintDebug("Das ist ein LogPrint...");
	                    myLog.LogFunctionEndDebug( returnListString );
	                myLog.LogTestcaseEnd();

	                String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
	                String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

	                assertEquals( Expected, Current );
	            }      
	@Test
	public void TC_LogFunktionDebug_Test() {

		Log2HTML myLog = new Log2HTML(TestName);
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

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogSequence_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

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

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	@Test
	public void TC_LogKeyWord_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_LogSequence_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();

		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}

	
	@Test
	public void TC_Reset_Test() {

		Log2HTML myLog = new Log2HTML(TestName);

		myLog.LogTestcaseStart( "TC_Reset_Test" );
		
		myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan");
			myLog.LogPrint("Das ist ein LogPrint...");
			myLog.LogKeyWordEnd();
			
//		myLog.LogKeyWordStart( "Mehrere Werte", "Name", "Zoltan", "Nachname", "Uschi");
//			myLog.LogPrint("Das ist ein LogPrint...");
//			myLog.LogKeyWordEnd();
	myLog.LogTestcaseEnd();	
		

		myLog.LogTestcaseStart( "This Test" );			
        myLog.LogTestcaseEnd(); 

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
	}
	
    @Test
    public void TC_LogLocalACCall_Test() {

        Log2HTML myLog = new Log2HTML(TestName);

        myLog.LogTestcaseStart( "TC_LogPrecondition_Test" );
        
        myLog.LogLocalACCallStart( "WHEN myPrecondion IS Test", "I" );
            myLog.LogSourceLocation( "10", "15", "myFeature", "mySourceType" );
        
            myLog.LogKeyWordStart( "Typekey", "Name", "Zoltan" );
                myLog.LogKeyWordEnd();
            myLog.LogKeyWordStart( "Typekey", "Password", "!?GhoKklA" );
                myLog.LogKeyWordEnd();
            
            myLog.LogLocalACCallEnd();
            
        myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        String Expected = this.loadUTF8FileFromResource( "Log2JSONTest/" + TestName + ".json" );            

        assertEquals( Expected, Current );
    }
}

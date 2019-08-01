package okw.log.log2html;

import static org.junit.Assert.*;

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

public class Log2HTMLCounterTest {

    @Rule
    public TestName name = new TestName();

	@Before
	public void setUp() throws Exception {
	    
	       okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
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
	public void tc_OK_Testcase_Normal_Test()
	{	
		Log2HTML myLog = new Log2HTML( );
						
		myLog.LogTestcaseStart( "tcTestcase_Normal_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + name.getMethodName() + ".json" );
        
        String Expected = this.loadFile( name.getMethodName() + ".json" );
             
        assertEquals( Expected, Current );      

	}

	
	@Test
	public void tc_OK_Testcase_Aborted_Test()
	{	
		Log2HTML myLog = new Log2HTML("target/Log2HTMLCounterTest-tcTestcase_Aborted_Test.html");
						
		myLog.LogTestcaseStart( "tcTestcase_Aborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );       
	}

	
	@Test
	public void tc_OK_Testcase_KeyWordNormal_Test()
	{	
		Log2HTML myLog = new Log2HTML("target/Log2HTMLCounterTest-tcTestcase_KeyWordNormal_Test.html");
						
		myLog.LogTestcaseStart( "tcTestcase_KeyWordNormal_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();

			String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );    

	}

	
	@Test
	public void tc_OK_Testcase_KeyWordAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML( "target/Log2HTMLCounterTest-tcTestcase_KeyWordAborted_Test.html" );
						
		myLog.LogTestcaseStart( "tcTestcase_KeyWordAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	                 
	            assertEquals( Expected, Current );    
	}

	@Test
	public void tc_OK_Testcase_WarningAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_WarningAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );       
	}

	@Test
	public void tc_OK_Testcase_Warning_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Warning_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Warning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );
	}

	
	@Test
	public void tc_OK_Testcase_Warning2_Test()
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
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );      

	}

	
	@Test
	public void tc_OK_Testcase_WarningAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_WarningAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Error_Test()
	{	
		Log2HTML myLog = new Log2HTML();
				
		myLog.LogTestcaseStart( "tcTestcase_Error_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
	        String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	        
            String Expected = this.loadFile( name.getMethodName() + ".json" );
	        
	        assertEquals( Expected, Current );		
	}
	
	
	@Test
	public void tc_OK_Testcase_Error2_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
				
		myLog.LogTestcaseStart( "tcTestcase_Error2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogError("Error 2_Z");
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current ); 
    }

	@Test
	public void tc_OK_Testcase_ErrorAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ErrorAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_ErrorAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ErrorAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogError("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	   @Test
	    public void tc_OK_Testcase_FunktionDebug_Test()
	    {   
	        Log2HTML myLog = new Log2HTML();
	        myLog.setDebugMode(true);
	        
	        myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_TC_KW_F_Test" );
	            myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
	                myLog.LogPrint( "Print im Schlüsselwort");
	                myLog.LogFunctionStartDebug("Funktion_1", "Param 1", "Value 1");
	                    myLog.LogError("Error 1");
	                    myLog.LogFunctionEndDebug( );
	                myLog.LogKeyWordEnd( );
	        myLog.LogTestcaseEnd( );
	        
	                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	                
	                String Expected = this.loadFile( name.getMethodName() + ".json" );
	                
	                assertEquals( Expected, Current );      
	    }
	   
	   
       @Test
       public void tc_OK_Testcase_Funktion_Test()
       {   
           Log2HTML myLog = new Log2HTML();
           myLog.setDebugMode(true);
           
           myLog.LogTestcaseStart( "tcTestcase_Funktion_Test" );
               myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                   myLog.LogPrint( "Print im Schlüsselwort");
                   myLog.LogFunctionStart("Funktion_1", "Param 1", "Value 1");
                       myLog.LogError("Error 1");
                       myLog.LogFunctionEnd( );
                   myLog.LogKeyWordEnd( );
           myLog.LogTestcaseEnd( );
           
                   String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                   
                   String Expected = this.loadFile( name.getMethodName() + ".json" );
                   
                   assertEquals( Expected, Current );      
       }
       
       
	@Test
	public void tc_OK_Testcase_Passed_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_Passed_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Passed_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Passed2_Test()
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
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_PassedAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_PassedAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogPass("Pass 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      
	
	}

	@Test
	public void tc_OK_Testcase_Exception_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/" + name.getMethodName() + ".html" );
				
		myLog.LogTestcaseStart( "tcTestcase_Exception_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + name.getMethodName() + ".json" );
            
            String Expected = this.loadFile( name.getMethodName() + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Exception2_Test()
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
		
		String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
		
        String Expected = this.loadFile( name.getMethodName() + ".json" );
		
		assertEquals( Expected, Current );

	}

	@Test
	public void tc_OK_Testcase_ExceptionAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_PassedAborted_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
		
	            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
	            
	            String Expected = this.loadFile( name.getMethodName() + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_ExceptionAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML();
		myLog.setDebugMode(true);
		
		myLog.setHTML_File( "target/Log2HTMLCounterTest-tcTestcase_ExceptionAborted_TC_KW_F_Test.html" );
				
		myLog.LogTestcaseStart( "tcTestcase_ExceptionAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
                   myLog.LogPrint( "Print im Schlüsselwort");
                   myLog.LogPass( "Pass" );
				   myLog.LogException("Exception 1");
                //myLog.LogFunctionEndDebug();
            //myLog.LogKeyWordEnd();
        //myLog.LogTestcaseEnd();
                
		
		            String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
		            
		            String Expected = this.loadFile( name.getMethodName() + ".json" );
		            
		            assertEquals( Expected, Current );      
	}
	
    
    
    @Test
    public void tc_AcceptanceCriteria_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        myLog.setDebugMode(true);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogAcceptanceCriteriaStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogAcceptanceCriteriaEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogAcceptanceCriteriaStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogAcceptanceCriteriaEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogAcceptanceCriteriaStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogAcceptanceCriteriaEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogAcceptanceCriteriaStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogAcceptanceCriteriaEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                
                assertEquals( Expected, Current );      
    }
    
    
    
    @Test
    public void tc_Precondition_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        myLog.setDebugMode(true);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogPreconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogPreconditionEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogPreconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPreconditionEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogPreconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPreconditionEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogPreconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPreconditionEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                
                assertEquals( Expected, Current );      
    }
    
    
    @Test
    public void tc_Postcondition_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        myLog.setDebugMode(true);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogPostconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogPostconditionEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogPostconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPostconditionEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogPostconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPostconditionEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogPostconditionStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogPostconditionEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                
                assertEquals( Expected, Current );      
    }
    
    
    @Test
    public void tc_Step_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogStepStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogStepStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogStepStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogStepStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                
                assertEquals( Expected, Current );      
}
    
    
    
    @Test
    public void tc_Sub_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogSubStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogSubEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogSubStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogSubEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogSubStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogSubEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogSubStart( "WHEN Gherkin IS myGherkin" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogSubEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                assertEquals( Expected, Current );      
}
    
    
    
    
    @Test
    public void tc_KomplexExample_Test()
    {   
        Log2HTML myLog = new Log2HTML();
        
        myLog.LogTestcaseStart( "Login Valid" );
        
            myLog.LogPreconditionStart( "WHEN PreCon IS myPreCon" );
                myLog.LogKeyWordStart( "Start App", "Chrome" ); myLog.LogKeyWordEnd( );

                myLog.LogStepStart( "WHEN URL IS myURL" );
                    myLog.LogKeyWordStart( "Set Value", "URL", "myURL" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );
            
                myLog.LogStepStart( "THEN URL IS myURL" );
                    myLog.LogKeyWordStart( "VerifyValue Value", "URL", "myURL" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );
            myLog.LogPreconditionEnd();
            
            myLog.LogAcceptanceCriteriaStart( "WHEN AC IS myAC" );
                myLog.LogStepStart( "WHEN User IS Zoltan" );
                    myLog.LogKeyWordStart( "Select Window", "Login" ); myLog.LogKeyWordEnd( );
                    myLog.LogKeyWordStart( "Set Value", "User", "Zoltan" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );

                myLog.LogStepStart( "WHEN Password IS Geheim" );
                    myLog.LogKeyWordStart( "Set Value", "Password", "Geheim" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );

                myLog.LogStepStart( "WHEN Login IS #pressed" );
                    myLog.LogKeyWordStart( "Click On", "Login" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );
                
            myLog.LogAcceptanceCriteriaEnd();
            
            myLog.LogPostconditionStart( "WHEN PostCon IS myPostCon" );
                myLog.LogStepStart( "WHEN Exit IS #pressed" );
                    myLog.LogKeyWordStart( "Click On", "Exit" ); myLog.LogKeyWordEnd( );
                myLog.LogStepEnd( );
            myLog.LogPostconditionEnd();
            
        myLog.LogTestcaseEnd( );

                String Current = myLog.Result2JSON( "target/" + name.getMethodName()+".json" );
                
                String Expected = this.loadFile( name.getMethodName() + ".json" );
                
                assertEquals( Expected, Current );      
}
}

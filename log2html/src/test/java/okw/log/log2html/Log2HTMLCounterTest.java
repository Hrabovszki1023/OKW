package okw.log.log2html;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.junit.JUnitBase;
import okw.log.log2html.Log2HTML;

@Tag("Log2HTML")
public class Log2HTMLCounterTest extends JUnitBase
{

	@BeforeEach
	public void setUp() throws Exception
	{
	    
	    okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
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

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      

	}

	
	@Test
	public void tc_OK_Testcase_Aborted_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
						
		myLog.LogTestcaseStart( "tcTestcase_Aborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogPrint( "Print auf einer Ebene höher...");
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );       
	}

	
	@Test
	public void tc_OK_Testcase_KeyWordNormal_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
						
		myLog.LogTestcaseStart( "tcTestcase_KeyWordNormal_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPrint( "Das hier ist ein weiterern Print-Absatz im Schlüsselwort.");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();

			String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
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
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	                 
	            assertEquals( Expected, Current );    
	}

	@Test
	public void tc_OK_Testcase_WarningAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );       
	}

	@Test
	public void tc_OK_Testcase_Warning_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Warning_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );
	}

	
	@Test
	public void tc_OK_Testcase_Warning2_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Warning2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
				myLog.LogKeyWordEnd();
			myLog.LogWarning("Warning 1");
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );      

	}

	
	@Test
	public void tc_OK_Testcase_WarningAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		myLog.setDebugMode(true);
				
		myLog.LogTestcaseStart( "tcTestcase_WarningAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogWarning("Warning 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Error_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Error_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
	        String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	        
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	        
	        assertEquals( Expected, Current );		
	}
	
	
	@Test
	public void tc_OK_Testcase_Error2_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		
				
		myLog.LogTestcaseStart( "tcTestcase_Error2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogError("Error 2_Z");
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current ); 
    }

	@Test
	public void tc_OK_Testcase_ErrorAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogError("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_ErrorAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		myLog.setDebugMode(true);
		
		myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogError("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	   @Test
	    public void tc_OK_Testcase_FunktionDebug_Test()
	    {   
	        Log2HTML myLog = new Log2HTML(TestName);
	        myLog.setDebugMode(true);
	        
	        myLog.LogTestcaseStart( "tcTestcase_ErrorAborted_TC_KW_F_Test" );
	            myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
	                myLog.LogPrint( "Print im Schlüsselwort");
	                myLog.LogFunctionStartDebug("Funktion_1", "Param 1", "Value 1");
	                    myLog.LogError("Error 1");
	                    myLog.LogFunctionEndDebug( );
	                myLog.LogKeyWordEnd( );
	        myLog.LogTestcaseEnd( );
	        
	                String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	                
	                String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	                
	                assertEquals( Expected, Current );      
	    }
	   
	   
       @Test
       public void tc_OK_Testcase_Funktion_Test()
       {   
           Log2HTML myLog = new Log2HTML(TestName);
           myLog.setDebugMode(true);
           
           myLog.LogTestcaseStart( "tcTestcase_Funktion_Test" );
               myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                   myLog.LogPrint( "Print im Schlüsselwort");
                   myLog.LogFunctionStart("Funktion_1", "Param 1", "Value 1");
                       myLog.LogError("Error 1");
                       myLog.LogFunctionEnd( );
                   myLog.LogKeyWordEnd( );
           myLog.LogTestcaseEnd( );
           
                   String Current = myLog.Result2JSON( "target/" + TestName+".json" );
                   
                   String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
                   
                   assertEquals( Expected, Current );      
       }
       
       
	@Test
	public void tc_OK_Testcase_Passed_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Passed_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Passed2_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Passed2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Passed 1");
				myLog.LogKeyWordEnd();
			myLog.LogPass("Passed 2");
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_PassedAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogPass("Error 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_PassedAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		myLog.setDebugMode(true);
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_TC_KW_F_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogFunctionStartDebug("Funktion_1", "P1=", "P1");
				myLog.LogPass("Pass 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      
	
	}

	@Test
	public void tc_OK_Testcase_Exception_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Exception_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
				myLog.LogKeyWordEnd();
			myLog.LogTestcaseEnd();
		
            String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
            
            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
            
            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_Exception2_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_Exception2_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
				myLog.LogKeyWordEnd();
			myLog.LogException("Exception 2");
			myLog.LogTestcaseEnd();
		
		String Current = myLog.Result2JSON( "target/" + TestName+".json" );
		
        String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
		
		assertEquals( Expected, Current );

	}

	@Test
	public void tc_OK_Testcase_ExceptionAborted_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
				
		myLog.LogTestcaseStart( "tcTestcase_PassedAborted_Test" );
			myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
				myLog.LogPrint( "Print im Schlüsselwort");
				myLog.LogException("Exception 1");
		
	            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
	            
	            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
	            
	            assertEquals( Expected, Current );      

	}

	@Test
	public void tc_OK_Testcase_ExceptionAborted_TC_KW_F_Test()
	{	
		Log2HTML myLog = new Log2HTML(TestName);
		myLog.setDebugMode(true);
				
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
                
		
		            String Current = myLog.Result2JSON( "target/" + TestName+".json" );
		            
		            String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
		            
		            assertEquals( Expected, Current );      
	}
    
    
    @Test
    public void tc_LogRemoteACCall_Test()
    {   
        Log2HTML myLog = new Log2HTML(TestName);
        myLog.setDebugMode(true);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogRemoteACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogRemoteACCallEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogRemoteACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogRemoteACCallEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogRemoteACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogRemoteACCallEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogRemoteACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogRemoteACCallEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + TestName+".json" );
                
                String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
                
                assertEquals( Expected, Current );      
    }
    
    
    @Test
    public void tc_LocalACCall_Test()
    {   
        Log2HTML myLog = new Log2HTML(TestName);
        myLog.setDebugMode(true);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogLocalACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogLocalACCallEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
            myLog.LogLocalACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogLocalACCallEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogLocalACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogLocalACCallEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogLocalACCallStart( "WHEN Gherkin IS myGherkin", "I" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogLocalACCallEnd();
        myLog.LogTestcaseEnd( );
        
        
        String Current = myLog.Result2JSON( "target/" + TestName+".json" );
                
        String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
                
        assertEquals( Expected, Current );      
    }
    
    
    @Test
    public void tc_Step_Test()
    {   
        Log2HTML myLog = new Log2HTML(TestName);
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Print" );
            myLog.LogStepStart( "myCat_1", "myCatType_1", "myChoice_1", "myFeature_1", "myLocalFeature_1", "WHEN myCat_1 IS myChoice_1", "myType_1 TestStep" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogPrint( "Print im Schlüsselwort");
                    myLog.LogKeyWordEnd( );
                myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );

        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Warning" );
        myLog.LogStepStart( "myCat_2", "myCatType_2", "myChoice_2", "myFeature_2", "myLocalFeature_2", "WHEN myCat_2 IS myChoice_2", "myType_2 TestStep" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogWarning( "Warning im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Error" );
            myLog.LogStepStart( "myCat_3", "myCatType_3", "myChoice_3", "myFeature_3", "myLocalFeature_3", "WHEN myCat_3 IS myChoice_3", "myType_3 TestStep" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogError( "Error im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
        myLog.LogTestcaseStart( "tcAcceptanceCriteria_Exception" );
            myLog.LogStepStart( "myCatName_4", "myCatType_4", "myChoice_4", "myFeature_4", "myLocalFeature_4", "WHEN myCat_4 IS myChoice_4", "myType_4 TestStep" );
                myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
                    myLog.LogException( "Exception im Schlüsselwort");
                myLog.LogKeyWordEnd( );
            myLog.LogStepEnd();
        myLog.LogTestcaseEnd( );
        
                String Current = myLog.Result2JSON( "target/" + TestName+".json" );
                
                String Expected = this.loadUTF8FileFromResource( "Log2HTMLCounterTest/" + TestName + ".json" );
                
                assertEquals( Expected, Current );      
   }
}

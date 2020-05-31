package okw.log.log2html;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.junit.JUnitBase;
import okw.log.log2html.Log2HTML;

public class LogWarning_Test extends JUnitBase
{

    String ClassName = this.getClass().getSimpleName();
    
	@BeforeEach
	public void setUp() throws Exception
	{
	    okw.OKW_Properties.getInstance().setProperty( "Log2HTML.Test", "true" );
	}

    @Test
    public void tc_LogFunction_1_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FunctionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEnd();        

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_2_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEnd( true );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_3_LogWarning_Test()
    {   
        ArrayList<String> lsReturn = new ArrayList<String>();
        
        lsReturn.add( "Sting 1" );
        lsReturn.add( "Sting 2" );
        lsReturn.add( "Sting 3" );
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEnd( lsReturn );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunction_4_LogWarning_Test()
    {   
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStart( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEnd( "Return String" );

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    
    @Test
    public void tc_LogTestcaseStart_LogWarning_Normal_Test()
    {   
        Log2HTML myLog = new Log2HTML( "Log2HTML - " + TestName );
                        
        myLog.LogTestcaseStart( TestName );
             myLog.LogWarning( "LogWarning");
        myLog.LogTestcaseEnd();

        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    
    @Test
    public void tc_LogFunctionDebug_1_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEndDebug();        
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_LogFunctionDebug_2_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEndDebug( true );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_LogFunctionDebug_3_LogWarning_Test()
    {   
        ArrayList<String> lsReturn = new ArrayList<String>();
        
        lsReturn.add( "Sting 1" );
        lsReturn.add( "Sting 2" );
        lsReturn.add( "Sting 3" );
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEndDebug( lsReturn );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogFunctionDebug_4_LogWarning_Test()
    {   
        
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogFunctionStartDebug( "FuncTionStart", "Param_1", "Value 1" );
             myLog.LogWarning( "LogWarning");
        myLog.LogFunctionEndDebug( "Return String" );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogLocalACCallStart_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogLocalACCallStart( "my source excerpt", "my Local AC Type" );;
             myLog.LogWarning( "LogWarning");
        myLog.LogLocalACCallEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogRemoteACCallStart_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogRemoteACCallStart( "sourceExcerpt", "my remote AC type" );
             myLog.LogWarning( "LogWarning");
        myLog.LogRemoteACCallEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogSequence_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogSequenceStart( "Sequence", "Window", "SequenzName", "SeqID" );
             myLog.LogWarning( "LogWarning");
        myLog.LogSequenceEnd( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogStep_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
        
        myLog.LogTestcaseStart( "TestCase = " + TestName );
        
        myLog.LogStepStart( "mycategoryName", "mycategoryType", "mychoiceValue", "myfeatureName", "mylocalCategoryName", "mysourceExcerpt", "TestStep" );
             myLog.LogWarning( "LogWarning");
        myLog.LogStepEnd( );
    
        myLog.LogTestcaseEnd();
        
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    
    @Test
    public void tc_LogKeyWordStart_LogWarning_Normal_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.LogKeyWordStart( "Gib ein", "Name", "Zoltan" );
            myLog.LogWarning( "LogWarning");
            myLog.LogKeyWordEnd();
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }

    @Test
    public void tc_ResultList_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.ResOpenList( "fps_ListHeader" );
             myLog.LogWarning( "LogWarning");
        myLog.ResCloseList( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }
    

    @Test
    public void tc_ResultListDebug_LogWarning_Test()
    {   
        Log2HTML myLog = new Log2HTML( TestName );
                        
        myLog.ResOpenListDebug( "fps_ListHeader" );
             myLog.LogWarning( "LogWarning");
        myLog.ResCloseListDebug( );
    
        String Current = myLog.Result2JSON( "target/" + TestName + ".json" );
        
        String Expected = this.loadUTF8FileFromResource( ClassName + "/" + TestName + ".json" );
             
        assertEquals( Expected, Current );      
    }
}

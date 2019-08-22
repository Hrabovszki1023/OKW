package okw.log.log2html;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import okw.log.Logger_Sngltn;
import okw.log.log2html.Log2HTML;

public class Logger_Test
{
    protected static Log2HTML myLog2HTML = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {  
        myLog2HTML = new Log2HTML("Logger2_Test");
        Logger_Sngltn.getInstance().addLogger(myLog2HTML);

        Logger_Sngltn.getInstance().setDebugMode(false);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        myLog2HTML.Result2HTML("Logger2_Test.html");
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

   @Test
    public void tcGet2ndInstance()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );

        Logger_Sngltn my2nLog = Logger_Sngltn.getInstance();
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcBeginTest_EndTest" );
        
        my2nLog.LogKeyWordStart( "LogKeyWordStart" );
        my2nLog.LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogTestcaseStart_LogTestcaseEnd()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcBeginTest_EndTest" );
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcBeginTest_EndTest" );
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }
    
    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_NoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart" );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
      
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart" );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }

    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_OneParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
      
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }

    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_TwoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
      
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }


    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
      
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );
        
        Logger_Sngltn.getInstance().LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
        Logger_Sngltn.getInstance().LogKeyWordEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }
    
    @Test
    public void tcLogSequenceStart_LogSequenceEnd_OhneParamater()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Logger_Sngltn.getInstance().LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
        Logger_Sngltn.getInstance().LogSequenceEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
        
        
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Logger_Sngltn.getInstance().LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
        Logger_Sngltn.getInstance().LogSequenceEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd(); 
    }
    
    @Test
    public void tcResultOpenList_ResultCloseList()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L1" );
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 1" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 3" );
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L1" );
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 1" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag 3" );
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }

    @Test (expected=ClassCastException.class)
    public void tcResultOpenList_ResultCloseList_LevelTest()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L1" );
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag" );
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList(); // one close more than open
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L1" );
        Logger_Sngltn.getInstance().ResOpenList( "ResOpenList L2" );
        Logger_Sngltn.getInstance().LogPrint( "Eintrag" );
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList();
        Logger_Sngltn.getInstance().ResCloseList(); // one close more than open
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcResultOpenListDebug_ResultCloseListDebug()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenListDebug( "ResOpenList" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 1" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 2" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 3" );
        Logger_Sngltn.getInstance().ResCloseListDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();


        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Logger_Sngltn.getInstance().ResOpenListDebug( "ResOpenList" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 1" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 2" );
        Logger_Sngltn.getInstance().LogPrintDebug( "Eintrag 3" );
        Logger_Sngltn.getInstance().ResCloseListDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogError()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogError" );

        Logger_Sngltn.getInstance().LogError( "Error..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogError" );

        Logger_Sngltn.getInstance().LogError( "Error..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogPass()
    {
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogPass" );

        Logger_Sngltn.getInstance().LogPass( "Pass..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogWarning()
    {
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogWarning" );

        Logger_Sngltn.getInstance().LogWarning( "Warning..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogException()
    {
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogException" );

        Logger_Sngltn.getInstance().LogException( "Exception 1" );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogPrint()
    {
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogPrint" );

        Logger_Sngltn.getInstance().LogPrint( "Print hore something..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogPrintDebug()
    {
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogPrintDebug" );

        Logger_Sngltn.getInstance().LogPrintDebug( "Print hore something..." );
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    
    
    
    @Test
    public void tcLogFunctionEnd()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd(  );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd(  );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }

    @Test
    public void tcLogFunctionEndDebug()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug(  );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug(  );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Boolean()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Boolean" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( true );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Boolean" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( true );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Booleannull()
    {
        Boolean Return = null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Booleannull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Booleannull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Boolean()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Boolean" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( true );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Boolean" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( true );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Booleannull()
    {
        Boolean Return = null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Booleannull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Booleannull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    @Test
    public void tcLogFunctionEnd_String()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_String" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( "Return String" );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_String" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( "Return String" );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Stringnull()
    {
        String ReturnString = null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Stringnull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( ReturnString );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_Stringnull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( ReturnString );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_String()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_String" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( "Return String" );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_String" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( "Return String" );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Stringnull()
    {
        String ReturnString = null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Stringnull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( ReturnString );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_Stringnull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( ReturnString );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }

    @Test
    public void tcLogFunctionEnd_ListString()
    {
        ArrayList<String> Return = new ArrayList<String>();
        Return.add( "String Value 1" );
        Return.add( "String Value 2" );
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_ListString" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_ListString" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_ListStringnull()
    {
        ArrayList<String> Return = null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_ListStringnull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEnd_ListStringnull" );

        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_ListString()
    {
        ArrayList<String> Return = new ArrayList<String>();
        Return.add( "String Value 1" );
        Return.add( "String Value 2" );
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_ListString" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_ListString" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_ListStringnull()
    {
        ArrayList<String> Return =  null;
        
        Logger_Sngltn.getInstance().setDebugMode( false );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_ListStringnull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();

        
        Logger_Sngltn.getInstance().setDebugMode( true );
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionEndDebug_ListStringnull" );

        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug( Return );

        Logger_Sngltn.getInstance().LogTestcaseEnd();
    }
    

    @Test
    public void tcLogFunctionStart_NoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStart_NoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
  

        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStart_NoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart" );
        Logger_Sngltn.getInstance().LogFunctionEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }
    
    @Test
    public void tcLogFunctionStartDebug_NoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStartDebug_NoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
        
        
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStartDebug_NoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd(); 
    }


    @Test
    public void tcLogFunctionStart_TwoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStart_TwoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart", "Param A1", "Param A2" );
        Logger_Sngltn.getInstance().LogFunctionEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
  

        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStart_TwoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStart( "LogFunctionStart", "Param A1", "Param A2" );
        Logger_Sngltn.getInstance().LogFunctionEnd();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();

    }
    
    @Test
    public void tcLogFunctionStartDebug_TwoParam()
    {
        Logger_Sngltn.getInstance().setDebugMode( false );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStartDebug_TwoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug", "Param A1", "Param A2" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd();
        
        
        Logger_Sngltn.getInstance().setDebugMode( true );
        
        Logger_Sngltn.getInstance().LogTestcaseStart( "tcLogFunctionStartDebug_TwoParam" );
        
        Logger_Sngltn.getInstance().LogFunctionStartDebug( "LogFunctionStartDebug", "Param A1", "Param A2" );
        Logger_Sngltn.getInstance().LogFunctionEndDebug();
        
        Logger_Sngltn.getInstance().LogTestcaseEnd(); 
    }
}

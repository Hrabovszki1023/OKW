package okw.log;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

public class Logger_Test
{

    Logger_Sngltn Log = Logger_Sngltn.getInstance();
    
    @BeforeAll
    public static void setUpBeforeClass() throws Exception
    {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * 
     */
    @Test
    public void tcGet2ndInstance()
    {
        Log.setDebugMode( false );

        Logger_Sngltn my2nLog = Logger_Sngltn.getInstance();
        
        Log.LogTestcaseStart( "tcBeginTest_EndTest" );
        
        my2nLog.LogKeyWordStart( "LogKeyWordStart" );
        my2nLog.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogTestcaseStart_LogTestcaseEnd()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcBeginTest_EndTest" );
        Log.LogTestcaseEnd();

        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcBeginTest_EndTest" );
        Log.LogTestcaseEnd();

    }
    
    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_NoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Log.LogKeyWordStart( "LogKeyWordStart" );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

        
      
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Log.LogKeyWordStart( "LogKeyWordStart" );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();
    }

    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_OneParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

        
      
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

    }

    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_TwoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

        
      
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

    }


    @Test
    public void tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

        
      
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );
        
        Log.LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
        Log.LogKeyWordEnd();
        
        Log.LogTestcaseEnd();

    }
    
    @Test
    public void tcLogSequenceStart_LogSequenceEnd_OhneParamater()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Log.LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
        Log.LogSequenceEnd();
        
        Log.LogTestcaseEnd();
        
        
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );
        
        Log.LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
        Log.LogSequenceEnd();
        
        Log.LogTestcaseEnd(); 
    }
    
    @Test
    public void tcResultOpenList_ResultCloseList()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenList( "ResOpenList L1" );
        Log.ResOpenList( "ResOpenList L2" );
        Log.LogPrint( "Eintrag 1" );
        Log.LogPrint( "Eintrag 2" );
        Log.LogPrint( "Eintrag 3" );
        Log.ResCloseList();
        Log.ResCloseList();
        
        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenList( "ResOpenList L1" );
        Log.ResOpenList( "ResOpenList L2" );
        Log.LogPrint( "Eintrag 1" );
        Log.LogPrint( "Eintrag 2" );
        Log.LogPrint( "Eintrag 3" );
        Log.ResCloseList();
        Log.ResCloseList();
        
        Log.LogTestcaseEnd();
    }

    @Test
    public void tcResultOpenList_ResultCloseList_LevelTest()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenList( "ResOpenList L1" );
        Log.ResOpenList( "ResOpenList L2" );
        Log.LogPrint( "Eintrag" );
        Log.ResCloseList();
        Log.ResCloseList();
        Log.ResCloseList(); // one close more than open
        
        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenList( "ResOpenList L1" );
        Log.ResOpenList( "ResOpenList L2" );
        Log.LogPrint( "Eintrag" );
        Log.ResCloseList();
        Log.ResCloseList();
        Log.ResCloseList(); // one close more than open
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcResultOpenListDebug_ResultCloseListDebug()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenListDebug( "ResOpenList" );
        Log.LogPrintDebug( "Eintrag 1" );
        Log.LogPrintDebug( "Eintrag 2" );
        Log.LogPrintDebug( "Eintrag 3" );
        Log.ResCloseListDebug();
        
        Log.LogTestcaseEnd();


        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );
        
        Log.ResOpenListDebug( "ResOpenList" );
        Log.LogPrintDebug( "Eintrag 1" );
        Log.LogPrintDebug( "Eintrag 2" );
        Log.LogPrintDebug( "Eintrag 3" );
        Log.ResCloseListDebug();
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogError()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogError" );

        Log.LogError( "Error..." );
        
        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogError" );

        Log.LogError( "Error..." );
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogPass()
    {
        Log.LogTestcaseStart( "tcLogPass" );

        Log.LogPass( "Pass..." );
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogWarning()
    {
        Log.LogTestcaseStart( "tcLogWarning" );

        Log.LogWarning( "Warning..." );
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogException()
    {
        Log.LogTestcaseStart( "tcLogException" );

        Log.LogException( "Exception 1" );
        
        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogPrint()
    {
        Log.LogTestcaseStart( "tcLogPrint" );

        Log.LogPrint( "Print hore something..." );
        
        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogPrintDebug()
    {
        Log.LogTestcaseStart( "tcLogPrintDebug" );

        Log.LogPrintDebug( "Print hore something..." );
        
        Log.LogTestcaseEnd();
    }
    
    
    
    
    
    @Test
    public void tcLogFunctionEnd()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd(  );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd(  );

        Log.LogTestcaseEnd();
    }

    @Test
    public void tcLogFunctionEndDebug()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug(  );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug(  );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Boolean()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Boolean" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( true );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Boolean" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( true );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Booleannull()
    {
        Boolean Return = null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Booleannull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Booleannull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Boolean()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Boolean" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( true );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Boolean" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( true );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Booleannull()
    {
        Boolean Return = null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Booleannull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Booleannull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();
    }
    
    @Test
    public void tcLogFunctionEnd_String()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_String" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( "Return String" );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_String" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( "Return String" );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_Stringnull()
    {
        String ReturnString = null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Stringnull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( ReturnString );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_Stringnull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( ReturnString );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_String()
    {
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_String" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( "Return String" );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_String" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( "Return String" );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_Stringnull()
    {
        String ReturnString = null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Stringnull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( ReturnString );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_Stringnull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( ReturnString );

        Log.LogTestcaseEnd();
    }

    @Test
    public void tcLogFunctionEnd_ListString()
    {
        ArrayList<String> Return = new ArrayList<String>();
        Return.add( "String Value 1" );
        Return.add( "String Value 2" );
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_ListString" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_ListString" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEnd_ListStringnull()
    {
        ArrayList<String> Return = null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEnd_ListStringnull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEnd_ListStringnull" );

        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd( Return );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_ListString()
    {
        ArrayList<String> Return = new ArrayList<String>();
        Return.add( "String Value 1" );
        Return.add( "String Value 2" );
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_ListString" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_ListString" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();
    }
    
    
    @Test
    public void tcLogFunctionEndDebug_ListStringnull()
    {
        ArrayList<String> Return =  null;
        
        Log.setDebugMode( false );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_ListStringnull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();

        
        Log.setDebugMode( true );
        Log.LogTestcaseStart( "tcLogFunctionEndDebug_ListStringnull" );

        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug( Return );

        Log.LogTestcaseEnd();
    }
    

    @Test
    public void tcLogFunctionStart_NoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogFunctionStart_NoParam" );
        
        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd();
        
        Log.LogTestcaseEnd();
  

        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogFunctionStart_NoParam" );
        
        Log.LogFunctionStart( "LogFunctionStart" );
        Log.LogFunctionEnd();
        
        Log.LogTestcaseEnd();

    }
    
    @Test
    public void tcLogFunctionStartDebug_NoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogFunctionStartDebug_NoParam" );
        
        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug();
        
        Log.LogTestcaseEnd();
        
        
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogFunctionStartDebug_NoParam" );
        
        Log.LogFunctionStartDebug( "LogFunctionStartDebug" );
        Log.LogFunctionEndDebug();
        
        Log.LogTestcaseEnd(); 
    }


    @Test
    public void tcLogFunctionStart_TwoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogFunctionStart_TwoParam" );
        
        Log.LogFunctionStart( "LogFunctionStart", "Param A1", "Param A2" );
        Log.LogFunctionEnd();
        
        Log.LogTestcaseEnd();
  

        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogFunctionStart_TwoParam" );
        
        Log.LogFunctionStart( "LogFunctionStart", "Param A1", "Param A2" );
        Log.LogFunctionEnd();
        
        Log.LogTestcaseEnd();

    }
    
    @Test
    public void tcLogFunctionStartDebug_TwoParam()
    {
        Log.setDebugMode( false );
        
        Log.LogTestcaseStart( "tcLogFunctionStartDebug_TwoParam" );
        
        Log.LogFunctionStartDebug( "LogFunctionStartDebug", "Param A1", "Param A2" );
        Log.LogFunctionEndDebug();
        
        Log.LogTestcaseEnd();
        
        
        Log.setDebugMode( true );
        
        Log.LogTestcaseStart( "tcLogFunctionStartDebug_TwoParam" );
        
        Log.LogFunctionStartDebug( "LogFunctionStartDebug", "Param A1", "Param A2" );
        Log.LogFunctionEndDebug();
        
        Log.LogTestcaseEnd(); 
    }
}

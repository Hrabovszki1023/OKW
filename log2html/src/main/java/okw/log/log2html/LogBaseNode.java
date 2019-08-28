package okw.log.log2html;

public class LogBaseNode extends LogBase
{
    // Statistics of a Node
    
  protected Integer ErrorCount = 0;
  protected Integer ExceptionCount = 0;    
  protected Integer WarningCount = 0;
  protected Integer PassedCount = 0;
  protected Integer PrintCount = 0;
  
  protected Integer TestcaseCount = 0;
  protected Integer TestcaseFail = 0;
  protected Integer TestcasePass = 0;

  protected Integer FunctionCount = 0;
  protected Integer FunctionFail = 0;
  protected Integer FunctionPass = 0;
  
  protected Integer KeyWordCount = 0;
  protected Integer KeyWordFail = 0;
  protected Integer KeyWordPass = 0;
  
  protected Integer StepCount = 0;
  protected Integer StepFail = 0;
  protected Integer StepPass = 0;
  
  protected Integer SequenceCount = 0;
  protected Integer SequenceFail = 0;
  protected Integer SequencePass = 0;
  
  // RemoteACCall
  protected Integer RemoteACCallCount = 0;
  protected Integer RemoteACCallFail = 0;
  protected Integer RemoteACCallPass = 0;
  
  // LocalACCall
  protected Integer LocalACCallCount = 0;
  protected Integer LocalACCallFail = 0;
  protected Integer LocalACCallPass = 0;

  
    public LogBaseNode( )
    {
    }
    
    
    public LogBaseNode( LogBase Parent )
	{
		setParent(Parent);
		myID = AllCount;
	}    
    
    public void reset()
    {
        AllCount = 0;
        myID = 0;

        // Global Statistics
        ErrorCount     = 0;
        ExceptionCount = 0;
        WarningCount   = 0;
        PassedCount    = 0;
        PrintCount     = 0;
        
        TestcaseCount = 0;
        TestcaseFail = 0;
        TestcasePass = 0;

        FunctionCount = 0;
        FunctionFail = 0;
        FunctionPass = 0;
        
        KeyWordCount = 0;
        KeyWordFail = 0;
        KeyWordPass = 0;
        
        SequenceCount = 0;
        SequenceFail = 0;
        SequencePass = 0;

        // LocalACCall
        StepCount = 0;
        StepFail = 0;
        StepPass = 0;

        // LocalACCall
        LocalACCallCount = 0;
        LocalACCallFail = 0;
        LocalACCallPass = 0;
        
        // RemoteACCall
        RemoteACCallCount = 0;
        RemoteACCallFail = 0;
        RemoteACCallPass = 0;
        
        PrintCount = 0;
    }

    
    // Node Statistics
    protected void ErrorCount()
    {
        ErrorCount++;
        bError = true;

        if ( myParent != null )
        {
            myParent.ErrorCount();
        }
    }
  
    protected void ExceptionCount()
    {
        ExceptionCount++;
        this.bException = true;

        if ( myParent != null )
        {
            myParent.ExceptionCount();
        }
    }
  
    protected void WarningCount()
    {
        WarningCount++;
        this.bWarning = true;

        if ( myParent != null )
        {
            myParent.WarningCount();
        }
    }

    protected void PassedCount()
    {
        PassedCount++;

        if ( myParent != null )
        {
            myParent.PassedCount();
        }
    }

    protected void PrintCount()
    {
        PrintCount++;

        if ( myParent != null )
        {
            myParent.PrintCount();
        }
    }
    
    @Override
    protected void TestcaseCount()
    {
        this.TestcaseCount++;
        myParent.TestcaseCount();
    }

    @Override
    protected void TestcaseFail()
    {
        this.TestcaseFail++;
        myParent.TestcaseFail();
    }
    
    @Override
    protected void TestcasePass()
    {
        this.TestcasePass++;
        myParent.TestcasePass();
    }

    @Override
    protected void FunctionCount()
    {
        this.FunctionCount++;
        myParent.FunctionCount();
    }

    @Override
    protected void FunctionFail()
    {
        this.FunctionFail++;
        myParent.FunctionFail();
    }

    @Override
    protected void FunctionPass()
    {
        this.FunctionPass++;
        myParent.FunctionPass();        
    }
    
    @Override
    protected void KeyWordCount()
    {
        this.KeyWordCount++;
        myParent.KeyWordCount();
    }

    @Override
    protected void KeyWordFail()
    {
        this.KeyWordFail++;
        myParent.KeyWordFail();        
    }

    @Override
    protected void KeyWordPass()
    {
        this.KeyWordPass++;
        myParent.KeyWordPass();
    }
    
    @Override
    protected void SequenceCount()
    {
        this.SequenceCount++;
        myParent.SequenceCount();
    }

    @Override
    protected void SequenceFail()
    {
        this.SequenceFail++;
        myParent.SequenceFail();
    }

    @Override
    protected void SequencePass()
    {
        this.SequencePass++;
        myParent.SequencePass();
    }
    
    @Override
    protected void StepCount()
    {
        this.StepCount++;
        myParent.StepCount();
    }
    
    @Override
    protected void StepFail()
    {
        this.StepFail++;
        myParent.StepFail();
    }
    
    @Override
    protected void StepPass()
    {
        this.StepPass++;
        myParent.StepPass();
    }
    
    @Override
    protected void LocalACCallCount()
    {
        this.LocalACCallCount++;
        myParent.LocalACCallCount();
    }
    
    @Override
    protected void LocalACCallFail()
    {
        this.LocalACCallFail++;
        myParent.LocalACCallFail();
    }
    
    @Override
    protected void LocalACCallPass()
    {
        this.LocalACCallPass++;
        myParent.LocalACCallPass();
    }
    
    @Override
    protected void RemoteACCallCount()
    {
        this.RemoteACCallCount++;
        myParent.RemoteACCallCount();
    }
    
    @Override
    protected void RemoteACCallFail()
    {
        this.RemoteACCallFail++;
        myParent.RemoteACCallFail();        
    }
    
    @Override
    protected void RemoteACCallPass()
    {
        this.RemoteACCallPass++;
        myParent.RemoteACCallPass();
    }


    protected String getJSONStatistics()
    {
        StringBuilder myJSON = new StringBuilder();
        
        // local Statistics
        myJSON.append( this.jsonElementComma( "ErrorCount", this.ErrorCount ) );
        myJSON.append( this.jsonElementComma( "ExceptionCount", this.ExceptionCount ) );
        myJSON.append( this.jsonElementComma( "WarningCount", this.WarningCount ) );
        myJSON.append( this.jsonElementComma( "PassedCount", this.PassedCount ) );
        myJSON.append( this.jsonElementComma( "PrintCount", this.PrintCount ) );
        
        myJSON.append( this.jsonElementComma( "FunctionCount", this.FunctionCount ) );
        myJSON.append( this.jsonElementComma( "FunctionFail", this.FunctionFail ) );
        myJSON.append( this.jsonElementComma( "FunctionPass", this.FunctionPass ) );
        
        myJSON.append( this.jsonElementComma( "SequenceCount", this.SequenceCount ) );
        myJSON.append( this.jsonElementComma( "SequenceFail", this.SequenceFail ) );
        myJSON.append( this.jsonElementComma( "SequencePass", this.SequencePass ) );

        myJSON.append( this.jsonElementComma( "LocalACCallCount", this.LocalACCallCount ) );
        myJSON.append( this.jsonElementComma( "LocalACCallFail", this.LocalACCallFail ) );
        myJSON.append( this.jsonElementComma( "LocalACCallPass", this.LocalACCallPass ) );
        
        myJSON.append( this.jsonElementComma( "RemoteACCallCount", this.RemoteACCallCount ) );
        myJSON.append( this.jsonElementComma( "RemoteACCallFail", this.RemoteACCallFail ) );
        myJSON.append( this.jsonElementComma( "RemoteACCallPass", this.RemoteACCallPass ) );        
        
        myJSON.append( this.jsonElementComma( "StepCount", this.StepCount ) );
        myJSON.append( this.jsonElementComma( "StepFail", this.StepFail ) );
        myJSON.append( this.jsonElementComma( "StepPass", this.StepPass ) );

        myJSON.append( this.jsonElementComma( "KeyWordCount", this.KeyWordCount ) );
        myJSON.append( this.jsonElementComma( "KeyWordFail", this.KeyWordFail ) );
        myJSON.append( this.jsonElementComma( "KeyWordPass", this.KeyWordPass ) );
        
        // Timer:
        // Für den Test wird das Abgeschaltet, weil veränderlich 
        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
        {
            myJSON.append( this.jsonElementComma( "startedAt", this.myDuration.getStartTimeMillis().toString() ) );
            myJSON.append( this.jsonElementComma( "finishedAt", this.myDuration.getEndTimeMillis().toString() ) );
            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
        }
        else
        {
            myJSON.append( this.jsonElementComma( "startedAt", "Start time TestMode" ) );
            myJSON.append( this.jsonElementComma( "finishedAt", "End time TestMode" ) );
            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
        }
        
        return myJSON.toString();
    }   
    
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append(this.jsonElementComma( "info", this.Info ));
        
        return myJSON.toString();
    }
    
    protected String getJSONResult()
    {
    
        StringBuilder myJSON = new StringBuilder();
        StringBuilder myJSONForLoop = new StringBuilder();
        
        myJSON.append( this.getJSONNodeProperties() );

        // Statistics...
        myJSON.append( this.jsonStructure( "statistics", this.getJSONStatistics() ) );

        Boolean GreaterOne = false;
        
        for( LogBase myLog: this.myLogs )
        {
            if (GreaterOne) myJSONForLoop.append( ", " ); 
            else GreaterOne = true;
            myJSONForLoop.append( this.jsonArrayElement(  myLog.getJSONResult() ) ) ;
            
        }
        
        if (GreaterOne)  myJSON.append( ", " + this.jsonArray( "elements", myJSONForLoop.toString() ) );

        return myJSON.toString();
    }
}

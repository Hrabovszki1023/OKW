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
  
  protected Integer SequensCount = 0;
  protected Integer SequensFail = 0;
  protected Integer SequensPass = 0;
  
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


    
    protected Boolean bWarning = false;
    
    protected void setWarning()
    {
        if (!bWarning)
        {
            bWarning = true;
        
        
            if (myParent != null)
            {
                myParent.setWarning();
            }
        }
    }

    protected Boolean getWarning()
    {
        return bWarning;
    }
    
    
    protected Boolean bException = false;

    protected void setException()
    {
        if (!bException)
        {
            //SetFail();
            bException = true;
        
            if (myParent != null)
            {
                myParent.setException();
            }
        }
    }


    protected Boolean getException()
    {
        return bException;
    }


    protected Boolean bError = false;
    
    protected void setError()
    {
        if (!bError)
        {           
            // SetFail();
            bError = true;

            if (myParent != null)
            {
                myParent.setError();
            }
        }
    }

    protected Boolean getError()
    {
        return bError;
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
        
        SequensCount = 0;
        SequensFail = 0;
        SequensPass = 0;

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
    protected void SequensCount()
    {
        this.SequensCount++;
        myParent.SequensCount();
    }

    @Override
    protected void SequensFail()
    {
        this.SequensFail++;
        myParent.SequensFail();
    }

    @Override
    protected void SequensPass()
    {
        this.SequensPass++;
        myParent.SequensPass();
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
        myJSON.append( this.jsonElement( "ErrorCount", this.ErrorCount ) );
        myJSON.append( this.jsonElement( "ExceptionCount", this.ExceptionCount ) );
        myJSON.append( this.jsonElement( "WarningCount", this.WarningCount ) );
        myJSON.append( this.jsonElement( "PassedCount", this.PassedCount ) );
        myJSON.append( this.jsonElement( "PrintCount", this.PrintCount ) );
        
        myJSON.append( this.jsonElement( "FunctionCount", this.FunctionCount ) );
        myJSON.append( this.jsonElement( "FunctionFail", this.FunctionFail ) );
        myJSON.append( this.jsonElement( "FunctionPass", this.FunctionPass ) );
        
        myJSON.append( this.jsonElement( "SequensCount", this.SequensCount ) );
        myJSON.append( this.jsonElement( "SequensFail", this.SequensFail ) );
        myJSON.append( this.jsonElement( "SequensPass", this.SequensPass ) );

        myJSON.append( this.jsonElement( "LocalACCallCount", this.LocalACCallCount ) );
        myJSON.append( this.jsonElement( "LocalACCallFail", this.LocalACCallFail ) );
        myJSON.append( this.jsonElement( "LocalACCallPass", this.LocalACCallPass ) );
        
        myJSON.append( this.jsonElement( "RemoteACCallCount", this.RemoteACCallCount ) );
        myJSON.append( this.jsonElement( "RemoteACCallFail", this.RemoteACCallFail ) );
        myJSON.append( this.jsonElement( "RemoteACCallPass", this.RemoteACCallPass ) );        
        
        myJSON.append( this.jsonElement( "StepCount", this.StepCount ) );
        myJSON.append( this.jsonElement( "StepFail", this.StepFail ) );
        myJSON.append( this.jsonElement( "StepPass", this.StepPass ) );

        myJSON.append( this.jsonElement( "KeyWordCount", this.KeyWordCount ) );
        myJSON.append( this.jsonElement( "KeyWordFail", this.KeyWordFail ) );
        myJSON.append( this.jsonElement( "KeyWordPass", this.KeyWordPass ) );
        
        return myJSON.toString();
    }
    
    
    protected String getJSONResult()
    {
    
        StringBuilder myJSON = new StringBuilder();

        // Statistics...
        myJSON.append( this.jsonStructre( "statistics", this.getJSONStatistics() ) );
        
        // Timer:
        // Für den Test wird das Abgeschaltet, weil veränderlich 
        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
        {
            myJSON.append( this.jsonElement( "startedAt", this.myDuration.getStartTimeMillis().toString() ) );
            myJSON.append( this.jsonElement( "finishedAt", this.myDuration.getEndTimeMillis().toString() ) );
            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
        }
        else
        {
            myJSON.append( this.jsonElement( "startedAt", "Start time TestMode" ) );
            myJSON.append( this.jsonElement( "finishedAt", "End time TestMode" ) );
            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
        }
        
        Integer EC = 0;
        
        for( LogBase myLog: this.myLogs )
        {
            EC++;
            String Element = myLog.getClass().getSimpleName();
            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.getJSONResult() ) );
        }
        
        return myJSON.toString();
    }
}

package okw.log.log2html;

public class LogBaseLeaf extends LogBase
{
    // Statistics of a Node
    
  protected Integer ErrorCount = 0;
  protected Integer ExceptionCount = 0;    
  protected Integer WarningCount = 0;
  protected Integer PassedCount = 0;
  protected Integer PrintCount = 0;
  
    public LogBaseLeaf( )
    {
    }
    
    
    public LogBaseLeaf( LogBase Parent )
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
    }

    
    // Node Statistics
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        bError = true;

        if ( myParent != null )
        {
            myParent.ErrorCount();
        }
    }
  
    @Override
    protected void ExceptionCount()
    {
        ExceptionCount++;
        this.bException = true;

        if ( myParent != null )
        {
            myParent.ExceptionCount();
        }
    }
  
    @Override
    protected void WarningCount()
    {
        WarningCount++;
        this.bWarning = true;

        if ( myParent != null )
        {
            myParent.WarningCount();
        }
    }

    @Override
    protected void PassedCount()
    {
        PassedCount++;

        if ( myParent != null )
        {
            myParent.PassedCount();
        }
    }

    @Override
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
    }

    @Override
    protected void TestcaseFail()
    {
    }
    
    @Override
    protected void TestcasePass()
    {
    }

    @Override
    protected void FunctionCount()
    {
    }

    @Override
    protected void FunctionFail()
    {
    }

    @Override
    protected void FunctionPass()
    {
    }
    
    @Override
    protected void KeyWordCount()
    {
    }

    @Override
    protected void KeyWordFail()
    {
    }

    @Override
    protected void KeyWordPass()
    {
    }
    
    @Override
    protected void SequenceCount()
    {
    }

    @Override
    protected void SequenceFail()
    {
    }

    @Override
    protected void SequencePass()
    {
    }
    

    @Override
    protected void StepCount()
    {
    }
    
    @Override
    protected void StepFail()
    {
    }
    
    @Override
    protected void StepPass()
    {
    }
    
    // LocalACCall
    @Override
    protected void LocalACCallCount()
    {
    }
    
    @Override
    protected void LocalACCallFail()
    {
    }
    
    @Override
    protected void LocalACCallPass()
    {
    }
    
    // RemoteACCall
    @Override
    protected void RemoteACCallCount()
    {
    }
    
    @Override
    protected void RemoteACCallFail()
    {
    }
    
    @Override
    protected void RemoteACCallPass()
    {
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
        
        return myJSON.toString();
    }
    
    
    protected String getJSONResult()
    {
    
        StringBuilder myJSON = new StringBuilder();

        // Statistics...
        myJSON.append( this.jsonArray( "statistics", this.getJSONStatistics() ) );
        
        // Timer:
        // Für den Test wird das Abgeschaltet, weil veränderlich 
        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
        {
            myJSON.append( this.jsonElement( "Start time", this.myDuration.getStartTime() ) );
            myJSON.append( this.jsonElement( "End time", this.myDuration.getEndTime() ) );
            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
        }
        else
        {
            myJSON.append( this.jsonElement( "Start time", "Start time TestMode" ) );
            myJSON.append( this.jsonElement( "End time", "End time TestMode" ) );
            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
        }

        
        Integer EC = 0;
        
        for( LogBase myLog: this.myLogs )
        {
            EC++;
            String Element = myLog.getClass().getSimpleName();
            myJSON.append( this.jsonArrayElement( myLog.getJSONResult() ) );
        }
        
        return myJSON.toString();
    }
}

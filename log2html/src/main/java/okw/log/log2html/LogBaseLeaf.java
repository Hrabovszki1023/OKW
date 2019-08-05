package okw.log.log2html;

public class LogBaseLeaf extends LogBase
{
    // Statistics of a Node
    
  protected Integer ErrorCount = 0;
  protected Integer ExceptionCount = 0;    
  protected Integer WarningCount = 0;
  protected Integer PassedCount = 0;
  protected Integer PrintCount = 0;
  
//    protected Integer TestcaseCount           = 0;
//    protected Integer TestcaseFail            = 0;
//    protected Integer TestcasePass            = 0;
//
//    protected Integer FunctionCount           = 0;
//    protected Integer FunctionFail            = 0;
//    protected Integer FunctionPass            = 0;
//
//    protected Integer KeyWordCount            = 0;
//    protected Integer KeyWordFail             = 0;
//    protected Integer KeyWordPass             = 0;
//
//    protected Integer StepCount               = 0;
//    protected Integer StepFail                = 0;
//    protected Integer StepPass                = 0;
//
//    protected Integer SequensCount            = 0;
//    protected Integer SequensFail             = 0;
//    protected Integer SequensPass             = 0;
//
//    // Sub
//    protected Integer SubCount                = 0;
//    protected Integer SubFail                 = 0;
//    protected Integer SubPass                 = 0;
//
//    // Precondition
//    protected Integer PreconditionCount       = 0;
//    protected Integer PreconditionFail        = 0;
//    protected Integer PreconditionPass        = 0;
//
//    // Postcondition
//    protected Integer PostconditionCount      = 0;
//    protected Integer PostconditionFail       = 0;
//    protected Integer PostconditionPass       = 0;
//
//    // AcceptanceCriteria
//    protected Integer AcceptanceCriteriaCount = 0;
//    protected Integer AcceptanceCriteriaFail  = 0;
//    protected Integer AcceptanceCriteriaPass  = 0;

  
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
        
//        TestcaseCount = 0;
//        TestcaseFail = 0;
//        TestcasePass = 0;
//
//        FunctionCount = 0;
//        FunctionFail = 0;
//        FunctionPass = 0;
//        
//        KeyWordCount = 0;
//        KeyWordFail = 0;
//        KeyWordPass = 0;
//        
//        SequensCount = 0;
//        SequensFail = 0;
//        SequensPass = 0;
//
//        // Postcondition
//        PostconditionCount = 0;
//        PostconditionFail = 0;
//        PostconditionPass = 0;
        
        PrintCount = 0;
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
    protected void SequensCount()
    {
    }

    @Override
    protected void SequensFail()
    {
    }

    @Override
    protected void SequensPass()
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
        
//        myJSON.append( this.jsonElement( "FunctionCount", this.FunctionCount ) );
//        myJSON.append( this.jsonElement( "FunctionFail", this.FunctionFail ) );
//        myJSON.append( this.jsonElement( "FunctionPass", this.FunctionPass ) );
//        
//        myJSON.append( this.jsonElement( "SequensCount", this.SequensCount ) );
//        myJSON.append( this.jsonElement( "SequensFail", this.SequensFail ) );
//        myJSON.append( this.jsonElement( "SequensPass", this.SequensPass ) );
//        
//        myJSON.append( this.jsonElement( "PreconditionCount", this.PreconditionCount ) );
//        myJSON.append( this.jsonElement( "PreconditionFail", this.PreconditionFail ) );
//        myJSON.append( this.jsonElement( "PreconditionPass", this.PreconditionPass ) );        
//
//        myJSON.append( this.jsonElement( "AcceptanceCriteriaCount", this.AcceptanceCriteriaCount ) );
//        myJSON.append( this.jsonElement( "AcceptanceCriteriaFail", this.AcceptanceCriteriaFail ) );
//        myJSON.append( this.jsonElement( "AcceptanceCriteriaPass", this.AcceptanceCriteriaPass ) );
//        
//        myJSON.append( this.jsonElement( "PostconditionCount", this.PostconditionCount ) );
//        myJSON.append( this.jsonElement( "PostconditionFail", this.PostconditionFail ) );
//        myJSON.append( this.jsonElement( "PostconditionPass", this.PostconditionPass ) );        
//        
//        myJSON.append( this.jsonElement( "SubCount", this.SubCount ) );
//        myJSON.append( this.jsonElement( "SubFail", this.SubFail ) );
//        myJSON.append( this.jsonElement( "SubPass", this.SubPass ) );
//        
//        myJSON.append( this.jsonElement( "StepCount", this.StepCount ) );
//        myJSON.append( this.jsonElement( "StepFail", this.StepFail ) );
//        myJSON.append( this.jsonElement( "StepPass", this.StepPass ) );
//
//        myJSON.append( this.jsonElement( "KeyWordCount", this.KeyWordCount ) );
//        myJSON.append( this.jsonElement( "KeyWordFail", this.KeyWordFail ) );
//        myJSON.append( this.jsonElement( "KeyWordPass", this.KeyWordPass ) );
        
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
            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.getJSONResult() ) );
        }
        
        return myJSON.toString();
    }
}

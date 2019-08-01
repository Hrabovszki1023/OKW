package okw.log.log2html;

public class LogBase4Gherkin extends LogBase
{
	
    public LogBase4Gherkin( )
    {
    }
    
    public LogBase4Gherkin(LogBase Parent, String fpGherkin)
	{
		setParent(Parent);
		myID = AllCount;
		
		this.Gherkin = fpGherkin;
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
        
        myJSON.append( this.jsonElement( "PreconditionCount", this.PreconditionCount ) );
        myJSON.append( this.jsonElement( "PreconditionFail", this.PreconditionFail ) );
        myJSON.append( this.jsonElement( "PreconditionPass", this.PreconditionPass ) );        

        myJSON.append( this.jsonElement( "AcceptanceCriteriaCount", this.AcceptanceCriteriaCount ) );
        myJSON.append( this.jsonElement( "AcceptanceCriteriaFail", this.AcceptanceCriteriaFail ) );
        myJSON.append( this.jsonElement( "AcceptanceCriteriaPass", this.AcceptanceCriteriaPass ) );
        
        myJSON.append( this.jsonElement( "PostconditionCount", this.PostconditionCount ) );
        myJSON.append( this.jsonElement( "PostconditionFail", this.PostconditionFail ) );
        myJSON.append( this.jsonElement( "PostconditionPass", this.PostconditionPass ) );        
        
        myJSON.append( this.jsonElement( "SubCount", this.SubCount ) );
        myJSON.append( this.jsonElement( "SubFail", this.SubFail ) );
        myJSON.append( this.jsonElement( "SubPass", this.SubPass ) );
        
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

        // Gherkin
        myJSON.append( this.jsonElement( "gherkin", this.Gherkin ) );
        
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

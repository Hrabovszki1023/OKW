package okw.log.log2html;

public class LogStep extends LogBaseNode
{

    private String categoryName = "";
    private String choiceValue = "";
    private String featureName = "";
    private String localCategoryName = "";
    private String sourceExcerpt = "";
    
    // Result is setted by Log2Html internaly!
    private String result = "";
    
	
    LogStep(LogBase Parent, String categoryName, String choiceValue, String featureName, String localCategoryName, String sourceExcerpt )
	{
        setParent(Parent);
        myID = AllCount;
                
        this.categoryName = categoryName;
        this.choiceValue = choiceValue;
        this.featureName = featureName;
        this.localCategoryName = localCategoryName;
        this.sourceExcerpt = sourceExcerpt;
        
        // inkrementieren StepCount
        this.StepCount();
	}
	
    
	  @Override
	  protected void ErrorCount()
	  {
	      ErrorCount++;
	      
	      this.StepFail();

	      this.bError = true;
	      
	      if ( myParent != null)
	      {
	          myParent.ErrorCount();
	      }
	  }
	  
	  
	  @Override
	  protected void ExceptionCount()
	  {
	      ExceptionCount++;

	      this.StepFail();
	      
	      this.bException = true;
	      
	      if ( myParent != null)
	      {
	          myParent.ExceptionCount();
	      }
	  }
	  
	  protected void StepFail()
	  {
	      if ( ! (this.bError || this.bException ) )
	         myParent.StepFail();
	  }
	  
	    
	    @Override
	    protected String getJSONResult()
	    {
	    
	        StringBuilder myJSON = new StringBuilder();

	        // Statistics...
	        myJSON.append( this.jsonStructre( "statistics", this.getJSONStatistics() ) );
	        
            myJSON.append( this.jsonElement( "categoryName", this.categoryName ) );
            myJSON.append( this.jsonElement( "choiceValue", this.choiceValue ) );
            myJSON.append( this.jsonElement( "featureName", this.featureName ) );
            myJSON.append( this.jsonElement( "localCategoryName", this.localCategoryName ) );
            myJSON.append( this.jsonElement( "sourceExcerpt", this.sourceExcerpt ) );
            myJSON.append( this.jsonElement( "result", this.result ) );
                        
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

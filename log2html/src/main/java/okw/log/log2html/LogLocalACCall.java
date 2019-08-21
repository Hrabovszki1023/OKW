package okw.log.log2html;

public class LogLocalACCall extends LogBaseNode
{
    private String sourceExcerpt = "";
    private String type = "";
	
    LogLocalACCall(LogBase Parent, String sourceExcerpt, String type)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.sourceExcerpt = sourceExcerpt;
        this.type = type;
        
        // inkrementieren AcceptanceCriteriaCount
        this.LocalACCallCount();
	}
	
	   
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.LocalACCallFail();

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

        this.LocalACCallFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    @Override
    protected void LocalACCallFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.LocalACCallFail();
    }

    
    @Override
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElementComma( "sourceExcerpt", this.sourceExcerpt ) );
        myJSON.append( this.jsonElementComma( "type", this.type ) );
  
        return myJSON.toString();
    }
}

package okw.log.log2html;

public class LogLocalACCall extends LogBaseNode
{
    private String sourceExcerpt = "";
    private String Type = "";
	
    LogLocalACCall(LogBase Parent, String sourceExcerpt, String Type)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.sourceExcerpt = sourceExcerpt;
        this.Type = Type;
        
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
}

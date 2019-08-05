package okw.log.log2html;

public class LogRemoteACCall extends LogBaseNode
{
    private String sourceExcerpt = "";
    private String Type = "";
	
    LogRemoteACCall(LogBase Parent, String sourceExcerpt, String Type)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.sourceExcerpt = sourceExcerpt;
        this.Type = Type;
        
        // inkrementieren AcceptanceCriteriaCount
        this.RemoteACCallCount();
	}
	
	   
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.RemoteACCallFail();

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

        this.RemoteACCallFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    @Override
    protected void RemoteACCallFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.RemoteACCallFail();
    }
}

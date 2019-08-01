package okw.log.log2html;

public class LogPrecondition  extends LogBase4Gherkin
{
	
	LogPrecondition(LogBase Parent, String Gherkin)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.Gherkin = Gherkin;
        
        // inkrementieren PostconditionCount
        this.PreconditionCount();
	}
	
	   
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.PreconditionFail();

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

        this.PreconditionFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    protected void PreconditionFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.PreconditionFail();
    }
}

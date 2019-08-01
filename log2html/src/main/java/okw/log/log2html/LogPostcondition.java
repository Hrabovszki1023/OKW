package okw.log.log2html;

public class LogPostcondition extends LogBase4Gherkin
{
	
	LogPostcondition(LogBase Parent, String Gherkin)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.Gherkin = Gherkin;
        
        // inkrementieren PostconditionCount
        this.PostconditionCount();
	}
	
    
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.PostconditionFail();

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

        this.PostconditionFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    protected void PostconditionFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.PostconditionFail();
    }
}

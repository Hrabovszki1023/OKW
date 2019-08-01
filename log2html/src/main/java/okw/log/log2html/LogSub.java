package okw.log.log2html;

public class LogSub  extends LogBase4Gherkin
{
	
	LogSub(LogBase Parent, String Gherkin )
	{
        setParent(Parent);
        myID = AllCount;
                
        this.Gherkin = Gherkin;
        
        // inkrementieren Sub
        this.SubCount();
	}
	   
    
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.SubFail();

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

        this.SubFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    protected void SubFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.SubFail();
    }
}

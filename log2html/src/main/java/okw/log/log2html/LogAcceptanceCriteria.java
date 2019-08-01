package okw.log.log2html;

public class LogAcceptanceCriteria  extends LogBase4Gherkin
{
	
	LogAcceptanceCriteria(LogBase Parent, String Gherkin)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.Gherkin = Gherkin;
        
        // inkrementieren AcceptanceCriteriaCount
        this.AcceptanceCriteriaCount();
	}
	
	   
    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.AcceptanceCriteriaFail();

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

        this.AcceptanceCriteriaFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    protected void AcceptanceCriteriaFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.AcceptanceCriteriaFail();
    }
}

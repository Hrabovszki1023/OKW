package okw.log.log2html;

public class LogStep extends LogBase4Gherkin
{
	
	LogStep(LogBase Parent, String Gherkin)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.Gherkin = Gherkin;
        
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
}

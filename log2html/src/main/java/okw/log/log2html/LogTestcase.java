package okw.log.log2html;

public class LogTestcase extends LogBaseNode
{

	protected LogTestcase( LogBase Parent, String fpsTestcaseName )
	{
		setParent(Parent);
		myID = AllCount;
				
		this.Info = fpsTestcaseName;
		
		// inkrementieren TestcaseCount
		this.TestcaseCount();
	}
	
	
  @Override
  protected void ErrorCount()
  {
      ErrorCount++;
      
      this.TestcaseFail();

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

      this.TestcaseFail();
      
      this.bException = true;
      
      if ( myParent != null)
      {
          myParent.ExceptionCount();
      }
  }
  
  protected void TestcaseFail()
  {
      if ( ! (this.bError || this.bException ) )
         myParent.TestcaseFail();
  }
}

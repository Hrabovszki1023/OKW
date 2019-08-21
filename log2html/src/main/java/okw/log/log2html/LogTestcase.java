package okw.log.log2html;

public class LogTestcase extends LogBaseNode
{

    private String name = "";
    private String type = "TestCase";
    
	protected LogTestcase( LogBase Parent, String fpsTestcaseName )
	{
		setParent(Parent);
		myID = AllCount;
				
		this.name = fpsTestcaseName;
		
		
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
  
  @Override
  protected void TestcaseFail()
  {
      if ( ! (this.bError || this.bException ) )
         myParent.TestcaseFail();
  }
  
  
  @Override
  protected String getJSONNodeProperties()
  {
      StringBuilder myJSON = new StringBuilder();
      
      myJSON.append(this.jsonElementComma( "name", this.name ));
      myJSON.append(this.jsonElementComma( "type", this.type ));
      
      return myJSON.toString();
  }
}

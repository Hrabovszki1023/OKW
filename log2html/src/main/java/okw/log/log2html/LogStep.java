package okw.log.log2html;

public class LogStep extends LogBaseNode
{

    
    // "categoryName": "URL",
    private String categoryName = "";
    
    // "categoryType": "I",
    private String categoryType = "";

    // "choiceValue": "\"https://cloud.4test.io/pizza/\"",
    private String choiceValue = "";

    // "featureName": "Main menu",
    private String featureName = "";
    
    // "localCategoryName": "URL",
    private String localCategoryName = "";

    // "sourceExcerpt": "WHEN URL IS \"https://cloud.4test.io/pizza/\"",
    private String sourceExcerpt = "";
    
    // "type": "TestStep"
    private String type = "";
    
    // Result is setted by Log2Html internaly!
    //  "result": "ok",
    private String result = "";
    
	
    LogStep(LogBase Parent, String categoryName, String categoryType, 
                            String choiceValue, String featureName,
                            String localCategoryName, String sourceExcerpt,
                            String type)
	{
        setParent(Parent);
        myID = AllCount;
                
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.choiceValue = choiceValue;
        this.featureName = featureName;
        this.localCategoryName = localCategoryName;
        this.sourceExcerpt = sourceExcerpt;
        this.type = type;
        
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

	  
	  @Override
	  protected String getJSONNodeProperties()
	  {
	      StringBuilder myJSON = new StringBuilder();
	      
	      myJSON.append( this.jsonElementComma( "type", this.type ) );
	      myJSON.append( this.jsonElementComma( "categoryName", this.categoryName ) );
	      myJSON.append( this.jsonElementComma( "categoryType", this.categoryType ) );
	      myJSON.append( this.jsonElementComma( "choiceValue", this.choiceValue ) );
	      myJSON.append( this.jsonElementComma( "featureName", this.featureName ) );
	      myJSON.append( this.jsonElementComma( "localCategoryName", this.localCategoryName ) );
	      myJSON.append( this.jsonElementComma( "sourceExcerpt", this.sourceExcerpt ) );
	      myJSON.append( this.jsonElementComma( "result", this.result ) );
	      
	      return myJSON.toString();
	  }	    
}

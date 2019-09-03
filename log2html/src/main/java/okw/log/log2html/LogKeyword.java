package okw.log.log2html;

public class LogKeyword extends LogBaseNode
{
    private String type = "Keyword";
    private String Keyword;
    private String[] Parameter;

	LogKeyword( LogBase Parent, String fpsKeyword, String... fpsParameter )
	{
		setParent( Parent );
		myID = AllCount;
		
		Keyword = fpsKeyword;
		Parameter = fpsParameter;
		
	      // inkrementieren KeyWordCount
        this.KeyWordCount();

		StringBuilder StrBuilder = new StringBuilder();

		StrBuilder.append( fpsKeyword + ": " );

		if ( fpsParameter.length == 2 )
		{
			StrBuilder.append( "'" + fpsParameter[0] + "' = '" + fpsParameter[1] + "'" );
		}
		else
		{
			for ( String sParameter : fpsParameter )
			{
				StrBuilder.append( " '" + sParameter + "'" );
			}
		}

		this.Info = StrBuilder.toString();
	}

    @Override
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElementComma( "type", this.type ) );
        myJSON.append( this.jsonElementComma( "info", this.Info ) );
        myJSON.append( this.jsonElementComma( "Keyword", this.Keyword ) );

        for ( Integer i = 0; i < Parameter.length; i++) { 
            
            myJSON.append( this.jsonElementComma( "Parameter" + i.toString(), Parameter[i] ) );
        } 
        return myJSON.toString();
    }
	
    
  @Override
  protected void ErrorCount()
  {
      ErrorCount++;

      this.KeyWordFail();
      
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

      this.KeyWordFail();
      
      this.bException = true;
      
      if ( myParent != null)
      {
          myParent.ExceptionCount();
      }
  }
}

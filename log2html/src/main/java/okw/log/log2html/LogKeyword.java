package okw.log.log2html;

public class LogKeyword extends LogBase4Gherkin
{
    
    private String Keyword;
    private String[] Parameter;

	LogKeyword( LogBase Parent, String fpsKeyword, String... fpsParameter )
	{
	    super( Parent, "");
	    
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
			StrBuilder.append( "\"" + fpsParameter[0] + "\" = \"" + fpsParameter[1] + "\"" );
		}
		else
		{
			for ( String sParameter : fpsParameter )
			{
				StrBuilder.append( " \"" + sParameter + "\"" );
			}
		}

		this.Info = StrBuilder.toString();

	}

    protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElement( "Keyword", this.Keyword ) );

        for ( Integer i = 0; i < Parameter.length; i++) { 
            
            myJSON.append( this.jsonElement( "Parameter" + i.toString(), Parameter[i] ) );
        } 
        
        // Statistics...
        myJSON.append( this.jsonStructre( "statistics", this.getJSONStatistics() ) );
        
        // Duration
        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
        {
            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
        }
        else
        {
            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
        }
        
        Integer EC = 0;
        
        for( LogBase myLog: this.myLogs )
        {
            EC++;
            String Element = myLog.getClass().getSimpleName();
            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.getJSONResult() ) );
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

package okw.log.log2html;


public class LogSourceLocation extends LogBaseLeaf
{
    
    private String Start = "";
    private String End = "";
    private String featureName = "";
    private String sourceType = "";
	
	protected LogSourceLocation( LogBase fpParent, String Start, String End, String featureName, String sourceType )
	{
		myID = AllCount;
		this.setParent(fpParent);
		this.Start = Start;
		this.End = End;
		this.featureName = End;
		this.sourceType = sourceType;
	}

	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPassed'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}

   @Override 
   protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
                    
        myJSON.append( this.jsonElementComma( "Start",  this.Start ) );
        myJSON.append( this.jsonElementComma( "End",  this.End ) );
        myJSON.append( this.jsonElementComma( "featureName",  this.featureName ) );
        myJSON.append( this.jsonElement( "sourceType",  this.sourceType ) );
        
        return myJSON.toString();
    }
}

package okw.log.log2html;


public class LogPass extends LogBaseLeaf
{
	
	protected LogPass( LogBase fpParent, String fpsInfo )
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		PassedCount();	
	}

	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPassed'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}

    
   protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
                    
        myJSON.append( this.jsonElement( "Passed",  this.Info ) );
        
        return myJSON.toString();
    }
}

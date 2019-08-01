package okw.log.log2html;


public class LogPrint extends LogBase
{

	public LogPrint(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);
        PrintCount();
	}
	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPrint'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	
	
   protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
                    
        myJSON.append( this.jsonElement( "Print",  this.Info ) );
        
        return myJSON.toString();
    }
	
    
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}
}

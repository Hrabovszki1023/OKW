package okw.log.log2html;

public class LogError extends LogBase{
	
	protected LogError(LogBase fpParent, String fpsInfo)
	{
	    Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		setError();	
	}

	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogError'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	
	protected void SetFail()
	{
	}

	
	protected void SetPass()
	{
	}
}

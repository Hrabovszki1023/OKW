package okw.log.log2html;

public class LogPrintDebug extends LogBase
{

	public LogPrintDebug(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
	}
	
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPrintDebug'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}
	
	
}

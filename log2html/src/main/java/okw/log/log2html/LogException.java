package okw.log.log2html;

public class LogException extends LogBase
{

	public LogException(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		setException();	
	}
	
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogException'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}

}

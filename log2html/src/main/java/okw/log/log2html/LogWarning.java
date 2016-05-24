package okw.log.log2html;

public class LogWarning extends LogBase
{

	public LogWarning(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		setWarning();		
	}
	
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogWarning'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}

}

package okw.log.log2html;

import org.apache.commons.text.StringEscapeUtils;

public class LogWarning extends LogBaseLeaf
{

	protected LogWarning(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		this.WarningCount();	
	}

	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogWarning'>" + StringEscapeUtils.escapeHtml4(this.Info) + "</p>\n" );
		
		return sbResult.toString();
	}

    
    protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
                    
        myJSON.append( this.jsonElement( "Warning",  this.Info ) );
        
        return myJSON.toString();
    }
    
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}

}

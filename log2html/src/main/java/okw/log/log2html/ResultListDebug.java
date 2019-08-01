package okw.log.log2html;

public class ResultListDebug extends LogBase
{
	
	String myReturn = "";
	
	ResultListDebug( LogBase Parent, String fpsListHeader )
	{
		setParent(Parent);
		myID = AllCount;

		this.Info = fpsListHeader;
	}

	public void setReturn(String fpsReturn)
	{
		myReturn = fpsReturn;
	}
	
	protected void SetFail()
	{
	}

	protected void SetPass()
	{
	}
	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		//sbResult.append( lvsIndention + "<blockquote class='" + this.getClass().getSimpleName() + "'>\n" );
		
		sbResult.append( lvsIndention + "<div class='" + this.getClass().getSimpleName() + "'>\n" );
		sbResult.append( lvsIndention + myIndentionBase  +"<div class='Header'>\n" );
		
		// Aufklappen wenn myLogs Werte enthält...
		if (!this.myLogs.isEmpty())
		{
			sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase + "<div class='FoldMe' href='javascript:/' onClick='div_change(" + myID.toString() + ")'></div>\n" );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_ResultListDebug'>" + this.Info + "</div>\n" );
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Header
		
		// Body der Klappbox
		sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase +"<div class='Body' id='" + myID.toString() +"' style='display: none;'>\n" );
		
		for( LogBase myLog: this.myLogs )
		{
			sbResult.append( myLog.getHTMLResult() );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}
	
	
    protected String getJASONResult()
    {
        StringBuilder sbResult = new StringBuilder();
        
        String lvsIndention = this.getLevelIndention();
        
        //sbResult.append( lvsIndention + "<blockquote class='" + this.getClass().getSimpleName() + "'>\n" );
        
        sbResult.append( lvsIndention + "<div class='" + this.getClass().getSimpleName() + "'>\n" );
        sbResult.append( lvsIndention + myIndentionBase  +"<div class='Header'>\n" );
        
        // Aufklappen wenn myLogs Werte enthält...
        if (!this.myLogs.isEmpty())
        {
            sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase + "<div class='FoldMe' href='javascript:/' onClick='div_change(" + myID.toString() + ")'></div>\n" );
        }
        
        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_ResultListDebug'>" + this.Info + "</div>\n" );
        
        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Header
        
        // Body der Klappbox
        sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase +"<div class='Body' id='" + myID.toString() +"' style='display: none;'>\n" );
        
        for( LogBase myLog: this.myLogs )
        {
            sbResult.append( myLog.getHTMLResult() );
        }
        
        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
        
        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen     
        //sbResult.append( lvsIndention + "</blockquote>\n");
        
        return sbResult.toString();
    }
}

package okw.log.log2html;

public class ResultList extends LogBase
{
	
	String myReturn = "";
	
	ResultList(LogBase Parent, String fpsListHeader)
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

	@Override
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
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_ResultList'>" + this.Info + "</div>\n" );
		
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
	

    @Override
    protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
        
        // obj.put( "class", this.getClass().getSimpleName() );
        // obj.put( "Info_ResultList", this.Info );

        myJSON.append( this.jsonElement( "Resultlist", this.Info ) );
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
            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.Info ) );
        }
        
        return myJSON.toString();
    }
}

package okw.log.log2html;

public class LogFunction extends LogBase
{
	
	String myReturn = "";
	
	LogFunction(LogBase Parent, String fpsFunctionName, String... fpsParameter)
	{
		setParent(Parent);
		myID = AllCount;
		
		StringBuilder StrBuilder = new StringBuilder();
		
		StrBuilder.append(fpsFunctionName + "( " );
		
		Boolean GreaterOne = false;
		for ( String sParameter : fpsParameter )
		{
			if (GreaterOne)
			{
				StrBuilder.append( ", " ); 
			}
			else
			{
				GreaterOne = true;
			}
			
			StrBuilder.append( sParameter ); 
		}
		
		StrBuilder.append( " )" );
		
		this.Info = StrBuilder.toString();
	}

	public void setReturn(String fpsReturn)
	{
		myReturn = fpsReturn;
	}
	
	protected void SetFail()
	{
		FunctionFail++;
	}

	protected void SetPass()
	{
		FunctionPass++;
	}
	
	@Override
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		//sbResult.append( lvsIndention + "<blockquote class='" + this.getClass().getSimpleName() + "'>\n" );
		
		sbResult.append( lvsIndention + "<div class='" + this.getClass().getSimpleName() + "'>\n" );
		sbResult.append( lvsIndention + myIndentionBase  +"<div class='Header'>\n" );
		
		if (!this.myLogs.isEmpty())
		{
			sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase + "<div class='FoldMe' href='javascript:/' onClick='div_change(" + myID.toString() + ")'></div>\n" );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Duration'>" + this.myDuration.getSeconds("#0.000") + " s</div>" );
		
		// Exception-icon einfügen wenn bException = true
		if (this.bException)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ExceptionSign' title='Exception...'></div>\n" );
		}
		
		// Error-icon einfügen wenn bError = true
		if (this.bError)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ErrorSign' title='Error...'></div>\n" );
		}
		
		if (this.bWarning)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='WarningSign' title='Warning...'></div>\n" );
		}

		if (this.bException || this.bError )
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Fail'>" + this.Info + "</div>\n" );
		}
		else
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='SuccessSign' title='Success...'></div>\n" );
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Pass'>" + this.Info + "</div>\n" );
		}

		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Header
		

		sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase +"<div class='Body' id='" + myID.toString() +"' style='display: none;'>\n" );
		
		for( LogBase myLog: this.myLogs )
		{
			sbResult.append( myLog.getResult() );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div>Return: "+ this.myReturn +"</div>\n" ); // Return-Value at the end...
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}

}
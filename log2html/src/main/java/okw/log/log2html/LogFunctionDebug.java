package okw.log.log2html;


public class LogFunctionDebug extends LogBase4Gherkin
{
	
	String myReturn = "";
    
    private String Function;
    private String[] Parameter;
    
	LogFunctionDebug(LogBase Parent, String fpsFunctionName, String... fpsParameter)
	{
		setParent(Parent);
		myID = AllCount;
        
        Function = fpsFunctionName;
        Parameter = fpsParameter;
        
        // inkrementieren FunctionCount
        this.FunctionCount();
		
		StringBuilder StrBuilder = new StringBuilder();
		
		StrBuilder.append(fpsFunctionName + "(" );
		
		for ( String sParameter : fpsParameter )
		{
			StrBuilder.append( sParameter ); 
		}
		
		StrBuilder.append( ")" );
		
		this.Info = StrBuilder.toString();
	}

	
	public void setReturn(String fpsReturn)
	{
		myReturn = fpsReturn;
	}

	
	protected void SetFail()
	{
	    //Nur Inkrementieren wenn dieser testfall noch nicht als Fail markiert wurde.
        if(!(this.bError || this.bException) )
        {
            FunctionFail++;
        }
	}

	protected void SetPass()
	{
		FunctionPass++;
	}

	
	@Override
	protected String getHTMLResult()
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
			sbResult.append( myLog.getHTMLResult() );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div>Return: "+ this.myReturn +"</div>\n" ); // Return-Value at the end...
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}

	
	    @Override
	    protected String getJSONResult()
	    {
	        StringBuilder myJSON = new StringBuilder();

	        myJSON.append( this.jsonElement( "Function", this.Function ) );

	        for ( Integer i = 0; i < Parameter.length; i++) { 
	            
	            myJSON.append( this.jsonElement( "Parameter" + i.toString(), Parameter[i] ) );
	        } 
	        
	        // Statistics...
	        myJSON.append( this.jsonStructre( "statistics", this.getJSONStatistics() ) );
	        
	        // Duration
	        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
	        {
	            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
	        }
	        else
	        {
	            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
	        }
	       
	        // Info
	        myJSON.append( this.jsonElement( "Info", this.Info ) );

	        Integer EC = 0;
	        
//	        for( LogBase myLog: this.myLogs )
//	        {
//	            EC++;
//	            String Element = myLog.getClass().getSimpleName();
//	            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.Info ) );
//	        }
	        
	        for( LogBase myLog: this.myLogs )
	        {
	            EC++;
	            String Element = myLog.getClass().getSimpleName();
	            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.getJSONResult() ) );
	        }

	        return myJSON.toString();
	    }


	    @Override
	    protected void ErrorCount()
	    {
	        ErrorCount++;
	        
	        this.FunctionFail();

	        this.bError = true;
	        
	        if ( myParent != null)
	        {
	            myParent.ErrorCount();
	        }
	    }
	    
	    
	    @Override
	    protected void ExceptionCount()
	    {
	        ExceptionCount++;

	        this.FunctionFail();
	        
	        this.bException = true;
	        
	        if ( myParent != null)
	        {
	            myParent.ExceptionCount();
	        }
	    }
	    

	    protected void FunctionFail()
	    {
	        if ( ! (this.bError || this.bException ) )
	            myParent.FunctionFail();
	    }
}

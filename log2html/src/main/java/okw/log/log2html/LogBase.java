package okw.log.log2html;

import java.util.*;

public abstract class LogBase {
	
	protected static Integer AllCount = 0;

	protected Integer myID = 0;

	protected String Info = "";
	
	protected LogTimer myDuration = new LogTimer();
	
	// Ein Parent ist immer ein Knoten!
	protected LogBase myParent = null;

	protected List<LogBase> myLogs= new ArrayList<LogBase>();
	
	public void setParent( LogBase fpParent )
	{
		myParent = fpParent;
	}

	protected void abort()
	{
		setError();
	}
    
	
	public LogBase getParent()
	{
		return myParent;
	}

	
	protected int Level = -1;
	protected String myIndentionBase = "    ";
	
	protected int getLevel()
	{
		int myReturn;
			
		if (Level >= 0)
		{
			myReturn = Level;
		}
		else
		{
			if (this.getParent() != null )
			{
				this.Level = this.getParent().getLevel() + 1;
				myReturn = this.Level;
			}
			else
			{
				myReturn = 0;
			}
		}
		
		return myReturn;
	}


	protected String getLevelIndention()
	{
		StringBuilder myIndention = new StringBuilder();
		
		int n = this.getLevel();
		int i;
		
		for ( i=1; i<=n; i++ )
		{
			myIndention.append(myIndentionBase);
		}
		
		return myIndention.toString();
	}


    protected String getLevelIndention( int shift )
    {
        StringBuilder myIndention = new StringBuilder();
        
        int n = this.getLevel() + shift;
        int i;
        
        for ( i=1; i<=n; i++ )
        {
            myIndention.append(myIndentionBase);
        }
        
        return myIndention.toString();
    }    

	protected String jsonElement( String Key, String Value)
	{
	       return "\"" + Key + "\": \"" + Value + "\"";
	}

    protected String jsonElementComma( String Key, String Value)
    {
        return "\"" + Key + "\": \"" + Value + "\",";
    }
    
    protected String jsonElementComma( String Key, Integer Value )
    {
        return "\"" + Key + "\": \"" + Value.toString() + "\",";
    }
    

    protected String jsonElement( String Key, Integer Value )
    {
         return "\"" + Key + "\": \""  + "\"";
    }
	   
    protected String jsonStructure( String Key, String Value )
    {
        return  "\"" + Key + "\": {" + Value + " }";
    }
    
    protected String jsonStructureComma( String Key, String Value )
    {
        return  "\"" + Key + "\": {" + Value + " },";
    }
    
    protected String jsonArray( String Key, String Value )
    {
        StringBuilder myIndention = new StringBuilder();
        
        myIndention.append( "\"" + Key + "\": [" );
        myIndention.append( Value );
        myIndention.append( "]" );
        
        return  myIndention.toString();
    }
    
    protected String jsonArrayElement( String Value )
    {
        StringBuilder myIndention = new StringBuilder();
        
        myIndention.append( "{" );
        myIndention.append( Value );
        myIndention.append( "}" );
        
        return  myIndention.toString();
    }
    
    protected String jsonArrayElementComma( String Value )
    {
        StringBuilder myIndention = new StringBuilder();
        
        myIndention.append( "{" );
        myIndention.append( Value );
        myIndention.append( "}," );
        
        return  myIndention.toString();
    }
    
	protected Boolean bWarning = false;
	
	protected void setWarning()
	{
		if (!bWarning)
		{
			bWarning = true;
		
		
			if (myParent != null)
			{
				myParent.setWarning();
			}
		}
	}

	protected Boolean getWarning()
	{
		return bWarning;
	}
	
	
	protected Boolean bException = false;

	protected void setException()
	{
		if (!bException)
		{
			//SetFail();
			bException = true;
		
			if (myParent != null)
			{
				myParent.setException();
			}
		}
	}


	protected Boolean bError = false;
	
	protected void setError()
	{
		if (!bError)
		{			
			// SetFail();
			bError = true;

			if (myParent != null)
			{
				myParent.setError();
			}
		}
	}

	protected Boolean getError()
	{
		return bError;
	}

    // Node Statistics
    protected abstract void ErrorCount();
 
    protected abstract void ExceptionCount();
  
    protected abstract void WarningCount();

    protected abstract void PassedCount();

    protected abstract void PrintCount();
    
    protected abstract void TestcaseCount();

    protected abstract void TestcaseFail();
    
    protected abstract void TestcasePass();

    protected abstract void FunctionCount();

    protected abstract void FunctionFail();

    protected abstract void FunctionPass();
    
    protected abstract void KeyWordCount();

    protected abstract void KeyWordFail();

    protected abstract void KeyWordPass();
    
    protected abstract void SequenceCount();

    protected abstract void SequenceFail();

    protected abstract void SequencePass();

    protected abstract void StepCount();
    
    protected abstract void StepFail();
    
    protected abstract void StepPass();

    // Precondition
    protected abstract void LocalACCallCount();
    
    protected abstract void LocalACCallFail();
    
    protected abstract void LocalACCallPass();
    
    // Postcondition
    protected abstract void RemoteACCallCount();
    
    protected abstract void RemoteACCallFail();
    
    protected abstract void RemoteACCallPass();

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
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}


	   protected String getJSONResult()
	    {
        
	        StringBuilder myJSON = new StringBuilder();
	        
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
	            myJSON.append( this.jsonStructure( Element + EC.toString(), myLog.getJSONResult() ) );
	        }
	        
	        return myJSON.toString();
	    }
}

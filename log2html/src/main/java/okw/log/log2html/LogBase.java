package okw.log.log2html;

import java.util.*;

public abstract class LogBase {
	
	
	static Integer AllCount = 0;
	Integer myID = 0;

	// Statistics
	static Integer ErrorCount = 0;
	static Integer ErrorFail = 0;
	static Integer ErrorPass = 0;
	
	static Integer ExceptionCount = 0;
	static Integer ExceptionFail = 0;
	static Integer ExceptionPass = 0;
	
	static Integer WarningCount = 0;
	static Integer WarningFail = 0;
	static Integer WarningPass = 0;
	
	static Integer TestcaseCount = 0;
	static Integer TestcaseFail = 0;
	static Integer TestcasePass = 0;

	static Integer FunctionCount = 0;
	static Integer FunctionFail = 0;
	static Integer FunctionPass = 0;
	
	static Integer KeyWordCount = 0;
	static Integer KeyWordFail = 0;
	static Integer KeyWordPass = 0;
	
	static Integer SequensCount = 0;
	static Integer SequensFail = 0;
	static Integer SequensPass = 0;
	
	static Integer PrintCount = 0;	
	
	String Info = "";
	
	LogTimer myDuration = new LogTimer();
	
	LogBase myParent = null;

	List<LogBase> myLogs= new ArrayList<LogBase>();

	protected abstract void SetFail();
	protected abstract void SetPass();
	
	public void setParent(LogBase fpParent)
	{
		myParent = fpParent;
	}

	
	public LogBase getParent()
	{
		return myParent;
	}
	
	int Level = -1;
	String myIndentionBase = "  ";
	
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

	
	Boolean bWarning = false;
	
	protected void setWarning()
	{
		bWarning = true;
		
		
		if (myParent != null)
		{
			myParent.setWarning();
		}
	}

	protected Boolean getWarning()
	{
		return bWarning;
	}
	
	
	
	Boolean bException = false;

	protected void setException()
	{
		bException = true;
		SetFail();
		
		
		if (myParent != null)
		{
			myParent.setException();
		}
	}


	protected Boolean getException()
	{
		return bException;
	}


	Boolean bError = false;
	
	protected void setError()
	{
		bError = true;
		
		SetFail();
		
		if (myParent != null)
		{
			myParent.setError();
		}
	}

	protected Boolean getError()
	{
		return bError;
	}


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
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}
}

package okw.log.log2html;

import java.util.*;

public abstract class LogBase {
	
	protected static Integer AllCount = 0;
	protected Integer myID = 0;

	// Statistics
	protected static Integer ErrorCount = 0;	
	protected static Integer ExceptionCount = 0;	
	protected static Integer WarningCount = 0;
	protected static Integer PassedCount = 0;
	protected static Integer PrintCount = 0;
	
	
	
	protected static Integer TestcaseCount = 0;
	protected static Integer TestcaseFail = 0;
	protected static Integer TestcasePass = 0;

	protected static Integer FunctionCount = 0;
	protected static Integer FunctionFail = 0;
	protected static Integer FunctionPass = 0;
	
	protected static Integer KeyWordCount = 0;
	protected static Integer KeyWordFail = 0;
	protected static Integer KeyWordPass = 0;
	
	protected static Integer SequensCount = 0;
	protected static Integer SequensFail = 0;
	protected static Integer SequensPass = 0;
		
	protected String Info = "";
	
	protected LogTimer myDuration = new LogTimer();
	
	protected LogBase myParent = null;

	protected List<LogBase> myLogs= new ArrayList<LogBase>();

	protected abstract void SetFail();
	protected abstract void SetPass();
	
	public void setParent(LogBase fpParent)
	{
		myParent = fpParent;
	}

	protected void abort()
	{
		setError();
	}
	
	public void reset()
	{
		AllCount = 0;
		myID = 0;

		// Statistics
		ErrorCount     = 0;
		ExceptionCount = 0;
		WarningCount   = 0;
		PassedCount    = 0;
		PrintCount     = 0;
		
		TestcaseCount = 0;
		TestcaseFail = 0;
		TestcasePass = 0;

		FunctionCount = 0;
		FunctionFail = 0;
		FunctionPass = 0;
		
		KeyWordCount = 0;
		KeyWordFail = 0;
		KeyWordPass = 0;
		
		SequensCount = 0;
		SequensFail = 0;
		SequensPass = 0;
		
		PrintCount = 0;
	}

	
	public LogBase getParent()
	{
		return myParent;
	}

	
	protected int Level = -1;
	protected String myIndentionBase = "  ";
	
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
			SetFail();
			bException = true;
		
			if (myParent != null)
			{
				myParent.setException();
			}
		}
	}


	protected Boolean getException()
	{
		return bException;
	}


	protected Boolean bError = false;
	
	protected void setError()
	{
		if (!bError)
		{			
			SetFail();
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

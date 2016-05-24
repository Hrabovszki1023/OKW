package okw.log.log2html;

public class LogVerify extends LogBase
{
	
	private String myActual   = "";
	private String myExpected = "";
	
	protected LogVerify( LogBase fpParent, String fpsActual, String fpsExpected )
	{
		myID = AllCount;
		this.setParent(fpParent);		

		myActual   = fpsActual;
		myExpected = fpsExpected;
		
		if (myExpected.equals( myActual ))
		{
			Info = "\"" + myActual + "\" = \"" + myExpected + "\"";
		}
		else
		{
			Info = "\"" + myActual + "\" != \"" + myExpected + "\"";
			this.setError();
		}
			
	}

	@Override
	protected void SetFail()
	{
	}

	@Override
	protected void SetPass()
	{
	}
	
	@Override
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPrint'>" + this.Info + "</p>\n" );
		
		
		// Habne wir eine Abweichung??
		if (this.getError())
		{
			sbResult.append( lvsIndention + myIndentionBase + "<p class='VerifyDefault'>Expected: \"" + myExpected + "\"</p>\n" );
			sbResult.append( lvsIndention + myIndentionBase +   "<p class='VerifyError'>  Actual: \"" + myActual + "\"</p>\n" );
		}
		else
		{
			sbResult.append( lvsIndention + myIndentionBase + "<p class='VerifyDefault'>Expected: \"" + myExpected + "\"</p>\n" );
			sbResult.append( lvsIndention + myIndentionBase + "<p class='VerifyPassed'>  Actual: \"" + myActual + "\"</p>\n" );
		}
		return sbResult.toString();
	}

}

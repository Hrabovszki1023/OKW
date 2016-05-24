package okw.log.log2html;

public class LogSequence  extends LogBase
{
	
	LogSequence(LogBase Parent, String fpsWindowFN, String fpsSequenName, String... fpsParameter)
	{
		setParent(Parent);
		myID = AllCount;
		
		StringBuilder StrBuilder = new StringBuilder();
		
		StrBuilder.append( "[" + fpsWindowFN + "]-\"" + fpsSequenName + "\": ");

		if ( fpsParameter.length == 2 )
		{
			StrBuilder.append( "\"" + fpsParameter[0] + "\" = \"" + fpsParameter[1] + "\"" );
		}
		else
		{
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
				StrBuilder.append( "\"" + sParameter + "\"" ); 
			}
		}
		
		this.Info = StrBuilder.toString();
		
	}
	
	protected void SetFail()
	{
		SequensFail++;
	}

	protected void SetPass()
	{
		SequensPass++;
	}
}

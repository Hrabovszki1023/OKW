package okw.log.log2html;

public class LogKeyword extends LogBase
{

	LogKeyword( LogBase Parent, String fpsKeyword, String... fpsParameter )
	{
		setParent( Parent );
		myID = AllCount;

		StringBuilder StrBuilder = new StringBuilder();

		StrBuilder.append( fpsKeyword + ": " );

		if ( fpsParameter.length == 2 )
		{
			StrBuilder.append( "\"" + fpsParameter[0] + "\" = \"" + fpsParameter[1] + "\"" );
		}
		else
		{
			for ( String sParameter : fpsParameter )
			{
				StrBuilder.append( " \"" + sParameter + "\"" );
			}
		}

		this.Info = StrBuilder.toString();

	}

	protected void SetFail()
	{
		KeyWordFail++;
	}

	protected void SetPass()
	{
		KeyWordPass++;
	}

}

package okw.log.log2html;

public class LogException extends LogBase
{

    protected LogException(LogBase fpParent, String fpsInfo)
	{
		Info = fpsInfo;
		myID = AllCount;
		this.setParent(fpParent);		
		ExceptionCount();	
	}
 
    @Override
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogException'>" + this.Info + "</p>\n" );
		
		return sbResult.toString();
	}
	

    protected String getJSONResult()
     {
         StringBuilder myJSON = new StringBuilder();
                     
         myJSON.append( this.jsonElement( "Exception",  this.Info ) );
         
         return myJSON.toString();
     }

}

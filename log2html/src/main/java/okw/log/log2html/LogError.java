package okw.log.log2html;

public class LogError extends LogBaseLeaf
{

    protected LogError( LogBase fpParent, String fpsInfo )
    {
        Info = fpsInfo;
        myID = AllCount;
        setParent(fpParent);
        
        ErrorCount();
    }

    
    // local Statistics
    protected void ErrorCount()
    {
        bError = true;

        if ( myParent != null )
        {
            myParent.ErrorCount();
        }
    }


    protected String getHTMLResult()
    {
        StringBuilder sbResult = new StringBuilder();

        String lvsIndention = this.getLevelIndention();

        sbResult.append( lvsIndention + myIndentionBase + "<p class='LogError'>" + this.Info + "</p>\n" );

        return sbResult.toString();
    }

    
    protected String getJSONResult()
     {
         StringBuilder myJSON = new StringBuilder();
                     
         myJSON.append( this.jsonElement( "Error",  this.Info ) );
         
         return myJSON.toString();
     }
}

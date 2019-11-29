package okw.log.log2html;

import org.apache.commons.text.StringEscapeUtils;

public class LogFunctionDebug extends LogBaseNode
{

    String           myReturn = "";

    private String   type     = "Function";
    private String   functionName;
    private String[] parameter;

    LogFunctionDebug( LogBase Parent, String fpsFunctionName, String... fpsParameter )
    {
        setParent( Parent );
        myID = AllCount;

        functionName = fpsFunctionName;
        parameter = fpsParameter;

        // inkrementieren FunctionCount
        this.FunctionCount();

        StringBuilder StrBuilder = new StringBuilder();

        StrBuilder.append( fpsFunctionName + "(" );

        Boolean GreaterOne = false;
        for ( String sParameter : fpsParameter )
        {
            if ( GreaterOne )
            {
                StrBuilder.append( ", " );
            }
            else
            {
                GreaterOne = true;
            }

            StrBuilder.append( sParameter );
        }

        StrBuilder.append( ")" );

        this.Info = StrBuilder.toString();
    }

    public void setReturn( String fpsReturn )
    {
        myReturn = fpsReturn;
    }

    protected void SetFail()
    {
        //Nur Inkrementieren wenn dieser testfall noch nicht als Fail markiert wurde.
        if ( !( this.bError || this.bException ) )
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
        sbResult.append( lvsIndention + myIndentionBase + "<div class='Header'>\n" );

        if ( !this.myLogs.isEmpty() )
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='FoldMe' onClick='div_change(" + myID.toString()
                            + ")'></div>\n" );
        }

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Duration'>" + this.myDuration.getSeconds( "#0.000" ) + " s</div>" );

        // Exception-icon einfügen wenn bException = true
        if ( this.bException )
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ExceptionSign' title='Exception...'></div>\n" );
        }

        // Error-icon einfügen wenn bError = true
        if ( this.bError )
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ErrorSign' title='Error...'></div>\n" );
        }

        if ( this.bWarning )
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='WarningSign' title='Warning...'></div>\n" );
        }

        if ( this.bException || this.bError )
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Fail'>" + StringEscapeUtils.escapeHtml4(this.Info) + "</div>\n" );
        }
        else
        {
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='SuccessSign' title='Success...'></div>\n" );
            sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Pass'>" + StringEscapeUtils.escapeHtml4(this.Info) + "</div>\n" );
        }

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Header

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Body' id='" + myID.toString() + "' style='display: none;'>\n" );

        for ( LogBase myLog : this.myLogs )
        {
            sbResult.append( myLog.getHTMLResult() );
        }

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div>Return: " + StringEscapeUtils.escapeHtml4(this.myReturn) + "</div>\n" ); // Return-Value at the end...

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body

        sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
        //sbResult.append( lvsIndention + "</blockquote>\n");

        return sbResult.toString();
    }

    @Override
    protected void ErrorCount()
    {
        ErrorCount++;

        this.FunctionFail();

        this.bError = true;

        if ( myParent != null )
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

        if ( myParent != null )
        {
            myParent.ExceptionCount();
        }
    }

    @Override
    protected void FunctionFail()
    {
        if ( !( this.bError || this.bException ) )
            myParent.FunctionFail();
    }

    @Override
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();

        myJSON.append( this.jsonElementComma( "type", this.type ) );
        // Info
        myJSON.append( this.jsonElementComma( "Info", this.Info ) );

        myJSON.append( this.jsonElementComma( "Function", this.functionName ) );

        for ( Integer i = 0; i < this.parameter.length; i++ )
        {

            myJSON.append( this.jsonElementComma( "Parameter" + i.toString(), parameter[i] ) );
        }

        return myJSON.toString();
    }
}

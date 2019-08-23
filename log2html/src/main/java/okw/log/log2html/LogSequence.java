package okw.log.log2html;

public class LogSequence  extends LogBaseNode
{
    private String type = "Sequence";
    
	LogSequence(LogBase Parent, String fpsWindowFN, String fpsSequenName, String... fpsParameter)
	{
		setParent(Parent);
		myID = AllCount;
			      
        // inkrementieren FunctionCount
		this.SequenceCount();
		
		StringBuilder StrBuilder = new StringBuilder();
		
		StrBuilder.append( "[" + fpsWindowFN + "]-'" + fpsSequenName + "': ");

		if ( fpsParameter.length == 2 )
		{
			StrBuilder.append( "'" + fpsParameter[0] + "' = '" + fpsParameter[1] + "'" );
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
				StrBuilder.append( "'" + sParameter + "'" ); 
			}
		}
		
		this.Info = StrBuilder.toString();		
	}


    @Override
    protected void ErrorCount()
    {
        ErrorCount++;
        
        this.SequenceFail();

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

        this.SequenceFail();
        
        this.bException = true;
        
        if ( myParent != null)
        {
            myParent.ExceptionCount();
        }
    }
    
    @Override
    protected void SequenceFail()
    {
        if ( ! (this.bError || this.bException ) )
           myParent.SequenceFail();
    }
    

    
    @Override
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElementComma( "type", this.type ) );
        myJSON.append( this.jsonElementComma( "info", this.Info ) );
        
        return myJSON.toString();
    }
 }

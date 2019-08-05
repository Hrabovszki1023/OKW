package okw.log.log2html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

import okw.log.ILogger;


// http://www.java-blog-buch.de/d-plugin-entwicklung-in-java/

public class Log2HTML extends LogBaseNode implements ILogger
{

	// Das ist das Root-Objekt, der Pointer wird im Konstruktor zuerst auf den root/Wurzel gesetzt,
	// LogBase Point2LogObject;
	private Stack<LogBase> Pointer2LogBaseStack = new Stack<LogBase>();
	

	// name des Features, welches hier getestet wird.
	private String name = "";
	
    // result - das Ergebniss des Features welche hier representiert wird.
    private String result = ""; // mögliche Werte "success"
	
	public Log2HTML()
	{
		this.myDuration.startTimer();
		Pointer2LogBaseStack.push(this);
	}


	public Log2HTML( String featereName )
	{
		this.myDuration.startTimer();;
		this.name = featereName;

		Pointer2LogBaseStack.push(this);
	}

	
	public void LogPass(String fpsMessage)
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogPass(Pointer2LogBaseStack.peek(), fpsMessage) ); 	
	}
	

	public void LogPrint(String fpsMessage)
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogPrint(Pointer2LogBaseStack.peek(), fpsMessage) ); 	
	}


	public void LogPrintDebug( String fpsMessage )
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogPrintDebug(Pointer2LogBaseStack.peek(), fpsMessage) );
	}


	public void LogWarning(String fpsMessage)
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogWarning(Pointer2LogBaseStack.peek(), fpsMessage) ); 	
	}


	public void LogError(String fpsMessage)
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogError(Pointer2LogBaseStack.peek(), fpsMessage) );
	}


	public void LogException(String fpsMessage)
	{
		AllCount++;
		
		Pointer2LogBaseStack.peek().myLogs.add( new LogException(Pointer2LogBaseStack.peek(), fpsMessage) ); 	
	}


    public void LogSourceLocation( String Start, String End, String featureName, String sourceType )
    {
        AllCount++;
        
        Pointer2LogBaseStack.peek().myLogs.add( new LogSourceLocation(Pointer2LogBaseStack.peek(), Start, End, featureName, sourceType) );    
    }

    
	public void LogFunctionStart(String fps_FunctionName, String... fpsParameter)
    {
		AllCount++;
		
    	LogBase myLog = new LogFunction( Pointer2LogBaseStack.peek(), fps_FunctionName, fpsParameter);

    	// Timer starten
    	myLog.myDuration.startTimer();
    	
    	Pointer2LogBaseStack.peek().myLogs.add(myLog);
    	Pointer2LogBaseStack.push(myLog);
    	
    }


	public void LogFunctionStartDebug( String fps_FunctionName, String... fpsParameter )
	{
		AllCount++;
		
    	LogBase myLog = new LogFunctionDebug( Pointer2LogBaseStack.peek(), fps_FunctionName, fpsParameter);

    	// Timer starten
    	myLog.myDuration.startTimer();
    	
    	Pointer2LogBaseStack.peek().myLogs.add(myLog);
    	Pointer2LogBaseStack.push(myLog);
	}


    public void LogFunctionEnd()
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();

    	@SuppressWarnings( "unused" )
		LogFunction myLogFunction = (LogFunction)myLog;
    	
        if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
	}


	public void LogFunctionEndDebug()
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();

    	@SuppressWarnings( "unused" )
		LogFunctionDebug myLogFunction = (LogFunctionDebug)myLog;
    	
        if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
	}


	public void LogFunctionEndDebug( Boolean fpb_Return )
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)myLog;
    	myLogFunction.setReturn( fpb_Return.toString());

        if ( !(myLog.bError || myLog.bException) )
        {
    		FunctionPass++;
    	}
	}
	

	public void LogFunctionEnd(Boolean Return)
    {
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)myLog;
    	myLogFunction.setReturn( Return.toString());

        if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
    }


	public void LogFunctionEnd( String fps_Return )
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)myLog;
    	myLogFunction.setReturn( fps_Return);

        if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
	}

	
	public void LogFunctionEndDebug( String fps_Return )
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)myLog;
    	myLogFunction.setReturn( fps_Return);

        if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
    }

	
	public void LogFunctionEnd( List<String> fps_Return )
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)myLog;
    	
    	// TODO: ein ResultListstring hier einhängen
    	myLogFunction.setReturn( fps_Return.toString());

   	    if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
	}

	public void LogFunctionEndDebug( List<String> fps_Return )
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)myLog;
    	
    	// TODO: ein ResultListstring hier einhängen
    	myLogFunction.setReturn( fps_Return.toString());

    	if ( !(myLog.bError || myLog.bException) )
    	{
    		FunctionPass++;
    	}
	}

	
    public void LogTestcaseStart(String fps_FunctionName)
	{
		AllCount++;
		
		StopAllTimerAndEmptyStack();
		Pointer2LogBaseStack.push( this );
		
		LogBase myLog = new LogTestcase( Pointer2LogBaseStack.peek(), fps_FunctionName);
		
		// Timer starten
		myLog.myDuration.startTimer();
	
		Pointer2LogBaseStack.peek().myLogs.add(myLog);
		Pointer2LogBaseStack.push(myLog);
	}

	public void LogTestcaseEnd()
    {
    	LogBase myLog = Pointer2LogBaseStack.pop();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();

    	@SuppressWarnings( "unused" )
		LogTestcase myCheck = (LogTestcase)myLog;

    	if ( !(myLog.bError || myLog.bException))
    	{
    		TestcasePass++;
    	}
    	
		StopAllTimerAndEmptyStack();
    }

    
    public void LogKeyWordStart(String fps_FunctionName, String... fpsParameter)
    {
		AllCount++;
		
    	LogBase myLog = new LogKeyword( Pointer2LogBaseStack.peek(), fps_FunctionName, fpsParameter);
    	
    	// Timer starten
    	myLog.myDuration.startTimer();

    	Pointer2LogBaseStack.peek().myLogs.add(myLog);
    	Pointer2LogBaseStack.push(myLog);
   }

    
    public void LogKeyWordEnd()
    {
		LogBase myLog = Pointer2LogBaseStack.peek();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();

    	@SuppressWarnings( "unused" )
		LogKeyword myCheck = (LogKeyword)myLog;

    	if ( !(myLog.bError  || myLog.bException))
    	{
            myLog.KeyWordPass( );
    	}

		Pointer2LogBaseStack.pop();

    }

    
    public void LogLocalACCallStart( String sourceExcerpt, String Type )
    {
        AllCount++;
        
        LogBase myLog = new LogLocalACCall( Pointer2LogBaseStack.peek(), sourceExcerpt, Type );
        
        // Timer starten
        myLog.myDuration.startTimer();

        Pointer2LogBaseStack.peek().myLogs.add(myLog);
        Pointer2LogBaseStack.push(myLog);
    }

    
    public void LogLocalACCallEnd()
    {
        LogBase myLog = Pointer2LogBaseStack.peek();
        // Timer Stoppen...
        myLog.myDuration.stopTimer();

        @SuppressWarnings( "unused" )
        LogLocalACCall myCheck = (LogLocalACCall)myLog;

        if ( !(myLog.bError  || myLog.bException))
        {
            myLog.LocalACCallPass( );
        }

        Pointer2LogBaseStack.pop();
    }

    /**
    * \~german
    * Log markiert den Start eines Steps.
    * 
    * Das ist ein [Harmony](https://cloud.4test.io/). spezifischer log
    * und ist für den Code-Compiler von Harmony Reserviert
    *
    * @param categoryName Name der Kategorie (category)
    * @param choiceValue Choice, also der zugeordnetter Wert der Categorie
    * @param featureName 
    * @param localCategoryName Lokalar Name der Kategorie 
    * @param sourceExcerpt ist der Auszug, von der dieser Schritt abgeleitet wurde
    * 
    * \~english
    * Log marks the start of a step.
    * 
    * Das ist ein [Harmony](https://cloud.4test.io/). spezifischer log
    * und ist für den Code-Compiler von Harmony Reserviert
    *
    * @param categoryName Category name
    * @param choiceValue Choice, i.e. the assigned value of the category
    * @param featureName Feature Name
    * @param localCategoryName Local name of category 
    * @param sourceExcerpt is the excerpt from which this step was derived
    * 
    * \~
    * @author Zoltán Hrabovszki
    * @date 2019-08-05
    */
    public void LogStepStart( String categoryName, String choiceValue, String featureName, String localCategoryName, String sourceExcerpt )
    {
        AllCount++;

        LogBase myLog = new LogStep( Pointer2LogBaseStack.peek(), categoryName, choiceValue, featureName, localCategoryName, sourceExcerpt );

        // Timer starten
        myLog.myDuration.startTimer();

        Pointer2LogBaseStack.peek().myLogs.add( myLog );
        Pointer2LogBaseStack.push( myLog );
    }
    
    
    public void LogStepEnd()
    {
        LogBase myLog = Pointer2LogBaseStack.peek();
        // Timer Stoppen...
        myLog.myDuration.stopTimer();
        
        @SuppressWarnings( "unused" )
        LogStep myCheck = (LogStep)myLog;
        
        if ( !(myLog.bError  || myLog.bException))
        {
            StepPass++;
        }
        
        Pointer2LogBaseStack.pop();
    }

    

    
    public void LogRemoteACCallStart( String sourceExcerpt, String Type )
    {
        AllCount++;
        
        LogBase myLog = new LogRemoteACCall( Pointer2LogBaseStack.peek(), sourceExcerpt, Type );
        
        // Timer starten
        myLog.myDuration.startTimer();

        Pointer2LogBaseStack.peek().myLogs.add(myLog);
        Pointer2LogBaseStack.push(myLog);
    }
    
    
    public void LogRemoteACCallEnd()
    {
        LogBase myLog = Pointer2LogBaseStack.peek();
        // Timer Stoppen...
        myLog.myDuration.stopTimer();
        
        @SuppressWarnings( "unused" )
        LogRemoteACCall myCheck = (LogRemoteACCall)myLog;
        
        if ( !(myLog.bError  || myLog.bException))
        {
            StepPass++;
        }
        
        Pointer2LogBaseStack.pop();
    }
    
    
    public void LogSequenceStart( String fpsKeywordName, String fpsWindowFN, String fps_SequensName, String... fpsParameter)
    {
		AllCount++;
		
    	LogBase myLog = new LogSequence( Pointer2LogBaseStack.peek(), fpsWindowFN, fps_SequensName, fpsParameter);
    	
    	// Timer starten
    	myLog.myDuration.startTimer();

    	Pointer2LogBaseStack.peek().myLogs.add(myLog);
    	Pointer2LogBaseStack.push(myLog);
    }

    
    public void LogSequenceEnd()
    {
		LogBase myLog = Pointer2LogBaseStack.peek();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();

    	@SuppressWarnings( "unused" )
		LogSequence myCheck = (LogSequence)myLog;

    	if ( !(myLog.bError  || myLog.bException))
    	{
    	    myLog.SequensPass();
    	}

		Pointer2LogBaseStack.pop();
    }
    
    
    private String getHTMLFooter()
    {
    	StringBuilder myResult = new StringBuilder();
    	
    	myResult.append("</body>\n");
    	myResult.append("</html>\n");

    	return myResult.toString();
    }

    
    private String getHTMLHeader() throws IOException
    {
    	StringBuilder myResult = new StringBuilder();
    	
    	myResult.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
    	myResult.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");

    	myResult.append("<head>\n");
    	myResult.append("\t<title>TestPage Titel</title>\n");
    	
    	// -----------------------------------------
    	// OKW is utf-8 based...
    	myResult.append("\t<meta charset=\"utf-8\"/>\n");
    	
    	// -----------------------------------------
    	// insert Log2HTML.css direct into the HTML-Code: No link-refernce!
        
    	myResult.append( "\t<style>\n" );
    	myResult.append( getStyleSheet() );
    	myResult.append( getFoldScript() );
    	myResult.append( "\t</style>\n" );
    	
    	// -----------------------------------------
    	// Log2HTML in HTML einbinden...
    	myResult.append("\t<script language='JavaScript'>\n");
    	myResult.append("\tfunction div_change() {\n");
    	myResult.append("\t\tfor (i = 0; i < div_change.arguments.length; i++) {\n");
    	myResult.append("\t\tvar _id = div_change.arguments[i];\n");
    	myResult.append("\t\tdocument.getElementById(_id).style.display = (document.getElementById(_id).style.display == 'none' ) ? 'block' : 'none';\n");
    	myResult.append("\t\t}\n");
    	myResult.append("\t}\n");
    	myResult.append("\t</script>\n");
    	
    	myResult.append("</head>\n");
    	myResult.append("<body>\n");
    	myResult.append("<div class=OKW_Logo title='www.openkeyword.de'></div>\n");
    	myResult.append("<h1>OpenKeyWord Testlog</h1>\n");
    	return myResult.toString();
    }

    private String getStyleSheet() throws IOException
    {
    	StringBuilder myResult = new StringBuilder();
    	        
    	ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	InputStream is = loader.getResourceAsStream("Log2HTML.css");
    	
        byte[] buffer = new byte[2048];
        int length;
        
        while ((length = is.read(buffer)) != -1) 
        {
        	myResult.append(new String(buffer, 0, length));
        }
        is.close();
    	    	
    	return myResult.toString();
    }

    private String getFoldScript() throws IOException
    {
      StringBuilder myResult = new StringBuilder();
              
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      InputStream is = loader.getResourceAsStream("folder.script");
      
        byte[] buffer = new byte[2048];
        int length;
        
        while ((length = is.read(buffer)) != -1) 
        {
          myResult.append(new String(buffer, 0, length));
        }
        is.close();
            
      return myResult.toString();
    }

    
    private String getHTMLStatistics()
    {
    	StringBuilder myResult = new StringBuilder();
    	
    	myResult.append("<h2>Test Statistics</h2>\n");
 
    	
    	myResult.append("<p><table class='statistics'>\n");   	

    	myResult.append("\t<thead  class='statistics'>\n");
    	myResult.append("\t\t<tr class='statistics'>\n");    	
    	myResult.append("\t\t\t<th></th>\n");
    	myResult.append("\t\t\t<th>Count</th>\n");
    	myResult.append("\t\t\t<th colspan='3'></th>\n");
    	myResult.append("\t\t</tr>\n");
    	myResult.append("\t</thead>\n");

    	
    	myResult.append("\t<tbody>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Errors:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + ErrorCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td colspan='3'></td>\n");
    	myResult.append("\t\t</tr>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Exceptions:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + ExceptionCount.toString() + "</td>\n");
       	myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");

    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Warnings:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + WarningCount.toString() + "</td>\n");
       	myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");

    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Passed:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + PassedCount.toString() + "</td>\n");
       	myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");

       	
    	myResult.append("\t<thead  class='statistics'>\n");
    	myResult.append("\t\t<tr class='statistics'>\n");    	
    	myResult.append("\t\t\t<th></th>\n");
    	myResult.append("\t\t\t<th width='60px'>Count</th>\n");
    	myResult.append("\t\t\t<th width='60px'>Pass</th>\n");
    	myResult.append("\t\t\t<th width='60px'>Fail</th>\n");
    	myResult.append("\t\t\t<th>Pass-Fail-Rate</th>\n");
    	myResult.append("\t\t</tr>\n");
    	myResult.append("\t</thead>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Test cases:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + TestcaseCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + TestcasePass.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + TestcaseFail.toString() + "</td>\n");
    	myResult.append("\t\t\t<td>" + getFailPassBar(TestcaseFail, TestcaseCount - TestcaseFail) + "</td>\n");
    	myResult.append("\t\t</tr>\n");


    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Sequences:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + SequensCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + SequensPass.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + SequensFail.toString() + "</td>\n");
    	myResult.append("\t\t\t<td >" + getFailPassBar(SequensFail, SequensCount - SequensFail) + "</td>\n");
    	myResult.append("\t\t</tr>\n");

    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Keywords:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + KeyWordCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + KeyWordPass.toString() + "</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + KeyWordFail.toString() + "</td>\n");
    	myResult.append("\t\t\t<td>" + getFailPassBar(KeyWordFail, KeyWordCount-KeyWordFail) + "</td>\n");
    	myResult.append("\t\t</tr>\n");

    	myResult.append("\t\t<tr class='statistics'>\n");    	
    	myResult.append("\t\t\t<th  colspan='5'>Timer</th>\n");
    	myResult.append("\t\t</tr>\n");
    	
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Start time:</td>\n");
    	myResult.append("\t\t\t<td align='center' colspan='4'>" + this.myDuration.getStartTime() + "</td>\n");
    	myResult.append("\t\t</tr>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>End time:</td>\n");
    	myResult.append("\t\t\t<td align='center' colspan='4'>" + this.myDuration.getEndTime() + "</td>\n");
    	myResult.append("\t\t</tr>\n");
    	myResult.append("</table></p>\n");
    	
       	return myResult.toString();
    }

    
    private String getFailPassBar(int FailCount, int PassCount)
    {
    	StringBuilder myResult = new StringBuilder();

    	if (FailCount+PassCount > 0)
    	{
    		float lfFailRate = FailCount * 100f / (FailCount + PassCount );
    		float lfPassRate = 100f - lfFailRate;
    	
    		myResult.append("<div class='pass-fail-graph'>\n");
    		myResult.append("\t<div class='pass-bar' style='width: " + String.format (Locale.ENGLISH, "%.2f", lfPassRate) + "%'></div>\n");
    		myResult.append("\t<div class='fail-bar' style='width: " + String.format (Locale.ENGLISH, "%.2f", lfFailRate) + "%'></div>\n");
    		myResult.append("</div>\n");
    	}

    	return myResult.toString();
    }
    
    
    public void Result2HTML(String fpsFilename)
    {
 
    	StringBuilder myResult = new StringBuilder();
    	
		try{
			
			StopAllTimerAndEmptyStack();
			
			myResult.append(getHTMLHeader());
			myResult.append(getHTMLStatistics());
    	
			myResult.append("<h2>Result Log</h2>\n");
			myResult.append(getHTMLResult());
			myResult.append(getHTMLFooter());
   

		    FileWriter fw = new FileWriter(fpsFilename);
		    BufferedWriter bw = new BufferedWriter(fw);

		    bw.write( myResult.toString() );

		    bw.close();
			}
			catch(Exception e)
			{
			 System.out.print(e.getMessage());
			}
    }

    
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
	
		for( LogBase myLog: this.myLogs )
		{
			sbResult.append( myLog.getHTMLResult() );
		}

		return sbResult.toString();
	}

	
    public String Result2JSON( String fpsFileName )
    {
        StringBuilder myJSON = new StringBuilder();
        
        try
        {
            StopAllTimerAndEmptyStack();
            
            myJSON.append( getJSONHeader() );
            myJSON.append( this.jsonStructre( "statistics", this.getJSONStatistics() ) );
        
            myJSON.append( this.jsonStructre( "result", this.getJSONResult() ));
            myJSON.append( getJSONFooter());
   
            System.out.print( myJSON.toString() );
            
            // Write jason-File
            FileWriter fw = new FileWriter( fpsFileName );
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write( myJSON.toString() );

            bw.close();
         }
            catch(Exception e)
         {
             System.out.print(e.getMessage());
         }
        
        return myJSON.toString();
    }

    
    private String getJSONHeader()
    {
        StringBuilder myResult = new StringBuilder();
        
        myResult.append("{\n");
        
        return myResult.toString();
    }

    
    protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
    
        Integer EC = 0;
        
        // 
        myJSON.append( this.jsonElement( "name", this.name) );
        myJSON.append( this.jsonElement( "result", this.result) );
        
        for( LogBase myLog: this.myLogs )
        {
            EC++;
            String Element = myLog.getClass().getSimpleName();
            myJSON.append( this.jsonStructre( Element + EC.toString(), myLog.getJSONResult() ) );
        }

        return myJSON.toString();
    }
    
    
    protected String getJSONStatistics()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElement( "PassedCount", PassedCount.toString() ) );
        myJSON.append( this.jsonElement( "ExceptionCount", ExceptionCount.toString() ) );
        myJSON.append( this.jsonElement( "WarningCount", WarningCount.toString() ) );
        myJSON.append( this.jsonElement( "ErrorCount", ErrorCount.toString() ) );
        
        // Test cases
        myJSON.append( this.jsonElement( "TestcaseCount", TestcaseCount.toString() ) );
        myJSON.append( this.jsonElement( "TestcasePass", TestcasePass.toString() ) );
        myJSON.append( this.jsonElement( "TestcaseFail", TestcaseFail.toString() ) );
 
        // Sequences
        myJSON.append( this.jsonElement( "SequensCount", SequensCount.toString() ) );
        myJSON.append( this.jsonElement( "SequensPass", SequensPass.toString() ) );
        myJSON.append( this.jsonElement( "SequensFail", SequensFail.toString() ) );

        // Precondition:
        myJSON.append( this.jsonElement( "LocalACCallCount", LocalACCallCount.toString() ) );
        myJSON.append( this.jsonElement( "LocalACCallPass",  LocalACCallPass.toString() ) );
        myJSON.append( this.jsonElement( "LocalACCallFail",  LocalACCallFail.toString() ) );

        // Sub
        myJSON.append( this.jsonElement( "RemoteACCallCount", RemoteACCallCount.toString() ) );
        myJSON.append( this.jsonElement( "RemoteACCallPass", RemoteACCallPass.toString() ) );
        myJSON.append( this.jsonElement( "RemoteACCallFail", RemoteACCallFail.toString() ) );        

        // Step
        myJSON.append( this.jsonElement( "StepCount", StepCount.toString() ) );
        myJSON.append( this.jsonElement( "StepPass", StepPass.toString() ) );
        myJSON.append( this.jsonElement( "StepFail", StepFail.toString() ) );        
        
        // Keywords:
        myJSON.append( this.jsonElement( "KeyWordCount", KeyWordCount.toString() ) );
        myJSON.append( this.jsonElement( "KeyWordPass", KeyWordPass.toString() ) );
        myJSON.append( this.jsonElement( "KeyWordFail", KeyWordFail.toString() ) );

        // Timer:
        // Für den Test wird das Abgeschaltet, weil veränderlich 
        if ( "false".equals( okw.OKW_Properties.getInstance().getProperty( "Log2HTML.Test", "false" ) ) )
        {
            myJSON.append( this.jsonElement( "Start time", this.myDuration.getStartTime() ) );
            myJSON.append( this.jsonElement( "End time", this.myDuration.getEndTime() ) );
            myJSON.append( this.jsonElement( "duration", this.myDuration.getSeconds("#0.000") ) );
        }
        else
        {
            myJSON.append( this.jsonElement( "Start time", "Start time TestMode" ) );
            myJSON.append( this.jsonElement( "End time", "End time TestMode" ) );
            myJSON.append( this.jsonElement( "duration", "Duration TestMode" ) );
        }

        return myJSON.toString();
    }
    
    private String getJSONFooter()
    {
        StringBuilder myResult = new StringBuilder();
        
        myResult.append("}\n");

        return myResult.toString();
    }
	
	protected void abort()
	{
	}

	
	public void ResOpenList( String fps_ListHeader )
	{
		AllCount++;
		
    	LogBase myLog = new ResultList( Pointer2LogBaseStack.peek(), fps_ListHeader);

    	// Timer starten
    	myLog.myDuration.startTimer();
    	
    	Pointer2LogBaseStack.peek().myLogs.add(myLog);    	
    	Pointer2LogBaseStack.push(myLog);
	}
	
	
	public void ResOpenListDebug( String fps_ListHeader )
	{
		AllCount++;
		
    	LogBase myLog = new ResultListDebug( Pointer2LogBaseStack.peek(), fps_ListHeader);

    	// Timer starten
    	myLog.myDuration.startTimer();
    	
        Pointer2LogBaseStack.peek().myLogs.add(myLog);
    	Pointer2LogBaseStack.push(myLog);
	}

	
	private void StopAllTimerAndEmptyStack()
	{		
		
		if (Pointer2LogBaseStack.size() > 1 )
		{
			Pointer2LogBaseStack.peek().abort();
		}
		
	    while (!Pointer2LogBaseStack.isEmpty()) 
	    {
	    	Pointer2LogBaseStack.pop().myDuration.stopTimer();	
		}
	}
	
	
	public void ResCloseList()
	{
		LogBase myLog = Pointer2LogBaseStack.pop();
		
    	// Timer Stoppen...
		myLog.myDuration.stopTimer();
    	
    	@SuppressWarnings( "unused" )
		ResultList myResultList = (ResultList)myLog;

    	if ( (!myLog.bError)  || (!myLog.bException))
    	{
    		FunctionPass++;
    	}
    }

	
	public void ResCloseListDebug()
	{
		LogBase myLog = Pointer2LogBaseStack.peek();
    	// Timer Stoppen...
    	myLog.myDuration.stopTimer();
    	
    	@SuppressWarnings( "unused" )
		ResultListDebug myResultList = (ResultListDebug)myLog;
 
    	if ( (!myLog.bError)  || (!myLog.bException))
    	{
    		FunctionPass++;
    	}

		Pointer2LogBaseStack.pop();
    }


	public void setDebugMode( Boolean fpbDebugMode )
	{
		
	}
	
	
	@Override
    protected void TestcaseCount()
    {
        this.TestcaseCount++;
    }

    @Override
    protected void TestcaseFail()
    {
        this.TestcaseFail++;
    }
    
    @Override
    protected void TestcasePass()
    {
        this.TestcasePass++;
    }

    @Override
    protected void FunctionCount()
    {
        this.FunctionCount++;
    }

    @Override
    protected void FunctionFail()
    {
        this.FunctionFail++;
    }

    @Override
    protected void FunctionPass()
    {
        this.FunctionPass++;
    }
    
    @Override
    protected void KeyWordCount()
    {
        this.KeyWordCount++;
    }

    @Override
    protected void KeyWordFail()
    {
        this.KeyWordFail++;
    }

    @Override
    protected void KeyWordPass()
    {
        this.KeyWordPass++;
    }
    
    @Override
    protected void SequensCount()
    {
        this.SequensCount++;
    }

    @Override
    protected void SequensFail()
    {
        this.SequensFail++;
    }

    @Override
    protected void SequensPass()
    {
        this.SequensPass++;
    }

    // Sub
    @Override
    protected void StepCount()
    {
        this.StepCount++;
    }
    
    @Override
    protected void StepFail()
    {
        this.StepFail++;
    }
    
    @Override
    protected void StepPass()
    {
        this.StepPass++;
    }

    
    // LocalACCall
    @Override
    protected void LocalACCallCount()
    {
        this.LocalACCallCount++;
    }
    
    @Override
    protected void LocalACCallFail()
    {
        this.LocalACCallFail++;
    }
    
    @Override
    protected void LocalACCallPass()
    {
        this.LocalACCallPass++;
    }
    
    // RemoteACCall
    @Override
    protected void RemoteACCallCount()
    {
        this.RemoteACCallCount++;
    }
    
    @Override
    protected void RemoteACCallFail()
    {
        this.RemoteACCallFail++;
    }
    
    @Override
    protected void RemoteACCallPass()
    {
        this.RemoteACCallPass++;
    }
}

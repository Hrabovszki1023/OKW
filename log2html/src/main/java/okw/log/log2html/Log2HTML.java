package okw.log.log2html;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import okw.log.ILogger;


// http://www.java-blog-buch.de/d-plugin-entwicklung-in-java/

public class Log2HTML extends LogBase implements ILogger
{

	// Das ist as Root Objekt, der Pointer wird initial auf root gestzt
	LogBase Point2LogObject;
	
	// Wo soll das ergebnissingescrieben werden
	private String HTML_File = "";
	
	private Boolean bFinalize = false;
	
	public String getHTML_File()
	{
		return HTML_File;
	}

	public void setHTML_File( String hTML_File )
	{
		HTML_File = hTML_File;
	}

	public Log2HTML()
	{
		Point2LogObject = this;
	}

	public Log2HTML(String fpsOutputFilename)
	{
		bFinalize = true;
		Point2LogObject = this;
		setHTML_File( fpsOutputFilename );
	}

	protected void finalize( )
	{
		if (bFinalize)
		{
			Result2HTML();
		}
	}

	public void LogPass(String fpsMessage)
	{
		PrintCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogPass(Point2LogObject, fpsMessage) ); 	
	}
	
	public void LogPrint(String fpsMessage)
	{
		PrintCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogPrint(Point2LogObject, fpsMessage) ); 	
	}

	public void LogPrintDebug( String fpsMessage )
	{
		PrintCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogPrintDebug(Point2LogObject, fpsMessage) ); 	
	}


	public void LogWarning(String fpsMessage)
	{
		WarningCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogWarning(Point2LogObject, fpsMessage) ); 	
	}

	public void LogError(String fpsMessage)
	{
		ErrorCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogError(Point2LogObject, fpsMessage) );
	}

	public void LogException(String fpsMessage)
	{
		ExceptionCount++;
		AllCount++;
		
		Point2LogObject.myLogs.add( new LogException(Point2LogObject, fpsMessage) ); 	
	}

	// TODO: Hierher
    public void LogFunctionStart(String fps_FunctionName, String... fpsParameter)
    {
		FunctionCount++;
		AllCount++;
		
    	LogBase myLog = new LogFunction( Point2LogObject, fps_FunctionName, fpsParameter);

    	// Timer starten
    	myLog.myDuration.StartTimer();
    	
    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
    }


	public void LogFunctionStartDebug( String fps_FunctionName, String... fpsParameter )
	{
		FunctionCount++;
		AllCount++;
		
    	LogBase myLog = new LogFunctionDebug( Point2LogObject, fps_FunctionName, fpsParameter);

    	// Timer starten
    	myLog.myDuration.StartTimer();
    	
    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
	}


    public void LogTestcaseStart(String fps_FunctionName)
    {
		TestcaseCount++;
		AllCount++;
		
    	LogBase myLog = new LogTestcase( Point2LogObject, fps_FunctionName);
    	
    	// Timer starten
    	myLog.myDuration.StartTimer();

    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
    }
    

	public void LogFunctionEnd()
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();

    	@SuppressWarnings( "unused" )
		LogFunction myLogFunction = (LogFunction)Point2LogObject;
    	
    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}


	public void LogFunctionEndDebug()
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();

    	@SuppressWarnings( "unused" )
		LogFunctionDebug myLogFunction = (LogFunctionDebug)Point2LogObject;
    	
    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}


	public void LogFunctionEndDebug( Boolean fpb_Return )
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)Point2LogObject;
    	myLogFunction.setReturn( fpb_Return.toString());

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}
	

	public void LogFunctionEnd(Boolean Return)
    {
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)Point2LogObject;
    	myLogFunction.setReturn( Return.toString());

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
    }


	public void LogFunctionEnd( String fps_Return )
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)Point2LogObject;
    	myLogFunction.setReturn( fps_Return);

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}

	public void LogFunctionEndDebug( String fps_Return )
	{
	   	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)Point2LogObject;
    	myLogFunction.setReturn( fps_Return);

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
    }

	
	public void LogFunctionEnd( List<String> fps_Return )
	{
	   	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunction myLogFunction = (LogFunction)Point2LogObject;
    	
    	// TODO: ein ResultListstring hier einhängen
    	myLogFunction.setReturn( fps_Return.toString());

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}

	public void LogFunctionEndDebug( List<String> fps_Return )
	{
	   	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	LogFunctionDebug myLogFunction = (LogFunctionDebug)Point2LogObject;
    	
    	// TODO: ein ResultListstring hier einhängen
    	myLogFunction.setReturn( fps_Return.toString());

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
	}

    public void LogTestcaseEnd()
    {
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();

    	@SuppressWarnings( "unused" )
		LogTestcase myCheck = (LogTestcase)Point2LogObject;

    	if ( !(Point2LogObject.bError  || Point2LogObject.bException))
    	{
    		TestcasePass++;
    	}
    	Point2LogObject = Point2LogObject.getParent();
    }

    
    public void LogKeyWordStart(String fps_FunctionName, String... fpsParameter)
    {
		KeyWordCount++;
		AllCount++;
		
    	LogBase myLog = new LogKeyword( Point2LogObject, fps_FunctionName, fpsParameter);
    	
    	// Timer starten
    	myLog.myDuration.StartTimer();

    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
    }

    
    public void LogKeyWordEnd()
    {
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();

    	@SuppressWarnings( "unused" )
		LogKeyword myCheck = (LogKeyword)Point2LogObject;

    	if ( !(Point2LogObject.bError  || Point2LogObject.bException))
    	{
    		KeyWordPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
    }

    public void LogSequenceStart( String fpsKeywordName, String fpsWindowFN, String fps_SequensName, String... fpsParameter)
    {
		SequensCount++;
		AllCount++;
		
    	LogBase myLog = new LogSequence( Point2LogObject, fpsWindowFN, fps_SequensName, fpsParameter);
    	
    	// Timer starten
    	myLog.myDuration.StartTimer();

    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
    }

    
    public void LogSequenceEnd()
    {
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();

    	@SuppressWarnings( "unused" )
		LogSequence myCheck = (LogSequence)Point2LogObject;

    	if ( !(Point2LogObject.bError  || Point2LogObject.bException))
    	{
    		SequensPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
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

    
    private String getStatistics()
    {
    	StringBuilder myResult = new StringBuilder();
    	
    	myResult.append("<h2>Test Statistics</h2>\n");
 
    	
    	myResult.append("<p><table class='statistics'>\n");   	

    	myResult.append("\t<thead  class='statistics'>\n");
    	myResult.append("\t\t<tr class='statistics'>\n");    	
    	myResult.append("\t\t\t<th></th>\n");
    	myResult.append("\t\t\t<th width='60px'>Count</th>\n");
    	myResult.append("\t\t\t<th width='60px'>Pass</th>\n");
    	myResult.append("\t\t\t<th width='60px'>Fail</th>\n");
    	myResult.append("\t\t\t<th>Pass-Fail-Rate</th>\n");
    	myResult.append("\t\t</tr>\n");
    	myResult.append("\t</thead>\n");

    	
    	myResult.append("\t<tbody>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Errors:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + ErrorCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t</tr>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Exceptions:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + ExceptionCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t</tr>\n");

    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Warnings:</td>\n");
    	myResult.append("\t\t\t<td align='center'>" + WarningCount.toString() + "</td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t\t<td> </td>\n");
    	myResult.append("\t\t</tr>\n");
    	
    	myResult.append("\t\t<tr>\n");    	
    	myResult.append("\t\t\t<td align='right'>Testcases:</td>\n");
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

    	myResult.append("\t</tbody>\n");
    	myResult.append("</table></p>\n");
    	
       	return myResult.toString();
    }

    
    private String getFailPassBar(int FailCount, int PassCount)
    {
    	StringBuilder myResult = new StringBuilder();

    	float lfFailRate = FailCount * 100f / (FailCount + PassCount );
    	float lfPassRate = 100f - lfFailRate;
    	
    	myResult.append("<div class='pass-fail-graph'>\n");
    	myResult.append("\t<div class='pass-bar' style='width: " + String.format (Locale.ENGLISH, "%.2f", lfPassRate) + "%'></div>\n");
    	myResult.append("\t<div class='fail-bar' style='width: " + String.format (Locale.ENGLISH, "%.2f", lfFailRate) + "%'></div>\n");
    	myResult.append("</div>\n");
    	
    	return myResult.toString();
    }
    
    
    public void Result2HTML(String fpsFilename)
    {
    	HTML_File = fpsFilename;
    	Result2HTML();
    }
    
    
    public void Result2HTML()
    {
    	StringBuilder myResult = new StringBuilder();
    	
		try{
			
			myResult.append(getHTMLHeader());
			myResult.append(getStatistics());
    	
			myResult.append("<h2>Result Log</h2>\n");
			myResult.append(getResult());
			myResult.append(getHTMLFooter());
   

		    FileWriter fw = new FileWriter(HTML_File);
		    BufferedWriter bw = new BufferedWriter(fw);

		    bw.write( myResult.toString() );

		    bw.close();
			}
			catch(Exception e)
			{
			 System.out.print(e.getMessage());
			}
    }

    
	protected String getResult()
	{
		StringBuilder sbResult = new StringBuilder();
	
		for( LogBase myLog: this.myLogs )
		{
			sbResult.append( myLog.getResult() );
		}

		return sbResult.toString();
	}

	
	protected void SetFail()
	{
	}

	
	protected void SetPass()
	{
	}

	@Deprecated
	public void LogVerify( String fps_Actual, String fps_Expected )
	{
		AllCount++;
		
    	LogBase myLog = new LogVerify( Point2LogObject, fps_Actual, fps_Expected);

    	Point2LogObject.myLogs.add(myLog);
    	
 	}

	
	public void ResOpenList( String fps_ListHeader )
	{
		AllCount++;
		
    	LogBase myLog = new ResultList( Point2LogObject, fps_ListHeader);

    	// Timer starten
    	myLog.myDuration.StartTimer();
    	
    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
	}

	public void ResOpenListDebug( String fps_ListHeader )
	{
		AllCount++;
		
    	LogBase myLog = new ResultListDebug( Point2LogObject, fps_ListHeader);

    	// Timer starten
    	myLog.myDuration.StartTimer();
    	
    	Point2LogObject.myLogs.add(myLog);
    	Point2LogObject = myLog;
	}

	
	public void ResCloseList()
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	@SuppressWarnings( "unused" )
		ResultList myResultList = (ResultList)Point2LogObject;

    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
    	}

	
	public void ResCloseListDebug()
	{
    	// Timer Stoppen...
    	Point2LogObject.myDuration.StopTimer();
    	
    	@SuppressWarnings( "unused" )
		ResultListDebug myResultList = (ResultListDebug)Point2LogObject;
 
    	if ( (!Point2LogObject.bError)  || (!Point2LogObject.bException))
    	{
    		FunctionPass++;
    	}

    	Point2LogObject = Point2LogObject.getParent();
    	}


	public void setDebugMode( Boolean fpbDebugMode )
	{
		
	}
}

/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2020, IT-Beratung Hrabovszki
  www.OpenKeyWord.de
============================================================================== 

This file is part of OpenKeyWord.

OpenKeyWord is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

OpenKeyWord is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

Diese Datei ist Teil von OpenKeyWord.

OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
der GNU General Public License, wie von der Free Software Foundation,
Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
veröffentlichten Version, weiterverbreiten und/oder modifizieren.

OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
Siehe die GNU General Public License für weitere Details.

Sie sollten eine Kopie der GNU General Public License zusammen mit 
OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
 */

package okw.log.log2html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
		this.reset();
	}


	public Log2HTML( String featereName )
	{
		this.myDuration.startTimer();;
		this.name = featereName;

		Pointer2LogBaseStack.push(this);
		this.reset();
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


	public void LogError(String fpsMessage, String fps_Expected, String fps_Actual )
	{
		AllCount++;

		Pointer2LogBaseStack.peek().myLogs.add( new LogError(Pointer2LogBaseStack.peek(), fpsMessage, fps_Expected, fps_Actual ) );
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
	 * \date 2019-08-05
	 */
	public void LogStepStart( String categoryName, String categoryType, 
			String choiceValue, String featureName,
			String localCategoryName, String sourceExcerpt,
			String type )
	{
		AllCount++;

		LogBase myLog = new LogStep( Pointer2LogBaseStack.peek(), categoryName, categoryType, choiceValue, featureName, localCategoryName, sourceExcerpt, type );

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


	public void LogSequenceStart( String fpsKeywordName, String fpsWindowFN, String fpsSequenceName, String... fpsParameter)
	{
		AllCount++;

		LogBase myLog = new LogSequence( Pointer2LogBaseStack.peek(), fpsWindowFN, fpsSequenceName, fpsParameter);

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
			myLog.SequencePass();
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

		myResult.append("<!DOCTYPE html>\n");
		myResult.append("<html lang=\"en\">\n");
		myResult.append("<head>\n");
		myResult.append("\t<title>TestPage Titel</title>\n");

		// -----------------------------------------
		// OKW is utf-8 based...
		myResult.append("\t<meta charset=\"utf-8\"/>\n");

		// -----------------------------------------
		// insert Log2HTML.css direct into the HTML-Code: No link-refernce!

		myResult.append( "\t<style>\n" );
		myResult.append( getStyleSheet() );
		myResult.append( "\t</style>\n" );

		myResult.append("</head>\n");
		myResult.append("<body>\n");
		myResult.append( getFoldScript() );
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
		String lvsStartTime = "????-???-?? ??:??:??.???";
		String lvsEndTime = "????-???-?? ??:??:??.???";

		StringBuilder myResult = new StringBuilder();

		myResult.append("<h2>Test Statistics</h2>\n");


		myResult.append("<table class='statistics'>\n");   	

		myResult.append("\t<thead  class='statistics'>\n");
		myResult.append("\t\t<tr class='statistics'>\n");    	
		myResult.append("\t\t\t<th></th>\n");
		myResult.append("\t\t\t<th>Count</th>\n");
		myResult.append("\t\t\t<th colspan='3'></th>\n");
		myResult.append("\t\t</tr>\n");
		myResult.append("\t</thead>\n");


		// myResult.append("\t<tbody>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Errors:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + ErrorCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td colspan='3'></td>\n");
		myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Exceptions:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + ExceptionCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Warnings:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + WarningCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Passed:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + PassedCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td colspan='3'></td>\n");    	myResult.append("\t\t</tr>\n");


		myResult.append("\t\t<tr class='statistics'>\n");    	
		myResult.append("\t\t\t<th></th>\n");
		myResult.append("\t\t\t<th class='widthfix'>Count</th>\n");
		myResult.append("\t\t\t<th class='widthfix'>Pass</th>\n");
		myResult.append("\t\t\t<th class='widthfix'>Fail</th>\n");
		myResult.append("\t\t\t<th>Pass-Fail-Rate</th>\n");
		myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Test cases:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + TestcaseCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + TestcasePass.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + TestcaseFail.toString() + "</td>\n");
		myResult.append("\t\t\t<td>" + getFailPassBar(TestcaseFail, TestcaseCount - TestcaseFail) + "</td>\n");
		myResult.append("\t\t</tr>\n");


		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Sequences:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + SequenceCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + SequencePass.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + SequenceFail.toString() + "</td>\n");
		myResult.append("\t\t\t<td >" + getFailPassBar(SequenceFail, SequenceCount - SequenceFail) + "</td>\n");
		myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Keywords:</td>\n");
		myResult.append("\t\t\t<td class='center'>" + KeyWordCount.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + KeyWordPass.toString() + "</td>\n");
		myResult.append("\t\t\t<td class='center'>" + KeyWordFail.toString() + "</td>\n");
		myResult.append("\t\t\t<td>" + getFailPassBar(KeyWordFail, KeyWordCount-KeyWordFail) + "</td>\n");
		myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr class='statistics'>\n");    	
		myResult.append("\t\t\t<th  colspan='5'>Timer</th>\n");
		myResult.append("\t\t</tr>\n");

		lvsStartTime = this.myDuration.getStartTime();
		lvsEndTime = this.myDuration.getEndTime();

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>Start time:</td>\n");
		myResult.append("\t\t\t<td class='center' colspan='4'>" + lvsStartTime + "</td>\n");
		myResult.append("\t\t</tr>\n");

		myResult.append("\t\t<tr>\n");    	
		myResult.append("\t\t\t<td class='right'>End time:</td>\n");
		myResult.append("\t\t\t<td class='center' colspan='4'>" + lvsEndTime + "</td>\n");
		myResult.append("\t\t</tr>\n");
		myResult.append("</table>\n");

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


	public void old_Result2HTML(String fpsFilename)
	{

		StringBuilder myResult = new StringBuilder();

		try{

			StopAllTimerAndEmptyStack();

			myResult.append(getHTMLHeader());
			myResult.append(getHTMLStatistics());

			myResult.append("<h2>Result Log</h2>\n");
			myResult.append(getHTMLResult());
			myResult.append(getHTMLFooter());

			File fileDir = new File( fpsFilename );

			Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(fileDir), "UTF8"));

			out.append(myResult.toString());

			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

	public String Result2HTML( String fpsFilename )
	{

		StringBuilder myResult = new StringBuilder();

		try
		{

			StopAllTimerAndEmptyStack();

			myResult.append( getHTMLHeader() );
			myResult.append( getHTMLStatistics() );

			myResult.append( "<h2>Result Log</h2>\n" );
			myResult.append( getHTMLResult() );
			myResult.append( getHTMLFooter() );

			FileWriter fw = new FileWriter( fpsFilename );
			BufferedWriter bw = new BufferedWriter( fw );

			bw.write( myResult.toString() );

			bw.close();

		}
		catch (Exception e)
		{
			System.out.print( e.getMessage() );
		}

		return myResult.toString();
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
	protected void SequenceCount()
	{
		this.SequenceCount++;
	}

	@Override
	protected void SequenceFail()
	{
		this.SequenceFail++;
	}

	@Override
	protected void SequencePass()
	{
		this.SequencePass++;
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

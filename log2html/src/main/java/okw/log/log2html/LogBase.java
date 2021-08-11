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

import java.util.*;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;


public abstract class LogBase {
	
	protected static Integer AllCount = 0;

	protected Integer myID = 0;

	protected String Info = "";
	
	protected LogTimer myDuration = new LogTimer();
	
	// Ein Parent ist immer ein Knoten!
	protected LogBase myParent = null;

	protected List<LogBase> myLogs= new ArrayList<LogBase>();
	
	public void setParent( LogBase fpParent )
	{
		myParent = fpParent;
	}

	protected void abort()
	{
		setError();
	}
    
	
	public LogBase getParent()
	{
		return myParent;
	}

	
	protected int Level = -1;
	protected String myIndentionBase = "    ";
	
	protected int getLevel()
	{
		int myReturn;
			
		if (Level >= 0)
		{
			myReturn = Level;
		}
		else
		{
			if (this.getParent() != null )
			{
				this.Level = this.getParent().getLevel() + 1;
				myReturn = this.Level;
			}
			else
			{
				myReturn = 0;
			}
		}
		
		return myReturn;
	}


	protected String getLevelIndention()
	{
		StringBuilder myIndention = new StringBuilder();
		
		int n = this.getLevel();
		int i;
		
		for ( i=1; i<=n; i++ )
		{
			myIndention.append(myIndentionBase);
		}
		
		return myIndention.toString();
	}


    protected String getLevelIndention( int shift )
    {
        StringBuilder myIndention = new StringBuilder();
        
        int n = this.getLevel() + shift;
        int i;
        
        for ( i=1; i<=n; i++ )
        {
            myIndention.append(myIndentionBase);
        }
        
        return myIndention.toString();
    }    

	protected Boolean bWarning = false;
	
	protected void setWarning()
	{
		if (!bWarning)
		{
			bWarning = true;
		
		
			if (myParent != null)
			{
				myParent.setWarning();
			}
		}
	}

	protected Boolean getWarning()
	{
		return bWarning;
	}
	
	
	protected Boolean bException = false;

	protected void setException()
	{
		if (!bException)
		{
			//SetFail();
			bException = true;
		
			if (myParent != null)
			{
				myParent.setException();
			}
		}
	}


	protected Boolean bError = false;
	
	protected void setError()
	{
		if (!bError)
		{			
			// SetFail();
			bError = true;

			if (myParent != null)
			{
				myParent.setError();
			}
		}
	}

	protected Boolean getError()
	{
		return bError;
	}


	protected String getInfoAsHTML()
	{
		String lvsReturn = Markdown2HTML(getInfo());
		
		return lvsReturn;
	}

	protected String getInfo()
	{
		return escapeHTML(Info);
	}
	
	static String Markdown2HTML(String fpsMarkdown)
	{
		String lvsReturn;

		if ( fpsMarkdown != null ) {
			Parser parser = Parser.builder().build();
			Node document = parser.parse( fpsMarkdown );
			HtmlRenderer renderer = HtmlRenderer.builder().build();
			lvsReturn = renderer.render(document);
			
			// <p> -Paragraf entfernen...
			lvsReturn = lvsReturn.replaceAll("^<p>", "").replaceAll("</p>$", "").trim();
		}
		else
		{
			lvsReturn = "";
		}
		
		
		return lvsReturn;
	}
	
    // Node Statistics
    protected abstract void ErrorCount();
 
    protected abstract void ExceptionCount();
  
    protected abstract void WarningCount();

    protected abstract void PassedCount();

    protected abstract void PrintCount();
    
    protected abstract void TestcaseCount();

    protected abstract void TestcaseFail();
    
    protected abstract void TestcasePass();

    protected abstract void FunctionCount();

    protected abstract void FunctionFail();

    protected abstract void FunctionPass();
    
    protected abstract void KeyWordCount();

    protected abstract void KeyWordFail();

    protected abstract void KeyWordPass();
    
    protected abstract void SequenceCount();

    protected abstract void SequenceFail();

    protected abstract void SequencePass();

    protected abstract void StepCount();
    
    protected abstract void StepFail();
    
    protected abstract void StepPass();

    // Precondition
    protected abstract void LocalACCallCount();
    
    protected abstract void LocalACCallFail();
    
    protected abstract void LocalACCallPass();
    
    // Postcondition
    protected abstract void RemoteACCallCount();
    
    protected abstract void RemoteACCallFail();
    
    protected abstract void RemoteACCallPass();

	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		//sbResult.append( lvsIndention + "<blockquote class='" + this.getClass().getSimpleName() + "'>\n" );
		
		sbResult.append( lvsIndention + "<div class='" + this.getClass().getSimpleName() + "'>\n" );
		sbResult.append( lvsIndention + myIndentionBase  +"<div class='Header'>\n" );
		
		if (!this.myLogs.isEmpty())
		{
			sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase + "<div class='FoldMe' onClick='div_change(" + myID.toString() + ")'></div>\n" );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Duration'>" + this.myDuration.getSeconds("#0.000") + " s</div>" );
		
		// Exception-icon einfügen wenn bException = true
		if (this.bException)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ExceptionSign' title='Exception...'></div>\n" );
		}
		
		// Error-icon einfügen wenn bError = true
		if (this.bError)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='ErrorSign' title='Error...'></div>\n" );
		}
		
		if (this.bWarning)
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='WarningSign' title='Warning...'></div>\n" );
		}

		if (this.bException || this.bError )
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Fail'>" + getInfoAsHTML() + "</div>\n" );
		}
		else
		{
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='SuccessSign' title='Success...'></div>\n" );
			sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "<div class='Info_Pass'>" + getInfoAsHTML() + "</div>\n" );
		}

		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Header
		

		sbResult.append( lvsIndention + myIndentionBase +  myIndentionBase +"<div class='Body' id='" + myID.toString() +"' style='display: none;'>\n" );
		
		for( LogBase myLog: this.myLogs )
		{
			sbResult.append( myLog.getHTMLResult() );
		}
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Body
		
		sbResult.append( lvsIndention + myIndentionBase + myIndentionBase + "</div>\n" ); // end Rahmen		
		//sbResult.append( lvsIndention + "</blockquote>\n");
		
		return sbResult.toString();
	}
	
	public static final String escapeHTML(String s){
		   StringBuffer sb = new StringBuffer();
		   int n = s.length();
		   for (int i = 0; i < n; i++) {
		      char c = s.charAt(i);
		      switch (c) {
		         case '<': sb.append("&lt;"); break;
		         case '>': sb.append("&gt;"); break;
		         case '&': sb.append("&amp;"); break;
		         case '"': sb.append("&quot;"); break;
		         case 'à': sb.append("&agrave;");break;
		         case 'À': sb.append("&Agrave;");break;
		         case 'â': sb.append("&acirc;");break;
		         case 'Â': sb.append("&Acirc;");break;
		         case 'ä': sb.append("&auml;");break;
		         case 'Ä': sb.append("&Auml;");break;
		         case 'å': sb.append("&aring;");break;
		         case 'Å': sb.append("&Aring;");break;
		         case 'æ': sb.append("&aelig;");break;
		         case 'Æ': sb.append("&AElig;");break;
		         case 'ç': sb.append("&ccedil;");break;
		         case 'Ç': sb.append("&Ccedil;");break;
		         case 'é': sb.append("&eacute;");break;
		         case 'É': sb.append("&Eacute;");break;
		         case 'è': sb.append("&egrave;");break;
		         case 'È': sb.append("&Egrave;");break;
		         case 'ê': sb.append("&ecirc;");break;
		         case 'Ê': sb.append("&Ecirc;");break;
		         case 'ë': sb.append("&euml;");break;
		         case 'Ë': sb.append("&Euml;");break;
		         case 'ï': sb.append("&iuml;");break;
		         case 'Ï': sb.append("&Iuml;");break;
		         case 'ô': sb.append("&ocirc;");break;
		         case 'Ô': sb.append("&Ocirc;");break;
		         case 'ö': sb.append("&ouml;");break;
		         case 'Ö': sb.append("&Ouml;");break;
		         case 'ø': sb.append("&oslash;");break;
		         case 'Ø': sb.append("&Oslash;");break;
		         case 'ß': sb.append("&szlig;");break;
		         case 'ù': sb.append("&ugrave;");break;
		         case 'Ù': sb.append("&Ugrave;");break;         
		         case 'û': sb.append("&ucirc;");break;         
		         case 'Û': sb.append("&Ucirc;");break;
		         case 'ü': sb.append("&uuml;");break;
		         case 'Ü': sb.append("&Uuml;");break;
		         case '®': sb.append("&reg;");break;         
		         case '©': sb.append("&copy;");break;   
		         case '€': sb.append("&euro;"); break;
		         // be carefull with this one (non-breaking whitee space)
		         case ' ': sb.append("&nbsp;");break;         
		         
		         default:  sb.append(c); break;
		      }
		   }
		   return sb.toString();
		}
}

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

import org.apache.commons.text.StringEscapeUtils;

public class LogSourceLocation extends LogBaseLeaf
{
    
    private String Start = "";
    private String End = "";
    private String featureName = "";
    private String sourceType = "";
	
	protected LogSourceLocation( LogBase fpParent, String Start, String End, String featureName, String sourceType )
	{
		myID = AllCount;
		this.setParent(fpParent);
		this.Start = Start;
		this.End = End;
		this.featureName = End;
		this.sourceType = sourceType;
	}

	
	protected String getHTMLResult()
	{
		StringBuilder sbResult = new StringBuilder();
		
		String lvsIndention = this.getLevelIndention();
		
		sbResult.append( lvsIndention + myIndentionBase + "<p class='LogPassed'>" + StringEscapeUtils.escapeHtml4(this.Info) + "</p>\n" );
		
		return sbResult.toString();
	}

   @Override 
   protected String getJSONResult()
    {
        StringBuilder myJSON = new StringBuilder();
                    
        myJSON.append( this.jsonElementComma( "Start",  this.Start ) );
        myJSON.append( this.jsonElementComma( "End",  this.End ) );
        myJSON.append( this.jsonElementComma( "featureName",  this.featureName ) );
        myJSON.append( this.jsonElement( "sourceType",  this.sourceType ) );
        
        return myJSON.toString();
    }
}

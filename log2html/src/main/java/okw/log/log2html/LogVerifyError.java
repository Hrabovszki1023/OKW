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

import okw.OKW_Properties;

public class LogVerifyError extends LogBaseLeaf
{
	protected Boolean bVerification = false;
	protected String Expected = "";
	protected String Actual = "";
	
    protected LogVerifyError( LogBase fpParent, String fps_Expected, String fps_Actual )
    {
        Info = OKW_Properties.getInstance().getProperty( "ok.LogVerifyError.ExpectedActuel.${LANGUAGE}", null, fps_Expected,  fps_Actual );
        myID = AllCount;
        setParent(fpParent);
        
        bVerification = true;
        Expected = fps_Expected;
        Actual = fps_Actual;
        
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

        if ( bVerification )
        {
        	sbResult.append( lvsIndention + myIndentionBase 
        			+ "<p class='LogError'>" 
        			   + StringEscapeUtils.escapeHtml4(this.Info) + "<br>\n"
        			   + "Expected = " + this.Expected + "<br>\n"
        			   + "Actual = " + this.Actual + "<br>\n"
        			+ "</p>\n" );
        }
        else
        {
        	sbResult.append( lvsIndention + myIndentionBase + "<p class='LogError'>" + StringEscapeUtils.escapeHtml4(this.Info) + "</p>\n" );
        }
        
        return sbResult.toString();
    }
}

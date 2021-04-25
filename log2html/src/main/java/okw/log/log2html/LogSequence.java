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
		
		this._Info = StrBuilder.toString();		
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
        myJSON.append( this.jsonElementComma( "info", this.getInfo() ) );
        
        return myJSON.toString();
    }
 }

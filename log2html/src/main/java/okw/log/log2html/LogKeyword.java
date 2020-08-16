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

public class LogKeyword extends LogBaseNode
{
    private String type = "Keyword";
    private String Keyword;
    private String[] Parameter;

	LogKeyword( LogBase Parent, String fpsKeyword, String... fpsParameter )
	{
		setParent( Parent );
		myID = AllCount;
		
		Keyword = fpsKeyword;
		Parameter = fpsParameter;
		
	      // inkrementieren KeyWordCount
        this.KeyWordCount();

		StringBuilder StrBuilder = new StringBuilder();

		StrBuilder.append( fpsKeyword + ": " );

		if ( fpsParameter.length == 2 )
		{
			StrBuilder.append( "'" + fpsParameter[0] + "' = '" + fpsParameter[1] + "'" );
		}
		else
		{
			for ( String sParameter : fpsParameter )
			{
				StrBuilder.append( " '" + sParameter + "'" );
			}
		}

		this.Info = StrBuilder.toString();
	}

    @Override
    protected String getJSONNodeProperties()
    {
        StringBuilder myJSON = new StringBuilder();
        
        myJSON.append( this.jsonElementComma( "type", this.type ) );
        myJSON.append( this.jsonElementComma( "info", this.Info ) );
        myJSON.append( this.jsonElementComma( "Keyword", this.Keyword ) );

        for ( Integer i = 0; i < Parameter.length; i++) { 
            
            myJSON.append( this.jsonElementComma( "Parameter" + i.toString(), Parameter[i] ) );
        } 
        return myJSON.toString();
    }
	
    
  @Override
  protected void ErrorCount()
  {
      ErrorCount++;

      this.KeyWordFail();
      
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

      this.KeyWordFail();
      
      this.bException = true;
      
      if ( myParent != null)
      {
          myParent.ExceptionCount();
      }
  }
}

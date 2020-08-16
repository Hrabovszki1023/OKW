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
package okw.gui.adapter.selenium;

import java.util.*;

import org.openqa.selenium.Keys;

public class SeTypeKeysCharSequence
{

    /**
     * @param isALT the isALT to set
     */
    public void setALT( )
    {
        value.add( Keys.ALT );
    }


    /**
     * @param isCTRL the isCTRL to set
     */
    public void setCTRL( )
    {
        value.add( Keys.CONTROL );
    }


    /**
     */
    public void setSHIFT( )
    {
        value.add( Keys.SHIFT );
    }

    public void setCOMMAND( )
    {
        value.add( Keys.COMMAND );
    }


    private String charSequence = new String();
    
    ArrayList<CharSequence> value = new ArrayList<CharSequence>();

    public SeTypeKeysCharSequence()
    {
        reset();
    }

    public void reset()
    {
        value.clear();
        
        return;
    }
    
    public void setText( String Text )
    {
        value.add( Text );
    }

    public String getCharSequenze()
    {
        charSequence = Keys.chord( value );
        return charSequence;
    }


    public void setKeyvalue( String lvsReturn )
    {
            value.add( Keys.valueOf( lvsReturn ) );
            return;
    }
}

package okw.gui;

/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

import okw.log.*;
import org.stringtemplate.v4.*;


/** <summary>
 * Description of OKWLocator.
 * </summary>
 */
public class OKWLocator //: IOKWLocator
{
    private String        _locator = "";

    private OKWLocator[]  _Locatoren;

    private Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

    public OKWLocator( String fpsLocator, OKWLocator... fpLocators )
    {
        _locator = fpsLocator;

        if ( fpLocators != null )
        {
            _Locatoren = fpLocators;
        }
    }

    /** \~german
     *  Holt den vollständig (rekursiv) aufgelösten  (z.B. XPath-Wert) des Locators.
     *  
     *  Beim Aufruf dieser Methode wird der Locator jeweils vollständig neu berechnet 
     *  und der aktuelle Wert zurückgeliefert.
     *  (Dynamischer Locator)
     *  
     *  @return Aktueller Wert des Locators
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     *
    public String getLocator()
    {
        myLogger.LogFunctionStartDebug( "getLocator()" );
        String lvsReturn = "";

        ArrayList<String> myLocatoren = new ArrayList<String>();

        if ( _Locatoren != null )
        {
            for ( OKWLocator Locator : _Locatoren )
            {
                myLocatoren.add( Locator.getLocator() );
            }

            lvsReturn = String.format( _locator, myLocatoren.toArray() );
        }
        else
        {
            lvsReturn = _locator;
        }

        myLogger.LogFunctionEndDebug( lvsReturn );
        return lvsReturn;
    }*/

    /** \~german
     *  Holt den vollständig (rekursiv) aufgelösten  (z.B. XPath-Wert) des Locators.
     *  
     *  Beim Aufruf dieser Methode wird der Locator jeweils vollständig neu berechnet 
     *  und der aktuelle Wert zurückgeliefert.
     *  (Dynamischer Locator)
     *  
     *  @return Aktueller Wert des Locators
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    public String getLocator()
    {
        myLogger.LogFunctionStartDebug( "getLocator()" );
        String lvsReturn = "";

        //ArrayList<String> myLocatoren = new ArrayList<String>();

        if ( _Locatoren != null )
        {
            ST st = new ST(_locator, '$', '$');

            Integer i = 1;
            
            for ( OKWLocator Locator : _Locatoren )
            {
                st.add("L" + i.toString() , Locator.getLocator());
                i++;
            }

            lvsReturn = st.render();
        }
        else
        {
            lvsReturn = _locator;
        }

        myLogger.LogFunctionEndDebug( lvsReturn );
        return lvsReturn;
    }    
    

    /** \~german
     *  Setzt den Wert (z.B. XPath-Wert) des Locators.
     *  
     *  
     *  \~english
     *  \brief
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    public void setLocator( String value )
    {
        myLogger.LogFunctionStartDebug( "Get locator" );
        _locator = value;
        myLogger.LogFunctionEndDebug();
    }
}

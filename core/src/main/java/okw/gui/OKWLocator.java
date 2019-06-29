package okw.gui;

/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

    /**  \~german
     * 
     * Beispiel 1: Ein einfacher Locator
     * 
     * L1 enthält den konstnaten XPATH-Wert "//*[contains(@name,'name')]".
     * <code>
     *  OKWLocator L1 = new OKWLocator( "//*[contains(@name,'name')]" );
     * </code>
     * 
     * Beispiel 2: Ein einfache verknüpfter Locator
     * 
     * Window kann mit dem konstnaten XPATH-Wert "//*[contains(@id,'widnow')]" identifiziert werden.
     * Child kann mit dem konstnaten XPATH-Wert "//*[contains(@id,'child')]" erkannt werden. Child kann jedoch
     * in mehrerern Fenstern existieren.
     * 
     * Durch das Verbinden der XPATH Werte Window und Child, kann Child eindeutig
     * erkannt werden:
     * <code>
     * OKWLocator LWindow = new OKWLocator( "//*[contains(@name,'name')]" );
     * OKWLocator LChild = new OKWLocator( "$L1$//*[contains(@contains(@id,'child')]", LWindow );
     * </code>
     * 
     * LChild.getLocator liefert den Wert //*[contains(@name,'name')]//*[contains(@id,'child')].
     * $L1$ markiert die stelle wo LWindow eingestezt werden soll.
     * 
     * Beispiel 3: Dynamischer Locator
     * 
     * Es gibt GUI-Objekte, deren GUI-erkennungseigenschaft von aktuellen Werten abhängt.
     * D.h. Ein spezifischer kleiner aber entscheidender Teil des XPATH ist bis zur konkreten
     * Anwendung unbekannt. Erst mit der konkreten Auswahl eines Wertes wird dieser dynamische Teil
     * bekannt. 
     * 
     * 1. "Child" hat den folgenden konstnaten XPATH-Wert "$L1$//*[contains(@name,'$L2$')]".
     *     An der Stelle "$L1$" wird Window und an der Stelle "$L2$" wird DynName eingesetzt.
     * 2. "Window" kann mit dem konstnaten XPATH-Wert "//*[contains(@id,'widnow')]" identifiziert werden.
     * 3. "DynName" den.
     * 
     * Durch das Verbinden der XPATH Werte Window und Child, kann Child eindeutig
     * erkannt werden:
     * <code>
     * OKWLocator LWindow = new OKWLocator( "//*[contains(@name,'name')]" );
     * OKWLocator LDyName = new OKWLocator( "" );
     * OKWLocator LChild = new OKWLocator( "$L1$//*[contains(@id,'child')]", LWindow, LDyName );
     * </code>
     * 
     * LChild.getLocator liefert zunächst den Wert "//*[contains(@name,'name')]//*[contains(@id,'')]".
     * LDyName enthält im Initialzustande den Leeren Locator Wert "".
     * 
     * Dieser kann nun dynamisch angepasst werden: 
     * Mit LDyName.setLocator("myValue") kann ein neure Wert für LDyName gestezt werden.
     * 
     * LChild.getLocator liefert nun den Wert "//*[contains(@name,'name')]//*[contains(@id,'myValue')]".
     * 
     *  \~english
     * Description of OKWLocator.
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
public class OKWLocator extends OKWLocatorBase
{
    /**
     * Base Locator
     */
    protected String           _locator = null;

    /**
     * List of reference Locators
     */
    protected OKWLocatorBase[] _Locators = null;

    protected Logger_Sngltn myLogger = Logger_Sngltn.getInstance();


    public OKWLocator(  )
    {
    }
    
    
    public OKWLocator( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        setLocator( fpsLocator, fpLocators );
    }

    /** \~german
     *  Holt den vollständig (rekursiv) aufgelösten des Locators.
     *  
     *  Beim Aufruf dieser Methode wird der Locator jeweils vollständig neu berechnet 
     *  und der aktuelle Wert zurückgeliefert.
     *  (dynamischer Locator)
     *  
     *  @return Aktueller Wert des Locators
     *  
     *  \~english
     *  Fetches the completely (recursively) resolved (e.g. XPath value) of the locator.
     *  
     *  When this method is called, the locator is recalculated
     *  completely and the current value is returned.
     *  (dynamic locator)
     *  
     *  @return Current value of the locator
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    public String getLocator()
    {
        myLogger.LogFunctionStartDebug( "getLocator()" );
        String lvsReturn = "";

        if ( _Locators != null )
            {
                ST st = new ST( _locator, '$', '$' );

                    Integer i = 1;

                    for ( OKWLocatorBase Locator : _Locators )
                    {
                        st.add( "L" + i.toString(), Locator.getLocator() );
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
     *  Setzt den Wert (z.B. XPath-Wert) des Locators und die eingebtteten Referenzen
     *  
     *  Hinweis: Durch weglassen von fpLocators wird nur fpsLocator gesetzt.
     *  Wenn bereits fpLocators in der Klasse vorhanden sind dann werden diese nicht verändert.
     *  Stichwort Dynamische Locatoren.
     *  
     *  \~english
     *  @todo TODO:  Übersetzung ins Englische fehlt...
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    public void setLocator( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        myLogger.LogFunctionStartDebug( "OKWLocator.setLocator" );

        _locator = fpsLocator;

        if ( fpLocators.length != 0 )
        {
            this.setLocators( fpLocators );
        }

        myLogger.LogFunctionEndDebug();
    }

    
    /** \~german
     *  Setzt den Wert (z.B. XPath-Wert) des Locators.
     *  
     * @param fpLocators Referenz Lokatoren. $L1$, $L2$, ... $Ln$ referenzieren auf diese.
     *  
     * \~english
     * @param fpLocators Reference Locators. $L1$, $L2$, ...  $Ln$ refer to them.
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2014.04.27
     */
    @Override
    public void setLocators( OKWLocatorBase... fpLocators )
    {
        myLogger.LogFunctionStartDebug( "OKWLocator.setLocators" );

        // if ( fpLocators.length != 0 )
        if ( fpLocators != null )
        {
            _Locators = fpLocators;
        }

        myLogger.LogFunctionEndDebug();
    }

    /** \~german
     *  Copiert bzw, überträgt die Werte des fpSource Locators auf die Aktuelle Instanz.
     *  
     *  \~english
     *  Copies or transfers the values of the fpSource locator to the current instance.
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2019.06.27
     */
    @Override
    public void copyLocator( OKWLocatorBase fpSource )
    {
        myLogger.LogFunctionStartDebug( "OKWLocator.copyLocator" );

        this.setLocator( fpSource.getlocator() );
        this.setLocators(fpSource.getLocators());

        myLogger.LogFunctionEndDebug();
    }

    /** \~german
     *  gettet den Basis-Locator.
     *  
     *  \~english
     *  gettet the base locator.
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2019.06.27
     */        
    @Override
    public String getlocator()
    {
        // TODO Auto-generated method stub
        return this._locator;
    }


    /** \~german
     *  gettet die Referenz Locatoren als Liste.
     *  
     *  \~english
     *  gets the reference locators as a list.
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  @date 2019.06.27
     */    
    @Override
    public OKWLocatorBase[] getLocators()
    {
        // TODO Auto-generated method stub
        return this._Locators;
    }
}

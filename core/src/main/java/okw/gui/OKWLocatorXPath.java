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

package okw.gui;

import okw.fourTestLocator;

public class OKWLocatorXPath extends OKWLocator
{
 
    public OKWLocatorXPath( )
    {
        super(  ) ;
    }
    
    public OKWLocatorXPath( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        super( fpsLocator, fpLocators ) ;
    }
    

    /** 
     * \~german
     *  Konstruktor der Klasse. iframeID wird auf den Wert "" (empty string) gesetzt.
     *  
     *  @note
     *  <code> fpsLocator = "//div[@ID='myID']"</code> -> <code>"//div[@ID='myID']"</code>
     *  <code> fpsLocator = "4T!MyValue"</code> -> <code>"//*[@data-harmony-id='MyValue']"</code>
     *  <code> fpsLocator = "4TNA!MyValue"</code> -> <code>"//*[contains( @name, 'MyValue']"</code>
     *  <code> fpsLocator = "4TID!MyValue"</code> -> <code>"//*[contains( @ID, 'MyValue']"</code>
     *  <code> fpsLocator = "4TLA!MyValue"</code> -> <code>"//label[contains(text(),'MyValue')]/following-sibling::input"</code>
     *  <code> fpsLocator = "4TTX!MyValue"</code> -> <code>"//*[contains(text(),'MyValue')]"</code>
     *  
     *  @param Locator definiert die Objekterkennungseigenschaft des Objektes. Dieser wird als XPATH angegeben
     *  @param Locators Locatoren z.B. von Elternobjekten, die zu einem gesamt Locator verkettet werden sollen.
     *  
     *  \~english
     *  
     *  \~
     *  @author Zoltán Hrabovszki
     *  \date 2019.03.28
     */
     @Override
     public void setLocator( String fpsLocator, OKWLocatorBase... fpLocators )
    {
        fourTestLocator fourTestLocator = new fourTestLocator( fpsLocator );


         String myLocator = fourTestLocator.getLocator();
         
         // Enthält xpath oder ein 4Test-Präfix?
         if ( fpsLocator.equals( myLocator ) )
         {
             // Ja es ist ein normaler XPath
             if ( fpLocators != null && fpLocators.length > 0 )
             {
                 super.setLocator( myLocator, fpLocators );
             }
             else
             {
                 super.setLocator( myLocator );
             }
         }
         else
         {
             if ( fpLocators != null && fpLocators.length > 0 )
             {
                 super.setLocator( "$L1$" + myLocator, fpLocators );
             }
             else
             {
                 super.setLocator( myLocator );
             }
         }
     }

}

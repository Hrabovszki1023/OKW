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

import okw.OKW;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.webdriver.SeALERTACCEPT;
import okw.gui.adapter.selenium.webdriver.SeALERTDATA;
import okw.gui.adapter.selenium.webdriver.SeALERTDISMISS;
import okw.gui.adapter.selenium.webdriver.SeALERTMESSAGE;
import okw.gui.adapter.selenium.webdriver.SeBACK;
import okw.gui.adapter.selenium.webdriver.SeMAXIMIZE;
import okw.gui.adapter.selenium.webdriver.SePOSITION;
import okw.gui.adapter.selenium.webdriver.SeSIZE;
import okw.gui.adapter.selenium.webdriver.SeURL;

/** 
 * @ingroup groupSeleniumWindowGUIAdapter
 * TODO: class SeBrowserChild dokumentieren...
 */
public class SeBrowserChild extends SeAnyWindow
{
    // The class for the window that contains the contents of the Web page.
    public OKWLocator locator;

    @OKW( FN = "URL" )
    public SeURL URLold = new SeURL();

    @OKW( FN = "#URL", VerifyExists_TO = 1, VerifyExists_PT = 500 )
    public SeURL      URL      = new SeURL();
    
    @OKW( FN = "BACK")
    public SeBACK BACK = new SeBACK();

    @OKW( FN = "MAXIMIZE")
    public SeMAXIMIZE MAXIMIZE = new SeMAXIMIZE();

    @OKW( FN = "SIZE")
    public SeSIZE SIZE = new SeSIZE();

    @OKW( FN = "POSITION")
    public SePOSITION POSITION = new SePOSITION();
    
    // Implement Alert Handling
    @OKW( FN = "#Alert message")
    public SeALERTMESSAGE ALERTMESSAGE = new SeALERTMESSAGE();

    @OKW( FN = "#Alert input")
    public SeALERTDATA ALERTDATA = new SeALERTDATA();
    
    @OKW( FN = "#Alert Cancel")
    public SeALERTDISMISS ALERTDISMISS = new SeALERTDISMISS();

    @OKW( FN = "#Alert OK")
    public SeALERTACCEPT ALERTACCEPT = new SeALERTACCEPT();
    
    
    @Override
    public void SelectWindow()
    {
        if ( !this.WaitForMe() )
        {
            ResOpenList( "GUI-Object not found..." );
            LogPrint( "Locator: '" + this.getLocator() + "'" );
            ResCloseList();

            throw new OKWGUIObjectNotFoundException( "BrowserChild not found!" );
        }
    }
}

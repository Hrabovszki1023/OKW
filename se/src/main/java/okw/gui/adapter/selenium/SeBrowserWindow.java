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

package okw.gui.adapter.selenium;

import okw.OKW;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.adapter.selenium.webdriver.*;

/** 
 * @ingroup groupSeleniumWindowGUIAdapter
 * Abstrakte Basisklasse für SeBrowserTypen
 * 
 * Implementiert Virtuelle GUI-Adapter
 * 
 *  - URL - Url-EingabeFeld (wie ein Eingabefeld)
 *  - BACK - Fenster Zurück  (wie ein Link oder Pushbutton)
 *  - MAXIMIZE - Browser-Größe Maximieren  (wie ein Link oder Pushbutton)
 *  - SIZE - Angabe der Fenster-Position (wie ein Eingabefeld)
 *  - POSITION - Angabe der Fenster-Position  (wie ein Eingabefeld)
 */
public class SeBrowserWindow extends SeAnyWindow
{
    @OKW( FN = "URL", VerifyExists_TO=1, VerifyExists_PT=500 )
    public SeURL URL = new SeURL();
    
    @OKW( FN = "BACK", VerifyExists_TO=1, VerifyExists_PT=500 )
    public SeBACK BACK = new SeBACK();

    @OKW( FN = "MAXIMIZE", VerifyExists_TO=1, VerifyExists_PT=500 )
    public SeMAXIMIZE MAXIMIZE = new SeMAXIMIZE();

    @OKW( FN = "SIZE", VerifyExists_TO=1, VerifyExists_PT=500 )
    public SeSIZE SIZE = new SeSIZE();

    @OKW( FN = "POSITION", VerifyExists_TO=1, VerifyExists_PT=500 )
    public SePOSITION POSITION = new SePOSITION();
    
    @Override
    public void SelectWindow()
    {
        if ( !this.WaitForMe() )
        {
            this.MyLogger.ResOpenList( "GUI-Object not found..." );
            this.MyLogger.LogPrint( "Locator: '" + this.getLocator() + "'" );
            this.MyLogger.ResCloseList();

            throw new OKWGUIObjectNotFoundException( "BrowserChild not found!" );
        }
    }
}

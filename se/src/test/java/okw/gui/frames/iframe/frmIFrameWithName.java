/*
 ==============================================================================
 Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

package okw.gui.frames.iframe;

import okw.OKW;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeButton;
import okw.gui.adapter.selenium.SeInputText;

/** \~german
 *  GUI-Frame für die OKW-Testseite <a href="http://test.openkeyword.de/iframe/iframe.htm">http://test.openkeyword.de/iframe/iframe.htm</a> 
 *  
 *  \~english
 *  GUI-Frame for the OKW-test page <a href="http://test.openkeyword.de/iframe/iframe.htm">http://test.openkeyword.de/iframe/iframe.htm</a> 
 *  \~
 *  @author Zoltán Hrabovszki
 *  \date 2019.02.28
 */
@OKW( FN = "IFrameWithName" )
public class frmIFrameWithName extends SeBrowserChild
{
    /** \~german
     * Anzeigefeld im Fenster: Enthält Werte nach dem Klick auf "Button 1" und "Button 2". Dient zur Prüfung der Button-Klicks geprüft werden.
     * 
     * \~english
     * Display TextField: Contains values after you click the "Button 1" and "Button 2".
     */
    @OKW( FN = "Display", WaitForMe_PT = 500, WaitForMe_TO = 1 )
    public SeInputText Anzeige  = new SeInputText( "//*[@data-4test='textarea']" );

    @OKW( FN = "Button 1", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public SeButton    Text_1   = new SeButton( "//*[@data-4test='Button 1']" );

    @OKW( FN = "Button 2", VerifyLabel_PT = 500, VerifyLabel_TO = 3, VerifyIsActive_PT = 500, VerifyIsActive_TO = 3, VerifyValue_PT = 500, VerifyValue_TO = 3, VerifyTooltip_PT = 500, VerifyTooltip_TO = 3, VerifyCaption_PT = 500, VerifyCaption_TO = 3, VerifyExists_PT = 500, VerifyExists_TO = 3, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 3 )
    public SeButton    Text_2   = new SeButton( "//*[@data-4test='Button 2']" );

    @OKW( FN = "User", WaitForMe_PT = 500, WaitForMe_TO = 1, VerifyLabel_PT = 500, VerifyLabel_TO = 3, VerifyIsActive_PT = 500, VerifyIsActive_TO = 3, VerifyValue_PT = 500, VerifyValue_TO = 3, VerifyTooltip_PT = 500, VerifyTooltip_TO = 3, VerifyCaption_PT = 500, VerifyCaption_TO = 3, VerifyExists_PT = 500, VerifyExists_TO = 3, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 3 )
    public SeInputText User     = new SeInputText( "//*[@data-4test='User']" );

    @OKW( FN = "Password", WaitForMe_PT = 500, WaitForMe_TO = 1, VerifyLabel_PT = 500, VerifyLabel_TO = 3, VerifyIsActive_PT = 500, VerifyIsActive_TO = 3, VerifyValue_PT = 500, VerifyValue_TO = 3, VerifyTooltip_PT = 500, VerifyTooltip_TO = 3, VerifyCaption_PT = 500, VerifyCaption_TO = 3, VerifyExists_PT = 500, VerifyExists_TO = 3, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 3 )
    public SeInputText Password = new SeInputText( "//*[@data-4test='Password']" );

    /**
     * URL des Fensters: http://test.openkeyword.de/InputButton/input_type-button.htm
     */
    public frmIFrameWithName()
    {
        setLocator( "//*[@data-4test='iframeWithName.htm']" );
    }
}
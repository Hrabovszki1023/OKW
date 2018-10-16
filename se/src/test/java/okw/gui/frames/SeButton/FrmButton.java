/*
 ==============================================================================
 Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

package okw.gui.frames.SeButton;

import okw.OKW;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeButton;
import okw.gui.adapter.selenium.SeInputText;

// \~german
// \brief GUI-Frame für die OKW-Testseite <a href="http://test.openkeyword.de/Button/button.htm">test.openkeyword.de/Button/button.htm</a> 
//
// \~english
// \brief GUI-Frame for the OKW-test page <a href="http://test.openkeyword.de/Button/button.htm">test.openkeyword.de/Button/button.htm</a> 
// \~
// \author Zoltán Hrabovszki
// \date 2016.09.06
@OKW( FN = "Button" )
public class FrmButton extends SeBrowserChild
{
  /** \~german
   * Anzeigefeld im Fenster: Enthält Werte nach dem Klick auf "Button 1" und "Button 2". Dient zur Prüfung der Button-Klicks geprüft werden.
   * 
   * \~english
   * \brief 
   * Display TextField: Contains values after you click the "Button 1" and "Button 2".
   */
  @OKW( FN = "Display", WaitForMe_PT= 500, WaitForMe_TO=1 )
  public SeInputText   Anzeige        = new SeInputText( "//*[@data-fn='textarea']" );

  /*
   * \~german
   * Nicht vorhandes Button für eine nicht Existenz zu prüfen.
   *
   * \~english
   * Not existing text box to verify the non-existence.
   */
  @OKW( FN = "Does Not Exists",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
           )
  public SeButton NichtVorhanden = new SeButton( "//*[@name='NichtVorhanden']" );

  @OKW( FN = "Text_1",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
          )
  public SeButton Text_1         = new SeButton( "//*[@data-fn='Button 1']" );

  @OKW( FN = "Text_2",
          VerifyLabel_PT=500, VerifyLabel_TO=3,
          VerifyIsActive_PT=500, VerifyIsActive_TO=3,
          VerifyValue_PT=500, VerifyValue_TO=3,
          VerifyTooltip_PT=500, VerifyTooltip_TO=3,
          VerifyCaption_PT=500, VerifyCaption_TO=3,
          VerifyExists_PT=500, VerifyExists_TO=3,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=3
          )
  public SeButton Text_2         = new SeButton( "//*[@data-fn='Button 2']" );

  @OKW( FN = "Button_3",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
           )
  public SeButton Button_3       = new SeButton( "//*[@data-fn='Button 3']" );

  /**
   * URL des Fensters: http://test.openkeyword.de/InputButton/input_type-button.htm
   */
  public FrmButton()
  {
    setLocator( "//title[contains(text(),'This is the page-title of button.htm')]/../.." );
  }
}
/*
 ==============================================================================
 Copyright © 2012, 2013, 2014, 2015,2016 IT-Beratung Hrabovszki
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

package okw.gui.frames.SeInputButton;

import okw.OKW;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeInputButton;
import okw.gui.adapter.selenium.SeInputText;

// \~german
// \brief GUI-Frame für die OKW-Testseite <a href="http://test.openkeyword.de/InputButton/input_type-button.htm">test.openkeyword.de/InputButton/input_type-button.htm</a> 
//
// \~english
// \brief GUI-Frame for the OKW-test page <a href="http://test.openkeyword.de/InputButton/input_type-button.htm">test.openkeyword.de/InputButton/input_type-button.htm</a> 
// \~
// \author Zoltán Hrabovszki
// \date 2016.09.06
@OKW( FN = "InputButton" )
public class frmInputButton extends SeBrowserChild
{
  // \~german
  // \brief
  // Anzeigefeld im Fenster: Enthält Werte nach dem Klick auf "Button 1" und "Button 2". Dient zur Prüfung der Button-Klicks geprüft werden.
  //\~english
  // \brief 
  // Display TextField: Contains values after you click the "Button 1" and "Button 2".
  @OKW( FN = "Display" )
  public SeInputText   Anzeige        = new SeInputText( "//*[@name='textfeld']" );

  // \~german
  // \brief
  // Nicht vorhandes Textfeld um die nicht Existenz zu prüfen.
  //\~english
  // \brief 
  // Not existing text box to verify the non-existence.
  @OKW( FN = "Does Not Exists" )
  public SeInputButton NichtVorhanden = new SeInputButton( "//*[@name='NichtVorhanden']" );

  @OKW( FN = "Text_1" )
  public SeInputButton Text_1         = new SeInputButton( "//*[@name='Button 1']" );

  @OKW( FN = "Text_2" )
  public SeInputButton Text_2         = new SeInputButton( "//*[@name='Button 2']" );

  @OKW( FN = "Button_3" )
  public SeInputButton Button_3       = new SeInputButton( "//*[@name='Button 3']" );

  // / \brief
  // / URL des Fensters: http://test.openkeyword.de/InputButton/input_type-button.htm
  // /
  public frmInputButton()
  {
    // <title>Klick-Buttons definieren(herkömmlich)</title>
    this.locator = new OKWLocator( "//*[@title='This is the page-title of input_type-button.htm']" );
  }
}
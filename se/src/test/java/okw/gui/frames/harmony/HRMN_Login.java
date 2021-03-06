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

package okw.gui.frames.harmony;

import okw.OKW;
import okw.gui.adapter.selenium.SeAnyChildWindow;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeButton;
import okw.gui.adapter.selenium.SeInputText;

@OKW( FN = "Harmony Login" )
public class HRMN_Login extends SeBrowserChild
{

  @OKW( FN = "Email",
          VerifyLabel_PT=500, VerifyLabel_TO=10,
          VerifyIsActive_PT=500, VerifyIsActive_TO=10,
          VerifyValue_PT=500, VerifyValue_TO=10,
          VerifyTooltip_PT=500, VerifyTooltip_TO=10,
          VerifyCaption_PT=500, VerifyCaption_TO=10,
          VerifyExists_PT=500, VerifyExists_TO=10,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=10
          )
  public SeAnyChildWindow Email = new SeInputText( "$L1$//*[@name=\"email\"]", this.getLOCATOR() ) ;

  @OKW( FN = "Password",
          VerifyLabel_PT=500, VerifyLabel_TO=10,
          VerifyIsActive_PT=500, VerifyIsActive_TO=10,
          VerifyValue_PT=500, VerifyValue_TO=10,
          VerifyTooltip_PT=500, VerifyTooltip_TO=10,
          VerifyCaption_PT=500, VerifyCaption_TO=10,
          VerifyExists_PT=500, VerifyExists_TO=10,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=10
          )
  public SeAnyChildWindow Password = new SeInputText( "$L1$//*[@name=\"password\"]", this.getLOCATOR() ) ;

  @OKW( FN = "Log In",
          VerifyLabel_PT=500, VerifyLabel_TO=10,
          VerifyIsActive_PT=500, VerifyIsActive_TO=10,
          VerifyValue_PT=500, VerifyValue_TO=10,
          VerifyTooltip_PT=500, VerifyTooltip_TO=10,
          VerifyCaption_PT=500, VerifyCaption_TO=10,
          VerifyExists_PT=500, VerifyExists_TO=10,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=10
          )
  public SeAnyChildWindow LogIn = new SeButton( "$L1$//*[@name=\"submit\"]", this.getLOCATOR() ) ;
  

  public HRMN_Login()
  {
    this.setLocator( "/*" );
  }
}

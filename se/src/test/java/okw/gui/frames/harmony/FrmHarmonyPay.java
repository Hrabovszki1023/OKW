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
import okw.gui.adapter.selenium.SeInputText;

@OKW( FN = "HarmonyPay" )
public class FrmHarmonyPay extends SeBrowserChild
{

  @OKW( FN = "cardNumber",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
          )
  public SeAnyChildWindow Text_1 = new SeInputText( "$L1$//*[@id=\"cardNumber\"]", this.getLOCATOR() ) ;


  /**
   * URL des Fensters: https://checkout.stripe.com/pay/cs_test_IvHBUXNLsF8ETtfx0i5Ev4iEkrehPmOdMtQbufoU3E7QZ68TPyCmuVim#fidkdWxOYHwnPyd1blpxYHZxWjFJX0ZPfUpocH13VkFyRlFMczF1M0FxcDU1RlVAfEthc0MnKSd3YGNgd3dgd0p3bGJsayc%2FJ21xcXV2PyoqaGR2cWB3K3Jqd252K21kd2hqa3wrZGYnKSdobGF2Jz9%2BJ2JwbGEnPyc9NTE3ND01ZigzNzwwKDE3YDQoPWRmZyg3Y2BjPDNkZzdgNmRnNWE9NzInKSdocGxhJz8nZGMwMGdnZDQoNWQ2MygxZmdkKGQ1NTAoPTRgNzJmZmAwZD1hMTVgNTUyJykndmxhJz8nYWcxMjU9PTQoN2A9ZygxZD01KDxjMTcoNTdgMTE2NDw0MzA0YTU1ZzBjJ3gpJ2dgcWR2Jz9eWHgl
   */
  public FrmHarmonyPay()
  {
    this.setLocator( "/*" );
  }
}

/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 Zoltán Hrabovszki, IT-Beratung Hrabovszki
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
package okw.gui.frames.frmCalculator;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

@OKW_FN(FN = "Calculator")
public class frmCalculator extends SeBrowserChild {
  
  @OKW_FN( FN = "Display" )
  public SeTextField  Display = new SeTextField( "//INPUT[@name='Display']" );

  @OKW_FN( FN = "1" )
  public SePushButton N1 = new SePushButton( "//input[@value='  1   ']");

  @OKW_FN( FN = "2" )
  public SePushButton N2 = new SePushButton( "//input[@value='  2   ']");

  @OKW_FN( FN = "3" )
  public SePushButton N3 = new SePushButton( "//input[@value='  3   ']");

  @OKW_FN( FN = "4" )
  public SePushButton N4 = new SePushButton( "//input[@value='  4   ']");

  @OKW_FN( FN = "5" )
  public SePushButton N5 = new SePushButton( "//input[@value='  5   ']");

  @OKW_FN( FN = "6" )
  public SePushButton N6 = new SePushButton( "//input[@value='  6   ']");

  @OKW_FN( FN = "7" )
  public SePushButton N7 = new SePushButton( "//input[@value='  7   ']");

  @OKW_FN( FN = "8" )
  public SePushButton N8 = new SePushButton( "//input[@value='  8   ']");

  @OKW_FN( FN = "9" )
  public SePushButton N9 = new SePushButton( "//input[@value='  9   ']");

  @OKW_FN( FN = "0" )
  public SePushButton N0 = new SePushButton( "//input[@value='  0   ']");

  @OKW_FN( FN = "." )
  public SePushButton Punkt = new SePushButton( "//INPUT[@type='button' and @value='*.*']" );

  @OKW_FN( FN = "+" )
  public SePushButton Plus = new SePushButton( "//input[@type='button' and @value='  +   ']" );

  @OKW_FN( FN = "-" )
  public SePushButton Minus = new SePushButton( "//input[@type='button' and @value='  -   ']" );

  @OKW_FN( FN = "/" )
  public SePushButton Durch = new SePushButton( "//input[@type='button' and @value='  /   ']" );

  @OKW_FN( FN = "*" )
  public SePushButton Mal  = new SePushButton( "//input[@type='button' and @value='  *   ']" );

  @OKW_FN( FN = "=" )
  public SePushButton Gleich = new SePushButton( "//input[@type='button' and @value='  =   ']" );

  @OKW_FN( FN = "C" )
  public SePushButton Clear  = new SePushButton( "//input[@type='reset' and @value='  C  ']" );

  @OKW_FN( FN = "sqrt" )
  public SePushButton Sqrt = new SePushButton( "//input[class='button'] type='button' value='sqrt '" );

  public frmCalculator() {
    
    // define Locator for Calculator Main-Window
    super( "//title[text()='Taschenrechner']/../.." );

  }
}

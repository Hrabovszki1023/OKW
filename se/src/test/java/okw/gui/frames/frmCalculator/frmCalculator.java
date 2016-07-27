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

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN = "Calculator")
public class frmCalculator extends SeBrowserChild {
  
  @OKW( FN = "Display" )
  public SeTextField  display = new SeTextField( "//INPUT[@name='Display']" );

  @OKW( FN = "1" )
  public SePushButton n1 = new SePushButton( "//input[@value='  1   ']");

  @OKW( FN = "2" )
  public SePushButton n2 = new SePushButton( "//input[@value='  2   ']");

  @OKW( FN = "3" )
  public SePushButton n3 = new SePushButton( "//input[@value='  3   ']");

  @OKW( FN = "4" )
  public SePushButton n4 = new SePushButton( "//input[@value='  4   ']");

  @OKW( FN = "5" )
  public SePushButton n5 = new SePushButton( "//input[@value='  5   ']");

  @OKW( FN = "6" )
  public SePushButton n6 = new SePushButton( "//input[@value='  6   ']");

  @OKW( FN = "7" )
  public SePushButton n7 = new SePushButton( "//input[@value='  7   ']");

  @OKW( FN = "8" )
  public SePushButton n8 = new SePushButton( "//input[@value='  8   ']");

  @OKW( FN = "9" )
  public SePushButton n9 = new SePushButton( "//input[@value='  9   ']");

  @OKW( FN = "0" )
  public SePushButton n0 = new SePushButton( "//input[@value='  0   ']");
  @OKW( FN = "." )
  public SePushButton punkt = new SePushButton( "//INPUT[@type='button' and @value='*.*']" );

  @OKW( FN = "+" )
  public SePushButton plus = new SePushButton( "//input[@type='button' and @value='  +   ']" );

  @OKW( FN = "-" )
  public SePushButton minus = new SePushButton( "//input[@type='button' and @value='  -   ']" );

  @OKW( FN = "/" )
  public SePushButton durch = new SePushButton( "//input[@type='button' and @value='  /   ']" );

  @OKW( FN = "*" )
  public SePushButton mal  = new SePushButton( "//input[@type='button' and @value='  *   ']" );

  @OKW( FN = "=" )
  public SePushButton gleich = new SePushButton( "//input[@type='button' and @value='  =   ']" );

  @OKW( FN = "C" )
  public SePushButton clear  = new SePushButton( "//input[@type='reset' and @value='  C  ']" );

  @OKW( FN = "sqrt" )
  public SePushButton sqrt = new SePushButton( "//input[class='button'] type='button' value='sqrt '" );

  public frmCalculator() {
    
    // define Locator for Calculator Main-Window
    super( "//title[text()='Taschenrechner']/../.." );

  }
}

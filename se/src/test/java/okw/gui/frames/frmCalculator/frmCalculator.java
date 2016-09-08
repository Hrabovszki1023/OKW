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
  public SeInputText  display = new SeInputText( "//INPUT[@name='Display']" );

  @OKW( FN = "1" )
  public SeInputButton n1 = new SeInputButton( "//input[@value='  1   ']");

  @OKW( FN = "2" )
  public SeInputButton n2 = new SeInputButton( "//input[@value='  2   ']");

  @OKW( FN = "3" )
  public SeInputButton n3 = new SeInputButton( "//input[@value='  3   ']");

  @OKW( FN = "4" )
  public SeInputButton n4 = new SeInputButton( "//input[@value='  4   ']");

  @OKW( FN = "5" )
  public SeInputButton n5 = new SeInputButton( "//input[@value='  5   ']");

  @OKW( FN = "6" )
  public SeInputButton n6 = new SeInputButton( "//input[@value='  6   ']");

  @OKW( FN = "7" )
  public SeInputButton n7 = new SeInputButton( "//input[@value='  7   ']");

  @OKW( FN = "8" )
  public SeInputButton n8 = new SeInputButton( "//input[@value='  8   ']");

  @OKW( FN = "9" )
  public SeInputButton n9 = new SeInputButton( "//input[@value='  9   ']");

  @OKW( FN = "0" )
  public SeInputButton n0 = new SeInputButton( "//input[@value='  0   ']");
  @OKW( FN = "." )
  public SeInputButton punkt = new SeInputButton( "//INPUT[@type='button' and @value='*.*']" );

  @OKW( FN = "+" )
  public SeInputButton plus = new SeInputButton( "//input[@type='button' and @value='  +   ']" );

  @OKW( FN = "-" )
  public SeInputButton minus = new SeInputButton( "//input[@type='button' and @value='  -   ']" );

  @OKW( FN = "/" )
  public SeInputButton durch = new SeInputButton( "//input[@type='button' and @value='  /   ']" );

  @OKW( FN = "*" )
  public SeInputButton mal  = new SeInputButton( "//input[@type='button' and @value='  *   ']" );

  @OKW( FN = "=" )
  public SeInputButton gleich = new SeInputButton( "//input[@type='button' and @value='  =   ']" );

  @OKW( FN = "C" )
  public SeInputButton clear  = new SeInputButton( "//input[@type='reset' and @value='  C  ']" );

  @OKW( FN = "sqrt" )
  public SeInputButton sqrt = new SeInputButton( "//input[class='button'] type='button' value='sqrt '" );

  public frmCalculator() {
    
    // define Locator for Calculator Main-Window
    super( "//title[text()='Taschenrechner']/../.." );

  }
}

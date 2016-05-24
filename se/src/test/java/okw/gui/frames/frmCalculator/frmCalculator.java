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

	@OKW_FN (FN="Calculator")
    public class frmCalculator extends SeBrowserChild
    {
        // http://de.selfhtml.org/javascript/beispiele/anzeige/taschenrechner.htm
	@OKW_FN (FN="Display")
        public SeTextField Anzeige;
        
	@OKW_FN (FN="1")
        public SePushButton N1 = null;
        
        @OKW_FN (FN="2")
        public SePushButton N2;
        
        @OKW_FN (FN="3")
        public SePushButton N3;
        
        @OKW_FN (FN="4")
        public SePushButton N4;
        
        @OKW_FN (FN="5")
        public SePushButton N5;
        
        @OKW_FN (FN="6")
        public SePushButton N6;
        
        @OKW_FN (FN="7")
        public SePushButton N7;
        
        @OKW_FN (FN="8")
        public SePushButton N8;
        
        @OKW_FN (FN="9")
        public SePushButton N9;
        
        @OKW_FN (FN="0")
        public SePushButton N0;
        
        @OKW_FN (FN=".")
        public SePushButton Punkt;

        @OKW_FN (FN="+")
        public SePushButton Plus;
        
        @OKW_FN (FN="-")
        public SePushButton Minus;
        
        @OKW_FN (FN="/")
        public SePushButton Durch;
        
        @OKW_FN (FN="*")
        public SePushButton Mal;
        
        
        @OKW_FN (FN="=")
        public SePushButton Gleich;

        @OKW_FN (FN="C")
        public SePushButton Clear;
        
        @OKW_FN (FN="sqrt")
        public SePushButton Sqrt;
        
        @OKW_FN (FN="pow")
        public SePushButton Pow;
        
        @OKW_FN (FN="ln")
        public SePushButton Ln;

        public frmCalculator()
        {
        	super("//title[text()='Taschenrechner']/../..");
        	
            Anzeige = new SeTextField("//INPUT[@name='Display']");
            
            //Zahlenblock
            N1 = new SePushButton("%1$s//input[@value='  1   ']", getLOCATOR());
            N2 = new SePushButton("%1$s//input[@value='  2   ']", getLOCATOR());
            N3 = new SePushButton("%1$s//input[@value='  3   ']", getLOCATOR());
            N4 = new SePushButton("%1$s//input[@value='  4   ']", getLOCATOR());
            N5 = new SePushButton("%1$s//input[@value='  5   ']", getLOCATOR());
            N6 = new SePushButton("%1$s//input[@value='  6   ']", getLOCATOR());
            N7 = new SePushButton("%1$s//input[@value='  7   ']", getLOCATOR());
            N8 = new SePushButton("%1$s//input[@value='  8   ']", getLOCATOR());
            N9 = new SePushButton("%1$s//input[@value='  9   ']", getLOCATOR());
            N0 = new SePushButton("%1$s//input[@value='  0   ']", getLOCATOR());
            
            Punkt = new SePushButton("%1$s//INPUT[@type='button' and @value='*.*']", getLOCATOR());
            
            // Grundrechenarten
            Plus  = new SePushButton("%1$s//input[@type='button' and @value='  +   ']", getLOCATOR());
            Minus = new SePushButton("%1$s//input[@type='button' and @value='  -   ']", getLOCATOR());
            Durch = new SePushButton("%1$s//input[@type='button' and @value='*/*']", getLOCATOR());
            Mal   = new SePushButton("%1$s//input[@type='button' and @value='  *   ']", getLOCATOR());
            
            Gleich = new SePushButton("%1$s//input[@value='  =   ']", getLOCATOR());
            
            // Funktionen
            Clear = new SePushButton("%1$s//input[@type='reset' and @value='  C  ']", getLOCATOR());
            
            // <input class="button" onclick="Sonderfunktion('sqrt')" type="button" value="sqrt "/>
            Sqrt = new SePushButton("%1$s//input[class='button'] type='button' value='sqrt '", getLOCATOR());
            Pow = new SePushButton("%1$s", getLOCATOR());
            Ln = new SePushButton("%1$s", getLOCATOR());
            
        }
    }



/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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

package okw.gui.frames;

import okw.*;
import okw.gui.AnyChildwindow;
import okw.gui.adapter.*;
import okw.log.*;

/** \~german
 *  frmObjDictTest ist eine Test-Frame-Klasse. Diese Klasse ist ein OKW-Unittest-Objekt.<br/>
 *  
 *  @author Zoltan Hrabovszki
 *  \date 2012.12.26
 *  @warning Diese Frame-Klasse nicht ohne Grund verändern!
 *  @copyright
 */
@OKW(FN="frmObjDictTest")
public class FrmObjDictTest extends Test_Window
  {
	private Logger_Sngltn      myLogger    = Logger_Sngltn.getInstance();
	private OKW_TestClipboard  myClipBoard = OKW_TestClipboard.getInstance();


        /**
         * \~german
         * Test für einen GUI-Container.
         * 
         * Object/Element zur Prüfung des ObjectDictionary-Scanner-Methoden
         * Test Ziel:
         *  - wird ein GUI-Container instanziert
         *  - und im ObjectDictionary abgelegt wird.
         * 
         * Keine Annotaion für die Container-Klasse selbst!
         * 
         * @author Zoltan Hrabovszki
         * \date 2016.11.13
         */
        public frmObjDictGuiContainer1 myGUIContainer = new frmObjDictGuiContainer1();

        
        /**
         * \~german
         * Test für eine Inline Klasse, die als GUI-Container dient.
         * 
         * Dient zur Prüfung, ob ein GUI-Container-Class instanziert und im ObjectDictionary abgelegt wird.
         * 
         * @author Zoltan Hrabovszki
         * \date 2016.11.13
         * No annotaion for the Container @OKW(FN="Anzeige")
         */
        @OKW(FN="Tastatur")
        public myTestbutton myInlineClassDef = new myTestbutton("locator");
        
        
        public class myTestbutton extends AnyChildwindow
        {

          /**
           * \~german
           * Taste_1 ist ein GUI-Objekt ohne weitere Veränderung/anpassungen der Basisklasse Test_PushButton.
           * D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
           * 
           * @author Zoltan Hrabovszki
           * \date 2012.12.26
           */
          @OKW(FN="Taste_1")
          public Test_PushButton Taste_1 = new Test_PushButton("1");


          /**
           * \~german
           *  Taste_2 ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_PushButton.
           *  D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
           *  
           *  @author Zoltan Hrabovszki
           *  \date 2012.12.26
           */
          @OKW(FN="Taste_2")
          public Test_PushButton Taste_2 = new Test_PushButton("2");
          
          public myTestbutton( String Locator )
          {
              super( Locator );
          }
          
        };
        
        
        /**
         * \~german
         * Konstruktor der Klasse Rechner: Definition des Locators: mit welchen characteristischen Eigenschaften 
         * wird das Objekt "Rechner" erkannt wird.<br/>
         * Da diese Klasse eine Testklasse ist ohne irgen dein ein GUI-Objekt,
         * ist das setzten des Wertes "Neuer Locator Rechner" nur für den Unittest relevant.<br/>
         * Also hier den Locator für das Fenster setzen...
         * 
         * @author Zoltan Hrabovszki
         * \date 2012.12.26
         */
        public FrmObjDictTest()
        {
        	super("Neuer Locator Rechner");
            myLogger.LogPrintDebug("Rechner.Constructor()");
        }

        @Override
        public  void SelectWindow()
        {
            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".SelectWindow");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            myClipBoard.setObjectName("Rechner");
            myClipBoard.setMethod("SelectWindow()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add("NO VALUE");

            myLogger.LogFunctionEndDebug();
        }
    }
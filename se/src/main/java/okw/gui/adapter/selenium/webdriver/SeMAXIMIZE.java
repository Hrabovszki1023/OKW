/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

package okw.gui.adapter.selenium.webdriver;

import java.awt.Toolkit;
import java.util.ArrayList;

import org.openqa.selenium.*;

import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.gui.adapter.selenium.SeAnyChildWindow;

    /** 
     * @ingroup groupSeleniumChildGUIAdapter
     * 
     *  \~german
     *  Klasse Implementiert den Knopf zur Fenster-Maximierung eines Browsers.
     *  
     *  Die Klasse besitz keinen <tt>locator</tt>.
     *  Die Maximierung wird via SeDriver.Instance.driver.
     *  Die Menge der verwendbaren Schlüsselwörter ist begrenzt, da SeMAXIMIZE ein Virtuelle Pushbutten ist, d.h. ein Maximize Puschbutton simuliert wird.
     *  
     *  @par Wichtig: Klasse kann nur zusammen mit Selenium WebBrowser Klassen verwendet werden.
     *  
     *  http://www.software-testing-tutorials-automation.com/2015/02/how-to-setget-window-position-and-size.html
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014.04.19
     */
    public class SeMAXIMIZE extends SeAnyChildWindow
    {

        public SeMAXIMIZE()
        {
          super();
        }

        /** \~german
         *  Ermittelt den textuellen Inhalt der Überschrift eines HTML-Tags anhand des Attributee "textContent".
         *   
         *  @return Rückgabe des Textuellen Inhaltes der Caption/Überschrift.
         *  \~english
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2013.12.07
         */
       public ArrayList<String> getCaption()
       {
           ArrayList<String> lvLsReturn = new ArrayList<String>();

           try
           {
               this.LogFunctionStartDebug( "GetCaption" );

               // TODO: SeURL.GetTooltip: Ausnahme-Meldung auslagern
               throw new OKWFrameObjectMethodNotImplemented("\"Caption\" not supported by SeMAXIMIZE-class!");
           }
           finally
           {
               this.LogFunctionEndDebug( lvLsReturn );
           }
       }
       
       /** \~german
        *  Prüft die Existenz des aktuellen Objektes.
        *  
        *  - Methode ist Selenium spezifisch.
        *  - Elementare Funktion, muss hier defiert werden.
        *  - Es wird nicht auf das Objekt gewarten!
        *  - Es wird nur ein eizigesmal die Existenz geprüft.
        *  - Es wird keine Ausnahme ausgelöst, wenn das Object nicht vorhanden ist.
        *  - Wenn Das Objekt nicht eindeitig ist wird false Zurückgeliefert.
        *  
        *  @return true, falls das Objekt eindeutig gefunden worden ist ist, sonst false.
        *  \~
        *  @author Zoltán Hrabovszki
        *  @date 2017.01.31
        */
        public Boolean getExists()
        {
            Boolean lvbReturn = true;

            try
            {
                this.LogFunctionStartDebug( "getExists" );
                lvbReturn = true;
            }
            finally
            {
                this.LogFunctionEndDebug( lvbReturn );
            }
            return lvbReturn;
        }
       
        /** \~german
         *  Ermittelt, ob das aktuellen Objekt aktiv ist.
         *  
         *  Diese Klasse ist als virtuelles Textfeld ab
         *  
         *  @return true, und zwar immer!
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2014.04.19
         */
         public Boolean getIsActive()
         {
             Boolean lvbReturn = true;

             this.LogFunctionStartDebug( "getIsActive" );
             this.LogPrintDebug( "Allways true" );
             this.LogFunctionEndDebug( lvbReturn );

             return lvbReturn;
         }

         /** \~german
          *  Methode wird nicht untertütz, Methode liefert den aktuellen Zustand Wert des Focus.
          * 
          *  \~
          *  @author Zoltán Hrabovszki
          *  @date 2017.07.28
          */
         public Boolean getHasFocus()
         {
             Boolean lvbReturn = false;

             try
             {
                 this.LogFunctionStartDebug( "getHasFocus" );

                 // TODO: SeURL.GetTooltip: Ausnahme-Meldung auslagern
                 throw new OKWFrameObjectMethodNotImplemented("\"HasFocus\" not supported by SeMAXIMIZE-class!");
                 }
             finally
             {
                 this.LogFunctionEndDebug( lvbReturn );
             }

         }

         /** \~german
          *  Ermittelt den textuellen Inhalt des Labels.
          *  
         *  __Diese Methode wird von dieser Klasse nicht unterstützt.__
         *  
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2017.07.23
        */
        public ArrayList<String> getLabel()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug( "getLabel" );

                // TODO: SeURL.GetTooltip: Ausnahme-Meldung auslagern
                throw new OKWFrameObjectMethodNotImplemented("GetTooltip not supported by SeURL-class!");
            }
            finally
            {
                this.LogFunctionEndDebug( lvLsReturn );
            }
        }
         
         
        /** \~german
         *  \brief
         *  Liest den aktuellen Tooltip-Wert der URL aus.
         *  
         *  __Diese Methode wird von dieser Klasse nicht unterstützt.__
         *  
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2017.07.23
         */
        public ArrayList<String> getTooltip()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.LogFunctionStartDebug("GetTooltip");

            try
            {
                // TODO: SeURL.GetTooltip: Ausnahme-Meldung auslagern
                throw new OKWFrameObjectMethodNotImplemented("GetTooltip not supported by SeURL-class!");
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }
            // return lvLsReturn;
        }

         /**
          * \~german
          * 
          * Alle Value Schlüsselwörter werden nicht unterstützt
          * 
          *  \~english
          *  \~
          *  @author Zoltan Hrabovszki
          *  @date 2017.07.28
          */
        public ArrayList<String> getValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.LogFunctionStartDebug("getValue");

            try
            {
                // TODO: SeMAXIMIZE.SetFocus: Ausnahme-Meldung auslagern
                throw new OKWFrameObjectMethodNotImplemented("\"*Value\" Keyword are not supported by SeMAXIMIZE-class!");
            }
            finally
            {
               this.LogFunctionEndDebug(lvLsReturn);
            }

        }

        
        /** \~german
         *  Klickt auf das aktuelle Objekt.
         *  
         *  \~english
         *  \~
         *  @author Zoltán Hrabovszki
         * @date 2013.11.11
         */
        public void ClickOn()
        {
            try
            {
                this.LogFunctionStartDebug("ClickOn");

                /*java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                
                this.ResOpenList( "Screen Dimension:" );
                this.LogPrint( screenSize.toString() );
                this.ResCloseList();
                
                Dimension myDimension = new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight());
                
                // Set dimension to 
                SeDriver.getInstance().getDriver().manage().window().setSize(myDimension);

                Point myPoint = new Point(0,0);
                
                // Set dimension to 
                SeDriver.getInstance().getDriver().manage().window().setPosition( myPoint );
*/
                
                SeDriver.getInstance().getDriver().manage().window().maximize();
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }


         /**  \~german
         *  Setzt den Focus in das aktuelle URL-TextFeld.
         *  
         *  __Diese Methode wird von dieser Klasse nicht unterstützt.__
         *  
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2014.04.19
         */
        public void SetFocus()
        {
            this.LogFunctionStartDebug("SetFocus");

            try
            {
                // TODO: SeMAXIMIZE.SetFocus: Ausnahme-Meldung auslagern
                throw new OKWFrameObjectMethodNotImplemented("\"SetFocus\" not supported by SeMAXIMIZE-class!");
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }

         /**  \~german
         *  Setzt den Wert der URL im aktiven Browser und navigiert zur gegebene Seite.
         *  
         *  Ctrl-Eingaben funktionieren nicht bei Set Value nicht (z.B. <tt>CTRL-C</tt>).
         *  
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2014.04.19
         */
        public void SetValue(ArrayList<String> fps_Values)
        {
            this.LogFunctionStartDebug("SetValue", "fps_Values", fps_Values.get(0));

            try
            {
                // TODO: SeMAXIMIZE.SetFocus: Ausnahme-Meldung auslagern
                throw new OKWFrameObjectMethodNotImplemented("\"SetValue\" not supported by SeMAXIMIZE-class!");
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }

        
         /**  \~german
         *  Setzt den Wert der URL im aktiven Browser/BrowserChild und navigiert zur gegebenen Seite.
         *  
         *  __Wichtig:__ Die URL wird in dieser Klasse technisch nicht über die Tastatur eigegeben. Implementierung erfolg 
         *  aus Kompfort- und Kompatinilitätsgründen.
         *  Dass heißt Ctrl-Eingaben funktionieren nicht(z.B. <tt>CTRL-C</tt>).
         *  
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2014.04.19
         */
        public void TypeKey(ArrayList<String> fps_Values)
        {
            this.LogFunctionStartDebug("TypeKey", "fps_Values", fps_Values.get(0));

            try
            {
                throw new OKWFrameObjectMethodNotImplemented("\"TypeKey\" not supported by SeMAXIMIZE-class!");
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }
}
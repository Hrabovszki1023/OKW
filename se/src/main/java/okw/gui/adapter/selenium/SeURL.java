/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

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

package okw.gui.adapter.selenium;

import java.util.ArrayList;
import org.openqa.selenium.*;

    /** : IOKW_SimpleDataObj
     *  \~german
     *  Klasse Implementiert das URL-Eingabefeld der Browser.
     *  Die Klasse besitz keinen <tt>locator</tt>.
     *  Die URL wird via <tt>SeDriver.Instance.driver.Url</tt> gelesen und geschrieben.
     *  Die Menge der Verwendbaren Schlüsselwörter ist begrenzt, weil die Selenium WebDriver API
     *  nur beschränkt an alle Funktionalitäten und Eigenschaften des
     *  URL-TextFeldes eines Browser herankommt.
     *  
     *  __Wichtig:__ Klasse kann nur zusammen mit Selenium WebBrowser Klassen verwendet werden.
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2014.04.19
     */
    public class SeURL extends SeAnyChildWindow
    {

        public SeURL()
        {
          super("SeURL");
        }

  
        /** \~german
         *  \brief
         *  Liest den aktuellen Tooltip-Wert der URL aus.
         *  
         *  __Diese Methode wird von dieser Klasse nicht unterstützt.__
         *  
         *  @return Tooltip-Wert des aktuellen URL-Textfeldes im aktiven Browser.
         *  \~english
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2014.04.19
         */
        public ArrayList<String> getTooltip()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.LogFunctionStartDebug("GetTooltip");

            try
            {
                // TODO: SeURL.GetTooltip: Ausnahme-Meldung auslagern
                throw new NotFoundException("GetTooltip not supported by SeURL-class!");
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }
            // return lvLsReturn;
        }

         /**
          * \~german
          *  Liest den aktuellen Wert der URL aus.
          *  
          *  @return Sichtbarer Wert der URL im Aktiven Browser.
          *  \~english
          *  \~
          *  @author Zoltan Hrabovszki
          *  @date 2014.04.19
          */
        public ArrayList<String> getValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            this.LogFunctionStartDebug("getValue");

            try
            {
                // Get Value from TextField and Putt this into theReturn ArrayList<String>
                lvLsReturn.add(SeDriver.getInstance().driver.getCurrentUrl());
            }
            finally
            {
               this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }

         /** 
         *  Ermittelt den Wert des Objktes für das Schlüsselwort Loggewert.
         *  
         *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
         *  
         *  @return Rückgabe des Textuellen Inhaltes der markierten Textes.
         *  
         *  @author Zoltan Hrabovszki
         *  @date 2013.12.14
         */
        public ArrayList<String> LogValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("LogValue");
                lvLsReturn = this.getValue();
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }

        /**  \~german
         *  Ermittelt den Wert, im Allgemeinen den textuellen Inhalt eines Objektes
         *  für das Schlüsselwort MerkeWert.
         *  
         *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
         *  
         *  @return Rückgabe des Textuellen Inhaltes des aktuellen Objektes.
         *  
         *  \~english
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2013.12.14
         */
        public ArrayList<String> MemorizeValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("MemorizeValue");
                lvLsReturn = this.getValue();
            }
            finally
            {
               this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
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
                // TODO: SeURL.SetFocus: Ausnahme-Meldung auslagern
                throw new NotFoundException("\"SetFocus\" not supported by SeURL-class!");
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
                SeDriver.getInstance().driver.navigate().to(fps_Values.get(0));
            }
            finally
            {
                this.LogFunctionEndDebug();
            }

            return;
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
            	WebDriver myDriver = SeDriver.getInstance().driver;
            	myDriver.navigate().to(fps_Values.get(0));
            }
            finally
            {
                this.LogFunctionEndDebug();
            }

            return;
        }

         /**
          *  Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
          *  
          *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
          *  
          *  \return
          *  Rückgabe des Textuellen Inhaltes der markierten Textes.
          *  Es wird immer der aktuelle Wert des Objektes zurückgeliefert.
          *  
          *  @author Zoltan Hrabovszki
          *  @date 2013.12.14
          */
        public ArrayList<String> VerifyValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                this.LogFunctionStartDebug("VerifyValue");

                lvLsReturn.add( SeDriver.getInstance().driver.getCurrentUrl() );
                
            }
            finally
            {
                this.LogFunctionEndDebug(lvLsReturn);
            }

            return lvLsReturn;
        }
}
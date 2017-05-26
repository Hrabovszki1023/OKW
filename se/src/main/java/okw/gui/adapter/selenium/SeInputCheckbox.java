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

import okw.LogMessenger;
import okw.OKW_Const_Sngltn;
import okw.exceptions.OKWNotAllowedValueException;
import okw.gui.*;

    /**
     * \~german
     *  Diese Klasse representiert eine HTML-CheckBox, die mit Selenium angsteuert wird.
     *  
     *  # Unterstützter Tag
     *  Folgender HTML-Tag wird unterstützt:
     *  
     *  \code{.html}
     *  <input type="checkbox" name="ingredients" value="salami" title="title: salami">Salami<br>
     *  \endcode
     * 
     * # Unterstützte GUI-Schlüsselwörter
     *
     * ## Kindobjekt Aktionen
     * 
     * | OpenKeyWord               | Implementiert | Beschreibung |
     * | ------------------------- | :-----------: | :----------- |
     * | `ClickOn( FN )`           | **JA**        |  |
     * | `DoubleClickOn( FN )`     | **NEIN**      | - Wie reagiert eine CheckBox auf DoubleClick??? |
     * | `SetFocus( FN )`          | **JA**        |  |
     * | `SetValue( FN, Val )`     | **JA**        | `SetValue( "MyChekckBox", "CHECKED")` - why not?!?. |
     * | `Select( FN, Val )`       | **JA**        | Hinweis: Entspricht `SetValue( FN, Val )` |
     * | `SelectMenu( FN )`        | **NEIN**      |  |
     * | `SelectMenu( FN, Val )`   | **NEIN**      |  |
     * | `TypeKey( FN, Val )`      | **NEIN**      | Prinzipiel sinnvoll. Zunächst müssen KeyNames für z.B. ${BLANK} TypeKey( "myCheckbox", "${BLANK}") definiert werden. |
     * 
     * ## Fensterbezogene Schlüsselwörter
     * 
     * | OpenKeyWord               | Implementiert | Beschreibung |
     * | ------------------------- | :-----------: | :----------- |
     * | `StarApp( AN )`           | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
     * | `StopApp( AN )`           | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
     * | `SelectWindow( FN )`      | **NEIN**      | Kind-Objekt, Checkbox ist kein Fensterobjekt |
     * | `Sequence( FN, SQN, SEQ_ID )` | **NEIN**  | Kind-Objekt, Checkbox ist kein Fensterobjekt |
     * 
     * ## Verifying, Memorizing, Logging Values
     * 
     * Group of keywords using the same GUI-Adapter Methods get*() <br/>
     * (e.g.: `VerifyExists( FN, ExpVal)`, `MemorizeExists( FN, MemKey)`,`LogExists( FN )` -> `getExists()` )
     * 
     * | OpenKeyWord | Implementiert | Beschreibung |
     * | ----------- | :-----------: | :----------- |
     * | `VerifyExists( FN, ExpVal)`,    <br>`MemorizeExists( FN, MemKey)`,    <br>`LogExists( FN )` | **JA** |  |
     * | `VerifyHasFocus( FN, ExpVal )`, <br>`MemorizeHasFocus( FN, MemKey)`,  <br>`LogHasFocus( FN )` | **JA** |  |
     * | `VerifyIsActive( FN, ExpVal )`, <br>`MemorizeIsActive( FN, MemKey)`,  <br>`LogIsActive( FN )` | **JA** |  |
     * | `VerifyCaption( FN, ExpVal )`,  <br>`VerifyCaptionWCM( FN, ExpVal )`, <br>`VerifyCaptionREGX( FN, ExpVal )`, <br/>`MemorizeCaption( FN, ExpVal )`, <br>`LogCaption( FN, ExpVal )` | **JA** | Caption ist der sichtbare Text neben der Checkboc |
     * | `VerifyLabel( FN, ExpVal )`,    <br>`VerifyLabelWCM( FN, ExpVal )`,   <br>`VerifyLabelREGX( FN, ExpVal )`,   <br/>`MemorizeLabel( FN, ExpVal )`, <br>`LogLabel( FN, ExpVal )` | - **JA** | Zu Prüfen: Ist eine CheckBox mit einem Label verbindbar? |
     * | `VerifyTooltip( FN, ExpVal )`,  <br>`VerifyTooltipWCM( FN, ExpVal )`, <br>`VerifyTooltipREGX( FN, ExpVal )`, <br/>`MemorizeTooltip( FN, ExpVal )`, <br>`LogTooltip( FN, ExpVal )` | **JA** | Wert des attributes `title` |
     * | `VerifyValue( FN, ExpVal )`,    <br>`VerifyValueWCM( FN, ExpVal )`,   <br>`VerifyValueREGX( FN, ExpVal )`,   <br/>`MemorizeValue( FN, ExpVal )`, <br>`LogValue( FN, ExpVal )` | **JA** | Wenn gesetzt = `CHECKED` sonst `UNCHECKED` |
     * 
     *  # Quellen/Links
     *  
     *  - [SelfHTML: https://wiki.selfhtml.org/wiki/HTML/Formulare/input/Radio-Buttons_und_Checkboxen#Checkboxen)
     *  - [HTML/Formulare](https://github.com/Hrabovszki1023/OKW/issues/24)
     *  
     *  \~english
     *  
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.04.11
     */
    public class SeInputCheckbox extends SeAnyChildWindow
    {
    	
    	OKW_Const_Sngltn myOKW_Const = null;

        /**
         *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,OKWLocator)
         *  
         *  @date 2017.02.17
         */         
        public SeInputCheckbox( String Locator, OKWLocator... Locators )
        {
            super(Locator, Locators);
            this.LM = new LogMessenger("GUI");
            myOKW_Const  = OKW_Const_Sngltn.getInstance();
        }

        
        /**
         *  \copydoc SeAnyChildWindow::SeAnyChildWindow(String,String,OKWLocator)
         *  
         *  @date 2017.02.17
         */
         public SeInputCheckbox(String IframeID, String Locator, OKWLocator... Locators)
         {
           super(IframeID, Locator, Locators);
         }        

         
        /**
         * \~german
         *  Method liefert den aktuellen Zustand der Checkbox, "angehakt" oder "nicht angehakt".
         *  
         *  Alle Methoden dieser Klasse verwenden diese Methode um den aktuellen Zustand zu ermitteln.
         *  
         *  \note WaitForMe() wird inder aufrufenden Methode ausgeführt.
         *  
         *  @return true falls angehakt, sonst false
         *  
         *  \~english
         *  
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2013.04.11
         */
        public Boolean getIsSelected()
        {
            Boolean lvbReturn = false;
            
            try
            {
                this.LogFunctionStartDebug("getIsSelected");

                // Hole Zusand: "Häkschen" oder kein "Häkschen", das ist hier die Frage...
                lvbReturn = this.Me().isSelected();
            }
            finally
            {
                this.LogFunctionEndDebug(lvbReturn);
            }
            return lvbReturn;
        }
        

        /**
         * \~german
         *  Method verlässt die Checkbox immer angehakt, egal ob diese vorher angehakt war oder nicht.
         *  
         *  
         *  \~english
         *  
         *  \~
         *  @author Zoltan Hrabovszki
         *  @throws Exception 
         *  @date 2013.04.11
         */
        public void Checking()
        {
            this.LogFunctionStartDebug("Checking");

            try
            {
                // Hab ich ein Häckchen?
                if (!this.getIsSelected())
                {
                    this.ClickOn();
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }

        /**
         * \~german
         * Ermittelt/holt den aktuellen Wert der CheckBox.
         * 
         * Die Mögliche Werte sind sprachabhängig CHECKED/UNCHECKED
         * 
         * @return Liefert im ersten Wert des ArrayList&lt;String&gt; sprachabhängig CHECKED/UNCHECKED zurück.
         *
         *  
         *  \~english
         *  
         *  \~
         * @author Zoltán Hrabovszki
         * @date 2013.04.11
         */
        @Override
        public ArrayList<String> getValue()
        {
            ArrayList<String> lvls_Return = new ArrayList<String>();
            try
            {
                this.LogFunctionStartDebug("getValue");

                // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
                this.WaitForMe();

                if (this.getIsSelected())
                {
                    String lvsValue = myOKW_Const.GetConst4Internalname("CHECKED");
                    lvls_Return.add(lvsValue);
                }
                else
                {
                    String lvsValue = myOKW_Const.GetConst4Internalname("UNCHECKED");
                    lvls_Return.add(lvsValue);
                }
            }
            finally
            {
                    this.LogFunctionEndDebug(lvls_Return);
            }

            return lvls_Return;
        }
        
        /**
         * \~german
         *  
         *  \~english
         *  
         *  \~
         *  
         *  @author Zoltan Hrabovszki
         *  @date 2013.04.11
         */
        @Override
        public void SetValue(ArrayList<String> fps_Values)
        {

            try
            {
                this.LogFunctionStartDebug("SetValue", "fps_Values", fps_Values.toString());

            	// Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
                this.WaitForMe();

                // Sprachabhängige Werte holen
                String lvsCHECKED = myOKW_Const.GetConst4Internalname("CHECKED");
                String lvsUNCHECKED = myOKW_Const.GetConst4Internalname("UNCHECKED");

                if (fps_Values.get(0).toUpperCase().equals( lvsCHECKED.toUpperCase()) )
                {
                    this.Checking();
                }
                else if (fps_Values.get(0).toUpperCase().equals(lvsUNCHECKED.toUpperCase()) )
                {
                    this.UnChecking();
                }
                else
                {
                    // LANGUAGE: Exceptionmeldungen in eine Eigene xml Auslagern.
                    String lvsLM = this.LM.GetMessage("Common", "OKWNotAllowedValueException", fps_Values.get(0));
                    throw new OKWNotAllowedValueException(lvsLM);
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }

        /**
         * \~german
         * 
         * Erlaubte Werte sind sprachabhängig CHECKED/UNCHECKED.
         * 
         * @exception OKWNotAllowedValueException wird aus glöst, wenn ein andere wert als die sprach abhängigen Werte CHECKED/UNCHECKED
         * 
         *  \~english
         *  
         *  \~  
         *  \copydoc SeAnyChildWindow::Select(ArrayList<String>)
         *  @author Zoltan Hrabovszki
         *  @date 2013.04.11
         */
        @Override
        public void Select(ArrayList<String> fps_Values)
        {
            this.LogFunctionStartDebug("Select", "fps_Values", fps_Values.toString());

            try
            {
            	// Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
                this.WaitForMe();

                // Sprachabhängige Werte holen
                String lvsCHECKED = myOKW_Const.GetConst4Internalname("CHECKED");
                String lvsUNCHECKED = myOKW_Const.GetConst4Internalname("UNCHECKED");

                if (fps_Values.get(0).toUpperCase().equals( lvsCHECKED.toUpperCase()) )
                {
                    this.Checking();
                }
                else if (fps_Values.get(0).toUpperCase().equals(lvsUNCHECKED.toUpperCase()) )
                {
                    this.UnChecking();
                }
                else
                {
                    // LANGUAGE: Exceptionmeldungen in eine Eigene xml Auslagern.
                    String lvsLM = this.LM.GetMessage("Common", "OKWNotAllowedValueException", fps_Values.get(0));
                    throw new OKWNotAllowedValueException(lvsLM);
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }

        
        /**
         * \~german
         * 
         *  Method verlässt die Checkbox immer unangehakt, egal ob sie vorher angehakt
         *  war oder nicht.<br/>
         *  
         *  \note Die Eigenschaft Element.Selected() ist nicht beschreibar. Daher wird ggf. die Methode Click() verwendet.
         *  
         *  @author Zoltan Hrabovszki
         *  @date 2013.04.11
         */
        public void UnChecking()
        {
            try
            {
                this.LogFunctionStartDebug("UnChecking");

                // Hab ich ein Häckchen?
                if (this.getIsSelected())
                {
                    // yep! - Dann klicken und Häckchen weg...
                    this.ClickOn();
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }
        }
}
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

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import okw.LogMessenger;
import okw.OKW_Const_Sngltn;
import okw.exceptions.OKWNotAllowedValueException;
import okw.gui.*;

    /** \brief
     *  Diese Klasse representiert eine CheckBox,
     *  die mit Selenium angsteuert wird.
     *  
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

         
        /** \brief
         *  Method liefert den aktuellen zustand der Checkbox, "angehakt" oder "nicht angehakt".
         *  
         *  Alle OKW Checkbox methoden
         *  Laufen über diese methode um den aktuellen zustand zu ermitteln.
         *  
         *  _Anmerkung:_ kein WaitForMe aufruf: WaitForMe() wird schon inder aufrufenden Methode ausgeführt.
         *  
         *  @return true falls angehakt, sonst false
         *  @author Zoltan Hrabovszki
         *  @throws Exception 
         *  @date 2013.04.11
         */
        public Boolean getIsSelected()
        {
            Boolean lvbReturn = false;
            
            try
            {
                this.LogFunctionStartDebug("IsSelected");

                // Hole Zusand: Häckchen oder kein Häckchen, das ist hier die Frage?
                lvbReturn = this.Me().isSelected();
            }
            finally
            {
                this.LogFunctionEndDebug(lvbReturn);
            }
            return lvbReturn;
        }
        

        /** \brief
         *  Method verlässt die Checkbox angehakt, egal ob diese vorher angehakt war oder nicht.
         *  
         *  @author Zoltan Hrabovszki
         * @throws Exception 
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
            return;
        }

        /** Ermittelt den aktuellen Wert der CheckBox.
         * 
         * Mögliche Werte sind Sprachabhängig CHECKED/UNCHECKED
         * 
         * @return Liefert im ersten Wert des ArrayList&lt;String&gt; sprachabhängig CHECKED/UNCHECKED zurück.
         * @author Zoltan Hrabovszki
         * @throws Exception 
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
         *  @author Zoltan Hrabovszki
         * @throws Exception 
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

            return;
        }

        // \author Zoltan Hrabovszki
        // \date 2013.04.11
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

            return;
        }

        
        /** \brief
         *  Method verlässt die Checkbox unangehakt, egal ob sie vorher angehakt
         *  war oder nicht.<br/>
         *  __Anmerkung:__ Die Eigenschaft Element.Selected() ist nicht beschreibar.
         *  Daher
         *  
         *  @author Zoltan Hrabovszki
         * @throws Exception 
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

            return;
        }
}
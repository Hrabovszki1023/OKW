package okw.gui.adapter.selenium;

/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015, 2016 IT-Beratung Hrabovszki
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

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import okw.LogMessenger;
import okw.OKW_Const_Sngltn;
import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.exceptions.OKWNotAllowedValueException;
import okw.gui.*;

    /// \brief
    /// Diese Klasse representiert eine CheckBox,
    /// die mit Selenium angsteuert wird.
    /// 
    /// \author Zoltan Hrabovszki
    /// \date 2013.04.11
    public class SeInputCheckbox extends SeSimpleDataObjBase
    {
    	
    	OKW_Const_Sngltn myOKW_Const = null;

        /// TODO: Konstuktor Beschreiben
        /// \brief
        /// Konstruktor der Klasse SeCheckBox.
        /// 
        /// \param Locator
        /// definiert die Objekterkennungseigenschaft
        /// des Objektes und wird als XPATH angegeben.<br/>
        /// <bf>Beispiel:</bf><tt>//input[@value='salami']</tt>
        ///         
        public SeInputCheckbox( String fpsLocator, OKWLocator... fpLocators )
        {
            super(fpsLocator, fpLocators);
            this.LM = new LogMessenger("GUI");
            myOKW_Const  = OKW_Const_Sngltn.getInstance();
        }

        /// \brief
        /// Method ermittel oder liefert den aktuellen zustend der Checkbox,
        /// also ob die angehakt oder Nicht angehakt.
        /// 
        /// Alle OKW Checkbox methoden
        /// Laufen über diese methode um den aktuellen zustand zu ermiietl.
        ///         angehakt war oder nicht.
        /// Diese Methode ist die Anpassungstelle für Projekspezifische Anpassungen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2013.04.11
        public Boolean IsSelected()
        {
            Boolean bOK = false;
            Boolean lvbReturn = false;
            
            this.LogFunctionStartDebug("IsSelected");

            try
            {
                // Hole Zusand: Häckchen oder kein Häckchen, das ist hier die Frage?
                lvbReturn = this.Me().isSelected();
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    this.LogFunctionEndDebug(lvbReturn);
                }
                else
                {
                    this.LogFunctionEndDebug( );
                }
            }

            return lvbReturn;
        }
        

        /// \brief
        /// Method verlässt die Checkbox angehakt, egal ob diese vorher angehakt war oder nicht.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2013.04.11
        public void Checking()
        {
            this.LogFunctionStartDebug("Checking");

            try
            {
                // Hab ich ein Häckchen?
                if (!this.IsSelected())
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

        // \brief Ermittelt den aktuellen Wert der CheckBox.
        // 
        // \return Liefert im ersten Wert des List-String Sprachabhänig CHECKED/UNCHECKED
        // \author Zoltan Hrabovszki
        // \date 2013.04.11
        @Override
        public ArrayList<String> getValue()
        {
            ArrayList<String> lvls_Return = new ArrayList<String>();
            Boolean bOK = false;
            try
            {
                this.LogFunctionStartDebug("getValue");

                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "GetValue()");
                    throw new OKWGUIObjectNotFoundException(lvsLM);
                }

                if (this.IsSelected())
                {
                    String lvsValue = myOKW_Const.GetConst4Internalname("CHECKED");
                    lvls_Return.add(lvsValue);
                }
                else
                {
                    String lvsValue = myOKW_Const.GetConst4Internalname("UNCHECKED");
                    lvls_Return.add(lvsValue);
                }

                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    this.LogFunctionEndDebug();
                }
                else
                {
                    this.LogFunctionEndDebug(lvls_Return);
                }
            }

            return lvls_Return;
        }
        
        // \author Zoltan Hrabovszki
        // \date 2013.04.11
        @Override
        public void SetValue(ArrayList<String> fps_Values) throws XPathExpressionException
        {
            this.LogFunctionStartDebug("SetValue", "fps_Values", fps_Values.toString());

            try
            {
                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "Select()");
                    throw new OKWGUIObjectNotFoundException(lvsLM + "\\Locator: >>" + this.getLocator() + "<<");
                }

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
        public void Select(ArrayList<String> fps_Values) throws XPathExpressionException
        {
            this.LogFunctionStartDebug("Select", "fps_Values", fps_Values.toString());

            try
            {
                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "Select()");
                    throw new OKWGUIObjectNotFoundException(lvsLM + "\\Locator: >>" + this.getLocator() + "<<");
                }

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

        /// \brief
        /// Method verlässt die Checkbox unangehakt, egal ob sie vorher angehakt
        /// war oder nicht.<br/>
        /// __Anmerkung:__ Die Eigenschaft Elemen.Selected ist nicht beschreibar.
        /// Daher
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2013.04.11

        public void UnChecking()
        {
            this.LogFunctionStartDebug("UnChecking");

            try
            {
                // Hab ich ein Häckchen?
                if (this.IsSelected())
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
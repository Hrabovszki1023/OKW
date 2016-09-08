package okw.gui.adapter.selenium;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import okw.exceptions.OKWGUIObjectNotFoundException;
import okw.gui.OKWLocator;

/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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
    
    /// \brief
    /// SeListBox ist ein Selenium GUI-Objekt.
    /// Erbt von SeAnyWin
    /// 
    public class SeSelect extends SeAnyWin // , IOKW_ListDataObj, I
    {

        /// \brief
        /// TODO: Konstruktor des SeListBoxs.
        /// 
        /// \param Locator definiert die Objekterkennungseigenschaft des Objektes und wird als XPATH angegeben.
        /// \author Zoltán Hrabovszki
        /// \date 2013.04.18
        public SeSelect(String Locator, OKWLocator... fpLocators)
        {
        	super(Locator, fpLocators);
        }
        
        /// \~german
        /// \brief
        /// Methode wählt einen oder mehrere Werte in einer ListBox aus.
        /// 
        /// Die Methode Select löscht bereits ausgewählte _nicht_.
        /// 
        /// \param fps_Values Ein oder mehrere Werte, die ausgewählt werden sollen.
        /// \author Zoltan Hrabovszki
        /// \date 2013.04.11
        public void Select(ArrayList<String> fps_Values)
        {
            this.LogFunctionStartDebug("Select", "fps_Values", fps_Values.toString());

            try
            {
                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "Select()");
                    throw new OKWGUIObjectNotFoundException(lvsLM);
                }
                
                //org.openqa.selenium.support.ui.Select
                Select SelectList = new Select(this.Me());
                
                for (String lvsValue : fps_Values )
                {
                    SelectList.selectByVisibleText(lvsValue);
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }

            return;
        }

        /// \~german
        /// \brief
        /// Methode setzt einen oder mehrere Werte in einer ListBox.
        /// 
        /// Die Methode löscht zunächst  alle ausgewählten Werte in der Liste, wenn eine Mehrfachauswahl möglich ist
        /// ( Attribut _multiple_ ist gestzt.
        /// 
        /// Danach werden die gegebenen Werte ausgewählt.
        /// 
        /// Unterschied zu Select: Nach SetValue sind nur die gegebenen Werte ausgewählt.
        /// (Select wählt bereits ausgewählte werde einer Listbox nicht ab sonder ergeänzt diese um die gegebenen Werte.)
        /// \param fpsValues Werte, die in der Listbox ausgwählt werden sollen.
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.04.11
        public void SetValue( ArrayList<String> fpsValues)
        {
            this.LogFunctionStartDebug("SetValue", "fpsValues", fpsValues.toString());

            try
            {
                // Wenn das Objekt nicht existiert mit Exception beenden...
                if (!this.getExists())
                {
                    String lvsLM = this.LM.GetMessage("Common", "OKWGUIObjectNotFoundException", "Select()");
                    throw new OKWGUIObjectNotFoundException(lvsLM);
                }

                Select SelectList = new Select(this.Me());
                
                // Zunächst alle ausgwählten Werte der Listbox löschen, wenn eine mehrfachauswahl möglich ist...
                if (SelectList.isMultiple())
                {
                    SelectList.deselectAll();
                }
                else
                {
                    if (fpsValues.size() > 1)
                        MyLogger.LogError( "ListBox erlaub keine Mehrfachauswahl." );
                    // \todo TODO: Text in XML auslagern.
                    // \todo TODO: Exception für NichtErlaubte Mehrfachauswahl setzen.
                    
                }

                // Danach die gegebene Werte auswählen
                for (String lvsValue : fpsValues )
                {
                    SelectList.selectByVisibleText(lvsValue);
                }
            }
            finally
            {
                this.LogFunctionEndDebug();
            }

            return;
        }


        /// \~german
        /// \brief
        /// Holt die aktuell _ausgewählten_ Werte aus der ListBox.
        /// 
        /// Die ausgewählten Werte werden in der Reihenfolge _oben nach unten_ inder Rückgabe-Liste abgelegt.
        /// Sind keine Werte ausgewählt, dann ist die Rückgabe-Liste leer.
        /// leer und List.Count = 0.
        /// \returnListe der ausgewählten Werte\return
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014.12.04
        @Override
        public ArrayList<String> getValue()
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            Boolean bOK = false;
            
            try
            {
                MyLogger.LogFunctionStartDebug("GetValue");

                Select SelectList = new Select(this.Me());
                
                for (WebElement Option : SelectList.getAllSelectedOptions() )
                {
                    lvLsReturn.add( Option.getAttribute("textContent") );
                }

                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    MyLogger.LogFunctionEndDebug(lvLsReturn);
                }
                else
                {
                    MyLogger.LogFunctionEndDebug();
                }
            }
            
            return lvLsReturn;
        }
}
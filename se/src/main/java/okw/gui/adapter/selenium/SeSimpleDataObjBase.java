package okw.gui.adapter.selenium;

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

import java.util.ArrayList;

import okw.gui.*;

    /// \brief
    /// Description of SeSimpleDataObjBase.
    /// 
    public class SeSimpleDataObjBase extends SeAnyWin // , IOKW_SimpleDataObj
    {

        public SeSimpleDataObjBase(String Locator)
        {
        	super(Locator);
        }
        
        public SeSimpleDataObjBase(String fpsLocator, OKWLocator... fpLocators)
        {
        	super(fpsLocator, fpLocators) ;  	
        }


        /// \brief
        /// Ermittelt den Wert des Objktes für das Schlüsselwort Loggewert.
        /// 
        /// Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methoden überschreibung.
        /// 
        /// \return
        /// Rückgabe des Textuellen Inhaltes der markierten Textes.
        /// \return
        /// \author Zoltan Hrabovszki
        /// \date 2013.12.14
        @Override
        public ArrayList<String> LogValue() throws Exception
        {
            Boolean bOK = false;
            ArrayList<String> lvLsReturn = new ArrayList<String>();

            try
            {
                MyLogger.LogFunctionStartDebug("LogValue");
                lvLsReturn = this.getValue();
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

        /**  \~german
         *  Ermittelt den Wert, im Allgemeinen den textuellen Inhalt eines Objektes
         *  für das Schlüsselwort MerkeWert.
         *  
         *  Diese Methode ist der Einstiegspunkt für MerkeWert-Anpassungen durch Methodenüberschreibung.
         *  
         *  @return Rückgabe des Textuellen Inhaltes des aktuellen Objektes.
         *  \~english
         *  @return
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2013.12.14
         */
        @Override
        public ArrayList<String> MemorizeValue() throws Exception
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            Boolean bOK = false;

            try
            {
                MyLogger.LogFunctionStartDebug("Memorize");
                lvLsReturn = this.getValue();
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

        /**
         *  Ermittelt den textuellen Inhalt des markierten Textes für Prüfewert.
         *  
         *  Diese Methode ist der Einstiegspunkt für PrüfeWert-Anpassungen durch Methodenüberschreibung.
         *  
         *  @return
         *  Rückgabe des Textuellen Inhaltes der markierten Textes.
         *  Es wird immer der aktuelle Wert des Objektes zurückgeliefert.
         *  @return
         *  @author Zoltan Hrabovszki
         *  @date 2013.12.14
         *  @throws Exception 
         *
         */
        @Override
        @Deprecated
        public ArrayList<String> __VerifyValue(ArrayList<String> fplsExpectedValue) throws Exception
        {
            ArrayList<String> lvLsReturn = new ArrayList<String>();
            Boolean bOK = false;

            try
            {
                MyLogger.LogFunctionStartDebug("Memorize", "fplsExpectedValue", fplsExpectedValue.get(0));

                // Nun mit dem erwarteten Sollwert und GetValue ggf. auf den Wert Warten.
                lvLsReturn = this.getValue( );

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
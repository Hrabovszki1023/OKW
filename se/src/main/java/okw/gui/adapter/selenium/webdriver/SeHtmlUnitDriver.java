package okw.gui.adapter.selenium.webdriver;

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

import okw.OKW_FN;
import okw.gui.adapter.selenium.SeDriver;
import okw.gui.adapter.selenium.SeURL;
import okw.log.Logger_Sngltn;


    /// \~german
    /// \brief
    /// Implementiert den Selenium HTMLUnit-Driver 
    /// 
    /// 
    /// \todo TODO: Ausführliche Beschreibung
    /// 
    /// \~english
    /// \brief \todo TODO: Brief Description.
    /// 
    /// \todo TODO: Detailed Description
    /// 
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.05.12
    public class SeHtmlUnitDriver
    {
        protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();

        // =========================================================================
        // ChildObject of InternetExplorer...
        // =========================================================================
        @OKW_FN(FN="URL")
        public SeURL URL = new SeURL();

        /// \~german
        /// \brief Konstruktor der Klasse, aktuell keine MethodenAufrufe.
        /// 
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.12
        public SeHtmlUnitDriver()
        {
        	MyLogger.LogFunctionStartDebug("SeHtmlUnitDriver()");

        	MyLogger.LogFunctionEndDebug();
        }

        
        public void Init()
        {
        	MyLogger.LogFunctionStartDebug("Init()");

            //// this.URL.mydriver = this.driver;

        	MyLogger.LogFunctionEndDebug();
        }

        
        public void SelectWindow()
        {
        }

        /// \~german
        /// \brief Erzeugt eine Instanz des Selenium HTMLUnit-Drivers (RemoteDriver).
        /// 
        /// \todo TODO: Ausführliche Beschreibung
        /// 
        /// \param Parameterbezeichner \todo TODO: Beschreibung 
        /// \return
        ///
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        /// 
        /// \param fpbTrueOrFalse 
        /// \return
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.12

        public void StartApp()
        {
        	MyLogger.LogFunctionStartDebug("StartApp");

            SeDriver.getInstance().DriveUnitDriver();
            this.Init();

            MyLogger.LogFunctionEndDebug();
        }

        /// \~german
        /// \brief HTMLUnit-Driver Beenden. 
        /// 
        /// Beendet den HTMLUnit-Driver mit der Methode Quit()
        /// 
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        /// 
        /// \param fpbTrueOrFalse 
        /// \return
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.12
        public void StopApp()
        {
        	MyLogger.LogFunctionStartDebug("StopApp");

            SeDriver.getInstance().driver.quit();

            MyLogger.LogFunctionEndDebug();
        }

        public void TypeKey(ArrayList<String> fps_Values)
        {
        }

}
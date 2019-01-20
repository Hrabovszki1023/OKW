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

import java.util.ArrayList;
import org.openqa.selenium.safari.*;
import okw.gui.AnyWindow;
import okw.log.*;


    ///
    /// \brief
    /// OKW Selenium FireFox BrowserWindow Klasse
    /// 
    public class SeSafariApp extends AnyWindow
    {
        protected Logger_Sngltn MyLogger = Logger_Sngltn.getInstance();

        public SeSafariApp()
        {
        	MyLogger.LogFunctionStartDebug("SeFirefoxApp()");

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

        public void StartApp()
        {
        	MyLogger.LogFunctionStartDebug("StartApp");

        	
        	 SafariOptions options = new SafariOptions();
        	 //options.setUseCleanSession(true); //if you wish safari to forget session everytime

            SeDriver.getInstance().driver = new SafariDriver(options);
            this.Init();

            MyLogger.LogFunctionEndDebug();
        }
        
        
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
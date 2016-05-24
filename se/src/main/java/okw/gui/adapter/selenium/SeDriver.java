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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

    /// \brief
    /// Pattern Singelton
    /// 
    public class SeDriver
    {

        public WebDriver driver;

        /// \brief
        /// Singelton-Class: instanz hold the Object-Referenc of CurrentObject
        /// 
        private static SeDriver instance = new SeDriver();

        private SeDriver()
        {
        }


        /// \brief
        /// Gibt die Instance für die einzige Instanz dieser Klasse zurück.<br/>
        /// __Hinweis:__
        /// * Diese Klasse ist ein Singelton.
        ///   - Higylander Prinzip: Es kann nur eine Instanz von dieser Klasse geben!
        ///   - Verwenden Sie diese Eigenschaft um die Instance dieser Klasse zu erhalten.
        ///   - Es gibt keinen öffentlichen Konstruktor für Methode!
        /// 
        /// <value>
        /// The instance of CurrentObject.
        /// </value>
        /// \author Zoltan Hrabovszki
        /// \date 2012.11.29
        public static SeDriver getInstance()
        {
            return instance;
        }


        public void DriveChrome()
        {
            this.driver = new ChromeDriver();
        }

        public void DriveFireFox()
        {
            this.driver = new FirefoxDriver();
        }

        /*public void DriveInternetExplorer()
        {
            this.driver = new InternetExplorerDriver();
        }*/

        public void DriveUnitDriver()
        {
            this.driver = new HtmlUnitDriver(true);
        }

/*
        /// \~german
        /// \brief Erzeugt eine Instanz des HTMLnitDrivers
        /// 
        /// Wetergehende Dokumentaion sind hier zu finden: http://docs.seleniumhq.org/docs/03_webdriver.jsp#htmlunit-driver
        /// 
        /// \~english
        /// \brief \todo TODO: Brief Description.
        /// 
        /// \todo TODO: Detailed Description
        ///         ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2015.05.12
        public void DriveRemote()
        {
            
            var remoteServer = new Uri("http://localhost:4444/wd/hub/");
            var  desiredCapabilities = DesiredCapabilities.HtmlUnit();
			//var  desiredCapabilities = DesiredCapabilities.HtmlUnitWithJavaScript()
			desiredCapabilities.IsJavaScriptEnabled = true;

			this.driver= new RemoteWebDriver(remoteServer, desiredCapabilities);
            this.driver.Manage().Timeouts().ImplicitlyWait(new TimeSpan(0, 0, 30));
            //this.driver = new RemoteWebDriver(true);
        }*/
}
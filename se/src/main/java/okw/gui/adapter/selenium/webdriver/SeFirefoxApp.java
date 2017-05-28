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

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.firefox.FirefoxDriver;

import okw.OKW_Memorize_Sngltn;
import okw.gui.AnyWindow;
import okw.gui.adapter.selenium.*;
import okw.log.*;

/**
 * \brief OKW Selenium FireFox BrowserWindow Klasse
 */
public class SeFirefoxApp extends AnyWindow
{
    /**
     *  \copydoc Logger_Sngltn
     */
    private static Logger_Sngltn       LOG = Logger_Sngltn.getInstance();

    /**
     *  \copydoc OKW_Memorize_Sngltn
     */
    private static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();

    public SeFirefoxApp()
    {
        this.LogFunctionStartDebug( "SeFirefoxApp()" );

        this.LogFunctionEndDebug();
    }

    public void Init()
    {
        this.LogFunctionStartDebug( "Init()" );

        //// this.URL.mydriver = this.driver;

        this.LogFunctionEndDebug();
    }

    @Override
    public void SelectWindow()
    {
    }

    public void StartApp()
    {
        this.LogFunctionStartDebug( "StartApp" );

        try
        {

            String OKWGeckodriverPath = System.getenv( "OKWGeckodriverPath" );

            if ( OKWGeckodriverPath != null )
            {
                LOG.LogPrint( "EnvVar: OKWGeckodriverPath='" + OKWGeckodriverPath + "'" );
                System.setProperty( "webdriver.gecko.driver", OKWGeckodriverPath );

                MEM.set( "System.Property: webdriver.gecko.driver", OKWGeckodriverPath );
                MEM.set( "OKW EnvVar: OKWGeckodriverPath", OKWGeckodriverPath );
            }
            else
            {
                LOG.LogWarning( "Enviroment Variable 'OKWGeckodriverPath' is not set!" );

                /*
                 * Properties systemProperties = System.getProperties();
                 * Enumeration<?> enuProp = systemProperties.propertyNames();
                 * 
                 * List list= Collections.list(enuProp); // create list from
                 * enumeration Collections.sort(list); enuProp =
                 * Collections.enumeration(list);
                 * 
                 * 
                 * MyLogger.ResOpenList("System.getProperties()... ");
                 * 
                 * while (enuProp.hasMoreElements()) { String propertyName =
                 * (String) enuProp.nextElement(); String propertyValue =
                 * systemProperties.getProperty(propertyName);
                 * MyLogger.LogPrint(propertyName + ": " + propertyValue); }
                 * 
                 * MyLogger.ResCloseList();
                 */

                String os_name = System.getProperty( "os.name" );

                switch ( os_name )
                {
                    case "Mac OS X":
                        System.setProperty( "webdriver.gecko.driver", "/Applications/geckodriver" );
                        MEM.set( "System Propety: OKWGeckodriverPath", System.getProperty( "webdriver.gecko.driver" ) );
                        break;
                    default:
                        LOG.LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
                        break;
                }

            }

            LOG.LogPrint( "System Property: webdriver.gecko.driver='" + System.getProperty( "os.name" ) + "'" );

            SeDriver.getInstance().driver = new FirefoxDriver();
            this.Init();
        }
        catch (XPathExpressionException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    public void StopApp()
    {
        this.LogFunctionStartDebug( "StopApp" );

        SeDriver.getInstance().driver.quit();

        this.LogFunctionEndDebug();
    }

    public void TypeKey( ArrayList<String> fps_Values )
    {
    }

}
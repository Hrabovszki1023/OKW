/*
	    ==============================================================================
	      Author: Zoltán Hrabovszki <zh@openkeyword.de>

	      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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
package okw.gui.frames;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import okw.OKW;
import okw.OKW_Memorize_Sngltn;
import okw.OKW_Properties;
// import okw.gui.adapter.selenium.webdriver.*;
import okw.gui.adapter.selenium.SeBrowserWindow;


/**
 * \~
 * @defgroup groupSeleniumFrames OKW Frame-Klassen für Selenium
 * @ingroup groupSeleniumClasses
 * /todo Beschreibung...
 */

/**
 * @ingroup groupSeleniumFrames
 * \~german
 *  Frame Classe für Chrome implmentiert mit Chrome-Driver
 *  
 *  Zu diesem Frame gehört die Properties-Datei "frmSeChrome.properties".
 *  Alle Chrome Properties/Eigenschaften können gesetzt werden. Diese müssen mit "frmSeChrome.option." beginnen.
 *  
 *  
 *  Beispiel
 *  Hide the automation toolbar warning:
 *  frmSeChrome.option.disable-infobars=disable-infobars
 *  bewirkt: 
 *  ChromeOptions options = new ChromeOptions().addArguments( "disable-infobars" );
 *  
 *  Zusätzlich kann die Location der Chrome-Binär-datei als Property gesetzt werden:
 *  frmSeChrome.setBinary="/path/to/chrome"
 *  
 * \~english
 * \~
 * @author zh@openkeyword.de
 * \date 2019-08-22
 */
@OKW (FN="Chrome")
public class FrmSeChrome extends SeBrowserWindow
{

	OKW_Properties OKW_Prop = OKW_Properties.getInstance();

	/**
	 *  \copydoc OKW_Memorize_Sngltn
	 */
	protected static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();

	/**
	 * \~german
	 * Diese Methode ist gedacht um ein Fenster/Dialog in den Vordergrund zu holen. Bei Selenium ist das Nicht möglich.
	 * 
	 * Siehe dazu das folgende Zitat aus https://sqa.stackexchange.com/a/20035:
	 * 
	 * "Wenn Sie davon sprechen, das Browserfenster innerhalb des Betriebssystems in den Vordergrund zu rücken.
	 * Selenium kann das nicht. Sie müssen eine Bibliothek verwenden, die in der Lage ist, 
	 * Aktionen auf Betriebssystemebene zu automatisieren. 
	 * Selenium ist durch die gleiche Restriktion wie Javascript eingeschränkt.
	 * Sieht so aus, als ob du Java benutzt, also könntest du einen Blick auf awt.Robot werfen.
	 * Aber seien Sie sich bewusst, dass jede Lösung, die Sie mit Robot erfinden, wahrscheinlich schwierig ist...
	 * Der Code driver.switchTo().window(handle) ist nicht dazu gedacht, das aktive Fenster auf Betriebssystemebene zu wechseln.
	 * Es ändert nur, an welches Browserfenster Selenium seine Aktionen sendet.
	 * Selenium ist in der Lage, mit Browserfenstern zu kommunizieren, die hinter anderen Fenstern auf Ihrem Bildschirm versteckt sind."
	 * Zitiert aus https://sqa.stackexchange.com/a/20035
	 * 
	 * \~english
	 *  This method is intended to bring a window/dialog into the foreground. With Selenium this is not possible.
	 *  See the following quote from https://sqa.stackexchange.com/a/20035
	 *  "If you're talking about bringing the browser's window within the OS to the foreground. Selenium cannot do that.
	 *  
	 *  You need to introduce a library that is able to automate actions on an OS level.
	 *  Selenium is restricted by javascript's same origin policy. Looks like you're using Java, so you could take a look at awt.Robot.
	 *  But be aware that any solution you come up with using Robot will likely be finicky...
	 *  The driver.switchTo().window(handle) code is not meant to switch the active window on an OS level. 
	 *  It just changes which browser window selenium sends it's actions to. 
	 *  Selenium is able to communicate with browser windows that are hidden behind other windows on your screen.
	 *
	 * @param ? 
	 * @return
	 * \~
	 * @author Zoltán Hrabovszki
	 * \date 2019-07-16
	 */
	@Override
	public void SelectWindow()
	{
		LogPrint( "SelectWindow(): Do nothing..." );
	}

	/**
	 * Chrome Options https://github.com/GoogleChrome/chrome-launcher/blob/master/docs/chrome-flags-for-tools.md
	 */
	public void StartApp()
	{
		try
		{
			String DriverPath;

			if ( ( DriverPath = System.getProperty( "webdriver.chrome.driver" ) ) != null )
			{
				LogPrint( "System.Property: webdriver.chrome.driver is set: '" + DriverPath + "'" );
				MEM.set( "System.Property: webdriver.chrome.driver", DriverPath );
			}
			else if ( ( DriverPath = System.getenv( "OKWChromedriverPath" ) ) != null )
			{
				LogPrint( "System.Property: webdriver.chrome.driver is not set" );
				LogPrint( "EnvVar: OKWChromedriverPath='" + DriverPath + "'" );
				System.setProperty( "webdriver.chrome.driver", DriverPath );
				MEM.set( "System.Property: webdriver.chrome.driver", DriverPath );
				MEM.set( "OKW EnvVar: OKWChromedriverPath", DriverPath );
			}
			else
			{
				LogPrint( "System.Property: webdriver.chrome.driver is not set" );
				LogWarning( "Enviroment Variable 'OKWChromedriverPath' is not set!" );

				String os_name = System.getProperty( "os.name" );

				switch ( os_name )
				{
				case "Mac OS X":
					System.setProperty( "webdriver.chrome.driver", "/Applications/chromedriver" );
					break;
				case "Linux":
					System.setProperty( "webdriver.chrome.driver", "/usr/bin/chromedriver" );
					break;
				default:
					LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
					break;
				}
			}

			// get ChromeOptions from frmSeChrome.Propreties <-- OKW_Properties
			ArrayList<String> frmSeChrome_option = OKW_Properties.getInstance().getPropertiesForKeysStartswith( "frmSeChrome.option." );

			ChromeOptions options = new ChromeOptions().addArguments( frmSeChrome_option );

			// Sets the path to the Chrome executable.
			if ( OKW_Properties.getInstance().getProperty( "frmSeChrome.setBinary" ) != null )
				options.setBinary( OKW_Properties.getInstance().getProperty( "frmSeChrome.setBinary" ) ) ;


			mySeDriver.setDriver( new ChromeDriver( options ) );

		}
		catch (XPathExpressionException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException( e );
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void StopApp()
	{
		mySeDriver.getDriver().close();
		mySeDriver.getDriver().quit();

		try
		{    
			//Runtime rt = Runtime.getRuntime();

			if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
			{
				LogPrintDebug( "before windows taskkill Chrome " );
				//rt.exec("taskkill Chrome");
			}
			else
			{
				LogPrintDebug( "before linux/osx pkill -f Chrome " );
				// rt.exec("pkill -f Chrome");
				// rt.exec("killall chromedriver");
			} 

			//Thread.sleep( 3000 );
		}
		// catch (InterruptedException | IOException e)
		catch ( Exception e)
		{
			LogPrintDebug( "before catch (InterruptedException | IOException e)" );
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogPrintDebug( "after catch (InterruptedException | IOException e)" );
		}
	}    
}

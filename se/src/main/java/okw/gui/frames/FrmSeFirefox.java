package okw.gui.frames;

import okw.gui.adapter.selenium.SeBrowserWindow;
import okw.gui.adapter.selenium.webdriver.SeDriver;
import okw.log.Logger_Sngltn;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import okw.OKW;
import okw.OKW_Memorize_Sngltn;

/**
 * @ingroup groupSeleniumFrames
 * 
 * @author zoltan
 *
 */
@OKW (FN="Firefox")
public class FrmSeFirefox extends SeBrowserWindow
{

    /**
     *  \copydoc OKW_Memorize_Sngltn
     */
    private static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();

    @Override
    public void SelectWindow()
    {
    }

    /**
     * https://github.com/mdn/headless-examples/blob/master/headlessfirefox-gradle/src/main/java/com/mozilla/example/HeadlessFirefoxSeleniumExample.java
     * http://www.automationtestinghub.com/selenium-headless-chrome-firefox/
     * 
     * How to set Options
     * http://www.automationtestinghub.com/disable-firefox-logs-selenium/
     * 
     * https://www.youtube.com/watch?v=7q8viGgiVSc
     */
    public void StartApp()
    {
        LogFunctionStartDebug( "StartApp" );

        try
        {

            String OKWGeckodriverPath = System.getenv( "OKWGeckodriverPath" );

            if ( OKWGeckodriverPath != null )
            {
                LogPrint( "EnvVar: OKWGeckodriverPath='" + OKWGeckodriverPath + "'" );
                System.setProperty( "webdriver.gecko.driver", OKWGeckodriverPath );

                MEM.set( "System.Property: webdriver.gecko.driver", OKWGeckodriverPath );
                MEM.set( "OKW EnvVar: OKWGeckodriverPath", OKWGeckodriverPath );
            }
            else
            {
                LogWarning( "Enviroment Variable 'OKWGeckodriverPath' is not set!" );

                String os_name = System.getProperty( "os.name" );

                switch ( os_name )
                {
                    case "Mac OS X":
                        System.setProperty( "webdriver.gecko.driver", "/Applications/geckodriver" );
                        MEM.set( "System Propety: OKWGeckodriverPath", System.getProperty( "webdriver.gecko.driver" ) );
                        break;
                    default:
                        LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
                        break;
                }

            }

            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            //System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary(firefoxBinary);
                       
            mySeDriver.setDriver( new FirefoxDriver(firefoxOptions) );
        }
        catch (XPathExpressionException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            LogFunctionEndDebug();
        }
    }

    public void StopApp()
    {
        LogFunctionStartDebug( "StopApp" );

        //mySeDriver.getDriver().close();
        mySeDriver.getDriver().quit();

        LogFunctionEndDebug();
    }

    public void TypeKey( ArrayList<String> fps_Values )
    {
    }
}

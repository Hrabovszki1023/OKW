package okw.gui.frames;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.chrome.ChromeDriver;

import okw.OKW;
import okw.OKW_Memorize_Sngltn;
import okw.gui.OKWLocator;
// import okw.gui.adapter.selenium.webdriver.*;
import okw.gui.adapter.selenium.SeBrowserWindow;
import okw.gui.adapter.selenium.webdriver.SeDriver;
import okw.log.Logger_Sngltn;

/**
 * \~
 * @defgroup groupSeleniumFrames OKW Frame-Klassen für Selenium
 * @ingroup groupSeleniumClasses
 * /todo Beschreibung...
 */


/**
 * @ingroup groupSeleniumFrames
 * 
 * @author zoltan
 *
 */
@OKW (FN="Chrome")
public class FrmSeChrome extends SeBrowserWindow
{
    /**
     *  \copydoc Logger_Sngltn
     */
    private static Logger_Sngltn       LOG = Logger_Sngltn.getInstance();

    /**
     *  \copydoc OKW_Memorize_Sngltn
     */
    private static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();


    @Override
    public void SelectWindow()
    {
    }

    public void StartApp()
    {
        this.LogFunctionStartDebug( "StartApp" );

        try
        {

            String DriverPath = System.getenv( "OKWChromedriverPath" );

            if ( DriverPath != null )
            {
                LOG.LogPrint( "EnvVar: OKWChromedriverPath='" + DriverPath + "'" );
                System.setProperty( "webdriver.chrome.driver", DriverPath );
                MEM.set( "System.Property: webdriver.Chrome.driver", DriverPath );
                MEM.set( "OKW EnvVar: OKWChromedriverPath", DriverPath );
            }
            else
            {
                LOG.LogWarning( "Enviroment Variable 'OKWChromedriverPath' is not set!" );

                String os_name = System.getProperty( "os.name" );

                switch ( os_name )
                {
                    case "Mac OS X":
                        System.setProperty( "webdriver.chrome.driver", "/Applications/chromedriver" );
                        break;
                    default:
                        LOG.LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
                        break;
                }
            }

            LOG.LogPrint( "System Property: webdriver.chrome.driver='" + System.getProperty( "os.name" ) + "'" );

            SeDriver.getInstance().driver = new ChromeDriver();
        }
        catch (XPathExpressionException e)
        {
            // TODO Auto-generated catch block
            throw new RuntimeException( e );
        }
        finally
        {
            this.LogFunctionEndDebug();
        }
    }

    public void StopApp()
    {
        SeDriver.getInstance().driver.close();
    }
}

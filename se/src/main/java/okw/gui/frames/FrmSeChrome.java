package okw.gui.frames;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import okw.OKW;
import okw.OKW_Memorize_Sngltn;
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
     *  \copydoc OKW_Memorize_Sngltn
     */
    private static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();


    @Override
    public void SelectWindow()
    {
    }

    
    /**
     * Chrome Options https://github.com/GoogleChrome/chrome-launcher/blob/master/docs/chrome-flags-for-tools.md
     */
    public void StartApp()
    {
        LogFunctionStartDebug( "StartApp" );

        try
        {

            String DriverPath = System.getenv( "OKWChromedriverPath" );

            if ( DriverPath != null )
            {
                LogPrint( "EnvVar: OKWChromedriverPath='" + DriverPath + "'" );
                System.setProperty( "webdriver.chrome.driver", DriverPath );
                MEM.set( "System.Property: webdriver.Chrome.driver", DriverPath );
                MEM.set( "OKW EnvVar: OKWChromedriverPath", DriverPath );
            }
            else
            {
                LogWarning( "Enviroment Variable 'OKWChromedriverPath' is not set!" );

                String os_name = System.getProperty( "os.name" );

                switch ( os_name )
                {
                    case "Mac OS X":
                        System.setProperty( "webdriver.chrome.driver", "/Applications/chromedriver" );
                        break;
                    case "Linux":
                        System.setProperty( "webdriver.chrome.driver", "/Applications/chromedriver" );
                        break;
                    default:
                        LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
                        break;
                }
            }

            
            // Set options
            ChromeOptions options = new ChromeOptions();  

            // Using Headless Chrome?
            options.setHeadless(true);
            
            // Hide the automation toolbar warning
            options.addArguments( "disable-infobars" );
            
            //Start Chrome maximized
            options.addArguments( "start-maximized" );
            options.addArguments( "disable-logging" );
            options.addArguments( "version" );
            options.addArguments( "ignore-certificate-errors" );
            
            // options.addArguments( "disable-extensions");
            
            
            options.addArguments("incognito");
            
            options.addArguments( "test-type" );
            options.addArguments("start-maximized");
            options.addArguments("window-size=1920,1080");
            options.addArguments("enable-precise-memory-info");
            options.addArguments("disable-popup-blocking");
            options.addArguments("disable-default-apps");
            //options.addArguments( "test-type=browser" );
            
            mySeDriver.setDriver( new ChromeDriver(options) );
            //mySeDriver.setDriver( new ChromeDriver() );
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
        LogFunctionStartDebug( "StopApp()" );
        
        mySeDriver.getDriver().close();
        mySeDriver.getDriver().quit();
        
        try
        {    
             Runtime rt = Runtime.getRuntime();
        
             if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
             {
                 LogPrintDebug( "before windows taskkill Chrome " );
                 //rt.exec("taskkill Chrome");
             }
             else
             {
                 LogPrintDebug( "before linux/osx pkill -f Chrome " );
                 //rt.exec("pkill -f Chrome");
                 //rt.exec("killall chromedriver");
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
        finally
        {
            LogPrintDebug( "finaly.. " );
            LogFunctionEndDebug();
        }
    }    
}

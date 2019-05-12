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
    
    OKW_Properties OKW_Prop = OKW_Properties.getInstance();
    
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

            // get ChromeOptions from frmSeChrome.Propreties <-- OKW_Properties
            ArrayList<String> frmSeChrome_option = OKW_Properties.getInstance().getPropertiesForKeysStartswith( "frmSeChrome.option." );
            
            ChromeOptions options = new ChromeOptions().addArguments( frmSeChrome_option );
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
        finally
        {
            LogPrintDebug( "finaly.. " );
            LogFunctionEndDebug();
        }
    }    
}

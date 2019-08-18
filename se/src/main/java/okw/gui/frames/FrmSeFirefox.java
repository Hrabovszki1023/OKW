package okw.gui.frames;

import okw.gui.adapter.selenium.SeBrowserWindow;


import javax.xml.xpath.XPathExpressionException;


import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
    protected static OKW_Memorize_Sngltn MEM = OKW_Memorize_Sngltn.getInstance();

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

            String OKWGeckodriverPath;

            if ( ( OKWGeckodriverPath = System.getProperty( "webdriver.gecko.driver" ) ) != null )
            {
                LogPrint( "System.Property: webdriver.gecko.driver is set: '" + OKWGeckodriverPath + "'" );
                MEM.set( "System.Property: webdriver.gecko.driver", OKWGeckodriverPath );
            }
            else if ( ( OKWGeckodriverPath = System.getenv( "OKWGeckodriverPath" ) ) != null )
            {
                LogPrint( "System.Property: webdriver.gecko.driver is not set" );
                LogPrint( "EnvVar: OKWGeckodriverPath='" + OKWGeckodriverPath + "'" );
                System.setProperty( "webdriver.gecko.driver", OKWGeckodriverPath );

                MEM.set( "System.Property: webdriver.gecko.driver", OKWGeckodriverPath );
                MEM.set( "OKW EnvVar: OKWGeckodriverPath", OKWGeckodriverPath );
            }
            else
            {
                LogPrint( "System.Property: webdriver.gecko.driver is not set" );
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
            // firefoxBinary.addCommandLineOptions("--headless");
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
        LogFunctionStartDebug( "StopApp()" );
        
        // mySeDriver.getDriver().close();
        mySeDriver.getDriver().quit();
        
        try
        {    
             Runtime rt = Runtime.getRuntime();
        
             if (System.getProperty("os.name").toLowerCase().indexOf("windows") > -1)
             {
                 LogPrintDebug( "before windows taskkill geckodriver " );
                 //rt.exec("taskkill Chrome");
             }
             else
             {
                 LogPrintDebug( "before linux/osx pkill -f geckodriver" );
                 Process p = rt.exec("pkill -f geckodriver");
                 p.waitFor();
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

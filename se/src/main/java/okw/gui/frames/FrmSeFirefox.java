package okw.gui.frames;

import okw.gui.adapter.selenium.SeBrowserWindow;
import okw.gui.adapter.selenium.webdriver.SeDriver;
import okw.log.Logger_Sngltn;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.firefox.FirefoxDriver;

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
                        LogError( "Unknown Property: 'os.name'= '" + System.getProperty( "os.name" ) + "'" );
                        break;
                }

            }

            LogPrint( "System Property: webdriver.gecko.driver='" + System.getProperty( "os.name" ) + "'" );

            mySeDriver.setDriver( new FirefoxDriver() );
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

        mySeDriver.getDriver().close();
        mySeDriver.getDriver().quit();

        LogFunctionEndDebug();
    }

    public void TypeKey( ArrayList<String> fps_Values )
    {
    }
}

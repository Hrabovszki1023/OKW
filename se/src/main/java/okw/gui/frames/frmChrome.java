package okw.gui.frames;

import okw.OKW;
import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeChromeApp;

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
public class frmChrome extends SeChromeApp
{
    @OKW(FN="URL")
    public SeURL URL = new SeURL();
}

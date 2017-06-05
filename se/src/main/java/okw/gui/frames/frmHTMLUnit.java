package okw.gui.frames;

import okw.OKW;
import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeHtmlUnitDriver;

/**
 * @ingroup groupSeleniumFrames
 * 
 * @author zoltan
 *
 */
@OKW (FN="HTMLUnit")
public class frmHTMLUnit extends SeHtmlUnitDriver
{
    @OKW(FN="URL")
    public SeURL URL = new SeURL();
}

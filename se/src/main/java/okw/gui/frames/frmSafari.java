package okw.gui.frames;

import okw.gui.adapter.selenium.SeBrowserWindow;
import okw.gui.adapter.selenium.webdriver.*;
import okw.OKW;

/**
 * @ingroup groupSeleniumFrames
 * 
 * @author zoltan
 *
 */
@OKW (FN="Safari")
public class frmSafari extends SeBrowserWindow
{
    @OKW(FN="URL")
    public SeURL URL = new SeURL();
}

package okw.gui.frames;

import okw.OKW_FN;
import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeChromeApp;

@OKW_FN (FN="Chrome")
public class frmChrome extends SeChromeApp
{
    @OKW_FN(FN="URL")
    public SeURL URL = new SeURL();
}

package okw.gui.frames;

import okw.OKW;
import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeChromeApp;

@OKW (FN="Chrome")
public class frmChrome extends SeChromeApp
{
    @OKW(FN="URL")
    public SeURL URL = new SeURL();
}

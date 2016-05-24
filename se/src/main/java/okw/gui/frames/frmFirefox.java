package okw.gui.frames;

import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeFirefoxApp;
import okw.OKW_FN;

@OKW_FN (FN="Firefox")
public class frmFirefox extends SeFirefoxApp
{
    @OKW_FN(FN="URL")
    public SeURL URL = new SeURL();
}

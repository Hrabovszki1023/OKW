package okw.gui.frames;

import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.*;
import okw.OKW_FN;

@OKW_FN (FN="Safari")
public class frmSafari extends SeSafariApp
{
    @OKW_FN(FN="URL")
    public SeURL URL = new SeURL();
}

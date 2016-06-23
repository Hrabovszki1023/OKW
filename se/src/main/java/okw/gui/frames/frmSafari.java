package okw.gui.frames;

import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.*;
import okw.OKW;

@OKW (FN="Safari")
public class frmSafari extends SeSafariApp
{
    @OKW(FN="URL")
    public SeURL URL = new SeURL();
}

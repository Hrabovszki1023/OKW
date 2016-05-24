package okw.gui.frames;

import okw.OKW_FN;
import okw.gui.adapter.selenium.SeURL;
import okw.gui.adapter.selenium.webdriver.SeHtmlUnitDriver;

@OKW_FN (FN="HTMLUnit")
public class frmHTMLUnit extends SeHtmlUnitDriver
{
    @OKW_FN(FN="URL")
    public SeURL URL = new SeURL();
	
}

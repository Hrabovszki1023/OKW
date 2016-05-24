package okw.gui.frames.SeTextField;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

@OKW_FN (FN="SeTextField")
public class frmSeTextField extends SeBrowserChild
{
	@OKW_FN (FN="NichtVorhanden")
    public SeTextField NichtVorhanden = new SeTextField("//*[@name='NichtVorhanden']");

    @OKW_FN (FN="Vorname")
    public SeTextField Vorname = new SeTextField("//*[@name='Vorname']");

    @OKW_FN (FN="Name")
    public SeTextField Zuname = new SeTextField("//*[@name='Name']");


    public frmSeTextField( )
    {
    	super("//*[@title='Eingabefeld Disabled']");
    }

}
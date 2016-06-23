package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeTextField")
public class frmSeTextField extends SeBrowserChild
{
	@OKW (FN="NichtVorhanden")
    public SeTextField NichtVorhanden = new SeTextField("//*[@name='NichtVorhanden']");

    @OKW (FN="Vorname")
    public SeTextField Vorname = new SeTextField("//*[@name='Vorname']");

    @OKW (FN="Name")
    public SeTextField Zuname = new SeTextField("//*[@name='Name']");


    public frmSeTextField( )
    {
    	super("//*[@title='Eingabefeld Disabled']");
    }

}
package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeTextField")
public class frmSeTextField extends SeBrowserChild
{
	@OKW (FN="NichtVorhanden")
    public SeInputText NichtVorhanden = new SeInputText("//*[@name='NichtVorhanden']");

    @OKW (FN="Vorname")
    public SeInputText Vorname = new SeInputText("//*[@name='Vorname']");

    @OKW (FN="Name")
    public SeInputText Zuname = new SeInputText("//*[@name='Name']");


    public frmSeTextField( )
    {
    	super("//*[@title='Eingabefeld Disabled']");
    }

}
package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeTextField")
public class frmSeTextField extends SeBrowserChild
{
  
	  @OKW (FN="NichtVorhanden",
	          VerifyLabel_PT=500, VerifyLabel_TO=1,
	          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
	          VerifyValue_PT=500, VerifyValue_TO=1,
	          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
	          VerifyCaption_PT=500, VerifyCaption_TO=1,
	          VerifyExists_PT=500, VerifyExists_TO=1,
	          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
	          )
    public SeInputText NichtVorhanden = new SeInputText("//*[@name='NichtVorhanden']");

    @OKW (FN="Vorname",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeInputText Vorname = new SeInputText("//*[@name='Vorname']");

    @OKW (FN="Name",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeInputText Zuname = new SeInputText("//*[@name='Name']");


    public frmSeTextField( )
    {
    	super("//*[@title='Eingabefeld Disabled']");
    }

}
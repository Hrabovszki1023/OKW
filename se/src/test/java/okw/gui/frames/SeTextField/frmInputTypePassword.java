package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="InputTypePassword", 
WaitForMe_PT=500,
WaitForMe_TO=5
)
public class frmInputTypePassword extends SeBrowserChild
{
  
	  @OKW (FN="DoesNotExist",
	          VerifyLabel_PT=500, VerifyLabel_TO=1,
	          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
	          VerifyValue_PT=500, VerifyValue_TO=1,
	          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
	          VerifyCaption_PT=500, VerifyCaption_TO=1,
	          VerifyExists_PT=500, VerifyExists_TO=1,
	          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
	          WaitForMe_PT=500, WaitForMe_TO=1
	          )
    public SeInputText NichtVorhanden = new SeInputText("$L1$//*[@data-4test='NichtVorhanden']", this.getLOCATOR() );

	  
    @OKW (FN="User",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeInputText Vorname = new SeInputText("$L1$//*[@data-4test='User']", this.getLOCATOR() );

    @OKW (FN="Password",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1
            )
    public SeInputText Zuname = new SeInputText("$L1$//*[@data-4test='Password']", this.getLOCATOR() );

    public frmInputTypePassword( )
    {
        setLocator("//*[@data-4test='InputTypePassword']");
    }

}
package okw.gui.frames.setextfield;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="Scroll Into View InputTypeText",
      WaitForMe_PT=500,
      WaitForMe_TO=5
     )
public class frmInputTypeTextScrollIntoView extends SeBrowserChild
{
  
    @OKW (FN="First Name",
                    VerifyLabel_PT=500, VerifyLabel_TO=1,
                    VerifyIsActive_PT=500, VerifyIsActive_TO=1,
                    VerifyValue_PT=500, VerifyValue_TO=1,
                    VerifyTooltip_PT=500, VerifyTooltip_TO=1,
                    VerifyCaption_PT=500, VerifyCaption_TO=1,
                    VerifyExists_PT=500, VerifyExists_TO=1,
                    VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
                    VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
                    VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
                    VerifyMinLength_PT=500, VerifyMinLength_TO=1,
                    WaitForMe_PT=500, WaitForMe_TO=1
            )
    public SeInputText First_Name = new SeInputText("4T!First Name", this.getLOCATOR() );

    @OKW (FN="Last Name",
                    VerifyLabel_PT=500, VerifyLabel_TO=1,
                    VerifyIsActive_PT=500, VerifyIsActive_TO=1,
                    VerifyValue_PT=500, VerifyValue_TO=1,
                    VerifyTooltip_PT=500, VerifyTooltip_TO=1,
                    VerifyCaption_PT=500, VerifyCaption_TO=1,
                    VerifyExists_PT=500, VerifyExists_TO=1,
                    VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
                    VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
                    VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
                    VerifyMinLength_PT=500, VerifyMinLength_TO=1,
                    WaitForMe_PT=500, WaitForMe_TO=1
            )
    public SeInputText Last_Name = new SeInputText("4T!Last Name", this.getLOCATOR() );

    public frmInputTypeTextScrollIntoView( )
    {
        setLocator("4T!Scroll Into View InputTypeText");
    }

}
package okw.gui.frames.SeCheckBox;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="SeCheckBox")
public class frmSeCheckBox extends SeBrowserChild
{

    // \brief
    // Diese Objekt ist für VerifyExists eines nicht vorhandenen Kindobjektes da.
    @OKW (FN="NotExists", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
         )
    public SeInputCheckbox NotExists = new SeInputCheckbox("//*[@value='upss']");

    @OKW (FN="Pilze", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
         )
    public SeInputCheckbox Pilze = new SeInputCheckbox("//*[@value='pilze']");

    @OKW (FN="Salami", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
         )
    public SeInputCheckbox Salami = new SeInputCheckbox("//*[@value='salami']");

    @OKW (FN="Sardellen", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
         )
    public SeInputCheckbox Sardellen = new SeInputCheckbox("//*[@value='sardellen']");

    @OKW (FN="Disabled", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1
         )
    public SeInputCheckbox Disabled = new SeInputCheckbox("//*[@id='ID_Disabled']");

    public frmSeCheckBox()
    {
    	super("//*[@titel='Checkboxen definieren']");
    }
}
package okw.gui.frames.secheckbox;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="SeCheckBox")
public class frmSeCheckBox extends SeBrowserChild
{

    // \brief
    // Diese Objekt ist für VerifyExists eines nicht vorhandenen Kindobjektes da.
    @OKW (FN="NotExists",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            WaitForMe_PT = 500, WaitForMe_TO = 1
            )
    public SeCheckbox NotExists = new SeCheckbox("//*[@value='upss']");

    @OKW (FN="Pilze",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeCheckbox Pilze = new SeCheckbox("//*[@value='pilze']");

    @OKW (FN="Salami",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeCheckbox Salami = new SeCheckbox("//*[@value='salami']");

    @OKW (FN="Sardellen",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeCheckbox Sardellen = new SeCheckbox("//*[@value='sardellen']");

    @OKW (FN="Disabled",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeCheckbox Disabled = new SeCheckbox("//*[@id='ID_Disabled']");

    public frmSeCheckBox()
    {
        setLocator("//title[contains(text(),'Checkbox TestGUI 1')]/../..");
    }
}
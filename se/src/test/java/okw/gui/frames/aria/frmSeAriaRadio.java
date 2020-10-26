package okw.gui.frames.aria;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="SeAriaRadio")
public class frmSeAriaRadio extends SeBrowserChild
{
	
    @OKW (FN="Regular crust",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Regular_crust = new SeAriaRadio("//div[text()[contains(.,'Regular crust')]]");

    @OKW (FN="Deep dish",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Deep_dish = new SeAriaRadio("//div[text()[contains(.,'Deep dish')]]");

    @OKW (FN="Thin crust",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Thin_crust = new SeAriaRadio("//div[text()[contains(.,'Thin crust')]]");

 
    @OKW (FN="Pickup",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Pickup = new SeAriaRadio("//div[text()[contains(.,'Pickup')]]");
    
    @OKW (FN="Home Delivery",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Home_Delivery = new SeAriaRadio("//div[text()[contains(.,'Home Delivery')]]");
    
    @OKW (FN="Dine in",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Dine_in = new SeAriaRadio("//div[text()[contains(.,'Dine in')]]");

    public frmSeAriaRadio()
    {
        setLocator("//title[contains(text(),'Radio Group Example Using Roving tabindex')]/../..");
    }
}
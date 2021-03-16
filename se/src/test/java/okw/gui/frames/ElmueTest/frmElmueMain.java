package okw.gui.frames.ElmueTest;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="ELMŰ")
public class frmElmueMain extends SeBrowserChild
{
	
    @OKW (FN="KIMÈR",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Kimer = new SeAnyChildWindow("//span[contains( text(), 'KIM' )]/..");

	@OKW (FN="Törzsadatok",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Toerzsadatok = new SeAnyChildWindow("//span[text()='Törzsadatok']/..");


    @OKW (FN="Menue",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Tree = new SeAriaTree("(//*[@role='tree'])[1]");

    
    @OKW (FN="Password",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow last_action = new SeInputText("//*[@id='password']");

    public frmElmueMain()
    {

        setLocator("//title[contains(text(),'- ELMŰ')]/../..");
      //title[contains(text(),'File Directory Treeview Example Using Declared Properties')]/../..
    }
}
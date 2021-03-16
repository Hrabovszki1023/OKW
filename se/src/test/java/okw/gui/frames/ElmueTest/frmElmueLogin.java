package okw.gui.frames.ElmueTest;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="Elmue Login")
public class frmElmueLogin extends SeBrowserChild
{
	
    @OKW (FN="User",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow Tree = new SeInputText("//*[@id='username']");

    
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
    
    @OKW (FN="Belépés",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow loginButton = new SeAnyChildWindow("//*[@id=\"loginButton\"]");

    public frmElmueLogin()
    {
        setLocator("//*[@id=\"loginFormPanel\"]");
    }
}
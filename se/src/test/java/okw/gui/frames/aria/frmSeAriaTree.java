package okw.gui.frames.aria;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="SeAriaTree")
public class frmSeAriaTree extends SeBrowserChild
{
	
    @OKW (FN="Tree",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    // <ul role="tree" aria-labelledby="tree_label">
    public SeAriaTree Tree = new SeAriaTree("//*[@role='tree']");

    
    // <input id="last_action" type="text" size="15" readonly="">
    @OKW (FN="last_action",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeAnyChildWindow last_action = new SeInputText("//*[@id='last_action']");

    public frmSeAriaTree()
    {
        setLocator("//title[contains(text(),'File Directory Treeview Example Using Declared Properties')]/../..");        
    }
}
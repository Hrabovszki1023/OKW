package okw.gui.frames.SeSelect;

import okw.OKW;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeSelect;


@OKW( FN="SeListBoxMultiSelect")
public class frm_SeListBoxMultiSelect extends SeBrowserChild
{
    @OKW( FN="Künstler",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeSelect Künstler;


    public frm_SeListBoxMultiSelect()
    {
       super( "//form[@action = 'SelectMultiSelect.htm']/../.." );
       Künstler =  new SeSelect("//*[@name='Artist']");
    }

}
package okw.gui.frames.aria;

import okw.OKW;
import okw.gui.adapter.selenium.SeAnyChildWindow;
import okw.gui.adapter.selenium.SeAriaRadioGroup;
import okw.gui.adapter.selenium.SeBrowserChild;


/**
 * URL = https://www.w3.org/TR/wai-aria-practices-1.1/examples/radio/radio-1/radio-1.html
 * @author zoltan
 *
 */
@OKW( FN = "SeAriaRadioGroup" )
public class frmSeAriaRadioGroup extends SeBrowserChild
{

    @OKW( FN = "Does Not Exist", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public SeAnyChildWindow DoesNotExist= new SeAriaRadioGroup( "//title[@id='id_RadioList']" );

    /**
     * Pizza Crust:<br>
     * Mögliche Werte: "Regular crust", "Deep dish", "Thin crust"
     */
    @OKW( FN = "Pizza Crust", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public SeAnyChildWindow  mySeRadioGroup_1 = new SeAriaRadioGroup( "//*[@aria-labelledby='group_label_1']", this.getLOCATOR() );

    
    /**
     *  Pizza Delivery
     *  Mögliche Werte: "Regular crust", "Deep dish", "Thin crust"
     */
    @OKW( FN = "Pizza Delivery", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public SeAnyChildWindow  mySeRadioGroup_2 = new SeAriaRadioGroup( "//*[@aria-labelledby='group_label_2']", this.getLOCATOR() );

    public frmSeAriaRadioGroup() throws Exception
    {
        setLocator( "//title[contains(text(),'Radio Group Example Using Roving tabindex')]/../.." );
    }
}

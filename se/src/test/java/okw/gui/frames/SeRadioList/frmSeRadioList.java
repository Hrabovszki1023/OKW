package okw.gui.frames.SeRadioList;

import okw.OKW;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeInputRadio;
import okw.gui.adapter.selenium.SeRadioList;

@OKW( FN = "SeRadioList" )
public class frmSeRadioList extends SeBrowserChild
{

    @OKW( FN = "Does Not Exist", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public SeRadioList DoesNotExist;

    @OKW( FN = "Pay Method", VerifyLabel_PT = 500, VerifyLabel_TO = 1, VerifyValue_PT = 500, VerifyValue_TO = 1, VerifyTooltip_PT = 500, VerifyTooltip_TO = 1, VerifyCaption_PT = 500, VerifyCaption_TO = 1, VerifyIsActive_PT = 500, VerifyIsActive_TO = 1, VerifyExists_PT = 500, VerifyExists_TO = 1, VerifyHasFocus_PT = 500, VerifyHasFocus_TO = 1 )
    public PayMethod   mySeRadioList = new PayMethod( "//fieldset[@title='fieldset-title']", this.getLOCATOR() );

    public class PayMethod extends SeRadioList
    {

        public PayMethod( String Locator, OKWLocator... fpLocators )
        {
            super( Locator, fpLocators );
        }

        @OKW( FN = "Pay Method.Visa" )
        public SeInputRadio myVisa            = new SeInputRadio( "%1$s//input[@id='id_visa']", this.getLOCATOR() );

        @OKW( FN = "Pay Method.American Express" )
        public SeInputRadio myAmericanExpress = new SeInputRadio( "%1$s//input[@id='id_american_express']", this.getLOCATOR() );

        @OKW( FN = "Pay Method.Mastercard" )
        public SeInputRadio myMastercard      = new SeInputRadio( "%1$s//input[@id='id_mastercard']", this.getLOCATOR() );

    };

    public frmSeRadioList() throws Exception
    {
        // Set the Locator for the Window-Frame
        super( "//title[@id='id_RadioList']/../.." );

        // 
        DoesNotExist = new SeRadioList( "//title[@id='id_RadioList']" );

        // myVisa = new SeInputRadio( "%1$s//input[@id='id_visa']", this.getLOCATOR() );
        // myAmaricanExpress = new SeInputRadio( "%1$s//input[@id='id_amarican_express']", this.getLOCATOR() );
        // myMastercard = new SeInputRadio( "%1$s//input[@id='id_mastercard']", this.getLOCATOR() );
    }
}

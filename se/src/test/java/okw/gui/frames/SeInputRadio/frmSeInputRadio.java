package okw.gui.frames.SeInputRadio;

import okw.OKW;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeInputRadio;

/**
 * TestFrame für den Test der Klasse SeInputRadio.
 * 
 * Die SeInputRadio RadioButtons sind in diesem Frame nicht in SeRadioList zusammengefasst.
 */
@OKW(FN="SeInputRadioTestFrame")
public class frmSeInputRadio extends SeBrowserChild
{

      @OKW(FN="Does Not Exists", 
              VerifyLabel_PT=500, VerifyLabel_TO=1,
              VerifyValue_PT=500, VerifyValue_TO=1,
              VerifyTooltip_PT=500, VerifyTooltip_TO=1,
              VerifyCaption_PT=500, VerifyCaption_TO=1,
              VerifyExists_PT=500, VerifyExists_TO=1,
              VerifyIsActive_PT=500, VerifyIsActive_TO=1,
              VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
      public SeInputRadio DoesNotExist = new SeInputRadio("//title[@id='Does Not Exists']");

    @OKW( FN = "Visa", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
    public SeInputRadio myVisa            = new SeInputRadio( "//input[@id='id_visa']" );

    @OKW( FN = "American Express", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
    public SeInputRadio myAmericanExpress = new SeInputRadio( "//input[@id='id_american_express']" );

    @OKW( FN = "Mastercard", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
    public SeInputRadio myMastercard      = new SeInputRadio( "//input[@id='id_mastercard']" );

    @OKW( FN = "Inactive", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
    public SeInputRadio myInactive      = new SeInputRadio( "//input[@id='id_disabled']" );

    
    public frmSeInputRadio() throws Exception 
    {
       // Set the Locator for the Window-Frame
        setLocator("//title[@id='id_RadioList']/../..");
    }
}

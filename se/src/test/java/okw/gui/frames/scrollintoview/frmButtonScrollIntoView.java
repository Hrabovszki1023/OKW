package okw.gui.frames.scrollintoview;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="Scroll Into View Button",
      WaitForMe_PT=500,
      WaitForMe_TO=5
     )
public class frmButtonScrollIntoView extends SeBrowserChild
{
    
    @OKW (FN="Textfield oben",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
public SeTextarea Textfield_oben = new SeTextarea("4T!Textfield oben", this.getLOCATOR() );

    
    
    @OKW (FN="Button 1 oben",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
    
public SeButton Button1_oben = new SeButton("4T!Button 1 oben", this.getLOCATOR() );
    
    
    @OKW (FN="Button 2 oben",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
public SeButton Button2_oben = new SeButton("4T!Button 2 oben", this.getLOCATOR() );


    @OKW (FN="Textfield unten",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
public SeTextarea Textfield_unten = new SeTextarea("4T!Textfield unten", this.getLOCATOR() );

    
    @OKW (FN="Button 1 unten",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
    
public SeInputButton Button1_unten = new SeInputButton("4T!Button 1 unten", this.getLOCATOR() );
    
    
    @OKW (FN="Button 2 unten",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
            VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
            VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
            VerifyMinLength_PT=500, VerifyMinLength_TO=1,
            WaitForMe_PT=500, WaitForMe_TO=1
    )
public SeInputButton Button2_unten = new SeInputButton("4T!Button 2 unten", this.getLOCATOR() );
    
    
    public frmButtonScrollIntoView( )
    {
        setLocator("4T!ButtonScroll");
    }

}
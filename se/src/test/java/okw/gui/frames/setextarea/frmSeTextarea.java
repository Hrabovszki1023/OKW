package okw.gui.frames.setextarea;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeTextarea Proxy")
// http://test.openkeyword.de/Textarea/textarea.htm
public class frmSeTextarea extends SeBrowserChild
{
  
    @OKW (FN="ObjectNotExists", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
         )
    public SeTextarea NichtVorhanden = new SeTextarea("//*[@name='NichtVorhanden']");

    @OKW (FN="Textarea 1",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeTextarea Textarea = new SeTextarea("//*[@data-4test='Textarea 1']");

    @OKW (FN="Textarea 2",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeTextarea Textarea_2 = new SeTextarea("//*[@data-4test='Textarea 2']");

    @OKW (FN="Textarea MaxLength 40",
                    VerifyLabel_PT=500, VerifyLabel_TO=1,
                    VerifyIsActive_PT=500, VerifyIsActive_TO=1,
                    VerifyValue_PT=500, VerifyValue_TO=1,
                    VerifyTooltip_PT=500, VerifyTooltip_TO=1,
                    VerifyCaption_PT=500, VerifyCaption_TO=1,
                    VerifyExists_PT=500, VerifyExists_TO=1,
                    VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
                    VerifyMaxLength_PT=500, VerifyMaxLength_TO=1
                    )
    public SeTextarea Textarea_3 = new SeTextarea("//*[@data-4test='Textarea MaxLength 40']");

    public frmSeTextarea( )
    {
      setLocator("//body[@data-4test='textarea']");
    }
}
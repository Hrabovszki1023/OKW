package okw.gui.frames.SeTextarea;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeTextarea")
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
    public SeTextarea Textarea = new SeTextarea("//*[@id='ID_Textarea_1']");

    @OKW (FN="Textarea 2",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeTextarea Textarea_2 = new SeTextarea("//*[@id='ID_Textarea_2']");


    public frmSeTextarea( )
    {
      super("//*[@title='<textarea>']");
    }
}
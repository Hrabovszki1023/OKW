package okw.gui.frames.setextfield;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeInputTextReadonly",
WaitForMe_PT=500,
WaitForMe_TO=5
)
    public class frmSeInputTextReadonly extends SeBrowserChild
    {
	@OKW (FN="MwSt",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
          )
        public SeInputText MwSt = new SeInputText("//*[@name='mwst']");

	@OKW (FN="Preis",
          VerifyLabel_PT=500, VerifyLabel_TO=1,
          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
          VerifyValue_PT=500, VerifyValue_TO=1,
          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
          VerifyCaption_PT=500, VerifyCaption_TO=1,
          VerifyExists_PT=500, VerifyExists_TO=1,
          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
          )
        public SeInputText Preis = new SeInputText("//*[@name='preis']");

        public frmSeInputTextReadonly()
        {
            setLocator("//title[contains(text(),'Textfield TestGUI 4 input_type-text_readonly')]/../..");
        }
}
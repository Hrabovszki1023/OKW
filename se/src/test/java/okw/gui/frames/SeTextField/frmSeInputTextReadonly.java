package okw.gui.frames.SeTextField;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

@OKW_FN (FN="SeInputTextReadonly")
    public class frmSeInputTextReadonly extends SeBrowserChild
    {
	@OKW_FN (FN="MwSt")
        public SeTextField MwSt = new SeTextField("//*[@name='mwst']");

	@OKW_FN (FN="Preis")
        public SeTextField Preis = new SeTextField("//*[@name='preis']");

        public frmSeInputTextReadonly()
        {
        	super("//@title='Eingabefeld Readonly']");
        }
}
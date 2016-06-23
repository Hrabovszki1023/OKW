package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeInputTextReadonly")
    public class frmSeInputTextReadonly extends SeBrowserChild
    {
	@OKW (FN="MwSt")
        public SeTextField MwSt = new SeTextField("//*[@name='mwst']");

	@OKW (FN="Preis")
        public SeTextField Preis = new SeTextField("//*[@name='preis']");

        public frmSeInputTextReadonly()
        {
        	super("//@title='Eingabefeld Readonly']");
        }
}
package okw.gui.frames.SeTextField;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="SeInputTextReadonly")
    public class frmSeInputTextReadonly extends SeBrowserChild
    {
	@OKW (FN="MwSt")
        public SeInputText MwSt = new SeInputText("//*[@name='mwst']");

	@OKW (FN="Preis")
        public SeInputText Preis = new SeInputText("//*[@name='preis']");

        public frmSeInputTextReadonly()
        {
        	super("//@title='Eingabefeld Readonly']");
        }
}
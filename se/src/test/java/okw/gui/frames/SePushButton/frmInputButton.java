package okw.gui.frames.SePushButton;

import okw.OKW_FN;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SePushButton;
import okw.gui.adapter.selenium.SeTextField;

@OKW_FN (FN="InputButton")
    public class frmInputButton extends SeBrowserChild
    {
        /// \brief
        /// Anzeige feld im Fenster, hier ein Klick auf die knöpfe geprüft werden.
        /// 
        /// <textarea name="textfeld" rows="4" cols="20"></textarea>
	@OKW_FN (FN="Anzeige")
        public SeTextField Anzeige = new SeTextField("//*[@name='textfeld']");

	@OKW_FN (FN="NichtVorhanden")
        public SePushButton NichtVorhanden = new SePushButton("//*[@name='NichtVorhanden']");

	@OKW_FN (FN="Text_1")
        public SePushButton Text_1 = new SePushButton("//*[@name='Button 1']");

	@OKW_FN (FN="Text_2")
        public SePushButton Text_2 = new SePushButton("//*[@name='Button 2']");

	@OKW_FN (FN="Button_3")
        public SePushButton Button_3 = new SePushButton("//*[@name='Button 3']");

        /// \brief
        /// URL des Fensters: http://test.openkeyword.de/input_button.htm
        /// 
        public frmInputButton()
        {
            // <title>Klick-Buttons definieren(herkömmlich)</title>
            this.locator = new OKWLocator("//*[@title='Buttons definieren(herkömmlich)']");
        }
}
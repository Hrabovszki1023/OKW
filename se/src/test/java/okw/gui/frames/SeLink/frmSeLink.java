package okw.gui.frames.SeLink;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

    /// \~german
    /// \brief
    /// Selenium-Frame zur [Link-TestSeite](http://test.openkeyword.de/Link/Link.htm)
    ///

	@OKW_FN (FN="SeLink")
    public class frmSeLink extends SeBrowserChild
    {

		// @todo TODO: WorkAround for inherited object: Scanner doesnt collect inherited objects. 
		@OKW_FN (FN="URL")
		public SeURL URL = new SeURL(); 

		/// \~german
        /// \brief
        /// Dieses Objekt dient zur Existenzprüfung eines _nicht_
        /// vorhandenen SeLink-Objektes.
        /// 
	@OKW_FN (FN="LinkNotExists")
    public SeLink LinkNotExists = new SeLink("//*[@value='upss']");
        
        /// \~german
        /// \brief
        /// SeLink nach [Google](http://www.yahoo.de), Testseite enthält folgenden Link:
        /// <code><a href="http://www.google.de" name="Google_Link">Google...</a></code>
        /// 
	@OKW_FN (FN="Google")
        public SeLink Google;
        
        /// \~german
        /// \brief
        /// SeLink-Klasse nach [Yahoo](http://www.yahoo.de), Testseite enthält folgenden Link:
        /// <code><a href="http://www.yahoo.de" name="Yahoo_Link">Yahoo...</a></code>
        /// 
	@OKW_FN (FN="Yahoo")
        public SeLink Yahoo;

        public frmSeLink()
        {
        	super("//title[text()='OKW Link-Testpage']/../..");
        	
            this.Google = new SeLink("%1$s//*[@name='Google_Link']", getLOCATOR());
            this.Yahoo  = new SeLink("%1$s//*[@name='Yahoo_Link']", getLOCATOR());
        }
}

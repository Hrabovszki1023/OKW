package okw.gui.frames.SeLink;

import okw.OKW;
import okw.gui.adapter.selenium.*;

/// \~german
/// \brief
/// Selenium-Frame zur [Link-TestSeite](http://test.openkeyword.de/Link/Link.htm)

@OKW( FN = "SeLink" )
public class frmSeLink extends SeBrowserChild {

    // @todo TODO: WorkAround for inherited object: Scanner doesnt collect
    // inherited objects.
    @OKW( FN = "URL" )
    public SeURL  url           = new SeURL();

    // / \~german
    // / \brief
    // / Dieses Objekt dient zur Existenzprüfung eines _nicht_
    // / vorhandenen SeLink-Objektes.
    // /
    @OKW( FN = "LinkNotExists", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1 )
    public SeLink LinkNotExists = new SeLink( "//*[@value='upss']" );

    // / \~german
    // / \brief
    // / SeLink nach [Google](http://www.yahoo.de), Testseite enthält folgenden
    // Link:
    // / <code><a href="http://www.google.de"
    // name="Google_Link">Google...</a></code>
    // /
    @OKW( FN = "Google", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1 )
    public SeLink Google;

    // / \~german
    // / \brief
    // / SeLink-Klasse nach [Yahoo](http://www.yahoo.de), Testseite enthält
    // folgenden Link:
    // / <code><a href="http://www.yahoo.de"
    // name="Yahoo_Link">Yahoo...</a></code>
    // /
    @OKW( FN = "Yahoo", 
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1 )
    public SeLink Yahoo;

    public frmSeLink() {
      super( "//title[text()='OKW Link-Testpage']/../.." );

      this.Google = new SeLink( "%1$s//*[@name='Google_Link']", getLOCATOR() );
      this.Yahoo = new SeLink( "%1$s//*[@name='Yahoo_Link']", getLOCATOR() );
    }
}

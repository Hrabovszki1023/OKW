package okw.gui.frames.selink;

import okw.OKW;
import okw.gui.adapter.selenium.*;

/** \~german
 *  Selenium-Frame zur [Link-TestSeite](http://test.openkeyword.de/Link/Link.htm)
 */
@OKW( FN = "Link" )
public class frmLink extends SeBrowserChild {

    /** \~german
     *  Dieses Objekt dient zur Existenzprüfung eines _nicht_
     *  vorhandenen SeLink-Objektes.
     */
    @OKW( FN = "LinkNotExists",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeLink LinkNotExists = new SeLink( "//*[@value='upss']" );

    /** \~german
     *   SeLink nach [Google](http://www.yahoo.de), Testseite enthält folgenden
     *   Link:
     *   <code><a href="http://www.google.de"
     *            data-4test="Google>Google...</a></code>
     */
    @OKW( FN = "Google",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeLink Google = new SeLink( "$L1$//*[@data-harmony-id='Google']", this.getLOCATOR() );

    // / \~german
    // / \brief
    // / SeLink-Klasse nach [Yahoo](http://www.yahoo.de), Testseite enthält
    // folgenden Link:
    // / <code><a href="http://www.yahoo.de"
    // name="Yahoo_Link">Yahoo...</a></code>
    // /
    @OKW( FN = "Yahoo",
            VerifyLabel_PT=500, VerifyLabel_TO=1,
            VerifyIsActive_PT=500, VerifyIsActive_TO=1,
            VerifyValue_PT=500, VerifyValue_TO=1,
            VerifyTooltip_PT=500, VerifyTooltip_TO=1,
            VerifyCaption_PT=500, VerifyCaption_TO=1,
            VerifyExists_PT=500, VerifyExists_TO=1,
            VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
            )
    public SeLink Yahoo = new SeLink( "$L1$//*[@data-harmony-id='Yahoo']", this.getLOCATOR());

    public frmLink()
    {
        setLocator( "//*[@data-harmony-id='Link']" );
    }
}

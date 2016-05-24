package okw.gui.frames.SeCheckBox;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

@OKW_FN(FN="SeCheckBox")
public class frmSeCheckBox extends SeBrowserChild
{

    /// \brief
    /// Der Sinn dieses Objektes ist die ExistenzPrüfung eines nicht vorhandenen Kindobjektes
    ///
    @OKW_FN (FN="NotExists")
    public SeCheckBox NotExists = new SeCheckBox("//*[@value='upss']");

    @OKW_FN (FN="Pilze")
    public SeCheckBox Pilze = new SeCheckBox("//*[@value='pilze']");

    @OKW_FN (FN="Salami")
    public SeCheckBox Salami = new SeCheckBox("//*[@value='salami']");

    @OKW_FN (FN="Sardellen")
    public SeCheckBox Sardellen = new SeCheckBox("//*[@value='sardellen']");

    public frmSeCheckBox()
    {
    	super("//*[@titel='Checkboxen definieren']");
    }
}
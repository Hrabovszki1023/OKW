package okw.gui.frames.SeCheckBox;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN="SeCheckBox")
public class frmSeCheckBox extends SeBrowserChild
{

    /// \brief
    /// Der Sinn dieses Objektes ist die ExistenzPrüfung eines nicht vorhandenen Kindobjektes
    ///
    @OKW (FN="NotExists")
    public SeCheckBox NotExists = new SeCheckBox("//*[@value='upss']");

    @OKW (FN="Pilze")
    public SeCheckBox Pilze = new SeCheckBox("//*[@value='pilze']");

    @OKW (FN="Salami")
    public SeCheckBox Salami = new SeCheckBox("//*[@value='salami']");

    @OKW (FN="Sardellen")
    public SeCheckBox Sardellen = new SeCheckBox("//*[@value='sardellen']");

    public frmSeCheckBox()
    {
    	super("//*[@titel='Checkboxen definieren']");
    }
}
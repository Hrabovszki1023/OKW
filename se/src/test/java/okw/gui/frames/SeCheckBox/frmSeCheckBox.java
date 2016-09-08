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
    public SeInputCheckBox NotExists = new SeInputCheckBox("//*[@value='upss']");

    @OKW (FN="Pilze")
    public SeInputCheckBox Pilze = new SeInputCheckBox("//*[@value='pilze']");

    @OKW (FN="Salami")
    public SeInputCheckBox Salami = new SeInputCheckBox("//*[@value='salami']");

    @OKW (FN="Sardellen")
    public SeInputCheckBox Sardellen = new SeInputCheckBox("//*[@value='sardellen']");

    public frmSeCheckBox()
    {
    	super("//*[@titel='Checkboxen definieren']");
    }
}
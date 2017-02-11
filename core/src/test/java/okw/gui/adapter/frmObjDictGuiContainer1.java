package okw.gui.adapter;

import okw.OKW;

public class frmObjDictGuiContainer1
{
  /** \brief
   *  Anzeige ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_TextField.
   *  D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
   *  
   *  \author Zoltan Hrabovszki
   *  \date 2012.12.26
   */
  @OKW(FN="Name", 
  VerifyLabel_PT=500, VerifyLabel_TO=1,
  VerifyValue_PT=500, VerifyValue_TO=1,
  VerifyTooltip_PT=500, VerifyTooltip_TO=1,
  VerifyCaption_PT=500, VerifyCaption_TO=1)

  public Test_TextField myName = new Test_TextField("New Locator Name");

  
  /** \brief
   *  Anzeige ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_TextField.
   *  D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
   *  
   *  \author Zoltan Hrabovszki
   *  \date 2012.12.26
   */
  @OKW(FN="BirthDay", 
  VerifyLabel_PT=500, VerifyLabel_TO=1,
  VerifyValue_PT=500, VerifyValue_TO=1,
  VerifyTooltip_PT=500, VerifyTooltip_TO=1,
  VerifyCaption_PT=500, VerifyCaption_TO=1)

  public Test_TextField myBirthDay = new Test_TextField("New Locator BirthDay");
}

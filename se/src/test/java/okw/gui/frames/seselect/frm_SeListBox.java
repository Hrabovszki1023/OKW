package okw.gui.frames.seselect;

import okw.OKW;
import okw.gui.adapter.selenium.SeBrowserChild;
import okw.gui.adapter.selenium.SeSelect;

  
  @OKW(FN="SeListBox")
  public class frm_SeListBox extends SeBrowserChild
  {

      @OKW(FN="NichtVorhanden", 
              VerifyLabel_PT=500, VerifyLabel_TO=1,
              VerifyValue_PT=500, VerifyValue_TO=1,
              VerifyTooltip_PT=500, VerifyTooltip_TO=1,
              VerifyCaption_PT=500, VerifyCaption_TO=1,
              VerifyExists_PT=500, VerifyExists_TO=1,
              VerifyIsActive_PT=500, VerifyIsActive_TO=1,
              VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
      public SeSelect NichtVorhanden = new SeSelect("//*[@name='NichtVorhanden']");;

      @OKW(FN="Künstler", 
              VerifyLabel_PT=500, VerifyLabel_TO=1,
              VerifyValue_PT=500, VerifyValue_TO=1,
              VerifyTooltip_PT=500, VerifyTooltip_TO=1,
              VerifyCaption_PT=500, VerifyCaption_TO=1,
              VerifyIsActive_PT=500, VerifyIsActive_TO=1,
              VerifyExists_PT=500, VerifyExists_TO=1,
              VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
      public SeSelect Künstler =  new SeSelect("//*[@data-4test='Artist']");

      @OKW(FN="Blumen", 
              VerifyLabel_PT=500, VerifyLabel_TO=1,
              VerifyValue_PT=500, VerifyValue_TO=1,
              VerifyTooltip_PT=500, VerifyTooltip_TO=1,
              VerifyCaption_PT=500, VerifyCaption_TO=1,
              VerifyIsActive_PT=500, VerifyIsActive_TO=1,
              VerifyExists_PT=500, VerifyExists_TO=1,
              VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
      public SeSelect Blumen = new SeSelect("//*[@data-4test='Flowers']");

      @OKW(FN="Fahrzeug", 
              VerifyLabel_PT=500, VerifyLabel_TO=1,
              VerifyValue_PT=500, VerifyValue_TO=1,
              VerifyTooltip_PT=500, VerifyTooltip_TO=1,
              VerifyCaption_PT=500, VerifyCaption_TO=1,
              VerifyIsActive_PT=500, VerifyIsActive_TO=1,
              VerifyExists_PT=500, VerifyExists_TO=1,
              VerifyHasFocus_PT=500, VerifyHasFocus_TO=1)
      public SeSelect Fahrzeug = new SeSelect("//*[@data-4test='Vehicle']");

      public frm_SeListBox() 
      {
          setLocator( "//*[@data-4test='select']" );
      }

  }

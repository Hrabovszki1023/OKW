package okw.gui.frames;

import okw.OKW;
import okw.gui.container.wp_format;
import okw.gui.adapter.selenium.SeInputText;
import okw.gui.adapter.selenium.SeInputButton;


@OKW(FN="WP Add New Post")
public class wp_Add_New_Post extends wp_basewindow
{

  @OKW (FN="Title")
  public SeInputText Username = new SeInputText("%1$s//*[@id='title']", this.getLOCATOR() );

  // -------------------------
  // Main
  // -------------------------
  @OKW( FN = "Visual")
  public SeInputButton mceVisual = new SeInputButton( "%1$s//*[@id='mce-ico mce-i-bold']/..", this.getLOCATOR() );;

  @OKW( FN = "Text")
  public SeInputButton mceText = new SeInputButton( "%1$s//*[@id='mce-ico mce-i-bold']/..", this.getLOCATOR() );;
  
  //
  // Editor Toolbar
  @OKW( FN = "Bold")
  public SeInputButton Bold = new SeInputButton( "%1$s//*[@id='mce-ico mce-i-bold']/..", this.getLOCATOR() );;

  @OKW( FN = "Italic")
  public SeInputButton Log_In = new SeInputButton( "%1$s//*[@id='mce-ico mce-i-italic']/..", this.getLOCATOR() );;

  @OKW (FN="Content-editor")
  public SeInputText Content_Editor = new SeInputText("%1$s//*[@id='tinymce']", this.getLOCATOR() );
  

  // -------------------------
  // GUI object on the rigth
  // -------------------------
  @OKW (FN="Format")
  public wp_format myFormat = new wp_format( "%1$s//span[text() = 'Format']/../..", this.getLOCATOR() );

  
  public wp_Add_New_Post()
  {
    super("//body//h1[text()='Add New Post']/../../../../../..");
  }
}


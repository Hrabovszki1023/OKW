package okw.gui.container;

import okw.OKW;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeInputButton;
import okw.gui.adapter.selenium.SeInputRadio;
import okw.gui.adapter.selenium.SeRadioList;

public class wp_format extends SeRadioList
{

  public wp_format( String Locator )
  {
      super( Locator );
  }
  
  public wp_format( String Locator, OKWLocator... fpLocators )
  {
      super( Locator, fpLocators );
  }

  public SeInputButton ExpandButton = new SeInputButton( "%1$s//button[@class='handlediv button-link' and @aria-expanded='true']", this.getLOCATOR() );

  @OKW (FN="Format.Standard")
  public SeInputRadio myStandard = new SeInputRadio( "%1$s//input[@type='radio' and @value='standard']", this.getLOCATOR() );

  @OKW (FN="Format.Aside")
  public SeInputRadio myAside = new SeInputRadio( "%1$s//input[@type='radio' and @value='aside']", this.getLOCATOR() );

  @OKW (FN="Format.Image")
  public SeInputRadio myImage = new SeInputRadio( "%1$s//input[@type='radio' and @value='image']", this.getLOCATOR() );

  @OKW (FN="Format.Video")
  public SeInputRadio myVideo = new SeInputRadio( "%1$s//input[@type='radio' and @value='viseo']", this.getLOCATOR() );

  @OKW (FN="Format.Quote")
  public SeInputRadio myQuote = new SeInputRadio( "%1$s//input[@type='radio' and @value='quote']", this.getLOCATOR() );

  @OKW (FN="Format.Link")
  public SeInputRadio myLink = new SeInputRadio( "%1$s//input[@type='radio' and @value='link']", this.getLOCATOR() );

  @OKW (FN="Format.Gallery")
  public SeInputRadio myGallery = new SeInputRadio( "%1$s//input[@type='radio' and @value='gallery']", this.getLOCATOR() );

  @OKW (FN="Format.Status")
  public SeInputRadio myStatus = new SeInputRadio( "%1$s//input[@type='radio' and @value='status']", this.getLOCATOR() );

  @OKW (FN="Format.Audio")
  public SeInputRadio myAudio = new SeInputRadio( "%1$s//input[@type='radio' and @value='audio']", this.getLOCATOR() );

  @OKW (FN="Format.Chat")
  public SeInputRadio myChat = new SeInputRadio( "%1$s//input[@type='radio' and @value='char']", this.getLOCATOR() );
};

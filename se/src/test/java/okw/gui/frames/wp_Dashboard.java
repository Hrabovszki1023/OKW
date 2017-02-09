package okw.gui.frames;

import okw.OKW;


@OKW(FN="WP Dashboard")
public class wp_Dashboard extends wp_basewindow
{  
 
  public wp_Dashboard()
  {
    super("//body//h1[text()='Dashboard']/../../../../../..");
  }
}


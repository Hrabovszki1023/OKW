package okw.gui.frames;

import okw.gui.container.wp_admin_menu;
import okw.gui.OKWLocator;
import okw.gui.adapter.selenium.SeBrowserChild;

public class wp_basewindow extends SeBrowserChild
{
  // -------------------------
  // WP-admin-Menu on the left
  // -------------------------
  public wp_admin_menu AdminMenu = new wp_admin_menu("", this.getLOCATOR());


  public wp_basewindow(String fpsLocator, OKWLocator... fpLocators )
  {
    super( fpsLocator, fpLocators);
  }
}


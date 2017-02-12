package okw.gui;

import java.util.ArrayList;

public interface IGUIWindow
{
  ArrayList<String> getCaption();
  Boolean getExists();
  Boolean getIsActive();
  void SelectWindow() throws Exception;
}

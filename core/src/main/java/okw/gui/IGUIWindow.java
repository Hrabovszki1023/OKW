package okw.gui;

import java.util.ArrayList;

public interface IGUIWindow
{
  ArrayList<String> getCaption() throws Exception;
  Boolean getExists();
  Boolean getIsActive() throws Exception;
  void SelectWindow() throws Exception;
}

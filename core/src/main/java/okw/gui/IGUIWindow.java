package okw.gui;

import java.util.ArrayList;

public interface IGUIWindow
{
  ArrayList<String> getCaption();
  Boolean getExists();
  Boolean getIsActive();
    
  void TypeKeyWindow(ArrayList<String> Val);
  void SelectWindow();
  
  void StartApp();
  void StopApp();
  
  Boolean VerifyWindowExists();
  Boolean VerifyIsWindowActive();
  ArrayList<String> VerifyWindowCaption();
}

package okw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith( Suite.class )
@SuiteClasses(
{ // okw.SeBrowserChild.SeBrowserChild_EN_Firefox_Test.class,
  okw.SeInputButton.SeInputButton_EN_Firefox_Test.class,
  okw.SeInputCheckbox.SeInputCheckbox_Firefox_Test.class,
  okw.SeInputField.SeInputField_Firefox_Test.class,
  okw.SeInputRadio.SeInputRadio_EN_Firefox_Test.class,
  //okw.SeLink.SeLink_EN_Firefox_Test.class,
  okw.SeRadioList.SeRadioList_Firefox_Test.class,
  //okw.SeSelect.SeSelect_Firefox_Test.class,
  okw.SeTextarea.SeTextarea_Firefox_Test.class  
} )
public class AllSe_Firefox_Tests
{

}

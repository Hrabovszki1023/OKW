package okw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith( Suite.class )
@SuiteClasses(
{ // okw.SeBrowserChild..class,
  okw.SeInputButton.SeInputButton_EN_Chrome_Test.class,
  okw.SeInputCheckbox.SeInputCheckbox_Chrome_Test.class,
  okw.SeInputField.SeInputField_Chrome_Test.class,
  okw.SeInputRadio.SeInputRadio_EN_Chrome_Test.class,
  //okw.SeLink..class,
  okw.SeRadioList.SeRadioList_Chrome_Test.class,
  okw.SeSelect.SeSelect_Chrome_Test.class,
  okw.SeTextarea.SeTextarea_Chrome_Test.class  
} )
public class AllSe_Chrome_Tests
{

}

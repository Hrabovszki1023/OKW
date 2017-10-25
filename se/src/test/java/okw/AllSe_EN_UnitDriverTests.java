package okw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses({
    okw.SeBACK.SeBACK_EN_HTMLUnitDriver_Test.class,
    okw.SeBrowserChild.SeBrowserChild_EN_HTMLUnitDriver_Test.class,
    okw.SeButton.SeButton_EN_HTMLUnitDriver_Test.class,
    okw.SeInputButton.SeInputButton_EN_HTMLUnitDriver_Test.class,
    okw.SeInputCheckbox.SeInputCheckbox_EN_HTMLUnitDriver_Test.class,
    okw.SeInputField.SeInputField_EN_HTMLUnitDriver_Test.class,
    okw.SeInputRadio.SeInputRadio_EN_HTMLUnitDriver_Test.class,
    okw.SeLink.SeLink_EN_HTMLUnitDriver_Test.class,
    okw.SeMAXIMIZE.SeMAXIMIZE_EN_HTMLUnitDriver_Test.class,
    okw.SeRadioList.SeRadioList_EN_HTMLUnitDriver_Test.class,
    okw.SeSelect.SeSelect_EN_HTMLUnitDriver_Test.class,
    okw.SeTextarea.SeTextarea_EN_HTMLUnitDriver_Test.class,
              } )
public class AllSe_EN_UnitDriverTests
{

}

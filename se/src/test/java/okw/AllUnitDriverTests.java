package okw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses({
                okw.SeInputButton.SeInputButton_EN_HTMLUnitDriver_Test.class,
                okw.SeInputCheckbox.SeInputCheckbox_HTMLUnitDriver_Test.class,
                okw.SeInputField.SeInputField_HTMLUnitDriver_Test.class,
                okw.SeLink.SeLink_EN_HTMLUnitDriver_Test.class,
                okw.SeSelect.SeSelect_HTMLUnitDriver_Test.class,
                okw.SeTextarea.SeTextarea_HTMLUnitDriver_Test.class
              } )
public class AllUnitDriverTests
{

}

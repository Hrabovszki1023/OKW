package okw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses(
{
  fourTestLocatorTest.class,
  OKW_Const_Boolean2YesNo.class,
  OKW_Const_Concat_SEP_HSEP_VSEP.class,
  OKW_Const_GetConst4Internalname.class,
  OKW_Const_GetOKWConst4Internalname.class,
  OKW_Const_Split_SEP_HSEP_VSEP.class,
  OKW_Const_YesNo2Boolean.class,
  OKW_FileHelperTest.class,
  OKW_Helper_GetLeftFromDelimiterNumberTest.class,
  OKW_Helper_GetRightFromDelimiterNumberTest.class,
  OKW_Helper_MatchStrIgnoreCaseTest.class,
  OKW_Helper_MatchStrTest.class,
  OKW_Helper_RemoveBeginQuotationsTest.class,
  OKW_Helper_String2BooleanTest.class,
  OKW_Helper_StringIsNullOrEmpty.class,
  OKW_Helper_StringRepeat.class,  
  OKW_Helper_StringSplitTest.class,
  OKW_HelperTest.class,
  OKW_IniTest.class,
  OKW_TimeOut_Test.class,
  OKW_XmlReaderTest.class,
  OKW_PropertiesTest.class,
  } )

public class AllTests
{

}

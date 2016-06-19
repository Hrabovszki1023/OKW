<img src="https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" width="150px" height="78px" />

# OKW

OKW - OpenKeyWord is not a replacement, but rather a powerful extension to your existing test-framework, like JUnit or TestNG.

OKW is absolutely free, both for open source and commercial projects.

## Maven POM files

Here you can find all [OKW modules in Maven repository](https://search.maven.org/#search%7Cga%7C1%7Copenkeyword).

## Include OKW in your project

The fastest and easiest way is:

* Create a Maven Project.
* Add your unit test framework like JUnit as Maven dependency.
* Add an OpenKeyWord GUI-Adapter - At this moment OKW support Selenium only.
   But OKW is basically open for all GUI-testing-tools with a java-API.

   You have to define GUI-adapter for your testing-tool only.

```xml 
<dependency>
    <groupId>de.openkeyword</groupId>
    <artifactId>se</artifactId>
    <version>?.?.?</version>
</dependency>
```
* Maven: update project.

Now you can start with GUI-Test description with OKW-Keywords.

## The OKW Frame
The OKW-frame describes your GUI and is a technical-functional mapping.
See the simple example "Calculator".

The  Steps you have to do are:

1. Define for all test relevant GUI-Element a functional name (FN). 
2. Find the locators which identifies a GUI-Object. The goal is: OKW has to identify the GUI-Objects clearly. The OKW Selenium GUI-adapter uses XPATH as Locator.
3. Add GUI-Adapter (e.g. SeBrowserChild or SeTextField) for the specific GUI-Object to the Frame.
   * Define functional name with OKW annotation like this: '@OKW_FN( FN = "Display" )'.
   * Assign the GUI-Adapter with the specific locator.


### The Calculator Example
Here is a simple OKW-frame as example. 

```java
package okw.gui.frames.frmCalculator;

import okw.OKW_FN;
import okw.gui.adapter.selenium.*;

@OKW_FN(FN = "Calculator")
public class frmCalculator extends SeBrowserChild {

  @OKW_FN( FN = "Display" )
  public SeTextField  Display = new SeTextField( "//INPUT[@name='Display']" );

  @OKW_FN( FN = "1" )
  public SePushButton N1 = new SePushButton( "//input[@value='  1   ']");

  @OKW_FN( FN = "2" )
  public SePushButton N2 = new SePushButton( "//input[@value='  2   ']");

  @OKW_FN( FN = "3" )
  public SePushButton N3 = new SePushButton( "//input[@value='  3   ']");

  @OKW_FN( FN = "4" )
  public SePushButton N4 = new SePushButton( "//input[@value='  4   ']");

  @OKW_FN( FN = "5" )
  public SePushButton N5 = new SePushButton( "//input[@value='  5   ']");

  @OKW_FN( FN = "6" )
  public SePushButton N6 = new SePushButton( "//input[@value='  6   ']");

  @OKW_FN( FN = "7" )
  public SePushButton N7 = new SePushButton( "//input[@value='  7   ']");

  @OKW_FN( FN = "8" )
  public SePushButton N8 = new SePushButton( "//input[@value='  8   ']");

  @OKW_FN( FN = "9" )
  public SePushButton N9 = new SePushButton( "//input[@value='  9   ']");

  @OKW_FN( FN = "0" )
  public SePushButton N0 = new SePushButton( "//input[@value='  0   ']");

  @OKW_FN( FN = "." )
  public SePushButton Punkt = new SePushButton( "//INPUT[@type='button' and @value='*.*']" );

  @OKW_FN( FN = "+" )
  public SePushButton Plus = new SePushButton( "//input[@type='button' and @value='  +   ']" );

  @OKW_FN( FN = "-" )
  public SePushButton Minus = new SePushButton( "//input[@type='button' and @value='  -   ']" );

  @OKW_FN( FN = "/" )
  public SePushButton Durch = new SePushButton( "//input[@type='button' and @value='  /   ']" );

  @OKW_FN( FN = "*" )
  public SePushButton Mal  = new SePushButton( "//input[@type='button' and @value='  *   ']" );

  @OKW_FN( FN = "=" )
  public SePushButton Gleich = new SePushButton( "//input[@type='button' and @value='  =   ']" );

  @OKW_FN( FN = "C" )
  public SePushButton Clear  = new SePushButton( "//input[@type='reset' and @value='  C  ']" );

  @OKW_FN( FN = "sqrt" )
  public SePushButton Sqrt = new SePushButton( "//input[class='button'] type='button' value='sqrt '" );

  public frmCalculator() {
    
    // define Locator for Calculator main-window
    super( "//title[text()='Taschenrechner']/../.." );

  }
}
```


## The Testcase with OKW Keywords

A test case with OKW-Keywords is simple and easy to understand. You understand every single step.
The test case is not littered with unnecessary things like incomprehensible technical terms.
This terrible technical matters are outsourced to the GUI-frame and GUI-adapter. 

```java
  @Test
  public void tc_Calculator_Addition() throws Exception
  {

   EN.BeginTest( "tc_Calculator_Addition" );
   
   EN.StartApp( "Firefox" );
   EN.SetValue( "URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm" );

   EN.SelectWindow( "Calculator" );
   EN.ClickOn( "1" );
   EN.ClickOn( "+" );
   EN.ClickOn( "1" );
   EN.ClickOn( "=" );

   EN.VerifyValue( "Display", "2" );
   
   EN.StopApp( ApplicationName );
   EN.EndTest();
   
  }

```




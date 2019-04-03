[![Build Status](https://travis-ci.org/Hrabovszki1023/OKW.svg?branch=master)](https://travis-ci.org/Hrabovszki1023/OKW)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e53cf4dc539d4aac9c1f29b7320d28a8)](https://www.codacy.com/app/Hrabovszki1023/OKW?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Hrabovszki1023/OKW&amp;utm_campaign=Badge_Grade)

[![MV OKW Se](https://maven-badges.herokuapp.com/maven-central/de.openkeyword/se/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.openkeyword/se)

[![MV OKW log2html](https://maven-badges.herokuapp.com/maven-central/de.openkeyword/log2html/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.openkeyword/log2html)

<img src="https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" width="150px" height="78px" />

# OKW

OKW - OpenKeyWord is a powerful extension to your existing test-framework such as 

* JUnit 
* TestNG
* Cucumber ( [Cucumber Calculator Example](https://github.com/Hrabovszki1023/OKW/wiki/Cucumber-Calculator-Example) )

OKW is absolutely free, both for open source projects and commercial projects.

## OKW Wiki-Pages 
Here you can find the OKW Wiki-Pages:

* [DoxyGen-Docu (german)](https://hrabovszki1023.github.io/OKW/html/index.html)
* [Wiki-Home](https://github.com/Hrabovszki1023/OKW/wiki)
* [List of OKW KeyWords](https://github.com/Hrabovszki1023/OKW/wiki/List-of-OKW-Keywords)
* [List of OKW Constants](https://github.com/Hrabovszki1023/OKW/wiki/List-of-OKW-Constants)

## Maven POM files

Here you can find all [OKW modules in Maven repository](https://search.maven.org/#search%7Cga%7C1%7Copenkeyword).

## Include OKW in your project

The fastest and easiest way is:

* Create a Maven Project.
* Add your unit test framework like JUnit as Maven dependency.
* Add an OpenKeyWord GUI-Adapter: At the moment OKW supports Selenium only, but OKW is basically open for all GUI-testing-tools with a java-API and can be adapted easily.

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
   * Define functional name with OKW annotation like this: '@OKW( FN = "Display" )'.
   * Assign the GUI-Adapter with the specific locator.


### The Calculator Example
Here is a simple OKW-frame as example. 

```java
package okw.gui.frames.frmCalculator;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW(FN = "Calculator")
public class frmCalculator extends SeBrowserChild {

  @OKW( FN = "Display" )
  public SeTextField  Display = new SeTextField( "//INPUT[@name='Display']" );

  @OKW( FN = "1" )
  public SePushButton N1 = new SePushButton( "//input[@value='  1   ']");

  @OKW( FN = "2" )
  public SePushButton N2 = new SePushButton( "//input[@value='  2   ']");

  @OKW( FN = "3" )
  public SePushButton N3 = new SePushButton( "//input[@value='  3   ']");

  @OKW( FN = "4" )
  public SePushButton N4 = new SePushButton( "//input[@value='  4   ']");

  @OKW( FN = "5" )
  public SePushButton N5 = new SePushButton( "//input[@value='  5   ']");

  @OKW( FN = "6" )
  public SePushButton N6 = new SePushButton( "//input[@value='  6   ']");

  @OKW( FN = "7" )
  public SePushButton N7 = new SePushButton( "//input[@value='  7   ']");

  @OKW( FN = "8" )
  public SePushButton N8 = new SePushButton( "//input[@value='  8   ']");

  @OKW( FN = "9" )
  public SePushButton N9 = new SePushButton( "//input[@value='  9   ']");

  @OKW( FN = "0" )
  public SePushButton N0 = new SePushButton( "//input[@value='  0   ']");

  @OKW( FN = "." )
  public SePushButton Punkt = new SePushButton( "//INPUT[@type='button' and @value='*.*']" );

  @OKW( FN = "+" )
  public SePushButton Plus = new SePushButton( "//input[@type='button' and @value='  +   ']" );

  @OKW( FN = "-" )
  public SePushButton Minus = new SePushButton( "//input[@type='button' and @value='  -   ']" );

  @OKW( FN = "/" )
  public SePushButton Durch = new SePushButton( "//input[@type='button' and @value='  /   ']" );

  @OKW( FN = "*" )
  public SePushButton Mal  = new SePushButton( "//input[@type='button' and @value='  *   ']" );

  @OKW( FN = "=" )
  public SePushButton Gleich = new SePushButton( "//input[@type='button' and @value='  =   ']" );

  @OKW( FN = "C" )
  public SePushButton Clear  = new SePushButton( "//input[@type='reset' and @value='  C  ']" );

  @OKW( FN = "sqrt" )
  public SePushButton Sqrt = new SePushButton( "//input[class='button'] type='button' value='sqrt '" );

  public frmCalculator() {
    
    // define Locator for Calculator main-window
    super( "//title[text()='Taschenrechner']/../.." );

  }
}
```
## Codecovereg

<img src="https://codecov.io/gh/Hrabovszki1023/OKW/commit/72cdbb8e5173b36b915d373688e89228154debd4/graphs/sunburst.svg"/>

* https://codecov.io/gh/Hrabovszki1023/OKW/commit/72cdbb8e5173b36b915d373688e89228154debd4/graphs/sunburst

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




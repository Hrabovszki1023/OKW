<img src="https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" width="150px" height="78px" />

# OKW

OKW - OpenKeyWord is not a replacement, but rather a powerful extension to your existing test-framework, like junit or TestNG.

OKW is absolutely free, both for open source and commercial projects.

## Maven POM files

Here you can find all [OKW modules in Maven repository](https://search.maven.org/#search%7Cga%7C1%7Copenkeyword).

## Include OKW in your project

The fastest and easiest way is:

* to create a Maven Project
* add your unittest-framework like junit as maven dependency
* add an openkeyword GUI-Adapter (e.g. se for Selenium) as maven dependency to your project

```xml 
<dependency>
    <groupId>de.openkeyword</groupId>
    <artifactId>se</artifactId>
    <version>?.?.?</version>
</dependency>
```
* maven: update project 

Now you can basically start with GUI-Test description with OKW-Keywords.



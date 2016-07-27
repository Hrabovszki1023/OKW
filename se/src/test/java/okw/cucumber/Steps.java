package okw.cucumber;

import okw.core.EN;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps
{
  @Given("^Calculator is started$")
  public void calculator_is_started() throws Throwable {
      EN.StartApp( "Firefox" );
      EN.TypeKey( "URL", "http://www.schulferien.org/taschenrechner/taschenrechner.html");
  }
  
  @Then("^I Close Calculator$")
  public void close_Calculator() throws Throwable {
      EN.StopApp( "Firefox" );
  }

  @Given("^The Calculator exists$")
  public void the_Calculator_exists() throws Throwable {
    EN.SelectWindow("Calculator");    
    EN.VerifyExists( "Display", "YES" );
  }

  @When("^I enter \"([^\"]*)\" into the calculator$")
  public void i_enter_into_the_calculator(String arg1) throws Throwable {
    
    EN.SelectWindow( "Calculator" );

    for( int i=0; i< arg1.length(); i++)
    {  
      EN.ClickOn( Character.toString(arg1.charAt(i)) );
    }
  }

  @When("^I press \"([^\"]*)\"$")
  public void i_press(String arg1) throws Throwable {
    
    EN.SelectWindow( "Calculator" );
    EN.ClickOn( arg1 );

  }

  @Then("^the Calculator displays \"([^\"]*)\"$")
  public void the_Calculatron_displayy(String arg1) throws Throwable {
    
    EN.SelectWindow( "Calculator" );
    EN.VerifyValue( "Display", arg1 );

  }
}


package okw.cucumber;

import okw.core.EN;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps
{
  
  @Then("^I Close Calculator$")
  public void close_Calculator() throws Throwable {
      EN.StopApp( "Firefox" );
  }

  public void typecalculator(String arg1) throws Throwable{
        for( int i=0; i< arg1.length(); i++)
    {  
      EN.ClickOn( Character.toString(arg1.charAt(i)) );
    }
  }
  
  @Given("^I use the calculater$")
  public void i_use_the_calculater() throws Throwable{
    EN.StartApp( "Firefox" );
    EN.TypeKey( "URL", "http://www.schulferien.org/taschenrechner/taschenrechner.html");
    EN.SelectWindow( "Calculator" );

  }

  @When("^I enter \"([^\"]*)\" into the calculator$")
  public void i_enter_into_the_calculator(String arg1) throws Throwable {
    this.typecalculator( arg1 );
   }
  
  @When("^I add \"([^\"]*)\"$")
  public void i_add(String arg1) throws Throwable{
    EN.SelectWindow( "Calculator" );

    EN.ClickOn( "+" );
    this.typecalculator( arg1 );
    EN.ClickOn( "=" );
  }

  @When("^I subtract \"([^\"]*)\"$")
  public void i_subtract(String arg1) throws Throwable{
    EN.SelectWindow( "Calculator" );

    EN.ClickOn( "-" );
    this.typecalculator( arg1 );
    EN.ClickOn( "=" );
  }

  @When("^I divide by \"([^\"]*)\"$")
  public void i_divide_by(String arg1) throws Throwable {
    EN.SelectWindow( "Calculator" );

    EN.ClickOn( "/" );
    this.typecalculator( arg1 );
    EN.ClickOn( "=" );
  }

  @When("^I multiply by \"([^\"]*)\"$")
  public void i_multiply_by(String arg1) throws Throwable {
      EN.SelectWindow( "Calculator" );

      EN.ClickOn( "*" );
      this.typecalculator( arg1 );
      EN.ClickOn( "=" );
  }

  @Then("^the calculated result is \"([^\"]*)\"$")
  public void the_calculated_result_is(String arg1) throws Throwable {
    EN.SelectWindow( "Calculator" );
    EN.VerifyValue( "Display", arg1 );
  }
}


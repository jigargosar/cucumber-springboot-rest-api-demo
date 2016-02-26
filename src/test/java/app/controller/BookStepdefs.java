package app.controller;

import app.Application;
import app.repository.BookRepository;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
//@WebAppConfiguration
//@IntegrationTest


@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class BookStepdefs {

  @Autowired
  private BookRepository bookRepository;


  @Given("^a book with following details$")
  public void aBookWithFollowingDetails(DataTable dataTable) throws Throwable {
    Assert.assertNotNull(bookRepository);
  }

  @When("^I add it$")
  public void iAddIt() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^response should be$")
  public void responseShouldBe() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
}

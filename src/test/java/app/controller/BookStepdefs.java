package app.controller;

import app.Application;
import app.model.Book;
import app.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


//@ContextConfiguration(classes = Application.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class BookStepdefs {

  public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Autowired
  private BookRepository bookRepository;
  private Book book;
  private RestTemplate restTemplate = new TestRestTemplate();
  private AddBookResponse addBookResponse;


  @Given("^a book with following details$")
  public void aBookWithFollowingDetails(List<Book> books) throws Throwable {
    book = books.get(0);
  }


  @Then("^response should be$")
  public void responseShouldBe(String json) throws Throwable {
    assertThat(addBookResponse.message, is(""));
  }

  @Given("^a system with an empty books repository$")
  public void aSystemWithAnEmptyBooksRepository() throws Throwable {
    bookRepository.deleteAll();
  }

  @When("^client adds the book$")
  public void clientAddsTheBook() throws Throwable {
    HttpEntity<String> httpEntity = httpEntity(book);
    addBookResponse = restTemplate.postForObject("http://localhost:8000/book", httpEntity, AddBookResponse.class);
  }

  static class AddBookResponse {
    String message;
    Book book;
  }

  private HttpEntity<String> httpEntity(Object object) throws JsonProcessingException {
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(object), requestHeaders);
  }


}

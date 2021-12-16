package fit.exemplo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {
  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void testHello() {
    // arrange
    var expected = "Hello Spring Boot!";

    // act
    ResponseEntity<String> response = restTemplate.getForEntity("/Hello", String.class);

    // assert
    assertThat(response.getBody()).isEqualTo(expected);
  }
}

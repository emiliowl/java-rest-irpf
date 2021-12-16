package fit.exemplo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import fit.exemplo.models.PersonVm;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IrpfControllerTest {
  @Autowired
  TestRestTemplate restTemplate;

  @Test
  void testCalculateIrpf() {
    // arrange
    var person = new PersonVm(3000.00, 0, 2021);
    var expected = 57.45;
  
    // act
    ResponseEntity<Double> response = restTemplate.postForEntity("/irpf/calculate", person, Double.class);
  
    // assert
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody().intValue()).isEqualTo((int)expected);
  }
  
}

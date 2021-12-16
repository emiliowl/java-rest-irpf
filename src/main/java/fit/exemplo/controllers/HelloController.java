package fit.exemplo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fit.exemplo.models.PersonVm;

// {myapp.com}/Hello
// http://localhost:8080/Hello
@RestController
@RequestMapping("Hello")
public class HelloController {

  /**
   * {myapp.com}/Hello/
   * http://localhost:8080/Hello/
   * @return
   */
  @GetMapping
  public String index() {
    return "Hello Spring Boot!";
  }

  @GetMapping("/Custom")
  public String custom(@RequestParam(value = "name", defaultValue = "Spring") String name) {
    return String.format("Hello %s!", name);
  }

  @PostMapping("/Custom")
  public String customPost(@RequestBody PersonVm person) {
    return String.format("Hello %s!", person.getName());
  }
}

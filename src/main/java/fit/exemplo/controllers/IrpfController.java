package fit.exemplo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.exemplo.core.IrpfCalculator;
import fit.exemplo.domain.Person;
import fit.exemplo.models.PersonVm;

@RestController
@RequestMapping("/irpf")
public class IrpfController {
  @PostMapping("/calculate")
  public Double calculate(@RequestBody PersonVm vm) {
    var person = new Person(vm.getSalary(), vm.getDependents());
    return new IrpfCalculator(vm.getYear(), person).calculate();
  }
}

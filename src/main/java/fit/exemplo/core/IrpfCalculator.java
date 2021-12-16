package fit.exemplo.core;

import fit.exemplo.application.abstracts.DiscountTable;
import fit.exemplo.application.abstracts.RateTable;
import fit.exemplo.application.factories.DiscountTableFactory;
import fit.exemplo.application.factories.RateTableFactory;
import fit.exemplo.domain.Person;

public class IrpfCalculator {

  private Person person;
  private DiscountTable discountTable;
  private RateTable rateTable;

  public IrpfCalculator(int year, Person person) {
    System.out.println("Inicializando calculadora...");
    this.person = person;
    this.discountTable = DiscountTableFactory.build(year);
    this.rateTable = RateTableFactory.build(year);
  }

  public double calculateBaseSalary() {
    System.out.println("Calculando salário base...");
    var totalSalary = this.person.getTotalSalary();
    var inss = this.rateTable.getInssValue(totalSalary);
    var dependentsDisccount = this.discountTable.getDependentsValue(this.person.getDependents());

    return totalSalary - inss - dependentsDisccount;
  }

  public double calculateDiscount() {
    System.out.println("Calculando salário com descontos...");
    return this.calculateBaseSalary() - this.discountTable.calculateExemption();
  }

  public double calculate() {
    System.out.println("Realizando cálculo completo...");
    var discountValue = this.calculateDiscount();
    var taxValue = this.rateTable.getTaxLayer(this.calculateBaseSalary());

    System.out.println("Cálculo completo finalizado...");
    return discountValue * taxValue;
  }

}

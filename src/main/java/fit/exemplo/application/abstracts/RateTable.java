package fit.exemplo.application.abstracts;

public interface RateTable {
    public double getInssValue(double baseSalary);
    public double getTaxLayer(double baseSalary);
}

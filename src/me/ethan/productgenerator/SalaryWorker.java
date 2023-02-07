package me.ethan.productgenerator;

import java.util.Objects;

public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int birthYear, double hourlyPayRate, double annualSalary) {
        super(ID, firstName, lastName, title, birthYear, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalaryWorker that = (SalaryWorker) o;
        return Double.compare(that.annualSalary, annualSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return (annualSalary/52);
    }
    @Override
    public String displayWeeklyPay(double hoursWorked) {
        return "Weekly Pay: " + Double.toString(annualSalary/52) + " Total Salary: " + annualSalary;
    }
}

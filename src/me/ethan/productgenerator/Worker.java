package me.ethan.productgenerator;

import java.util.Objects;

public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int birthYear, double hourlyPayRate) {
        super(ID, firstName, lastName, title, birthYear);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Double.compare(worker.hourlyPayRate, hourlyPayRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyPayRate);
    }

    /**
     * @param hoursWorked The hours the worker has worked input as a double
     * @return returns the pay for the worker this week, given the hours worked as double
     */

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked<= 40) {
            return hoursWorked * hourlyPayRate;
        } else if (hoursWorked> 40) {
            double overtimeHours = hoursWorked-40;
            return (40*hourlyPayRate) + (overtimeHours*hourlyPayRate*1.5);
        }
        return hoursWorked * hourlyPayRate;
    }
    public String displayWeeklyPay(double hoursWorked) {
        if (hoursWorked<= 40) {
            return "Total Hours Worked: "  + hoursWorked + " Total Pay: " + Double.toString(hoursWorked * hourlyPayRate);
        } else if (hoursWorked> 40) {
            double overtimeHours = hoursWorked-40;
            return "Total Hours Worked: " + hoursWorked + "Overtime Hours Worked: " + Double.toString(40-hoursWorked) + "Overtime Pay: " + Double.toString(overtimeHours*1.5*hourlyPayRate) + "Total Pay: " + Double.toString((40*hourlyPayRate) + (overtimeHours*hourlyPayRate*1.5));
        }
        return Double.toString(hoursWorked * hourlyPayRate);
    }

}

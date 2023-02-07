import me.ethan.inheritence.SalaryWorker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryWorkerTest {

    SalaryWorker sw1, sw2;


    @BeforeEach
    void setUp() {
        sw1 = new SalaryWorker("00001", "John", "Doe", "Mr.", 2000, 0, 60000);
        sw2 = new SalaryWorker("00002", "Jane", "Buck", "Mrs.", 1999, 0, 52000);
    }


    @Test
    void getAnnualSalary() {
        assertEquals(60000, sw1.getAnnualSalary());
    }
    @Test
    void setAnnualSalary() {
        sw1.setAnnualSalary(52000);
        assertEquals(52000, sw1.getAnnualSalary());
    }
    @Test
    void equals() {
        sw1.setID("00002");
        sw1.setFirstName("Jane");
        sw1.setLastName("Buck");
        sw1.setTitle("Mrs.");
        sw1.setBirthYear(1999);
        sw1.setHourlyPayRate(0);
        sw1.setAnnualSalary(52000);
        assertEquals(true, sw1.equals(sw2));
    }

    @Test
    void calculateWeeklyPay() {
        sw1.setAnnualSalary(60000);
        assertEquals(1153.8461538461538, sw1.calculateWeeklyPay(40));
    }
    @Test
    void displayWeeklyPay() {
        sw1.setAnnualSalary(60000);
        assertEquals("Weekly Pay: 1153.8461538461538 Total Salary: 60000.0", sw1.displayWeeklyPay(40));
    }

}

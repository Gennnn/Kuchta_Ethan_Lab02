import me.ethan.inheritence.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    Worker w1, w2;


    @BeforeEach
    void setUp() {
        w1 = new Worker("00001", "John", "Doe", "Mr.", 2000, 17.60);
        w2 = new Worker("00002", "Jane", "Buck", "Mrs.", 1999, 15.40);
    }

    @Test
    void getHourlyPay() {
        assertEquals(17.60, w1.getHourlyPayRate());
    }

    @Test
    void setHourlyPayRate() {
        w1.setHourlyPayRate(15.40);
        assertEquals(15.40, w1.getHourlyPayRate());
    }
    @Test
    void equals() {
        w1.setID("00002");
        w1.setFirstName("Jane");
        w1.setLastName("Buck");
        w1.setTitle("Mrs.");
        w1.setBirthYear(1999);
        w1.setHourlyPayRate(15.40);
        assertEquals(true, w1.equals(w2));
    }

    @Test
    void calculateWeeklyPay() {
        w1.setHourlyPayRate(17.60);
        assertEquals(704, w1.calculateWeeklyPay(40));
    }
    @Test
    void displayWeeklyPay() {
        w1.setHourlyPayRate(17.60);
        assertEquals("Total Hours Worked: 40.0 Total Pay: 704.0", w1.displayWeeklyPay(40));
    }

}

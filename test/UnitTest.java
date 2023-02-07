import me.ethan.productgenerator.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    Person p1, p2;


    @BeforeEach
    void setUp() {
        p1 = new Person("00001", "John", "Doe", "Mr.", 2000);
        p2 = new Person("00002", "Jane", "Buck", "Mrs.", 1999);
    }

    @Test
        void getIDNum() {
            assertEquals("00001", p1.getID());
    }

    @Test
    void getPersonFirstName() {
        assertEquals("John", p1.getFirstName());
    }

    @Test
    void getPersonLastName() {
        assertEquals("Doe", p1.getLastName());
    }

    @Test
    void getTitle() {
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void getBirthYear() {
        assertEquals(2000, p1.getBirthYear());
    }

    @Test
    void setPersonID() {
        p1.setID("00002");
        assertEquals("00002", p1.getID());
    }

    @Test
    void setPersonFirstName() {
        p1.setFirstName("Jane");
        assertEquals("Jane", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Buck");
        assertEquals("Buck", p1.getLastName());

    }

    @Test
    void setTitle() {
        p1.setTitle("Mrs.");
        assertEquals("Mrs.", p1.getTitle());

    }

    @Test
    void setBirthYEAR() {
        p1.setBirthYear(1999);
        assertEquals(1999, p1.getBirthYear());
    }

    @Test
    void equals() {
        p1.setID("00002");
        p1.setFirstName("Jane");
        p1.setLastName("Buck");
        p1.setTitle("Mrs.");
        p1.setBirthYear(1999);
        assertEquals(true, p1.equals(p2));


    }

    @Test
    void fullName() {
        p1.setFirstName("John");
        p1.setLastName("Doe");
        assertEquals("John Doe", p1.fullName());


    }
    @Test
    void formalName() {
        p1.setFirstName("John");
        p1.setLastName("Doe");
        p1.setTitle("Mr.");
        assertEquals("Mr. John Doe", p1.formalName());


    }
    @Test
    void getAge() {
        p1.setBirthYear(2000);
        assertEquals(23, p1.getAge());


    }
    @Test
    void getAgeSetYear() {
        p1.setBirthYear(2000);
        assertEquals(2, p1.getAge(2002));


    }
}

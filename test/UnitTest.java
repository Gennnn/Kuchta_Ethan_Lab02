import me.ethan.productgenerator.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    Product p1, p2;


    @BeforeEach
    void setUp() {
        p1 = new Product(00001, "Apple", "Red round fruit", 2.99);
        p2 = new Product(00002, "Banana", "Yellow curved fruit", 1.99);
    }

    @Test
        void getIDNum() {
            assertEquals(00001, p1.getID());
    }

    @Test
    void getProductName() {
        assertEquals("Apple", p1.getName());
    }

    @Test
    void getProductDesc() {
        assertEquals("Red round fruit", p1.getDescription());
    }

    @Test
    void getProductPrice() {
        assertEquals(2.99, p1.getPrice());
    }

    @Test
    void setProductID() {
        p1.setID(00002);
        assertEquals(00002, p1.getID());
    }

    @Test
    void setProductName() {
        p1.setName("Banana");
        assertEquals("Banana", p1.getName());
    }

    @Test
    void setProductDesc() {
        p1.setDescription("Yellow curved fruit");
        assertEquals("Yellow curved fruit", p1.getDescription());

    }

    @Test
    void setProductPrice() {
        p1.setPrice(1.99);
        assertEquals(1.99, p1.getPrice());
    }

    @Test
    void equals() {
        p1.setID(00002);
        p1.setName("Banana");
        p1.setDescription("Yellow curved fruit");
        p1.setPrice(1.99);
        System.out.println(p1.toCSVDataRecord());
        System.out.println(p2.toCSVDataRecord());
        assertEquals(true, p1.toCSVDataRecord().equals(p2.toCSVDataRecord()));


    }
}

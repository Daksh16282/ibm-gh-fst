
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity1_Test {

    public static List<String> list;

    @BeforeAll
    public static void setUp() {
        list = new ArrayList<>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    @Order(1)
    public void insertTest() {
        // checking size
        assertEquals(2, list.size(), "Wrong Size Value -> " + list);
        list.add("gamma");
        assertEquals(3, list.size(), "Wrong Size Value");
        // Checking elements
        assertEquals("alpha", list.get(0), "Wrong Element");
        assertEquals("beta", list.get(1), "Wrong Element");
        assertEquals("gamma", list.get(2), "Wrong Element");
    }

    @Test
    @Order(2)
    public void replaceTest() {
        // checking size
        assertEquals(3, list.size(), "Wrong Size Value");
        list.add("gamma");
        assertEquals(4, list.size(), "Wrong Size Value");
        // Checking elements
        list.set(1, "theta");
        assertEquals("alpha", list.get(0), "Wrong Element");
        assertEquals("theta", list.get(1), "Wrong Element");
        assertEquals("gamma", list.get(2), "Wrong Element");
    }

}

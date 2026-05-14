
import com.example.MyCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCollectionTest {

    @Test
    public void testRemove1() {
        MyCollection coll = new MyCollection(5);
        coll.add("apple");
        coll.add("banana");
        coll.remove("apple");
        assertEquals(1, coll.size());
    }


    @Test
    public void testRemoveException2() {
        MyCollection coll = new MyCollection(5);
        assertThrows(IllegalArgumentException.class, () -> coll.remove("apple")); // If the list is empty, it throws an IllegalArgumentException
    }

    @Test
    public void testRemoveException3() {
        MyCollection coll = new MyCollection(5);
        coll.add("apple");
        assertThrows(IllegalArgumentException.class, () -> coll.remove("banana")); // If the String is not in the list, it throws an IllegalArgumentException
    }

    @Test
    public void testEmpty() {
        MyCollection coll = new MyCollection(3);
        coll.add("a");
        coll.add("b");
        coll.empty();
        assertEquals(0, coll.size());
    }
}

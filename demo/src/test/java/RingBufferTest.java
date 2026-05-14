import com.example.RingBuffer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferTest {

    @Test
    public void testIsEmpty() {
        RingBuffer<String> buffer = new RingBuffer<>(2);
        assertTrue(buffer.isEmpty());
    }

    @Test
    public void testSize() {
        RingBuffer<Integer> buffer = new RingBuffer<>(5);
        buffer.push(1);
        buffer.push(2);
        assertEquals(2, buffer.size());
    }

    @Test
    public void testPushAndPop() {
        RingBuffer<Integer> buffer = new RingBuffer<>(3);
        buffer.push(10);
        assertEquals(10, buffer.pop());
    }



    @Test
    public void testException0() {
        RingBuffer<Integer> buffer = new RingBuffer<>(2);
        assertThrows(RuntimeException.class, buffer::pop);
    }

    @Test
    public void testException1() {
        RingBuffer<Integer> buffer = new RingBuffer<>(2);
        buffer.push(10);
        buffer.push(20);
        assertThrows(RuntimeException.class, () -> buffer.push(30));
    }


    // white-box tests

   @Test
   public void testWrap() {
       RingBuffer<Integer> buffer = new RingBuffer<>(2);
       buffer.push(10);
       buffer.push(20);
       buffer.pop(); // pop one
       buffer.push(30); // push again to test wrap
       assertEquals(20, buffer.pop());
       assertEquals(30, buffer.pop());
   }

   @Test
   public void testIteratorNext() {
       RingBuffer<Integer> buffer = new RingBuffer<>(3);
       buffer.push(10);
       buffer.push(20);

       Iterator<Integer> iterator = buffer.iterator();
       assertTrue(iterator.hasNext());
       assertEquals(10, iterator.next());
       assertTrue(iterator.hasNext());
       assertEquals(20, iterator.next());
       assertFalse(iterator.hasNext());
   }

   @Test
   public void testIteratorException() {
       RingBuffer<String> buffer = new RingBuffer<>(2);
       Iterator<String> iterator = buffer.iterator();
       assertThrows(NoSuchElementException.class, iterator::next);
   }

   @Test
   public void testIteratorRemoveUnsupported() {
       RingBuffer<Integer> buffer = new RingBuffer<>(1);
       Iterator<Integer> iterator = buffer.iterator();
       assertThrows(UnsupportedOperationException.class, iterator::remove);
   }

   @Test
   public void testIterator1() {
       RingBuffer<Integer> buffer = new RingBuffer<>(3);
       buffer.push(10);
       buffer.push(20);
       buffer.push(30);
       buffer.pop();
       buffer.push(40);

       List<Integer> items = new ArrayList<>();
       for (int item : buffer) {
           items.add(item);
       }

       List<Integer> expected = List.of(20, 30, 40);
       assertEquals(expected, items);
   }

}

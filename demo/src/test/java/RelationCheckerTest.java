import com.example.RelationChecker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelationCheckerTest {

    @Test
    public void testStatAndBrunch1() {
        // x < y is false, x + y < 25 is true
        int result = RelationChecker.checkRelation(0, 0);
        assertEquals(0, result); // u = x = 0, w = 0, v = u + y = 0 + 0
    }

    @Test
    public void testStatAndBrunch2() {
        // x < y is true, x + y >= 25
        int result = RelationChecker.checkRelation(10, 17);
        assertEquals(22, result); // u = y = 17, w = 2, v = u + x/w = 17 + 10/2 = 22
    }



}

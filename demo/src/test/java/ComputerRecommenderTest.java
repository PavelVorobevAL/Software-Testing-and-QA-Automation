import com.example.ComputerRecommender;
import com.example.ComputerType;
import com.example.InvalidBudgetException;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComputerRecommenderTest {

    /* maxbudget = -1 --> result - Exception
       maxbudget = 0 --> result - ENTRYLVLPC
        maxbudget = 450 --> result - ENTRYLVLPC
        maxbudget = 451 --> result - BDGTPC
        maxbudget = 600 --> result - BDGTPC
        maxbudget = 601 --> result - GAMINGPC (LB)
        maxbudget = 1500 --> result - Exception (UB)
        maxbudget = 1501 --> result - ENTHUSIASTPC (LB of EP5)

    */

    ComputerRecommender pc = new ComputerRecommender();

    @Test
    void testInvalidBudget() {
        assertThrows(InvalidBudgetException.class, () -> {
            pc.getRecommendedComputerTypePerBudget(-1);}
        );
    }

    @Test
    void testEntryLvl_LB() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVLPC, pc.getRecommendedComputerTypePerBudget(0));
    }

    @Test
    void testEntryLvl_UP() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVLPC, pc.getRecommendedComputerTypePerBudget(450));
    }

    @Test
    void testBudgt_LB() throws InvalidBudgetException {
        assertEquals(ComputerType.BDGTPC, pc.getRecommendedComputerTypePerBudget(451));
    }

    @Test
    void testBudgt_UB() throws InvalidBudgetException {
        assertEquals(ComputerType.BDGTPC, pc.getRecommendedComputerTypePerBudget(600));
    }

    @Test
    void testGaming_LB() throws InvalidBudgetException {
        assertEquals(ComputerType.GAMINGPC, pc.getRecommendedComputerTypePerBudget(601));
    }

    @Test
    void testGaming_UB() throws InvalidBudgetException {
        assertEquals(ComputerType.GAMINGPC, pc.getRecommendedComputerTypePerBudget(1500));
    }

    @Test
    void testEnthusiast() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTHUSIASTPC, pc.getRecommendedComputerTypePerBudget(1501));
    }
}



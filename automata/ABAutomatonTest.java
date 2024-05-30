import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * TODO 3: FIll in your names and student IDs
 * @author Horia-George Dună
 * @id 1949284
 * @author Radu-Cristian Sarău
 * @id 1939149
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        // Test 1: Randomly picked truth values
        boolean[] test1 = {true, true, true, false, true, false, false, false, true, false, false};
        assertEquals("*** *   *  ", ABAutomaton.genToString(test1));
        
        // Test 2: All false array
        boolean[] test2 = {false, false, false, false, false};
        assertEquals("     ", ABAutomaton.genToString(test2));

        // Test 3: All true array
        boolean[] test3 = {true, true, true, true, true, true, true};
        assertEquals("*******", ABAutomaton.genToString(test3));
        
        // Test 4: Empty array
        boolean[] test4 = {};
        assertEquals("", ABAutomaton.genToString(test4));

        // Test 5: Alternating truth values 
        boolean[] test5 = {true, false, true, false, true, false, true};
        assertEquals("* * * *", ABAutomaton.genToString(test5));

    }

    @Test
    public void testNextGenA() {

        // Test 1: Case "empty, occupied, empty" for Automaton A
        boolean[] test1 = {false, true, false, true, false, true, false};
        boolean[] test1Result = {false, false, true, false, true, false, false};
        assertArrayEquals(test1Result, ABAutomaton.nextGenA(test1));
        
        // Test 2: Case "occupied, occupied, empty" for Automaton A
        boolean[] test2 = {false, true, true, false, false};
        boolean[] test2Result = {false, true, true, true ,false};
        assertArrayEquals(test2Result, ABAutomaton.nextGenA(test2));
        
        // Test 3: Case "empty, occupied, occupied" for Automaton A
        boolean[] test3 = {false, false, true, true, false};
        boolean[] test3Result = {false, true, true, true, false};
        assertArrayEquals(test3Result, ABAutomaton.nextGenA(test3));
        
        // Test 4: Case "occupied, occupied, occupied" for Automaton A
        boolean[] test4 = {false, true, true, true, false};
        boolean[] test4Result = {false, true, false, true, false};
        assertArrayEquals(test4Result, ABAutomaton.nextGenA(test4));

        // Test 5: Case "empty, empty, empty" for Automaton A
        boolean[] test5 = {false, false, false, false, false};
        boolean[] test5Result = {false, false, false, false, false};
        assertArrayEquals(test5Result, ABAutomaton.nextGenA(test5));

        //Test 6: Case "occupied, empty, occupied" for Automaton A
        boolean[] test6 = {false, true, false, true, false, true, false};
        boolean[] test6Result = {false, false, true, false, true, false, false};
        assertArrayEquals(test6Result, ABAutomaton.nextGenA(test6));

        //Test 7: Case "occupied, empty, empty" for Automaton A
        boolean[] test7 = {false, true, true, false, false};
        boolean[] test7Result = {false, true, true, true ,false};
        assertArrayEquals(test7Result, ABAutomaton.nextGenA(test7));

        //Test 8: Case "empty, empty, occupied" for Automaton A
        boolean[] test8 = {false, false, true, true, false};
        boolean[] test8Result = {false, true, true, true, false};
        assertArrayEquals(test8Result, ABAutomaton.nextGenA(test8));

    }

    @Test
    public void testNextGenB() {

        // Test 1: Case "empty, occupied, empty" for Automaton B
        boolean[] test1 = {false, true, false, true, false};
        boolean[] test1Result = {false, true, false, true, false};
        assertArrayEquals(test1Result, ABAutomaton.nextGenB(test1));
        
        // Test 2: Case "occupied, occupied, empty" for Automaton B
        boolean[] test2 = {false, true, true, false, false};
        boolean[] test2Result = {false, false, true, true, false};
        assertArrayEquals(test2Result, ABAutomaton.nextGenB(test2));
        
        // Test 3: Case "empty, occupied, occupied" for Automaton B
        boolean[] test3 = {false, false, true, true, false};
        boolean[] test3Result = {false, true, false, true, false};
        assertArrayEquals(test3Result, ABAutomaton.nextGenB(test3));

        // Test 4: Case "occupied, occupied, occupied" for Automaton B
        boolean[] test4 = {false, true, true, true, false};
        boolean[] test4Result = {false, false, false, true, false};
        assertArrayEquals(test4Result, ABAutomaton.nextGenB(test4));

        // Test 5: Case "empty, empty, empty" for Automaton B
        boolean[] test5 = {false, false, false, false, false};
        boolean[] test5Result = {false, false, false, false, false};
        assertArrayEquals(test5Result, ABAutomaton.nextGenB(test5));

        // Test 6: Case "occupied, empty, occupied" for Automaton B
        boolean[] test6 = {false, true, false, true, false};
        boolean[] test6Result = {false, true, false, true, false};
        assertArrayEquals(test6Result, ABAutomaton.nextGenB(test6));

        // Test 7: Case "occupied, empty, empty" for Automaton B
        boolean[] test7 = {false, true, true, false, false};
        boolean[] test7Result = {false, false, true, true, false};
        assertArrayEquals(test7Result, ABAutomaton.nextGenB(test7));

        // Test 8: Case "empty, empty, occupied" for Automaton B
        boolean[] test8 = {false, false, true, true, false};
        boolean[] test8Result = {false, true, false, true, false};
        assertArrayEquals(test8Result, ABAutomaton.nextGenB(test8));
    }

}

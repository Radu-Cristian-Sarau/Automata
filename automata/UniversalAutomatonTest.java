import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * @author Horia-George Dună
 * @id 1949284
 * @author Radu-Cristian Sarău
 * @id 1939149
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        
        /// Test 1: Randomly picked truth values
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
    public void testNextGen() {
        // Test 1: Reversing the given example
        boolean[] ruleSequence1 = {false, true, false, true, true, true, true, false};
        boolean[] testGen1 = {false, true, false, true, false, true, false, true, false, true, false};
        boolean[] testResult1 = {false, false, true, false, true, false, true, false, true, false, false};
        assertArrayEquals(testResult1, UniversalAutomaton.nextGen(ruleSequence1, testGen1));

        // Test 2: Rule sequence filled with "false"; randomly picked test gen
        boolean[] ruleSequence2 = {false, false, false, false, false, false, false, false};
        boolean[] testGen2 = {false, true, true, false, true, false, false, true, false};
        boolean[] testResult2 = {false, false, false, false, false, false, false, false, false};
        assertArrayEquals(testResult2, UniversalAutomaton.nextGen(ruleSequence2, testGen2));

        // Test 3: Rule sequence filled with "true"
        boolean[] ruleSequence3 = {true, true, true, true, true, true, true, true};
        boolean[] testGen3 = {false, false, false, true, false, true, true, false, false};
        boolean[] testResult3 = {false, true, true, true, true, true, true, true, false};
        assertArrayEquals(testResult3, UniversalAutomaton.nextGen(ruleSequence3, testGen3));

        // Test 4: Randomly picked rule sequence and test generation
        boolean[] ruleSequence4 = {false, true, true, false, false, true, false, true};
        boolean[] testGen4 = {false, true, false, true, true, false, true, false, false, false};
        boolean[] testResult4 = {false, true, true, false, false, true, true, false, false, false};
        assertArrayEquals(testResult4, UniversalAutomaton.nextGen(ruleSequence4, testGen4));
        
        // Test 5: One-cell test generation
        boolean[] ruleSequence5 = {false, true, false, true, true, true, true, false};
        boolean[] testGen5 = {false, true, false};
        boolean[] testResult5 = {false, false, false};
        assertArrayEquals(testResult5, UniversalAutomaton.nextGen(ruleSequence5, testGen5));
    }

}
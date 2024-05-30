import java.util.Arrays;
import java.util.Scanner;

/**
 * Universal Automaton. 
 * @author Horia-George Dună
 * @id 1949284
 * @author Radu-Cristian Sarău
 * @id 1939149
 */

class UniversalAutomaton {
    Scanner scanner = new Scanner(System.in);

    /**
     * This method takes an array of boolean values as input and, depending on their truth values, 
     * writes ' ' or '*' in a string variable. An "occupied" cell contains a '*', whereas an 
     * "empty" one contains a ' '.
     * @param gen is the boolean array which represents the generation of cells that is going to 
     * be converted to String.
     */
    String genToString(boolean[] gen) {
        String genString = "";
        for (boolean i : gen) {
            if (!i) {
                genString += " ";
            } else {
                genString += "*";
            }
        } 
        return genString;
    }

    /**
     * This method is used to generate the next generation of cells using the current generation 
     * and the rule sequence specified by the user. Using the binary code it finds the bit pattern 
     * of the neighbourhood pattern in the current generation, converts it to base 10, stores it in
     * a variable "rule" and fills the cell in the next generation with the truth value specified in the
     * "ruleSequence" array at the position "rule".
     * @param ruleSequence is the boolean array which specifies the rules for each neighbourhood 
     * pattern in the universal automaton
     * @param gen is the current generation of cells which will be used to construct the next 
     * generation
     */
    static boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        int rule = 0; // Will specify which rule will be used for each cell in the next generation
        boolean[] newGen = new boolean[gen.length]; // Represents the next generation of cells
        Arrays.fill(newGen, false);

        for(int i = 1; i < gen.length - 1; i++){
            rule = 0;
            // The bit pattern of the neighbourhood pattern is converted to base 10
            if (gen[i - 1]) {
                rule += 4;
            }
            if (gen[i]) {
                rule += 2;
            }
            if (gen[i+1]) {
                rule++;
            }

            // The cell in the next gen is filled with the truth value on position "rule"
            newGen[i] = ruleSequence[rule]; 
        }
        return newGen;
    }

    /**
     * This method reads the initial generation. It reads the user's input, which start with 
     * "init_start" and end with "init_end", then it trims it if there is whitespace at both ends 
     * of the input. It reads every integer inside this String, and parses it into an Int. Then, it
     * stores the value "true" in each cell of the boolean array "gen" with the index mentioned
     * in the String. In the end, it return the first generation, through the array "gen".
     * 
     * @param length is the number of cells in a generation, as specified by the user. 
     */
    boolean[] readInitalGeneration(int length) {
        
        String input = ""; // The variable where the user's input is stored
        int cell; // Integer value that specifies which cell is occupied in the original generation
        boolean[] gen = new boolean[length + 2]; // Array of booleans acting as the first generation
        
        Arrays.fill(gen, false); // Unspecified cells in the "gen" array are considered empty
        
        input = scanner.next();        
        input = input.trim();
        input = scanner.next(); // Reading the first integer
        
        // Tests if input is still an integer and parses it into an Int if the number is less than
        // the length of the generation
        while (!"init_end".equals(input)) {
            cell = Integer.parseInt(input);
            if(cell >= 1 && cell <= length){
                gen[cell] = true;
            }
            input = scanner.next();
        }        
        return gen; 
    }

    /**
     * This method is used to read the user's input and create a boolean array representing the 
     * rule sequence for the universal automaton.
     */
    boolean[] readRuleSequence() {
        boolean[] ruleSequence = new boolean[8];
        int input;

        for (int i = 0; i < 8; i++) {
            input = scanner.nextInt();
            if (input == 0) {
                ruleSequence[i] = false;
            } else {
                ruleSequence[i] = true;
            }
        }

        return ruleSequence;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}






























//lmao
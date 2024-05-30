import java.util.Arrays;
import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * @author Horia-George Dună
 * @id 1949284
 * @author Radu-Cristian Sarău
 * @id 1939149
 */

class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    /**
     * This method takes an array of boolean values as input and, depending on their truth values, 
     * writes ' ' or '*' in a string variable. An "occupied" cell contains a '*', whereas an 
     * "empty" one contains a ' '.
     * @param gen is the boolean array which represents the generation of cells that is going to 
     * be converted to String.
     */
    static String genToString(boolean[] gen) {
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
     * This method receives the previous generation, creates and returns the current generation according 
     * to the rules of Automaton A. Occupied cells remain occupied only if exactly one of the 
     * neighbors is occupied. Empty cells remain empty only if both neighbors are empty.
     * @param gen is the boolean array representing the previous generation of cells
     */
    static boolean[] nextGenA(boolean[] gen) {
        // Declaring the array "newGen" which will act as the new generation of cells
        boolean[] newGen = new boolean[gen.length];
        Arrays.fill(newGen, false);// Unspecified cells in the "newGen" array are considered empty

        for (int i = 1; i < gen.length - 1; i++) {
            // Tests if the cell at index i is occupied in the previous generation
            if (gen[i]) {
                // Tests if exactly one of the neighbors is occupied
                if (gen[i - 1] != gen[i + 1]) {
                    newGen[i] = true;
                } else {
                    newGen[i] = false;
                }
            } else { // Tests if the cell at index i is empty in the previous generation
                // Tests if both neighbors are empty
                if (!gen[i - 1] && !gen[i + 1]) {
                    newGen[i] = false;
                } else {
                    newGen[i] = true;
                }
            }
        }
        return newGen;
    }

    /**
     * This method receives the previous generation, creates and returns the current generation according 
     * to the rules of Automaton B. "Occupied" cells remain "occupied" only if the right-hand 
     * neighbor is empty. "Empty" cells become "occupied" if exactly one neighbor is "occupied".
     * @param gen is the boolean array representing the previous generation of cells 
     */
    static boolean[] nextGenB(boolean[] gen) {
        // Declaring the array "newGen" which will act as the new generation of cells
        boolean[] newGen = new boolean[gen.length];
        Arrays.fill(newGen, false);//unspecified cells in the "newGen" array are considered empty

        for (int i = 1; i < gen.length - 1; i++) {
            // Tests if the cell at index i is occupied in the previous generation
            if (gen[i]) {
                // Tests if the righthand side neighbour is empty
                if (!gen[i + 1]) {
                    newGen[i] = true;
                } else {
                    newGen[i] = false;
                }
            } else {// Tests if the cell at index i is empty in the previous generation
                // Tests if exactly one neighbour is occupied
                if (gen[i - 1] != gen[i + 1]) {
                    newGen[i] = true;
                } else {
                    newGen[i] = false;
                }
            }
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

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Solution for the number array interview problem.
 * Counts occurrences of each number in an array and displays the results.
 */
public class NumberArrayProcessor {

    /**
     * Main method to run the number array processing demonstration.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        NumberArrayProcessor processor = new NumberArrayProcessor();

        // Test array from the interview question
        int[] testArray = { 1, 1, 4, 4, 4, 4, 5, 1, 1, 2, 2, 2, 2, 3, 3, 3 };

        System.out.println("Processing array: " + Arrays.toString(testArray));
        System.out.println();

        processor.run(testArray);
    }

    /**
     * Processes the input array to count occurrences of each element
     * and displays the results sorted by key.
     *
     * @param numbers the array of integers to process
     */
    public void run(int[] numbers) {
        // Convert array to stream, group by element value, count occurrences,
        // sort by key, print results
        Arrays.stream(numbers) // Create stream from array
                .boxed() // Convert int to Integer for collections
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream() // Convert map to stream of entries
                .sorted(Map.Entry.comparingByKey()) // Sort by number (key)
                .forEach(e -> System.out.println("Number " + e.getKey()
                        + " appears " + e.getValue() + " time(s)"));
    }
}
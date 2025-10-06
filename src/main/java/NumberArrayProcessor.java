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
        // Stream pipeline: Transform array → group & count → sort → display

        Arrays.stream(numbers) // Step 1: Convert int[] to IntStream
                .boxed() // Step 2: Convert IntStream to Stream<Integer> (required for collections)
                // Step 3: Group elements by their value and count occurrences
                // - Function.identity() means "group by the element itself" (x -> x)
                // - Collectors.counting() counts how many elements are in each group
                // - Result: Map<Integer, Long> where key=number, value=occurrence count
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream() // Step 4: Convert Map to Stream<Map.Entry<Integer, Long>>
                .sorted(Map.Entry.comparingByKey()) // Step 5: Sort entries by key (number) in ascending order
                // Step 6: Print each entry in "Number X appears Y time(s)" format
                .forEach(e -> System.out.println("Number " + e.getKey()
                        + " appears " + e.getValue() + " time(s)"));
    }
}
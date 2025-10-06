import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Solution for the number array interview problem.
 * Counts occurrences of each number in an array and displays the results.
 */
public class NumberArrayProcessor {

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
        Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println("Number " + e.getKey() + " appears " + e.getValue() + " time(s)"));
    }
}
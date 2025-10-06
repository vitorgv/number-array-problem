import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class NumberArrayProcessorTest {

    private NumberArrayProcessor processor;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        processor = new NumberArrayProcessor();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testRunWithInterviewArray() {
        int[] testArray = { 1, 1, 4, 4, 4, 4, 5, 1, 1, 2, 2, 2, 2, 3, 3, 3 };

        processor.run(testArray);

        String output = outputStream.toString();

        // Verify the output contains expected counts
        assertTrue(output.contains("Number 1 appears 4 time(s)"));
        assertTrue(output.contains("Number 2 appears 4 time(s)"));
        assertTrue(output.contains("Number 3 appears 3 time(s)"));
        assertTrue(output.contains("Number 4 appears 4 time(s)"));
        assertTrue(output.contains("Number 5 appears 1 time(s)"));

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    void testRunWithEmptyArray() {
        int[] emptyArray = {};

        processor.run(emptyArray);

        String output = outputStream.toString();
        // Empty array should produce no output
        assertTrue(output.trim().isEmpty());

        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    void testRunWithSingleElement() {
        int[] singleElement = { 7 };

        processor.run(singleElement);

        String output = outputStream.toString();
        assertTrue(output.contains("Number 7 appears 1 time(s)"));

        // Restore original System.out
        System.setOut(originalOut);
    }
}
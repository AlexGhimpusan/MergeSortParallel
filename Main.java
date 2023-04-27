import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long totalStartTime = System.currentTimeMillis();


        // Reading the array numbers from file
        long readingStartTime = System.currentTimeMillis();

        int[] arr = parallelReadArrayFromFile("input");

        long readingEndTime = System.currentTimeMillis();
        long readingTotalTime = readingEndTime - readingStartTime;


        // Sorting the array
        long sortingStartTime = System.currentTimeMillis();

        Arrays.parallelSort(arr);

        long sortingEndTime = System.currentTimeMillis();
        long sortingTotalTime = sortingEndTime - sortingStartTime;


        // Printing the details to the console
        System.out.println("Successfully sorted the array \n");
        System.out.println("READING the numbers from file: " + readingTotalTime + " milliseconds");
        System.out.println("SORTING the numbers: " + sortingTotalTime + " milliseconds");

        long totalEndTime = System.currentTimeMillis();
        long totalTime = totalEndTime - totalStartTime;
        System.out.println("TOTAL program time: " + totalTime + " milliseconds");
    }

    public static int[] parallelReadArrayFromFile(String filename) {
        Path file = Path.of(filename);

        int[] arr;
        try {
            arr = Files.lines(file)
                    .parallel()
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }
}
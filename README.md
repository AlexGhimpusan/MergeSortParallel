
# MergeSort Parallel version

## Details of the project:
Google Docs for the details: https://docs.google.com/document/d/1uT7c02JRSUtgdrbxoADnl2o0Tfq1fHthoxULftjFWT4/edit

## FYI:
The "input" file contains one number on every line becuase the sorting uses a parallel algorithm for reading the numbers from file line-by-line.

### Sequential algorithm to generate random numbers to file:

    public static void main(String[] args) {
        String fileName = "PATH TO: input";
        int numCount = 10; // How many numbers you want to generate

        try {
            FileWriter fileWriter = new FileWriter(fileName);

            // Generate and write the random numbers on the second line
            Random random = new Random();
            for (int i = 0; i < numCount; i++) {
                int randomNumber = random.nextInt(numCount); // Generate a random number between 0 and numCount
                fileWriter.write(randomNumber + "\n");
            }

            fileWriter.close();

            System.out.println("Successfully wrote " + numCount + " random numbers to file " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to file " + fileName);
            e.printStackTrace();
        }
    }

### Parallel algorithm to read number from file:

    public static int[] readArrayFromFileInParallel(String filename) {
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

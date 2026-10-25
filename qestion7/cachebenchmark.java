package qestion7;


public class cachebenchmark {

    static final int n = 20000;
    static final int iterations = 20;

    static double[][] matrix = new double[n][n];

    public static double traverseRowMajor() {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }dfdadf

        return sum;
    }

    public static double traverseColumnMajor() {
        double sum = 0;

        for (int j=0; j<n; j++) {
            for (int i=0; i<n; i++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        double rowTotalTime = 0;
        double columnTotalTime = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = i + j;
            }
        }

        traverseRowMajor();
        traverseColumnMajor();

        // Measure Row-Major traversal
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();

            traverseRowMajor();

            long endTime = System.nanoTime();

            rowTotalTime += endTime - startTime;
        }

        // Measure Column-Major traversal
        for (int i=0; i<iterations; i++) {
            long startTime = System.nanoTime();

            traverseColumnMajor();

            long endTime = System.nanoTime();

            columnTotalTime += endTime - startTime;
        }

        double rowAverageMs =
                rowTotalTime / iterations / 1_000_000.0;

        double columnAverageMs =
                columnTotalTime / iterations / 1_000_000.0;

        double speedup = columnTotalTime / rowTotalTime;

        System.out.println("Matrix Size: " +n+ " x "+n);
        System.out.println("Number of Iterations: " + iterations);

        System.out.println("\nAverage Row-Major Time: "
                + rowAverageMs + " milliseconds");

        System.out.println("Average Column-Major Time: "
                + columnAverageMs + " milliseconds");

        System.out.println("Row-Major Speedup Ratio: "
                + speedup + "x");
    }
}

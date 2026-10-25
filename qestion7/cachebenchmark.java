package qestion7;


public class cachebenchmark {

    static final int n = 2000;
    static final int iterations = 10;

    static double[][] matrix = new double[n][n];

    public static double traverseRowMajor() {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

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

    
}

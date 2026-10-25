package question4;

public class parallelriskcalculator extends RecursiveTask<Double> {
    private double[] assets;
    private int start;
    private int end;

    private static int threshold=1000;
    public parallelriskcalculator(double[] ass, int st, int en){
        assets=ass;
        start=st;
        end=en;
    }
    
}

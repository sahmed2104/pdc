package question4;
import java.util.concurrent.RecursiveTask;
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
    @Override 
    protected Double compute(){
        if(end-start <=threshold){
            double sum=0;
            for (int i=start;i<end;i++){
                sum=sum+assets[i];
            }
            return sum;
        }
        int mid= (start+end)/2;
        parallelriskcalculator left=new parallelriskcalculator(assets, start, mid);
        parallelriskcalculator right=new parallelriskcalculator(assets, mid, end);
        left.fork();
        double rightresult= right.compute();
        double leftresult= left.compute();
        return leftresult + rightresult;

    }
}

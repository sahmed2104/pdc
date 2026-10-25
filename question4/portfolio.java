package question4;
import java.util.concurrent.RecursiveAction;
public class portfolio extends RecursiveAction{
    private double[] assets;
    private int start;
    private int end;
    private double risk;
    private static int threshold=1000;
    
    public portfolio(double[] ass, int st, int en, double ris){
        assets=ass;
        start=st;
        end=en;
        risk=ris;
    }
}

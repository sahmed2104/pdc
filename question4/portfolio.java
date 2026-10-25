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
    @Override 
    protected void compute(){
        if(end-start <=threshold){
            for(int i=start; i<end;i++){
                if(assets[i]>risk){
                    assets[i]=assets[i]*0.95;
                }
            }
        }
        else {
            int mid=(start + end)/2;
            portfolio left=new portfolio(assets, start, mid, risk);
            portfolio right=new portfolio(assets, mid, end, risk);
            invokeAll(left, right);
        }
    }
}

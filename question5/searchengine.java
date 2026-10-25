package question5;

public abstract class searchengine {
    protected double[] sensordata;
    protected int startid;
    protected int endid;

    public searchengine(double[] d, int st, int en){
        sensordata=d;
        startid=st;
        endid=en;
    }
    public abstract void processgrid();

}

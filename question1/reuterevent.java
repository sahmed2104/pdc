package question1;

public class reuterevent extends tradeevent {
    private double bidprice;
    private double askprice;

    public reuterevent(String sid, long time, double base, double bid, double ask){
        super(sid, time, base);
        bidprice=bid;
        askprice=ask;
    }
}

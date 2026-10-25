package question1;

public class reuterevent extends tradeevent {
    private double bidprice;
    private double askprice;

    public reuterevent(String sid, long time, double base, double bid, double ask){
        super(sid, time, base);
        bidprice=bid;
        askprice=ask;
    }
    @Override 
    public void dispatch(){
        double gap= askprice - bidprice;
        System.out.println("reuters market quote: ");
        System.out.println("sender id: "+ sid);
        System.out.println("baseprice: "+ bprice);
        System.out.println("bid price: "+ bidprice);
        System.out.println("ask price: "+askprice);
        System.out.println("bid ask price gap: "+ gap);
    }
}

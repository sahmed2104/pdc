package question1;

public class tradeevent {
    protected String sid;
    protected long timestamp;
    protected double bprice;

    public tradeevent(String id, long time, double price){
        sid=id;
        timestamp=time;
        bprice=price;
    }
    public void dispatch(){
        System.out.println("trade event: ");
        System.out.println("sender id: "+ sid);
        System.out.println("time: "+timestamp);
        System.out.println("base price: "+bprice);
    }
}

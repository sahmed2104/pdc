package question1;

public class tradeevent {
    protected String sid;
    protected long timestamp;
    private double bprice;

    public tradeevent(String id, long time, double price){
        sid=id;
        timestamp=time;
        bprice=price;
    }
}

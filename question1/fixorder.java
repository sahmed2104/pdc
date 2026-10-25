package question1;

public class fixorder extends tradeevent {
private String orderid;

public fixorder(String id, long time, double base, String oid){
    super(id, time, base);
    orderid=oid;
}


}

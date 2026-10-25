package question1;

public class fixorder extends tradeevent {
private String orderid;

public fixorder(String id, long time, double base, String oid){
    super(id, time, base);
    orderid=oid;
}
@Override 
public void dispatch(){
    double fee= bprice * 015/100;
    double total= bprice+fee;

    System.out.println("fix stock purchase order:-");
    System.out.println("sender id:- "+ sid);
    System.out.println("timestamp:- "+ timestamp);
    System.out.println("client order id:- "+ orderid);
    System.out.println("purchase amount:- "+bprice);
    System.out.println("transaction fee:- "+ fee);
    System.out.println("total amount will be:- "+total);
}
}
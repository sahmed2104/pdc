package question1;

public class tradingengine {
    public static void main(String[] args) {
        tradeevent E1 =new fixorder("fixorder001", 100101L, 100.99, "order101");
        tradeevent E2 =new reuterevent("reuter2102", 1001001L, 130.99, 95.50, 100);
        E1.dispatch();
        System.out.println("\n");
        E2.dispatch();
    }
}

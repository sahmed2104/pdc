package question3;

public class webengine {
    public static void main(String[] args) {
        System.out.println("main thread name: " +
        Thread.currentThread().getName());

        telemetrythread t1= new telemetrythread();
        t1.setName("tele metery worker");

        logprocessor task= new logprocessor();
        Thread logThread= new Thread(task);
        logThread.setName("thakur");

        System.out.println("setting both threads");
        t1.start();
        logThread.start();

        System.out.println("telemetry thread state: "+ t1.getState());
        System.out.println("main thead continue execution.");
    }
}

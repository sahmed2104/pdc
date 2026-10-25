package question3;

public class logprocessor implements Runnable {
    @Override 
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(
                Thread.currentThread().getName()
                + "-log metrices iteration: "+i);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("log processor interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

package question5;


public class SensorGridMonitorApp {

    public static void main(String[] args) {

        int size = 50000;
        double[] sensorData = new double[size];

        for (int i = 0; i < size; i++) {
            sensorData[i] = Math.random() * 100;
        }

        parallelminsearch minSearch =
                new parallelminsearch(sensorData, 0, size);

        parallelmaxsearch maxSearch =
                new parallelmaxsearch(sensorData, 0, size);

        long startTime = System.nanoTime();

        Thread minThread = new Thread(() -> minSearch.processGrid());
        Thread maxThread = new Thread(() -> maxSearch.processGrid());

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Search was interrupted.");
            return;
        }

        long endTime = System.nanoTime();

        double executionTime =
                (endTime - startTime) / 1_000_000.0;

        System.out.println("Total Sensor Readings: " + size);
        System.out.println("Global Minimum Value: "
                + minSearch.getMinimum());
        System.out.println("Global Maximum Value: "
                + maxSearch.getMaximum());
        System.out.println("Execution Time: "
                + executionTime + " milliseconds");
    }
}

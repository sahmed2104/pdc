package question6;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class inventroycatalog {

    static int threads = 19;
    static int operations = 80000;
    static  int products = 200;

    public static void benchmarkSynchronizedMap() throws Exception {

        Map<String, Integer> stockMap =
                Collections.synchronizedMap(new HashMap<>());

        for (int i = 1; i <= products; i++) {
            stockMap.put("P" + i, 100);
        }

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        long startTime = System.nanoTime();

        for (int i = 0; i < threads; i++) {

            final int worker = i;

            executor.submit(() -> {
                for (int j = 0; j < operations; j++) {

                    String productId =
                            "P" + ((j + worker) % products+ 1);

                    synchronized (stockMap) {
                        Integer stock = stockMap.get(productId);

                        if (stock != null) {
                            stockMap.put(productId, stock + 1);
                        }
                    }
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        long endTime = System.nanoTime();

        double seconds = (endTime - startTime) / 1_000_000_000.0;
        long totalOperations = (long) threads*operations;
        double throughput = totalOperations / seconds;

        System.out.println("SynchronizedMap Results");
        System.out.println("Execution Time: " + seconds + " seconds");
        System.out.println("Throughput: " + throughput
                + " transactions/second");
        System.out.println();
    }

    public static void benchmarkConcurrentMap() throws Exception {

        ConcurrentHashMap<String, Integer> stockMap =
                new ConcurrentHashMap<>();

        for (int i = 1; i <= products; i++) {
            stockMap.put("P" + i, 100);
        }

        ExecutorService executor = Executors.newFixedThreadPool(threads);

        long startTime = System.nanoTime();

        for (int i = 0; i < threads; i++) {

            final int worker = i;

            executor.submit(() -> {
                for (int j = 0; j <operations; j++) {

                    String productId =
                            "P" + ((j + worker) %products + 1);

                    stockMap.compute(productId,
                            (key, stock) -> stock + 1);
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        long endTime = System.nanoTime();

        double seconds = (endTime - startTime) / 1_000_000_000.0;
        long totalOperations = (long) threads * operations;
        double throughput = totalOperations / seconds;

        System.out.println("ConcurrentHashMap Results");
        System.out.println("Execution Time: " + seconds + " seconds");
        System.out.println("Throughput: " + throughput
                + " transactions/second");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        benchmarkSynchronizedMap();
        benchmarkConcurrentMap();
    }
}

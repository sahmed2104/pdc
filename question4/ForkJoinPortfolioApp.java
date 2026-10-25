package question4;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPortfolioApp {

    public static void main(String[] args) {

        int size = 10000;
        double riskCap = 1500;

        double[] assets = new double[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            assets[i] = 100 + random.nextInt(1901);
        }

        ForkJoinPool pool = new ForkJoinPool();

        double serialRisk = 0;

        long serialStart = System.nanoTime();

        for (int i = 0; i < assets.length; i++) {
            serialRisk = serialRisk + assets[i];
        }

        long serialEnd = System.nanoTime();

        long parallelStart = System.nanoTime();

        parallelriskcalculator riskTask =
                new parallelriskcalculator(assets, 0, assets.length);

        double parallelRisk = pool.invoke(riskTask);

        long parallelEnd = System.nanoTime();

        long stressStart = System.nanoTime();

        portfolio stressTask =
                new portfolio(
                        assets, 0, assets.length, riskCap);

        pool.invoke(stressTask);

        long stressEnd = System.nanoTime();

        double adjustedRisk = pool.invoke(
                new parallelriskcalculator(assets, 0, assets.length));

        System.out.println("PORTFOLIO RISK ASSESSMENT");
        System.out.println("------------------------");

        System.out.println("Number of assets: " + size);
        System.out.println("Risk cap: " + riskCap);

        System.out.println("Serial risk score: " + serialRisk);
        System.out.println("Parallel risk score: " + parallelRisk);

        System.out.println("Adjusted risk score: " + adjustedRisk);

        System.out.println();
        System.out.println("PROCESSING TIMES \n");

        System.out.println("Serial calculation time: "
                + (serialEnd - serialStart) / 1000000.0 + " ms");

        System.out.println("Parallel calculation time: "
                + (parallelEnd - parallelStart) / 1000000.0 + " ms");

        System.out.println("Stress-test time: "
                + (stressEnd - stressStart) / 1000000.0 + " ms");

        if (parallelRisk == serialRisk) {
            System.out.println("Risk calculations match.");
        } else {
            System.out.println("Risk calculations do not match.");
        }

        pool.close();
    }
}

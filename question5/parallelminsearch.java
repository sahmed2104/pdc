package question5;
public class parallelminsearch extends searchengine {

    private double minimum;

    public parallelminsearch(double[] data, int start, int end) {
        super(data, start, end);
    }

    private class MinWorker extends Thread {
        int start;
        int end;
        double result;

        public MinWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            result = sensordata[start];

            for (int i = start + 1; i < end; i++) {
                if (sensordata[i] < result) {
                    result = sensordata[i];
                }
            }
        }
    }

    @Override
    public void processGrid() {
        int total = endid - startid;
        int partSize = (total + 3) / 4;

        MinWorker[] workers = new MinWorker[4];

        for (int i = 0; i < 4; i++) {
            int start = startid + i * partSize;
            int end = Math.min(start + partSize, endid);

            if (start < end) {
                workers[i] = new MinWorker(start, end);
                workers[i].start();
            }
        }

        minimum = Double.POSITIVE_INFINITY;

        for (int i = 0; i < 4; i++) {
            if (workers[i] != null) {
                try {
                    workers[i].join();

                    if (workers[i].result < minimum) {
                        minimum = workers[i].result;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public double getMinimum() {
        return minimum;
    }

    @Override
    public void processgrid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processgrid'");
    }
}

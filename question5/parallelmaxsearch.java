package question5;


public class parallelmaxsearch extends searchengine {

    private double maximum;

    public parallelmaxsearch(double[] data, int start, int end) {
        super(data, start, end);
    }

    private class MaxWorker extends Thread {
        int start;
        int end;
        double result;

        public MaxWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            result = sensordata[start];

            for (int i = start + 1; i < end; i++) {
                if (sensordata[i] > result) {
                    result = sensordata[i];
                }
            }
        }
    }

    @Override
    public void processGrid() {
        int total = endid - startid;
        int partSize = (total + 3) / 4;

        MaxWorker[] workers = new MaxWorker[4];

        for (int i = 0; i < 4; i++) {
            int start = startid + i * partSize;
            int end = Math.min(start + partSize, endid);

            if (start < end) {
                workers[i] = new MaxWorker(start, end);
                workers[i].start();
            }
        }

        maximum = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < 4; i++) {
            if (workers[i] != null) {
                try {
                    workers[i].join();

                    if (workers[i].result > maximum) {
                        maximum = workers[i].result;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public double getMaximum() {
        return maximum;
    }

    @Override
    public void processgrid() {
        throw new UnsupportedOperationException("Unimplemented method 'processgrid'");
    }
}

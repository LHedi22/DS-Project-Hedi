public class WarmestStretch {

    public static double brute(int[] temps, int k) {
        long best = Long.MIN_VALUE;
        for (int i = 0; i + k <= temps.length; i++) {
            long sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += temps[j];
            }
            if (sum > best) {
                best = sum;
            }
        }
        return (double) best / k;
    }

    public static double optimized(int[] temps, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temps[i];
        }
        long best = sum;
        for (int i = k; i < temps.length; i++) {
            sum += temps[i] - temps[i - k];
            if (sum > best) {
                best = sum;
            }
        }
        return (double) best / k;
    }
}

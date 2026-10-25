public class PeakMonitor {

    public static int[] brute(int[] readings, int k) {
        int[] result = new int[readings.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            int max = readings[i];
            for (int j = i + 1; j < i + k; j++) {
                if (readings[j] > max) {
                    max = readings[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] optimized(int[] readings, int k) {
        int n = readings.length;
        int[] result = new int[n - k + 1];
        int[] deque = new int[n];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            if (head < tail && deque[head] <= i - k) {
                head++;
            }
            while (head < tail && readings[deque[tail - 1]] <= readings[i]) {
                tail--;
            }
            deque[tail] = i;
            tail++;
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque[head]];
            }
        }
        return result;
    }
}

public class BestRun {

    public static int brute(int[] profit) {
        int best = profit[0];
        for (int i = 0; i < profit.length; i++) {
            int sum = 0;
            for (int j = i; j < profit.length; j++) {
                sum += profit[j];
                if (sum > best) {
                    best = sum;
                }
            }
        }
        return best;
    }

    public static int optimized(int[] profit) {
        int cur = profit[0];
        int best = profit[0];
        for (int i = 1; i < profit.length; i++) {
            if (cur < 0) {
                cur = profit[i];
            } else {
                cur += profit[i];
            }
            if (cur > best) {
                best = cur;
            }
        }
        return best;
    }
}

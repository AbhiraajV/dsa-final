public class PaintersPartition {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] arr = { 5, 10, 30, 20, 15 };
        System.out.print(minTime(arr, n, k));
    }

    static long[][] dp;

    static long minTime(int[] arr, int n, int k) {
        long[] sumArray = new long[n];
        sumArray[0] = arr[0];

        for (int i = 1; i < n; i++)
            sumArray[i] = sumArray[i - 1] + arr[i];

        dp = new long[n + 1][k + 1];
        return solve(sumArray, k, 0, n, 0);
    }

    static long solve(long[] sum, int k, int i, int n, long prev) {
        if (k == 1)
            return sum[n - 1] - prev;

        if (i >= n)
            return k != 0 ? Integer.MIN_VALUE : 0;

        if (dp[i][k] != 0)
            return dp[i][k];
        long min = Integer.MAX_VALUE;
        for (int p = i; p < n; p++) {
            long cur = Math.max(solve(sum, k - 1, p + 1, n, sum[p]), sum[p] - prev);
            min = Math.min(min, cur);
        }

        return dp[i][k] = min;
    }
}

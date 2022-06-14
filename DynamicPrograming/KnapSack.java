public class KnapSack {
    public static void main(String[] args) {

    }

    static int[][] dp = new int[1001][1001];

    static int knapSack(int W, int wt[], int val[], int n) {

        dp = new int[n + 1][W + 1];
        return knapSackUtil(W, wt, val, n);
    }

    static int knapSackUtil(int W, int wt[], int val[], int n) {
        if (W < 0)
            return Integer.MIN_VALUE;

        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != 0)
            return dp[n][W];
        return dp[n][W] = Math.max((val[n - 1] +
                knapSackUtil(W - wt[n - 1], wt,
                        val, n - 1)),
                knapSackUtil(W, wt, val,
                        n - 1));
    }
}

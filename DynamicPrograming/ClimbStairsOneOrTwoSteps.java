public class ClimbStairsOneOrTwoSteps {
    public static void main(String[] args) {

    }

    static int m = 1000000007;
    static int[] dp = new int[10001];

    int countWays(int n) {
        dp = new int[n + 1];
        return count(n) % m;
    }

    static int count(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (dp[n] != 0)
            return dp[n] % m;
        return dp[n] = (count(n - 1) % m + count(n - 2) % m) % m;
    }
}

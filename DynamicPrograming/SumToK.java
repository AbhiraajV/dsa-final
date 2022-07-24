import java.util.Arrays;

public class SumToK {
    public static void main(String[] args) {

    }

    static int m = 1000000007;
    static int[][] dp;

    public int perfectSum(int arr[], int n, int sum) {
        dp = new int[sum + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(arr, n - 1, sum) % m;
    }

    static int solve(int[] arr, int n, int sum) {

        if (n < 0 || sum < 0)
            return sum == 0 ? 1 : 0;
        if (dp[sum][n] != -1)
            return dp[sum][n];
        return dp[sum][n] = (solve(arr, n - 1, sum - arr[n]) % m + solve(arr, n - 1, sum) % m) % m;

    }
}

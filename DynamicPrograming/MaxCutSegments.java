import java.util.Arrays;

public class MaxCutSegments {
    public static void main(String[] args) {

    }

    int solve(int n, int x, int y, int z, int dp[]) {

        if (n == 0)
            return 0;

        if (n < 0)
            return Integer.MIN_VALUE;

        if (dp[n] != -1)
            return dp[n];

        int max = Math.max(
                solve(n - x, x, y, z, dp),
                Math.max(
                        solve(n - y, x, y, z, dp), solve(n - z, x, y, z, dp)));

        return dp[n] = max == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1 + max;
    }

    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);

        int ans = solve(n, x, y, z, dp);

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}

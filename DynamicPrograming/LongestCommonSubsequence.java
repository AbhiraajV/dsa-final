public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    static int[][] dp;

    static int lcs(int x, int y, String s1, String s2) {
        dp = new int[x + 1][y + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(x, y, s1, s2);
    }

    static int solve(int x, int y, String s1, String s2) {

        if (x == 0 || y == 0)
            return 0;
        if (dp[x][y] != -1)
            return dp[x][y];
        if (s1.charAt(x - 1) == s2.charAt(y - 1))
            return dp[x][y] = 1 + solve(x - 1, y - 1, s1, s2);
        else
            return dp[x][y] = Math.max(solve(x - 1, y, s1, s2), solve(x, y - 1, s1, s2));

    }
}

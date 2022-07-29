package Hard;

import java.util.Arrays;

public class EditDistance {

    static int[][] dp;
    static int myMax;

    public static void main(String[] args) {
        String word1 = "";
        String word2 = "";
        myMax = 1001;
        dp = new int[word1.length()][word2.length()];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        solveDp(word1, word2, 0, 0);
    }

    static int solveDp(String a, String b, int i, int j) {

        if (a == b) {
            return 0;
        } else if (i >= a.length()) {
            return b.length() - j;
        } else if (j >= b.length()) {
            return a.length() - i;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = myMax;
        if (a.charAt(i) == b.charAt(j)) {
            ans = Math.min(ans, solveDp(a, b, i + 1, j + 1));
        } else { // considering we only change A;
            int cases = 1 + Math.min(
                    // insert
                    solveDp(a, b, i, j + 1), // ABC AXC => AX-B(i is still at B)C AXB=> j is moved at X is done
                    Math.min(
                            // delete
                            solveDp(a, b, i + 1, j), // ABC AXC => AC AXC => i is moved as we still need to compare with
                                                     // j
                            // replace
                            solveDp(a, b, i + 1, j + 1) // i & j both are made equal so we can move
                    ));

            ans = Math.min(ans, cases);
        }
        return dp[i][j] = ans;

    }

    static int solve(String a, String b, int i, int j) {

        if (a == b) {
            return 0;
        } else if (i >= a.length()) {
            return b.length() - j;
        } else if (j >= b.length()) {
            return a.length() - i;
        }

        int ans = Integer.MAX_VALUE;
        if (a.charAt(i) == b.charAt(j)) {
            ans = Math.min(ans, solve(a, b, i + 1, j + 1));
        } else { // considering we only change A;
            int cases = 1 + Math.min(
                    solve(a.substring(0, i) + b.charAt(j) + a.substring(i), b, i, j), // insert
                    Math.min(
                            solve(a.substring(0, i) + a.substring(i + 1), b, i, j), // delete
                            solve(a.substring(0, i) + b.charAt(j) + a.substring(i + 1), b, i, j) // replace
                    ));
            ans = Math.min(ans, cases);
        }
        return ans;

    }
}
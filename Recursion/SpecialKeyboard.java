public class SpecialKeyboard {
    public static void main(String[] args) {
        System.out.println(optimalKeys(60));
    }

    static int[] dp = new int[76];

    static boolean firstCase = true;

    static void getBaseDP() {
        firstCase = false;
        for (var i = 0; i <= 6; i++)
            dp[i] = i;
    }

    static int optimalKeysDP(int n) {

        if (dp[n] != 0)
            return dp[n];

        for (var i = 3; i <= n; i++)
            dp[n] = Math.max(dp[n], (i - 1) * optimalKeysDP(n - i));

        return dp[n];

    }

    static int optimalKeys(int N) {

        if (firstCase)
            getBaseDP();
        // optimized recursive solution
        // with added memo
        return optimalKeysDP(N);

        // Basic Recursive Solution
        // return getMaxLen(n,0,0);
    }

    static int getMaxLen(int n, int len, int clipboard) {

        if (n == 0)
            return len;

        int maxLen = Integer.MIN_VALUE;

        if (n - 3 >= 0 && len != 0)
            maxLen = Math.max(maxLen, getMaxLen(n - 3, len * 2, len));

        if (clipboard != 0)
            maxLen = Math.max(maxLen, getMaxLen(n - 1, len + clipboard, clipboard));

        maxLen = Math.max(maxLen, getMaxLen(n - 1, len + 1, clipboard));

        return maxLen;
    }
}

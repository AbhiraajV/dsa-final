public class PartitionEqualSubset {
    public static void main(String[] args) {

    }

    static boolean[][] dp;

    static int equalPartition(int N, int arr[]) {
        if (arr.length <= 1)
            return 0;
        int totalSum = 0;

        for (int i : arr)
            totalSum += i;

        if (totalSum % 2 != 0)
            return 0;

        dp = new boolean[N + 1][(totalSum / 2) + 1];

        if (check(arr, N - 1, (int) totalSum / 2))
            return 1;
        return 0;
    }

    static boolean check(int[] arr, int n, int target) {

        if (target == 0)
            return true;

        if (n < 0 || target < 0)
            return false;

        if (dp[n][target])
            return dp[n][target];

        return dp[n][target] = check(arr, n - 1, target - arr[n]) || check(arr, n - 1, target);
    }
}

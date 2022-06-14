public class MaxSumSubArr {
    public static void main(String[] args) {

    }

    // DIVIDE AND CONQUER O(N*log(N))
    // KADANE'S ALGORITHM O(N)
    static long getMax(int[] arr, int n, int curSum) {

        if (n < 0)
            return curSum;

        long maxSum = Integer.MIN_VALUE;

        maxSum = Math.max(maxSum, getMax(arr, n - 1, curSum + arr[n]));

        if (curSum != 0)
            maxSum = Math.max(maxSum, getMax(arr, n - 1, 0));

        return maxSum;
    }
}

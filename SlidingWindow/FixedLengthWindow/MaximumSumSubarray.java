public class MaximumSumSubarray {
    public static void main(String[] args) {

    }

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int start = 0, end = 0, sum = 0, maxSum = Integer.MIN_VALUE;

        while (end != Arr.size()) {
            sum += Arr.get(end);
            if (end - start + 1 == K) {
                maxSum = Math.max(maxSum, sum);
                sum -= Arr.get(start);
                start++;
            }
            end++;
        }
        return maxSum;
    }
}

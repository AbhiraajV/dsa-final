public class NextSmaller {
    public static void main(String[] args) {

    }

    public static long[] getNextSmallerArray(long[] arr, long n) {

        long[] ans = new long[(int) n];
        Stack<Integer> stack = new Stack<>();

        while (n != 0) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[(int) n - 1])
                stack.pop();

            ans[(int) n - 1] = stack.isEmpty() ? -1 : stack.peek();

            stack.push((int) n - 1);

            n--;
        }
        return ans;
    }
}

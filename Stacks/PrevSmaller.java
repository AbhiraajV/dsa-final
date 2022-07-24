public class PrevSmaller {
    public static void main(String[] args) {

    }

    public static long[] getPrevSmallerArray(long[] arr, long n) {

        long[] ans = new long[(int) n];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i != n) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);

            i++;
        }
        return ans;
    }
}

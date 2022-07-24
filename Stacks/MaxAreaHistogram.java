public class MaxAreaHistogram {
    public static void main(String[] args) {

    }

    public static long getMaxArea(long hist[], long n) {
        long[] nextSmaller = new long[(int) n];

        long[] prevSmaller = new long[(int) n];

        nextSmaller = getNextSmallerArray(hist, n);
        prevSmaller = getPrevSmallerArray(hist, n);
        long maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (nextSmaller[i] == -1)
                nextSmaller[i] = n;

            long breadth = nextSmaller[i] - prevSmaller[i] - 1;

            long curArea = hist[i] * breadth;

            maxArea = Math.max(maxArea, curArea);

        }

        return maxArea;

    }

    static long[] getNextSmallerArray(long[] hist, long n) {

        long[] ans = new long[(int) n];
        Stack<Integer> stack = new Stack<>();

        while (n != 0) {

            while (!stack.isEmpty() && hist[stack.peek()] >= hist[(int) n - 1])
                stack.pop();

            ans[(int) n - 1] = stack.isEmpty() ? -1 : stack.peek();

            stack.push((int) n - 1);

            n--;
        }
        return ans;
    }

    static long[] getPrevSmallerArray(long[] hist, long n) {

        long[] ans = new long[(int) n];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i != n) {

            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);

            i++;
        }
        return ans;
    }

}

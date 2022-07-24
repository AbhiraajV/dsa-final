public class StockSpan {
    public static void main(String[] args) {

    }

    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int i = 0;
        while (i != n) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);

            i++;
        }
        return ans;

    }
}

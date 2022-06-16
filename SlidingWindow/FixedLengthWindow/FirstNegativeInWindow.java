public class FirstNegativeInWindow {
    public static void main(String[] args) {

    }

    public long[] printFirstNegativeInteger(long A[], int k) {
        int s = 0, e = 0;

        ArrayList<Long> negatives = new ArrayList<>();

        long[] ans = new long[A.length - k + 1];

        while (e < A.length) {
            if (A[e] < 0)
                negatives.add(A[e]);
            if (e - s + 1 == k) {
                if (negatives.size() == 0)
                    ans[s] = 0;
                else {
                    ans[s] = negatives.get(0);
                    if (A[s] == negatives.get(0))
                        negatives.remove(0);
                }
                s += 1;
            }
            e += 1;
        }
        return ans;
    }
}

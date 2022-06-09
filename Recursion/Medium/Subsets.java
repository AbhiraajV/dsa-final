package Medium;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsets(nums));
    }

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        subsetRec(nums, 0, new ArrayList<Integer>());

        return ans;
    }

    public static void subsetRec(int[] A, int col, ArrayList<Integer> cur) {

        if (col >= A.length) {
            ans.add(new ArrayList<Integer>(cur));
            return;
        }

        cur.add(A[col]);

        subsetRec(A, col + 1, cur);

        cur.remove(cur.size() - 1);

        subsetRec(A, col + 1, cur);

    }
}

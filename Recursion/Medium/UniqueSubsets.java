package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UniqueSubsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsetsWithDup(nums));
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        Arrays.sort(nums);
        subsetRec(nums, 0, new ArrayList<>());

        return ans;

    }

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();

    public static void subsetRec(int[] A, int col, ArrayList<Integer> cur) {

        if (col >= A.length) {
            // Collections.sort(cur);
            System.out.println(cur);
            if (!map.containsKey(cur)) {
                ans.add(new ArrayList<Integer>(cur));
                map.put(cur, 1);
            }
            return;
        }

        cur.add(A[col]);

        subsetRec(A, col + 1, cur);

        cur.remove(cur.size() - 1);

        subsetRec(A, col + 1, cur);
    }
}

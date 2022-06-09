// Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
// Example 1:

// Input:
// K = 3
// arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
// Output: 1 2 3 4 5 6 7 8 9
// Explanation:Above test case has 3 sorted
// arrays of size 3, 3, 3
// arr[][] = [[1, 2, 3],[4, 5, 6], 
// [7, 8, 9]]
// The merged list will be 
// [1, 2, 3, 4, 5, 6, 7, 8, 9].

// Pointers Method
public class MergeKSortedArrays {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> sortedOrder;

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        sortedOrder = new ArrayList<>();

        merge(arr, new int[arr.length]);

        return sortedOrder;
    }

    static void merge(int[][] arr, int[] curPos) {
        int curMaxPos = getCurMaxPos(arr, curPos);

        if (curMaxPos == -1)
            return;

        sortedOrder.add(arr[curMaxPos][curPos[curMaxPos]]);

        curPos[curMaxPos] += 1;

        merge(arr, curPos);
    }

    static int getCurMaxPos(int[][] arr, int[] curPos) {

        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (curPos[i] >= arr[i].length)
                continue;
            if (max == -1 || arr[max][curPos[max]] > arr[i][curPos[i]])
                max = i;
        }

        return max;
    }
}

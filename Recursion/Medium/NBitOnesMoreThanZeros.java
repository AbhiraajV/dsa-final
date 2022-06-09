package Medium;
// Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s for any prefix of the number.

// Example 1:

// Input:  N = 2
// Output: 11 10
// Explanation: 11 and 10 have more than 
// or equal 1's than 0's
import java.util.ArrayList;

public class NBitOnesMoreThanZeros {
    public static void main(String[] args) {

    }

    static ArrayList<String> ans;

    ArrayList<String> NBitBinary(int N) {
        ans = new ArrayList<>();

        getNBit(0, 0, N, "");

        return ans;
    }

    static void getNBit(int ones, int zeros, int total, String cur) {

        if (ones + zeros == total) {
            ans.add(cur);
            return;
        }

        getNBit(ones + 1, zeros, total, cur + "1");
        if (zeros < ones)
            getNBit(ones, zeros + 1, total, cur + "0");

    }
}

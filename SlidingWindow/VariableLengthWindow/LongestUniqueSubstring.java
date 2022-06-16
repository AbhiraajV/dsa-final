// Given a string S, find the length of the longest substring without repeating characters.

// Example 1:

// Input:
// S = "geeksforgeeks"
// Output:
// 7
// Explanation:
// Longest substring is
// "eksforg".
public class LongestUniqueSubstring {
    public static void main(String[] args) {

    }

    int longestUniqueSubsttr(String S) {

        HashMap<Character, Integer> map = new HashMap<>();

        int len = -1, i = 0, j = 0, n = S.length();

        while (j < n) {
            Character cur = S.charAt(j);

            if (map.containsKey(cur))
                map.put(cur, map.get(cur) + 1);
            else
                map.put(cur, 1);

            if (map.size() == j - i + 1)
                len = Math.max(len, map.size());
            else if (map.size() < j - i + 1) {
                cur = S.charAt(i);
                while (map.size() < j - i + 1) {
                    if (map.containsKey(cur))
                        map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0)
                        map.remove(cur);
                    i++;
                }
            }
            j++;

        }
        return len;
    }
}

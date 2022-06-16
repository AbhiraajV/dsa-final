
// Given a string you need to print the size of the longest 
// possible substring that has exactly K unique characters. 
// If there is no possible substring then print -1.

// Example 1:

// Input:
// S = "aabacbebebe", K = 3
// Output: 7
// Explanation: "cbebebe" is the longest 
// substring with K distinct characters.
public class LongestKUniqueCharSubstring {
    public static void main(String[] args) {

    }

    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int size = -1;

        int i = 0, j = 0, count = 0;

        while (j < s.length() && i < s.length()) {
            // System.out.println(map+" "+);
            Character cur = s.charAt(j);

            if (map.containsKey(cur))
                map.put(cur, map.get(cur) + 1);
            else
                map.put(cur, 1);

            if (map.size() == k)
                size = Math.max(size, j - i + 1);
            else {
                while (map.size() > k) {
                    cur = s.charAt(i);
                    if (map.containsKey(cur))
                        map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0)
                        map.remove(cur);
                    i++;
                }
            }

            j++;
        }

        return size;
    }
}

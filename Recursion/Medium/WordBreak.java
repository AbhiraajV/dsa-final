package Medium;

// Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary word can be used more than once. Return all such possible sentences.

// Follow examples for better understanding.

// Example 1:

// Input: s = "catsanddog", n = 5 
// dict = {"cats", "cat", "and", "sand", "dog"}
// Output: (cats and dog)(cat sand dog)
// Explanation: All the words in the given 
// sentences are present in the dictionary.
import java.util.ArrayList;

public class WordBreak {
    public static void main(String[] args) {

    }

    static ArrayList<String> ans;

    static ArrayList<String> wordBreak(int n, ArrayList<String> dict, String s) {
        ans = new ArrayList<>();
        wordBreakUtil(dict, s, "");
        return ans;
    }

    static void wordBreakUtil(ArrayList<String> dict, String s, String cur) {

        if (s.length() == 0) {
            ans.add(cur.substring(0, cur.length() - 1));
            return;
        }

        for (int i = 0; i < dict.size(); i++) {

            if (s.charAt(0) != dict.get(i).charAt(0) || s.length() < dict.get(i).length())
                continue;

            int foundTill = wordInString(s, dict.get(i));

            if (foundTill == -1)
                continue;

            wordBreakUtil(dict, s.substring(foundTill),
                    cur + s.substring(0, foundTill) + " ");
        }

    }

    static int wordInString(String word, String s) {

        for (int j = 0; j < s.length(); j++)
            if (s.charAt(j) != word.charAt(j))
                return -1;

        return s.length();
    }

}

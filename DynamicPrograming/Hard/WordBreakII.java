package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
    public static void main(String[] args) {

    }

    static Set<String> dict;
    static HashMap<Integer, List<String>> dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<String>(wordDict);

        dp = new HashMap<>();

        return f(s, 0);

    }

    static List<String> f(String s, int i) {
        List<String> res = new ArrayList<String>();

        if (i >= s.length()) {
            res.add("");
            return res;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        for (int j = i; j <= s.length(); j++) {
            String cur = s.substring(i, j);
            if (dict.contains(cur)) {

                List<String> subSol = f(s, j);

                for (String solution : subSol) {
                    String space = solution == "" ? "" : " ";
                    res.add(cur + space + solution);
                }

            }
        }

        dp.put(i, res);
        return res;
    }
}

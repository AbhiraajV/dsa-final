import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.println(find_permutation("abc"));
    }

    public static List<String> find_permutation(String S) {
        // List<String> arr = new ArrayList<>;
        List<String> ans = getPerms(S, "");

        ans = removeDups(ans);

        Collections.sort(ans);

        return ans;
    }

    static List<String> getPerms(String S, String perm) {
        List<String> ans = new ArrayList<>();
        if (S.length() == 0) {
            ans.add(perm);
            return ans;
        }

        for (int i = 0; i < S.length(); i++)
            ans.addAll(getPerms(S.substring(0, i) + S.substring(i + 1), perm + S.charAt(i)));

        return ans;
    }

    static List<String> removeDups(List<String> a) {
        HashSet<String> mp = new HashSet<>();

        for (int i = 0; i < a.size(); ++i)
            mp.add(a.get(i));

        List<String> out = new ArrayList<String>();

        for (String ele : mp)
            out.add(ele);

        return out;

    }
}

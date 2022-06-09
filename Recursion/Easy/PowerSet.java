// https://practice.geeksforgeeks.org/problems/subsets-1613027340/1/?page=1&difficulty[]=1&difficulty[]=2&category[]=Recursion&sortBy=submissions#
package Easy;

// all subset's set is power set
import java.util.ArrayList;

public class PowerSet {
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }

    static ArrayList<String> ans = new ArrayList<>();

    static ArrayList<String> powerSet(String s) {
        ans = new ArrayList<>();
        formPowerSet(s, "", 0);
        return ans;
    }

    static void formPowerSet(String s, String cur, int index) {
        if (index >= s.length())
            ans.add(cur);
        else {
            formPowerSet(s, cur + s.charAt(index), index + 1);
            formPowerSet(s, cur, index + 1);
        }

    }
}

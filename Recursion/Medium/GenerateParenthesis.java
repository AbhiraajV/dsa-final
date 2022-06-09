package Medium;

// Given an integer N representing the number of pairs of parentheses, the task is to generate all combinations of well-formed(balanced) parentheses.

// Example 1:

// Input:
// N = 3
// Output:
// ((()))
// (()())
// (())()
// ()(())
// ()()()
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {

    }

    static List<String> ans;

    public List<String> AllParenthesis(int n) {
        ans = new ArrayList<>();

        getAllPar(n, n, "");

        return ans;
    }

    static void getAllPar(int open, int close, String cur) {
        if (open == 0 && close == 0) {
            ans.add(cur);
            return;
        }

        if (open != 0 && open <= close)
            getAllPar(open - 1, close, cur + "(");
        if (close != 0)
            getAllPar(open, close - 1, cur + ")");
    }
}

package Medium;

public class StringFormationFromSubstring {
    public static void main(String[] args) {

    }

    int isRepeat(String s) {

        for (int i = 1; i <= s.length() / 2; i++)
            if (s.length() % i == 0 && isRepeatUtil(s.substring(i), s.substring(0, i)) >= 1)
                return 1;

        return 0;

    }

    static int isRepeatUtil(String s, String toCheck) {
        if (s.length() == 0)
            return 1;
        int out = 0;
        if (isThere(s, toCheck))
            out += isRepeatUtil(s.substring(toCheck.length()), toCheck);
        return out;
    }

    static boolean isThere(String s, String toCheck) {

        for (int i = 0; i < toCheck.length(); i++)
            if (toCheck.charAt(i) != s.charAt(i))
                return false;
        return true;
    }
}

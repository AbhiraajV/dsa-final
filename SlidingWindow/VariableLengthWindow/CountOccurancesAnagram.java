public class CountOccurancesAnagram {
    public static void main(String[] args) {

    }

    int search(String pat, String txt) {

        HashMap<String, Integer> map = new HashMap<>();
        int start = 0, end = 0, plen = pat.length(), count = 0;

        for (int i = 0; i < plen; i++) {
            String cur = "" + pat.charAt(i);
            if (map.containsKey(cur))
                map.put(cur, map.get(cur) + 1);
            else
                map.put(cur, 1);
        }

        int chars = map.size();

        while (end < txt.length()) {

            String cur = "" + txt.charAt(end);

            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0)
                    chars--;
            }
            if (end - start + 1 == plen) {
                cur = "" + txt.charAt(start);

                if (chars == 0)
                    count++;

                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                    if (map.get(cur) == 1)
                        chars++;
                }

                start++;
            }

            end++;
        }

        return count;
    }
}

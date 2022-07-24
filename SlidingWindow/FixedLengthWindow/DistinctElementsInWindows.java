public class DistinctElementsInWindows {
    public static void main(String[] args) {

    }

    ArrayList<Integer> countDistinct(int a[], int n, int k) {
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);

            if (j - i + 1 == k) {
                ans.add(map.size());
                if (map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i]) - 1);
                if (map.get(a[i]) <= 0)
                    map.remove(a[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}

public class SubArrayWithGivenSum {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        int i = 0, j = 0;

        while (j < arr.length) {
            // System.out.println(s);
            s -= arr[j];
            if (s == 0)
                return new ArrayList<Integer>(Arrays.asList(i + 1, j + 1));
            else if (s < 0) {
                while (s < 0) {
                    s += arr[i];
                    i++;
                }
                if (s == 0)
                    return new ArrayList<Integer>(Arrays.asList(i + 1, j + 1));
            }
            j++;
        }
        return new ArrayList<Integer>(Arrays.asList(-1));
    }
}

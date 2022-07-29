import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class FindVertextReachAllNodes {
    public static void main(String[] args) {

    }

    static ArrayList<ArrayList<Integer>> g__adj;

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        g__adj = adj;

        for (int i = 0; i < V; i++) {

            if (dfs(i, new HashSet<Integer>(), -1) == V) {
                return i;
            }
            ;
        }
        return -1;
    }

    static int dfs(int cur, HashSet<Integer> map, int parent) {

        map.add(cur);
        for (int i : g__adj.get(cur)) {
            if (!(map.contains(i) && i != parent)) {
                dfs(i, map, cur);
            }
        }

        return map.size();
    }
}
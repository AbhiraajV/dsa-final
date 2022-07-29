public class DirectedCycle {
    public static void main(String[] args) {

    }

    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> g__adj;

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V + 1];
        g__adj = adj;

        for (int i = 0; i < V; i++) {
            if (!vis[i] && solve(i, new HashSet<Integer>()))
                return true;
        }
        return false;

    }

    static boolean solve(int cur, HashSet<Integer> map) {
        if (vis[cur] && map.contains(cur))
            return true;
        if (vis[cur])
            return false;
        map.add(cur);
        vis[cur] = true;

        for (int i : g__adj.get(cur)) {
            if (solve(i, map))
                return true;
        }
        map.remove(cur);
        return false;
    }
}

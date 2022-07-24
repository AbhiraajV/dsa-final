public class DFS {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> ans = new ArrayList<>();
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> g__adj;

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V + 1];
        ans = new ArrayList<>();
        g__adj = adj;
        dfs(0);
        return ans;
    }

    static void dfs(int cur) {
        if (vis[cur])
            return;

        vis[cur] = true;

        for (int i : g__adj.get(cur)) {
            dfs(i);
        }

    }
}

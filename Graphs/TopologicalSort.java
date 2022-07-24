public class TopologicalSort {
    public static void main(String[] args) {

    }

    static int[] ans;
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> g__adj;
    static Stack<Integer> stack;

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        stack = new Stack<>();
        vis = new boolean[V + 1];
        ans = new int[V];
        g__adj = adj;

        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfs(i);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    static void dfs(int cur) {
        if (vis[cur])
            return;

        vis[cur] = true;

        for (int i : g__adj.get(cur)) {
            dfs(i);
        }

        stack.push(cur);

    }
}

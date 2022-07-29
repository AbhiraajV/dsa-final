public class PathExists {
    public static void main(String[] args) {

    }

    static HashMap<Integer, ArrayList<Integer>> adj;
    static boolean[] vis;

    public boolean validPath(int n, int[][] edges, int s, int d) {
        adj = new HashMap<>();
        vis = new boolean[n];
        for (int[] edge : edges) {
            ArrayList<Integer> cur = adj.getOrDefault(edge[0], new ArrayList<Integer>());
            cur.add(edge[1]);
            adj.put(edge[0], cur);

            cur = adj.getOrDefault(edge[1], new ArrayList<Integer>());
            cur.add(edge[0]);
            adj.put(edge[1], cur);
        }

        return dfs(s, d);

        // return bfs(s, d); BFS Approach

    }

    static boolean dfs(int s, int d) {
        if (s == d) {
            return true;
        }
        if (vis[s]) {
            return false;
        }
        vis[s] = true;

        for (int i : adj.get(s)) {

            if (dfs(i, d)) {
                return true;
            }

        }

        return false;
    }

    static boolean bfs(int s, int t) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(s);
        map.put(s, -1);

        while (!q.isEmpty()) {
            int parent = q.poll();
            vis[parent] = true;
            if (!adj.containsKey(parent))
                continue;
            for (int child : adj.get(parent)) {
                if (!vis[child]) {
                    map.put(child, parent);
                    q.add(child);
                }

            }
        }
        int temp = t;
        while (t != s) {
            t = map.getOrDefault(t, -1);
            if (t == temp || t == -1)
                return false;
        }
        return true;
    }
}

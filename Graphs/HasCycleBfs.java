public class HasCycleBfs {
    public static void main(String[] args) {

    }

    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> g__adj;

    static class Pair {
        int cur;
        int parent;

        Pair(int c, int p) {
            this.cur = c;
            this.parent = p;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V + 1];
        g__adj = adj;

        return hasCycle();
    }

    static boolean hasCycle() {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < vis.length; i++) {

            if (vis[i])
                continue;

            q.add(new Pair(i, -1));
            vis[i] = true;

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                // System.out.println(g__adj+" "+cur.cur);
                if (cur.cur >= g__adj.size())
                    break;
                for (int neighbour : g__adj.get(cur.cur)) {
                    if (neighbour != cur.parent && vis[neighbour])
                        return true;
                    else if (!vis[neighbour]) {
                        vis[neighbour] = true;
                        q.add(new Pair(neighbour, cur.cur));
                    }
                }

            }
        }

        return false;
    }

}

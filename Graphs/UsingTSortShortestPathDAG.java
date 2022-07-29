public class UsingTSortShortestPathDAG {
    public static void main(String[] args) {

    }

    static class Pair {
        int node;
        int dist;

        Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }
    }

    static HashMap<Integer, ArrayList<Pair>> g__adj;
    static int[] ans;
    static boolean[] vis;
    static Stack<Integer> st;

    static void formGAdj(ArrayList<ArrayList<Integer>> adj) {

        g__adj = new HashMap<>();
        st = new Stack<>();

        for (ArrayList<Integer> edge : adj) {
            int curNode = edge.get(0), next = edge.get(1), dist = edge.get(2);

            ArrayList<Pair> cur = g__adj.getOrDefault(curNode, new ArrayList<Pair>());

            cur.add(new Pair(next, dist));
            g__adj.put(curNode, cur);
        }

        for (int i = 0; i < vis.length; i++) {
            if (!g__adj.containsKey(i))
                g__adj.put(i, new ArrayList<Pair>());
        }
    }

    static void TopoDfs(int cur) {
        if (vis[cur])
            return;

        vis[cur] = true;

        for (Pair i : g__adj.get(cur)) {
            TopoDfs(i.node);
        }
        st.push(cur);
    }

    static void getTSort(int cur) {

        for (int i = cur; i < vis.length; i++) {
            if (!vis[i])
                TopoDfs(i);
        }

    }

    static int inf_dist = 100000000;

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {
        vis = new boolean[V + 1];
        ans = new int[V + 1];
        Arrays.fill(ans, inf_dist);

        formGAdj(adj); // map < curNode -> list< nextNode,dist > >
        getTSort(0); // return topological sort of the graph

        ans[S] = 0;

        // remove every element before source as all these elements
        // cant be reached by source
        while (!st.isEmpty()) {
            if (st.top == S)
                break;
            st.pop();
        }

        // now check
        while (!st.isEmpty()) {
            int top = st.pop();
            // if(!g__adj.containsKey(top)) continue;
            for (Pair i : g__adj.get(top)) {
                // dist from top element of stack to ith element
                int distTopToI = i.dist;

                // shortest dist from source to top as stored in the ans arr till now
                int distFromSToTop = ans[top];

                // dist to ith (from source to top) + (from top element till ith)
                int distStoI = distFromSToTop + distTopToI;

                // pre calculated dist from source to ith if exists else inf

                int preCalDistStoI = ans[i.node];

                // updating if shorter dist found
                ans[i.node] = Math.min(distStoI, preCalDistStoI);
            }
        }

        return ans;
    }

}

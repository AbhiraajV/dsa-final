class DijkstrasAlgo {
    public static void main(String[] args) {

    }

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] ans = new int[V + 1];
        boolean[] vis = new boolean[V + 1];

        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[S] = 0;
        pq.add(new Pair(S, 0));

        while (pq.size() > 0) {
            // get element at the shortest distance from source currently
            int cur = pq.remove().node;

            // if visited ignore and continue
            if (vis[cur])
                continue;
            // else mark as visited
            vis[cur] = true;

            // for every neighbour check if ans can have a shorted dist for that node
            for (ArrayList<Integer> neighbour : adj.get(cur)) {

                int node = neighbour.get(0); // cur node i
                int dist = neighbour.get(1); // dist from cur to i

                // if visited ignore and continue
                if (vis[node])
                    continue;

                // source to cur + dist(cur to node) => source to node

                int sourceToNode = ans[cur] + dist;

                // ans[node] contains previously stored dist of node from source
                // or +inf
                ans[node] = Math.min(ans[node], sourceToNode);
                pq.add(new Pair(node, ans[node]));

            }

        }

        return ans;

    }
}
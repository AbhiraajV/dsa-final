public class DirectedCycleBfs {
    public static void main(String[] args) {

    }

    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> g__adj;
    static int g__V;

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[V + 1];
        g__adj = adj;
        g__V = V;
        // for( int i = 0; i < V; i++ ){
        // if( !vis[i] && solve(i,new HashSet<Integer>()) ) return true;
        // }
        // return false;
        return topoSortKahnAlgo();

    }

    static boolean topoSortKahnAlgo() {
        Queue<Integer> q = new LinkedList<>();

        // create indegree array
        int[] indeg = new int[g__V];

        for (ArrayList<Integer> temp : g__adj) {
            for (int i : temp) {
                indeg[i] += 1;
            }
        }

        // push all node having 0 indegree into a Queue
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {

            // adds only those having 0 indegree currently!!
            int node = q.poll();

            count++;
            for (int neighbour : g__adj.get(node)) {
                indeg[neighbour] -= 1;
                if (indeg[neighbour] == 0) {
                    q.add(neighbour);
                }
            }

        }
        return count != g__V;

    }
}

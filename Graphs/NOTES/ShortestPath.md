Shortest Path

1. Undirected Unweighted
   a. BFS
   First Find the Parent of each node using BFS and store it.
   Then using t get its parent and set that to t
   keep doing the above step till t === s
   return the count or store each node and return path
   b. DFS
   if s === d return true or a map that stores the path till here(till the current call)
2. Undirected Weighted => Dijkstra's Algo
   ->Create a ans array which has shortest dist from source to node at index
   ->Create a priority queue that returns smallest dist node.
   ->Insert Source at 0 distance to PQ.
   -> while pq != null
   ->-> for each of the shortest node element at top get its neighbours and see if stored ans is > new ans ( dist from cur to neighbour as in adj + source to cur as in ans)
   if > replace!
   and insert into pq
   TOP 10 QUESTIONS https://leetcode.com/list/53js48ke/

3. Directed Weighted

   A. Cyclic
   a. Bellman-Ford Algorithm
   b. Dijkstra's (exact same method as in undirected)

   B. Acyclic=> (DAG) TOPO SORT METHOD

   Method 1 Unoptimized.
   a. Fill a D array with inf.
   b. loop i through 0 to N, for every element =>
   (dist from source to i as stored in D array) + (dist from i to its neighbour as in adj array) = source to neighbour dist.
   is less than dist from source to neighbour as stored in D array

   Method 2 Optimized.
   a. As we know in a toposort stack all elements appearing before an element in the stack have the max connections. ( ONLY INCASE OF DAG) All elements appearing before a element hence has no way to reach it.

   So we repeat Method 1 but instead of looping 0 to N we check in a topo sort of graph

   a. Find T.sort of the graph.
   b. Fill a D array with inf.
   c. check for top of topo stack till stack empty =>
   (dist from source to top as stored in D array) + (dist from top to its neighbour as in adj array) = source to neighbour dist.
   is less than dist from source to neighbour as stored in D array

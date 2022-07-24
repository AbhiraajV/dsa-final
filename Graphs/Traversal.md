BFS

1.Maintain a Queue and a vis[]
2.if !vis add cur to queue and vis[cur] = true
3.remove each element and add to ans[]

DFS

1. base case if(vis[cur]) return;
2. add cur to ans[] if passes base case
3. loop all adj of cur and recursively call for each

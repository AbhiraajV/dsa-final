Cycle Problems:

1. For Undirected
   CONDITION => If cur node's neighbour has been visited and it's parent  
    is not the neighbour return true!

   a.BFS Approach:
   While in BFS traversal store cur node with its parent.
   Check for condition!

   b. DFS Approach:
   Loop for cur node's neighbour while checking for condition.
   If !CONDITION recursively call for next node i.e. not visited

2. For Directed
   CONDITION => If cur node has been visited before and at the same time
   it was visited in the current path. return true!!

   a. DFS Approach:
   Maintain a HashSet of nodes visited in this path
   flow => add to map => call for next => remove from map (backtrack)
   Base case check each time if
   CONDITION => vis\_\_global[cur] == true && map.contains(cur) return true

   b. BFS Approach:
   We know Kahn's Algo is a good method to find a topological sort of the graph.
   Also a graph only has a t.sort iff its a DAG.
   For a directed graph to check if the graph is Acyclic we can use the above relation!

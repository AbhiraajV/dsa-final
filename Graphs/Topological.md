Topological sort of a Tree is an order of nodes of graph such that each
element in that order i < j is such that i comes before j in its adj list too.

Approach 1.
Use DFS to find the last element in a path from where there exists no other path.
This is then added to the stack.
Reason?
Stack being a FILO DS ensures that the element having no paths starting from it(or lowest no. of paths starting from it) remains at the last of our topological sort.

Approach 2.
Use BFS Kahn's Algo

1. Create Indegree Array for each node
2. Push all node having 0 indegree into a Queue
3. While !q.empty() add neighbours of q.top() where indegree-- == 0 else reduce indegree--
4. Each element is added to array

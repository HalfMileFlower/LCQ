class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                count++;
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < edges[current].size(); i++) {
                int neighbor = (int)edges[current].get(i);
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        
        return count == numCourses;
    }
}

// Notes: Topological sorting
// inDegree & edges
// use a queue to put courses whose indegrees are 0
// finally compare the number of courses that have been put in the queue to the numCourses
// TC: O(n)  SC: O(n)

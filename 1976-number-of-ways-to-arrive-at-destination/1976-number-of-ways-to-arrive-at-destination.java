class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        List<List<List<Integer>>> adjList = makeAdjList(n, roads);
                
        long[] minDist = new long[n];
        Arrays.fill(minDist, Long.MAX_VALUE);
        minDist[0] = 0; 

        int[] pathCount = new int[n];
        pathCount[0] = 1; 

        Queue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        queue.offer(new long[]{0, 0});

        while(!queue.isEmpty()){
            long[] curr = queue.poll();
            long currNode = curr[0], currDist = curr[1];
            if(currDist > minDist[(int)currNode]) continue;

            for(var adj : adjList.get((int)currNode)){
                int nextNode = adj.get(0);
                long nextDist = currDist + adj.get(1);

                if(nextDist > minDist[nextNode]) continue;
                if(nextDist == minDist[nextNode]){
                    pathCount[nextNode] = (pathCount[nextNode] + pathCount[(int)currNode]) % MOD;
                } else {
                    minDist[nextNode] = nextDist;
                    pathCount[nextNode] = pathCount[(int)currNode];
                    queue.offer(new long[]{nextNode, nextDist});
                }
            }
        }
        return pathCount[n-1];
    }

    List<List<List<Integer>>> makeAdjList(int n, int[][] roads){
       
       List<List<List<Integer>>> adjList = new ArrayList<>();
       for(int i = 0; i<n; i++)
        adjList.add(new ArrayList<>());
       
       
       for(int[] edge : roads){
        int start = edge[0], end = edge[1], travelTime = edge[2];
        adjList.get(start).add(List.of(end, travelTime));
        adjList.get(end).add(List.of(start, travelTime));
       }

       return adjList;
    }
}
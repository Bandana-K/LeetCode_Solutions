//Based on Editorial soln 1
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        //create and initialize adjency list for each vertex
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            List<Integer> adj = new ArrayList<>();
            adj.add(i);
            adjList.add(adj);
        }

        //populate the full adjency list
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Map<List<Integer>, Integer> map = new HashMap<>();
        for(var adj : adjList){
            Collections.sort(adj);
            map.put(adj, map.getOrDefault(adj,0)+1);
        }

        int result = 0;
        for(var entry: map.entrySet()){
            List<Integer> adj = entry.getKey();
            int count = entry.getValue();
            if(adj.size() == count) result++;
        }

        return result;
    }
}
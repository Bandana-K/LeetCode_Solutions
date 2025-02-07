class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Set<Integer>> colorMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();

        for(int i = 0; i< queries.length; i++){
            int ball = queries[i][0], color = queries[i][1];
            if(ballMap.containsKey(ball)){
                int previousColor = ballMap.get(ball);
                var previousBalls = colorMap.get(previousColor);
                previousBalls.remove(ball);
                if(previousBalls.size() == 0)
                    colorMap.remove(previousColor);
            }
            ballMap.put(ball, color);
            Set<Integer> balls = colorMap.containsKey(color) ? colorMap.get(color) : new HashSet<>();
            balls.add(ball);
            colorMap.put(color, balls);
            ans[i] = colorMap.keySet().size();
        }

        return ans;
    }
}
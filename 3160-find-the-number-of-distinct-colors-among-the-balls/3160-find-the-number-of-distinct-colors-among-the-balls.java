class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> colorMap = new HashMap<>();  // We don't really need to know the ball numbers where a color is applied but only the number of balls to which this color is applied. So instead of Set<Integer> we can do the same task in Integer aswell.
        Map<Integer, Integer> ballMap = new HashMap<>();

        for(int i = 0; i< queries.length; i++){
            int ball = queries[i][0], color = queries[i][1];
            if(ballMap.containsKey(ball)){
                int previousColor = ballMap.get(ball);
                colorMap.put(previousColor, colorMap.get(previousColor) -1 );
                if(colorMap.get(previousColor) == 0)
                    colorMap.remove(previousColor);
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0)+1);

            ans[i] = colorMap.keySet().size();
        }
        return ans;
    }
}
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        int[] freq = new int[n*n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j< n; j++){
                int k = grid[i][j];
                freq[k-1] = freq[k-1]+1;
            }

        for(int i = 0; i < freq.length; i++){
            if(ans[0] == 0 || ans[1] == 0){
                if(freq[i] == 2) ans[0] = i+1;
                else if (freq[i] == 0) ans[1] = i+1;
                else continue;

            } else break;
        }
            
        return ans;
        
    }
}
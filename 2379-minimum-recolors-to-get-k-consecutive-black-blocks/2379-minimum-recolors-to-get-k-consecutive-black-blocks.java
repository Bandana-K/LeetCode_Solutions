class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i+k <= blocks.length(); i++){
            int white = 0;
            for(int j = i; j < i+k; j++){
                if(blocks.charAt(j) == 'W')
                    white++;
            }
            if(white == 0) return 0;
            result = Math.min(result, white);
        }
        return result;
    }
}
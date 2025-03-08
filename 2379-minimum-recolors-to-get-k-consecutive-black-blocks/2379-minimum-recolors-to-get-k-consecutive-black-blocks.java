class Solution {
    public int minimumRecolors(String blocks, int k) {
        int result = Integer.MAX_VALUE;
        int white = 0;
        for(int i = 0 ; i < k; i++){
            if(blocks.charAt(i) == 'W') white++;
        }
        if(white == 0) return 0;
        result = Math.min(result, white);

        for(int i = k; i<blocks.length(); i++){
            int whiteAdded = blocks.charAt(i) == 'W' ? 1 : 0;
            int whiteRemoved = blocks.charAt(i-k) == 'W' ? 1 : 0;
            white = white + whiteAdded - whiteRemoved;
            if(white == 0) return 0;
            result = Math.min(result, white);
        }
        return result;
    }
}
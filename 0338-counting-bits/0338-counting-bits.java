class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        while( n > 0 ){
            ans[n] = bitCount(n);
            n--;
        }
        ans[0] = 0;
        return ans;
    }

    private static int bitCount(int n){
        int result = 0;
        while(n > 0) {
            if( n%2 == 1)
                result++;
            n = n/2;
        }
        return result;
    }
}


class Other_Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        while( n > 0 ){
            ans[n] = Integer.bitCount(n);
            n--;
        }
        ans[0] = 0;
        return ans;
    }
}
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            if(piles[i] > max) max = piles[i];
        }
    
        int left = 1, right = max;
        int result = 0;
        while(left <= right){
            int mid = (left + right)/2;
            // System.out.println("left = " + left + " right = " + right + " mid = " + mid);

            if(canEat(mid, piles, h)){
                result = mid;
                // System.out.println(" result = " + result);
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }

        return result;
    }

    boolean canEat(int limit, int[] piles, int hours){
        long hoursTaken = 0;
        for(int i=0; i<piles.length; i++){
            if(piles[i] <= limit){
                hoursTaken++;
            } else{
                hoursTaken += (long)piles[i] / limit;
                if(piles[i] % limit != 0) hoursTaken++;
            }
        }
        // System.out.println("For limit = " + limit + " hoursTaken = " + hoursTaken);
        return hoursTaken <= hours;
    }
}
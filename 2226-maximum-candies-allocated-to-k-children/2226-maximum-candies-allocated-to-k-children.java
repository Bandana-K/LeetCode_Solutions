class Solution {
    public int maximumCandies(int[] candies, long k) {

        int n = candies.length, result = 0, max = Integer.MIN_VALUE;
        long sum = 0;
        
        for(int i = 0; i<n; i++){
            if(candies[i] > max) max = candies[i];
            sum += candies[i];
        }

        if(sum < k) return 0;

        // System.out.println("Max = " + max);

        int left = 1, right = max;
        // System.out.println("left = " + left + " right = " + right);

        while(left <= right){
            int mid = (left+right)/2;
            // System.out.println("mid = " + mid);
            if(canDistribute(mid, candies, k)){
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
            // System.out.println("left = " + left + " right = " + right);
        }
        return result;
    }

    boolean canDistribute(int limit, int[] candies, long k){
        long kids = 0l;
        for(int i = 0; i< candies.length; i++){
            kids = kids + candies[i]/limit;
        }
        // System.out.println("Can distribute to kids = " + kids + " k  = " + k);
        return kids >= k;
    }
}
class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        int n = price.length;
        Arrays.sort(price);

        int low = 0, high = price[n-1]-price[0], result = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canSellCandies(price, k, mid)){
                result = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }

    boolean canSellCandies(int[] price, int k, int mid){
        int n = price.length;
        if(price[n-1] <= mid) return false;
        int candies = 1, prev = price[0];
        for(int i = 1; i<n && candies<k ; i++){
            if(price[i] - prev >= mid){
                prev = price[i];
                candies++;
            }
        }
        return candies >= k;
    }
}
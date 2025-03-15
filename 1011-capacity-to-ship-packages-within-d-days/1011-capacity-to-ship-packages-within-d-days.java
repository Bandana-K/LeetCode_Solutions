class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length, sum = 0;
        for(int i = 0; i<n; i++){
            sum += weights[i];
        }

        int left = 1, right = sum, result = 1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canShip(mid, weights, days)){
                result = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return result;
    }

    boolean canShip(int limit, int[] weights, int days){
        int shippingDay = 0, sum = 0;
        for(int i = 0; i<weights.length;){
            if(weights[i] > limit) return false;
            
            sum += weights[i];
            if(sum < limit){
                i++;
            } else if(sum == limit){
                shippingDay ++;
                i++;
                sum = 0;
            } else {
                shippingDay ++;
                sum = 0;
            } 
        }

        if(sum != 0) shippingDay++;
        return shippingDay <= days;
    }
}
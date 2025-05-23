class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, result = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((long)mid*mid <= (long)x){
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return result;
    }
}
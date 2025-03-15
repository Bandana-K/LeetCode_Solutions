class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++){
            if(bloomDay[i] > max) max = bloomDay[i];
        }

        int left = 1, right = max, result = -1;
        while(left<= right){
            int mid = left + (right-left)/2;
            // System.out.println("Left = " + left + " right = " + right + " mid = " + mid);
            if(canMakeBouquets(mid, bloomDay, m, k)){
                result = mid;
                right = mid -1;
            } else {
                left = mid + 1; 
            }
        }
        return result;
    }

    boolean canMakeBouquets(int limit, int[] bloomDay, int m, int k){
        int count = 0, n = bloomDay.length, i = 0, j = i+k;
        for(; j<=n; j = i+k){
            // System.out.print("i = " + i + " j = " + j);

            boolean isValidI = true;
            for(int l = i; l<j; l++){
                if(bloomDay[l] <= limit) continue;
                else {
                    isValidI = false;
                    i = l+1;
                    break;
                }
            }

            if(isValidI){
                count++;
                i = j;
            } 
            // System.out.println(" isValidI = " + isValidI + " count = " + count);
        }
        return count >= m;
    }
}
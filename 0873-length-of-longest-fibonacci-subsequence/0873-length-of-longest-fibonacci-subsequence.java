// The idea is to keep a map of numbers and their index. So that to check if the fibonacci sum exists, it can be checked in O(1)
// And keep on going with x1, x2 till the time we find x1+x2 in map. Do this for each i and j O(n^2) at max
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, result = 0;
        Map<Long, Integer> arrIdx = new HashMap<>();
        for(int i=0; i < n; i++){
            arrIdx.put((long) arr[i], i);
        }


        for(int i = 0; i < n ; i++){
            int x1 = arr[i], count = 0, k=0;
            for(int j = i+1; j<n; ){
                long sum = (long) x1 + arr[j];
                if(arrIdx.containsKey(sum)){
                    if(count == 0){
                        count = count+3;
                        k = j;
                    } else count++;
                    x1 = arr[j];
                    j = arrIdx.get(sum);
                    result = Math.max(result, count);
                } else {
                    if(count == 0) j++;
                    else{
                         j = k+1;
                         count = 0;
                         x1 = arr[i];
                    }
                }
            }
        }

        return result;
    }
}
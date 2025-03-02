class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, result = 0;
        Map<Long, Integer> arrIdx = new HashMap<>();
        for(int i=0; i < n; i++){
            arrIdx.put((long) arr[i], i);
        }

        // System.out.println(arrIdx);

        for(int i = 0; i < n ; i++){
            int x1 = arr[i], count = 0, k=0;
            // System.out.println(" i = "+i );
            for(int j = i+1; j<n; ){
                long sum = (long) x1 + arr[j];
                // System.out.println(" x1 = " + x1 + " j = "+j + " arr[j] = " + arr[j]);
                if(arrIdx.containsKey(sum)){
                    if(count == 0){
                        count = count+3;
                        k = j;
                    } else count++;
                    x1 = arr[j];
                    j = arrIdx.get(sum);
                    // System.out.println(" sum = " + sum + " found, new j = " + j + " count = "+ count);
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
            // System.out.println(" result = "+ result);

        }

        return result;
    }
}
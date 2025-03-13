//COPIED
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }
}

// class Solution {
//     public int minZeroArray(int[] nums, int[][] queries) {
//         int n = nums.length, q = queries.length, count = 0;
//         boolean allZero = false;

//         for(int i = 0; i<q; i++){
            
//             allZero = checkZeroArray(nums);
//             if(allZero) break;

//             int l = queries[i][0];
//             int r = queries[i][1];
//             int val = queries[i][2];
//             for(int j = l; j<=r; j++){
//                 if(nums[j] <= val) nums[j] = 0;
//                 else nums[j] = nums[j]-val;
//             }
//             count++;
            
//             allZero = checkZeroArray(nums);
//             if(allZero) break;
//         }

//         if(allZero) return count;
//         return -1;
        
//     }

//     private boolean checkZeroArray(int[] nums){
//         for(int i = 0; i<nums.length; i++){
//             if(nums[i] != 0) return false;
//         }
//         return true;
//     }
// }
//COPED FROM EDITORIAL
public class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }
}

// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int n = nums.length;
//         int[] leftMax = new int[n];
//         int[] rightMin = new int[n];
//         int[] rightMax = new int[n];
//         long result = 0;

//         leftMax[0] = nums[0];
//         rightMin[n-1] = nums[n-1];
//         rightMax[n-1] = nums[n-1];

//         for(int i = 1; i<n; i++){
//             leftMax[i] = Math.max(leftMax[i-1], nums[i]);
//         }

//         for(int i = n-2; i>=0; i--){
//             rightMin[i] = Math.min(rightMin[i+1], nums[i]);
//             rightMax[i] =  Math.max(rightMax[i+1], nums[i]);
//         }

//         for(int i =0; i<n; i++) System.out.print(leftMax[i] + " ") ;  
//         System.out.println();   
//         for(int i =0; i<n; i++) System.out.print(rightMin[i] + " ") ;   
//         System.out.println();   
//         for(int i =0; i<n; i++) System.out.print(rightMax[i] + " ") ;     

//         for(int i =0; i<n; i++){
//             if(leftMax[i] != rightMax[i]) {
//                 result = Math.max(result, ((long)leftMax[i]-rightMin[i])*rightMax[i]);
//                 System.out.println("result = " + result);
//             }
//         }

//         return result>0? result : 0;
//     }
// }
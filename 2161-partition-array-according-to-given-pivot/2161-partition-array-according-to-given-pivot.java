class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int j = 0, countPivot = 0;

        for(int i = 0; i<n; i++){
            if(nums[i] < pivot){
                result[j++] = nums[i];
            } else if (nums[i] ==  pivot){
                countPivot++;
            }
        }

        for(int i = 0; i<countPivot; i++) result[j++] = pivot;

        for(int i = 0; i<n; i++){
            if(nums[i] > pivot) result[j++] = nums[i];
        }

        return result; 
    }
}
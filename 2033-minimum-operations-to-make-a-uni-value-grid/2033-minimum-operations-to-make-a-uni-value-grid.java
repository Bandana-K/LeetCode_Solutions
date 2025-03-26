class Solution {
    public int minOperations(int[][] grid, int x) {
        //Convert 2d to 1d array
        //Sort and then get the element at mid position
        //Then one by one for each element check if it can be converted to median element if yes count the operation else return -1
        
        int m = grid.length, n = grid[0].length;
        int[] nums = new int[m*n];
        
        for(int i=0, k =0; i<m; i++)
            for(int j = 0; j<n; j++)
                nums[k++] = grid[i][j];

        Arrays.sort(nums);
        int mid = (m*n)/2;

        int median = nums[mid];

        int result = 0;
        for(int i = 0; i< (m*n); i++){
            int diff = Math.abs(nums[i]-median);
            if((diff % x) == 0){
                result += (diff/x);
            } else {
                return -1;
            }
        }
        return result;
    }
}
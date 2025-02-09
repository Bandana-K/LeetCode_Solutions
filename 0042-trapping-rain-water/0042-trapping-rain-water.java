// Water stored at any unit is = Min(leftMaxHeightBuilding, rightMaxHeightBuilding) - height of current unit
//Time complexity is O(3*n) ~~ O(n) and space is O(2n) ~ O(n)
class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] leftMax = new int[n];
        int currentLeftMax = height[0];
        leftMax[0] = currentLeftMax;
        for(int i = 1; i < n; i++){
            currentLeftMax = Math.max(currentLeftMax, height[i]);
            leftMax[i] = currentLeftMax;
        }

        int[] rightMax = new int[n];
        int currentRightMax = height[n-1];
        rightMax[n-1] = currentRightMax;
        for(int i = n-2; i >= 0 ; i--){
            currentRightMax = Math.max(currentRightMax, height[i]);
            rightMax[i] = currentRightMax;
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        
        return ans;
    }
}
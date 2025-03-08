class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for(int i = nums.length-1 ; i >= 0; i--)
            stack.push(nums[i]);

        for(int i = nums.length-1; i >= 0; i--){
            int nextIdx = (i+1)%nums.length;
            int nextMax = -1;
            if(nums[i] < nums[nextIdx]) nextMax = nums[nextIdx];
            else {
                while(!stack.isEmpty() && stack.peek() <= nums[i])
                    stack.pop();
                
                if(stack.isEmpty()) {
                    stack.push(-1);
                }
                else nextMax = stack.peek();    
            }
            result[i] = nextMax;
            stack.push(nextMax);
        }

        return result;
    }

}
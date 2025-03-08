class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int[] newNum = new int[nums.length*2];
        int[] newNumMax = new int[nums.length*2];
        for(int i = 0; i < nums.length; i++){
            newNum[i] = nums[i];
            // System.out.print(newNum[i] + " ");
        }

        for(int i = 0; i < nums.length; i++){
            newNum[nums.length+i] = nums[i];
            // System.out.print(newNum[nums.length+i] + " ");
        }

        // System.out.println();

        Stack<Integer> stack = new Stack<>();
        newNumMax[newNumMax.length-1] = -1;
        stack.push(-1);
        for(int i = newNum.length-2; i >= 0; i--){
            int nextMax = -1;
            // System.out.println("i = " + i + " newNum[i] = " + newNum[i]);
            // System.out.println("Previous stack = " + stack);
            if(newNum[i] < newNum[i+1]) nextMax = newNum[i+1];
            else {
                while(!stack.isEmpty() && stack.peek() <= newNum[i])
                    stack.pop();
                
                if(stack.isEmpty()) {
                    // System.out.println("Stack is empty");
                    stack.push(-1);
                }
                else nextMax = stack.peek();    
            }
            // System.out.println("New stack = " + stack);
            // System.out.println("NextMax = "  + nextMax);
            newNumMax[i] = nextMax;
            stack.push(nextMax);
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = newNumMax[i];
        }

        return result;
    }

}
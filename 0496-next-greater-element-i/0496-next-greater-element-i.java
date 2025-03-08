class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        map.put(nums2[nums2.length-1], -1);
        stack.push(-1);
        for(int i = nums2.length-2; i >= 0; i--){
            int nextMax = -1;
            if(nums2[i] < nums2[i+1]) nextMax = nums2[i+1];
            else {
                while(!stack.isEmpty() && stack.peek() < nums2[i])
                    stack.pop();
                
                if(stack.isEmpty())
                    stack.push(-1);
                else nextMax = stack.peek();    
            }
            map.put(nums2[i], nextMax);
            stack.push(nextMax);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

}
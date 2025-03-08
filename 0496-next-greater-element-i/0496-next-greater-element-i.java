class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            int nextMax = -1;
            for(int j = i+1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    nextMax = nums2[j];
                    break;
                }
            }
            map.put(nums2[i], nextMax);

        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

}
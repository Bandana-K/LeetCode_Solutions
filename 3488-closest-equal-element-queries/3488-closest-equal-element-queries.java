class Solution {
    
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        Map<Integer, List<Integer>> numIndicesMap = new HashMap<>();
        populateMap(numIndicesMap, nums);

        // System.out.println(numIndicesMap);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< queries.length; i++){
            int idx = queries[i];
            int num = nums[idx];
            // System.out.println("For i = "+ i+ " idx = " + idx + " num = " + num);
            int dist = findDistnace(numIndicesMap, num, idx, nums.length);
            result.add(dist);
        }
        return result;
    }
    
    int findDistnace(Map<Integer, List<Integer>> numIndicesMap, int num, int target, int n){
        List<Integer> searchList = numIndicesMap.get(num);
        if(searchList.size() == 1) return -1;

        int low = 0, high = searchList.size()-1, result = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            // System.out.println("low = "+ low + " high = " + high + " mid = " + mid);
            if(searchList.get(mid) == target){
                result = mid;
                break;
            } else if(searchList.get(mid) < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        // System.out.print("For num = "+ num + " target = " + target + " result = " + result);

        int left =0, right = 0;
        if(result == 0){
            right = searchList.get(1)-searchList.get(0);
            left = n - searchList.get(searchList.size()-1) -1 + searchList.get(0)+1;
        } else if(result == searchList.size()-1){
            right =  n - searchList.get(searchList.size()-1) -1 + searchList.get(0)+1;
            left = searchList.get(result)-searchList.get(result-1);
        } else {
            right = searchList.get(result+1)-searchList.get(result);
            left = searchList.get(result)-searchList.get(result-1);
        }

        // System.out.println(" Left = "+ left + " right = " + right);
        return Math.min(left, right);
    }

    void populateMap(Map<Integer, List<Integer>> numIndicesMap, int[] nums){
        for(int i = 0; i<nums.length; i++){
            numIndicesMap.putIfAbsent(nums[i], new ArrayList<>());
            numIndicesMap.get(nums[i]).add(i);
        }
    }

}
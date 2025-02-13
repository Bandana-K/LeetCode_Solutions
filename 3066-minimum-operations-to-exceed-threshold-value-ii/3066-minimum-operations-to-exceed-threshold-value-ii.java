class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> minElements = new PriorityQueue<>();
        int cutOffNum = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < k)
                minElements.offer((long)num);
            else 
                cutOffNum = Math.min(num, cutOffNum);
        }
        minElements.offer((long)cutOffNum);
        // System.out.println("minElements = " +minElements);

        int result = 0;
        var min = minElements.poll();
        while(minElements.size() > 0 && min < k){
            var min2 = minElements.poll();
            var sum = 2 * min + min2;
            minElements.offer(sum);
            result++;
            min = minElements.poll();
            // System.out.println("min = " + min + " min2 = " + min2 + " sum = " + sum  + " result = "+ result);

        }

        return result;
    }
}
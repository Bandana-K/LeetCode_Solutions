class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length, max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(ranks[i] > max) max = ranks[i];
        }

        long low = 1, high = (long)max*cars*cars, result = 1;
        while(low<=high){
            long mid = low + (high-low)/2;
            if(canRepair(mid, ranks, cars)){
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }

    boolean canRepair(long totalTime, int[] ranks, int cars){
        for(int i = 0; i<ranks.length ; i++){
            var repairedCarSq = totalTime / ranks[i];
            int repairedCar = (int) Math.sqrt(repairedCarSq);
            cars -= repairedCar;
            if(cars <= 0) break;
        }
        return cars <= 0;
    }
}
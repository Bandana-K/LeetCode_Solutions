class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> mergedX = merge(rectangles, 0);
        List<int[]> mergedY = merge(rectangles, 1);

        if(mergedX.size() >=3 || mergedY.size() >=3) return true;
        return false;
    }

    List<int[]> merge(int[][] rectangles, int idx){
        Arrays.sort(rectangles, ((a,b) -> a[idx]-b[idx]));
        List<int[]> merged = new ArrayList<>();
        int start = rectangles[0][idx], end = rectangles[0][idx+2];
        for(int i = 1; i<rectangles.length; i++){
            if(rectangles[i][idx] < end){
                end = Math.max(end, rectangles[i][idx+2]);
            } else {
                merged.add(new int[]{start,end});
                start = rectangles[i][idx];
                end = rectangles[i][idx+2];
            }
        }
        
        merged.add(new int[]{start,end});
        return merged;
    }
}
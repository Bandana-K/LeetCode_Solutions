class Solution {

    class Pair{
        int id;
        int val;

        Pair(int id, int val){
            this.id = id;
            this.val = val;
        }
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length;
        ArrayList<Pair> resultList = new ArrayList<>();
        int i = 0, j =0;
        for(; i< n && j< m; ){
            if(nums1[i][0] < nums2[j][0]){
                Pair pair = new Pair(nums1[i][0], nums1[i][1]);
                resultList.add(pair);
                i++;
            } else if(nums1[i][0] > nums2[j][0]){
                Pair pair = new Pair(nums2[j][0], nums2[j][1]);
                resultList.add(pair);
                j++;
            } else {
                Pair pair = new Pair(nums2[j][0], nums1[i][1]+nums2[j][1]);
                resultList.add(pair);
                i++;
                j++;
            }

        }

        if( i < n){
            for(; i< n; i++){
                Pair pair = new Pair(nums1[i][0], nums1[i][1]);
                resultList.add(pair);
            }
        } else if (j < m){
            for(; j< m; j++){
                Pair pair = new Pair(nums2[j][0], nums2[j][1]);
                resultList.add(pair);
            }
        }

        int[][] result = new int[resultList.size()][2];
        for(int k = 0; k < resultList.size(); k++){
            Pair pair = resultList.get(k);
            result[k][0] = pair.id;
            result[k][1] = pair.val;        
        }
    
        return result;
    }
}
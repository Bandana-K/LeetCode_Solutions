//COPIED
class Solution {
    int len;
    int[] ans;
    boolean[] visited;
    public int[] constructDistancedSequence(int n) {
        if(n == 1) return new int[]{1};
        len = 2 * (n-1) + 1;
        ans = new int[len];
        visited = new boolean[n+1];
        placeNums(n, 0);
        return ans;
    }
    // place the best possible, biggest unplaced num at "idx"
    private boolean placeNums(int n, int idx){
        if(idx == len) return true;     // filled all nums
        for(var num=n; num>0; num--){
            if(visited[num]) continue;  // this num is already filled in ans
            var secIdx = num == 1 ? idx : idx+num;  // second index of curr num
            if(secIdx >= len || ans[idx] != 0 || ans[secIdx] != 0) continue;
            // place current num
            ans[idx] = ans[secIdx] = num;
            visited[num] = true;
            // place remaining nums
            int nextIdx = 0;
            while(nextIdx < len && ans[nextIdx] != 0) nextIdx++;
            if(placeNums(n, nextIdx)) return true;
            // rollback current num placement
            visited[num] = false;
            ans[idx] = ans[secIdx] = 0;
        }
        return false;
    }
}
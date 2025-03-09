// COPIED
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, ans = 0, same = 0;

        // count same adjacent colors in first k tiles
        for(var i=1; i<k; i++)
            if(colors[i] == colors[i-1]) same++;
        if(same == 0) ans++;

        // track same adjacent colors for each k window
        int lPrev = colors[0], rPrev = colors[k-1];
        for(int l=1, r=(l+k-1)%n; l < n; l++, r = (r+1)%n){
            if(colors[l] == lPrev) same--;
            if(colors[r] == rPrev) same++;
            if(same == 0) ans++;

            lPrev = colors[l];
            rPrev = colors[r];
        }

        return ans;
    }
}

// class Solution {
//     public int numberOfAlternatingGroups(int[] colors, int k) {
//         int n = colors.length, result = 0;
//         int[] copy = new int[2*n];
        
//         for(int i = 0; i<n; i++) copy[i] = colors[i];
//         for(int i = 0; i<n; i++) copy[n+i] = colors[i];

//         for(int i = 0; i< n; i++){
//             boolean altFound = true;
//             for(int j = i; j <k; j++){
//                 if(copy[j] == copy[j+1]){
//                     altFound = false;
//                     break;
//                 }
//             }
//             if(altFound) result++;
//         }
//         return result;
//     }
// }
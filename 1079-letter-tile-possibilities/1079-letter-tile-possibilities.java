class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return permute(0, arr);
    }
    public int permute(int start, char[] arr) {
        if(start == arr.length) return 0;
        int ans = 0;
        for(int i=start; i<arr.length; i++) {
            if(!isPermutedBefore(start, i-1, arr[i], arr)) {
                swap(start, i, arr);
                ans += 1+permute(start+1, arr);
                swap(start, i, arr);
            }
        }
        return ans;
    }
    public boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while(i<=j)
            if(arr[i++] == ch) return true;
        return false;
    }
    public void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


// class Solution {
//     public int numTilePossibilities(String tiles) {
//         var charArray = tiles.toCharArray();
//         Arrays.sort(charArray);
//         Set<String> result = new HashSet<>();
//         var currentSubSeq = new StringBuilder();
//         findSubsequence(0, charArray, result, currentSubSeq);
//         System.out.print(result);
//         return result.size();
//     }

//     void findSubsequence(int idx, char[] charArray, Set<String> result, StringBuilder currentSubSeq){
//         result.add(currentSubSeq.toString());
//         for(int i = 0; i < charArray.length; i++){
//             // if(i != idx && charArray[i] == charArray[i-1]) continue;
//             if(i == idx) continue;
//             currentSubSeq.append(charArray[i]);
//             findSubsequence(i+1, charArray, result, currentSubSeq);
//             currentSubSeq.deleteCharAt(currentSubSeq.length() - 1);
//         }
//     }
// }
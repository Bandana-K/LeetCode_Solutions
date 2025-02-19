class Solution {
    public String getHappyString(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder currentVal = new StringBuilder();
        formHappyString(n, k, 0, currentVal, ans);
        if(ans.size() < k) return "";
        return ans.get(k-1);
    }

    void formHappyString(int n, int k, int idx, StringBuilder currentVal,  List<String> ans){

        if(currentVal.length() == n ) {
            ans.add(currentVal.toString());
            return;
        }

        for( char curr = 'a'; curr <= 'c'; curr++){
            if(idx != 0){
                char prev = currentVal.charAt(currentVal.length()-1);
                if(curr == prev) continue;
            } 

            currentVal.append(curr);
            formHappyString(n, k-1, idx+1, currentVal, ans);
            currentVal.deleteCharAt(currentVal.length()-1);
        }
    }
}
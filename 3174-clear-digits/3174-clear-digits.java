class Solution {
    public String clearDigits(String s) {
        StringBuilder res = new StringBuilder("");
        for(char c : s.toCharArray()){
            var isDigit = Character.isDigit(c);
            if(isDigit) res.deleteCharAt(res.length()-1);
            else res.append(c);
        }
        return res.toString();
    }
}
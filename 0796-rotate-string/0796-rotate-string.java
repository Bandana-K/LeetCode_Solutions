class Solution {
    public boolean rotateString(String s, String goal) {

        if(goal.length() != s.length()) return false;

        StringBuilder sb = new StringBuilder(s);
        sb.append(s);

        return sb.toString().contains(goal);
        
    }
}
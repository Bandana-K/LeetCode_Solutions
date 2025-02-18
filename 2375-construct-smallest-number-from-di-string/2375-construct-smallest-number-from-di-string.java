class Solution {
    public String smallestNumber(String pattern) {
        var visited = new boolean[10];

        StringBuilder currentNum = new StringBuilder();
        var possible = canFormNumber(pattern, 0, visited, currentNum);
        if(possible) return currentNum.toString();
        return "";  // Unreachable code
    }

    private boolean canFormNumber(String pattern, int idx, boolean[] visited, StringBuilder currentNum){
        if(idx > pattern.length()) return true;

        for(int i = 1; i <= 9 ; i++){

            if(visited[i]) continue;

            if(idx == 0){
                currentNum.append((char) ('0' + i));
                visited[i] = true;
                var possible = canFormNumber(pattern, idx+1, visited, currentNum);
                if(possible) return true;
                visited[i] = false;
                currentNum.deleteCharAt(currentNum.length()-1);
            } else {
                char direction = pattern.charAt(idx-1);
                char prevChar = currentNum.charAt(currentNum.length()-1);
                if(direction == 'I' && (char) ('0' + i) <= prevChar) continue; 
                if(direction == 'D' && (char) ('0' + i) >= prevChar) continue; 

                currentNum.append((char) ('0' + i));
                visited[i] = true;
                var possible = canFormNumber(pattern, idx+1, visited, currentNum);
                if(possible) return true;
                visited[i] = false;
                currentNum.deleteCharAt(currentNum.length()-1);
            }
        }

        return false;
    }
}
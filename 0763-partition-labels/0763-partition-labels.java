class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();

        Map<Character, Integer> charFreq = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!charFreq.containsKey(s.charAt(i)))
                charFreq.put(s.charAt(i), i);
        }


        List<Integer> result = new ArrayList<>();
        for(int i = n-1; i>=0;){
            int idx = charFreq.get(s.charAt(i));
            int j = i-1;
            while(j >= idx){
                idx = Math.min(idx, charFreq.get(s.charAt(j)));
                j--;
            }
            result.add(i-j);
            i = j;
        }
        
        Collections.reverse(result);
        return result;
    }
}
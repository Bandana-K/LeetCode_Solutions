class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();

        Map<Character, List<Integer>> charFreq = new HashMap<>();
        for(int i=0; i<n; i++){
            charFreq.putIfAbsent(s.charAt(i), new ArrayList<>());
            charFreq.get(s.charAt(i)).add(i);
        }


        List<Integer> rev = new ArrayList<>();
        for(int i = n-1; i>=0;){
            int idx = charFreq.get(s.charAt(i)).get(0);
            int j = i-1;
            while(j >= idx){
                idx = Math.min(idx, charFreq.get(s.charAt(j)).get(0));
                j--;
            }
            rev.add(i-j);
            i = j;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = rev.size()-1; i>=0; i--)
            result.add(rev.get(i));
            
        return result;
    }
}
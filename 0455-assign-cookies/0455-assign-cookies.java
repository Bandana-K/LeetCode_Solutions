class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        
        int l=0, r=0;
        while(l < s.length && r < g.length){
            if(s[l] >= g[r]){   //If size of cookie is >= greed of kid, then increase the right pointer to next kid 
                r++;
            }
            l++;//Left pointer is always moved, either the cookie satisfies one kid or can't satisfy any other kid aswell, coz the greed is sorted.
        }

        return r; //The number of content kid can be simply fetched from greed array traversed in while loop
    }
}
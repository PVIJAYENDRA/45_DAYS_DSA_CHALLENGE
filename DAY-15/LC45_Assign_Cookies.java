import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = s.length;
        int n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0;
        while( l < m && r < n){
            if( g[r] <= s[l]){
                r = r + 1;
            }
            l = l + 1;
        }

        return r;
    }
}
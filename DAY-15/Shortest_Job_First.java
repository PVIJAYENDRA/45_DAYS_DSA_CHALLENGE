import java.util.Arrays;

class Solution {
    static int solve(int bt[]) {
        
        
        int n =bt.length;
        Arrays.sort(bt);
        
        int t = 0, wtTime = 0;
        
        for(int i = 0 ; i < n ; i++){
            
            wtTime += t;
            t += bt[i];
        }
        
        return wtTime / n;
    }
}

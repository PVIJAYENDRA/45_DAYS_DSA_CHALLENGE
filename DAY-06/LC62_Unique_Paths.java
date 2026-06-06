class Solution {
    public int uniquePaths(int m, int n) {
        return func(m, n);
    }
    
    public int func(int m, int n) {
        
        int[] prev = new int[n];    
        for (int i = 0; i < m; i++) {

            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                // Base case
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
               
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;
                
                temp[j] = up + left;
            }           
            prev = temp;
        }
        return prev[n - 1];
    }

    
    
}
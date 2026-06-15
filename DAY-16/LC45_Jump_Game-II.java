class Solution {
    public int jump(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int jumps = 0;
        while( r < n-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest , (i + arr[i]));
            }
            jumps = jumps + 1;
            l = r + 1;
            r = farthest;
            
        }

        return jumps;
    }
}
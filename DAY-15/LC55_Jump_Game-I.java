class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        int maxIndex = 0;
        for(int i = 0 ; i < n ; i++){
            if( i > maxIndex) return false;
            maxIndex = Math.max(maxIndex , (i + arr[i]));

            if(  maxIndex >= n - 1) return true;
        }

        return true;
    }
}
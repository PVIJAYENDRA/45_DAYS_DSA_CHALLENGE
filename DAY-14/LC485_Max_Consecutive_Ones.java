class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCon = 0;
        for( int x : nums){
            if( x == 1){
                count++;
                maxCon = Math.max( count , maxCon);
            }
            else{
                count = 0;
            }
        }

        return maxCon;
        
    }
}
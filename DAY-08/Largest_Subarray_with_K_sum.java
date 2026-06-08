

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if( sum == k){
                maxLength = Math.max(maxLength, i+1);
            }
            long remain = sum - k;
            if( map.containsKey(remain)){
                maxLength= Math.max( maxLength , i - map.get(remain));
            }
            if(!map.containsKey(sum)){
                map.put((long)sum , i);
            }
        }
        
        return maxLength;
    }
}

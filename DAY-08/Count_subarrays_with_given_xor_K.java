class Solution {
    public long subarrayXor(int arr[], int k) {

        int xr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , 1);
        long count = 0;
        for(int n : arr){
            xr = xr ^ n;
            int x = xr ^ k;
            if(map.containsKey(x)) count += map.get(x);
            map.put(xr , map.getOrDefault(xr,0)+1);
            
        }
        
        return count;
    }
}
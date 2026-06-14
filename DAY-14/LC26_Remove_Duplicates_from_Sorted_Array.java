class Solution {
    public int removeDuplicates(int[] arr) {
        int N = arr.length;
        int i = 0;
        for(int j = i + 1; j < N ; j++){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }

        return i+1;
    }
}
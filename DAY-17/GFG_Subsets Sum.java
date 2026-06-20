class Solution {
   
    public void findSums(int index, int currentSum, int[] arr, ArrayList<Integer> sums) {
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        // Include current element
        findSums(index + 1, currentSum + arr[index], arr, sums);

        // Exclude current element
        findSums(index + 1, currentSum, arr, sums);
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> sums = new ArrayList<>();
        findSums(0, 0, arr, sums);
        Collections.sort(sums);
        return sums;
    }
}
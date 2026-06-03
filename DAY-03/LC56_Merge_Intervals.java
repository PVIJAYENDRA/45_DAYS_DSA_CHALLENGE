class Solution {
    public  static int[][] merge(int[][] arr) {
        int n = arr.length;
        if (n <= 1) return arr;

        // 1. Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] interval : arr) {
            // 2. If list is empty or current start > last merged end, no overlap
            if (ans.isEmpty() || interval[0] > ans.get(ans.size() - 1)[1]) {
                ans.add(interval);
            } 
            // 3. Otherwise, there is an overlap, so merge by updating the end
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
import java.util.*;

class Solution {
    static class Job {
        int id;
        int dead;
        int profit;
        
        Job(int id, int dead, int profit) {
            this.id = id;
            this.dead = dead;
            this.profit = profit;
        }
    }

    // DSU Find function with path compression
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] arr = new Job[n];
        
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(i + 1, deadline[i], profit[i]);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        
        
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        
       
        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++) {
            parent[i] = i;
        }
        
        int countJobs = 0;
        int jobProfit = 0;
        
        for (int i = 0; i < n; i++) {
            
            int availableSlot = find(parent, arr[i].dead);
            
            
            if (availableSlot > 0) {
                countJobs++;
                jobProfit += arr[i].profit;
                
                
                parent[availableSlot] = find(parent, availableSlot - 1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(jobProfit);
        return result;
    }
}

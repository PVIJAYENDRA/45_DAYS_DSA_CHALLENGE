class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int ele1 = 0, ele2 = 0;

        for(int num : nums){
            if( count1 == 0 && num != ele2){
                ele1 = num;
                count1 = 1;
            }
            else if( count2 == 0 && num != ele1){
                ele2 = num;
                count2 = 1;
            }
            else if( num == ele1){
                count1++;
            }
            else if( num == ele2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> result = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        
        for(int num : nums){
            if( num == ele1) count1++;
            else if( num == ele2) count2++;
        }

        if( count1 > ( n / 3)) result.add(ele1);
        if( count2 > ( n / 3)) result.add(ele2);

        return result;
        
    }
}
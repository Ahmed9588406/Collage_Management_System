package Model;

public class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean hasincreasing = false;
        boolean hasdecreasing = false;
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            if(nums[i]<nums[j]){
                hasincreasing = true;
            } else if (nums[i] > nums[j]) {
                hasdecreasing = true;
            }

        }
        if(hasincreasing && hasdecreasing){
            return false;
        }else{
            return true;
        }

    }
}

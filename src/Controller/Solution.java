package Controller;

import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] != val){
                arr.add(nums[i]);
            }
        }
        Collections.sort(arr);
        int k = arr.size();
        return k;
    }
}

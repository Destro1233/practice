package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSums1 {

	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		TwoSums1 obj = new TwoSums1();
		int[] nums2 = obj.twoSum(nums, target);
		System.out.println(nums2[0]+" "+nums2[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			al.add(nums[i]);
		}
		int solution[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			al.remove(0);
			
			if (al.contains(target - nums[i])) {
				solution[0] = i;
				solution[1] = (al.indexOf(target - nums[i])+i+1);
				//System.out.println(al.indexOf(target - nums[i])+i+1);
				break;
			}
		}
		return solution;
	}

}

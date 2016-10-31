package leetcode;

/*You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KPairsSmallestSum {

	public static void main(String[] args) {
		KPairsSmallestSum obj = new KPairsSmallestSum();
		// int[] nums1 = {1,7,11}, nums2 = {2,4,6};
		// int k = 3;
		// int[] nums1 = {1,1,2}, nums2 = {1,2,3};
		// int k = 2;
		int[] nums1 = { 1, 2 }, nums2 = { 3 };
		int k = 3;
		PriorityQueue<int[]> queue = obj.kSmallestPairs(nums1, nums2, k);
		while ((queue.size() != 0) && k > 0) {
			int[] output = (queue.remove());
			System.out.println(output[0] + "," + output[1]);
			k--;
		}

	}

	public PriorityQueue<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Comparator<int[]> comparator = new intAddComparator();
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(10, comparator);
		int len1 = (nums1.length < k ? nums1.length : k);
		int len2 = (nums2.length < k ? nums2.length : k);
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				queue.add(new int[] { nums1[i], nums2[j] });
			}
		}
		return queue;
	}
}

class intAddComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] x, int[] y) {
		if ((x[0] + x[1]) < y[0] + y[1]) {
			return -1;
		}
		if ((x[0] + x[1]) > y[0] + y[1]) {
			return 1;
		}
		return 0;
	}
}
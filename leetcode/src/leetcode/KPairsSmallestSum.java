package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KPairsSmallestSum {

	public static void main(String[] args) {
		KPairsSmallestSum obj = new KPairsSmallestSum();
//		int[] nums1 = {1,7,11}, nums2 = {2,4,6};
//		int k = 3;
//		int[] nums1 = {1,1,2}, nums2 = {1,2,3};
//		int k = 2;
		int[] nums1 = {1,2}, nums2 = {3};
		int k = 3;
		PriorityQueue<int[]> queue = obj.kSmallestPairs(nums1, nums2, k);
		while ((queue.size() != 0)&&k>0)
        {			
			int[] output = (queue.remove());
            System.out.println(output[0]+","+output[1]);
            k--;
        }

	}

	public PriorityQueue<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Comparator<int[]> comparator = new intAddComparator();
        PriorityQueue<int[]> queue = 
            new PriorityQueue<int[]>(10, comparator);
            int len1 = (nums1.length<k?nums1.length:k);
            int len2 = (nums2.length<k?nums2.length:k);
            for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					queue.add(new int[]{nums1[i],nums2[j]});
				}
			}
		return queue;
	}
}
class intAddComparator implements Comparator<int[]>
{
    @Override
    public int compare(int[] x, int[] y)
    {
        if ((x[0]+x[1]) < y[0]+y[1])
        {
            return -1;
        }
        if ((x[0]+x[1]) > y[0]+y[1])
        {
            return 1;
        }
        return 0;
    }
}
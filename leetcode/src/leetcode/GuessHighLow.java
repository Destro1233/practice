package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class GuessHighLow {
	int total = 0;

	public static void main(String[] args) {
		int n = 10;
		GuessHighLow obj = new GuessHighLow();
		System.out.println(obj.getMoneyAmount(n));
	}

	public int getMoneyAmount(int n) {
          return(getAmount(1,n));
      }

	public int getAmount(int left, int right) {
		int mid = 0;
		if (left == right|| Math.abs(left-right)==1) {
			return left;
		} else {
			mid = (left + (right - left) / 2);
			return (mid + getAmount(mid+1, right));
		}
		
	}
}

package interview;

import java.util.Scanner;

public class NisargTwitter {

	public static void main(String[] args) {
		NisargTwitter obj = new NisargTwitter();
		System.out.println(obj.numberCalc());
		// System.out.println(maxLenght());
	}

	public StringBuffer numberCalc() {// String s
		String s = "(123)-123-1234";
		String first = "";
		s.trim();
		StringBuffer output = new StringBuffer();
		if (s.startsWith("+")) {
			output.append("+");
			first = s.substring(1, s.length() - 4);
		}
		// System.out.println(output);
		String last = s.substring(s.length() - 4, s.length());
		// System.out.println(last);
		if (first.equals("")) {
			first = s.substring(0, s.length() - 4);
		}
		first = first.replace("(", "").replace(")", "").replace("-", "").replaceAll(" ", "");
		int mod = first.length() % 3;
		int div = first.length() / 3;
		// System.out.println(div+" "+mod);
		if (mod > 0) {
			while (mod > 0) {
				output.append("*");
				mod--;
			}
			output.append("-");
		}
		while (div > 0) {
			output.append("***-");
			div--;
		}
		output.append(last);
		return output;

	}

	static int maxLenght() {// int[] a, int k
		int[] a = { 74, 659, 931, 273, 545, 879, 924, 710, 441, 166, 493, 43, 988, 504, 328, 730, 841, 613, 304, 170,
				710, 158, 561, 934, 100, 279, 817, 336, 98, 827, 513, 268, 811, 634, 980, 150, 580, 822, 968, 673, 394,
				337, 486, 746, 229, 92, 195, 358, 2, 154, 709, 945, 669, 491, 125, 197, 531, 904, 723, 667, 550 };
		int k = 22337;
		// int[] a = {3,1,2,1};
		// int k = 4;
		int maxWords = 0;
		int currentWords = 0;
		int prevK = 0;
		for (int i = 0; i < a.length; i++) {
			currentWords = 0;
			if ((a[i]) < k) {
				prevK = a[i];
				currentWords = 1;
				if (a[i] == k) {
					continue;
				}
			} else {
				continue;
			}
			for (int j = i + 1; j < a.length; j++) {
				if (i != j && ((prevK + a[j]) <= k)) {
					currentWords++;
					prevK += a[j];
				} else {
					break;
				}
			}
			if (currentWords > maxWords)
				maxWords = currentWords;
		}
		return maxWords;
	}
}

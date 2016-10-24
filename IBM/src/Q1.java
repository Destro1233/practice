/*
 * You will be given a positive integer N, and two single-digit integers p and q, where p != q and both are 
 * greater than 1. You must output all of the integers from 1 to N inclusive,separated by a comma ','.
 * However, any integer divisible by p or q should be replaced by the text OUT and any integer whose decimal 
 * representation contains digit p or q should be replaced by the text THINK. 
 * Integers for which both of the preceding statements are true should instead be replaced by the text 
 * OUTTHINK.
 */
public class Q1 {

	public static void main(String[] args) {
		String ip = "20 3 4";
		String[] s = ip.split(" ");

		// System.out.println(s);
		int N = Integer.parseInt(s[0]);
		int p = Integer.parseInt(s[1]);
		int q = Integer.parseInt(s[2]);
		String[] res = new String[N];
		for (int i = 1; i <= N; i++) {
			String result = "";
			if (i % p == 0 || i % q == 0) {
				if (String.valueOf(i).contains(s[1]) || String.valueOf(i).contains(s[2]))
					// result += "OUTTHINK";
					res[i - 1] = "OUTHINK";
				else
					res[i - 1] = "OUT";

			} else if (String.valueOf(i).contains(s[1]) || String.valueOf(i).contains(s[2])) {
				res[i - 1] = "OUTHINK";
			} else
				res[i - 1] = String.valueOf(i);
			// System.out.println(result);
		}
		System.out.print(String.join(",", res));

	}

}

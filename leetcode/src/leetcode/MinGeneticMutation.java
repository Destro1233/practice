package leetcode;

/*A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinGeneticMutation {

	public static void main(String[] args) {
		String start = "AAAAACCC";
		String end = "ACAAACCC";
		String[] bank = { "ACAAACCC", "AAAAAGCC", "ACAAAGCC", "ACAAACCC" };
		MinGeneticMutation obj = new MinGeneticMutation();
		System.out.println(obj.minMutation(start, end, bank));
		System.out.println(obj.minMutation1(start, end, bank));

	}

	public int minMutation1(String start, String end, String[] bank) {// Working

		HashSet<String> bankSet = new HashSet();
		for (String s : bank) {
			bankSet.add(s);
		}
		Queue<String> queue = new LinkedList();
		HashSet<String> set = new HashSet();
		char[] genes = { 'A', 'C', 'G', 'T' };

		set.add(start);
		queue.offer(start);

		int length = 0;// don't consider the start as one of the steps

		while (!queue.isEmpty()) {
			length++;
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String word = queue.poll();
				for (int i = 0; i < word.length(); i++) {
					for (char c : genes) {
						StringBuilder sb = new StringBuilder(word);
						sb.setCharAt(i, c);
						String temp = sb.toString();

						if (temp.equals(end) && bankSet.contains(temp)) {
							return length;
						}

						if (bankSet.contains(temp) && !set.contains(temp)) { // avoid
																				// duplicated
																				// path
							set.add(temp);
							queue.offer(temp);
						}
					}
				}
			}

		}

		return -1;
	}

	public int minMutation(String start, String end, String[] bank) {// Memory
																		// exceeds
																		// set
																		// limitation
		Set<String> set = new HashSet<String>();
		char[] chars = { 'A', 'C', 'G', 'T' };
		for (String b : bank)
			set.add(b);

		if (!set.contains(end))
			return -1;
		Queue<Container> q = new LinkedList<Container>();
		q.add(new Container(start, 0));

		while (!q.isEmpty()) {
			Container con = q.remove();
			char[] str = con.word.toCharArray();

			for (int i = 0; i < str.length; i++) {
				char tmpChar = str[i];
				for (char c : chars) {
					if (c == str[i])
						continue;
					str[i] = c;
					String tmpStr = new String(str);
					if (tmpStr.equals(end))
						return con.steps + 1;
					if (set.contains(tmpStr))
						q.add(new Container(tmpStr, con.steps + 1));

				}
				str[i] = tmpChar;
			}
		}
		return -1;
	}
}

class Container {
	String word;
	int steps;

	public Container(String word, int steps) {
		this.word = word;
		this.steps = steps;
	}
}

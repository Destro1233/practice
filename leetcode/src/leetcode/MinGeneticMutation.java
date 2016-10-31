package leetcode;

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

	public int minMutation1(String start, String end, String[] bank) {//Working

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

	public int minMutation(String start, String end, String[] bank) {//Memory exceeds set limitation
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

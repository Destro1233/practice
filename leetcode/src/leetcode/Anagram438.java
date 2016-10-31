package leetcode;

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Anagram438 {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// String s = "abab";
		// String p = "ab";
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> lis = new ArrayList<Integer>();
		Anagram438 obj = new Anagram438();
		lis = obj.findAnagrams(s, p);
		Iterator<Integer> itr = lis.iterator();
		int subLocation = p.length();
		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println(s.subSequence(i, i + subLocation));
		}

	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (p.length() > s.length())
			return res;
		char[] sStr = s.toCharArray();
		int[] map = new int[26];
		for (char ch : p.toCharArray())
			map[ch - 'a']++;
		int n = s.length(), m = p.length();
		;
		int j = 0;
		for (j = 0; j < m - 1; j++)
			map[sStr[j] - 'a']--;
		for (int i = 0; j < n; i++, j++) {
			map[sStr[j] - 'a']--;
			if (check(map))
				res.add(i);
			map[sStr[i] - 'a']++;
		}
		return res;
	}

	public boolean check(int[] map) {
		for (int n : map)
			if (n > 0)
				return false;
		return true;
	}

}

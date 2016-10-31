package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Anagram438 {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		//String s = "abab";
		//String p = "ab";
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> lis = new ArrayList<Integer>();
		Anagram438 obj = new Anagram438();
		lis = obj.findAnagrams(s,p);
		Iterator<Integer> itr = lis.iterator();
		int subLocation = p.length();
		while(itr.hasNext())
		{
			int i = itr.next();
			System.out.println(s.subSequence(i, i+subLocation));
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

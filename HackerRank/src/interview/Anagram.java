package interview;
/* Anagram is where a string has same number and similar characters.
 * We have to find the number of digits should be removed before both
 * the strings satisfy anagram.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Anagram {
	public static int numberNeeded(String first, String second) {
		int solution = 0;
		char[] a = first.toCharArray();
		char[] b = second.toCharArray();
		Map<Character, Integer> m1 = new HashMap<Character, Integer>();
		Map<Character, Integer> m2 = new HashMap<Character, Integer>();
		int l1 = first.length(), l2 = second.length();
		int minLength = (l1 < l2 ? l1 : l2);
		int i = 0;
		while (i < l1) {
			if (m1.containsKey(a[i])) {
				m1.put(a[i], m1.get(a[i]) + 1);
			} else {
				m1.put(a[i], 1);
			}
			i++;
		}
		i=0;
		while (i < l2) {
			if (m2.containsKey(b[i])) {
				m2.put(b[i], m2.get(b[i]) + 1);
			} else {
				m2.put(b[i], 1);
			}
			i++;
		}
		
		System.out.println(m1.entrySet());
		System.out.println(m2.entrySet());
		for(char y = 'a'; y <= 'z'; y++){
		    solution += Math.abs(m1.getOrDefault(y, 0) - m2.getOrDefault(y, 0));
		}
		//System.out.println();
		return solution;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
}

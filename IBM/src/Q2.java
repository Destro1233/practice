/**
 * Programming Challenge Description:

You will be given a sequence of passages, and must filter out any passage whose text (sequence of whitespace-delimited words) is wholly contained as a sub-passage of one or more of the other passages.
When comparing for containment, certain rules must be followed:
The case of alphabetic characters should be ignored
Leading and trailing whitespace should be ignored
Any other block of contiguous whitespace should be treated as a single space
non-alphanumeric character should be ignored, white space should be retained
Duplicates must also be filtered - if two passages are considered equal with respect to the comparison rules listed above, only the shortest should be retained.
If they are also the same length, the earlier one in the input sequence should be kept. The retained passages should be output in their original form (identical to the input passage),
and in the same order.
Input:

For each test case a single line comprising the passages (strings) to be processed, delimited by | characters. The | characters are not considered part of any passage.

Output:

A single line of filtered passages in the same |-delimited format.

Test 1

Test Input Download Test InputIBM cognitive computing|IBM "cognitive" computing is a revolution| ibm cognitive  computing|'IBM Cognitive Computing' is a revolution?

Expected Output Download Test OutputIBM "cognitive" computing is a revolution

Test 2

Test Input Download Test Input"Computer Science Department"|Computer-Science-Department|the "computer science department"

Expected Output Download Test OutputComputer-Science-Department|the "computer science department"
 */

/**
 * @author Saurabh
 *
 */
public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive  computing|'IBM Cognitive Computing' is a revolution?";
		// Output-IBM "cognitive" computing is a revolution
		// String s = "\"Computer Science
		// Department\"|Computer-Science-Department|the \"computer science
		// department\""; //Input
		// Output-Computer-Science-Department|the "computer science department"
		String input[] = s.split("[|]");
		int len = input.length;
		String processedInput[] = new String[len];
		for (int i = 0; i < len; i++) {
			processedInput[i] = (input[i].replaceAll("[^\\p{Alnum}\\s]", "")).trim().replaceAll("( )+", " ")
					.toLowerCase();
			// System.out.println(processedInput[i]);
		}
		int[] b = new int[len];// -1 is untouched, 1 is true, 0 is false
		for (int i = 0; i < len; i++) {
			b[i] = -1;
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((processedInput[i].equals(processedInput[j]))) {
					int ilen = input[i].length(), jlen = input[j].length();
					if (ilen == jlen) {
						if (b[i] == -1) {
							b[i] = 1;
						}
						b[j] = 0;
					}
					if (ilen < jlen) {
						if (b[i] == -1) {
							b[i] = 1;
						}
						b[j] = 0;
					} else {
						if (b[j] == -1) {
							b[j] = 1;
						}
						b[i] = 0;
					}
				} else if (processedInput[i].contains(processedInput[j])) {
					if (b[i] == -1) {
						b[i] = 1;
					}
					b[j] = 0;
				} else if (processedInput[j].contains(processedInput[i])) {
					if (b[j] == -1) {
						b[j] = 1;
					}
					b[i] = 0;
				} else {
					b[i] = 1;
					b[j] = 1;
				}
			}
		}
		String answer = new String("");
		for (int i = 0; i < len; i++) {
			if (b[i] == 1) {
				if (!answer.equals("")) {
					answer += ("|");
				}
				answer += (input[i]);
			}
		}
		System.out.println(answer);
		// System.out.println("a".contains("ab"));
	}
}

/**
 * 
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
		//Output-IBM "cognitive" computing is a revolution
		//String s = "\"Computer Science Department\"|Computer-Science-Department|the \"computer science department\""; //Input
		//Output-Computer-Science-Department|the "computer science department"
		String input[] = s.split("[|]");
		int len = input.length;
		String processedInput[] = new String[len];
		for (int i = 0; i < len; i++) {
			processedInput[i] = (input[i].replaceAll("[^\\p{Alnum}\\s]", " ")).trim().replaceAll("( )+", " ")
					.toLowerCase();
			// System.out.println(processedInput[i]);
		}
		boolean[] b = new boolean[len];
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
					if ((processedInput[i].equals(processedInput[j]))) {
						int ilen = input[i].length(), jlen =input[j].length();
						if(ilen==jlen){
							b[i] = true;
							b[j] = false;
						}
						if (ilen < jlen) {
							b[i] = true;
							b[j] = false;
						} else {
							b[j] = true;
							b[i] = false;
						}
					} else if (processedInput[i].contains(processedInput[j])) {
						b[j] = false;
						//b[i] = true;
					} else if(processedInput[j].contains(processedInput[i])) {
						b[i] = false;
						//b[j] = true;
					} else {
						b[i] = true;
					}
			}
		}
		String answer = new String("");
		for (int i = 0; i < len; i++) {
			if (b[i] == true) {
				if (!answer.equals("")) {
					answer += ("|");
				}
				answer += (input[i]);
			}
		}
		System.out.println(answer);
		//System.out.println("a".contains("ab"));
	}
}

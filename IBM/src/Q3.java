import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*IBM desires to develop a service to help a client quickly find a manager who can resolve the conflict between two employees. When there is a conflict between two employees, the closest common manager should help resolve the conflict. The developers plan to test the service by providing an example reporting hierarchy to enable the identification of the closest common manager for two employees. Your goal is to develop an algorithm for IBM to efficiently perform this task. To keep things simple, they just use a single relationship "isManagerOf" between any two employees. For example, consider a reporting structure represented as a set of triples:

Tom isManagerOf Mary

Mary isManagerOf Bob

Mary isManagerOf Sam

Bob isManagerOf John

Sam isManagerOf Pete

Sam isManagerOf Katie

The manager who should resolve the conflict between Bob and Mary is Tom(Mary's manager). The manager who should resolve the conflict between Pete and Katie is Sam(both employees' manager). The manager who should resolve the conflict between Bob and Pete is Mary(Bob's manager and Pete's manager's manager). Assumptions:

There will be at least one isManagerOf relationship.

There can be a maximum of 15 team member to a single manager

No cross management would exist i.e., a person can have only one manager

There can be a maximum of 100 levels of manager relationships in the corporation

Input:

R1,R2,R3,R4...Rn,Person1,Person2 R1...Rn - A comma separated list of "isManagerOf" relationships. Each relationship being represented by an arrow "Manager->Person". Person1,Person2 - The name of the two employee that have conflict

Output:

The name of the manager who can resolve the conflict Note: Please be prepared to provide a video follow-up response to describe your approach to this exercise.

Test 1

Test Input Download Test InputFrank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob,Katie

Expected Output Download Test OutputMary

Test 2

Test Input Download Test InputSam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John,Sam,John

Expected Output Download Test OutputMary*/
public class Q3 {

	public static void main(String[] args) {
		//String s = "Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,Bob,Katie";
		//Output - Mary
		String s = "Sam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John,Sam,John";
		String[] input = s.split(",");
		int len = input.length;
		Map<String, String> m = new HashMap<String, String>();
		for (int i = 0; i < len - 2; i++) {
			String s1[] = input[i].split("->");
			m.put(s1[1], s1[0]);
		}
		String q1 = input[len - 2];
		String q2 = input[len - 1];
		System.out.println(m.toString() + "\n" + q1 + "\n" + q2);
		ArrayList<String> q1list = new ArrayList<>();
		q1list.add(q1);
		String q1parent = q1;
		while (m.containsKey(q1parent)) {
			String temp = m.get(q1parent);
			q1list.add(temp);
			q1parent = temp;
		}
		ArrayList<String> q2list = new ArrayList<>();
		q2list.add(q2);
		String q2parent = q2;
		while (m.containsKey(q2parent)) {
			String temp = m.get(q2parent);
			q2list.add(temp);
			q2parent = temp;
		}
		System.out.println(q1list.toString() + "\n" + q2list.toString());
		
		int q1pointer = q1list.size()-1, q2pointer = q2list.size()-1;
		System.out.println(q1pointer+1 + " " + (q2pointer+1));
		// int j=(q1size<=q2size?q1size:q2size);
		System.out.println("===========================================");
		while (q1list.get(q1pointer).equals(q2list.get(q2pointer))) {
			//System.out.println(q1list.get(q1pointer) + " " + q2list.get(q2pointer));
			--q1pointer;
			--q2pointer;
		}
		System.out.println("Manager is :"+q1list.get(q1pointer+1));
	}
}

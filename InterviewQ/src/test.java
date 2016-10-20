import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class test {
	public static void main(String args[]) {
		ArrayList<String[]> ar = new ArrayList<String[]>();
		String fileName = "log.txt";
		String line = null;
		Pattern pattern = Pattern.compile(".*\\\"(.*)\\\".*");
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				String IP = null;
				if (line.contains(" ")) {
					IP = line.substring(0, line.indexOf(" "));
					Matcher matcher = pattern.matcher(line);
					String requestURL = null;
					if (matcher.find()) {
						requestURL = (matcher.group(1));
					}
					String[] s1 = { IP, requestURL };

					if (line.contains(" 200 ")) {
						ar.add(s1);
					}
				}
			}

			bufferedReader.close();
			JSONObject obj = new JSONObject();
			System.out.println("Sample Output:\n Access Entries:");
			Iterator<String[]> itr = ar.iterator();
			while (itr.hasNext()) {
				String[] s2 = (String[]) itr.next();
				System.out.println("{\nIP: " + s2[0]);
				obj.put("IP", s2[0]);
				System.out.println("Request URL: " + s2[1] + "\n}\n");
				obj.put("Request URL", s2[1]);
			}
			System.out.println("}\n}");
			FileWriter file1 = new FileWriter("file1.txt");
			file1.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
			file1.flush();
			file1.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}finally{
			//file1.flush();
			//file1.close();
		}

	}
}
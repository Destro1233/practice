
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CSVReader {

	public static void main(String[] args) {

		String csvFile = "GeoIPCountryWhois.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			String str = "insert into geoipcountry values(?,?)";
			PreparedStatement stmt = null;
			while ((line = br.readLine()) != null) {
				String[] country = line.split(cvsSplitBy);
				System.out.println("Country [code= " + country[2] + " , name=" + country[5] + "]");
				stmt = con.prepareStatement(str);
				stmt.setInt(1, Integer.valueOf(country[2].replaceAll("\"", "")));
				stmt.setString(2, country[5].replaceAll("\"", ""));
				stmt.executeUpdate(str);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
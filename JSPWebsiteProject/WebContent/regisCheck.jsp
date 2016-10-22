<%@ page language="java" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body background="images/regisCheck-background.jpg" style="color: white;">
<header>
		<%@include file="html/header.html"%>
	</header>
	<%!private Boolean register(String firstname, String lastname, String username, String password, String email,
			String activities) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			String str = "insert into kohinoorlogin values (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(str);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.setString(5, email);
			stmt.setString(6, activities);
			int count = stmt.executeUpdate();
			if (count > 0) {
				System.out.println("Insertion succesful");
				return true;
			} else {
				System.out.println("Insertion failed");
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Insertion failed");
			return (false);
		} finally {
			if (rset != null)
				rset.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
	}%>

	<%
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String activities = request.getParameter("activities");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Values given\nusername:" + username + "\npassword: " + password + "\nname :" + firstname
				+ " " + lastname + "\nemail: " + email + "\nactivities: " + activities);
		String title = null;
		if (register(firstname,lastname,username, password, email, activities)) {
			title = "<h2 style='padding-top: 10%;'>You have registered successfully :" + firstname + " " + lastname +"</h2>";
			title += "<br/>Please click here to <a href='signin.jsp'>login</a>";
			session.setAttribute("username", username);
		} else {
			title = "<div style='padding-top: 10%;'>There was some error with the values. Please <a href='registration.jsp'>retry</a> again.</div>";
		}
		out.println("<h2 >" + title + "</h2>");
	%>
<footer class="footer"> <%@include file="html/footer.html"%> </footer>
</body>
</html>


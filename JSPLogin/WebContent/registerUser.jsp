<%@ page language="java" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<%!private Boolean register(String username, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			String str = "insert into login values (?,?)";
			stmt = conn.prepareStatement(str);
			stmt.setString(1, username);
			stmt.setString(2, password);
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Values given :" + username + " " + password);
		String title = null;
		if (register(username, password)) {
			title = "You have registered successfully :" + username;
			title += "<br/>Please <a href='login.html'>click</a> here to login";
			session.setAttribute("username", username);
		} else {
			title = "There was some error with the values. Please <a href='registration.html'>retry</a> again.";
		}
		out.println("<h2>" + title + "</h2>");
	%>
</body>
</html>

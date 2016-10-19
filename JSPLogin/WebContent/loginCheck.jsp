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
	<%!private Boolean checkUser(String username, String password) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
			stmt = conn.createStatement();
			// dynamic query
			rset = stmt.executeQuery("SELECT password FROM login where username = '" + username + "'");
			while (rset.next()) {
				String pass = rset.getString(1);
				System.out.println("Password needed :"+pass);
				return password.equals(pass);
			}

			return false;

		} catch (SQLException e) {
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
		System.out.println("Username & Password provided: " + username + "-" + password);
		if (checkUser(username, password)) {
			String title = "Welcome to website " + username;
			session.setAttribute("username", username);
			out.println("<h2>" + title + "</h2>");
		} else {
	%>
	<c:redirect url="/invalidUser.html" />
	<%
		}
	%>

</body>
</html>
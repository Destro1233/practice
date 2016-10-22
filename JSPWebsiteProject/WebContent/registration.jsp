<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" type="text/css" href="css/home.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<style>
#backgroundImage{z-index: 1;}

#backgroundImage:before {
   content: "";
   position: absolute;
   z-index: -1;
   top: 0;
   bottom: 0;
   left: 0;
   right: 0;
   background-image: url(images/regis-background.jpg);
    background-repeat: no-repeat;
    background-size: 100%;
    opacity: 0.6;
    filter:alpha(opacity=40);
    height:100%;
    width:100%;
 }
div {
	padding-top: 10%;
	text-align: center;
	width: 450px;
	color: black;
	border: 2px blue;
	border-radius: 5px;
	margin: auto;
	font-family: 'Open Sans', sans-serif;
}

tr {
	padding: 4px;
	text-align: left;
	font-size: 20px;
	width: auto;
}

.button {
	padding: 10px 15px;
	font-size: 18px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: #009999;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.button:hover {
	background-color: #006666
}

.button:active {
	background-color: #006666;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}
</style>
</head>
<body id="backgroundImage">
	<header>
		<%@include file="html/header.html"%>
	</header>
	<div>
		<form method="post" action="regisCheck.jsp">
			<table>
				<tr>
					<th colspan="2" style="font-size: 28px;">Registration Form</th>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Activities</td>
					<td><textarea rows="4" cols="30" name="activities"></textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input class="button" type="submit"
						value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
	<footer class="footer">
		<%@include file="html/footer.html"%>
	</footer>
</body>
</html>


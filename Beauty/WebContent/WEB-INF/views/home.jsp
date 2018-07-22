<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Begin your choose</title>
</head>
<body>
	<center>
		<h2>
			The Most Beautiful girl is (with the highest score):
		</h2>
		<img src = "file://${mostBeautiful}" height="400" width="300"/>
		
		<h4>
			Choose how many girls you want see:
		</h4>
		<form action="/Beauty/getList">
			<select name="num">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<input type="submit" value="begin">
		</form>
	</center>
	
</body>
</html>
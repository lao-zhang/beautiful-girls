<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pick Girls</title>
</head>
<body>
	<center>
		<img src="file://${src1 }" height=400 width=300 onclick="f1()"/>
		<img src="file://${src2}" height=400 width=300 onclick="f2()"/>
	</center>
	
	<form name="form1" action="/Beauty/next">
		<input type="hidden" name="win" value="${no1}">
		<input type="hidden" name="lost" value="${no2 }">
		<input type="hidden" name="change" value="2"> 
	</form>
	
	<form name="form2" action="/Beauty/next">
		<input type="hidden" name="win" value="${no2}">
		<input type="hidden" name="lost" value="${no1 }"> 
		<input type="hidden" name="change" value="1">
	</form>
</body>

<script >
	function f1(){
		form1.submit();
	}
	function f2(){
		form2.submit();
	}
</script>
</html>
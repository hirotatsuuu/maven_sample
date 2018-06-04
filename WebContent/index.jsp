<%@ page import="java.util.* "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pageTitle = "Fruits Shop";
	List<String> fruitsList = Arrays.asList("Apple", "Banana", "Cherry");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= pageTitle %></title>
</head>
<body>
	<h1><%= pageTitle %></h1>
	<ul>
		<%
		for (String fruits: fruitsList) {
			out.println("<li>" + fruits + "</li>");
		}
		%>
	</ul>
</body>
</html>
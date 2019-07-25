<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h1>College Data</h1>
		College Id : ${requestScope.myacc.cid}<br>
		College Name : ${requestScope.myacc.aname}<br>
		CourseType : ${requestScope.myacc.coursetype}<br>
		City : ${requestScope.myacc.city}<br>
		Fees : ${requestScope.myacc.fees}<br>
		Pincode : ${requestScope.myacc.pincode}<br>
		
		<hr>
		<h1>Account Data</h1>
		<jsp:useBean id="myacc" class="com.lti.bean.College" scope="request"/>
		Aid<jsp:getProperty name="myacc" property="cid"/><br>
		Aname<jsp:getProperty name="myacc" property="cname"/><br>
		CourseType<jsp:getProperty name="myacc" property="coursetype"/><br>
		City<jsp:getProperty name="myacc" property="city"/><br>
		Fees<jsp:getProperty name="myacc" property="fees"/><br>
		Pincode<jsp:getProperty name="myacc" property="pincode"/><br>
		
		
		
		<a href="index.html">HOME</a>

</body>
</html>
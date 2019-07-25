<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.List, com.lti.bean.College, com.lti.service.CollegeService, com.lti.service.CollegeServiceImp" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of all accounts</h1>
		<font color="green" size="4">
	<% 			CollegeService service=new CollegeServiceImp();
					List<College> colist = (List<College>)service.displayAllColleges();
					for(College o:colist){
					 	out.println("CID : "+o.getCid()+"<br>");
						out.println("CName : "+o.getCname()+"<br>");
						out.println("CourseType : "+o.getCoursetype()+"<br>");
						out.println("City : "+o.getCity()+"<br>");
						out.println("fees : "+o.getFees()+"<br>");
						out.println("Pincode : "+o.getPincode()+"<br><hr>");
					}
			%>
		</font>
		<a href="index.html">HOME</a>

</body>
</html>
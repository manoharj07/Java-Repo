<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>COLLEGE INSERTION FORM</h1>
<form action="UpfeesServlet" method="post">
				
				Cname : <input type="text" id="cname" name="cname" /><br>
				
				Fees: <input type="number" id="fees" name="fees" /><br>
			   
			    <input type="Submit" value="Update fees">
			    </form>
			    <hr>
			      <font color="green" size="4">
					<%String stat = (String)request.getAttribute("status"); %>
					<%if(stat!=null) { out.println(stat); } %>
				</font>
			    <font color="red" size="4">
					<%String err = (String)request.getAttribute("err"); %>
					<%if(err!=null) { out.println(err); } %>
				</font>
				<a href="index.html">HOME</a>

</body>
</html>
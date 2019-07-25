<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Details here</title>
		<script>
			 $(document).ready(
				function(){
					$("input#cid").blur(
						function(){
							var cid=/^[0-9]{1,3}$/
							var str=$(this).val();
							if(str=="" || !cid.test(str)){
								$("div#formerr").text("User cannot be null or numbers");
								$(this).focus();
							}
						});
					$("input#cname").blur(
						function(){
							var cname=/^[a-zA-Z]+$/
							var str=$(this).val();
							if(str=="" || !cname.test(str)){
								$("div#formerr").text("Age cannot be null or alphabets or greater than 3 or less than 1");
								$(this).focus();
							}
						});
					$("input#Coursetype").blur(
						function(){
							var Coursetype=/^[a-zA-Z]+$/
								var str=$(this).val();
								if(str=="" || !Coursetype.test(str)){
									$("div#formerr").text("Age cannot be null or alphabets or greater than 3 or less than 1");
									$(this).focus();
							}
						});
					$("input#city").blur(
						function(){
							var city=/^[a-zA-Z]+$/
							var str=$(this).val();
							if(str=="" || !city.test(str)){
								$("div#formerr").text("Invalid Email");
								$(this).focus();
							}
						});
					$("input#fees").blur(
							function(){
								var fees=/^[0-9]{1,3}$/
								var str=$(this).val();
								if(str=="" || !fees.test(str)){
									$("div#formerr").text("Invalid Email");
									$(this).focus();
								}
							});
					$("input#pincode").blur(
							function(){
								var pincode=/^[0-9]{1,3}$/
								var str=$(this).val();
								if(str=="" || !pincode.test(str)){
									$("div#formerr").text("Invalid Email");
									$(this).focus();
								}
							});
				
						
				}
			 );
		</script>
</head>
<body>
<h1>COLLEGE INSERTION FORM</h1>
<form action="insertServlet" method="post">
				Cid : <input type="number" id="cid" name="cid" /><br>
				Cname : <input type="text" id="cname" name="cname" /><br>
				Coursetype : <input type="text" id="ctype" name="coursetype" /><br>
				City : <input type="text" id="city" name="city" /><br>
				Fees: <input type="number" id="fees" name="fees" /><br>
			    Pincode : <input type="number" id="pcode" name="pincode" /><br>
			    <input type="Submit" value="Insert College">
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
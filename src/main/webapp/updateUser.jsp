<%@page import="modal.User"%>
<%@page import="dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
	<link rel="stylesheet" href="./css/updateUser.css">
    <title>Electro - HTML Ecommerce Template</title>
</head>
<body>
	
	<% 
		String err = "";
		if(request.getAttribute("err") != null) {
			err = (String) request.getAttribute("err");
		}
		String username = request.getParameter("username");
		Dao dao = new Dao();
		User u = dao.getUser(username);
	%>

    <!-- HEADER -->
		<jsp:include page="header.jsp"></jsp:include>	
	<!-- /HEADER -->

		<div class="update-user">
			<div class="container">
				<div class="row">
					<h1 class="heading">Update information</h1>
					<form action="updateUserServlet" method="post" class="form-update">
						<span style="color: red"><%=err%></span>
						<div class="item"> 
							<span class="title">Username:</span>
							<input type="text" value="<%=u.getUsername()%>" name="username" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Password:</span>
							<input type="password" value="<%=u.getPassword()%>" name="password" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Birthday:</span>
							<input type="date" value="<%=u.getBirthday()%>" onfocus="this.value = '';" onblur="if(this.value == '') {this.value = '<%=u.getBirthday()%>';}" name="birthday" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Sex:</span>
							<input type="text" value="<%=u.getSex()%>" onfocus="this.value = '';" onblur="if(this.value == '') {this.value = '<%=u.getSex()%>';}" name="sex" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Email:</span>
							<input type="email" value="<%=u.getEmail()%>" onfocus="this.value = '';" onblur="if(this.value == '') {this.value = '<%=u.getEmail()%>';}" name="email" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Phone:</span>
							<input type="number" value="<%=u.getPhone()%>" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '<%=u.getPhone() %>';}" name="phone" id="" class="input-update-user">
						</div>
						<div class="item">
							<span class="title">Address:</span>
							<input type="text" value="<%=u.getAddress()%>" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '<%=u.getAddress()%>';}" name="address" id="" class="input-update-user">
						</div>

						<div class="control-update">
							<input type="submit" value="Update" style="background-color: #D10024; color: #fff; outline: none; border: none; padding: 8px 18px;">
							<input type="hidden" value="<%=u.getuId()%>" name="id">
						</div> 
					</form>
				</div>
			</div>
		</div>


</body>
</html>
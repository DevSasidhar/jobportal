<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile Page</title>
<%@ include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f7f7f7;">
	<%@include file="all_component/navbar.jsp" %>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"/>
	</c:if>
	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Login Page</h5>
						</div>
						<form cation="update_profile" method="post">
							<input type="hidden" name="id" value="${userobj.id }">
							<div class="form-group">
								<label>Enter Full Name</label><input type="text"
								required="required" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="name" value="${userobj.name }">
							</div>
							<div class="form-group">
								<label>Enter Qualification</label><input type="text"
								required="required" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="qua" value="${userobj.password }">
							</div>
							<div class="form-group">
								<label>Enter Email</label><input type="email"
								required="required" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="email" value="${userobj.qualification }">
							</div>
							<div class="form-group">
								<label>Enter Password</label><input type="password"
								required="required" class="form-control"
								id="exampleInputPassword1" aria-describedby="emailHelp"
								name="ps" value="${userobj.qualification }">
							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>
								
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 50px;">
		<%@include file="all_component/footer.jsp" %>
	</div>
</body>
</html>
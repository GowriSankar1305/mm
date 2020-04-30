<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<c:url value="/resources/css/ionicons.min.css"/>">
  <!-- Theme style -->
  <link rel="stylesheet" href="<c:url value="/resources/css/AdminLTE.min.css"/>">
  <!-- iCheck -->
  <link rel="stylesheet" href="<c:url value="/resources/css/blue.css"/>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<title>Login Here</title>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${contextPath }/"><b>Admin</b>LTE</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <c:choose>
    	<c:when test="${error ne null}">
    		<p class="login-box-msg" style="color: red;">${error }</p>
    	</c:when>
    	<c:when test="${logout ne null}">
    		<p class="login-box-msg" style="color: green;">${logout }</p>
    	</c:when>
    	<c:when test="${invalidSession ne null}">
    		<p class="login-box-msg" style="color: red;">${invalidSession }</p>
    	</c:when>
    	<c:when test="${sessionExpired ne null}">
    		<p class="login-box-msg" style="color: red;">${sessionExpired }</p>
    	</c:when>
    </c:choose>
    
    <form action="login" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="username">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
        </div>
        <!-- /.col -->
      </div>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>

    <a href="#">I forgot my password</a><br>
    <a href="signup" class="text-center">Register a new membership</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<!-- iCheck -->
<script src="<c:url value="/resources/js/icheck.min.js"/>"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
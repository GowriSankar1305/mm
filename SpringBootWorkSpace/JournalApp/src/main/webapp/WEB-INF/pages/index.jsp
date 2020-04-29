<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>Insert title here</title>
<%@ include file="css.jsp" %>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		
		<%@ include file="header1.jsp" %>
		<%@ include file="sideBar1.jsp"%>
		<div class="content-wrapper">
	 <section class="content-header">
      <h1>
        Blank page
        <small>it all starts here</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">Blank page</li>
      </ol>
    </section>
	
	
	<section class="content">

    	<div class="row">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Hover Data Table</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th style="text-align: center;">Answers</th>
                  <th style="text-align: center;">Views</th>
                  <th style="text-align: center;">Title</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                <tr>
                <td>12</td>
                <td>67</td>
                <td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
                </tr>
                </tbody>
              </table>
            </div>
            <!-- /.box-body -->
          </div> 
	</div>
</div>
    </section>
	
			
		</div>
		<%@ include file="footer1.jsp" %>
	</div>
	
	<%@ include file="scripts.jsp" %>
</body>
</html>
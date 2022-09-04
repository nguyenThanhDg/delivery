<%-- 
    Document   : base-admin2
    Created on : Sep 2, 2022, 9:31:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">



    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <link href="<c:url value="/images/header/fav.png" />" rel="shortcut icon" type="image/x-icon" >
        <title>
            <tiles:insertAttribute name="title" />
        </title>

        <script src="<c:url value="/js/testjs.js"/>"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="<c:url value="/admin/css/bootstrap.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/admin/css/font-awesome.min.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/admin/css/style.css"/>">
        <!--[if lt IE 9]>
                   
            <![endif]-->
        <script src="<c:url value="/admin/js/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/admin/js/popper.min.js"/>"></script>
        <script src="<c:url value="/admin/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/admin/js/jquery.slimscroll.js"/>"></script>
        <script src="<c:url value="/admin/js/Chart.bundle.js"/>"></script>
        <script src="<c:url value="/admin/js/chart.js"/>"></script>
        <script src="<c:url value="/admin/js/app.js"/>"></script>
        <script src="<c:url value="/https://cdn.jsdelivr.net/npm/chart.js"/>"></script>
        <script src="<c:url value="/js/admin.js" />"></script>
        <script src="<c:url value="/js/main.js" />"></script>
        <script src="<c:url value="/js/stats.js" />"></script>
    </head>

    <body>
        <div class="main-wrapper">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="content" />

        </div>
        <div class="sidebar-overlay" data-reff=""></div>


    </body>



</html>

<%-- 
    Document   : admin-header2
    Created on : Sep 3, 2022, 10:37:45 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="header">
    <div class="header-left">
        <a href="<c:url value="/index-2.html"/>" class="logo">
            <img src="<c:url value="/images/header/logo.png" />" width="70" alt=""> 
        </a>
    </div>
    <a id="mobile_btn" class="mobile_btn float-left" href="<c:url value="/#sidebar"/>"><i class="fa fa-bars"></i></a>
    <ul class="nav user-menu float-right">
        <li class="nav-item dropdown d-none d-sm-block">
            <a href="<c:url value="/#"/>" class="dropdown-toggle nav-link" data-toggle="dropdown"><i class="fa fa-bell-o"></i></a>

        </li>
        <li class="nav-item dropdown d-none d-sm-block">
            <a href="" id="open_msg_box" class="hasnotifications nav-link"><i class="fa fa-comment-o"></i></a>
        </li>
        <li class="nav-item dropdown has-arrow">
            <a href="" class="dropdown-toggle nav-link user-link" data-toggle="dropdown">
                <span class="user-img">
                    <img class="rounded-circle" src="<c:url value="/admin/img/user.jpg"/>" width="24" alt="Admin">
                    <span class="status online"></span>
                </span>
                <span>Admin</span>
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="<c:url value="/logout.html"/>">Logout</a>
            </div>
        </li>
    </ul>
</div>

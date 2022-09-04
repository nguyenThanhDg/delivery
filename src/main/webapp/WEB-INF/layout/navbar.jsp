<%-- 
    Document   : navbar
    Created on : Sep 1, 2022, 9:07:23 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a href="<c:url value="/"/>"><img src="<c:url value="/images/menu-icon/Homeicon.png" />" title="" alt=""> <div class="fos" id="foo">Home</div></a></li>
    <li><a href="<c:url value="/shipper/"/>"><img src="<c:url value="/images/menu-icon/flag.png"/>" title="" alt=""> <div class="fos" id="foo2">Find Profiles Shipper</div></a></li>


    
            <c:if test="${currentUser.getUserRole() == 'CUSTOMER'}">
        <li class="mpadding"><a href="<c:url value="/gotoshipper" />"><img src="<c:url value="/images/menu-icon/user.png"/>" title="" alt=""><div class="fos" id="foo10">Register Shipper</div></a></li>
            </c:if>
            <c:if test="${currentUser.getUserRole() == 'CUSTOMER' || currentUser.getUserRole() == 'SHIPPER'}">
        <li> <a href="<c:url value="/products" />"><img src="<c:url value="/images/menu-icon/info.png"/>" title="" alt=""><div class="fos" id="foo8">Your Products</div></a></li>
            </c:if>
            <c:if test="${currentUser.getUserRole() == 'SHIPPER'}">
        <li> <a href="<c:url value="/shipper/products" />"><img src="<c:url value="/images/menu-icon/info.png"/>" title="" alt=""><div class="fos" id="foo8">Products Delivery</div></a></li>
            </c:if>
            <c:if test="${currentUser.getUserRole() == 'ADMIN'}">
        <li> <a href="<c:url value="/admin/" />"><img src="<c:url value="/images/menu-icon/info.png"/>" title="" alt=""><div class="fos" id="foo8">Admin Page</div></a></li>
            </c:if>
</ul>

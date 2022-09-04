<%-- 
    Document   : goToShipper
    Created on : Aug 19, 2022, 2:21:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/gotoshipper" var="action" />
<form:form method="post" action="${action}" modelAttribute="userShipper">
    <div class="row">
        <div class="messages text-center col-md-12">
            Delivery Service
            <p>Register to become a shipper</p>
            <hr>
        </div>
        <div class="feedback col-md-10">
            <div class="email-input">
                <div class="midemail">
                    <img src="images/feedback/img1.png" alt="">
                    Identity
                </div>
                <form:input type="text" path="identity" placeholder="Enter your ID" />
                <form:errors path="identity" cssClass="text-danger" element="div" />
            </div>

            <div class="email-input">
                <div class="midemail">
                    <img src="images/feedback/3.png" alt="">
                    Birthday
                </div>
                <form:input type="text" path="dob" placeholder="MM/dd/yyyy" /> 
                <form:errors path="dob" cssClass="text-danger" element="div" />
            </div>
            <div class="email-input">
                <div class="midemail">
                    <img src="images/feedback/4.png" alt="">
                    Location
                </div>
                <form:input type="text" path="address" placeholder="e.g. “Ho Chi Minh city"/> 
                <form:errors path="address" cssClass="text-danger" element="div" />
            </div>
            <div class="sends">
                <input type="submit" value="send">
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</form:form>
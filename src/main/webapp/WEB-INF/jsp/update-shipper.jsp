<%-- 
    Document   : test2
    Created on : Sep 3, 2022, 10:55:43 AM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<div class="page-wrapper">
    <div class="content">
        <div class="row">
            <div class="col-sm-12">
                <h4 class="page-title">Edit Shipper Profile</h4>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10">
                <div class="card-box">
                    

                    <form:form method="post" action="${action}" 
                               enctype="multipart/form-data" modelAttribute="shipper">
                        <div class="form-group">
                            <label>First Name</label>
                            <form:input type="text" class="form-control" id="firstname" path="firstName"/>
                        </div>
                        <div class="form-group">
                            <label>Last Name</label>
                             <form:input type="text" class="form-control" id="lastname" path="lastName"/>
                        </div>
                        <div class="form-group">
                            <label>Email Address</label>
                             <form:input type="email" class="form-control" id="email" path="email"/>
                        </div>
                        <div class="form-group">
                            <label>Phone</label>
                             <form:input type="text" class="form-control" id="phone" path="phone"/>
                        </div>
                        <div class="text-right">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

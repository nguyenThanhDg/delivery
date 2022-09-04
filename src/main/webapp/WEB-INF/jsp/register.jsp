<%-- 
    Document   : re
    Created on : Sep 1, 2022, 2:30:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


    <!-- signup15:59:34 GMT -->
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon -->
        <link href="<c:url value="/images/header/fav.png"/>" rel="shortcut icon"  type="image/x-icon"/>

        <title>Youlisting | Sign Up  </title>

        <!-- Bootstrap core CSS-->
        <link href="<c:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/responsive.css"/>" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link rel="stylesheet" href="<c:url value="/css/portfolio.css"/>" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/owlslider.css"/>" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Custom styles for this template-->
        <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/font-awesome.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="<c:url value="/assets/owlcarousel/assets/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/owlcarousel/assets/owl.theme.default.min.css"/>">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    </head>

    <body>
        <div class="sign">
            <div class="container">
                <div class="row">
                    <div class="bg-form">
                        <div class="sinheader">
                            <div class="col-md-6">
                                <img src="images/header/logo.png" alt="">
                            </div>
                            <div class="sings col-md-6">
                                <a href="<c:url value="/login.html"/>">Have an already account! Sign in here</a> &nbsp;
                                <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                            </div>
                            <div class="clearfix">
                            </div>
                            <div style="width:500px" class="container">
                                <h1 class="text-center">Sign Up</h1>
                                <c:url value="/register" var="action" />

                                <form:form method="post" action="${action}"  enctype="multipart/form-data" modelAttribute="user">
                                    <div class="form-group">
                                        <label for="firstname">First Name</label>
                                        <form:input type="text" id="firstname" path="firstName" class="form-control" />
                                        <form:errors path="firstName" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="lastname">Last Name</label>
                                        <form:input type="text" id="lastname" path="lastName" class="form-control" />
                                        <form:errors path="lastName" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <form:input type="email" id="email" path="email" class="form-control" />
                                        <form:errors path="email" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">Phone</label>
                                        <form:input type="text" id="phone" path="phone" class="form-control" />
                                        <form:errors path="phone" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <form:input type="text" id="username" path="username" class="form-control" />
                                        <form:errors path="username" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <form:input type="password" id="password" path="password" class="form-control" />
                                        <form:errors path="password" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm-password">Confirm Password</label>
                                        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control" />
                                        <form:errors path="password" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <label for="avatar">Avatar : </label>
                                        <form:input type="file" id="avatar" path="file" />
                                        <form:errors path="file" cssClass="text-danger" element="div" />
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" value="Sign Up" class="btn btn-info" />
                                    </div>
                                </form:form>

                            </div>
                        </div>
                        <div class="footer-sign">
                            <div class="p-left col-md-8 footermenu">
                                <ul>
                                    <li><a>About  </a></li>
                                    <li><a >Faq’s</a></li>
                                    <li><a > Privacy policy</a></li>
                                    <li><a >Advertise</a></li>
                                    <li><a >career</a></li>
                                    <li><a >Term and conditions </a></li>
                                    <li><a >Press</a></li>
                                    <li><a>Sitemap</a></li>
                                    <li><a >Tags</a></li>
                                    <li><a >Blogs</a></li>
                                </ul>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <!-- Core plugin JavaScript-->

    </body>


</html>


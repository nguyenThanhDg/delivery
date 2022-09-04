<%-- 
    Document   : signin
    Created on : Sep 1, 2022, 1:49:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


    <!-- signin15:54:02 GMT -->
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Favicon -->
        <link href="<c:url value="/images/header/fav.png"/>" rel="shortcut icon" type="image/x-icon"/>

        <title>Youlisting | Sign In </title>

        <!-- Bootstrap core CSS-->
        <link href="<c:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/responsive.css"/>" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Page level plugin CSS-->
        <link rel="stylesheet" href="<c:url value="/css/portfolio.css"/>" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/owlslider.css"/>" type="text/css">
        <!-- Custom styles for this template-->
        <link href="<c:url value="/css/sb-admin.css"/> rel="stylesheet"  type="text/css">
        <link href="<c:url value="/css/font-awesome.css"/> rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/font-awesome.min.css"/> rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="<c:url value="/assets/owlcarousel/assets/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/owlcarousel/assets/owl.theme.default.min.css"/>">

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

                            <div class="clearfix">
                            </div>

                            <div class="sform">
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger">
                                        Login Failure

                                    </div>

                                </c:if>
                                <c:if test="${param.accessDenied != null}">
                                    <div class="alert alert-danger">
                                        You have not permission to access
                                    </div>
                                </c:if>
                                <h1>Sign in</h1>
                                <span>Don't have an account yet? <a href="<c:url value="/register/"/>">Sign Up</a></span>
                                <c:url value="/login" var="action" />
                                <form class="sinup" method="post" action="${action}">
                                    <div class="input-container">
                                        <input class="input-field" type="text" placeholder="Username" name="username">
                                    </div>

                                    <div class="input-container">
                                        <input class="input-field" type="password" placeholder="Password" name="password">
                                    </div>

                                    <button type="submit" class="btn">Sign in</button>
                                </form>

                            </div>
                        </div>
                        <div class="footer-sign">
                            <div class="p-left col-md-8 footermenu">
                                <ul>
                                    <li><a href="<c:url value="/#"/>">About  </a></li>
                                    <li><a href="<c:url value="/#"/>">Faq’s</a></li>
                                    <li><a href="<c:url value="/#"/>"> Privacy policy</a></li>
                                    <li><a href="<c:url value="/#"/>">Advertise</a></li>
                                    <li><a href="<c:url value="/#"/>">career</a></li>
                                    <li><a href="<c:url value="/#"/>">Term and conditions </a></li>
                                    <li><a href="<c:url value="/#"/>">Press</a></li>
                                    <li><a href="<c:url value="/#"/>">Sitemap</a></li>
                                    <li><a href="<c:url value="/#"/>">Tags</a></li>
                                    <li><a href="<c:url value="/#"/>">Blogs</a></li>
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


    <!-- signin15:54:03 GMT -->
</html>

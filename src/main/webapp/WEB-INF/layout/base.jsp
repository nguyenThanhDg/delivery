<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
        <link href="<c:url value="/images/header/fav.png" />" rel="shortcut icon" type="image/x-icon" >
        <link href="<c:url value="/css/style.css" />" rel="stylesheet">
        <link href="<c:url value="/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/responsive.css" />" rel="stylesheet">
        
        <!-- Custom fonts for this template-->
        <link href="<c:url value="/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
        <!-- Page level plugin CSS-->
        <link rel="stylesheet" href="<c:url value="/css/portfolio.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/dropdown.css"/>" type="text/css">
        <link rel="stylesheet" href="<c:url value="/css/owlslider.css"/>" type="text/css">
        <!-- Custom styles for this template-->
        <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/font-awesome.css"/>" rel="stylesheet" type="text/css">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body id="page-top">
        <!-- HEADER -->
        <tiles:insertAttribute name="header" />

        <div id="wrapper">
            <tiles:insertAttribute name="navbar" />

            <!-- CONTENT -->
            <div id="content-wrapper">
                <div class="container-fluid">
                    <tiles:insertAttribute name="content" />
                </div>
                <div class="clearfix"></div>
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>
        <br><br>
        <!-- FOOTER -->
        
        <script src="<c:url value="/vendor/chart.js/Chart.min.js"/>"></script>
        <script src="<c:url value="/vendor/datatables/jquery.dataTables.js"/>"></script>
        <script src="<c:url value="/endor/datatables/dataTables.bootstrap4.js"/>"></script>
        <script src="<c:url value="/js/main.js" />"></script>
        <script src="<c:url value="/js/admin.js" />"></script>
        <script src="<c:url value="/js/sb-admin.min.js"/>"></script>
        <script src="<c:url value="/js/portfolio.js"/>"></script>
        <script src="<c:url value="/js/you-listing.js"/>"></script>
        <script src="<c:url value="/js/menurght.js"/>"></script>
        <script src="<c:url value="/js/crausal1.js"/>"></script>
        <script src="<c:url value="/js/dropdown.js"/>"></script>
        <script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
        <script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
        <script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
        <script src="<c:url value="/js/slick.min.js"/>"></script>.
        <!-- Assect scripts for this page-->
        <script src="<c:url value="/assets/vendors/jquery.min.js"/>"></script>
        <script src="<c:url value="/assets/owlcarousel/owl.carousel.js"/>"></script>
        <script src="<c:url value="/assets/vendors/highlight.js"/>"></script>
        <script src="<c:url value="/assets/js/app.js"/>"></script>

    </body>
</html>

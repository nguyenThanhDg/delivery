<%-- 
    Document   : listshipper
    Created on : Aug 24, 2022, 10:18:11 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="messages text-center col-md-12">
        Find Profiles
        <hr>
    </div>	
    <div class="left_side">
        <div class="search-main">
            <form>
                <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                <input type="text" name="search" placeholder="Enter a keyword....">
            </form>
        </div>
        <c:forEach var="s" items="${shipper}">
            <c:url value="/shipper/${s.id}" var="endpoint" />
            <div class="col-md-4 col-xs-12 col-sm-6 p-left">
                <div class="mainbox">
                    <div class="imgbox">
                        <img src="${s.avatar}" alt="">
                    </div>
                    <div class="lefttext">
                        ${s.firstName} ${s.lastName}
                        <p>${s.email}</p>
                    </div>
                    <div class="righttext">
                        <a href="${endpoint}">Detail</a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<br><br>
<div>
    <ul class="pagination d-flex justify-content-center">
        <c:forEach begin="1" end="${Math.ceil(counter/3)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/shipper/" />?page=${i}">${i}</a></li>
            </c:forEach>
    </ul>
</div>

<script src="<c:url value="/js/slick.min.js"/>"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<nav class="navbar navbar-expand-md navbar-light fixed-top sticky-top nav-menu">

    <div class="col-md-2 col-xs-12 p-left  p-right">

        <button  class="btn btn-link btn-sm text-white order-1 order-sm-0"  id="sidebarToggle" >
            <i class="fas fa-bars"></i>
        </button>
        <div class="logo">
            <a href="<c:url value="/" />">
                <img src="<c:url value="/images/header/logo.png" />" alt="logo" />
            </a>
        </div>
    </div>
    <!-- Navbar -->
    <div class="col-md-5 col-xs-12 p-left  p-right">
        <div class="searching">
            <form>
                <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                <input type="text" name="kw" placeholder="Search Product name...">
            </form>
        </div>
    </div>
    <div class="col-md-5 col-xs-12 p-left p-right">
        <c:if test="${currentUser.getUserRole() == 'CUSTOMER' || currentUser.getUserRole() == 'SHIPPER'}">
        <div class="add-listing">
            <a href="<c:url value="/add/product" />">
                <img src="<c:url value="/images/header/plus-ico.png" />" alt="">
                Add Product</a>
        </div>
         </c:if>
        <div class="home">
            <ul>
                <li>
                    <a  href="<c:url value="/" />"><img src="<c:url value="/images/header/home.png" />" alt="" title="" >
                    </a>
                </li>
                <li class="popup"  onclick="myFunctionmsg()">
                    <img src="<c:url value="/images/header/mgs.png" />" alt="" title="" >


                </li>
                <li class="popup"  onclick="myFunctionicon()">
                    <img src="<c:url value="/images/header/notification.png" />" alt="" title="" >

                </li>

            </ul>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="<c:url value="/login" />">
            <div class="login popup">
                <img src="<c:url value="/images/header/u-icon.png" />" title="" alt="">Sign in
            </div>
            </a>
        </c:if>
        <!--#Home-->
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="login popup"  onclick="signin()">
                <img src="${currentUser.avatar}" title="" alt="">
                ${currentUser.lastName}
                <div class="popuptext1" id="signin">
                    <div class="notfication-details">
                        <div class="notification-info">
                            <a href="<c:url value="/logout"/>" >Sign out</a>
                        </div><!--notification-info -->
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</nav>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="messages text-center col-md-12">Product Detail</div>


<!-- Banner -->
<div class="dashboard">
    <div class="advertisment-banner1 col-md-12">
        <img src="${product.image}" alt="" title="c-Bg">
    </div>
    <div class="clearfix">
    </div>
</div>

<!-- Banner Area-->
<div class="settingmenu">
    <div class="navbar navbar-expand-md navbar-light">
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon "></span>
        </button>
        <div class="collapse navbar-collapse  visible-title" id="navbarNav">
            <ul class="navbar-nav ">
                <li>
                    <a href="setting.html">About </a>
                </li>
            </ul>

        </div>
    </div>

</div>
<div class="row">
    <div class="col-md-6">
        <div class="locatins heading">
            <div class="email-input">
                <div class="midemail1">
                    <img src="<c:url value="/images/feedback/img1.png"/>" alt="">
                    Name: ${product.name}
                </div>
            </div>
        </div>
        <div class="locatins heading">
            <div class="email-input">
                <div class="midemail1">
                    <img src="<c:url value="/images/feedback/img1.png"/>" alt="">
                    About
                </div>
                <div class="editors">
                    <textarea>${product.description}</textarea>
                </div>
            </div>
        </div>
        <div class="locatins heading">
            <div class="email-input">
                <div class="midemail1">
                    <img src="<c:url value="/images/feedback/4.png"/>" alt="">
                    From Address
                </div>
                <div class="socialnetworking">
                    ${product.diliveryAddress}
                </div>


            </div>
            <div class="clearfix"></div>
        </div>
        <div class="locatins heading">
            <div class="email-input">
                <div class="midemail1">
                    <img src="<c:url value="/images/feedback/4.png"/>" alt="">
                    To Address
                </div>
                <div class="socialnetworking">
                    ${product.getAddress}
                </div>


            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="box-left">
            <div class="rightboxs">
                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                <span>Email Address</span>
                <p>${product.customer.email}</p>
            </div>
        </div>
        <div class="box-left">
            <div class="rightboxs">
                <i class="fa fa-mobile" aria-hidden="true"></i>
                <span>Phone Number </span>
                <p>${product.customer.phone}</p>
            </div>
        </div>
        <div class="box-left1">
            <div class="email-input2">
                <div class="midemail2">
                    <img src="<c:url value="/images/feedback/4.png"/>" alt="">
                    &nbsp Cost: ${product.price}
                </div>
            </div>
        </div>

    </div>
</div>
<div class="clearfix"></div>
<!--#Spiner-->
<c:if test="${cost != null}">
    <h3>Your offer: ${cost.cost}</h3>
</c:if>
<c:if test="${shipper == 1}">
    <form>
        <c:url value="/api/add-productShipper" var="endpoint" />
        <div class="mf-field">
            <input type="number" id="costId" placeholder="Type a suggested shipping cost here">
            <button onclick="addProductShip('${endpoint}', ${product.id})"
                    >Send</button>
        </div>
    </form>
</c:if>
<!--#Spiner-->
<!-- Sticky Footer -->











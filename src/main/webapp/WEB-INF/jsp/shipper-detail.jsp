<%-- 
    Document   : shipper-detail
    Created on : Aug 24, 2022, 10:49:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${shipperDetail == null}">
    <div class="messages text-center col-md-12">There's nothing here</div>
</c:if>
<c:if test="${shipperDetail != null}">
    <c:if test="${rate == 0}">
        <c:url value="/api/add-rating" var="endpoint" />
        <div class="myrating" onchange="addRating('${endpoint}',${shipperDetail.id})">
            <input type="radio" name="myrating" value="5" id="5"><label for="5">☆</label>
            <input type="radio" name="myrating" value="4" id="4"><label for="4">☆</label>
            <input type="radio" name="myrating" value="3" id="3"><label for="3">☆</label>
            <input type="radio" name="myrating" value="2" id="2"><label for="2">☆</label>
            <input type="radio" name="myrating" value="1" id="1"><label for="1">☆</label>
        </div>
    </c:if>

    <div class="dashboard">
        <div class="advertisment-banner1 col-md-12">
            <img src="${shipperDetail.avatar}" alt="" title="c-Bg">
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
                        Name: ${shipperDetail.firstName} ${shipperDetail.lastName}
                    </div>
                </div>
            </div>
            <div class="rightbox" id="commentArea">
                <c:forEach items="${shipperDetail.commentShipperCollection}" var="comment">
                    <div class="rightmsg">
                        <div class="message-radius">
                            <img src="${comment.customer.avatar}" alt="" title="">
                        </div>
                        <div class="message-heading">
                            ${comment.customer.firstName} ${comment.customer.lastName}
                            <p>${comment.content}</p>
                        </div>
                        <div class="message-heading1 date">
                            <i>${comment.createdDate}</i>
                        </div>
                        <div class="clearfix"></div>
                        <hr>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-6">
            <div class="box-left">
                <div class="rightboxs">
                    <i class="fa fa-envelope-o" aria-hidden="true"></i>
                    <span>Email Address</span>
                    <p>${shipperDetail.email}</p>
                </div>
            </div>
            <div class="box-left">
                <div class="rightboxs">
                    <i class="fa fa-mobile" aria-hidden="true"></i>
                    <span>Phone Number </span>
                    <p>${shipperDetail.phone}</p>
                </div>
            </div>

        </div>
    </div>
    <div class="message-send-area">
        <form>
            <c:url value="/api/add-comment" var="endpoint" />
            <div class="mf-field">

                <input type="text" id="commentId" placeholder="Type a comment here">
                <button onclick="addComment('${endpoint}',${shipperDetail.id})">Send</button>
            </div>

        </form>
    </div>
    <div class="clearfix"></div>
</c:if>
    

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
        document.getElementById(${avg}).checked = true;
    }
</script>
<link rel="stylesheet" href="<c:url value="/css/css.css" />">

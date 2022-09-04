

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<br><br>

<div class="tabby">
    <div class="htitle col-md-6">
        List Products
    </div>
    <div class="htitle col-md-12">
        <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/3)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
    </div>
    <div class="clearfix"></div>
    <c:forEach var="p" items="${products}">

        <div class="filterDiv Places">
            <div class="col-md-4 col-xs-12 ">
                <div class="box" >
                    <a href="<c:url value="/products/${p.id}"/>">
                        <div class="box-img">
                            <img src="${p.image}" style="height: 100%" class="img" alt="" title="" >

                        </div>
                    </a>

                    <div class="box-radius">
                        <img style="width: 100%" src="${p.customer.avatar}" class="img" alt="" title="" >

                    </div>
                    <div class="box-heading3">
                        By ${p.customer.firstName} ${p.customer.lastName}
                        <div class="box-heading3">
                            <i class="fa fa-map-marker" aria-hidden="true"></i> ${p.name}
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </c:forEach>

</div>



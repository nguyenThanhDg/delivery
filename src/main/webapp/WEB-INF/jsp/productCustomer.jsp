<%-- 
    Document   : productCustomer
    Created on : Aug 27, 2022, 9:42:26 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${product.isEmpty()}">
    <div class="messages text-center col-md-12">There's nothing here</div>
</c:if>
<c:if test="${!product.isEmpty()}">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped table-vcenter mb-0 text-nowrap">
                            <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Name</th>
                                    <th class="w100">Cost</th>
                                    <th class="w100">Date</th>
                                    <th>From Address</th>
                                    <th>To Address</th>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${product}" var="data">
                                    <c:url value="/api/products/${data.id}" var="endpoint"/>
                                    <tr>
                                        <td><img src="${data.image}" alt="Image" class="w30 rounded-circle mr-2"></td>
                                        <td>${data.name}</td>
                                        <td><span>${data.price}</span></td>
                                        <td>${data.createdDate}</td>
                                        <td>${data.diliveryAddress}</td>
                                        <td>${data.getAddress}</td>
                                        <td><button class='btn btn-danger' onclick="delGoToShipper('${endpoint}')">Delete</button></td>
                                        <td><a class='btn btn-success' href="<c:url value="/products/update/${data.id}"/>">Edit</a></td>
                                         <c:url value="/products/view/${data.id}" var="url"/>
                                        <td><a class='btn btn-info' href="${url}">Shipper</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<script src="<c:url value="/js/admin.js" />"></script>


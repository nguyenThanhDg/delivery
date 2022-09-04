
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
                                    <th>Customer</th>
                                    <th class="w100">Product Name</th>
                                    <th class="w100">Cost</th>
                                    <th>Created Date</th>
                                    <th>From Address</th>
                                    <th>To Address</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${product}" var="data">
                                    <c:url value="/api/accept/${data.id}" var="endpoint" />
                                    <tr>
                                        <td><img src="${data.product.image}" alt="Image" class="w30 rounded-circle mr-2"></td>
                                        <td>${data.shipper.firstName} ${data.shipper.lastName}</td>
                                        <td><span>${data.product.name}</span></td>
                                        <td>${data.cost}</td>
                                        <td>${data.product.createdDate}</td>
                                        <td>${data.product.diliveryAddress}</td>
                                        <td>${data.product.getAddress}</td>
                                        <td><button class='btn btn-success' onclick="delShipper('${endpoint}')">Complete</button></td>
      
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


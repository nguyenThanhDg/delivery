<%-- 
    Document   : viewShipper
    Created on : Aug 30, 2022, 8:13:29 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${shippers.isEmpty()}">
    <div class="messages text-center col-md-12">There's nothing here</div>
</c:if>
<c:if test="${!shippers.isEmpty()}">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped table-vcenter mb-0 text-nowrap">
                            <thead>
                                <tr>
                                    <th>Avatar</th>
                                    <th>Name</th>
                                    <th class="w100">Email</th>
                                    <th class="w100">Phone</th>
                                    <th>Cost</th>
                                    <th></th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${active == null}">
                                    <c:forEach items="${shippers}" var="s">
                                        <c:url value="/api/active/${s.id}" var="endpoint" />
                                        <tr>
                                            <td><img src="${s.shipper.avatar}" alt="Image" class="w30 rounded-circle mr-2"></td>
                                            <td>${s.shipper.firstName} ${s.shipper.lastName}</td>
                                            <td>${s.shipper.email}</td>
                                            <td>${s.shipper.phone}</td>
                                            <td>${s.cost}</td>
                                            <td><button class='btn btn-success' onclick="delShipper('${endpoint}')">Commit</button></td>

                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${active != null}">
                                    <tr>
                                        <td><img src="${active.shipper.avatar}" alt="Image" class="w30 rounded-circle mr-2"></td>
                                        <td>${active.shipper.firstName} ${s.shipper.lastName}</td>
                                        <td>${active.shipper.email}</td>
                                        <td>${active.shipper.phone}</td>
                                        <td>${active.cost}</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</c:if>
<script src="<c:url value="/js/admin.js" />"></script>
<script src="<c:url value="/js/main.js" />"></script>

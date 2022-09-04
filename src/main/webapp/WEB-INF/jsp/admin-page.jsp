<%-- 
    Document   : test1
    Created on : Sep 3, 2022, 10:41:41 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="page-wrapper">
    <div class="content">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">
                <div class="dash-widget">
                    <span class="dash-widget-bg2"><i class="fa fa-user-o"></i></span>
                    <div class="dash-widget-info text-right">
                        <h3>${countS}</h3>
                        <span class="widget-title2">Shipper<i class="fa fa-check" aria-hidden="true"></i></span>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-lg-6 col-xl-4">
                <div class="dash-widget">
                    <span class="dash-widget-bg3"><i class="fa fa-user-o" aria-hidden="true"></i></span>
                    <div class="dash-widget-info text-right">
                        <h3>${countC}</h3>
                        <span class="widget-title3">Customer<i class="fa fa-check" aria-hidden="true"></i></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12 col-md-6 col-lg-6 col-xl-6">
                <div class="card">
                    <div class="card-body">
                        <div class="chart-title">
                            <h4>Search by Year</h4>
                            <c:url value="/admin/" var="action" />
                            <form action="${action}">
                                <div class="row filter-row">

                                    <div class="col-sm-6 col-md-4">
                                        <div class="form-group form-focus">
                                            <label class="focus-label">Year</label>
                                            <input type="text" name="year" class="form-control floating">
                                        </div>
                                    </div>

                                    <div class="col-sm-6 col-md-3">
                                        <button type="submit" class="btn btn-success btn-block"> Search </button>
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>	
                    <canvas id="myChart"></canvas>
                </div>
            </div>
            <div class="col-12 col-md-6 col-lg-6 col-xl-6">
                <div class="card">
                    <div class="card-body">
                        <div class="chart-title">
                        </div>
                    </div>	
                    <canvas id="chart2"></canvas>
                </div>
            </div>
        </div>
    </div>
    <div class="content">
        <form action="">
            <div class="row filter-row">
                <div class="col-sm-6 col-md-2">

                    <label class="focus-label">Key word</label>
                    <div class="form-group form-focus">
                        <div class="cal-icon">
                            <input class="form-control floating" name="kw" type="text">
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">

                    <label class="focus-label">From</label>
                    <div class="form-group form-focus">
                        <div class="cal-icon">
                            <input class="form-control floating" name="fromDate" type="date">
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <label class="focus-label">To</label>
                    <div class="form-group form-focus">

                        <div class="cal-icon">
                            <input class="form-control floating" name="toDate" type="date">
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <label class="focus-label">Search Product by Date</label>
                    <div class="form-group form-focus">
                        <input type="submit" class="btn btn-success btn-block" value="Search">
                    </div>
                </div>
            </div>
        </form>
        <div class="row">
            <div class="col-md-11">
                <div class="table-responsive">
                    <table class="table table-striped custom-table mb-0">
                        <thead>
                            <c:if test="${products.isEmpty()}">
                            <div class="card-header">
                                <h4 class="card-title d-inline-block">No Product</h4> 
                            </div>
                        </c:if>
                        <c:if test="${!products.isEmpty()}">
                            <tr>
                                <th>Product</th>
                                <th>Shipper</th>
                                <th>Cost</th>
                                <th>Date</th>
                            </tr>
                        </c:if>
                        </thead>
                        <tbody>


                            <c:forEach items="${products}" var="p">
                                <tr>
                                    <td><img width="50px" height="50px" src="${p[1]}">${p[2]}</img></td>
                                    <td>${p[3]} ${p[4]}</td>
                                    <td>${p[5]}</td>
                                    <td>${p[6]}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>  
    <div class="row">
        <div class="col-12 col-md-6 col-lg-11 col-xl-11">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title d-inline-block">List Shippers</h4>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table class="table mb-0 new-patient-table">
                            <tbody>
                                <c:if test="${shipper.isEmpty()}">
                                <div class="card-header">
                                    <h4 class="card-title d-inline-block">No Shipper</h4> 
                                </div>
                            </c:if>
                            <c:if test="${!shipper.isEmpty()}">
                                <c:forEach items="${shipper}" var="data">
                                    <c:url value="/api/shipper/${data[8]}" var="endpoint" />
                                    <c:url value="/api/usershipper/${data[8]}" var="endpoint2" />
                                    <tr>
                                        <td>
                                            <img width="28" height="28" class="rounded-circle" src="${data[4]}" alt=""> 
                                            <h2>${data[0]} ${data[1]}</h2>
                                        </td>
                                        <td>${data[2]}</td>
                                        <td>${data[3]}</td>
                                        <td>${data[5]}</td>
                                        <td>${data[7]}</td>
                                        <td>${data[6]}</td>
                                        <td><a class="btn btn-primary btn-primary-two float-right" href="<c:url value="/admin/shipper/${data[8]}"/>">Edit</a></td>
                                        <td><button class="btn btn-primary btn-primary-one float-right" onclick="delShipper('${endpoint}'); delGoToShipper('${endpoint2}')">Cancel</button></td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12 col-md-6 col-lg-11 col-xl-11">
            <div class="card">
                <div class="card-header">
                    <h4 class="card-title d-inline-block">Subscriber becomes a delivery person</h4> 
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table class="table mb-0 new-patient-table">
                            <tbody>
                                <c:if test="${uGoToShipper.isEmpty()}">
                                <div class="card-header">
                                    <h4 class="card-title d-inline-block">No subscribers</h4> 
                                </div>
                            </c:if>
                            <c:if test="${!uGoToShipper.isEmpty()}">
                                <c:forEach items="${uGoToShipper}" var="data">
                                    <c:url value="/api/usershipper/${data[8]}" var="endpoint" />
                                    <tr>
                                        <td>
                                            <img width="28" height="28" class="rounded-circle" src="${data[4]}" alt=""> 
                                            <h2>${data[0]} ${data[1]}</h2>
                                        </td>
                                        <td>${data[2]}</td>
                                        <td>${data[3]}</td>
                                        <td>${data[5]}</td>
                                        <td>${data[7]}</td>
                                        <td>${data[6]}</td>
                                        <td><button class="btn btn-primary btn-primary-three float-right" onclick="addGoToShipper('${endpoint}')">Accept</button></td>
                                        <td><button class="btn btn-primary btn-primary-one float-right" onclick="delGoToShipper('${endpoint}')">Cancel</button></td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script>
    window.onload = function () {
        let data = [];
        let labels = [];
        let data2 = [];
    <c:forEach items="${revenuStats}" var="c">
        data.push(${c[3]});
        labels.push('${c[0]}');
        data2.push(${c[2]});
    </c:forEach>

        revenueStats(labels, data);
        chart(labels, data2);
    }
</script>
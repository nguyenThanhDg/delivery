<%-- 
    Document   : add-product
    Created on : Aug 21, 2022, 8:06:16 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/add/product" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="product">
    <div class="upload_listing">
        <!-- Banner -->
        <div class="row">
            <div class="messages text-center col-md-12">
                Add Product
                <p>Submit a form</p>
                <hr>
            </div>
            <div class="feedback col-md-10">
                <div class="email-input">
                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/img1.png" />" alt="">
                        Name
                    </div>
                    <form:input type="text" id="name" path="name" placeholder="Name the Product"/> 
                    <form:errors path="name" cssClass="text-danger" element="div" />
                </div>
                <div class="email-input">
                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/img1.png" />" alt=""> Description
                    </div>
                    <div class="editors">
                        <ul>
                            <li><strong>B</strong><i>I</i></li>
                            <li><img src="<c:url value="/images/feedback/img2.png" />" alt=""></li>
                            <li><img src="<c:url value="/images/feedback/link.png" />" alt=""> &nbsp; &nbsp;
                                <img src="<c:url value="/images/feedback/link-2.png" />" alt="">
                            </li>
                        </ul>

                        <div class="clearfix"></div>
                    </div>
                    <form:textarea placeholder="Write description here" id="description" path="description"/>
                    <form:errors path="description" cssClass="text-danger" element="div" />
                </div>
                <div class="email-input searched">
                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/img1.png" />" alt="">
                        Initial cost
                    </div>
                    <form:input type="text" id="price" path="price" placeholder="Enter cost" />
                    <form:errors path="price" cssClass="text-danger" element="div" />
                </div>
                <div class="email-input">

                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/screen.png" />" alt=""> Images
                    </div>
                    <div class="form-group d-inline-flex p-2">
                        <form:input type="file" id="file" path="file" />
                    </div>

                </div>
                <div class="email-input">
                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/4.png" />" alt="">
                        From Location 
                    </div>
                    <form:input type="text" id="diliveryAddress" path="diliveryAddress" class="form-control" />
                    <form:errors path="diliveryAddress" cssClass="text-danger" element="div" />
                </div>
                <div class="email-input">
                    <div class="midemail">
                        <img src="<c:url value="/images/feedback/4.png" />" alt="">
                        To Location 
                    </div>
                    <form:input type="text" id="getAddress" path="getAddress" class="form-control" />
                    <form:errors path="getAddress" cssClass="text-danger" element="div" />
                </div>
                <div class="sends">
                    <input type="submit" value="send">
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>

</form:form>
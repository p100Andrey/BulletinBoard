<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head>
    <title>Announces Pages</title>

    <style type="text/css">
        .tg {
            width: 1200px;
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }
        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<div align="center">
<c:import url="/WEB-INF/pages/header.jsp"></c:import>
<table>

    <br/>
    <br/>
    <table class="tg">

        <h1>Announces</h1>

        <c:if test="${!empty listAnnounce}">

            <c:forEach items="${listAnnounce}" var="announce">
                <jsp:useBean id="now" class="java.util.Date" />
                <c:if test="${(now.time - announce.announcecreationtime)/(1000*60*60)>24}">
                    <c:url value='/announceremove/${announce.announceid}'/>
                </c:if>
            </c:forEach>

            <tr>
                <th width="80">ID</th>
                <th width="120">Title</th>
                <th width="120">Announce text</th>
                <th width="120">Photo</th>
                <th width="60">Author</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listAnnounce}" var="announce">
                <tr>
                    <td>${announce.announceid}</td>
                    <td>${announce.announcetitle}</td>
                    <td>${announce.announcetext}</td>
                    <td>${announce.announcefoto}</td>
                    <td>${announce.announceauthor}</td>
                    <td><a href="<c:url value='/announceedit/${announce.announceid}'/>">Edit</a></td>
                    <td><a href="<c:url value='/announceremove/${announce.announceid}'/>">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</table>
</div>
</body>
</html>
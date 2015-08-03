<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Creator</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<form action="upload" method="post" enctype="multipart/form-data">
		<h2>Upload File :</h2>
		<input type="file" name="fileToUpload" id="fileToUpload"> <input
			type="submit" value="Upload" name="submit">
	</form>
	<c:choose>
		<c:when test="${data != null}">
			<table>
				<c:forEach items="${data}" var="rowData" varStatus="loop">
					<tr>
						<c:forEach items="${rowData}" var="colData">
							<td contenteditable='true'>${colData}</td>
						</c:forEach>
						<c:choose>
							<c:when test="${loop.index == 0}">
								<td>Edit</td>
								<td>delete</td>
							</c:when>
							<c:otherwise>
								<td><a
									href="<c:url value='/editData' />">Edit</a></td>
								<td><a
									href="<c:url value='/deleteData' />">delete</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</c:when>
	</c:choose>
</body>
</html>
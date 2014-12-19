<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body> 
<h2>QR Generator</h2>
<p>Hora:        <c:out value="${model.now}"/></p>
<p>Util:        <c:out value="${model.util}"/></p>

<form method="POST" action="uploadPDFFile" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br />
        Name: <input type="text" name="name"><br /> <br />
        <input type="submit" value="Upload"> Press here to upload the file!
</form>

 <c:if test="${not empty sigInfo}">
	 <div style="border: 1px solid;">
	 	<p> <c:out value="${sigInfo}" escapeXml="false"/> </p>
	 </div>
 </c:if>

<%@ include file="/WEB-INF/views/links.jsp" %>

</body>
</html>

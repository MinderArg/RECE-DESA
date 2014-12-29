<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body> 
<h2>Splitter</h2>
<p>Hora:        <c:out value="${model.now}"/></p>
<p>Util:        <c:out value="${model.util}"/></p>

<form method="POST" action="uploadPDFtoSplit.htm" enctype="multipart/form-data">
	<fieldset>
			<legend>Subir recibos</legend>
	        <label for="file">Elegir archivo</label> 
	        <input type="file" name="file"><br />
	        <label for="name">Nombre</label> 
	        <input type="text" name="name"><br /> <br />
	        <input type="submit" name="upload" value="Subir"/>
	</fieldset>
</form>

 <c:if test="${not empty document.name}">
	<form method="POST" action="splitDocument.htm" enctype="multipart/form-data">
		<fieldset>
				<legend>Opciones del recibo</legend>
		        <input type="text" name="docName" value="${document.name}" disabled/><br/>
		        <input type="submit" name="splitDocument" value="Cortar recibos"/>
		        <label for="dobleHoja">Dos recibos por hoja?</label> 
		        <input type="checkbox" name="dobleHoja"><br/>
		        
<%-- 		        <input type="text" name="incluNone" value="${document.name}"/> --%>
		</fieldset>
	</form>
	
  </c:if>

<%@ include file="/WEB-INF/views/links.jsp" %>

</body>
</html>

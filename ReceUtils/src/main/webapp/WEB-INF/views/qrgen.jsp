<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<body> 
<h2>QR Generator</h2>
<p>Hora:        <c:out value="${model.now}"/></p>
<p>Util:        <c:out value="${model.util}"/></p>

<form:form id="mecardForm" method="post" action="qrgen.htm">
	<form:label for="qrName" path="name">Nombre:</form:label>
	<form:input id="qrName" type="text" path="name"/>
	<form:label for="qrTel" path="tel">Teléfono:</form:label>
	<form:input id="qrTel" type="text" path="tel"/>
	<br/>
	<form:label for="qrNote" path="note">Nota:</form:label>
	<form:input id="qrNote" type="text" path="note"/>
	<form:label for="qrEmail" path="email">Email:</form:label>
	<form:input id="qrEmail" type="text" path="email"/>
	<br/>
	<form:button type="submit">Generar</form:button>
</form:form>


<c:if test="${model.showQR}">
	<img src="qr"/>
</c:if>

<%@ include file="/WEB-INF/views/links.jsp" %>

</body>
</html>

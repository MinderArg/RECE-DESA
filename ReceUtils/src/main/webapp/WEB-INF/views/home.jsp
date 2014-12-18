<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
<body> 
<h2>Hello Lucas Ponce de!</h2>
<p>Hora:        <c:out value="${model.now}"/></p>
<p>Util:        <c:out value="${model.util}"/></p>


<div>
<a href="signer.htm">SIGNER</a> 
<br/> 
<a href="qrgen.htm">QR GENERATOR</a>
</div>

</body>
</html>

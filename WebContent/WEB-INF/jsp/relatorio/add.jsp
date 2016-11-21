<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	response.setContentType("application/vnd.ms-excel");
	response.setHeader("Content-Disposition", "inline; filename=" + "excel.xls");
%>

<table>
	<thead>
		<tr>
			<th>Rede</th>
			<th>Motivo de Suporte</th>
			<th>Defeito Encontrado</th>
			<th>Solu��o</th>
			<th>Login Operador</th>
			<th>Login Registro</th>
			<th>Terminal</th>
			<th>Data</th>
			<th>Observa��o</th>
			<th>Nome Operador</th>
			<th>Gestor Imediato</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${atendimentos}" var="at">
			<tr class="leline">
				<td>${at.solucao.motivo.macroMotivo.rede.nome}</td>
				<td>${at.solucao.motivo.macroMotivo.nome}</td>
				<td>${at.solucao.motivo.nome}</td>
				<td>${at.solucao.nome}</td>
				<td>${at.loginOperador}</td>
				<td>${at.loginRegistro}</td>
				<td>${at.terminal}</td>
				<td><fmt:formatDate type="both" dateStyle="short"
						timeStyle="short" value="${at.dataRegistro}" /></td>
				<td>${at.observacao}</td>
				<c:forEach items="${colaboradores}" var="col">
					<c:if test="${col.matricula == at.loginOperador}">
						<td>${col.nome}</td>
						<td>${col.supervisor}</td>	
					</c:if>
				</c:forEach>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
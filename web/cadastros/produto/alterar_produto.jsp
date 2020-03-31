<%-- 
    Document   : alterar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : KaOs
--%>

<%@page import="modelo.Produto"%>
<%@page import="modelo.Situacao"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.Departamento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
    </head>
    <body>
        <%
            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("objProduto"); //aqui pega o objeto produto que esta na sessão
        %>
        <form action="/padraocommand/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Alterar"/>
            <div>
                <label>Descrição: </label>
                <input type="text" name="txtdescricao" id="descricao" value="<%= objproduto.getDescricao()%>"/>
            </div>
            <div>
                <label>Quantidade: </label>
                <input type="text" name="txtquantidade" id="descricao" value="<%= objproduto.getQuantidade()%>"/>
            </div>
            <div>
                <label>Situação: </label>
                <select name="cmbsituacao" id="cmbsituacao"/>
                <c:forEach var="situacao" items="${arrsituacao}">
                    <c:if test="${objProduto.getSituacao().getId() eq situacao.id}">
                        <option value="${situacao.id}" selected="selected">${situacao.descricao}</option>
                    </c:if>
                    <c:if test="${objProduto.getSituacao().getId() != situacao.id}">
                        <option value="${situacao.id}">${situacao.descricao}</option>   
                    </c:if>    
                </c:forEach>
                </select>
            </div>
            <div>
                <label>Departamento:  </label>
                <select name="cmbdepartamento" id="cmbdepartamento" onchange="this.form.submit();"/>
                <c:forEach var="departamento" items="${arrdepartamento}">
                    <c:if test="${objProduto.getDepartamento().getId() eq departamento.id}">
                        <option value="${departamento.id}" selected="selected">${departamento.descricao}</option>
                    </c:if>
                    <c:if test="${objProduto.getDepartamento().getId() != departamento.id}">
                        <option value="${departamento.id}">${departamento.descricao}</option>   
                    </c:if>        
                </c:forEach>
                </select>
            </div>
            <div>
                <label>Tipo:  </label>
                <select name="cmbtipo" id="cmbtipo"/>
                <c:forEach var="tipo" items="${arrtipo}">
                    <c:if test="${objProduto.getTipo().getId() eq tipo.id}">
                        <option value="${tipo.id}" selected="selected">${tipo.descricao}</option>
                    </c:if>
                    <c:if test="${objProduto.getTipo().getId() != tipo.id}">
                        <option value="${tipo.id}">${tipo.descricao}</option>   
                    </c:if>                    
                </c:forEach>
                </select>
            </div>
            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>

        </form>

    </body>
</html>

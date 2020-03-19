<%-- 
    Document   : alterar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Produto"%>
<%@page import="modelo.Situacao"%>
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
            objproduto = (Produto) request.getSession().getAttribute("produto"); //aqui pega o objeto produto que esta na sessão

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
                        <option value="${situacao.id}">${situacao.descricao}</option>                      
                    </c:forEach>
                </select>
            </div>
            <div>
                <input type="submit" name="btnalterar" id="btnalterar" value="Alterar"/>   
            </div>

        </form>

    </body>
</html>

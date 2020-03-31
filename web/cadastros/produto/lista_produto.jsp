<%-- 
    Document   : lista_produto
    Created on : 15/04/2019, 19:56:06
    Author     : KaOs
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page import="modelo.Situacao"%>
<%@page import="modelo.Departamento"%>
<%@page import="modelo.Tipo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        <a href="ControleProduto?acao=Cadastrar">Novo</a>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descrição</th>
                     <th>Quantidade</th>
                    <th>Situação</th>
                    <th>Departamento</th>
                     <th>Tipo</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Produto> arrproduto = new ArrayList<Produto>();
                    arrproduto = (ArrayList<Produto>) request.getSession().getAttribute("arrproduto");
                    for (Produto obj : arrproduto) {
                %>
                <tr>
                    <td> <%= obj.getId()%></td>
                    <td> <%= obj.getDescricao()%></td>
                    <td> <%= obj.getQuantidade()%></td>
                    <td> <%= obj.getSituacao().getDescricao()%></td>
                    <td> <%= obj.getDepartamento().getDescricao()%></td>
                    <td> <%= obj.getTipo().getDescricao()%></td>
                    <td>
                        <a href="ControleProduto?acao=Buscar&id=<%= obj.getId()%>">Alterar</a>
                        <a href="ControleProduto?acao=Consultar&id=<%= obj.getId()%>">Consultar</a>
                        <a href="ControleProduto?acao=Excluir&id=<%= obj.getId()%>">Excluir</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

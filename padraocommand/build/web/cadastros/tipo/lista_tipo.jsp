<%-- 
    Document   : lista_tipo
    Created on : 15/04/2019, 19:56:06
    Author     : alunocmc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo</title>
    </head>
    <body>
        <h1>Lista de Tipos</h1>
        <a href="ControleTipo?acao=Cadastrar">Novo</a>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Descrição</th>
                    <th>Operações</th>
                </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();
                arrtipo = (ArrayList<Tipo>) request.getSession().getAttribute("arrtipo");
                for (Tipo obj : arrtipo) {
            %>
             <tr>
                    <td> <%= obj.getId()%></td>
                    <td> <%= obj.getDescricao()%></td>
                    <td>
                        <a href="ControleTipo?acao=Buscar&id=<%= obj.getId()%>">Alterar</a>
                        <a href="ControleTipo?acao=Consultar&id=<%= obj.getId()%>">Consultar</a>
                        <a href="ControleTipo?acao=Excluir&id=<%= obj.getId()%>">Excluir</a>
                    </td>
                </tr>
           
            
                <%
                }
            %>
            </tbody>
        </table>
    </body>
</html>

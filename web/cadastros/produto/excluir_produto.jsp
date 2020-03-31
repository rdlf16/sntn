<%-- 
    Document   : excluir_produto
    Created on : 16/04/2019, 19:11:05
    Author     : KaOs
--%>

<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir</title>
    </head>
    <body>

        <%

            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("produto"); //aqui pega o objeto produto que esta na sessão

        %>

        <form action="/padraocommand/ControleProduto" method="POST">
            <input type="hidden" name="id" id="id" value="<%= objproduto.getId()%>"/>
            <input type="hidden" name="acao" id="acao" value="Excluir"/>
            <input type="hidden" name="confirmaexclusao" id="confirmaexclusao" value="2"/>
            <h1>Confirma a exclusão definitiva do registro abaixo?</h1>
            <div>
                <label>Descrição</label>
                <label><b><%= objproduto.getDescricao()%></b></label>
            </div>

            <div>
                <input type="submit" name="btnconfirma" id="btnconfirma" value="Confirma"/>   
            </div>

        </form>

    </body>
</html>

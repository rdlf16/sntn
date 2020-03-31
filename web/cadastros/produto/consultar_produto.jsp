<%-- 
    Document   : consultar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : KaOs
--%>

<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
    </head>
    <body>

        <%

            Produto objproduto = new Produto();
            objproduto = (Produto) request.getSession().getAttribute("objProduto"); //aqui pega o objeto produto que esta na sessão

        %>

        <form>

            <div>
                <label>Descrição: </label>
                <label><b><%= objproduto.getDescricao()%></b></label>
            </div>     
            <div>
                <label>Quantidade: </label>
                <label><b><%= objproduto.getQuantidade()%></b></label>
            </div>     
            <div>
                <label>Situação: </label>
                <label><b><%= objproduto.getSituacao().getDescricao()%></b></label>
            </div>
             <div>
                <label>Departamento: </label>
                <label><b><%= objproduto.getDepartamento().getDescricao()%></b></label>
            </div>  
             <div>
                <label>Tipo: </label>
                <label><b><%= objproduto.getTipo().getDescricao()%></b></label>
            </div>  

        </form>
        <a href="ControleProduto?acao=Listar">Listar</a>

    </body>
</html>

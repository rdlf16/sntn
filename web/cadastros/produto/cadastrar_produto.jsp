<%-- 
    Document   : alterar_tipo
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>


        <form action="/padraocommand/ControleProduto" method="POST">
        
            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>

            <div>
                <label>Descrição: </label>
                <input type="text" name="txtdescricao" id="txtdescricao" value=""/>
            </div>
             <div>
                <label>Quantidade: </label>
                <input type="text" name="txtquantidade" id="txtquantidade" value=""/>
            </div>
            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>   
            </div>

        </form>

    </body>
</html>

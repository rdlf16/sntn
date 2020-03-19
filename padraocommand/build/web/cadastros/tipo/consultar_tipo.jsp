<%-- 
    Document   : alterar_tipo
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>

<%@page import="modelo.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%

            Tipo objtipo = new Tipo();
            objtipo = (Tipo) request.getSession().getAttribute("tipo"); //aqui pega o objeto tipo que esta na sessão

        %>

        <form>
          
            <div>
                <label>Descrição</label>
                <lable><b><%= objtipo.getDescricao()%></b></lable>
            </div>           

        </form>

    </body>
</html>

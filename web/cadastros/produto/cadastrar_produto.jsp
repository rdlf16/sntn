<%-- 
    Document   : cadastrar_produto
    Created on : 16/04/2019, 19:11:05
    Author     : KaOs
--%>

<%@page import="modelo.Produto"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.Departamento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <%
            Produto objProduto = new Produto();
            try {
                objProduto = (Produto) request.getSession().getAttribute("objProduto"); //aqui pega o objeto produto que esta na sessão
            } catch (Exception ex) {

            }
        %>
    </head>
    <body>
        <form action="/padraocommand/ControleProduto" method="POST">

            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>

            <div>
                <label>Descrição: </label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="${objProduto.getDescricao()}"/>
            </div>
            <div>
                <label>Quantidade: </label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="${objProduto.getQuantidade()}"/>
            </div>
            <div>
                <label>Departamento:  </label>
                <select name="cmbdepartamento" id="cmbdepartamento" onchange="this.form.submit();"/>
                <option value="0" selected="selected">Selecione um Departamento</option>
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
                <option value="0" selected="selected">Selecione um Tipo</option>
                <c:forEach var="tipo" items="${arrtipo}">
                    <option value="${tipo.id}">${tipo.descricao}</option>                      
                </c:forEach>
                </select>
            </div>
            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>   
            </div>

        </form>

    </body>
</html>

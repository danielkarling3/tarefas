<%-- 
    Document   : dataFinalizada
    Created on : 19/06/2016, 14:45:26
    Author     : danielkarling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


    <td>${tarefa.id}</td>
    <td>${tarefa.descricao}</td>
    <td>Finalizada</td>
    <td>
        <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
    </td>
    <td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
    <td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>


    <script type="text/javascript">
        function finalizaAgora(id) {
            $.post("finalizaTarefa", {'id': id}, function (resposta) {
                $("#tarefa_" + id).html("Finalizado");
                $("#tarefa_data_" + id).html(resposta);
                alert(resposta);
            });
        }
    </script>





</body>
</html>

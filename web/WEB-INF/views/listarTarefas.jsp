<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Contatos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>

        <%
            String idS = request.getParameter("tarefas");
        %>
        <br>
        <br>

        <div class="container"> 
            <div class="panel panel-info">
                <div class="panel-heading"> 
                    <center>Lista de Contatos</center>
                </div> 
                <div class="panel-info"> 

                    <table class="table"> 

                        <tr> 
                            <td>ID:</td>
                            <td>Descrioção:</td> 

                            <td>Data de Finalização:</td> 

                        </tr> 

                        <c:forEach items="${tarefas}" var="tarefa">
                            <tr>
                                <td>${tarefa.id}</td>
                                <td>${tarefa.descricao}</td>
                                <c:if test="${tarefa.finalizado eq false}">
                                    <td>Não finalizado</td>
                                </c:if>
                                <c:if test="${tarefa.finalizado eq true}">
                                    <td>Finalizado</td>
                                </c:if>
                                <td>
                                    <fmt:formatDate 
                                        value="${tarefa.dataFinalizacao.time}" 
                                        pattern="dd/MM/yyyy"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table> 


                    <center>
                        <button align="center" class="btn btn-info" 
                                onclick="window.location.href = 'novaTarefa';"> 
                            Adicionar Tarefa</button> 
                    </center>
                </div>
            </div>
        </div> 
    </div> 
</div>

</body>
</html>
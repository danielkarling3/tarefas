<%-- 
    Document   : formulario
    Created on : 28/05/2016, 21:30:31
    Author     : danielkarling
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h3>Adicionar tarefas</h3>
        <form action="alteraTarefa" method="post">
            
            
            <input type="hidden" name="id" value="${tarefa.id}"/>
            <br />
            
            Descrição: <br />
            
            <textarea name="descricao" rows="5" cols="100"> ${tarefa.descricao}</textarea><br />
            <br>
            Finalizado? <br />
            <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado ? 'checked' : ''}/>
            <br>
            Data de Finalização: <br />
     
            <input type="text" name="dataFinalizacao"
                   value = "<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>"/>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>

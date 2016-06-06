<%-- 
    Document   : formulario
    Created on : 28/05/2016, 21:30:31
    Author     : danielkarling
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <body>
    <h3>Adicionar tarefas</h3>
    <form action="adicionaTarefa" method="post">
      Descrição: <br />
      <textarea name="descricao" rows="5" cols="100"></textarea><br />
      <br>
      <form:errors path ="tarefa.descricao" cssStyle ="color:red"/>  
      <br>
      <br>
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>

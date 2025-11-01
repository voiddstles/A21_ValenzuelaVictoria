<%-- 
    Document   : listado
    Created on : Oct 30, 2025, 12:08:26 PM
    Author     : victoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Pokedex</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Mi Pokedex</h1>
                <a href="index.jsp" class="btn-back">Registrar otro</a>
            </header>
            
            <main>
                <table class="pokedex-table">
                    <thead>
                        <tr>
                            <th>Imagen</th>
                            <th>Numero</th>
                            <th>Nombre</th>
                            <th>Tipo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pokemon" items="${sessionScope.pokedex}">
                            <tr>
                                <td>
                                    <img src="${pokemon.imageUrl}" alt="imagen de pokemon" class="pokemon-image"
                                </td>
                                <td>#${pokemon.numero}</td>
                                <td>${pokemon.nombre}</td>
                                <td>${pokemon.tipo}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
        </div>
    </body>
</html>

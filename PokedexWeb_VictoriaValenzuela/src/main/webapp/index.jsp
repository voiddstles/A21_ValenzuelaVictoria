<%-- 
    Document   : index
    Created on : Oct 30, 2025, 12:08:18 PM
    Author     : victoria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Pokemon</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Pokedex Web</h1>
                <p>Registra un nuevo pokemon</p>
            </header>
            
            <main>
                <form action="PokedexServlet" method="POST" class="pokemon-form">
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" id="nombre" name="nombre" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="numero">Numero:</label>
                        <input type="number" id="numero" name="numero" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="tipo">Tipo:</label>
                        <input type="text" id="tipo" name="tipo" placeholder="Aqui se pone el tipo de pokemon que es" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="imageUrl">URL de imagen:</label>
                        <input type="url" id="imageUrl" name="imageUrl" placeholder="https://imagen.com" required>
                    </div>
                    
                    <button type="submit" class="btn-submit">Registrar Pokemon</button>
            </main>
        </div>
    </body>
</html>


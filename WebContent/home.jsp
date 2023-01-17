<%@page import="model.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    <title>Foster's Hollywood</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
    <!-- Mi CSS -->
    <link rel="stylesheet" href="css/mycss.css"/>
	</head>
	
	<% 
		ArrayList<Categoria> listacategorias = (ArrayList<Categoria>) session.getAttribute("listacategorias");
		int pantalla = (int) session.getAttribute("pantalla");
	%>
	
    <body>

    <div id="maincontainer" class="container p-0"   	
    	<% 
    		if (pantalla == 2) { 
    			String fondo = (String) session.getAttribute("fondo");
    	%>
    		style="background-image: url(<%=fondo%>); background-size: cover; background-repeat: no-repeat;"
    	<%}%>>

        <!-- CAROUSSEL -->
        <div id="carouselId" class="carousel slide" data-ride="carousel">

            <!-- Logo -->
            <img src="img/logo.png" alt="logo fosters hollywood"/>

            <ol class="carousel-indicators">
                <li data-target="#carouselId" data-slide-to="0" class="active"></li>
                <li data-target="#carouselId" data-slide-to="1"></li>
                <li data-target="#carouselId" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img src="img/slider1.png" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img src="img/slider2.png" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img src="img/slider3.png" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselId" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselId" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- CAROUSSEL -->


        <!-- Pon un if aqui­ que elija que tipo de card mostrar... -->
        
        <% 
        	if (pantalla == 0) {
        %>
        
        <!-- CARDS CATEGORIAS -->
        <div id="categorias" class="row mx-3 my-5">

			<% for (Categoria categoria : listacategorias) { %>
			
            <div class="col-12 col-md-6 col-lg-4 mb-4">
	            <div class="card">
	                <div class="card-body" >
	                	<a href="Controller?op=dameproductos&categoriaid=<%=categoria.getId()%>">
                            <img class="my-3" src="img/<%=categoria.getNombre()%>.png" alt="<%=categoria.getNombre()%>"/>
	                	</a>
	                	<h4 class="card-title text-center"><%=categoria.getNombre().toUpperCase()%></h4>
	                </div>
	            </div>
            </div>
            
            <%} %>

        </div>
        <!-- CARDS CATEGORIAS -->
        
        <%
        	} else if (pantalla == 1) {
        		ArrayList<Producto> listaproductos = (ArrayList<Producto>) request.getAttribute("listaproductos");
		%>
        
        <!-- CARDS PRODUCTOS -->
        <div id="productos" class="row mx-3 my-5">
        
        	<% 
        		if (listaproductos != null) {
        			for (Producto producto : listaproductos) { 
        	%>

            <div class="col-12 col-md-6 col-lg-4 mb-4">
                <div class="card">
                    <div class="card-body">
                    	<a href="Controller?op=dameproducto&idproducto=<%=producto.getId()%>">
                    		<img class="my-3" src="<%=producto.getImagen()%>" alt="<%=producto.getTitulo()%>"/>
                    	</a>
                        <h4 class="card-title text-center"><%=producto.getTitulo().toUpperCase()%></h4>
                    </div>
                </div>
            </div>
            
            <%}}%>

        </div>
        <!-- CARDS PRODUCTOS -->
        
        <%
        	} else if (pantalla == 2) {
        		Producto producto = (Producto) request.getAttribute("producto");
        %>

        <!-- CARD PRODUCTO -->
        <div id="producto" class="row my-5">

            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                    
                    	<%
                    		Integer puntuacion = (Integer) request.getAttribute("puntuacion");
                    		if (puntuacion != null) {
                    	%>
                    	
                    	<!-- PUNTUACION MEDIA PRODUCTO -->
                    	<p class="text-center m-0 p-0">
	                        <span class="puntuacion">
								
								<% for (int i=0; i<puntuacion; i++) { %>	
								<span>&#9733;</span>
								<%} %>
								
							</span>
                        </p>
                        
                        <%} %>
                    
                        <img class="my-5" src="<%=producto.getImagen()%>" alt="<%=producto.getTitulo()%>"/>
                        <h4 class="card-title text-center"><%=producto.getTitulo().toUpperCase()%></h4>
                        <p class="card-text text-center"><%=producto.getSumario()%></p>
                        
                        <!--  RATING ESTRELLAS	 PRODUCTO -->
                        <p class="text-center">
	                        <span class="rating">
								<a href="Controller?op=rating&puntos=1&idproducto=<%=producto.getId()%>">&#9733;</a>
								<a href="Controller?op=rating&puntos=2&idproducto=<%=producto.getId()%>">&#9733;</a>
								<a href="Controller?op=rating&puntos=3&idproducto=<%=producto.getId()%>">&#9733;</a>
								<a href="Controller?op=rating&puntos=4&idproducto=<%=producto.getId()%>">&#9733;</a>
								<a href="Controller?op=rating&puntos=5&idproducto=<%=producto.getId()%>">&#9733;</a>
							</span>
                        </p>
                        <!-- RATING PRODUCTO -->
                        
                    </div>
                </div>
            </div>

        </div>
        <!-- CARD PRODUCTO -->
		
		<%} %>

        <!-- FOOTER -->
        <footer class="page-footer font-small blue">
            <!-- Copyright -->
            <h2 class="text-center py-4 mb-0">FOSTER'S HOLLYWOOD</h2>
        </footer>
        <!-- FOOTER -->

    </div>
        
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DAOCategoria;
import daos.DAOProducto;
import daos.DAOPunto;
import model.Categoria;
import model.Producto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String op = request.getParameter("op"); 
		RequestDispatcher dispatcher;
		
		if (op.equals("inicio")) {
			
			//Subimos datos a la sesión (desde los daos)
			//('session' guarda los datos de manera permanente)
			ArrayList<Categoria> listacategorias = new DAOCategoria().getCategorias();
			session.setAttribute("listacategorias", listacategorias);
			session.setAttribute("pantalla", 0);
			
			//Refrescamos la vista (la página) con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);	
			
		} else if (op.equals("dameproductos")) {
			
			int categoriaid = Integer.valueOf(request.getParameter("categoriaid"));
			ArrayList<Producto> listaproductos = new DAOProducto().getProductosByCategoria(categoriaid);
			
			request.setAttribute("listaproductos", listaproductos);
			session.setAttribute("pantalla", 1);
			
			//Refrescamos la vista (la página) con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		} else if (op.equals("dameproducto")) {
			
			int idproducto = Integer.valueOf(request.getParameter("idproducto"));
			Producto producto = new DAOProducto().getProductoById(idproducto);
			Integer puntuacion = new DAOPunto().getPuntosByProducto(idproducto);
			
			request.setAttribute("puntuacion", puntuacion);
			request.setAttribute("producto", producto);
			session.setAttribute("pantalla", 2);
			session.setAttribute("fondo", producto.getFondo());
			
			//Refrescamos la vista (la página) con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		} else if (op.equals("rating")) {
			
			int idproducto = Integer.valueOf(request.getParameter("idproducto"));
			int puntos = Integer.valueOf(request.getParameter("puntos"));
			new DAOPunto().insertPuntos(idproducto, puntos);
			
			Producto producto = new DAOProducto().getProductoById(idproducto);
			Integer puntuacion = new DAOPunto().getPuntosByProducto(idproducto);
			
			request.setAttribute("puntuacion", puntuacion);
			request.setAttribute("producto", producto);
			session.setAttribute("pantalla", 2);
			session.setAttribute("fondo", producto.getFondo());
			
			//Refrescamos la vista (la página) con los nuevos datos de la sesión
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

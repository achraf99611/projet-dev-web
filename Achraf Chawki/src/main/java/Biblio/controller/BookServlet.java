package Biblio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Biblio.dao.BookDao;
import Biblio.model.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/registerb")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookDao bookdao = new BookDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bookregister.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		
		Book book = new Book();
		
		book.setAuthor(author);
		book.setTitle(title);
		book.setCategory(category);
		
		
		try {
			bookdao.registrybook(book);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bookdetails.jsp");
		dispatcher.forward(request, response);
	}

}

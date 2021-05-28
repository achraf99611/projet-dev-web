package Biblio.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Biblio.model.Login;
import Biblio.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LoginDao loginDao;
       
       public void init() {
    	   
    	   loginDao= new LoginDao() ;
       }
       
       
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		response.getWriter().append("Served at: ").append(request.getContextPath());
   		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
   	}
       
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		    throws ServletException, IOException {

    		        String username = request.getParameter("username");
    		        String password = request.getParameter("password");
    		        Login login = new Login();
    		        login.setUsername(username);
    		        login.setPassword(password);

    		        try {
    		            if (loginDao.validate(login)) {
    		            	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/loginsuccess.jsp");  
    		                rd.forward(request,response);  
    		            } else {
    		                HttpSession session = request.getSession();
    		                RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/login.jsp");  
    		                rd.forward(request,response); 
    		            }
    		        } catch (ClassNotFoundException e) {
    		            e.printStackTrace();
    		        } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		    }
    		}
package leapacademyquiz.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.model.LoginDataModel;

/**
 * Servlet implementation class signup
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDataModel lm = new LoginDataModel();
		LoginDAO loginDAO = new LoginDAO();
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("psw");
		String cnfpass = request.getParameter("cnfpsw");
		
		if(pass.equals(cnfpass)) {
			try {
				if(loginDAO.loginCheck(uname, pass)) {
					response.sendRedirect("userexists.jsp");
				}
				else {
					lm.username = uname;
					lm.password = pass;
					loginDAO.addLoginDetails(lm);
					
					request.setAttribute("username", uname);
					request.getRequestDispatcher("/registrationpage.jsp").forward(request, response);
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("passwordnotmatched.jsp");
		}
	}
}

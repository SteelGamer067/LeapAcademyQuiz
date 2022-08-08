package leapacademyquiz.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.model.StudentDataModel;

/**
 * Servlet implementation class registrationpage
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDataModel sm = new StudentDataModel();
		
		sm.firstName = request.getParameter("fname");
		sm.lastName = request.getParameter("lname");
		sm.fatherName = request.getParameter("faname");
		sm.emailID = request.getParameter("email");
		sm.dob = request.getParameter("dob");
		/*try {
			sm.dob = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}*/
		sm.address = request.getParameter("address");
		sm.city = request.getParameter("city");
		sm.state = request.getParameter("state");
		sm.pincode = request.getParameter("pin");
		sm.username = request.getParameter("username");
		
		LoginDAO loginDAO = new LoginDAO();
		try {
			loginDAO.addStudentDetails(sm);
			response.sendRedirect("login.jsp");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
package leapacademyquiz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.model.CourseDataModel;

/**
 * Servlet implementation class CourseRegisterServlet
 */
@WebServlet("/CourseRegisterServlet")
public class CourseRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRegisterServlet() {
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
		LoginDAO loginDAO = new LoginDAO();
		CourseDataModel courseModel = new CourseDataModel();
		
		String username = request.getParameter("username");
		String courseID = request.getParameter("courses");
		
		try {
			String courseName = loginDAO.getCoursebyID(courseID);
			
			courseModel.setCourseID(courseID);
			courseModel.setCourseName(courseName);
			courseModel.setUsername(username);
			
			if(loginDAO.isCourseRegistered(courseModel)) response.sendRedirect("courseregistered.jsp");
			else {
				loginDAO.addCourses(courseModel);
				response.sendRedirect("userhomepage.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

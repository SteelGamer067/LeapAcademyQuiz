package leapacademyquiz.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.model.CourseModel;

/**
 * Servlet implementation class ExamSelectServlet
 */
@WebServlet("/ExamSelectServlet")
public class ExamSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamSelectServlet() {
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
		
		String username = request.getParameter("username");
		
		try {
			ResultSet rs = loginDAO.getRegisteredCourses(username);
			ArrayList<CourseModel> courses = new ArrayList<>();
			while(rs.next()) {
				if(!rs.getBoolean("examattended")) {
					CourseModel course = new CourseModel();
					course.setCourseID(rs.getString("courseID"));
					course.setCourseName(rs.getString("courseName"));
					courses.add(course);
				}
			}
			
			if(courses.isEmpty()) response.sendRedirect("examsnotfound.jsp");
			
			request.setAttribute("courseList", courses);
			request.getRequestDispatcher("/selectcourseexam.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

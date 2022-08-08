package leapacademyquiz.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.service.QuestionPaperService;

/**
 * Servlet implementation class CourseSelectServlet
 */
@WebServlet("/CourseSelectServlet")
public class CourseSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSelectServlet() {
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
		QuestionPaperService qpService = new QuestionPaperService();
		LoginDAO loginDAO = new LoginDAO();
		
		String courseID = request.getParameter("courses");
		
		try {
			String courseName = loginDAO.getCoursebyID(courseID);
			qpService.getAnswerKey(courseID);
			request.setAttribute("questionPaper", qpService.getQuestionPaper(courseID));
			request.setAttribute("courseID", courseName);
			request.getRequestDispatcher("/questionpaper.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

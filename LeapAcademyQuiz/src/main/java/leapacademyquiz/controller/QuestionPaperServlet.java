package leapacademyquiz.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import leapacademyquiz.dal.LoginDAO;
import leapacademyquiz.model.AnswerKeyModel;
import leapacademyquiz.model.CourseDataModel;
import leapacademyquiz.model.QuestionPaperModel;
import leapacademyquiz.service.QuestionPaperService;
import leapacademyquiz.utilities.ScoreCalculator;

/**
 * Servlet implementation class questionpaper
 */
@WebServlet("/QuestionPaperServlet")
public class QuestionPaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionPaperServlet() {
        super();
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
		LoginDAO loginDAO = new LoginDAO();
		CourseDataModel courseData = new CourseDataModel();
		ArrayList<QuestionPaperModel> qp = QuestionPaperService.qPaper;
		ArrayList<AnswerKeyModel> ans = QuestionPaperService.answers;
		float totalScore = 0.0f;
		
		String username = request.getParameter("username");
		String courseID = request.getParameter("courseID");
		
		for(int i = 0; i < qp.size(); i++) {
			ArrayList<Boolean> choices = new ArrayList<>();
			choices.add(getBooleanFromString(request.getParameter("chkbx_"+qp.get(i).getQuestionNo()+"A")));
			choices.add(getBooleanFromString(request.getParameter("chkbx_"+qp.get(i).getQuestionNo()+"B")));
			choices.add(getBooleanFromString(request.getParameter("chkbx_"+qp.get(i).getQuestionNo()+"C")));
			choices.add(getBooleanFromString(request.getParameter("chkbx_"+qp.get(i).getQuestionNo()+"D")));
			
			ArrayList<Boolean> answers = new ArrayList<>();
			answers.add(ans.get(i).optA);
			answers.add(ans.get(i).optB);
			answers.add(ans.get(i).optC);
			answers.add(ans.get(i).optD);
			
			ScoreCalculator sc = new ScoreCalculator();
			float questionScore = sc.calculateQuestionScore(choices, answers, qp.get(i).getCorrectAnswers());
			totalScore += questionScore;
		}
		
		try {
			courseData.setCourseID(courseID);
			courseData.setExamattended(true);
			courseData.setScore(totalScore);
			courseData.setUsername(username);
			
			loginDAO.examAttended(courseData);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(totalScore);
		request.setAttribute("score", totalScore);
		request.getRequestDispatcher("/displayscore.jsp").forward(request, response);
	}
	
	private boolean getBooleanFromString(String input) {
		if(input == null) return false;
		else return true;
	}
}

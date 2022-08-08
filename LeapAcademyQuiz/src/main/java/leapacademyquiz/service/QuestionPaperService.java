package leapacademyquiz.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import leapacademyquiz.dal.LeapAcademyQuizDAO;
import leapacademyquiz.model.AnswerKeyModel;
import leapacademyquiz.model.QuestionPaperModel;

public class QuestionPaperService {
	LeapAcademyQuizDAO laqDAO = new LeapAcademyQuizDAO();
	public static ArrayList<QuestionPaperModel> qPaper = new ArrayList<>();
	public static ArrayList<AnswerKeyModel> answers = new ArrayList<>();
	ResultSet result;
	
	public ArrayList<QuestionPaperModel> getQuestionPaper(String id) throws ClassNotFoundException, SQLException {
		result = laqDAO.getQuestionDetails(id);
		ArrayList<QuestionPaperModel> questionPaper = new ArrayList<>();
		int i = 1;
		while(result.next()) {
			QuestionPaperModel question = new QuestionPaperModel();
			question.questionNo = i;
			question.correctAnswers = result.getInt("correctanswers");
			question.question = result.getString("question");
			question.optionA = result.getString("optionA");
			question.optionB = result.getString("optionB");
			question.optionC = result.getString("optionC");
			question.optionD = result.getString("optionD");
			questionPaper.add(question);
			i++;
		}
		qPaper = questionPaper;
		return questionPaper;
	}
	
	public void getAnswerKey(String id) throws ClassNotFoundException, SQLException {
		result = laqDAO.getQuestionDetails(id);
		ArrayList<AnswerKeyModel> ansKey = new ArrayList<>();
		while(result.next()) {
			AnswerKeyModel answer = new AnswerKeyModel();
			answer.optA = result.getBoolean("isOptionA");
			answer.optB = result.getBoolean("isOptionB");
			answer.optC = result.getBoolean("isOptionC");
			answer.optD = result.getBoolean("isOptionD");
			ansKey.add(answer);
		}
		answers = ansKey;
	}
}
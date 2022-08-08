package leapacademyquiz.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import leapacademyquiz.utilities.DBConnectionUtility;

public class LeapAcademyQuizDAO {
	Connection con;
	Statement statement;
	PreparedStatement pst;
	ResultSet result;
	
	public ResultSet getQuestionDetails(String id) throws ClassNotFoundException, SQLException {
		String query = "Select * from LeapAcademyDB."+id+"QuestionPaper;";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result;
	}
	
	public ResultSet getCourses() throws ClassNotFoundException, SQLException{
		String query = "Select * from LeapAcademyDB.Courses;";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result;
	}
	
	private void clearData() {
		statement = null;
		pst = null;
		result = null;
	}
}

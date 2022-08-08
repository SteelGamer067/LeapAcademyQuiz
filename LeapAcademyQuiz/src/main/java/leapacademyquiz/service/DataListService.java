package leapacademyquiz.service;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import leapacademyquiz.dal.*;
import leapacademyquiz.model.CourseModel;
import leapacademyquiz.model.StudentDataModel;

public class DataListService {

	DemographicsDAO demDAO = new DemographicsDAO();
	LeapAcademyQuizDAO laqDAO = new LeapAcademyQuizDAO();
	LoginDAO loginDAO = new LoginDAO();
	ResultSet result;
	
	public ArrayList<String> getCities() throws ClassNotFoundException, SQLException {
		ArrayList<String> cityList = new ArrayList<>();
		result = demDAO.getCities();
		while(result.next()) cityList.add(result.getString("cityName"));
		return cityList;
	}
	
	public ArrayList<String> getStates() throws ClassNotFoundException, SQLException {
		ArrayList<String> stateList = new ArrayList<>();
		result = demDAO.getStates();
		while(result.next()) stateList.add(result.getString("stateName"));
		return stateList;
	}
	
	public ArrayList<CourseModel> getCourses() throws ClassNotFoundException, SQLException {
		ArrayList<CourseModel> courseList = new ArrayList<>();
		result = laqDAO.getCourses();
		while(result.next()) {
			CourseModel course = new CourseModel();
			course.setCourseID(result.getString("courseID"));
			course.setCourseName(result.getString("courseName"));
			courseList.add(course);
		}
		return courseList;
	}
	
	public StudentDataModel getStudentDetails(String username) throws ClassNotFoundException, SQLException {
		StudentDataModel student = new StudentDataModel();
		student = loginDAO.getStudentDetails(username);
		return student;
	}
}

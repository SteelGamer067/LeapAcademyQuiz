package leapacademyquiz.dal;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import leapacademyquiz.model.CourseDataModel;
import leapacademyquiz.model.LoginDataModel;
import leapacademyquiz.model.StudentDataModel;
import leapacademyquiz.security.PasswordSecurity;
import leapacademyquiz.utilities.DBConnectionUtility;

public class LoginDAO {
	PasswordSecurity ed = new PasswordSecurity();
	Connection con;
	Statement statement;
	PreparedStatement pst;
	ResultSet result;
	
	public boolean loginCheck(String uname, String pass) throws ClassNotFoundException, SQLException {
		String query = "Select password from LoginDetailsDB.LoginDetails where username='"+uname+"';";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result.next();
	}
	
	public boolean usernameExists(String uname) throws ClassNotFoundException, SQLException {
		String query = "Select * from LoginDetailsDB.LoginDetails where username='"+uname+"';";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result.next();
	}
	
	public void addLoginDetails(LoginDataModel lm) throws ClassNotFoundException, SQLException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
		if(usernameExists(lm.username)) {
			System.out.println("Username Exists");
			return;
		}
		
		String query = "Insert into LoginDetailsDB.LoginDetails(username, password) values(?,?);";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		pst = con.prepareStatement(query);
		
		pst.setString(1, lm.username);
		pst.setString(2, lm.password);
		pst.executeUpdate();
	}
	
	public void addStudentDetails(StudentDataModel sm) throws ClassNotFoundException, SQLException {
		String query = "Insert into LoginDetailsDB.StudentDetails(firstname,lastname,fathername,dob,emailid,address,city,state,pincode,username) values(?,?,?,?,?,?,?,?,?,?);";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		pst = con.prepareStatement(query);
		
		pst.setString(1, sm.firstName);
		pst.setString(2, sm.lastName);
		pst.setString(3, sm.fatherName);
		pst.setString(4, sm.dob);
		pst.setString(5, sm.emailID);
		pst.setString(6, sm.address);
		pst.setString(7, sm.city);
		pst.setString(8, sm.state);
		pst.setString(9, sm.pincode);
		pst.setString(10, sm.username);
		pst.executeUpdate();
	}
	
	public boolean isCourseRegistered(CourseDataModel course) throws ClassNotFoundException, SQLException {
		String query = "Select * from LoginDetailsDB.SelectedCourses where username='"+course.getUsername()+"' and courseID='"+course.getCourseID()+"';";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result.next();
	}
	
	public void addCourses(CourseDataModel course) throws ClassNotFoundException, SQLException {
		String query = "Insert into LoginDetailsDB.SelectedCourses(courseID,courseName,username) values(?,?,?);";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		pst = con.prepareStatement(query);
		
		pst.setString(1, course.getCourseID());
		pst.setString(2, course.getCourseName());
		pst.setString(3, course.getUsername());
		pst.executeUpdate();
	}
	
	public String getCoursebyID(String id) throws ClassNotFoundException, SQLException {
		String query = "Select courseName from LeapAcademyDB.Courses where courseID='"+id+"';";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		result.next();
		return result.getString("courseName");
	}
	
	public ResultSet getRegisteredCourses(String username) throws ClassNotFoundException, SQLException {
		String query = "Select * from LoginDetailsDB.SelectedCourses where username='"+username+"';";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		return result;
	}
	
	public StudentDataModel getStudentDetails(String username) throws ClassNotFoundException, SQLException {
		String query = "Select * from LoginDetailsDB.StudentDetails where username='"+username+"';";
		StudentDataModel student = new StudentDataModel();
		
		clearData();
		con = DBConnectionUtility.getConnection();
		statement = con.createStatement();
		result = statement.executeQuery(query);
		if(result.next()) {
			student.setFirstName(result.getString("firstname"));
			student.setLastName(result.getString("lastname"));
			student.setFatherName(result.getString("fathername"));
			student.setDob(result.getString("dob"));
			student.setEmailID(result.getString("emailid"));
			student.setAddress(result.getString("address"));
			student.setCity(result.getString("city"));
			student.setState(result.getString("state"));
			student.setPincode(result.getString("pincode"));
			return student;
		}
		else {
			return student;
		}
	}
	
	public void examAttended(CourseDataModel course) throws ClassNotFoundException, SQLException {
		String query = "Update LoginDetailsDB.SelectedCourses"+
					   "Set examattended=true,score=?"+
					   "where username=? and courseID=?;";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		pst = con.prepareStatement(query);
		
		pst.setFloat(1, course.getScore());
		pst.setString(2, course.getUsername());
		pst.setString(3, course.getCourseID());
		pst.executeUpdate();
	}
	
	private void clearData() {
		statement = null;
		pst = null;
		result = null;
	}
}

package leapacademyquiz.model;

public class CourseDataModel {
	public String courseID, courseName, username;
	public boolean examattended;
	public float score;
	
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isExamattended() {
		return examattended;
	}
	public void setExamattended(boolean examattended) {
		this.examattended = examattended;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
}

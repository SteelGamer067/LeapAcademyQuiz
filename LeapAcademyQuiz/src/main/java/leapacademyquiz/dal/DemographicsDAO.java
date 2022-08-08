package leapacademyquiz.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import leapacademyquiz.utilities.DBConnectionUtility;

public class DemographicsDAO {
	
	Connection con;
	Statement st;
	ResultSet result;
	
	public ResultSet getStates() throws ClassNotFoundException, SQLException {
		String query = "Select stateName from DemographicsDB.State;";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		result.next();
		return result;
	}

	public ResultSet getCities() throws ClassNotFoundException, SQLException {
		String query = "Select cityName from DemographicsDB.City;";
		
		clearData();
		con = DBConnectionUtility.getConnection();
		st = con.createStatement();
		ResultSet result = st.executeQuery(query);
		result.next();
		return result;
	}
	
	private void clearData() {
		st = null;
		result = null;
	}
}

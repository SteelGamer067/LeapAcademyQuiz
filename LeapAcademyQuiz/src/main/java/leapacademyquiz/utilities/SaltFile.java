package leapacademyquiz.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.StringTokenizer;

import leapacademyquiz.security.PasswordSecurity;

public class SaltFile {
	String salt;
	
	private String readSaltFile() throws FileNotFoundException {
		String readLine = null;
		
		File saltFile = new File("salt.slt");
		Scanner reader = new Scanner(saltFile);
		
		while(reader.hasNextLine()) readLine = reader.nextLine();
		reader.close();
		
		return readLine;
	}
	
	public String verifySalt(String uname, String pass) throws FileNotFoundException, NoSuchAlgorithmException {
		String readLine = readSaltFile();
		
		StringTokenizer st = new StringTokenizer(readLine);
		while(st.hasMoreTokens()) salt = st.nextToken("_"+uname);
		
		PasswordSecurity security = new PasswordSecurity();
		security.setSalt(salt);
		
		String hashedPass = security.hashInput(pass);
		return hashedPass;
	}
	
	public boolean saltExists(String uname) throws FileNotFoundException {
		String thisSalt = readSaltFile();
		if(thisSalt.contains(uname)) return true;
		else return false;
	}
}

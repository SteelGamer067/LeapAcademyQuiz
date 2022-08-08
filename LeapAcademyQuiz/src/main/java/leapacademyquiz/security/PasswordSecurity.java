package leapacademyquiz.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordSecurity {
	private static String hashingAlgorithm = "MD5";
	private static String saltingAlgorithm = "SHA1PRNG";
	private byte[] salt;
	
	public void createSalt() throws NoSuchAlgorithmException {
		SecureRandom secRand = SecureRandom.getInstance(saltingAlgorithm);
		salt = new byte[16];
		secRand.nextBytes(salt);
	}
	
	public String hashInput(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance(hashingAlgorithm);
		md.update(salt);
		byte[] msgDigest = md.digest(input.getBytes());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < msgDigest.length; i++) {
			sb.append(Integer.toString((msgDigest[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		String hashText = sb.toString();
		return hashText;
	}
	
	public String getSalt() {
		return salt.toString();
	}
	
	public void setSalt(String salt) {
		this.salt = salt.getBytes();
	}
}

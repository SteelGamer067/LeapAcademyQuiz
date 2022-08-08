package leapacademyquiz.model;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionDataModel {
	private KeyGenerator keyGen;
	private SecretKey sKey;
	
	public KeyGenerator getKeyGen() {
		return keyGen;
	}
	public void setKeyGen(KeyGenerator keyGen) {
		this.keyGen = keyGen;
	}
	
	public SecretKey getsKey() {
		return sKey;
	}
	public void setsKey(SecretKey sKey) {
		this.sKey = sKey;
	}
}

package cn.telecom.traffic.common;

import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AES {

	static Cipher cipher;
	static final String KEY_ALGORITHM = "AES";

	static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

	static public String encrypt(String str, String symKeyStr, String iv) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128, new SecureRandom(symKeyStr.getBytes()));
		cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
		SecretKeySpec symKey = new SecretKeySpec(kgen.generateKey().getEncoded(), "AES");

		cipher.init(Cipher.ENCRYPT_MODE, symKey, new IvParameterSpec(iv.getBytes()));

		byte[] encrypted = cipher.doFinal(str.getBytes(Charset.forName("UTF-8")));

		return DatatypeConverter.printBase64Binary(encrypted);

	}

}

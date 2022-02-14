package br.com.challenges.fifth.aes.builder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import br.com.challenges.fifth.builder.SecretKeyBuilder;
import br.com.challenges.fifth.enumerator.CryptographyAlgorithm;
import br.com.challenges.fifth.enumerator.SecretKeyFactoryAlgorithm;
import br.com.challenges.fifth.exception.GenerateSecretException;
import br.com.challenges.fifth.model.CryptographySecretKeyIv;
import br.com.challenges.fifth.utilities.PropertiesUtils;

public class AESCryptographySecretKeyIvBuilder {

	private final String iv;
	private final String salt;
	private final String secret;

	public static AESCryptographySecretKeyIvBuilder read(String propertiesName) throws FileNotFoundException, IOException {
		Properties properties = PropertiesUtils.read(propertiesName);
		return new AESCryptographySecretKeyIvBuilder(properties.getProperty("crypto.secret", ""), properties.getProperty("crypto.salt", ""), properties.getProperty("crypto.iv", ""));
	}

	public static AESCryptographySecretKeyIvBuilder with(String secret, String salt, String iv) {
		return new AESCryptographySecretKeyIvBuilder(secret, salt, iv);
	}

	private AESCryptographySecretKeyIvBuilder(String secret, String salt, String iv) {
		this.secret = secret;
		this.salt = salt;
		this.iv = iv;
	}

	public CryptographySecretKeyIv build() throws GenerateSecretException {
		SecretKey key = genereteSecretKey(this.secret, this.salt);
		IvParameterSpec iv = generateIV(this.iv);

		return new CryptographySecretKeyIv(key, iv);
	}

	private SecretKey genereteSecretKey(String secret, String salt) throws GenerateSecretException {
		return SecretKeyBuilder
					.usingAlgorithm(SecretKeyFactoryAlgorithm.PBKDF2WITHHMACSHA256)
					.usingSalt(salt)
					.withIterationCount(65536)
					.withKeyLength(128)
					.toAlgorithm(CryptographyAlgorithm.AES)
			   .build(secret);
	}

	private IvParameterSpec generateIV(String iv) throws GenerateSecretException {
		try {
			return new IvParameterSpec(iv.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException exception) {
			throw new GenerateSecretException(exception.getMessage(), exception);
		}
	}
}

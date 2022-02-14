package br.com.challenges.fifth.model;

import java.util.Base64;
import java.util.Objects;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

import br.com.challenges.fifth.exception.DecryptionException;
import br.com.challenges.fifth.exception.EncryptionException;

public class CryptorCipher implements Cryptor {

	private final Cipher encrypt;
	private final Cipher decrypt;

	public CryptorCipher(Cipher encrypt, Cipher decrypt) {
		this.encrypt = encrypt;
		this.decrypt = decrypt;
	}

	public String encrypt(String text) throws EncryptionException {
		if (Objects.isNull(text) || text.trim().isEmpty())
			throw new IllegalArgumentException("Deve ser informado um texto!");

		try {
		    return Base64.getEncoder().encodeToString(encrypt.doFinal(text.getBytes()));
		} catch (IllegalBlockSizeException | BadPaddingException exception) {
			throw new EncryptionException(exception.getMessage(), exception);
		}
	}

	public String decrypt(String text) throws DecryptionException {
		if (Objects.isNull(text) || text.trim().isEmpty())
			throw new IllegalArgumentException("Deve ser informado um texto!");

		try {
		    return new String(decrypt.doFinal(Base64.getDecoder().decode(text)));
		} catch (IllegalBlockSizeException | BadPaddingException exception) {
			throw new DecryptionException(exception.getMessage(), exception);
		}
	}
}

package br.com.challenges.fifth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import br.com.challenges.fifth.exception.CreateCryptorException;
import br.com.challenges.fifth.exception.DecryptionException;
import br.com.challenges.fifth.exception.EncryptionException;
import br.com.challenges.fifth.exception.GenerateSecretException;
import br.com.challenges.fifth.model.Cryptor;

public class FifthTest {

	private Cryptor cryptor;

	@Before
	public void init() {
		try {
			Fifth fifth = new Fifth();
			this.cryptor = fifth.execute();
		} catch (GenerateSecretException | CreateCryptorException exception) {
			throw new RuntimeException("Erro ao criar o cryptor!");
		}
	}

	@Test
	public void encrypt_null_value() throws EncryptionException {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { this.cryptor.encrypt(""); });
		assertEquals("Deve ser informado um texto!", exception.getMessage());
	}

	@Test
	public void encrypt_empty_value() throws EncryptionException {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { this.cryptor.encrypt(""); });
		assertEquals("Deve ser informado um texto!", exception.getMessage());
	}

	@Test
	public void encrypt_value() throws EncryptionException {
		String encrypted = this.cryptor.encrypt("super-secret-info");
		assertEquals("UEKwWm4YFGcnkVJ4ebhSii1LAs7V2Ivx2Gm+/QxUpro=", encrypted);
	}

	@Test
	public void decrypt_null_value() throws DecryptionException {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { this.cryptor.decrypt(null); });
		assertEquals("Deve ser informado um texto!", exception.getMessage());
	}

	@Test
	public void decrypt_empty_value() throws DecryptionException {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { this.cryptor.decrypt(""); });
		assertEquals("Deve ser informado um texto!", exception.getMessage());
	}

	@Test
	public void decrypt_value() throws DecryptionException {
		String decrypted = this.cryptor.decrypt("UEKwWm4YFGcnkVJ4ebhSii1LAs7V2Ivx2Gm+/QxUpro=");
		assertEquals("super-secret-info", decrypted);
	}

}

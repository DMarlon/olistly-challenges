package br.com.challenges.fifth;

import br.com.challenges.fifth.aes.builder.AESCryptographyBuilder;
import br.com.challenges.fifth.aes.builder.AESCryptographySecretKeyIvBuilder;
import br.com.challenges.fifth.aes.enumerator.AESPadding;
import br.com.challenges.fifth.aes.enumerator.AESVariation;
import br.com.challenges.fifth.exception.CreateCryptorException;
import br.com.challenges.fifth.exception.GenerateSecretException;
import br.com.challenges.fifth.model.CryptographySecretKeyIv;
import br.com.challenges.fifth.model.Cryptor;

public class Fifth {

	public Cryptor execute() throws GenerateSecretException, CreateCryptorException {
		CryptographySecretKeyIv secretKeyIv = AESCryptographySecretKeyIvBuilder.with("super-secret", "super-salt", "super-ivvvvvvvvv").build();

		Cryptor cryptorAES = AESCryptographyBuilder
								.usingMode(AESVariation.CBC)
								.withPadding(AESPadding.PKCS5PADDING)
								.usingSecretKey(secretKeyIv.getSecretKey())
								.withIV(secretKeyIv.getIV())
							.build();

		return cryptorAES;
	}
}

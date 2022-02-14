package br.com.challenges.fifth.model;

import br.com.challenges.fifth.exception.DecryptionException;
import br.com.challenges.fifth.exception.EncryptionException;

public interface Cryptor {
	public String encrypt(String text) throws EncryptionException;
	public String decrypt(String text) throws DecryptionException;
}

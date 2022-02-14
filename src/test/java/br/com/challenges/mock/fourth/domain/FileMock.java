package br.com.challenges.mock.fourth.domain;

import br.com.challenges.fourth.domain.File;

public class FileMock {
	private static final String fileName = "file";
	private static final byte[] fileContent = new byte[100];


	public static File mock() {
		return File.touch(fileName, fileContent);
	}
}

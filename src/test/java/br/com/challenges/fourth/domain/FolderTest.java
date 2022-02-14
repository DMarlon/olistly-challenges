package br.com.challenges.fourth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import br.com.challenges.mock.fourth.domain.FileMock;

public class FolderTest {

	@Test
	public void mkdir_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { Folder.mkdir(null); });
		assertEquals("O parâmetro nome não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void mkdir_empty_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { Folder.mkdir(" "); });
		assertEquals("O parâmetro nome não pode ser em branco!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { Folder.mkdir("       "); });
		assertEquals("O parâmetro nome não pode ser em branco!", exception.getMessage());
	}

	@Test
	public void mkdir_exists_file_name() {
		Folder folder = Folder.mkdir("  teste  ");
		folder.add(FileMock.mock());

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { folder.add(FileMock.mock()); });
		assertEquals("file já existe!", exception.getMessage());
	}

	@Test
	public void mkdir_value() {
		Folder folder = Folder.mkdir("  teste  ");
		folder.add(FileMock.mock());
		folder.add(File.touch("teste-folder", new byte[100]));

		assertNotNull(folder);
		assertEquals("teste", folder.getName());
		assertEquals(200, folder.getSize());
	}
}

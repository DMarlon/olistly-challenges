package br.com.challenges.fourth.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import br.com.challenges.mock.utilitary.ArrayMock;

public class FileTest {
	private ArrayMock mock;

	@Before
	public void init() {
		mock = ArrayMock.mock();
	}

	@Test
	public void touch_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { File.touch(null, null); });
		assertEquals("O parâmetro nome não pode ser nullo!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { File.touch("teste", null); });
		assertEquals("O parâmetro conteudo não pode ser nullo!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { File.touch(null, mock.valuesByte()); });
		assertEquals("O parâmetro nome não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void touch_empty_name_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { File.touch(" ", mock.valuesByte()); });
		assertEquals("O parâmetro nome não pode ser em branco!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { File.touch("       ", mock.valuesByte()); });
		assertEquals("O parâmetro nome não pode ser em branco!", exception.getMessage());
	}

	@Test
	public void touch_value() {
		File file = File.touch("  teste  ", new byte[50]);
		assertNotNull(file);
		assertEquals("teste", file.getName());
		assertEquals(50, file.getSize());
	}
}

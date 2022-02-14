package br.com.challenges.second;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.challenges.mock.utilitary.ArrayMock;

public class SecondTest {
	private Second second;
	private ArrayMock mock;

	@Before
	public void init() {
		second = new Second();
		mock = ArrayMock.mock();
	}

	@Test
	public void execute_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { second.execute(null); });
		assertEquals("O parâmetro não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void execute_empty_value() {
		int[] result = second.execute(mock.emptyInt());
		assertNotNull(result);
		assertEquals(0, result.length);
	}

	@Test
	public void execute_value() {
		int[] result = second.execute(mock.valuesInt());
		assertNotNull(result);
		assertEquals(3, result.length);
		assertEquals("[5, 5, 9]", Arrays.toString(result));
	}
}

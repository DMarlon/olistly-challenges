package br.com.challenges.first.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.challenges.mock.utilitary.ArrayMock;

public class UnionTest {
	private ArrayMock mock;

	@Before
	public void init() {
		mock = ArrayMock.mock();
	}

	@Test
	public void arrays_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { Union.arrays(null, mock.emptyInt()); });
		assertEquals("Os parâmetros não pode ser nullos!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { Union.arrays(mock.emptyInt(), null); });
		assertEquals("Os parâmetros não pode ser nullos!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { Union.arrays(null, null); });
		assertEquals("Os parâmetros não pode ser nullos!", exception.getMessage());
	}

	@Test
	public void transform_empty_value() {
		int[] result = Union.arrays(mock.emptyInt(), mock.emptyInt()).transform();
		assertNotNull(result);
		assertEquals(0, result.length);

		result = Union.arrays(mock.emptyInt(), mock.valuesInt()).transform();
		assertNotNull(result);
		assertEquals(6, result.length);

		result = Union.arrays(mock.valuesInt(), mock.emptyInt()).transform();
		assertNotNull(result);
		assertEquals(6, result.length);
	}

	@Test
	public void transform_value() {
		int[] result = Union.arrays(mock.valuesInt(), mock.differentValuesInt()).transform();
		assertNotNull(result);
		assertEquals(9, result.length);
		assertEquals("[1, 2, 3, 4, 5, 9, 6, 7, 8]", Arrays.toString(result));
	}
}

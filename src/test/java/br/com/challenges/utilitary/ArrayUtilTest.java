package br.com.challenges.utilitary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import br.com.challenges.mock.utilitary.ArrayMock;

public class ArrayUtilTest {
	ArrayMock mock;

	@Before
	public void init() {
		mock = ArrayMock.mock();
	}

	@Test
	public void exists_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.exists(null, 0); });
		assertEquals("O parâmetro array não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void exist_find_value() {
		assertTrue(ArrayUtil.exists(mock.valuesInt(), 1));
		assertTrue(ArrayUtil.exists(mock.valuesInt(), 4));
		assertTrue(ArrayUtil.exists(mock.valuesInt(), 5));
		assertTrue(ArrayUtil.exists(mock.valuesInt(), 9));
	}

	@Test
	public void exist_not_find_value() {
		assertFalse(ArrayUtil.exists(mock.valuesInt(), 6));
		assertFalse(ArrayUtil.exists(mock.valuesInt(), 7));
		assertFalse(ArrayUtil.exists(mock.valuesInt(), 8));
		assertFalse(ArrayUtil.exists(mock.valuesInt(), 10));
	}

	@Test
	public void change_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(null, 0, 0); });
		assertEquals("O parâmetro array não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void change_negative_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(mock.valuesInt(), -1, 0); });
		assertEquals("O parâmetro do primeiro index deve ser positivo!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(mock.valuesInt(), 0, -1); });
		assertEquals("O parâmetro do segundo index deve ser positivo!", exception.getMessage());
	}

	@Test
	public void change_out_of_bound_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(mock.valuesInt(), 11, 0); });
		assertEquals("O parâmetro do primeiro index esta fora do range [0-10]!", exception.getMessage());

		exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(mock.valuesInt(), 0, 11); });
		assertEquals("O parâmetro do segundo index esta fora do range [0-10]!", exception.getMessage());
	}

	@Test
	public void change_value() {
		ArrayUtil.change(mock.valuesInt(), 1, 2);

		assertEquals(3, mock.valuesInt()[1]);
		assertEquals(2, mock.valuesInt()[2]);
	}

	@Test
	public void inverter_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.change(null, 0, 0); });
		assertEquals("O parâmetro array não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void inverter_value() {
		char[] array = ArrayUtil.inverter("Olist".toCharArray());
		assertEquals("[t, s, i, l, O]", Arrays.toString(array));
	}

	@Test
	public void copy_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.copy(null, 0); });
		assertEquals("O parâmetro array não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void copy_length_negative_value() {
		int[] array = ArrayUtil.copy(mock.valuesInt(), -1);
		assertEquals(0, array.length);
	}

	@Test
	public void copy_length_biger_value() {
		int[] array = ArrayUtil.copy(mock.valuesInt(), 11);
		assertEquals(10, array.length);
	}

	@Test
	public void copy_value() {
		int[] array = ArrayUtil.copy(mock.valuesInt(), 5);
		assertEquals(5, array.length);
		assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(array));
	}

	@Test
	public void copyFromEnd_null_value() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { ArrayUtil.copyFromEnd(null, 0); });
		assertEquals("O parâmetro array não pode ser nullo!", exception.getMessage());
	}

	@Test
	public void copyFromEnd_length_negative_value() {
		int[] array = ArrayUtil.copyFromEnd(mock.valuesInt(), -1);
		assertEquals(0, array.length);
	}

	@Test
	public void copyFromEnd_length_biger_value() {
		int[] array = ArrayUtil.copyFromEnd(mock.valuesInt(), 11);
		assertEquals(10, array.length);
	}

	@Test
	public void copyFromEnd_value() {
		int[] array = ArrayUtil.copyFromEnd(mock.valuesInt(), 5);
		assertEquals(5, array.length);
		assertEquals("[5, 5, 5, 5, 9]", Arrays.toString(array));
	}
}

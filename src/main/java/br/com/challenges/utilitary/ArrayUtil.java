package br.com.challenges.utilitary;

import java.util.Objects;

public class ArrayUtil {

	public static boolean exists(int[] array, int value) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro array não pode ser nullo!");

		for (int index = 0; index < array.length; index++) {
			if (array[index] == value) {
				return true;
			}
		}

		return false;
	}

	public static void change(int[] array, int firstIndex, int secondIndex) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro array não pode ser nullo!");

		if (firstIndex < 0)
			throw new IllegalArgumentException("O parâmetro do primeiro index deve ser positivo!");

		if (secondIndex < 0)
			throw new IllegalArgumentException("O parâmetro do segundo index deve ser positivo!");

		if (array.length < firstIndex)
			throw new IllegalArgumentException(String.format("O parâmetro do primeiro index esta fora do range [0-%d]!", array.length));

		if (array.length < secondIndex)
			throw new IllegalArgumentException(String.format("O parâmetro do segundo index esta fora do range [0-%d]!", array.length));

		int valueFirstIndex = array[firstIndex];

		array[firstIndex] = array[secondIndex];
		array[secondIndex] = valueFirstIndex;
	}

	public static char[] inverter(char[] array) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro array não pode ser nullo!");

		int resultIndex = 0;
		char[] result = new char[array.length];

		for (int index = array.length-1; index >= 0; index--) {
			result[resultIndex++] = array[index];
		}

		return result;
	}

	public static int[] copy(int[] array, int length) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro array não pode ser nullo!");

		if (length < 0)
			return new int[0];

		if (length > array.length)
			return array;

		int[] result = new int[length];

		for (int index = 0; index < length; index++) {
			result[index] = array[index];
		}

		return result;
	}

	public static int[] copyFromEnd(int[] array, int length) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro array não pode ser nullo!");

		if (length < 0)
			return new int[0];

		if (length > array.length)
			return array;

		int[] result = new int[length];

		for (int index = array.length-1; length > 0; index--) {
			result[--length] = array[index];
		}

		return result;
	}

}

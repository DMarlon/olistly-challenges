package br.com.challenges.mock.utilitary;

public class ArrayMock {

	private final int[] emptyInt = new int[0];
	private final int[] valuesInt = {1, 2, 3, 4, 5, 5, 5, 5, 5, 9};
	private final int[] differentValuesInt = {5, 6, 7, 8, 9, 9, 9, 9, 9, 9};

	private final byte[] emptyByte = new byte[0];
	private final byte[] valuesByte = {1, 2, 3, 4, 5, 5, 5, 5, 5, 9};
	private final byte[] differentValuesByte = {5, 6, 7, 8, 9, 9, 9, 9, 9, 9};

	public static ArrayMock mock() {
		return new ArrayMock();
	}

	private ArrayMock() {
	}


	public int[] emptyInt() {
		return this.emptyInt;
	}

	public int[] valuesInt() {
		return this.valuesInt;
	}

	public int[] differentValuesInt() {
		return this.differentValuesInt;
	}

	public byte[] emptyByte() {
		return this.emptyByte;
	}

	public byte[] valuesByte() {
		return this.valuesByte;
	}

	public byte[] differentValuesByte() {
		return this.differentValuesByte;
	}
}

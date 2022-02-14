package br.com.challenges.first.domain;

import java.util.Objects;

import br.com.challenges.utilitary.ArrayUtil;

public class Union {

	private int size;
	private int[] union;
	private int[] first;
	private int[] second;

	public static Union arrays(int[] first, int[] second) {
		if (Objects.isNull(first) || Objects.isNull(second))
			throw new IllegalArgumentException("Os parâmetros não pode ser nullos!");

		return new Union(first, second);
	}

	private Union(int[] first, int[] second) {
		this.first = first;
		this.second = second;
	}

	public int[] transform() {
		initialize();

		unify(first);
		unify(second);

		return ArrayUtil.copy(this.union, this.size);
	}

	private void initialize() {
		this.size = 0;
		this.union = new int[this.first.length + this.second.length];
	}

	private void unify(int[] array) {
		for (int index = 0; index < array.length; index++) {
			if (!ArrayUtil.exists(this.union, array[index])) {
				this.union[size++] = array[index];
			}
		}
	}
}

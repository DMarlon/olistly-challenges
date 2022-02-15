package br.com.challenges.first.domain;

import java.util.Objects;

import br.com.challenges.utilitary.ArrayUtil;

public class Intersection {
	private int size;
	private int[] intersection;
	private int[] longer;
	private int[] shorter;
	private boolean hasZero;

	public static Intersection arrays(int[] first, int[] second) {
		if (Objects.isNull(first) || Objects.isNull(second))
			throw new IllegalArgumentException("Os parâmetros não pode ser nullos!");

		return new Intersection(first, second);
	}

	private Intersection(int[] first, int[] second) {
		this.hasZero = false;

		if (first.length > second.length) {
			this.longer = first;
			this.shorter = second;
		} else {
			this.longer = second;
			this.shorter = first;
		}
	}

	public int[] transform() {
		initialize();

		unify();

		return ArrayUtil.copy(this.intersection, this.size);
	}

	private void initialize() {
		this.size = 0;
		this.intersection = new int[this.longer.length];
	}

	private void unify() {
		for (int index = 0; index < longer.length; index++) {
			boolean existsInShorter = ArrayUtil.exists(this.shorter, longer[index]);
			if (!hasZero && longer[index] == 0 && existsInShorter) {
				size++;
				hasZero = true;
			} else if (existsInShorter && !ArrayUtil.exists(this.intersection, longer[index])) {
				this.intersection[size++] = longer[index];
			}
		}
	}
}

package br.com.challenges.second;

import java.util.Objects;

import br.com.challenges.second.domain.QuickSort;
import br.com.challenges.utilitary.ArrayUtil;

public class Second {
	public int[] execute(int[] array) {
		if (Objects.isNull(array))
			throw new IllegalArgumentException("O parâmetro não pode ser nullo!");

		if (array.length <= 3)
			return array;

		return ArrayUtil.copyFromEnd(QuickSort.sort(array), 3);
	}

}

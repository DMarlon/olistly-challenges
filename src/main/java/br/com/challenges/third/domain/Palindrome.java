package br.com.challenges.third.domain;

import java.util.Objects;

import br.com.challenges.utilitary.ArrayUtil;

public class Palindrome {

	public static boolean is(String word) {
		if (Objects.isNull(word))
				return false;

		String comparation = word.trim().toLowerCase();

		if (comparation.isEmpty() || comparation.contains(" "))
			return false;

		return comparation.trim().equals(new String(ArrayUtil.inverter(comparation.toCharArray())));
	}
}

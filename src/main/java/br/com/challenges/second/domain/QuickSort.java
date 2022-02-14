package br.com.challenges.second.domain;

import br.com.challenges.utilitary.ArrayUtil;

public class QuickSort {

	public static int[] sort(int[] array) {
		return (new QuickSort()).sort(array, 0, array.length-1);
	}

	private QuickSort() {
	}

	private int[] sort(int[] array, int start, int end) {
		if (end-start > 0) {
			int pivot = partition(array, start, end);
			sort(array, start, pivot-1);
			sort(array, pivot+1, end);
		}

		return array;
	}

	private int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int shorterValue = 0;

		for (int index = 0; index < end; index++) {
			if (array[index] <= pivot) {
				ArrayUtil.change(array, index, shorterValue);
				shorterValue++;
			}
		}

		ArrayUtil.change(array, shorterValue, end);

		return shorterValue;
	}
}

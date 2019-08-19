package com.wlgdo.avatar.apps.common;

import cn.hutool.core.util.ArrayUtil;

import java.util.Comparator;

/**
 * 一些排序实现
 */
public final class ArraySortUtil {

	private static final int QUICK_SORT_THRESHOLD = 120;

	private static final int INSERTION_SORT_THRESHOLD = 60;

	public static <E extends Comparable<? super E>> boolean isSorted(final E[] array, final boolean lowToHigh) {
		return isSorted(array, lowToHigh, Comparator.naturalOrder());
	}

	public static <E> boolean isSorted(final E[] array, final boolean lowToHigh, final Comparator<E> comparator) {
		int left = 0, right = array.length - 1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				right = i - 1;
				break;
			}
		}
		for (; left < right; left++) {
			int v = comparator.compare(array[left], array[left + 1]);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(final long[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		long previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final long current = array[i];
			int v = Long.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final int[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		int previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final int current = array[i];
			int v = Integer.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final short[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		short previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final short current = array[i];
			int v = Short.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final char[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		char previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final char current = array[i];
			int v = Character.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final byte[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		byte previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final byte current = array[i];
			int v = Byte.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final double[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		double previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final double current = array[i];
			int v = Double.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final float[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		float previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final float current = array[i];
			int v = Float.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	public static boolean isSorted(final boolean[] array, final boolean lowToHigh) {
		if (array == null || array.length == 1) {
			return true;
		}
		boolean previous = array[0];
		final int n = array.length;
		for (int i = 1; i < n; i++) {
			final boolean current = array[i];
			int v = Boolean.compare(previous, current);
			if (v == 0) {
				continue;
			}
			if (lowToHigh ^ v < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}


	/**
	 * 排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void sort(final E[] original, final boolean lowToHigh) {
		sort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 按照给定的范围,排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void sort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		sort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void sort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		sort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void sort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		if (original.length < INSERTION_SORT_THRESHOLD) {
			insertSort(original, left, right, lowToHigh, comparator);
		} else if (original.length < QUICK_SORT_THRESHOLD) {
			shellSort(original, left, right, lowToHigh, comparator);
		} else {
			quickSort(original, left, right, lowToHigh, comparator);
		}
	}

	/**
	 * 插入排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void insertSort(final E[] original, final boolean lowToHigh) {
		insertSort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 按照给定的范围,插入排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void insertSort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		insertSort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 插入排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void insertSort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		insertSort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 插入排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void insertSort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		int cursor = ArrayTool.arrangeNullElementToTheRight(original, left, right);
		if (left < 0 || cursor >= original.length || left >= cursor) {
			return;
		}
		for (int i = left, j = i; i <= cursor; j = ++i) {
			E temp = original[i];
			if (temp != null) {
				for (; j > left; j--) {
					if (lowToHigh ^ comparator.compare(temp, original[j - 1]) < 0) {
						break;
					}
					original[j] = original[j - 1];
				}
				original[j] = temp;
			} else {
				for (; cursor > i; cursor--) {
					if (original[cursor] != null) {
						original[i] = original[cursor];
						original[cursor] = null;
						i--;
						break;
					}
				}
			}
		}
	}

	/**
	 * 希尔排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void shellSort(final E[] original, final boolean lowToHigh) {
		shellSort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 按照给定的范围,希尔排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void shellSort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		shellSort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 希尔排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void shellSort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		shellSort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 按照给定的范围,希尔排序,允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void shellSort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		int cursor = ArrayTool.arrangeNullElementToTheRight(original, left, right);
		if (left < 0 || cursor >= original.length || left >= cursor) {
			return;
		}
		int increment = 3;
		int step = 1;
		while (step < (cursor - left + 1) / increment) {
			// <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
			step = step * 3 + 1;
		}
		for (; step >= 1; step /= increment) {
			for (int group = left; group < step; group++) {
				for (int i = group, j = i; i <= cursor - step; i += step, j = i) {
					E temp = original[i + step];
					while (lowToHigh ^ comparator.compare(temp, original[j]) > 0) {
						original[j + step] = original[j];
						j -= step;
						if (j < left) {
							break;
						}
					}
					original[j + step] = temp;
				}
			}
		}
	}

	/**
	 * 快速排序(数组长度较小时,无速度优势),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void quickSort(final E[] original, final boolean lowToHigh) {
		quickSort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 按照给定的范围,快速排序(给定范围较小时,无速度优势),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void quickSort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		quickSort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 快速排序(数组长度较小时,无速度优势),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void quickSort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		quickSort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 按照给定的范围,快速排序(给定范围较小时,无速度优势),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void quickSort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		int cursor = ArrayTool.arrangeNullElementToTheRight(original, left, right);
		if (left < 0 || cursor >= original.length || left >= cursor) {
			return;
		}
		E flag = original[(left + cursor) >>> 1];
		int leftCursor = left - 1;
		int rightCursor = cursor + 1;
		if (lowToHigh) {
			while (true) {
				while (comparator.compare(original[++leftCursor], flag) < 0) {

				}
				while (comparator.compare(original[--rightCursor], flag) > 0) {

				}
				if (leftCursor >= rightCursor) {
					break;
				}
				ArrayUtil.swap(original, leftCursor, rightCursor);
			}
		} else {
			while (true) {
				while (comparator.compare(original[++leftCursor], flag) > 0) {

				}
				while (comparator.compare(original[--rightCursor], flag) < 0) {

				}
				if (leftCursor >= rightCursor) {
					break;
				}
				ArrayUtil.swap(original, leftCursor, rightCursor);
			}
		}
		quickSort(original, left, leftCursor - 1, lowToHigh, comparator);
		quickSort(original, rightCursor + 1, cursor, lowToHigh, comparator);
	}

	/**
	 * 冒泡排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void bubbleSort(final E[] original, final boolean lowToHigh) {
		bubbleSort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 冒泡排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void bubbleSort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		bubbleSort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 冒泡排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void bubbleSort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		bubbleSort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 冒泡排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void bubbleSort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		int cursor = ArrayTool.arrangeNullElementToTheRight(original, left, right);
		if (left < 0 || cursor >= original.length || left >= cursor) {
			return;
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int j = left + 1; j <= cursor; j++) {
				if (lowToHigh ^ comparator.compare(original[j], original[j - 1]) > 0) {
					E temp = original[j];
					original[j] = original[j - 1];
					original[j - 1] = temp;
					flag = true;
				}
			}
			cursor--;
		}
	}

	/**
	 * 直接选择排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void selectSort(final E[] original, final boolean lowToHigh) {
		selectSort(original, 0, original.length - 1, lowToHigh);
	}

	/**
	 * 直接选择排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original  源数组
	 * @param left      左端起始索引
	 * @param right     右端结束索引
	 * @param lowToHigh 是否是升序
	 */
	public static <E extends Comparable<? super E>> void selectSort(final E[] original, final int left, final int right, final boolean lowToHigh) {
		selectSort(original, left, right, lowToHigh, Comparator.naturalOrder());
	}

	/**
	 * 直接选择排序(性能差),允许数组内有空元素,支持升降序的选择.
	 *
	 * @param original   源数组
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void selectSort(final E[] original, final boolean lowToHigh, final Comparator<E> comparator) {
		selectSort(original, 0, original.length - 1, lowToHigh, comparator);
	}

	/**
	 * 直接选择排序(性能差),允许数组内有空元素,支持升降序的选择
	 *
	 * @param original   源数组
	 * @param left       左端起始索引
	 * @param right      右端结束索引
	 * @param lowToHigh  是否是升序
	 * @param comparator 比较器
	 */
	public static <E> void selectSort(final E[] original, final int left, final int right, final boolean lowToHigh, final Comparator<E> comparator) {
		int cursor = ArrayTool.arrangeNullElementToTheRight(original, left, right);
		if (left < 0 || cursor >= original.length || left >= cursor) {
			return;
		}
		int index;
		for (int i = left; i < cursor; i++) {
			index = i;
			for (int j = i + 1; j <= cursor; j++) {
				if (lowToHigh ^ comparator.compare(original[index], original[j]) < 0) {
					index = j;
				}
			}
			E temp = original[i];
			original[i] = original[index];
			original[index] = temp;
		}
	}

}

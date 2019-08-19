package com.wlgdo.avatar.apps.common;


import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.function.Function;

import static io.lettuce.core.models.command.CommandDetail.Flag.RANDOM;

/**
 * @author mayer - [Created on 2019-08-02 20:26]
 */
public class ArrayTool {
	private static final Random RANDOM = new Random();


	public static <S, T> void cast(final S[] original, final T[] target, final Function<S, T> caster) {
		for (int i = 0; i < original.length; i++) {
			target[i] = caster.apply(original[i]);
		}
	}

	public static <E> boolean isAllNull(final E[] array) {
		if (array != null) {
			for (E e : array) {
				if (e != null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <p>安排空元素到数组的右端</p>
	 *
	 * @param array 源数组
	 * @return 不为空的最右端的元素索引
	 */
	public static <E> int arrangeNullElementToTheRight(final E[] array) {
		return arrangeNullElementToTheRight(array, 0, array.length - 1);
	}

	/**
	 * <p>按照给定的范围,安排空元素到给定范围的右端</p>
	 *
	 * @param array 源数组
	 * @param left  左端起始索引
	 * @param right 右端结束索引
	 * @return 不为空的在给定范围内的最右端的元素索引
	 */
	public static <E> int arrangeNullElementToTheRight(final E[] array, final int left, final int right) {
		int leftCursor = Math.max(left, 0);
		int rightCursor = right < array.length ? right : array.length - 1;
		for (int i = leftCursor; i <= rightCursor; i++) {
			if (array[i] == null) {
				array[i] = array[rightCursor];
				array[rightCursor] = null;
				rightCursor--;
				i--;
			}
		}
		return rightCursor;
	}

	public static <E> void shuffle(final E[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final long[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final int[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final short[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final char[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final byte[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final double[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final float[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static void shuffle(final boolean[] array) {
		for (int i = 1; i < array.length; i++) {
			swap(array, i, RANDOM.nextInt(array.length));
		}
	}

	public static <E> void swap(final E[] array, final int left, final int right) {
		E temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final long[] array, final int left, final int right) {
		long temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final int[] array, final int left, final int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final short[] array, final int left, final int right) {
		short temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final char[] array, final int left, final int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final byte[] array, final int left, final int right) {
		byte temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final double[] array, final int left, final int right) {
		double temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final float[] array, final int left, final int right) {
		float temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void swap(final boolean[] array, final int left, final int right) {
		boolean temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static int[] toIntArray(final char[] chars) {
		int[] result = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			result[i] = chars[i];
		}
		return result;
	}

	public static byte[] toBytePrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_BYTE_ARRAY;
		}
		final byte[] result = new byte[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Byte.parseByte(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static boolean[] toBooleanPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_BOOLEAN_ARRAY;
		}
		final boolean[] result = new boolean[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = BooleanUtils.toBooleanObject(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static char[] toCharPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_CHAR_ARRAY;
		}
		final char[] result = new char[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = CharUtils.toChar(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static short[] toShortPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_SHORT_ARRAY;
		}
		final short[] result = new short[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Short.parseShort(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static int[] toIntPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_INT_ARRAY;
		}
		final int[] result = new int[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Integer.parseInt(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static long[] toLongPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_LONG_ARRAY;
		}
		final long[] result = new long[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Long.parseLong(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static float[] toFloatPrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_FLOAT_ARRAY;
		}
		final float[] result = new float[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Float.parseFloat(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static double[] toDoublePrimitiveArray(final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return ArrayUtils.EMPTY_DOUBLE_ARRAY;
		}
		final double[] result = new double[strings.length];
		for (int index = 0; index < strings.length; index++) {
			try {
				result[index] = Double.parseDouble(strings[index]);
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return result;
	}

	public static Byte[] toByteObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toBytePrimitiveArray(strings));
	}

	public static Boolean[] toBooleanObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toBooleanPrimitiveArray(strings));
	}

	public static Character[] toCharObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toCharPrimitiveArray(strings));
	}

	public static Short[] toShortObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toShortPrimitiveArray(strings));
	}

	public static Integer[] toIntObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toIntPrimitiveArray(strings));
	}

	public static Long[] toLongObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toLongPrimitiveArray(strings));
	}

	public static Float[] toFloatObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toFloatPrimitiveArray(strings));
	}

	public static Double[] toDoubleObjectArray(final String[] strings) {
		return ArrayUtils.toObject(toDoublePrimitiveArray(strings));
	}

	@SuppressWarnings("unchecked")
	public static <T extends Enum<T>> T[] toEnumArray(final Class<T> enumClass, final String[] strings) {
		if (ArrayUtils.isEmpty(strings)) {
			return (T[]) Array.newInstance(enumClass, 0);
		}
		T[] array = (T[]) Array.newInstance(enumClass, strings.length);
		for (int index = 0; index < strings.length; index++) {
			try {
				Array.set(array, index, Enum.valueOf(enumClass, strings[index]));
			} catch (Exception exception) {
				throw new RuntimeException(String.format("[index:%d] -> %s", index, exception.getMessage()), exception);
			}
		}
		return array;
	}

	public static byte[] defaultIfEmpty(final byte[] array, final byte[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static boolean[] defaultIfEmpty(final boolean[] array, final boolean[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static char[] defaultIfEmpty(final char[] array, final char[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static short[] defaultIfEmpty(final short[] array, final short[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static int[] defaultIfEmpty(final int[] array, final int[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static long[] defaultIfEmpty(final long[] array, final long[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static float[] defaultIfEmpty(final float[] array, final float[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static double[] defaultIfEmpty(final double[] array, final double[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

	public static <T> T[] defaultIfEmpty(final T[] array, final T[] defaultArray) {
		return ArrayUtils.isEmpty(array) ? defaultArray : array;
	}

}

package com.mt.datastructure;

import java.util.*;

public class DataStructureUtil {

	private DataStructureUtil() {

	}

	public static String reverseString(String str) {
		String reversed = "";
		char ch;

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			reversed = ch + reversed;
		}

		System.out.println("Reversed String : " + reversed);
		return reversed;
	}

	public static boolean checkPalindrome(String str) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				long stopTime = System.currentTimeMillis();
				System.out.println("Before full check, time passed : " + (stopTime - startTime));
				return false;
			}
		}

		long stopTime = System.currentTimeMillis();
		System.out.println("Full checked, time passed : " + (stopTime - startTime));

		return true;
	}

	public static void findTheMostUsedCharInString(String str) {
		Map<Character, Integer> mapLetterToCount = createLetterCountMap(str);

		int maxCount = 0;
		char maxChar = ' ';
		for (Map.Entry<Character, Integer> entry : mapLetterToCount.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxChar = entry.getKey();
			}
		}
		System.out.println("Maximum used character for '" +
				str + "' is : " + maxChar +
				" and repeated " + maxCount + " times.");
	}

	public static Map<Character, Integer> createLetterCountMap(String str) {
		Map<Character, Integer> mapLetterToCount = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				continue;
			if (mapLetterToCount.get(str.charAt(i)) == null) {
				mapLetterToCount.put(str.charAt(i), 1);
			} else {
				int count = mapLetterToCount.get(str.charAt(i));
				count++;
				mapLetterToCount.put(str.charAt(i), count);
			}
		}
		return mapLetterToCount;
	}

	public static int reverseInt(int number) {
		if (Math.signum(number) == 1.0) {
			String num = Integer.toString(number);
			return Integer.parseInt(reverseStringImproved(num));
		} else {
			int num = Math.abs(number);
			return -1 * Integer.parseInt(reverseStringImproved(Integer.toString(num)));
		}
	}

	public static String reverseStringImproved(String str) {
		long startTime = System.currentTimeMillis();
		StringBuilder reversed = new StringBuilder();
		char ch;

		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			reversed.insert(0, ch);
		}
		long stopTime = System.currentTimeMillis();
		System.out.println("Reversed String : " + reversed + ", time passed : " + (stopTime - startTime));
		return reversed.toString();
	}

	public static List<String> fizzBuzz(int number) {
		List<String> tempList = new ArrayList<>();
		while (number > 0) {
			if (number % 15 == 0) {
				tempList.add("fizz-buzz");
			} else if (number % 5 == 0) {
				tempList.add("buzz");
			} else if (number % 3 == 0) {
				tempList.add("fizz");
			} else {
				tempList.add(Integer.toString(number));
			}
			number--;
		}
		return tempList;
	}

	/**
	 * @param array     array we are going to chunk it like [1,2,4,5,0,6,3,1,9,7]
	 * @param chunkSize size of chunks like 3
	 *
	 * @return chunk version of our array : [[1,2,4],[5,0,6],[3,1,9],[7,0,0]]
	 */
	public static int[][] chunk(int[] array, int chunkSize) {
		int[][] answer;
		int j = 0;
		int k = 0;

		if (chunkSize != 0) {
			if (array.length % chunkSize == 0) {
				answer = new int[array.length / chunkSize][chunkSize];
			} else {
				answer = new int[array.length / chunkSize + 1][chunkSize];
			}

			for (int i = 0; i < array.length; i++) {
				if (i % chunkSize == 0 && i != 0) {
					j++;
					k = 0;
				}
				answer[j][k] = array[i];
				k++;
			}

			return answer;
		} else {
			System.out.println("Enter valid size for chunk");
			return new int[0][0];
		}
	}

	public static boolean isAnagram(String str1, String str2) {
		Map<Character, Integer> firstMap = createLetterCountMap(str1.toLowerCase(Locale.ROOT));
		Map<Character, Integer> secondMap = createLetterCountMap(str2.toLowerCase(Locale.ROOT));
		return firstMap.equals(secondMap);
	}
}

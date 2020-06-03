/*******************************************************************************
 * Unpublished work, copyright (c) aMind Solutions LLC 2008-2013. All rights 
 * reserved. This software code and any commented materials or notations 
 * ("Materials") constitute proprietary and confidential  information of aMind 
 * Solutions LLC. The Materials (and any  or material derived therefrom) may not 
 * be reproduced or used, and may not be disclosed or otherwise  made available 
 * to any person, in whole or in part, except in accordance with a written 
 * agreement with aMind or as otherwise expressly authorized in writing by aMind
 ******************************************************************************/

package com.amind.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

	public static String parseAnyNumber(String numStr) {

		if (isEmpty(numStr)) {
			return "0.00";
		}

		char currChar = numStr.charAt(numStr.length() - 1);

		while (!Character.isDigit(currChar)) {
			if (numStr.length() == 1)
				return "0.00";
			numStr = numStr.substring(0, numStr.length() - 1);
			currChar = numStr.charAt(numStr.length() - 1);
		}

		return numStr;
	}

	public static String parsePhoneNumber(String numStr) {

		if (isEmpty(numStr)) {
			return "";
		}

		int numStrLength = numStr.length();

		if ((numStrLength >= 1) && (numStrLength <= 3))
			return "(" + numStr.substring(0, numStrLength) + ")";

		if ((numStrLength >= 4) && (numStrLength <= 6))
			return "(" + numStr.substring(0, 3) + ") " + numStr.substring(3, numStrLength);

		if (numStrLength >= 7)
			return "(" + numStr.substring(0, 3) + ") " + numStr.substring(3, 6) + " - " + numStr.substring(6, numStrLength);

		return numStr;
	}

	public static boolean isTrue(String boolVal) {
		return (boolVal != null && (boolVal.equalsIgnoreCase("Y") || boolVal.equalsIgnoreCase("true")));
	}

	public static String getCallStackTrace() {
		StringBuffer callStackTrace = new StringBuffer();
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		callStackTrace.append("Thread name is: '" + Thread.currentThread().getName() + "', Thread id is: '" + String.valueOf(Thread.currentThread().getId()) + "'");
		for (int i = 0; i < stackTraceElements.length; i++) {
			StackTraceElement ste = stackTraceElements[i];
			callStackTrace.append("\n" + ste.getClassName() + "." + ste.getMethodName() + "(" + ste.getFileName() + ":" + String.valueOf(ste.getLineNumber()) + ")");
		}
		return callStackTrace.toString();
	}

	public static String getCallStackTrace(Exception e) {
		StringBuffer callStackTrace = new StringBuffer();
		StackTraceElement[] stackTraceElements = e.getStackTrace();
		for (int i = 0; i < stackTraceElements.length; i++) {
			StackTraceElement ste = stackTraceElements[i];
			callStackTrace.append("\n" + ste.getClassName() + "." + ste.getMethodName() + "(" + ste.getFileName() + ":" + String.valueOf(ste.getLineNumber()) + ")");
		}
		return callStackTrace.toString();
	}

	/**
	 * Checks if parameter toTest is null or empty. Trims leading and trailing
	 * whitespace before checking for empty string.
	 * 
	 * @param toTest
	 * @return true if null, empty, or all whitespace characters
	 */
	public static boolean isEmpty(String toTest) {
		return toTest == null || toTest.trim().isEmpty();
	}

	/**
	 * checks if parameter str is not (null or empty)
	 * 
	 * @param str
	 * @return true or false
	 */
	public static boolean isNotEmpty(String str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * checks if parameter str is null or just containing whitespaces
	 * 
	 * @param str
	 * @return true or false
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * checks if parameter str is neither null nor contains only white spaces
	 * 
	 * @param str
	 * @return true or false
	 */

	public static boolean isNotBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return false;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Converts a null string to an empty String
	 * 
	 * @param input
	 * @return empty string
	 */
	public static String makeEmptyIfNull(String input) {
		return input != null ? input : "";
	}

	public static String defaultNullOrEmpty(String input, String defaultArg) {
		return input != null && !input.isEmpty() ? input : defaultArg;
	}

	/**
	 * converts a String to an array
	 * 
	 * @param toParse
	 *            : string to change
	 * @param delimiter
	 *            : string used to divide toParse String by
	 * @return array of strings
	 */
	public static String[] parseToArray(String toParse, String delimiter) {
		StringTokenizer tokenizer = new StringTokenizer(toParse.trim(), ",");
		String[] array = new String[tokenizer.countTokens()];
		int i = 0;
		while (tokenizer.hasMoreElements()) {
			array[i++] = tokenizer.nextElement().toString().trim();
		}
		return array;
	}

	/**
	 * converts a String to a List
	 * 
	 * @param toParse
	 *            : String to be converted
	 * @param delimiter
	 *            : divider to separate the String on
	 * @return List of Strings
	 */
	public static List<String> parseToList(String toParse, String delimiter) {
		List<String> list = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(toParse.trim(), ",");
		while (tokenizer.hasMoreElements()) {
			list.add(tokenizer.nextElement().toString().trim());
		}
		return list;
	}
	

	/**
	 * converts a String to a long
	 * 
	 * @param lstr
	 *            : String to be converted
	 * @return converted long value
	 */
	public static long toLong(String lstr) {
		if(StringUtils.isNotBlank(lstr)) {
			Long defNum = Long.valueOf(lstr);
			long intNum = defNum.longValue();
			return intNum;
		} else {
			return 0;
		}
	}



}

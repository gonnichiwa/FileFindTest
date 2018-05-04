package com.malanghoney.filefindtest;

import java.io.UnsupportedEncodingException;

class EncodingChanger {

	private static final String UTF8_FORMAT = "%04X";

	// UNICODE 변환(int) FROM 문자열
	int[] getUnicodesFromString(String targetStr) {
		char[] strArr = getCharsFromString(targetStr);
		return getIntArrFromChars(strArr);
	}

	private char[] getCharsFromString(String targetStr){
		int strLength = targetStr.length();
		char[] cArr = new char[strLength];
		targetStr.getChars(0,strLength,cArr,0);
		return cArr;
	}

	private int[] getIntArrFromChars(char[] chars){
		int[] iArr = new int[chars.length];
		for (int i=0; i< chars.length; i++){
			iArr[i] = (int) chars[i];
		}
		return iArr;
	}

	// 콘솔 출력 (UTF8)
	void printUTF8Code(String targetStr){
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			System.out.print(String.format(UTF8_FORMAT, (int) chr) + " ");
		}
	}

	// UTF8문자열 변환 FROM 문자열
	String getStringsFromUTF8Code(String targetStr){
		StringBuilder sb = new StringBuilder();
		char[] strArr = new char[targetStr.length()];
		targetStr.getChars(0,targetStr.length(),strArr,0);

		for (char chr : strArr) {
			sb.append(String.format(UTF8_FORMAT, (int) chr));
		}
		return sb.toString();
	}

	// UTF-8 byte 변환 FROM 문자열
	byte[] getBytesFromString(String targetStr) throws UnsupportedEncodingException {
//		return targetStr.getBytes(); equal with UTF8
		return targetStr.getBytes("UTF-8");
	}

}

package com.malanghoney.filefindtest;

class HangulDetector {

	private HangulDetector(){}
	static HangulDetector getInstance(){
		return LazyHolder.INSTANCE;
	}
	private EncodingChanger ec = new EncodingChanger();

	private static class LazyHolder {

		private static final HangulDetector INSTANCE = new HangulDetector();
	}

	// sourceCode 한줄 왼쪽부터 검색하야
	// 한글(unicode) 검출시 true
	boolean isContainHangul(String lineString) {
		boolean isContain = false;
		int[] unicodes = ec.getUnicodesFromString(lineString);
		for(int i : unicodes){
			/* (UTF-8 INT : UTF-8 HEX )
			       44032  :   0xAC00
			       55203  :   0xD7A3 */
			if(i >= 44032 && i <= 55203) {
				isContain = true;
				break;
			}
		}
		return isContain;
	}

}

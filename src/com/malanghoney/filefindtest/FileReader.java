package com.malanghoney.filefindtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class FileReader {
	private static HangulDetector hd = HangulDetector.getInstance();

	private FileReader(){}
	static FileReader getInstance() {return LazyHolder.INSTANCE;}
	private static class LazyHolder {
		private static final FileReader INSTANCE = new FileReader();
	}

	void printHangulCode(String rootDirPath, String targetFileName) {
		Charset inputCharset;

		// 파일 내용 읽기
		inputCharset = Charset.forName("UTF-8");
		try (FileInputStream fis = new FileInputStream(rootDirPath +"\\"+ targetFileName);
			 InputStreamReader isr = new InputStreamReader(fis, inputCharset);
			 BufferedReader br = new BufferedReader(isr)) {

			int lineNum = 1;
			String lineString;

			System.out.println("****** 경로\t : \t " + rootDirPath);
			System.out.println("****** 파일명\t : \t " + targetFileName);
			System.out.println("=============================한글 포함 라인==================================");
			// read source String each Line
			while ((lineString = br.readLine()) != null) {
				// 한글 감지된 라인만 출력
				if(hd.isContainHangul(lineString)) System.out.println("Line"+ lineNum + "\t" + lineString);
				lineNum++;
			}
			System.out.println("=============================\t\tEND\t\t====================================\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.malanghoney.filefindtest;

import java.io.File;
import java.io.IOException;

public class FileSearcher {
	public static void main(String[] args) throws IOException {
		String rootDirPath = "C:\\dev-Source\\cafe24FTP\\_\\sde_design\\skin6";

		new FileSearcher().subDirSearch(rootDirPath);

		System.out.println("종료");
	}

	private void subDirSearch(String rootDirPath) throws IOException{
		File dirPath = new File(rootDirPath);
		File[] fileList = dirPath.listFiles();
		assert fileList != null;
		for (File file : fileList) {
			if (file.isFile() && new FileSearcher().getFileExt(file,"html")) {
				// 파일이면 코드 검색, 한글(UTF-8) 포함된 라인 출력
				FileReader.getInstance()
						.printHangulCode(rootDirPath,file.getName());
			} else if (file.isDirectory()) {
				System.out.println("디렉토리입니다. 경로 \t:\t " + file.getAbsolutePath());
				// 서브디렉토리 존재하면 재귀 호출
				subDirSearch(file.getAbsolutePath());
			}
		}

	}

	private boolean getFileExt(File file, String extension) {
		String fileName = file.getName();
		return fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())
				.equals(extension);
	}
}

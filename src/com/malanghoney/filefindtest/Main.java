package com.malanghoney.filefindtest;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        String rootDirPath = "C:\\dev-Source\\cafe24FTP\\_\\sde_design\\skin3\\_wg\\import";
        new Main().subDirSearch(rootDirPath);

        System.out.println("종료");
    }

    private void subDirSearch(String rootDirPath) throws IOException{
        File dirPath = new File(rootDirPath);
        File[] fileList = dirPath.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            if (file.isFile()) {
                System.out.println("파일입니다. 파일경로(명) \t:\t " + file.getAbsolutePath());
                // TODO : 파일이면 코드 검색
            } else if (file.isDirectory()) {
                System.out.println("디렉토리입니다. 경로 \t:\t " + file.getAbsolutePath());
                // 서브디렉토리 존재하면 재귀 호출
                subDirSearch(file.getAbsolutePath());
            }
        }

    }
}

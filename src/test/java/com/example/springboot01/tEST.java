package com.example.springboot01;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class tEST {


    public static void main(String[] args) {
        File file1 = new File("D:\\BaiduNetdiskDownload\\推送配置导入模板.xlsx");

        String sss = file1.getAbsolutePath();
        int i = sss.indexOf("\\",4);
        String substring = sss.substring(i+1);
        System.out.println(substring);
    }
}

package com.wpx.jdk.base.jdk7.file;

/**
 * Created by wpx on 2018/4/7.
 */
public class ReadTxtTest {
    public static void main(String[] args) {
        try (ReadTxt rt = new ReadTxt()) {
            String line = rt.readTextValue("D:\\code\\testdoc\\filetest.txt");
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

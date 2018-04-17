package com.wpx.jdk.base.common.jdk7.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by wpx on 2018/4/7.
 * <p>
 * JDK在1.7之后出现了自动关闭类的功能，该功能的出现为各种关闭资源提供了相当大的帮助，
 * 这里我们谈一谈自动关闭类。
 * JDK1.7之后出现了一个重要的接口，以及改造了一个重要的方法结构：
 * 1、AutoCloseable自动关闭接口
 * 2、try(){}--catch{}--finally{}
 * 相应的一些资源也实现了该接口，如preparedStatement、Connection、InputStream、outputStream等等资源接口。
 * 接口的实现类要重写close（）方法，将要关闭的资源定义在try()中，这样当程序执行完毕之后，资源将会自动关闭。
 * 自定义类如果要进行自动关闭，只需要实现AutoCloseable接口重写close（）方法即可，
 * 同时也只有实现了AutoCloseable接口才能将，自定义类放入到try()块中，否则编译不能通过
 */
public class ReadTxt implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("ReadTxt close");
    }

    public static String readTextValue(String path) throws IOException {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int line;
            while ((line = br.read()) != -1) {
                sb.append(br.readLine() + "\n");
            }
        }
        return sb.toString();
    }
}

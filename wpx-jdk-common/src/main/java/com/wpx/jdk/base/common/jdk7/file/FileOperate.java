package com.wpx.jdk.base.common.jdk7.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by wpx on 2018/4/7.
 */
public class FileOperate {
    public static void readFile(String filePath) {
        //Java7之前
        // File file = new File("some_file");
        //使用Java7
        //在File类中加入了新的方法toPath()，可以方便的转换File到Path
        //Path path = new File("some_file").toPath();
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String filePath){
        Path src = Paths.get(filePath);
        try(BufferedWriter writer = Files.newBufferedWriter(src, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            writer.write("\nhello word Path");

        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\code\\testdoc\\filetest.txt";
        FileOperate.readFile(filePath);
        FileOperate.writeFile(filePath);
        FileOperate.readFile(filePath);

    }

}

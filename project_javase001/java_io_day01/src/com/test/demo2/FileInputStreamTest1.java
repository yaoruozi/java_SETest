package com.test.demo2;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
/**
 * 字节流：按照字节一个一个往后读取或者往文件写入，性能比较低
 *
 * */
public class FileInputStreamTest1 {
    File file = new File("D:\\baidu\\hello.txt");

    @Test
    public void test1() throws IOException {
        //向文件中写入一段内容
        OutputStream output = new FileOutputStream(file);
        try {
            String data = "Kobe,I miss you";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }
    }

    @Test
    public void test2() throws IOException {
        //将文件中的内容读取出来并输出
        InputStream input = new FileInputStream(file);
        try {
            byte[] buf = new byte[1024];
            int bufread = input.read(buf);
            String data = new String(buf, 0, bufread, "UTF-8");
            System.out.println(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }

    }

    @Test
    public void test3() throws IOException {
        OutputStream output = new FileOutputStream(file, true);
        try {
            String data = "\n"+"明天是圣诞大战,湖人大战勇士";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            output.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.close();
        }

    }

    @Test
    public void test4() throws IOException{
        InputStream input = new FileInputStream(file);
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int byteRead = 0;
            while ((byteRead = input.read(buf))!=-1){
                output.write(buf,0,byteRead);
            }
            String data = output.toString("UTF-8");
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }


}

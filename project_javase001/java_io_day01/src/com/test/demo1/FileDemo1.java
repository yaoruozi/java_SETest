package com.test.demo1;

import org.junit.Test;

public class FileDemo1 {

    @Test
    public void test1() {
        /**
         * 返回Java工作空间目录
         * */
        String path = System.getProperty("user.dir");
        System.out.println(path);
    }

}

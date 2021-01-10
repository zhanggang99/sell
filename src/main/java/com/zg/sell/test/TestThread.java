package com.zg.sell.test;

public class TestThread {
    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("你好");
        String str=(String)threadLocal.get();
        System.out.println(str);

    }

}

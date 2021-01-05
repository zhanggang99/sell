package com.zg.sell.test;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.ForkJoinPool;

public class TestParallelStream {
    public static void main(String[] args) throws InterruptedException {
        Lists.newArrayList("1", "2", "3", "4").parallelStream().forEach(System.out::println);

        //线程安全问题
        //List<Integer> intList = Lists.newArrayList();
        //List<String> strList = Lists.newArrayList();
        Vector<Integer> intVector = new Vector<>();
        Vector<String> strList = new Vector<>();
        int practicalSize = 100;

        for (int i = 0; i < practicalSize; i++) {
            strList.add(String.valueOf(i));
        }

        strList.parallelStream().forEach(each -> {
            //intList.add(Integer.parseInt(each));
            intVector.add(Integer.parseInt(each));
        });

        System.out.println("  >>> integerList 预计长度 :: " + practicalSize);
        //System.out.println("  >>> integerList 实际长度 :: "+intList.size());
        System.out.println("  >>> integerList 实际长度 :: " + intVector.size());


        System.out.println("CPU 并行处理线程数" + Runtime.getRuntime().availableProcessors());
        System.out.println("并行流公共线程池内线程数" + ForkJoinPool.commonPool().getParallelism());
        List<String> list1 = Lists.newArrayList();
        List<String> list2 = Lists.newArrayList();
        for (int i=0;i<13;i++)list1.add(String.valueOf(i));
        for (int i=0;i<3;i++)list2.add(String.valueOf(i));

        new Thread(()->{
            list1.parallelStream().forEach(each->{
                System.out.println(Thread.currentThread().getName()+"开始执行::"+each);
                try {
                    Thread.sleep(6000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        },"子线程-1").start();
        Thread.sleep(1500);
        new Thread(()->{
            list2.parallelStream().forEach(each->{
                System.out.println(Thread.currentThread().getName()+"开始执行：："+each);
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        },"子线程-2").start();
    }
}

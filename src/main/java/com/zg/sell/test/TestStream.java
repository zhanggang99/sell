package com.zg.sell.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        //通过Arrays的静态方法来进行流的创建
        String[] strArrays={"张刚","张廷","奇奇","妙妙"};
        Arrays.stream(strArrays).forEach(System.out::println);
        Stream.of(strArrays).forEach(System.out::println);
        List<String> strList = Arrays.asList("1","2","3");
        strList.stream().forEach(System.out::println);

        Stream.iterate(1,each -> each+2).limit(5).collect(Collectors.toList()).forEach(System.out::println);
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        //流的处理顺序
        Stream.of("龙台","百凯","四马","儿郎","英雄").filter(each->{
            System.out.println("filter:"+each);
            return each.startsWith("英");
        }).map(each->{
            System.out.println("map:"+each);
            return each;
        }).forEach(each-> System.out.println("foreach:"+each));

        //数据处理、转换：一个流在被创建后，可以被多个数据处理、转换操作，全部操作之后返回给终端操作的是一个新的流
        //流的映射 map/flatMap


    }
}


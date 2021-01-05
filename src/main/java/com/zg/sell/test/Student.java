package com.zg.sell.test;

import jdk.nashorn.internal.runtime.options.Option;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class Student {
    private String num,name,area;

    public Student(String num, String name, String area) {
        this.num = num;
        this.name = name;
        this.area = area;
    }

    public static void main(String[] args) {
        List<Student> studentList= Arrays.asList(new Student("004","zg","st"),new Student("001","zt","tj"),new Student("003","qq","bj"),new Student("001","mm","bj"));
        List<String> nameList = studentList.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList.toString());

        //在这里先说明下 map 和 flatMap 的区别
        //flatmap 可以将一个二维的集合映射成一个一维，相当于他映射的深度比 map 深了一层.
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> collect = inputStream.flatMap(each->each.stream()).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //流的过滤 filter  使用 filter 进行数据筛选，挑选出符合程序要求的元素
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8);
        integerList.stream().filter(each->each>6).forEach(System.out::println);

        //流的去重 distinct
        List<String> stringList = Arrays.asList("狂妄", "偏执", "英雄", "偏执");
        stringList.stream().distinct().forEach(System.out::println);

        //流的排序 sorted
        //Stream 中对于排序使用的是 sorted 对比与普通的集合、数组排序，Stream 的排序更会有优势，可以通过链式调用过滤、去重等方法筛选出结果数据流再进行排序，会更方便一些
        List<Student> students = studentList.stream().sorted((s1,s2)->s1.getNum().compareTo(s2.getNum())).collect(Collectors.toList());
        students.forEach(each-> System.out.println(each.toString()));

        //执行流 peek  为什么要叫 peek 为执行流呢，之前我也是分不清这个有什么用，看了下他的接受参数就明白了
        //Stream<T> peek(Consumer<? super T> action);
        //peek 入参是一个 Consumer 所以只会执行消费，而不会像 map 一样将执行后的内容返回
        //那与 forEach 的不同点在于 一个为 中间操作 一个为 终端操作

        Stream.of("one", "two", "three", "four")
                .filter(each -> each.length() > 3)
                .peek(each -> System.out.println("peek:" + each))
                .map(each -> "map:" + each)
                .forEach(System.out::println);

        //截取和刨除 limit / skip
        List<Integer> integerList1 = Arrays.asList(1,2,3,4,5,6);
        integerList1.stream().limit(3).forEach(System.out::println);
        integerList1.stream().skip(3).forEach(System.out::println);

        //流的终端操作
        //当流使用了终端操作之后，那么这个流的生命周期即为结束，如果再进行调用会编译异常或报错处理。在终端操作中会是对流的遍历操作
        //流的分组聚合 groupingBy / partitioningBy  流的聚合 groupingBy 和 mysql 数据库中的 Group By 原理基本一致

        Map<String,List<Student>> stuGroup = studentList.stream().collect(Collectors.groupingBy(each->each.getArea()));
        stuGroup.forEach((key,val)-> System.out.println(key+":"+val.toString()));
//        st:[Student(num=004, name=zg, area=st)]
//        tj:[Student(num=001, name=zt, area=tj)]
//        bj:[Student(num=003, name=qq, area=bj), Student(num=001, name=mm, area=bj)]

        //而 partitioningBy 则和普通 Group By 显的有一丝不一致。详情查看代码
        //可以看的到 在进行分组时，返回参数的 key 为 Boolean 类型，在执行 partitioningBy 时，如果地区为 “山东”则为 True
        Map<Boolean,List<Student>> stuPartition = studentList.stream().collect(Collectors.partitioningBy(each-> Objects.equals(each.getArea(),"st")));
        System.out.println("结果为true:"+stuPartition.get(true));
        System.out.println("结果为false:"+stuPartition.get(false));
        //结果为true:[Student(num=004, name=zg, area=st)]
        //结果为false:[Student(num=001, name=zt, area=tj), Student(num=003, name=qq, area=bj), Student(num=001, name=mm, area=bj)]

        //流的循环 forEach
        //forEach 接受一个 Consumer 类型的消费函数 无返回，其实就是之前写的 for、forEach 循环
        //void forEach(Consumer<? super T> action);

        //流的汇总 collect
        //一般而言，我们在使用 Stream 的 collect 方法时都是将流元素 转换为指定类型的集合
        List<Integer> integerList3 = Arrays.asList(1,2,3,4,5).stream()
                .collect(Collectors.toList());
        System.out.println(integerList3.toString());

        //流数据的获取 findFirst  findFirst 通过API名称可以看出：获取的是流的第一个元素，返回值是一个 Optional
        Optional<String> first=Arrays.asList("zt","zg","qq","mm").stream().findFirst();
        System.out.println(first.orElse("kong"));

        //流的匹配 anyMatch / allMatch / noneMatch
        //anyMatch 任何一个元素匹配，返回 true
        Boolean flag = Arrays.asList(1,2,3,4,5).stream().anyMatch(each->each>3);
        System.out.println(flag);
        //allMatch 所有元素匹配，返回 true
        flag = Arrays.asList(1,2,3,4,5).stream().allMatch(each->each>3);
        System.out.println(flag);
        //noneMatch 没有一个元素匹配，返回 true
        flag = Arrays.asList(1,2,3,4,5).stream().noneMatch(i->i>10);
        System.out.println(flag);


        //流的规约操作
        //流统计 summaryStatistics
        //流的统计这个功能在进行集合数据统计上来说是非常有用的，可以求平均值、最大值、最小值、个数、数据和
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6);
        IntSummaryStatistics intSummaryStatistics = ints.stream().mapToInt(e->e).summaryStatistics();
        System.out.println("max:"+intSummaryStatistics.getMax()+":sum:"+intSummaryStatistics.getSum());


    }
}

package com.bt.test.features.java8;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamadaTest {

    public static void main(String[] strings) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 直接打印
//        list.forEach(System.out::println);
        list.forEach(i -> {
                    System.out.println(i);
                }
        );
    }

    @Test
    public void test15() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> ((String) str).startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> ((String) str).endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> ((String) str).length() > 4);

    }

    public static void filter(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    /**
     * Predicate接口中的 and, or, xor的使用
     */
    @Test
    public void test16() {
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLength = (n) -> n.length() == 4;

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        languages.stream().filter(startWithJ.and(fourLength))
                .forEach(System.out::println);
    }

    /**
     * map, 允许将对象进行转换, 比如, 可以更改list中的每个元素的值
     */
    @Test
    public void test14() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 可改变对象
        list.stream().map((i) -> i * 3).forEach(System.out::println);

        // 不可改变元有对象
        list.forEach(i -> i = i * 3);
        list.forEach(System.out::println);
    }

    /**
     * 只在本次调用中有效, 并不会改变原有的list
     * <p>
     * 5.2, flatmap
     */
    @Test
    public void test11() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
    }

    /**
     * 6, reduce, 用来将值进行合并, 又称折叠操作, Map和Reduce操作是函数式编程的核心操作
     * SQL中类似 sum()、avg() 或者 count() 的聚集函数，实际上就是 reduce 操作，因为它们接收多个值并返回一个值。流API定义的 reduceh() 函数可以接受lambda表达式，并对所有值进行合并。IntStream这样的类有类似 average()、count()、sum() 的内建方法来做 reduce 操作，也有mapToLong()、mapToDouble() 方法来做转换
     * <p>
     * 复制代码
     */
    @Test
    public void test17() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer integer = list.stream().map((i) -> i = i * 3)
                .reduce((sum, count) -> sum += count).get();

        System.out.println(integer);
    }

    /**
     * reduce的更多用法
     */
    @Test
    public void test10() {
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }

    /**
     * 7, 通过过滤创建一个string, list
     * 过滤是Java开发者在大规模集合上的一个常用操作，而现在使用lambda表达式和流API过滤大规模数据集合是惊人的简单。流提供了一个 filter() 方法，接受一个 Predicate 对象，即可以传入一个lambda表达式作为过滤逻辑。下面的例子是用lambda表达式过滤Java集合，将帮助理解。
     */
    @Test
    public void test2() {
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb", "ehdc", "jk");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }

    /**
     * 过滤后将获取一个新的列表
     * <p>
     * 8, 对列表的每个元素使用 函数
     */
    @Test
    public void test3() {
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb", "ehdc", "jk");
        String collect = strList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.printf("filtered list : %s %n", collect);
    }

    /**
     * 9, 使用distinct进行去重
     */
    @Test
    public void test5() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        System.out.println("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    /**
     * 10, 计算最值和平均值
     * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，描述流中元素的各种摘要数据。在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
     */
    //获取数字的个数、最小值、最大值、总和以及平均值
    @Test
    public void test1() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }


    /**
     * 实体类Person
     *
     * @author MingChenchen
     */
    public class Person {
        private String name;      //姓名
        private String location;  //地址

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Person:" + name + "," + location;
        }
    }


    //使用String默认的排序规则，比较的是Person的name字段
    Comparator<Person> byName = Comparator.comparing(p -> p.getName());
    //不用写传入参数,传入的用Person来声明
    Comparator<Person> byName2 = Comparator.comparing(Person::getName);

    /**
     * 12, optional 的两种使用方式
     */
    @Test
    public void test8() {
        String str = "abc";
        Optional.ofNullable(str).ifPresent(System.out::println);
    }

    /**
     * 第二种
     */
    @Test
    public void test9() {
        String str = "abc";
        // Java 8
        Optional.ofNullable(str).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }
}

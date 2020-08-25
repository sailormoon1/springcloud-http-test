package com.example.springcloudhttptest.controller;

import com.example.springcloudhttptest.entity.Trader;
import com.example.springcloudhttptest.entity.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//@RestController
@Controller
@RequestMapping("/gmm")
public class TestController {
    @RequestMapping("/get")
    @ResponseBody
    public String get() {
        return "hello-gmm";
    }


    public static void main(String[] args) {
        //将一个数组转换成一个list
        List<String> stringList = Arrays.asList("1", "345", "234", "123", "1.1111", "21");
        //去重
        List<String> distinctStringList = stringList.stream().distinct().collect(Collectors.toList());
        //将长度作为集合返回
        List<Integer> mapStringList = stringList.stream().map(String::length).collect(Collectors.toList());
        //排序
        List<String> sortedStringList = stringList.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
//        stringList.stream().
        Optional<String> fistItem = stringList.stream().filter(item -> item.length() > 2 && item.length() < 4).findFirst();
        Optional<String> anyItem = stringList.stream().filter(item -> item.length() > 2 && item.length() < 4).findAny();
        //过滤掉特定位数的 按照大小递增排序
        stringList.stream().filter(item -> item.length() > 2 && item.length() < 4).sorted(Comparator.comparing(Integer::valueOf)).forEach(item -> System.out.println(item));


        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction>transactions = Arrays.asList(

                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(brian,2011,300),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        System.out.println(stringList);
        System.out.println(distinctStringList);

        System.out.println(mapStringList);
        System.out.println(sortedStringList);
        System.out.println(fistItem);
        System.out.println(anyItem);
        System.out.println("---------------------找出集合中2011年并且按照交易额排序的集合----------------------------------------");
        //找出集合中2011年并且按照交易额排序的集合
        transactions.stream().filter(transaction -> transaction.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()).forEach(item->System.out.println(item));
        System.out.println("---------------------找出交易员都在哪些不同的城市工作过---------------------------------------");
        //找出交易员都在哪些不同的城市工作过
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList()).forEach(item->System.out.println(item));
        System.out.println("---------------------查找所有来自剑桥的交易员，并且按照姓名排序---------------------------------------");
        //查找所有来自剑桥的交易员，并且按照姓名排序
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).sorted(Comparator.comparing(transaction -> transaction.getTrader().getName())).collect(Collectors.toList()).forEach(item->System.out.println(item));
        //返回所有交易员的姓名字符串，安字母顺序排序
        System.out.println("---------------------返回所有交易员的姓名字符串，安字母顺序排序---------------------------------------");
        String names  = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+n2);
        System.out.println(names);
        //有没有在米兰工作的交易员
        System.out.println("有没有在米兰工作的交易员"+transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity())));
        //生活在剑桥的交易员的所有交易额
        transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())).map(Transaction::getValue).forEach(item->System.out.println(item));
        //所有交易中最高的交易额是多少
        Optional<Integer> maxVule = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("所有交易中最高的交易额是:"+maxVule);
        //所有交易中最小的交易额
        Optional<Transaction>  maxTransaction = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        Optional<Transaction>  minTransaction = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println("所有交易中最高的交易额是:"+maxTransaction.get().getValue());
        System.out.println("所有交易中最小的交易额是:"+minTransaction.get().getValue());
        //分组
        Map<Integer,List<Transaction>> yearGroup = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));
        System.out.println("按照年份分组之后："+yearGroup);

    }


    public class StringComparater implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}

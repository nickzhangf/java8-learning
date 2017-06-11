package com.zf;

import com.zf.entity.Apple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by feng zhang on 2017/6/11.
 * 收集器测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CollectorTest
{
    private List<Integer> numbers;
    private List<Apple> apples;

    @Before
    public void init()
    {
        numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight((double) 170);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight((double) 130);
        Apple apple3 = new Apple();
        apple3.setColor("yellow");
        apple3.setWeight((double) 130);
        apples = new ArrayList<Apple>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
    }

    @Test
    public void testCount()
    {
        long c = numbers.stream().count();
        System.out.println(c);
    }

    @Test
    public void testMaxBy()
    {
        Comparator<Apple> appleComparator = Comparator.comparingDouble(Apple::getWeight);
        Optional<Apple> apple = apples.stream().collect(Collectors.maxBy(appleComparator));
        System.out.println(apple.get());
    }

    @Test
    public void testSum()
    {
        double totalAppleWeight = apples.stream().collect(Collectors.summingDouble(Apple::getWeight));
        System.out.println(totalAppleWeight);
    }

    @Test
    public void testSummarizing()
    {
        DoubleSummaryStatistics appleStatistics = apples.stream().collect(Collectors.summarizingDouble
                (Apple::getWeight));
        System.out.println(appleStatistics);
    }

    @Test
    public void testJoining()
    {
        String colors = apples.stream().map(Apple::getColor).collect(Collectors.joining(","));
        System.out.println(colors);
    }
}

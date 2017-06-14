package com.zf;

import com.zf.entity.Apple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by feng zhang on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GroupingByTest
{
    private List<Apple> apples;

    @Before
    public void init()
    {
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight((double) 170);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight((double) 130);
        Apple apple3 = new Apple();
        apple3.setColor("yellow");
        apple3.setWeight((double) 130);
        Apple apple4 = new Apple();
        apple4.setColor("yellow");
        apple4.setWeight((double) 130);
        apples = new ArrayList<Apple>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        apples.add(apple4);
    }

    @Test
    public void testGroupingBy()
    {
        Map<String, List<Apple>> applesByColor = apples.stream()
                .collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(applesByColor);
    }
}

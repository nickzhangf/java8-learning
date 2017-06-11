package com.zf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by feng zhang on 2017/6/11.
 * 测试谓词筛选
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilterTest
{
    private List<Integer> numbers;

    @Before
    public void init()
    {
        numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    }

    @Test
    public void testDistinct()
    {
        numbers.stream().filter(i -> i % 2 == 0).distinct()
                .forEach(System.out::println);
    }

    @Test
    public void testLimit()
    {
        numbers.stream().sorted(Integer::compareTo)
                .limit(4).forEach(System.out::println);
    }

    @Test
    public void testSkip()
    {
        numbers.stream().sorted(Integer::compareTo)
                .skip(4).forEach(System.out::println);
    }
}

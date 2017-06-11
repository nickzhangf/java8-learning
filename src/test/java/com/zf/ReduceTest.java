package com.zf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by feng zhang on 2017/6/11.
 * 测试归并操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReduceTest
{
    private List<Integer> numbers;

    @Before
    public void init()
    {
        numbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    public void testSum()
    {
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void testMax()
    {
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        max.ifPresent(System.out::println);
    }
}

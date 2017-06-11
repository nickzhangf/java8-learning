package com.zf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by feng zhang on 2017/6/11.
 * 测试映射
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapTest
{
    private List<String> words;

    @Before
    public void init()
    {
        words = Arrays.asList("java 8", "lambdas", "in", "action");
    }

    @Test
    public void testMap()
    {
        words.stream().map(String::length).forEach(System.out::println);
    }

    @Test
    public void testFlatMap()
    {
        List<String> uniqueCharacters = words.stream()
                .map(w -> w.split("")).flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }
}
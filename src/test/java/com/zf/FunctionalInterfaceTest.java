package com.zf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by feng zhang on 2017/6/7.
 * 测试函数式接口
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FunctionalInterfaceTest
{
    @Test
    public void testPredicate()
    {
        Predicate<String> predicate = (x) -> x.length() > 3;
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test("hi"));
    }

    @Test
    public void testConsumer()
    {
        Consumer<String> consumer = (s) -> System.out.println(s);
//        consumer.accept("hello");
        Consumer<String> consumer1 = (s) -> System.out.println("after consumer");
        consumer1.andThen(consumer).accept("hello");
    }

    @Test
    public void testFunction()
    {
        Function<String, Integer> function = (a) -> a.length();
        System.out.println(function.apply("hello"));
    }
}

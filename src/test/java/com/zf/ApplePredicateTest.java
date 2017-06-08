package com.zf;

import com.zf.entity.Apple;
import com.zf.service.impl.AppleGreenColorPredicate;
import com.zf.service.impl.AppleHeavyWeightPredicate;
import com.zf.util.ApplePredicateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by feng zhang on 2017/6/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplePredicateTest
{
    private List<Apple> apples;

    @Before
    public void initApples()
    {
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(170);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(130);
        Apple apple3 = new Apple();
        apple3.setColor("yellow");
        apple3.setWeight(130);
        apples = new ArrayList<Apple>();
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
    }

    @Test
    public void testFilterHeavyWeightApples()
    {
        List<Apple> result = ApplePredicateUtils
                .filterApples(apples, new AppleHeavyWeightPredicate());
        System.out.println(result);
    }

    @Test
    public void testGreenColorApples()
    {
        List<Apple> result = ApplePredicateUtils
                .filterApples(apples, new AppleGreenColorPredicate());
        System.out.println(result);
    }

    @Test
    public void testLambdaGreenColorApples()
    {
        List<Apple> result = ApplePredicateUtils
                .filterApples(apples, (Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(result);
    }

    // 使用方法引用进行排序
    @Test
    public void testMethodReferenceSort()
    {
        // 升序
//        apples.sort(Comparator.comparing(Apple::getWeight));
        // 降序
//        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        // 按重量降序排列，重量相同的按颜色升序排列
        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(apples);
    }
}

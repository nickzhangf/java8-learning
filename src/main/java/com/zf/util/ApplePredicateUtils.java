package com.zf.util;

import com.zf.entity.Apple;
import com.zf.service.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng zhang on 2017/6/4.
 */
public class ApplePredicateUtils
{
    public static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate)
    {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

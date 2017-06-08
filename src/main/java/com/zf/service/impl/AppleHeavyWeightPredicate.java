package com.zf.service.impl;

import com.zf.entity.Apple;
import com.zf.service.ApplePredicate;

/**
 * Created by feng zhang on 2017/6/4.
 */
public class AppleHeavyWeightPredicate implements ApplePredicate
{
    @Override
    public boolean test(Apple apple)
    {
        return apple.getWeight() > 150;
    }
}

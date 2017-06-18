package com.zf;

import com.zf.service.ParallelStreams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by feng zhang on 2017/6/18.
 * 串行流/并行流 性能测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MesureSumPrefTest
{
    /**
     * 测试串行流
     */
    @Test
    public void testSequentialSum()
    {
        System.out.println("Sequential sum done in:" +
                ParallelStreams.measureSumPref(ParallelStreams::sequentialSum, 10_000_000)
        + " msecs");
    }

    /**
     * 测试传统java迭代写法
     */
    @Test
    public void testIterativeSum()
    {
        System.out.println("Iterative sum done in:" +
                ParallelStreams.measureSumPref(ParallelStreams::interativeSum, 10_000_000)
                + " msecs");
    }

    /**
     * 测试传统java迭代写法并行流
     */
    @Test
    public void testParalleSum()
    {
        System.out.println("Paralle sum done in:" +
                ParallelStreams.measureSumPref(ParallelStreams::paralleSum, 10_000_000)
                + " msecs");
    }

    @Test
    public void testRangeSum()
    {
        System.out.println("range sum done in:" +
                ParallelStreams.measureSumPref(ParallelStreams::rangeSum, 10_000_000)
                + " msecs");
    }

    @Test
    public void testParalleRangeSum()
    {
        System.out.println("Paralle range sum done in:" +
                ParallelStreams.measureSumPref(ParallelStreams::paralleRangeSum, 10_000_000)
                + " msecs");
    }
}

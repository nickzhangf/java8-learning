package com.zf.service;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by feng zhang on 2017/6/18.
 * 对连续数求和（测试顺序流和并行流）
 */
public class ParallelStreams
{
    /**
     * 串行流求和
     * @param n
     * @return
     */
    public static long sequentialSum(long n)
    {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    /**
     * 传统java写法
     * @return
     */
    public static long interativeSum(long n)
    {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 并行流
     * @param n
     * @return
     */
    public static long paralleSum(long n)
    {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }

    /**
     * rangeClosed
     * @param n
     * @return
     */
    public static long rangeSum(long n)
    {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }

    /**
     * 并行rangeClosed
     * @param n
     * @return
     */
    public static long paralleRangeSum(long n)
    {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    /**
     * 测试累加器性能
     * @param adder
     * @param n
     * @return
     */
    public static long measureSumPref(Function<Long, Long>adder, long n)
    {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}

package com.zf;

import com.zf.service.AsyncPriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhangf
 * @version V1.0
 * @Description:
 * @date 2017/7/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncPriceServiceTest
{
    @Autowired
    private AsyncPriceService asyncPriceService;

    @Test
    public void getAsyncPrice()
    {
        long start = System.nanoTime();
        Future<Double> futurePrice = asyncPriceService.getPriceAsync("pp");
        long invocationTime = (System.nanoTime() - start)/ 1000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        // do some thing else
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            double price = futurePrice.get();
            System.out.println("Price is " + price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = (System.nanoTime() - start)/ 1000_000;
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}

package com.zf.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author zhangf
 * @version V1.0
 * @Description: 异步API, CompletableFuture实现
 * @date 2017/7/26
 */
@Service
public class AsyncPriceService
{
    public Future<Double> getPriceAsync(String product)
    {
        return CompletableFuture.supplyAsync(() -> calcPrice());
//        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//        new Thread(
//                () -> {
//                    try {
//                        double price = calcPrice();
//                        futurePrice.complete(price);
//                    } catch (Exception e) {
//                        futurePrice.completeExceptionally(e);
//                    }
//                }
//        ).start();
//        return futurePrice;
    }

    public double calcPrice()
    {
        try {
            deleay();
            return Math.random()*100;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void deleay() throws InterruptedException
    {
        Thread.sleep(2000L);
    }
}

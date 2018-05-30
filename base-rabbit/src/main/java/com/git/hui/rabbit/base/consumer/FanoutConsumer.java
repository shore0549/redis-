package com.git.hui.rabbit.base.consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by yihui in 21:34 18/5/27.
 */
public class FanoutConsumer {

    private static final String exchangeName = "fanout.exchange";

    public void msgConsumer(String queueName, String routingKey) {
        try {
            MsgConsumer.consumerMsg(exchangeName, queueName, routingKey);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FanoutConsumer consumer = new FanoutConsumer();
        String[] routingKey = new String[]{"aaa", "bbb"};
        String[] queueNames = new String[]{"qa", "qb"};


        for (int i = 0; i < 2; i++) {
            consumer.msgConsumer(queueNames[i], routingKey[i]);
        }

        Thread.sleep(1000 * 60 * 10);
    }
}

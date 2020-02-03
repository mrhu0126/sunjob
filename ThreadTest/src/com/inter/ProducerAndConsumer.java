package com.inter;

import com.pojo.Phone;
import com.thread.Consumer;
import com.thread.Producer;
import com.thread.Storage;

public class ProducerAndConsumer {

    public static void main(String[] args) {
        Storage<Phone> storage = new Storage<Phone>();

        //开启生产者和消费着线程
        new Thread(new Producer(storage)).start();
        new Thread(new Consumer(storage)).start();
    }
}
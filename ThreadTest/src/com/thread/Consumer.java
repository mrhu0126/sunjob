package com.thread;

import com.pojo.Phone;

public class Consumer implements Runnable {

    private Storage<Phone> storage;
    
    public Consumer(Storage<Phone> storage) {
        this.storage = storage;
    }

    public void run() {
        for(int i = 0;i<20;i++){
            storage.consume();
            try {
                Thread.sleep(10);//每隔100毫秒消费一个
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
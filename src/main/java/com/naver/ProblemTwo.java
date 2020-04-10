package com.naver;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Package com.naver
 * @Description: ${todo}
 * @Author lijiaqi
 * @Date 2020/4/10 15:03
 * @Modified By:
 */
public class ProblemTwo {

    public static class CacheData {

        public CacheData(Object data) {
            this.data = data;
            this.valid = true;
        }

        private Object data;

        private volatile boolean valid;

        private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

        public void processCachedData(String object) {
            lock.readLock().lock();
            if (!valid) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    if (!valid) {
                        data = object;
                        valid = true;
                    }
                    lock.readLock().lock();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.writeLock().unlock();
                }
            }

            try {
                //process data cost time
                Thread.sleep(1000);
                System.out.println("Thread " + Thread.currentThread().getId() + " process data: " + object);
            } catch (InterruptedException e) {
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        final CacheData cacheData = new CacheData("1");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheData.processCachedData("1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                cacheData.processCachedData("2");
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

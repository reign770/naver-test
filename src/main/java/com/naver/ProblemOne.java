package com.naver;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Package com.naver
 * @Description: ${todo}
 * @Author lijiaqi
 * @Date 2020/4/10 15:03
 * @Modified By:
 */
public class ProblemOne {

    public static class Task {

        private String taskName;

        public void Task(String taskName) {
            this.taskName = taskName;
        }

        public String execute() {
            return taskName;
        }

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }
    }

    public static void buildRelationShip(final List<Task> tasks) {

        final Task taskA = tasks.get(0);
        final Task taskB = tasks.get(1);
        final Task taskC = tasks.get(2);
        final Task taskD = tasks.get(3);
        final Task taskE = tasks.get(4);
        final Task taskF = tasks.get(5);
        final Task taskG = tasks.get(6);
        final Task taskH = tasks.get(7);

        final CountDownLatch cdC = new CountDownLatch(1);
        final CountDownLatch cdG = new CountDownLatch(1);
        final CountDownLatch cdA = new CountDownLatch(2);
        final CountDownLatch cdE = new CountDownLatch(2);
        final CountDownLatch cdF = new CountDownLatch(1);
        final CountDownLatch cdH = new CountDownLatch(1);
        final CountDownLatch cdD = new CountDownLatch(1);
        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskA.execute() + ",");
                cdC.countDown();
            }
        });
        final Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdC.await();
                } catch (InterruptedException e) {
                }
                System.out.print(taskB.execute() + ",");
                cdG.countDown();
                cdE.countDown();
            }
        });
        final Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdC.await();
                } catch (InterruptedException e) {
                }
                System.out.print(taskC.execute() + ",");
                cdA.countDown();
            }
        });
        final Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdD.await();
                } catch (InterruptedException e) {
                }
                System.out.print(taskD.execute() + ",");
                cdF.countDown();
            }
        });
        final Thread threadE = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdE.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(taskE.execute() + ",");
                cdF.countDown();
            }
        });
        final Thread threadF = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cdF.await();
                } catch (InterruptedException e) {

                }
                System.out.print(taskF.execute() + ",");
            }
        });
        final Thread threadG = new Thread(new Runnable() {
            @Override
            public void run() {
                cdG.countDown();
                System.out.print(taskG.execute() + ",");
                cdA.countDown();
                cdE.countDown();
            }
        });
        final Thread threadH = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskH.execute() + ",");
                cdC.countDown();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
        threadG.start();
        threadH.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
            threadE.join();
            threadF.join();
            threadG.join();
            threadH.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //TODO:不好意思，没有理解题目的意思
    }
}

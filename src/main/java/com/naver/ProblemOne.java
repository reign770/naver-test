package com.naver;

import java.util.List;

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
        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.print(taskA.execute() + ",");
            }
        });
        final Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskB.execute() + ",");
            }
        });
        final Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskC.execute() + ",");
            }
        });
        final Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskD.execute() + ",");
            }
        });
        final Thread threadE = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskE.execute() + ",");
            }
        });
        final Thread threadF = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskF.execute() + ",");
            }
        });
        final Thread threadG = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskG.execute() + ",");
            }
        });
        final Thread threadH = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print(taskH.execute() + ",");
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
    }

    public static void main(String[] args) {

        //TODO:不好意思，没有理解题目的意思
    }
}

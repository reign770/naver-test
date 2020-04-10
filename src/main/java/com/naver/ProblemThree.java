package com.naver;

/**
 * @Package com.naver
 * @Description: ${todo}
 * @Author lijiaqi
 * @Date 2020/4/10 15:03
 * @Modified By:
 */
public class ProblemThree {

    public static class MyQueue {

        private int[] datas;

        private int index;

        private int maxSize;

        /**
         *
         * @param maxSize
         */
        public MyQueue(int maxSize) {
            this.maxSize = maxSize;
            datas = new int[maxSize];
        }

        /**
         *
         * @param data
         */
        public void push(int data) {
            if (index >= maxSize) {
                throw new RuntimeException("queue over maxsize " + maxSize);
            }
            datas[index++] = data;
        }

        /**
         *
         * @return
         */
        public int pop() {
            if (empty()) {
                throw new RuntimeException("queue is empty");
            }
            int data = datas[0];
            //move array
            for (int i = 0; i < index - 1; i++) {
                datas[i] = datas[i + 1];
            }
            index--;
            return data;
        }

        /**
         *
         * @return
         */
        public int peek() {
            if (empty()) {
                throw new RuntimeException("queue is empty");
            }
            return datas[0];
        }

        /**
         *
         * @return
         */
        public boolean empty() {
            return index == 0;
        }
    }

    public static void main(String[] args) {
        //操作
        MyQueue queue = new MyQueue(10);
        System.out.println("queue empty : " + queue.empty());
        queue.push(3);
        queue.push(2);
        queue.push(1);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(5);
        queue.push(13);
        queue.push(1);
        System.out.println(queue.pop());
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
